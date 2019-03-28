// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.util.xmltools;

import java.io.File;
import java.util.*;
import oracle.forms.jdapi.*;

// Referenced classes of package oracle.forms.util.xmltools:
//            TempFormsObject, ConverterUtilities

class TempFormsObjectTree
{

    public TempFormsObjectTree(boolean flag)
    {
        m_writeTree = true;
        m_parentErrorGiven = false;
        m_indent = new String();
        m_parentlessObjects = new Vector();
        m_parents = new Vector();
        m_formulaItems = new Vector();
        m_objectTree = new Vector();
        m_writeTree = flag;
    }

    public void add(TempFormsObject tempformsobject)
    {
        if(m_objectTree.size() < 1 && !tempformsobject.isModule())
            throw new UnsupportedOperationException("The first element in a TempFormsObjectTree must be a module");
        if(m_objectTree.size() >= 1 && tempformsobject.isModule())
        {
            throw new UnsupportedOperationException("Modules can only be added as the first object in a TempFormsObjectTree");
        } else
        {
            m_objectTree.add(tempformsobject);
            return;
        }
    }

    public JdapiModule processModule()
    {
        TempFormsObject tempformsobject = (TempFormsObject)m_objectTree.elementAt(0);
        processObject(tempformsobject);
        if(tempformsobject.isSubclassed())
        {
            processSubclassProperties(tempformsobject, true);
            processProperties(tempformsobject);
        }
        fixOrdering(tempformsobject);
        processObjectGroups(tempformsobject);
        fixFormulaItems();
        if(m_dummyForm != null)
            m_dummyForm.destroy();
        return m_module;
    }

    private void processObject(TempFormsObject tempformsobject)
    {
        if(m_writeTree)
            ConverterUtilities.println(m_indent + tempformsobject);
        String s = tempformsobject.getParentName();
        if((s == null || s.equals("")) && !tempformsobject.isSubObject() && !tempformsobject.isObjectGroupSubObject())
            createRealObject(tempformsobject, true);
        else
            createSubclassedRealObject(tempformsobject);
        if(tempformsobject.getRealObject() != null)
        {
            String s1 = m_indent;
            if(m_indent.length() != 0)
                m_indent = m_indent.substring(0, m_indent.length() - 1) + " ";
            m_indent += "|-";
            for(Iterator iterator = tempformsobject.getOwnedObjects(); iterator.hasNext();)
            {
                TempFormsObject tempformsobject1 = (TempFormsObject)iterator.next();
                if(!tempformsobject.isType("ObjectLibrary") || tempformsobject1.isType("ObjectLibraryTab"))
                    if(tempformsobject.isType("ObjectLibraryTab") && tempformsobject1.hasOwnedObjects())
                    {
                        processObjectLibraryTabChild(tempformsobject1);
                        Integer integer = new Integer(ConverterUtilities.SMARTCLASS_PTID);
                        if(tempformsobject1.getBooleanProperties().containsKey(integer))
                            ((ObjectLibrary)m_module).setSmartClass(tempformsobject1.getRealObject(), true);
                    } else
                    if(!tempformsobject.isType("Coordinate"))
                        processObject(tempformsobject1);
            }

            m_indent = s1;
            if(m_parents.contains(tempformsobject))
            {
                int i = m_parentlessObjects.size();
                for(int j = 0; j < i; j++)
                {
                    TempFormsObject tempformsobject2 = (TempFormsObject)m_parentlessObjects.elementAt(j);
                    if(tempformsobject.getName().equals(tempformsobject2.getParentName()))
                        processObject(tempformsobject2);
                    i = m_parentlessObjects.size();
                }

            }
            if(tempformsobject.isType("ObjectGroupChild") && (m_module instanceof ObjectLibrary))
            {
                JdapiObject jdapiobject = ConverterUtilities.findObject(tempformsobject.getName(), null, m_dummyForm);
                tempformsobject.getRealObject().setObjectProperty(JdapiTypes.OBJECT_GROUP_CHILD_REAL_OBJECT_PTID, jdapiobject);
            } else
            if(tempformsobject.isType("MenuModule"))
            {
                String s2 = tempformsobject.getPropertyValue(JdapiTypes.MAIN_MENU_PTID);
                if(s2 != null)
                    ((MenuModule)tempformsobject.getRealObject()).setMainMenu(s2);
                else
                    tempformsobject.getRealObject().inheritProperty(JdapiTypes.MAIN_MENU_PTID);
            }
            if(tempformsobject.isType("Item"))
            {
                String s3 = tempformsobject.getPropertyValue(JdapiTypes.CALCULATE_MODE_PTID);
                if(s3 != null)
                {
                    int k = Integer.parseInt(s3);
                    if(k == JdapiTypes.CAMO_FORMULA_CTID)
                        m_formulaItems.add(tempformsobject);
                }
            }
            if(tempformsobject.isType("Graphics"))
            {
                String s4 = tempformsobject.getPropertyValue(JdapiTypes.GRAPHICS_TYPE_PTID);
                if(s4 != null && Integer.parseInt(s4) == JdapiTypes.GRTY_IMAGE_CTID)
                    importGraphicsImage(tempformsobject);
            }
        }
    }

