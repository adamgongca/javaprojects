// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, JdapiException, JdapiObjectListIterator, Jdapi, 
//            BaseAPI, JdapiTypes, FormModule, MenuModule, 
//            ObjectLibrary, ObjectLibraryTab, JdapiObject, JdapiIterator

public class PropertyClass extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public PropertyClass(FormModule formmodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public PropertyClass(FormModule formmodule, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public PropertyClass(MenuModule menumodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), menumodule.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public PropertyClass(MenuModule menumodule, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), menumodule.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public PropertyClass(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), 0L);
        Jdapi.addObject(this);
    }

    public PropertyClass(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected PropertyClass(long l)
    {
        super(l);
    }

    public PropertyClass clone(FormModule formmodule, String s)
    {
        return (PropertyClass)super.clone(formmodule, s);
    }

    public PropertyClass clone(MenuModule menumodule, String s)
    {
        return (PropertyClass)super.clone(menumodule, s);
    }

    public PropertyClass clone(ObjectLibraryTab objectlibrarytab, String s)
    {
        return (PropertyClass)super.clone(objectlibrarytab, s);
    }

    public static PropertyClass find(FormModule formmodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s, s_foType);
        PropertyClass propertyclass = null;
        if(l1 != 0L)
            propertyclass = (PropertyClass)Jdapi.getObject(l1);
        return propertyclass;
    }

    public static PropertyClass find(MenuModule menumodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), menumodule.getObjectPointer(), s, s_foType);
        PropertyClass propertyclass = null;
        if(l1 != 0L)
            propertyclass = (PropertyClass)Jdapi.getObject(l1);
        return propertyclass;
    }

    public static PropertyClass find(ObjectLibraryTab objectlibrarytab, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s, s_foType);
        PropertyClass propertyclass = null;
        if(l1 != 0L)
            propertyclass = (PropertyClass)Jdapi.getObject(l1);
        return propertyclass;
    }

    public String getComment()
    {
        return getStringProperty(JdapiTypes.COMMENT_PTID);
    }

    public void setComment(String s)
    {
        setStringProperty(JdapiTypes.COMMENT_PTID, s);
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

    public int getParentModuleType()
    {
        return getIntegerProperty(JdapiTypes.PARENT_MODULETYPE_PTID);
    }

    public void setParentModuleType(int i)
    {
        setIntegerProperty(JdapiTypes.PARENT_MODULETYPE_PTID, i);
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

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
    }

    public boolean isSubclassObjectGroup()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID);
    }

    public void setSubclassObjectGroup(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, flag);
    }

    public JdapiObject getModule()
    {
        return getObjectProperty(JdapiTypes.MODULE_PTID);
    }

    public JdapiObject getOwner()
    {
        return getObjectProperty(JdapiTypes.OWNER_PTID);
    }

    public PropertyClass getSource()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (PropertyClass)getObjectProperty(JdapiTypes.SOURCE_PTID);
    }

    public JdapiIterator getTriggers()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.TRIGGER_PTID, JdapiTypes.TRIGGER_OTID);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.PROPERTY_CLASS_OTID;
    }
}
