// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.util.xmltools;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import oracle.forms.jdapi.*;
import oracle.xml.parser.v2.XMLDocument;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package oracle.forms.util.xmltools:
//            ConverterUtilities

public class Forms2XML
{

    public Forms2XML(JdapiModule jdapimodule)
    {
        m_properties = null;
        m_elements = null;
        m_dumpAll = false;
        m_objectLibraryTabObjectGroupChildren = new Vector();
        m_ParentModuleList = new Vector();
        ConverterUtilities.testJdapi();
        m_module = jdapimodule;
    }

    public Forms2XML(File file)
    {
        m_properties = null;
        m_elements = null;
        m_dumpAll = false;
        m_objectLibraryTabObjectGroupChildren = new Vector();
        m_ParentModuleList = new Vector();
        ConverterUtilities.testJdapi();
        if(m_dumpAll)
            Jdapi.setFailSubclassLoad(true);
        else
            Jdapi.setFailSubclassLoad(false);
        try
        {
            m_module = JdapiModule.openModule(file);
        }
        catch(JdapiException jdapiexception)
        {
            ConverterUtilities.processException(jdapiexception);
            System.exit(1);
        }
    }

    public XMLDocument dumpModule()
    {
        return dumpModule(false);
    }

    private XMLDocument dumpModule(boolean flag)
    {
        m_dumpAll = flag;
        m_xmlDoc = new XMLDocument();
        m_xmlDoc.setEncoding("UTF-8");
        Element element = m_xmlDoc.createElementNS("http://xmlns.oracle.com/Forms", "Module");
        element.setAttribute("version", String.valueOf(Jdapi.getProductVersion()));
        if(flag)
            element.setAttribute("Dump", "All");
        m_currElem = element;
        dumpObject(m_module, 0);
        moveObjectGroupsLast(element);
        m_xmlDoc.appendChild(element);
        m_module.destroy();
        if(m_dumpAll && !m_ParentModuleList.isEmpty())
        {
            for(int i = 0; i < m_ParentModuleList.size(); i++)
            {
                String s = (String)m_ParentModuleList.get(i);
                element.setAttribute("xmlns:" + s, "http://xmlns.oracle.com/Forms");
            }

        }
        return m_xmlDoc;
    }

    private void moveObjectGroupsLast(Element element)
    {
        boolean flag = false;
        Object obj = null;
        Object obj1 = null;
        Node node2 = element.getFirstChild();
        Object obj2 = null;
        if(node2.getNodeName().equals("PlsqlModule") || node2.getNodeName().equals("ObjectLibrary"))
            return;
        for(Node node3 = node2.getFirstChild(); node3 != null && !flag;)
            if(node3.getNodeName().equals("ObjectGroup"))
            {
                Node node4 = node3.getNextSibling();
                Node node1 = node3.getParentNode();
                Node node = node1.removeChild(node3);
                node1.appendChild(node);
                node3 = node4;
                if(node3 == null || !node3.getNodeName().equals("ObjectGroup"))
                    flag = true;
            } else
            {
                node3 = node3.getNextSibling();
            }

    }