    private void createRealObject(TempFormsObject tempformsobject, boolean flag)
    {
        int i = tempformsobject.getTypeId();
        Object obj = null;
        if(!tempformsobject.isType("Coordinate") && !tempformsobject.isType("ObjectGroupChild") && !tempformsobject.isType("ProgramUnit"))
            obj = findExistingRealObject(tempformsobject);
        if(tempformsobject.isType("LOVColumnMapping"))
        {
            int j = JdapiTypes.COLUMN_MAP_PTID;
            JdapiObject jdapiobject = tempformsobject.getOwner().getRealObject();
            if(jdapiobject.isSubclassed())
            {
                for(JdapiIterator jdapiiterator = jdapiobject.getChildObjectProperty(j); jdapiiterator != null && jdapiiterator.hasNext();)
                {
                    JdapiObject jdapiobject1 = (JdapiObject)jdapiiterator.next();
                    if(!jdapiobject1.getOwner().isSubclassed())
                        jdapiobject1.destroy();
                }

            }
        }
        if(obj == null)
        {
            Class class1 = tempformsobject.getObjectClass();
            String s = tempformsobject.getName();
            if(s == null || s.equals(""))
                s = String.valueOf(i);
            if(tempformsobject.isModule())
            {
                obj = ConverterUtilities.constructObject(class1, new Object[] {
                    s
                });
                m_module = (JdapiModule)obj;
            } else
            if(tempformsobject.isType("Coordinate"))
                obj = new Coordinate((FormModule)m_module);
            else
            if(tempformsobject.isType("AttachedLibrary"))
            {
                String s1 = tempformsobject.getPropertyValue(JdapiTypes.LIBRARY_LOCATION_PTID);
                if(s1 == null || s1.equals(""))
                    s1 = tempformsobject.getName();
                try
                {
                    if(m_module instanceof FormModule)
                        obj = new AttachedLibrary((FormModule)m_module, s1);
                    else
                        obj = new AttachedLibrary((MenuModule)m_module, s1);
                }
                catch(JdapiException jdapiexception)
                {
                    ConverterUtilities.printResourceMessage("attach_lib", new Object[] {
                        tempformsobject.getName()
                    });
                    flag = false;
                }
            } else
            if(tempformsobject.isType("RecordGroupColumn"))
            {
                String s2 = tempformsobject.getOwner().getPropertyValue(JdapiTypes.RECORD_GROUP_TYPE_PTID);
                if(s2 == null || Integer.parseInt(s2) == 0)
                {
                    try
                    {
                        obj = RecordGroupColumn.find((RecordGroup)tempformsobject.getOwner().getRealObject(), s);
                    }
                    catch(JdapiException jdapiexception1)
                    {
                        if(Jdapi.isConnectedToDatabase())
                            ConverterUtilities.printResourceMessage("rgc_error_find", new Object[] {
                                tempformsobject.getName()
                            });
                        else
                            ConverterUtilities.printResourceMessage("rgc_error_db", new Object[] {
                                tempformsobject.getName()
                            });
                    }
                    flag = false;
                } else
                {
                    obj = ConverterUtilities.constructObject(class1, new Object[] {
                        tempformsobject.getOwner().getRealObject(), s
                    });
                }
            } else
            if(tempformsobject.getOwner().isType("ObjectLibraryTab"))
                obj = ConverterUtilities.constructObject(class1, new Object[] {
                    m_module, tempformsobject.getOwner().getRealObject(), s
                });
            else
                obj = ConverterUtilities.constructObject(class1, new Object[] {
                    tempformsobject.getOwner().getRealObject(), s
                });
        }
        tempformsobject.setRealObject(((JdapiObject) (obj)));
        if(flag)
            processProperties(tempformsobject);
        if(tempformsobject.isType("Coordinate"))
            ((Coordinate)obj).apply((FormModule)m_module);
    }

