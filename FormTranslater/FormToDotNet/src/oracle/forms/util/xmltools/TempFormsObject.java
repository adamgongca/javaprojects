// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.util.xmltools;

import java.util.*;
import oracle.forms.jdapi.*;

// Referenced classes of package oracle.forms.util.xmltools:
//            ConverterUtilities

class TempFormsObject
{

    public TempFormsObject(String s, TempFormsObject tempformsobject)
    {
        m_ownedObjects = new Vector();
        m_properties = new HashMap();
        m_extras = new HashMap();
        m_ignored = false;
        m_type = s;
        if(!isModule())
            m_typeId = ConverterUtilities.getObjectPropertyId(s);
        else
            m_typeId = 0;
        m_owner = tempformsobject;
        if(m_owner != null)
            m_owner.addOwnedObject(this);
        try
        {
            m_objectClass = Class.forName("oracle.forms.jdapi." + s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            ConverterUtilities.printResourceMessage("find_class", new Object[] {
                s
            });
        }
    }

    public TempFormsObject(String s, int i, TempFormsObject tempformsobject)
    {
        m_ownedObjects = new Vector();
        m_properties = new HashMap();
        m_extras = new HashMap();
        m_ignored = false;
        m_type = s;
        m_typeId = i;
        m_owner = tempformsobject;
        if(m_owner != null)
            m_owner.addOwnedObject(this);
        try
        {
            m_objectClass = Class.forName("oracle.forms.jdapi." + s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            ConverterUtilities.printResourceMessage("find_class", new Object[] {
                s
            });
        }
    }

    public String getType()
    {
        return m_type;
    }

    public boolean isType(String s)
    {
        return m_type.equals(s);
    }

    public boolean isType(int i)
    {
        return ConverterUtilities.getObjectPropertyId(m_type) == i;
    }

    public int getTypeId()
    {
        return m_typeId;
    }

    public Class getObjectClass()
    {
        return m_objectClass;
    }

    public boolean isModule()
    {
        return m_type.equals("FormModule") || m_type.equals("MenuModule") || m_type.equals("ObjectLibrary");
    }

    public void setProperty(int i, String s, String s1)
    {
        m_properties.put(new Integer(i), new String[] {
            s, s1
        });
    }

    private String[] getProperty(int i)
    {
        return (String[])m_properties.get(new Integer(i));
    }

    public String getPropertyValue(int i)
    {
        String s = null;
        String as[] = getProperty(i);
        if(as != null)
            s = as[1];
        return s;
    }

    public String getPropertyType(int i)
    {
        String s = null;
        String as[] = getProperty(i);
        if(as != null)
            s = as[0];
        return s;
    }

    public void removeProperty(int i)
    {
        m_properties.remove(new Integer(i));
    }

    public void setName(String s)
    {
        setProperty(JdapiTypes.NAME_PTID, "String", s);
    }

    public String getName()
    {
        return getPropertyValue(JdapiTypes.NAME_PTID);
    }

    public HashMap getStringProperties()
    {
        HashMap hashmap = new HashMap();
        for(Iterator iterator = m_properties.keySet().iterator(); iterator.hasNext();)
        {
            Integer integer = (Integer)iterator.next();
            String as[] = (String[])m_properties.get(integer);
            if(!ConverterUtilities.isSubclassProperty(integer) && as[0].equals("String"))
                hashmap.put(integer, as[1]);
        }

        return hashmap;
    }

    public HashMap getBooleanProperties()
    {
        HashMap hashmap = new HashMap();
        for(Iterator iterator = m_properties.keySet().iterator(); iterator.hasNext();)
        {
            Integer integer = (Integer)iterator.next();
            String as[] = (String[])m_properties.get(integer);
            if(!ConverterUtilities.isSubclassProperty(integer) && as[0].equals("Boolean"))
                hashmap.put(integer, Boolean.valueOf(as[1]));
        }

        return hashmap;
    }

    public HashMap getIntegerProperties()
    {
        HashMap hashmap = new HashMap();
        for(Iterator iterator = m_properties.keySet().iterator(); iterator.hasNext();)
        {
            Integer integer = (Integer)iterator.next();
            String as[] = (String[])m_properties.get(integer);
            if(!ConverterUtilities.isSubclassProperty(integer) && as[0].equals("Integer"))
                hashmap.put(integer, Integer.valueOf(as[1]));
        }

        return hashmap;
    }

    public void setExtraProperty(int i, Object obj)
    {
        m_extras.put(new Integer(i), obj);
    }

    public Object getExtraProperty(int i)
    {
        return m_extras.get(new Integer(i));
    }

    public int getNumberOfExtras()
    {
        return m_extras.size();
    }

    public void setRealObject(JdapiObject jdapiobject)
    {
        m_real = jdapiobject;
    }

    public JdapiObject getRealObject()
    {
        return m_real;
    }

    public void setNext(TempFormsObject tempformsobject)
    {
        m_next = tempformsobject;
    }

    public TempFormsObject getNext()
    {
        return m_next != null ? m_next.isIgnored() ? m_next.getNext() : m_next : null;
    }

    public void setPrevious(TempFormsObject tempformsobject)
    {
        m_previous = tempformsobject;
    }

    public TempFormsObject getPrevious()
    {
        return m_previous != null ? m_previous.isIgnored() ? m_previous.getPrevious() : m_previous : null;
    }

    public TempFormsObject getOwner()
    {
        return m_owner;
    }

    public void addOwnedObject(TempFormsObject tempformsobject)
    {
        m_ownedObjects.add(tempformsobject);
    }

    public Iterator getOwnedObjects()
    {
        return m_ownedObjects.iterator();
    }

    public boolean hasOwnedObjects()
    {
        return m_ownedObjects.size() > 0;
    }

    public HashMap getSubclassProperties()
    {
        HashMap hashmap = new HashMap();
        for(Iterator iterator = m_properties.keySet().iterator(); iterator.hasNext();)
        {
            Integer integer = (Integer)iterator.next();
            String as[] = (String[])m_properties.get(integer);
            if(ConverterUtilities.isSubclassProperty(integer))
                hashmap.put(integer, as[1]);
        }

        return hashmap;
    }

    public boolean isSubclassed()
    {
        boolean flag = true;
        if(getParentName() == null || getParentName().equals(""))
            flag = false;
        return flag;
    }

    public boolean isSubObject()
    {
        boolean flag = false;
        String s = getPropertyValue(JdapiTypes.SUBCLASS_SUBOBJECT_PTID);
        if(s != null)
            flag = Boolean.valueOf(s).booleanValue();
        return flag;
    }

    public boolean isObjectGroupSubObject()
    {
        boolean flag = false;
        String s = getPropertyValue(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID);
        if(s != null)
            flag = flag || Boolean.valueOf(s).booleanValue();
        return flag;
    }

    public String getParentName()
    {
        return getPropertyValue(JdapiTypes.PARENT_NAME_PTID);
    }

    public String getParentFileName()
    {
        return getPropertyValue(JdapiTypes.PARENT_FILENAME_PTID);
    }

    public String getParentFilePath()
    {
        return getPropertyValue(JdapiTypes.PARENT_FILEPATH_PTID);
    }

    public String getParentModuleName()
    {
        return getPropertyValue(JdapiTypes.PARENT_MODULE_PTID);
    }

    public String getParentOwnerL1()
    {
        return getPropertyValue(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID);
    }

    public String getParentOwnerL2()
    {
        return getPropertyValue(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_NAME_PTID);
    }

    public String getParentModuleType()
    {
        return getPropertyValue(JdapiTypes.PARENT_MODULETYPE_PTID);
    }

    public String getParentType()
    {
        return getPropertyValue(JdapiTypes.PARENT_TYPE_PTID);
    }

    public String getParentOwnerL1Type()
    {
        return getPropertyValue(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID);
    }

    public String getParentOwnerL2Type()
    {
        return getPropertyValue(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_TYPE_PTID);
    }

    public boolean removeOwnedObject(TempFormsObject tempformsobject)
    {
        return m_ownedObjects.remove(tempformsobject);
    }

    public void destroy()
    {
        if(m_real != null)
            m_real.destroy();
        setIgnored(true);
    }

    public void setIgnored(boolean flag)
    {
        m_ignored = flag;
    }

    public boolean isIgnored()
    {
        return m_ignored;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(getType());
        if(ConverterUtilities.DEBUG)
        {
            stringbuffer.append(getType() + "(" + m_typeId + "): " + getName() + "\n");
            Integer integer;
            String as[];
            for(Iterator iterator = m_properties.keySet().iterator(); iterator.hasNext(); stringbuffer.append(as[0] + "(" + integer + "): " + as[1] + "\n"))
            {
                integer = (Integer)iterator.next();
                as = (String[])m_properties.get(integer);
            }

        } else
        if(getType().equals("DataSourceColumn"))
            stringbuffer.append(": " + getPropertyValue(JdapiTypes.DSC_NAME_PTID));
        else
        if(getType().equals("Coordinate"))
        {
            String s = JdapiMetaProperty.getPropertyValueName(JdapiTypes.COORDINATE_SYSTEM_PTID, Integer.parseInt(getPropertyValue(JdapiTypes.COORDINATE_SYSTEM_PTID)));
            stringbuffer.append(": " + s);
            stringbuffer.append(" " + getPropertyValue(JdapiTypes.CHARACTER_CELL_WIDTH_PTID));
            stringbuffer.append(":" + getPropertyValue(JdapiTypes.CHARACTER_CELL_HEIGHT_PTID));
        } else
        {
            stringbuffer.append(": " + getName());
        }
        return stringbuffer.toString();
    }

    private String m_type;
    private Class m_objectClass;
    private TempFormsObject m_owner;
    private TempFormsObject m_next;
    private TempFormsObject m_previous;
    private JdapiObject m_real;
    private int m_typeId;
    private Vector m_ownedObjects;
    private HashMap m_properties;
    private HashMap m_extras;
    private boolean m_ignored;
}