    private void dumpObject(JdapiObject jdapiobject, int i)
    {
        String s = jdapiobject.getClassName();
        int j = jdapiobject.getTypeId();
        boolean flag = false;
        if(j == JdapiTypes.TRIGGER_OTID && jdapiobject.getBooleanProperty(JdapiTypes.HIDE_PTID))
            flag = true;
        if(j == JdapiTypes.VISUAL_STATE_OTID && !s_visualState.booleanValue())
            flag = true;
        if(!flag)
        {
            Element element = m_xmlDoc.createElementNS("http://xmlns.oracle.com/Forms", s);
            Element element1 = m_currElem;
            m_currElem = element;
            try
            {
                m_properties = new HashMap();
                m_elements = new HashMap();
                dumpProperties(jdapiobject, "String");
                dumpProperties(jdapiobject, "Integer");
                dumpProperties(jdapiobject, "Boolean");
                if(j == JdapiTypes.PROPERTY_CLASS_OTID)
                    dumpPropertyClass((PropertyClass)jdapiobject);
                else
                if(j == JdapiTypes.ITEM_OTID)
                {
                    if(((Item)jdapiobject).getItemType() == JdapiTypes.ITTY_LS_CTID)
                        dumpListItem((Item)jdapiobject);
                } else
                if(j == JdapiTypes.RECORDGROUP_COLUMNSPECIFICATION_OTID)
                    dumpRecordGroupColumn((RecordGroupColumn)jdapiobject);
                else
                if(j == JdapiTypes.OBJECTGROUP_CHILD_OTID)
                    dumpObjectGroupChild((ObjectGroupChild)jdapiobject);
                else
                if(j == JdapiTypes.MENU_MODULE_OTID)
                    dumpMenuModule((MenuModule)jdapiobject);
                else
                if(j == JdapiTypes.MENU_ITEM_OTID)
                    dumpMenuItem((MenuItem)jdapiobject);
                else
                if(j == JdapiTypes.GRAPHIC_OTID)
                {
                    if(((Graphics)jdapiobject).getGraphicsType() == JdapiTypes.GRTY_IMAGE_CTID)
                        dumpGraphicsImage((Graphics)jdapiobject);
                } else
                if(j == JdapiTypes.DATA_SOURCE_ARGUMENT_OTID || j == JdapiTypes.DATA_SOURCE_COLUMN_OTID)
                    dumpDataSourceObject(jdapiobject, i);
                if(m_properties.containsKey(new Integer(JdapiTypes.NAME_PTID)))
                {
                    Integer integer = new Integer(JdapiTypes.NAME_PTID);
                    Vector vector = (Vector)m_properties.get(integer);
                    addProperty(vector, integer);
                }
                for(Iterator iterator = m_properties.keySet().iterator(); iterator.hasNext();)
                {
                    Integer integer1 = (Integer)iterator.next();
                    if(integer1.intValue() != JdapiTypes.NAME_PTID)
                    {
                        Vector vector1 = (Vector)m_properties.get(integer1);
                        addProperty(vector1, integer1);
                    }
                }

            }
            catch(Exception exception)
            {
                ConverterUtilities.processException(exception);
                System.exit(1);
            }
            Element element2;
            for(Iterator iterator1 = m_elements.keySet().iterator(); iterator1.hasNext(); m_currElem.appendChild(element2))
            {
                Integer integer2 = (Integer)iterator1.next();
                Vector vector2 = (Vector)m_elements.get(integer2);
                element2 = m_xmlDoc.createElementNS("http://xmlns.oracle.com/Forms", (String)vector2.elementAt(0));
                element2.setAttribute("Index", String.valueOf(integer2));
                String s1 = (String)vector2.elementAt(1);
                String s2 = (String)vector2.elementAt(0);
                if(s2.equals("ListItemElement"))
                    element2.setAttribute("Name", s1);
                else
                if(!s1.equals(""))
                    element2.setAttribute("Name", s1);
                element2.setAttribute("Value", (String)vector2.elementAt(2));
            }

            if(j == JdapiTypes.FORM_MODULE_OTID)
                dumpObject(((JdapiObject) (new Coordinate((FormModule)jdapiobject))), JdapiTypes.COORDINATE_OTID);
            dumpChildObjects(jdapiobject);
            if(jdapiobject instanceof ObjectLibrary)
            {
                JdapiObject jdapiobject1;
                for(Iterator iterator2 = m_objectLibraryTabObjectGroupChildren.iterator(); iterator2.hasNext(); dumpObject(jdapiobject1, i))
                {
                    jdapiobject1 = (JdapiObject)iterator2.next();
                    i = ConverterUtilities.getObjectPropertyId(jdapiobject1.getClassName());
                }

            }
            m_currElem = element1;
            m_currElem.appendChild(element);
        }
    }