    private void createSubclassedRealObject(TempFormsObject tempformsobject)
    {
        boolean flag = true;
        boolean flag1 = true;
        boolean flag2 = false;
        String s = null;
        if(tempformsobject.isType("ObjectGroupChild"))
            s = tempformsobject.getOwner().getParentModuleName();
        else
            s = tempformsobject.getParentModuleName();
        if(s == null)
            s = "";
        if(tempformsobject.isModule())
            flag2 = s.equalsIgnoreCase(tempformsobject.getName());
        else
            flag2 = s.equalsIgnoreCase(m_module.getName());
        if(tempformsobject.isSubObject())
        {
            if(tempformsobject.getOwner().isSubObject())
                flag2 = flag2 || tempformsobject.getOwner().getOwner().getParentModuleName().equalsIgnoreCase(m_module.getName());
            else
            if(tempformsobject.isSubObject())
                flag2 = flag2 || tempformsobject.getOwner().getParentModuleName().equalsIgnoreCase(m_module.getName());
            JdapiObject jdapiobject = findExistingRealObject(tempformsobject);
            if(jdapiobject == null)
            {
                if(!m_parentErrorGiven)
                {
                    ConverterUtilities.printResourceMessage("parent_error");
                    m_parentErrorGiven = true;
                }
                ConverterUtilities.printResourceMessage("sub_obj_find", new Object[] {
                    tempformsobject.getName(), tempformsobject.getOwner().getName()
                });
                flag = false;
            } else
            {
                tempformsobject.setRealObject(jdapiobject);
                processProperties(tempformsobject);
                flag = false;
            }
        } else
        {
            if(flag2)
                if(tempformsobject.isModule())
                {
                    flag1 = false;
                } else
                {
                    TempFormsObject tempformsobject1 = findParentTempObject(tempformsobject);
                    JdapiObject jdapiobject1 = tempformsobject1.getRealObject();
                    if(jdapiobject1 == null)
                    {
                        m_parentlessObjects.add(tempformsobject);
                        if(m_writeTree)
                            ConverterUtilities.printResourceMessage("cache_obj", new Object[] {
                                tempformsobject, tempformsobject1
                            });
                        m_parents.add(tempformsobject1);
                        flag = false;
                    }
                }
            if(flag)
            {
                createRealObject(tempformsobject, false);
                if(flag1)
                    processSubclassProperties(tempformsobject, flag2);
                processProperties(tempformsobject);
            }
        }
    }

