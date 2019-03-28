// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.io.File;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiModule, JdapiException, TranslationTable, JdapiUnsupportedOperationException, 
//            JdapiObjectListIterator, Block, VisualAttribute, Jdapi, 
//            BaseAPI, BaseFormsObject, JdapiIterator, JdapiTypes

public class FormModule extends JdapiModule
{

    public int getTypeId()
    {
        return s_foType;
    }

    public FormModule(String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), Jdapi.getContextPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    protected FormModule(long l)
    {
        super(l);
    }

    public static FormModule open(String s)
    {
        return open(new File(s), null);
    }

    public static FormModule open(File file)
    {
        return open(file, null);
    }

    public static FormModule open(String s, String s1)
    {
        return open(new File(s), s1);
    }

    public static FormModule open(File file, String s)
    {
        for(JdapiIterator jdapiiterator = Jdapi.getModules(); jdapiiterator.hasNext();)
        {
            JdapiModule jdapimodule = (JdapiModule)jdapiiterator.next();
            String s1 = jdapimodule.getAbsolutePath();
            if(s1 != null && s1.equals(file.getAbsolutePath()))
                return (FormModule)jdapimodule;
        }

        if(!file.exists())
        {
            throw new JdapiException("'" + file.getAbsolutePath() + "' not found");
        } else
        {
            FormModule formmodule = BaseAPI._jni_load_form(Jdapi.getContextPointer(), file.getAbsolutePath(), s);
            formmodule.setAbsolutePath(file.getAbsolutePath());
            return formmodule;
        }
    }

    public void save(String s)
    {
        File file = new File(s);
        setAbsolutePath(file.getAbsolutePath());
        BaseAPI._jni_save_form(Jdapi.getContextPointer(), getObjectPointer(), getAbsolutePath());
    }

    public void compile()
    {
        BaseAPI._jni_compile_form(Jdapi.getContextPointer(), getObjectPointer());
    }

    public FormModule clone(String s)
    {
        return (FormModule)super.clone(null, s);
    }

