// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.io.File;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiModule, JdapiException, TranslationTable, JdapiUnsupportedOperationException, 
//            JdapiObjectListIterator, Jdapi, BaseAPI, BaseFormsObject, 
//            JdapiIterator, JdapiTypes

public class MenuModule extends JdapiModule
{

    public int getTypeId()
    {
        return s_foType;
    }

    public MenuModule(String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), Jdapi.getContextPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    protected MenuModule(long l)
    {
        super(l);
    }

    public static MenuModule open(String s)
    {
        return open(new File(s), null);
    }

    public static MenuModule open(File file)
    {
        return open(file, null);
    }

    public static MenuModule open(String s, String s1)
    {
        return open(new File(s), s1);
    }

    public static MenuModule open(File file, String s)
    {
        for(JdapiIterator jdapiiterator = Jdapi.getModules(); jdapiiterator.hasNext();)
        {
            JdapiModule jdapimodule = (JdapiModule)jdapiiterator.next();
            String s1 = jdapimodule.getAbsolutePath();
            if(s1 != null && s1.equals(file.getAbsolutePath()))
                return (MenuModule)jdapimodule;
        }

        if(!file.exists())
        {
            throw new JdapiException("'" + file.getAbsolutePath() + "' not found");
        } else
        {
            MenuModule menumodule = BaseAPI._jni_load_menu(Jdapi.getContextPointer(), file.getAbsolutePath(), s);
            menumodule.setAbsolutePath(file.getAbsolutePath());
            return menumodule;
        }
    }

    public void save(String s)
    {
        File file = new File(s);
        setAbsolutePath(file.getAbsolutePath());
        BaseAPI._jni_save_menu(Jdapi.getContextPointer(), getObjectPointer(), getAbsolutePath());
    }

    public void compile()
    {
        BaseAPI._jni_compile_menu(Jdapi.getContextPointer(), getObjectPointer());
    }

    public MenuModule clone(String s)
    {
        return (MenuModule)super.clone(null, s);
    }

    public static MenuModule find(String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), Jdapi.getContextPointer(), s, s_foType);
        MenuModule menumodule = null;
        if(l1 != 0L)
            menumodule = (MenuModule)Jdapi.getObject(l1);
        return menumodule;
    }

    public void addRole(int i, String s)
    {
        BaseAPI._jni_mmd_add_role(Jdapi.getContextPointer(), super.m_pd2fob, i, s);
    }

    public void removeRole(int i)
    {
        BaseAPI._jni_mmd_remove_role(Jdapi.getContextPointer(), super.m_pd2fob, i);
    }

    public String getRole(int i)
    {
        return BaseAPI._jni_mmd_get_role(Jdapi.getContextPointer(), super.m_pd2fob, i);
    }

    public TranslationTable getTranslationTable()
    {
        if(Jdapi.s_transMode)
            return new TranslationTable(this);
        else
            throw new JdapiUnsupportedOperationException("Session not in Translation Mode");
    }

    public String getComment()
    {
        return getStringProperty(JdapiTypes.COMMENT_PTID);
    }

    public void setComment(String s)
    {
        setStringProperty(JdapiTypes.COMMENT_PTID, s);
    }

    public String getMainMenu()
    {
        return getStringProperty(JdapiTypes.MAIN_MENU_PTID);
    }

    public void setMainMenu(String s)
    {
        setStringProperty(JdapiTypes.MAIN_MENU_PTID, s);
    }

    public String getMenuDirectory()
    {
        return getStringProperty(JdapiTypes.MENU_DIRECTORY_PTID);
    }

    public void setMenuDirectory(String s)
    {
        setStringProperty(JdapiTypes.MENU_DIRECTORY_PTID, s);
    }

    public String getMenuFilename()
    {
        return getStringProperty(JdapiTypes.MENU_FILENAME_PTID);
    }

    public void setMenuFilename(String s)
    {
        setStringProperty(JdapiTypes.MENU_FILENAME_PTID, s);
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

    public String getStartupCode()
    {
        return getStringProperty(JdapiTypes.STARTUP_CODE_PTID);
    }

    public void setStartupCode(String s)
    {
        setStringProperty(JdapiTypes.STARTUP_CODE_PTID, s);
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

    public int getRoleCount()
    {
        return getIntegerProperty(JdapiTypes.ROLE_COUNT_PTID);
    }

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
    }

    public boolean isShareLibrary()
    {
        return getBooleanProperty(JdapiTypes.SHARE_LIBRARY_PTID);
    }

    public void setShareLibrary(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHARE_LIBRARY_PTID, flag);
    }

    public boolean isUseSecurity()
    {
        return getBooleanProperty(JdapiTypes.USE_SECURITY_PTID);
    }

    public void setUseSecurity(boolean flag)
    {
        setBooleanProperty(JdapiTypes.USE_SECURITY_PTID, flag);
    }

    public JdapiIterator getAttachedLibraries()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.ATTACHMENT_LIBRARY_PTID, JdapiTypes.ATTACHMENT_LIBRARY_OTID);
    }

    public JdapiIterator getMenus()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.MENU_PTID, JdapiTypes.MENU_OTID);
    }

    public JdapiIterator getObjectGroups()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.OBJECT_GROUP_PTID, JdapiTypes.OBJECT_GROUP_OTID);
    }

    public JdapiIterator getProgramUnits()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.PROGRAM_UNIT_PTID, JdapiTypes.PROGRAM_UNIT_OTID);
    }

    public JdapiIterator getPropertyClasses()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.PROPERTY_CLASS_PTID, JdapiTypes.PROPERTY_CLASS_OTID);
    }

    public JdapiIterator getVisualAttributes()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.VISUAL_ATTRIBUTE_PTID, JdapiTypes.VISUAL_ATTRIBUTE_OTID);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.MENU_MODULE_OTID;
    }
}