    private void processProperties(TempFormsObject tempformsobject)
    {
        JdapiObject jdapiobject = tempformsobject.getRealObject();
        Integer integer = new Integer(JdapiTypes.TABPAGE_NAME_PTID);
        Integer integer1 = new Integer(JdapiTypes.SCROLLBAR_TABPAGE_NAME_PTID);
        Integer integer2 = new Integer(JdapiTypes.DATA_SOURCE_X_AXIS_PTID);
        Integer integer3 = new Integer(JdapiTypes.DATA_SOURCE_Y_AXIS_PTID);
        Integer integer4 = new Integer(JdapiTypes.SUMMARY_ITEM_NAME_PTID);
        HashMap hashmap = tempformsobject.getStringProperties();
        for(Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext();)
        {
            Integer integer5 = (Integer)iterator.next();
            String s1 = (String)hashmap.get(integer5);
            if(integer5.intValue() != integer.intValue() && integer5.intValue() != integer1.intValue() && integer5.intValue() != integer2.intValue() && integer5.intValue() != integer3.intValue() && integer5.intValue() <= JdapiTypes.MAXIMUM_PTID)
                jdapiobject.setStringProperty(integer5.intValue(), s1);
        }

        String s = (String)hashmap.get(integer2);
        if(s != null)
            jdapiobject.setStringProperty(integer2.intValue(), s);
        String s2 = (String)hashmap.get(integer3);
        if(s2 != null)
            jdapiobject.setStringProperty(integer3.intValue(), s2);
        String s3 = (String)hashmap.get(integer1);
        if(s3 != null)
            jdapiobject.setStringProperty(integer1.intValue(), s3);
        String s4 = (String)hashmap.get(integer);
        if(s4 != null)
            jdapiobject.setStringProperty(integer.intValue(), s4);
        String s5 = (String)hashmap.get(integer4);
        if(s5 != null)
            jdapiobject.setStringProperty(integer4.intValue(), s5);
        HashMap hashmap1 = tempformsobject.getBooleanProperties();
        for(Iterator iterator1 = hashmap1.keySet().iterator(); iterator1.hasNext();)
        {
            Integer integer6 = (Integer)iterator1.next();
            Boolean boolean1 = (Boolean)hashmap1.get(integer6);
            if(integer6.intValue() == ConverterUtilities.SMARTCLASS_PTID)
            {
                if(jdapiobject.getModule() instanceof ObjectLibrary)
                {
                    ObjectLibrary objectlibrary = (ObjectLibrary)jdapiobject.getModule();
                    objectlibrary.setSmartClass(jdapiobject, boolean1.booleanValue());
                }
            } else
            {
                jdapiobject.setBooleanProperty(integer6.intValue(), boolean1.booleanValue());
            }
        }

        HashMap hashmap2 = tempformsobject.getIntegerProperties();
        Integer integer7;
        Integer integer8;
        for(Iterator iterator2 = hashmap2.keySet().iterator(); iterator2.hasNext(); jdapiobject.setIntegerProperty(integer7.intValue(), integer8.intValue()))
        {
            integer7 = (Integer)iterator2.next();
            integer8 = (Integer)hashmap2.get(integer7);
        }

        if(jdapiobject instanceof Item)
        {
            String s6 = tempformsobject.getPropertyValue(integer.intValue());
            if(s6 == null || !s6.equals(""))
            {
                String s7 = jdapiobject.getStringProperty(integer.intValue());
                if(s7 != null && s7.equals(""))
                    jdapiobject.inheritProperty(integer.intValue());
            }
        }
        if(tempformsobject.getNumberOfExtras() > 0)
            processExtraProperties(tempformsobject);
        if((jdapiobject instanceof Trigger) && tempformsobject.isSubclassed() && tempformsobject.getPropertyValue(JdapiTypes.TRIGGER_TEXT_PTID) == null)
            jdapiobject.inheritProperty(JdapiTypes.TRIGGER_TEXT_PTID);
        if((jdapiobject instanceof ProgramUnit) && tempformsobject.isSubclassed() && tempformsobject.getPropertyValue(JdapiTypes.PROGRAMUNIT_TEXT_PTID) == null)
            jdapiobject.inheritProperty(JdapiTypes.PROGRAMUNIT_TEXT_PTID);
    }