    private void dumpChildObjects(JdapiObject jdapiobject)
    {
        JdapiMetaObject jdapimetaobject = JdapiMetadata.getJdapiMetaObject(jdapiobject.getClass());
        for(JdapiIterator jdapiiterator = jdapimetaobject.getChildObjectMetaProperties(); jdapiiterator.hasNext();)
        {
            JdapiMetaProperty jdapimetaproperty = (JdapiMetaProperty)jdapiiterator.next();
            int i = jdapimetaproperty.getPropertyId();
            try
            {
                if(i == JdapiTypes.JDAPI_OLT_OBJECTS_PTID || jdapiobject.hasOverriddenProperty(i))
                {
                    JdapiIterator jdapiiterator1 = jdapiobject.getChildObjectProperty(i);
                    if(jdapiiterator1 != null)
                    {
                        JdapiObject jdapiobject1;
                        for(; jdapiiterator1.hasNext(); dumpObject(jdapiobject1, i))
                            jdapiobject1 = (JdapiObject)jdapiiterator1.next();

                    }
                }
            }
            catch(Exception exception)
            {
                ConverterUtilities.processException(exception);
            }
        }

    }

    private void dumpProperties(JdapiObject jdapiobject, String s)
        throws InvocationTargetException, NoSuchMethodException, IllegalAccessException
    {
        JdapiMetaObject jdapimetaobject = JdapiMetadata.getJdapiMetaObject(jdapiobject.getClass());
        Method method = (oracle.forms.jdapi.JdapiMetaObject.class).getMethod("get" + s + "MetaProperties", null);
        for(JdapiIterator jdapiiterator = (JdapiIterator)method.invoke(jdapimetaobject, null); jdapiiterator.hasNext();)
        {
            JdapiMetaProperty jdapimetaproperty = (JdapiMetaProperty)jdapiiterator.next();
            int i = jdapimetaproperty.getPropertyId();
            if(jdapiobject.hasProperty(i) && (i != JdapiTypes.LIST_ELEMENT_COUNT_PTID && i != JdapiTypes.COLUMN_VALUES_COUNT_PTID && i != JdapiTypes.ROLE_COUNT_PTID || jdapiobject.getPropertyState(i) != 3 || jdapiobject.getIntegerProperty(i) != 0) && (i != JdapiTypes.MENU_ITEM_CODE_PTID || jdapiobject.getIntegerProperty(JdapiTypes.MENU_ITEM_TYPE_PTID) != 3 && jdapiobject.getIntegerProperty(JdapiTypes.COMMAND_TYPE_PTID) == 2))
            {
                int j = jdapiobject.getPropertyState(i);
                try
                {
                    if(jdapiobject.hasOverriddenProperty(i))
                    {
                        if(m_dumpAll && !(jdapiobject instanceof Coordinate))
                        {
                            String s1 = jdapiobject.getModule().getName();
                            s1 = jdapiobject.getModule().getName();
                            if(j == 4)
                                s1 = s1 + "_inherited_overridden";
                            else
                            if(j == 2)
                                s1 = s1 + "_overridden";
                            dumpProperty(jdapiobject, i, s, s1 + ":");
                            addToParentModuleList(s1);
                        } else
                        {
                            dumpProperty(jdapiobject, i, s, "");
                        }
                    } else
                    if(m_dumpAll && !ConverterUtilities.isSubclassProperty(i))
                        if(jdapiobject.hasInheritedProperty(i))
                        {
                            JdapiObject jdapiobject1 = ConverterUtilities.getParentObject(jdapiobject, i);
                            String s3;
                            if(jdapiobject1 == null)
                                s3 = "UNKNOWN";
                            else
                                s3 = jdapiobject1.getModule().getName();
                            if(j == 3)
                                s3 = s3 + "_inherited";
                            dumpProperty(jdapiobject, i, s, s3 + ":");
                            addToParentModuleList(s3);
                        } else
                        if(jdapiobject.hasDefaultedProperty(i))
                        {
                            String s2 = jdapiobject.getModule().getName();
                            if(j == 1)
                                s2 = s2 + "_default";
                            dumpProperty(jdapiobject, i, s, s2 + ":");
                            addToParentModuleList(s2);
                        }
                }
                catch(Exception exception)
                {
                    ConverterUtilities.printResourceMessage("prop_read", new Object[] {
                        JdapiMetaProperty.getPropertyName(i), jdapiobject.getName()
                    });
                }
            }
        }

        if(!(jdapiobject instanceof ObjectLibrary) && !(jdapiobject instanceof ObjectLibraryTab) && (jdapiobject.getModule() instanceof ObjectLibrary) && s.equals("Boolean") && ((ObjectLibrary)jdapiobject.getModule()).isSmartClass(jdapiobject))
        {
            Vector vector = new Vector(3);
            vector.add(s);
            vector.add("SmartClass");
            vector.add("true");
            m_properties.put(new Integer(ConverterUtilities.SMARTCLASS_PTID), vector);
        }
    }