    public static FormModule find(String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), Jdapi.getContextPointer(), s, s_foType);
        FormModule formmodule = null;
        if(l1 != 0L)
            formmodule = (FormModule)Jdapi.getObject(l1);
        return formmodule;
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

    public String getConsoleWindow()
    {
        return getStringProperty(JdapiTypes.CONSOLE_WINDOW_PTID);
    }

    public void setConsoleWindow(String s)
    {
        setStringProperty(JdapiTypes.CONSOLE_WINDOW_PTID, s);
    }

    public String getFirstNavigationBlockName()
    {
        return getStringProperty(JdapiTypes.FIRST_NAVIGATION_BLOCK_NAME_PTID);
    }

    public void setFirstNavigationBlockName(String s)
    {
        setStringProperty(JdapiTypes.FIRST_NAVIGATION_BLOCK_NAME_PTID, s);
    }

    public String getHelpBookTitle()
    {
        return getStringProperty(JdapiTypes.HELP_BOOK_TITLE_PTID);
    }

    public void setHelpBookTitle(String s)
    {
        setStringProperty(JdapiTypes.HELP_BOOK_TITLE_PTID, s);
    }

    public String getHorizontalToolbarCanvas()
    {
        return getStringProperty(JdapiTypes.HORIZONTAL_TOOLBAR_CANVAS_PTID);
    }

    public void setHorizontalToolbarCanvas(String s)
    {
        setStringProperty(JdapiTypes.HORIZONTAL_TOOLBAR_CANVAS_PTID, s);
    }

    public String getInitializeMenu()
    {
        return getStringProperty(JdapiTypes.INITIALIZE_MENU_PTID);
    }

    public void setInitializeMenu(String s)
    {
        setStringProperty(JdapiTypes.INITIALIZE_MENU_PTID, s);
    }

    public String getMenuModule()
    {
        return getStringProperty(JdapiTypes.MENU_MODULE_PTID);
    }

    public void setMenuModule(String s)
    {
        setStringProperty(JdapiTypes.MENU_MODULE_PTID, s);
    }

    public String getMenuRole()
    {
        return getStringProperty(JdapiTypes.MENU_ROLE_PTID);
    }

    public void setMenuRole(String s)
    {
        setStringProperty(JdapiTypes.MENU_ROLE_PTID, s);
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

    public String getRecordVisualAttributeGroupName()
    {
        return getStringProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_NAME_PTID);
    }

    public void setRecordVisualAttributeGroupName(String s)
    {
        setStringProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_NAME_PTID, s);
    }

    public String getTitle()
    {
        return getStringProperty(JdapiTypes.TITLE_PTID);
    }

    public void setTitle(String s)
    {
        setStringProperty(JdapiTypes.TITLE_PTID, s);
    }

    public String getVerticalToolbarCanvas()
    {
        return getStringProperty(JdapiTypes.VERTICAL_TOOLBAR_CANVAS_PTID);
    }

    public void setVerticalToolbarCanvas(String s)
    {
        setStringProperty(JdapiTypes.VERTICAL_TOOLBAR_CANVAS_PTID, s);
    }

    public int getCursorMode()
    {
        return getIntegerProperty(JdapiTypes.CURSOR_MODE_PTID);
    }

    public int getInteractionMode()
    {
        return getIntegerProperty(JdapiTypes.INTERACTION_MODE_PTID);
    }

    public void setInteractionMode(int i)
    {
        setIntegerProperty(JdapiTypes.INTERACTION_MODE_PTID, i);
    }

    public int getIsolationMode()
    {
        return getIntegerProperty(JdapiTypes.ISOLATION_MODE_PTID);
    }

    public void setIsolationMode(int i)
    {
        setIntegerProperty(JdapiTypes.ISOLATION_MODE_PTID, i);
    }

    public int getLanguageDirection()
    {
        return getIntegerProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID);
    }

    public void setLanguageDirection(int i)
    {
        setIntegerProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, i);
    }

    public int getMaximumQueryTime()
    {
        return getIntegerProperty(JdapiTypes.MAXIMUM_QUERY_TIME_PTID);
    }

    public void setMaximumQueryTime(int i)
    {
        setIntegerProperty(JdapiTypes.MAXIMUM_QUERY_TIME_PTID, i);
    }

    public int getMaximumRecordsFetched()
    {
        return getIntegerProperty(JdapiTypes.MAXIMUM_RECORDS_FETCHED_PTID);
    }

    public void setMaximumRecordsFetched(int i)
    {
        setIntegerProperty(JdapiTypes.MAXIMUM_RECORDS_FETCHED_PTID, i);
    }

    public int getMouseNavigationLimit()
    {
        return getIntegerProperty(JdapiTypes.MOUSE_NAVIGATION_LIMIT_PTID);
    }

    public void setMouseNavigationLimit(int i)
    {
        setIntegerProperty(JdapiTypes.MOUSE_NAVIGATION_LIMIT_PTID, i);
    }

    public int getNewdeferReqEnf()
    {
        return getIntegerProperty(JdapiTypes.NEWDEFER_REQ_ENF_PTID);
    }

    public void setNewdeferReqEnf(int i)
    {
        setIntegerProperty(JdapiTypes.NEWDEFER_REQ_ENF_PTID, i);
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

    public int getRuntimeComp()
    {
        return getIntegerProperty(JdapiTypes.RUNTIME_COMP_PTID);
    }

    public void setRuntimeComp(int i)
    {
        setIntegerProperty(JdapiTypes.RUNTIME_COMP_PTID, i);
    }

    public int getValidationUnit()
    {
        return getIntegerProperty(JdapiTypes.VALIDATION_UNIT_PTID);
    }

    public void setValidationUnit(int i)
    {
        setIntegerProperty(JdapiTypes.VALIDATION_UNIT_PTID, i);
    }

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
    }

    public boolean isSavepointMode()
    {
        return getBooleanProperty(JdapiTypes.SAVEPOINT_MODE_PTID);
    }

    public boolean isUse3dControls()
    {
        return getBooleanProperty(JdapiTypes.USE_3D_CONTROLS_PTID);
    }

    public void setUse3dControls(boolean flag)
    {
        setBooleanProperty(JdapiTypes.USE_3D_CONTROLS_PTID, flag);
    }

    public JdapiIterator getAlerts()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.ALERT_PTID, JdapiTypes.ALERT_OTID);
    }

    public JdapiIterator getAttachedLibraries()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.ATTACHMENT_LIBRARY_PTID, JdapiTypes.ATTACHMENT_LIBRARY_OTID);
    }

    public JdapiIterator getBlocks()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.BLOCK_PTID, JdapiTypes.BLOCK_OTID);
    }

    public JdapiIterator getCanvases()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.CANVAS_PTID, JdapiTypes.CANVAS_OTID);
    }

    public JdapiIterator getEditors()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.EDITOR_PTID, JdapiTypes.EDITOR_OTID);
    }

    public JdapiIterator getModuleParameters()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.FORM_PARAMETER_PTID, JdapiTypes.FORM_PARAMETER_OTID);
    }

    public Block getFirstNavigationBlockObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (Block)getObjectProperty(JdapiTypes.FIRST_NAVIGATION_BLOCK_OBJECT_PTID);
    }

    public void setFirstNavigationBlockObject(Block block)
    {
        setObjectProperty(JdapiTypes.FIRST_NAVIGATION_BLOCK_OBJECT_PTID, block);
    }

    public JdapiIterator getLOVs()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.LOV_PTID, JdapiTypes.LOV_OTID);
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

    public JdapiIterator getRecordGroups()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.RECORD_GROUP_PTID, JdapiTypes.RECORD_GROUP_OTID);
    }

    public VisualAttribute getRecordVisualAttributeGroupObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (VisualAttribute)getObjectProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_OBJECT_PTID);
    }

    public void setRecordVisualAttributeGroupObject(VisualAttribute visualattribute)
    {
        setObjectProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_OBJECT_PTID, visualattribute);
    }

    public JdapiIterator getReports()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.REPORT_PTID, JdapiTypes.REPORT_OTID);
    }

    public JdapiIterator getTriggers()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.TRIGGER_PTID, JdapiTypes.TRIGGER_OTID);
    }

    public JdapiIterator getVisualAttributes()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.VISUAL_ATTRIBUTE_PTID, JdapiTypes.VISUAL_ATTRIBUTE_OTID);
    }

    public JdapiIterator getWindows()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.WINDOW_PTID, JdapiTypes.WINDOW_OTID);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.FORM_MODULE_OTID;
    }
}