    private void processSubclassProperties(TempFormsObject tempformsobject, boolean flag)
    {
        JdapiObject jdapiobject = tempformsobject.getRealObject();
        HashMap hashmap = tempformsobject.getSubclassProperties();
        String s = tempformsobject.getParentName();
        String s1 = tempformsobject.getParentFileName();
        String s2 = tempformsobject.getParentFilePath();
        String s3 = tempformsobject.getParentModuleName();
        String s4 = tempformsobject.getParentOwnerL1();
        String s5 = tempformsobject.getParentOwnerL2();
        String s6 = tempformsobject.getParentModuleType();
        String s7 = tempformsobject.getParentType();
        String s8 = tempformsobject.getParentOwnerL1Type();
        String s9 = tempformsobject.getParentOwnerL2Type();
        if(flag)
        {
            TempFormsObject tempformsobject1 = findParentTempObject(tempformsobject);
            jdapiobject.setSubclassParent(tempformsobject1.getRealObject());
        }
        if(!flag)
        {
            if(s != null)
                jdapiobject.setStringProperty(JdapiTypes.PARENT_NAME_PTID, s);
            if(s1 != null)
            {
                jdapiobject.setStringProperty(JdapiTypes.PARENT_FILENAME_PTID, s1);
            } else
            {
                ConverterUtilities.printResourceMessage("db_subclassing", new Object[] {
                    tempformsobject.getName(), tempformsobject.getOwner().getName(), s3
                });
                jdapiobject.setStringProperty(JdapiTypes.PARENT_FILENAME_PTID, s3);
            }
            if(s2 != null)
                jdapiobject.setStringProperty(JdapiTypes.PARENT_FILEPATH_PTID, s2);
            if(s3 != null)
                jdapiobject.setStringProperty(JdapiTypes.PARENT_MODULE_PTID, s3);
            if(s4 != null)
                jdapiobject.setStringProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID, s4);
            if(s5 != null)
                jdapiobject.setStringProperty(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_NAME_PTID, s5);
            if(s6 != null)
                jdapiobject.setIntegerProperty(JdapiTypes.PARENT_MODULETYPE_PTID, Integer.parseInt(s6));
            if(s7 != null)
                jdapiobject.setIntegerProperty(JdapiTypes.PARENT_TYPE_PTID, Integer.parseInt(s7));
            if(s8 != null)
                jdapiobject.setIntegerProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID, Integer.parseInt(s8));
            if(s9 != null)
                jdapiobject.setIntegerProperty(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_TYPE_PTID, Integer.parseInt(s9));
            jdapiobject.reattach();
        }
    }

    private void processExtraProperties(TempFormsObject tempformsobject)
    {
        JdapiObject jdapiobject = tempformsobject.getRealObject();
        int i = jdapiobject.getTypeId();
        for(int j = 1; j <= tempformsobject.getNumberOfExtras(); j++)
            if(i == JdapiTypes.ITEM_OTID)
            {
                String as[] = (String[])tempformsobject.getExtraProperty(j);
                ((Item)jdapiobject).insertElement(j, as[0], as[1]);
            } else
            if(i == JdapiTypes.RECORDGROUP_COLUMNSPECIFICATION_OTID)
                ((RecordGroupColumn)jdapiobject).insertRow(j, (String)tempformsobject.getExtraProperty(j));
            else
            if(i == JdapiTypes.MENU_MODULE_OTID)
                ((MenuModule)jdapiobject).addRole(j, (String)tempformsobject.getExtraProperty(j));
            else
            if(i == JdapiTypes.MENU_ITEM_OTID)
                ((MenuItem)jdapiobject).addRole(j, (String)tempformsobject.getExtraProperty(j));

    }

    private void processObjectGroups(TempFormsObject tempformsobject)
    {
        JdapiModule jdapimodule = (JdapiModule)tempformsobject.getRealObject();
        Object obj = null;
        if((jdapimodule instanceof FormModule) || (jdapimodule instanceof MenuModule))
        {
            for(Iterator iterator = tempformsobject.getOwnedObjects(); iterator != null && iterator.hasNext();)
            {
                TempFormsObject tempformsobject1 = (TempFormsObject)iterator.next();
                if(tempformsobject1.isType("ObjectGroup"))
                {
                    int i;
                    ObjectGroupChild objectgroupchild;
                    for(Iterator iterator1 = tempformsobject1.getOwnedObjects(); iterator1.hasNext(); fixObjectGroupChildRealObject(jdapimodule, objectgroupchild, i))
                    {
                        TempFormsObject tempformsobject2 = (TempFormsObject)iterator1.next();
                        i = tempformsobject2.getTypeId();
                        objectgroupchild = (ObjectGroupChild)tempformsobject2.getRealObject();
                    }

                }
            }

        }
    }

    private void fixObjectGroupChildRealObject(JdapiModule jdapimodule, ObjectGroupChild objectgroupchild, int i)
    {
        String s = objectgroupchild.getStringProperty(JdapiTypes.NAME_PTID);
        JdapiIterator jdapiiterator = jdapimodule.getChildObjectProperty(i);
        boolean flag;
        for(flag = false; jdapiiterator.hasNext() && !flag;)
        {
            JdapiObject jdapiobject = (JdapiObject)jdapiiterator.next();
            if(jdapiobject.getName().equals(s))
            {
                objectgroupchild.setObjectProperty(JdapiTypes.OBJECT_GROUP_CHILD_REAL_OBJECT_PTID, jdapiobject);
                flag = true;
                if(objectgroupchild.isSubclassSubObject())
                {
                    HashMap hashmap = getOverriddenProperties(jdapiobject);
                    jdapiobject.setBooleanProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true);
                    if(hashmap.size() > 0)
                        setOverriddenProperties(jdapiobject, hashmap);
                }
            }
        }

        if(!flag)
            objectgroupchild.destroy();
    }

    private HashMap getOverriddenProperties(JdapiObject jdapiobject)
    {
        HashMap hashmap = new HashMap();
        for(JdapiIterator jdapiiterator = jdapiobject.getMetaProperties(); jdapiiterator.hasNext();)
        {
            JdapiMetaProperty jdapimetaproperty = (JdapiMetaProperty)jdapiiterator.next();
            int i = jdapimetaproperty.getPropertyId();
            if(jdapiobject.hasProperty(i) && jdapiobject.hasOverriddenProperty(i))
                if(JdapiMetaProperty.getPropertyType(i).equals(java.lang.String.class))
                    hashmap.put(new Integer(i), jdapiobject.getStringProperty(i));
                else
                if(JdapiMetaProperty.getPropertyType(i).equals(java.lang.Integer.class))
                    hashmap.put(new Integer(i), new Integer(jdapiobject.getIntegerProperty(i)));
                else
                if(JdapiMetaProperty.getPropertyType(i).equals(java.lang.Boolean.class))
                    hashmap.put(new Integer(i), new Boolean(jdapiobject.getBooleanProperty(i)));
        }

        return hashmap;
    }

    private void setOverriddenProperties(JdapiObject jdapiobject, HashMap hashmap)
    {
        for(Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = iterator.next();
            Object obj1 = hashmap.get(obj);
            if(obj1 instanceof String)
                jdapiobject.setStringProperty(((Integer)obj).intValue(), (String)obj1);
            else
            if(obj1 instanceof Boolean)
                jdapiobject.setBooleanProperty(((Integer)obj).intValue(), ((Boolean)obj1).booleanValue());
            else
            if(obj1 instanceof Integer)
                jdapiobject.setIntegerProperty(((Integer)obj).intValue(), ((Integer)obj1).intValue());
        }

    }

    private void processObjectLibraryTabChild(TempFormsObject tempformsobject)
    {
        if(m_dummyForm == null)
        {
            m_dummyForm = new FormModule("XMLDUMMYFORM");
            Block block = new Block(m_dummyForm, "XMLDUMMYBLOCK");
            Canvas canvas = new Canvas(m_dummyForm, "XMLDUMMYCANVAS");
            TempFormsObject tempformsobject1 = (TempFormsObject)m_objectTree.elementAt(0);
            for(Iterator iterator = tempformsobject1.getOwnedObjects(); iterator.hasNext();)
            {
                TempFormsObject tempformsobject2 = (TempFormsObject)iterator.next();
                if(!tempformsobject2.isType("ObjectLibraryTab"))
                    createDummyOLTChild(tempformsobject2);
            }

        }
        createDummyOLTChild(tempformsobject);
        ObjectLibraryTab objectlibrarytab = (ObjectLibraryTab)tempformsobject.getOwner().getRealObject();
        JdapiObject jdapiobject = objectlibrarytab.addObject(tempformsobject.getRealObject(), false);
        tempformsobject.setRealObject(jdapiobject);
    }

    private void createDummyOLTChild(TempFormsObject tempformsobject)
    {
        Block block = Block.find(m_dummyForm, "XMLDUMMYBLOCK");
        Canvas canvas = Canvas.find(m_dummyForm, "XMLDUMMYCANVAS");
        JdapiObject jdapiobject = null;
        if(tempformsobject.isType("Item"))
            jdapiobject = ConverterUtilities.constructObject(oracle.forms.jdapi.Item.class, new Object[] {
                block, tempformsobject.getName()
            });
        else
        if(tempformsobject.isType("Graphics"))
            jdapiobject = ConverterUtilities.constructObject(oracle.forms.jdapi.Graphics.class, new Object[] {
                canvas, tempformsobject.getName()
            });
        else
            jdapiobject = ConverterUtilities.constructObject(tempformsobject.getObjectClass(), new Object[] {
                m_dummyForm, tempformsobject.getName()
            });
        tempformsobject.setRealObject(jdapiobject);
        processProperties(tempformsobject);
        TempFormsObject tempformsobject1;
        for(Iterator iterator = tempformsobject.getOwnedObjects(); iterator.hasNext(); processObject(tempformsobject1))
            tempformsobject1 = (TempFormsObject)iterator.next();

    }

    private JdapiObject findExistingRealObject(TempFormsObject tempformsobject)
    {
        JdapiObject jdapiobject = null;
        TempFormsObject tempformsobject1 = tempformsobject.getOwner();
        int i = tempformsobject.getTypeId();
        if(tempformsobject.isType("ObjectGroupChild"))
            i = JdapiTypes.OBJECTGROUP_CHILD_PTID;
        if(tempformsobject1 != null)
            jdapiobject = tempformsobject1.getRealObject();
        JdapiObject jdapiobject1 = null;
        if(jdapiobject != null)
        {
            for(JdapiIterator jdapiiterator = jdapiobject.getChildObjectProperty(i); jdapiiterator != null && jdapiiterator.hasNext() && jdapiobject1 == null;)
            {
                JdapiObject jdapiobject2 = (JdapiObject)jdapiiterator.next();
                if(jdapiobject2.getName().equalsIgnoreCase(tempformsobject.getName()))
                    jdapiobject1 = jdapiobject2;
            }

        }
        return jdapiobject1;
    }

    private void fixOrdering(TempFormsObject tempformsobject)
    {
        for(Iterator iterator = tempformsobject.getOwnedObjects(); iterator.hasNext();)
        {
            TempFormsObject tempformsobject1 = (TempFormsObject)iterator.next();
            if(!tempformsobject1.isType("ObjectGroupChild"))
            {
                if(tempformsobject1.getPrevious() == null)
                    checkOrder(tempformsobject1);
                fixOrdering(tempformsobject1);
            }
        }

    }

    private void fixFormulaItems()
    {
        Item item;
        String s;
        for(Iterator iterator = m_formulaItems.iterator(); iterator.hasNext(); item.setFormula(s))
        {
            TempFormsObject tempformsobject = (TempFormsObject)iterator.next();
            item = (Item)tempformsobject.getRealObject();
            s = tempformsobject.getPropertyValue(JdapiTypes.FORMULA_PTID);
        }

    }

    private void importGraphicsImage(TempFormsObject tempformsobject)
    {
        Graphics g = (Graphics)tempformsobject.getRealObject();
        String s = tempformsobject.getPropertyValue(ConverterUtilities.IMAGE_FILENAME_PTID);
        if(s == null)
            s = ConverterUtilities.getQualifiedObjectName(g) + ".tif";
        String s1 = s.substring(s.lastIndexOf('.') + 1);
        File file = new File(s);
        if(file.exists())
        {
            g.importImage(s, ConverterUtilities.getImageFormat(s1));
        } else
        {
            ConverterUtilities.printResourceMessage("missing_image", new Object[] {
                tempformsobject.getName(), s
            });
            tempformsobject.destroy();
        }
    }

    private void checkOrder(TempFormsObject tempformsobject)
    {
        JdapiObject jdapiobject = tempformsobject.getRealObject();
        if(jdapiobject != null)
        {
            JdapiObject jdapiobject1 = jdapiobject.getObjectProperty(JdapiTypes.NEXT_PTID);
            TempFormsObject tempformsobject1 = tempformsobject.getNext();
            if(tempformsobject1 == null)
            {
                if(jdapiobject1 != null)
                {
                    if(m_writeTree)
                        ConverterUtilities.printResourceMessage("move_obj_to_end", new Object[] {
                            tempformsobject
                        });
                    jdapiobject.move(null);
                }
            } else
            {
                JdapiObject jdapiobject2 = tempformsobject1.getRealObject();
                if(jdapiobject2 == null)
                {
                    if(m_writeTree)
                        ConverterUtilities.printResourceMessage("move_obj_to_end", new Object[] {
                            tempformsobject
                        });
                    jdapiobject.move(null);
                } else
                if(!jdapiobject2.equals(jdapiobject1))
                {
                    if(m_writeTree)
                        ConverterUtilities.printResourceMessage("move_obj", new Object[] {
                            tempformsobject1, tempformsobject
                        });
                    jdapiobject2.move(jdapiobject1);
                }
                checkOrder(tempformsobject1);
            }
        }
    }

    private JdapiObject findParentObject(TempFormsObject tempformsobject)
    {
        JdapiObject jdapiobject = null;
        String s = tempformsobject.getParentName();
        String s1 = tempformsobject.getParentOwnerL1();
        String s2 = tempformsobject.getParentOwnerL2();
        if(s2 == null || s2.equals(""))
        {
            if(s1 != null && s1.equals(""))
                s1 = null;
            jdapiobject = ConverterUtilities.findObject(s, s1, m_module);
        } else
        {
            JdapiObject jdapiobject1 = ConverterUtilities.findObject(s2, s1, m_module);
            jdapiobject = ConverterUtilities.findObject(s, null, jdapiobject1);
        }
        return jdapiobject;
    }

    private TempFormsObject findParentTempObject(TempFormsObject tempformsobject)
    {
        TempFormsObject tempformsobject1 = null;
        String s = tempformsobject.getParentName();
        int i = Integer.parseInt(tempformsobject.getParentType());
        String s1 = tempformsobject.getParentOwnerL1();
        String s2 = tempformsobject.getParentOwnerL2();
        if(s2 == null || s2.equals(""))
        {
            if(s1 == null || s1.equals(""))
            {
                if(i == ConverterUtilities.getObjectId(tempformsobject.getType()))
                    tempformsobject1 = findTempObject(tempformsobject.getOwner(), s, i);
                else
                    tempformsobject1 = findTempObject((TempFormsObject)m_objectTree.elementAt(0), s, i);
            } else
            {
                int j = Integer.parseInt(tempformsobject.getParentOwnerL1Type());
                TempFormsObject tempformsobject2 = findTempObject((TempFormsObject)m_objectTree.elementAt(0), s1, j);
                tempformsobject1 = findTempObject(tempformsobject2, s, i);
            }
        } else
        {
            int k = Integer.parseInt(tempformsobject.getParentOwnerL1Type());
            int l = Integer.parseInt(tempformsobject.getParentOwnerL2Type());
            TempFormsObject tempformsobject3 = findTempObject((TempFormsObject)m_objectTree.elementAt(0), s1, k);
            TempFormsObject tempformsobject4 = findTempObject(tempformsobject3, s2, l);
            tempformsobject1 = findTempObject(tempformsobject4, s, i);
        }
        return tempformsobject1;
    }

    private TempFormsObject findTempObject(TempFormsObject tempformsobject, String s, int i)
    {
        TempFormsObject tempformsobject1 = null;
        for(Iterator iterator = tempformsobject.getOwnedObjects(); iterator.hasNext() && tempformsobject1 == null;)
        {
            TempFormsObject tempformsobject2 = (TempFormsObject)iterator.next();
            if(tempformsobject2.getName() != null && tempformsobject2.getName().equals(s) && ConverterUtilities.getObjectId(tempformsobject2.getType()) == i)
                tempformsobject1 = tempformsobject2;
        }

        return tempformsobject1;
    }

    private TempFormsObject findCoordinate()
    {
        TempFormsObject tempformsobject = null;
        for(Iterator iterator = m_objectTree.iterator(); iterator.hasNext();)
        {
            TempFormsObject tempformsobject1 = (TempFormsObject)iterator.next();
            if(tempformsobject1.isType("Coordinate"))
                tempformsobject = tempformsobject1;
        }

        return tempformsobject;
    }

    private boolean m_writeTree;
    private boolean m_parentErrorGiven;
    private String m_indent;
    private Vector m_objectTree;
    private Vector m_parentlessObjects;
    private Vector m_parents;
    private Vector m_formulaItems;
    private JdapiModule m_module;
    private FormModule m_dummyForm;
}
