// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            Item, PropertyClass, Block, FormModule, 
//            ObjectLibrary, ObjectLibraryTab, JdapiObject

public class Trigger extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public Trigger(Item item, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), item.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Trigger(Item item, String s, Trigger trigger)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), item.getObjectPointer(), s_foType, s, 0L, trigger.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Trigger(Item item, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), item.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Trigger(Block block, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), block.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Trigger(Block block, String s, Trigger trigger)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), block.getObjectPointer(), s_foType, s, 0L, trigger.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Trigger(Block block, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), block.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Trigger(PropertyClass propertyclass, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), propertyclass.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Trigger(PropertyClass propertyclass, String s, Trigger trigger)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), propertyclass.getObjectPointer(), s_foType, s, 0L, trigger.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Trigger(PropertyClass propertyclass, String s, PropertyClass propertyclass1)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), propertyclass.getObjectPointer(), s_foType, s, 0L, propertyclass1.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Trigger(FormModule formmodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Trigger(FormModule formmodule, String s, Trigger trigger)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, trigger.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Trigger(FormModule formmodule, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Trigger(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), 0L);
        Jdapi.addObject(this);
    }

    public Trigger(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, Trigger trigger)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), trigger.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Trigger(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected Trigger(long l)
    {
        super(l);
    }

    public Trigger clone(Item item, String s)
    {
        return (Trigger)super.clone(item, s);
    }

    public Trigger clone(Block block, String s)
    {
        return (Trigger)super.clone(block, s);
    }

    public Trigger clone(PropertyClass propertyclass, String s)
    {
        return (Trigger)super.clone(propertyclass, s);
    }

    public Trigger clone(FormModule formmodule, String s)
    {
        return (Trigger)super.clone(formmodule, s);
    }

    public Trigger clone(ObjectLibraryTab objectlibrarytab, String s)
    {
        return (Trigger)super.clone(objectlibrarytab, s);
    }

    public static Trigger find(Item item, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), item.getObjectPointer(), s, s_foType);
        Trigger trigger = null;
        if(l1 != 0L)
            trigger = (Trigger)Jdapi.getObject(l1);
        return trigger;
    }

    public static Trigger find(Block block, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), block.getObjectPointer(), s, s_foType);
        Trigger trigger = null;
        if(l1 != 0L)
            trigger = (Trigger)Jdapi.getObject(l1);
        return trigger;
    }

    public static Trigger find(PropertyClass propertyclass, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), propertyclass.getObjectPointer(), s, s_foType);
        Trigger trigger = null;
        if(l1 != 0L)
            trigger = (Trigger)Jdapi.getObject(l1);
        return trigger;
    }

    public static Trigger find(FormModule formmodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s, s_foType);
        Trigger trigger = null;
        if(l1 != 0L)
            trigger = (Trigger)Jdapi.getObject(l1);
        return trigger;
    }

    public static Trigger find(ObjectLibraryTab objectlibrarytab, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s, s_foType);
        Trigger trigger = null;
        if(l1 != 0L)
            trigger = (Trigger)Jdapi.getObject(l1);
        return trigger;
    }

    public String getComment()
    {
        return getStringProperty(JdapiTypes.COMMENT_PTID);
    }

    public void setComment(String s)
    {
        setStringProperty(JdapiTypes.COMMENT_PTID, s);
    }

    public String getKeyboardHelpText()
    {
        return getStringProperty(JdapiTypes.KEYBOARD_HELP_TEXT_PTID);
    }

    public void setKeyboardHelpText(String s)
    {
        setStringProperty(JdapiTypes.KEYBOARD_HELP_TEXT_PTID, s);
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
    }

    public String getParentFilename()
    {
        return getStringProperty(JdapiTypes.PARENT_FILENAME_PTID);
    }

    public void setParentFilename(String s)
    {
        setStringProperty(JdapiTypes.PARENT_FILENAME_PTID, s);
    }

    public String getParentFilepath()
    {
        return getStringProperty(JdapiTypes.PARENT_FILEPATH_PTID);
    }

    public void setParentFilepath(String s)
    {
        setStringProperty(JdapiTypes.PARENT_FILEPATH_PTID, s);
    }

    public String getParentModule()
    {
        return getStringProperty(JdapiTypes.PARENT_MODULE_PTID);
    }

    public void setParentModule(String s)
    {
        setStringProperty(JdapiTypes.PARENT_MODULE_PTID, s);
    }

    public String getParentName()
    {
        return getStringProperty(JdapiTypes.PARENT_NAME_PTID);
    }

    public void setParentName(String s)
    {
        setStringProperty(JdapiTypes.PARENT_NAME_PTID, s);
    }

    public String getParentSourceLevel1ObjectName()
    {
        return getStringProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID);
    }

    public void setParentSourceLevel1ObjectName(String s)
    {
        setStringProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID, s);
    }

    public String getParentSourceLevel2ObjectName()
    {
        return getStringProperty(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_NAME_PTID);
    }

    public void setParentSourceLevel2ObjectName(String s)
    {
        setStringProperty(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_NAME_PTID, s);
    }

    public String getTriggerText()
    {
        return getStringProperty(JdapiTypes.TRIGGER_TEXT_PTID);
    }

    public void setTriggerText(String s)
    {
        setStringProperty(JdapiTypes.TRIGGER_TEXT_PTID, s);
    }

    public int getExecuteHierarchy()
    {
        return getIntegerProperty(JdapiTypes.EXECUTE_HIERARCHY_PTID);
    }

    public void setExecuteHierarchy(int i)
    {
        setIntegerProperty(JdapiTypes.EXECUTE_HIERARCHY_PTID, i);
    }

    public int getParentModuleType()
    {
        return getIntegerProperty(JdapiTypes.PARENT_MODULETYPE_PTID);
    }

    public void setParentModuleType(int i)
    {
        setIntegerProperty(JdapiTypes.PARENT_MODULETYPE_PTID, i);
    }

    public int getParentSourceLevel1ObjectType()
    {
        return getIntegerProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID);
    }

    public void setParentSourceLevel1ObjectType(int i)
    {
        setIntegerProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID, i);
    }

    public int getParentSourceLevel2ObjectType()
    {
        return getIntegerProperty(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_TYPE_PTID);
    }

    public void setParentSourceLevel2ObjectType(int i)
    {
        setIntegerProperty(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_TYPE_PTID, i);
    }

    public int getParentType()
    {
        return getIntegerProperty(JdapiTypes.PARENT_TYPE_PTID);
    }

    public void setParentType(int i)
    {
        setIntegerProperty(JdapiTypes.PARENT_TYPE_PTID, i);
    }

    public int getPersistentClientInfoLength()
    {
        return getIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID);
    }

    public void setPersistentClientInfoLength(int i)
    {
        setIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, i);
    }

    public int getTriggerInternalType()
    {
        return getIntegerProperty(JdapiTypes.TRIGGER_INTERNAL_TYPE_PTID);
    }

    public void setTriggerInternalType(int i)
    {
        setIntegerProperty(JdapiTypes.TRIGGER_INTERNAL_TYPE_PTID, i);
    }

    public int getTriggerStyle()
    {
        return getIntegerProperty(JdapiTypes.TRIGGER_STYLE_PTID);
    }

    public void setTriggerStyle(int i)
    {
        setIntegerProperty(JdapiTypes.TRIGGER_STYLE_PTID, i);
    }

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
    }

    public boolean isDisplayInKeyboardHelp()
    {
        return getBooleanProperty(JdapiTypes.DISPLAY_IN_KEYBOARD_HELP_PTID);
    }

    public void setDisplayInKeyboardHelp(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DISPLAY_IN_KEYBOARD_HELP_PTID, flag);
    }

    public boolean isFireInQuery()
    {
        return getBooleanProperty(JdapiTypes.FIRE_IN_QUERY_PTID);
    }

    public void setFireInQuery(boolean flag)
    {
        setBooleanProperty(JdapiTypes.FIRE_IN_QUERY_PTID, flag);
    }

    public boolean isHide()
    {
        return getBooleanProperty(JdapiTypes.HIDE_PTID);
    }

    public void setHide(boolean flag)
    {
        setBooleanProperty(JdapiTypes.HIDE_PTID, flag);
    }

    public boolean isSubclassObjectGroup()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID);
    }

    public void setSubclassObjectGroup(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, flag);
    }

    public boolean isSubclassSubObject()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID);
    }

    public void setSubclassSubObject(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, flag);
    }

    public JdapiObject getModule()
    {
        return getObjectProperty(JdapiTypes.MODULE_PTID);
    }

    public JdapiObject getOwner()
    {
        return getObjectProperty(JdapiTypes.OWNER_PTID);
    }

    public JdapiObject getSource()
    {
        return getObjectProperty(JdapiTypes.SOURCE_PTID);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.TRIGGER_OTID;
    }
}