    private void dumpProperty(JdapiObject jdapiobject, int i, String s, String s1)
        throws InvocationTargetException, NoSuchMethodException, IllegalAccessException
    {
        String s2 = JdapiMetaProperty.getPropertyName(i);
        if(s2 == null || s2.equals(""))
            s2 = "NAMING_ERROR_" + i;
        else
            s2 = s1 + s2;
        try
        {
            Method method = (oracle.forms.jdapi.JdapiObject.class).getMethod("get" + s + "Property", new Class[] {
                Integer.TYPE
            });
            Object obj = method.invoke(jdapiobject, new Object[] {
                new Integer(i)
            });
            boolean flag = true;
            if((i == JdapiTypes.SUBCLASS_SUBOBJECT_PTID || i == JdapiTypes.SUBCLASS_OBJECTGROUP_PTID) && !((Boolean)obj).booleanValue())
                flag = false;
            if(flag)
            {
                if(s.equals("Integer"))
                {
                    int ai[] = JdapiMetaProperty.getAllowedValues(i);
                    if(ai != null)
                        try
                        {
                            if(!m_usePropertyIds)
                                obj = JdapiMetaProperty.getPropertyValueName(i, ((Integer)obj).intValue());
                        }
                        catch(JdapiException jdapiexception1)
                        {
                            ConverterUtilities.printResourceMessage("prop_value_name", new Object[] {
                                obj, s2, jdapiobject.getName()
                            });
                        }
                }
                Vector vector = new Vector(3);
                vector.add(s);
                vector.add(s2);
                vector.add(obj);
                m_properties.put(new Integer(i), vector);
            }
        }
        catch(JdapiException jdapiexception)
        {
            ConverterUtilities.printResourceMessage("prop_read", new Object[] {
                s2, jdapiobject.getName()
            });
        }
    }

    private void dumpSubclassProperties(JdapiObject jdapiobject)
        throws InvocationTargetException, NoSuchMethodException, IllegalAccessException
    {
        for(Iterator iterator = ConverterUtilities.getSubclassPropertyIds(); iterator.hasNext();)
        {
            Integer integer = (Integer)iterator.next();
            JdapiMetaProperty jdapimetaproperty = jdapiobject.getJdapiMetaObject().getMetaProperty(integer.intValue());
            if(!m_properties.containsKey(integer) && jdapimetaproperty != null)
                dumpProperty(jdapiobject, integer.intValue(), ConverterUtilities.getSubclassPropertyType(integer), "");
        }

    }

    private void dumpPropertyClass(PropertyClass propertyclass)
        throws InvocationTargetException, NoSuchMethodException, IllegalAccessException
    {
        for(int i = 1; i <= JdapiTypes.MAXIMUM_PTID; i++)
            if(propertyclass.hasProperty(i) && propertyclass.hasOverriddenProperty(i) && !JdapiMetaProperty.getPropertyConstantName(i).endsWith("STRID"))
            {
                Class class1 = JdapiMetaProperty.getPropertyType(i);
                if((java.lang.String.class).equals(class1))
                    dumpProperty(propertyclass, i, "String", "");
                else
                if((java.lang.Integer.class).equals(class1))
                    dumpProperty(propertyclass, i, "Integer", "");
                else
                if((java.lang.Boolean.class).equals(class1))
                    dumpProperty(propertyclass, i, "Boolean", "");
            }

    }

