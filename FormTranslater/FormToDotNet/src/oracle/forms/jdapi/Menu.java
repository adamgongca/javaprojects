// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, JdapiException, JdapiObjectListIterator, Jdapi, 
//            BaseAPI, JdapiTypes, FormModule, PropertyClass, 
//            MenuModule, ObjectLibrary, ObjectLibraryTab, JdapiIterator, 
//            JdapiObject

public class Menu extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public Menu(FormModule formmodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Menu(FormModule formmodule, String s, Menu menu)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, menu.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Menu(FormModule formmodule, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Menu(MenuModule menumodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), menumodule.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Menu(MenuModule menumodule, String s, Menu menu)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), menumodule.getObjectPointer(), s_foType, s, 0L, menu.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Menu(MenuModule menumodule, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), menumodule.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Menu(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), 0L);
        Jdapi.addObject(this);
    }

    public Menu(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, Menu menu)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), menu.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Menu(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected Menu(long l)
    {
        super(l);
    }

    public Menu clone(FormModule formmodule, String s)
    {
        return (Menu)super.clone(formmodule, s);
    }

    public Menu clone(MenuModule menumodule, String s)
    {
        return (Menu)super.clone(menumodule, s);
    }

    public Menu clone(ObjectLibraryTab objectlibrarytab, String s)
    {
        return (Menu)super.clone(objectlibrarytab, s);
    }

    public static Menu find(FormModule formmodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s, s_foType);
        Menu menu = null;
        if(l1 != 0L)
            menu = (Menu)Jdapi.getObject(l1);
        return menu;
    }

    public static Menu find(MenuModule menumodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), menumodule.getObjectPointer(), s, s_foType);
        Menu menu = null;
        if(l1 != 0L)
            menu = (Menu)Jdapi.getObject(l1);
        return menu;
    }

    public static Menu find(ObjectLibraryTab objectlibrarytab, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s, s_foType);
        Menu menu = null;
        if(l1 != 0L)
            menu = (Menu)Jdapi.getObject(l1);
        return menu;
    }

    public String getBottomTitle()
    {
        return getStringProperty(JdapiTypes.BOTTOM_TITLE_PTID);
    }

    public void setBottomTitle(String s)
    {
        setStringProperty(JdapiTypes.BOTTOM_TITLE_PTID, s);
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

    public String getSubTitle()
    {
        return getStringProperty(JdapiTypes.SUB_TITLE_PTID);
    }

    public void setSubTitle(String s)
    {
        setStringProperty(JdapiTypes.SUB_TITLE_PTID, s);
    }

    public String getTitle()
    {
        return getStringProperty(JdapiTypes.TITLE_PTID);
    }

    public void setTitle(String s)
    {
        setStringProperty(JdapiTypes.TITLE_PTID, s);
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

    public boolean isTearOffMenu()
    {
        return getBooleanProperty(JdapiTypes.TEAR_OFF_MENU_PTID);
    }

    public void setTearOffMenu(boolean flag)
    {
        setBooleanProperty(JdapiTypes.TEAR_OFF_MENU_PTID, flag);
    }

    public JdapiIterator getMenuItems()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.MENU_ITEM_PTID, JdapiTypes.MENU_ITEM_OTID);
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
        s_foType = JdapiTypes.MENU_OTID;
    }
}