    private void dumpListItem(Item item)
    {
        for(int i = 1; i <= item.getListElementCount(); i++)
        {
            Vector vector = new Vector(3);
            vector.add("ListItemElement");
            String s = item.getElementLabel(i);
            vector.add(s);
            String s1 = item.getElementValue(i);
            vector.add(s1);
            m_elements.put(new Integer(i), vector);
            if(s == null || s.equals("") || s1 == null || s1.equals(""))
                ConverterUtilities.printResourceMessage("list_item_name", new Object[] {
                    item.getName()
                });
        }

    }

    private void dumpRecordGroupColumn(RecordGroupColumn recordgroupcolumn)
    {
        RecordGroup recordgroup = (RecordGroup)recordgroupcolumn.getOwner();
        if(recordgroup.getRecordGroupType() == JdapiTypes.REGR_STATIC_CTID)
        {
            for(int i = 1; i <= recordgroupcolumn.getColumnValuesCount(); i++)
            {
                Vector vector = new Vector(3);
                vector.add("RecordGroupColumnRow");
                vector.add("");
                vector.add(recordgroupcolumn.getRow(i));
                m_elements.put(new Integer(i), vector);
            }

        }
    }

    private void dumpMenuModule(MenuModule menumodule)
    {
        for(int i = 1; i <= menumodule.getRoleCount(); i++)
        {
            Vector vector = new Vector(3);
            vector.add("MenuModuleRole");
            vector.add("");
            vector.add(menumodule.getRole(i));
            m_elements.put(new Integer(i), vector);
        }

    }

    private void dumpMenuItem(MenuItem menuitem)
    {
        for(int i = 1; i <= menuitem.getRoleCount(); i++)
        {
            Vector vector = new Vector(3);
            vector.add("MenuItemRole");
            vector.add("");
            vector.add(menuitem.getRole(i));
            m_elements.put(new Integer(i), vector);
        }

    }

    private void dumpObjectGroupChild(ObjectGroupChild objectgroupchild)
    {
        JdapiObject jdapiobject = objectgroupchild.getObjectGroupChildRealObject();
        if(jdapiobject == null)
        {
            ConverterUtilities.printResourceMessage("ogc_error", new Object[] {
                objectgroupchild.getName()
            });
        } else
        {
            Vector vector = new Vector(3);
            vector.add("String");
            vector.add("Type");
            vector.add(jdapiobject.getClassName());
            m_properties.put(new Integer(JdapiTypes.OBJECT_GROUP_CHILD_REAL_OBJECT_PTID), vector);
        }
        if(m_module instanceof ObjectLibrary)
            m_objectLibraryTabObjectGroupChildren.add(jdapiobject);
    }

    private void dumpGraphicsImage(Graphics g)
    {
        int i = g.getIntegerProperty(JdapiTypes.IMAGE_FORMAT_PTID);
        String s = ConverterUtilities.getImageFileExtension(i);
        String s1 = ConverterUtilities.getQualifiedObjectName(g) + "." + s;
        g.exportImage(s1);
        ConverterUtilities.printResourceMessage("image_saved", new Object[] {
            g.getName(), s1
        });
        Vector vector = new Vector(3);
        vector.add("String");
        vector.add("ImageFilename");
        vector.add(s1);
        m_properties.put(new Integer(ConverterUtilities.IMAGE_FILENAME_PTID), vector);
    }

    private void dumpDataSourceObject(JdapiObject jdapiobject, int i)
    {
        Vector vector = new Vector(3);
        vector.add("String");
        vector.add("Type");
        if(jdapiobject.getTypeId() == JdapiTypes.DATA_SOURCE_ARGUMENT_OTID)
            vector.add(ConverterUtilities.getDataSourceArgumentType(i));
        else
        if(jdapiobject.getTypeId() == JdapiTypes.DATA_SOURCE_COLUMN_OTID)
            vector.add(ConverterUtilities.getDataSourceColumnType(i));
        m_properties.put(new Integer(i), vector);
    }

    private void addProperty(Vector vector, Integer integer)
    {
        String s = (String)vector.elementAt(1);
        Object obj = vector.elementAt(2);
        if(obj instanceof String)
            obj = ConverterUtilities.replaceHtmlCharacters((String)obj);
        m_currElem.setAttribute(s, obj.toString());
    }

    private static void printUsage()
    {
        ConverterUtilities.println();
        ConverterUtilities.printResourceMessage("Forms2XML_usage");
        System.exit(1);
    }

    public static void main(String args[])
    {
        ConverterUtilities.printResourceMessage("Forms2XML");
        ConverterUtilities.printResourceMessage("Copyright");
        HashMap hashmap = ConverterUtilities.processCommandLine(args, new String[] {
            "DUMP"
        }, new String[] {
            "OVERWRITE", "USE_PROPERTY_IDS", "VISUALSTATE"
        });
        if(hashmap == null)
            printUsage();
        Iterator iterator = (Iterator)hashmap.get("args");
        String s = (String)hashmap.get("DUMP");
        boolean flag = false;
        if(s != null && s.equalsIgnoreCase("ALL"))
            flag = true;
        Boolean boolean1 = true ;//(Boolean)hashmap.get("OVERWRITE");
        m_usePropertyIds = ((Boolean)hashmap.get("USE_PROPERTY_IDS")).booleanValue();
        s_visualState = (Boolean)hashmap.get("VISUALSTATE");
        if(!iterator.hasNext())
        {
            ConverterUtilities.printResourceMessage("nothing_to_do");
            printUsage();
        }
        while(iterator.hasNext()) 
        {
            String s1 = (String)iterator.next();
            ConverterUtilities.println();
            File file = new File(s1);
            if(!file.exists())
                ConverterUtilities.printResourceMessage("file_doesnt_exist", new Object[] {
                    s1
                });
            else
            if(!ConverterUtilities.isModule(s1))
            {
                ConverterUtilities.printResourceMessage("not_a_module", new Object[] {
                    s1
                });
            } else
            {
                int i = s1.lastIndexOf('.');
                String s2 = s1.substring(0, i) + "_" + s1.substring(i + 1) + ".xml";
                File file1 = new File(s2);
                if(file1.exists() && !boolean1.booleanValue())
                {
                    ConverterUtilities.printResourceMessage("overwrite", new Object[] {
                        s2
                    });
                } else
                {
                    ConverterUtilities.printResourceMessage("process_module", new Object[] {
                        s1
                    });
                    Forms2XML forms2xml = new Forms2XML(file);
                    Object obj = null;
                    try
                    {
                        XMLDocument xmldocument = forms2xml.dumpModule(flag);
                        try
                        {
                            ConverterUtilities.writeXML(xmldocument, s2);
                            ConverterUtilities.printResourceMessage("xml_module_saved", new Object[] {
                                s2
                            });
                            if(flag)
                                ConverterUtilities.printResourceMessage("xml_dump_warn", new Object[] {
                                    s2
                                });
                        }
                        catch(IOException ioexception)
                        {
                            ConverterUtilities.processException(ioexception);
                        }
                    }
                    catch(Exception exception)
                    {
                        ConverterUtilities.processException(exception);
                    }
                }
            }
        }
    }

    private void addToParentModuleList(String s)
    {
        if(m_ParentModuleList.isEmpty() || !m_ParentModuleList.contains(s))
            m_ParentModuleList.add(s);
    }

    private JdapiModule m_module;
    private XMLDocument m_xmlDoc;
    private Element m_currElem;
    private HashMap m_properties;
    private HashMap m_elements;
    private boolean m_dumpAll;
    private static boolean m_usePropertyIds = false;
    private static Boolean s_visualState;
    private Vector m_objectLibraryTabObjectGroupChildren;
    private Vector m_ParentModuleList;

}
