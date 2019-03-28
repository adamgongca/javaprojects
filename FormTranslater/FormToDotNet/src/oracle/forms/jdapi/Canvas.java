// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, JdapiException, JdapiObjectListIterator, Menu, 
//            VisualAttribute, Window, Jdapi, BaseAPI, 
//            JdapiTypes, FormModule, PropertyClass, ObjectLibrary, 
//            ObjectLibraryTab, JdapiIterator, JdapiObject

public class Canvas extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public Canvas(FormModule formmodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Canvas(FormModule formmodule, String s, Canvas canvas)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, canvas.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Canvas(FormModule formmodule, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Canvas(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), 0L);
        Jdapi.addObject(this);
    }

    public Canvas(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, Canvas canvas)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), canvas.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Canvas(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected Canvas(long l)
    {
        super(l);
    }

    public Canvas clone(FormModule formmodule, String s)
    {
        return (Canvas)super.clone(formmodule, s);
    }

    public Canvas clone(ObjectLibraryTab objectlibrarytab, String s)
    {
        return (Canvas)super.clone(objectlibrarytab, s);
    }

    public static Canvas find(FormModule formmodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s, s_foType);
        Canvas canvas = null;
        if(l1 != 0L)
            canvas = (Canvas)Jdapi.getObject(l1);
        return canvas;
    }

    public static Canvas find(ObjectLibraryTab objectlibrarytab, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s, s_foType);
        Canvas canvas = null;
        if(l1 != 0L)
            canvas = (Canvas)Jdapi.getObject(l1);
        return canvas;
    }

    public String getBackColor()
    {
        return getStringProperty(JdapiTypes.BACK_COLOR_PTID);
    }

    public void setBackColor(String s)
    {
        setStringProperty(JdapiTypes.BACK_COLOR_PTID, s);
    }

    public String getComment()
    {
        return getStringProperty(JdapiTypes.COMMENT_PTID);
    }

    public void setComment(String s)
    {
        setStringProperty(JdapiTypes.COMMENT_PTID, s);
    }

    public String getFillPattern()
    {
        return getStringProperty(JdapiTypes.FILL_PATTERN_PTID);
    }

    public void setFillPattern(String s)
    {
        setStringProperty(JdapiTypes.FILL_PATTERN_PTID, s);
    }

    public String getFontName()
    {
        return getStringProperty(JdapiTypes.FONT_NAME_PTID);
    }

    public void setFontName(String s)
    {
        setStringProperty(JdapiTypes.FONT_NAME_PTID, s);
    }

    public String getForegroundColor()
    {
        return getStringProperty(JdapiTypes.FOREGROUND_COLOR_PTID);
    }

    public void setForegroundColor(String s)
    {
        setStringProperty(JdapiTypes.FOREGROUND_COLOR_PTID, s);
    }

    public String getHelpBookTopic()
    {
        return getStringProperty(JdapiTypes.HELP_BOOK_TOPIC_PTID);
    }

    public void setHelpBookTopic(String s)
    {
        setStringProperty(JdapiTypes.HELP_BOOK_TOPIC_PTID, s);
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

    public String getPopupMenuName()
    {
        return getStringProperty(JdapiTypes.POPUP_MENU_NAME_PTID);
    }

    public void setPopupMenuName(String s)
    {
        setStringProperty(JdapiTypes.POPUP_MENU_NAME_PTID, s);
    }

    public String getVisualAttributeName()
    {
        return getStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID);
    }

    public void setVisualAttributeName(String s)
    {
        setStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, s);
    }

    public String getWindowName()
    {
        return getStringProperty(JdapiTypes.WINDOW_NAME_PTID);
    }

    public void setWindowName(String s)
    {
        setStringProperty(JdapiTypes.WINDOW_NAME_PTID, s);
    }

    public int getBevel()
    {
        return getIntegerProperty(JdapiTypes.BEVEL_PTID);
    }

    public void setBevel(int i)
    {
        setIntegerProperty(JdapiTypes.BEVEL_PTID, i);
    }

    public int getCanvasType()
    {
        return getIntegerProperty(JdapiTypes.CANVAS_TYPE_PTID);
    }

    public void setCanvasType(int i)
    {
        setIntegerProperty(JdapiTypes.CANVAS_TYPE_PTID, i);
    }

    public int getFontSize()
    {
        return getIntegerProperty(JdapiTypes.FONT_SIZE_PTID);
    }

    public void setFontSize(int i)
    {
        setIntegerProperty(JdapiTypes.FONT_SIZE_PTID, i);
    }

    public int getFontSpacing()
    {
        return getIntegerProperty(JdapiTypes.FONT_SPACING_PTID);
    }

    public void setFontSpacing(int i)
    {
        setIntegerProperty(JdapiTypes.FONT_SPACING_PTID, i);
    }

    public int getFontStyle()
    {
        return getIntegerProperty(JdapiTypes.FONT_STYLE_PTID);
    }

    public void setFontStyle(int i)
    {
        setIntegerProperty(JdapiTypes.FONT_STYLE_PTID, i);
    }

    public int getFontWeight()
    {
        return getIntegerProperty(JdapiTypes.FONT_WEIGHT_PTID);
    }

    public void setFontWeight(int i)
    {
        setIntegerProperty(JdapiTypes.FONT_WEIGHT_PTID, i);
    }

    public int getHeight()
    {
        return getIntegerProperty(JdapiTypes.HEIGHT_PTID);
    }

    public void setHeight(int i)
    {
        setIntegerProperty(JdapiTypes.HEIGHT_PTID, i);
    }

    public int getLanguageDirection()
    {
        return getIntegerProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID);
    }

    public void setLanguageDirection(int i)
    {
        setIntegerProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, i);
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

    public int getTabActionStyle()
    {
        return getIntegerProperty(JdapiTypes.TAB_ACTION_STYLE_PTID);
    }

    public void setTabActionStyle(int i)
    {
        setIntegerProperty(JdapiTypes.TAB_ACTION_STYLE_PTID, i);
    }

    public int getTabAttachmentEdge()
    {
        return getIntegerProperty(JdapiTypes.TAB_ATTACHMENT_EDGE_PTID);
    }

    public void setTabAttachmentEdge(int i)
    {
        setIntegerProperty(JdapiTypes.TAB_ATTACHMENT_EDGE_PTID, i);
    }

    public int getTabStyle()
    {
        return getIntegerProperty(JdapiTypes.TAB_STYLE_PTID);
    }

    public void setTabStyle(int i)
    {
        setIntegerProperty(JdapiTypes.TAB_STYLE_PTID, i);
    }

    public int getTabWidthStyle()
    {
        return getIntegerProperty(JdapiTypes.TAB_WIDTH_STYLE_PTID);
    }

    public void setTabWidthStyle(int i)
    {
        setIntegerProperty(JdapiTypes.TAB_WIDTH_STYLE_PTID, i);
    }

    public int getViewportHeight()
    {
        return getIntegerProperty(JdapiTypes.VIEWPORT_HEIGHT_PTID);
    }

    public void setViewportHeight(int i)
    {
        setIntegerProperty(JdapiTypes.VIEWPORT_HEIGHT_PTID, i);
    }

    public int getViewportWidth()
    {
        return getIntegerProperty(JdapiTypes.VIEWPORT_WIDTH_PTID);
    }

    public void setViewportWidth(int i)
    {
        setIntegerProperty(JdapiTypes.VIEWPORT_WIDTH_PTID, i);
    }

    public int getViewportXPosition()
    {
        return getIntegerProperty(JdapiTypes.VIEWPORT_X_POSITION_PTID);
    }

    public void setViewportXPosition(int i)
    {
        setIntegerProperty(JdapiTypes.VIEWPORT_X_POSITION_PTID, i);
    }

    public int getViewportXPositionOnCanvas()
    {
        return getIntegerProperty(JdapiTypes.VIEWPORT_X_POSITION_ON_CANVAS_PTID);
    }

    public void setViewportXPositionOnCanvas(int i)
    {
        setIntegerProperty(JdapiTypes.VIEWPORT_X_POSITION_ON_CANVAS_PTID, i);
    }

    public int getViewportYPosition()
    {
        return getIntegerProperty(JdapiTypes.VIEWPORT_Y_POSITION_PTID);
    }

    public void setViewportYPosition(int i)
    {
        setIntegerProperty(JdapiTypes.VIEWPORT_Y_POSITION_PTID, i);
    }

    public int getViewportYPositionOnCanvas()
    {
        return getIntegerProperty(JdapiTypes.VIEWPORT_Y_POSITION_ON_CANVAS_PTID);
    }

    public void setViewportYPositionOnCanvas(int i)
    {
        setIntegerProperty(JdapiTypes.VIEWPORT_Y_POSITION_ON_CANVAS_PTID, i);
    }

    public int getWidth()
    {
        return getIntegerProperty(JdapiTypes.WIDTH_PTID);
    }

    public void setWidth(int i)
    {
        setIntegerProperty(JdapiTypes.WIDTH_PTID, i);
    }

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
    }

    public boolean isDisplayViewport()
    {
        return getBooleanProperty(JdapiTypes.DISPLAY_VIEWPORT_PTID);
    }

    public void setDisplayViewport(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DISPLAY_VIEWPORT_PTID, flag);
    }

    public boolean isRaiseOnEnter()
    {
        return getBooleanProperty(JdapiTypes.RAISE_ON_ENTER_PTID);
    }

    public void setRaiseOnEnter(boolean flag)
    {
        setBooleanProperty(JdapiTypes.RAISE_ON_ENTER_PTID, flag);
    }

    public boolean isShowHorizontalScrollbar()
    {
        return getBooleanProperty(JdapiTypes.SHOW_HORIZONTAL_SCROLLBAR_PTID);
    }

    public void setShowHorizontalScrollbar(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_HORIZONTAL_SCROLLBAR_PTID, flag);
    }

    public boolean isShowVerticalScrollbar()
    {
        return getBooleanProperty(JdapiTypes.SHOW_VERTICAL_SCROLLBAR_PTID);
    }

    public void setShowVerticalScrollbar(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_VERTICAL_SCROLLBAR_PTID, flag);
    }

    public boolean isSubclassObjectGroup()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID);
    }

    public void setSubclassObjectGroup(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, flag);
    }

    public boolean isVisible()
    {
        return getBooleanProperty(JdapiTypes.VISIBLE_PTID);
    }

    public void setVisible(boolean flag)
    {
        setBooleanProperty(JdapiTypes.VISIBLE_PTID, flag);
    }

    public JdapiIterator getGraphicses()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.GRAPHIC_PTID, JdapiTypes.GRAPHIC_OTID);
    }

    public JdapiObject getModule()
    {
        return getObjectProperty(JdapiTypes.MODULE_PTID);
    }

    public JdapiObject getOwner()
    {
        return getObjectProperty(JdapiTypes.OWNER_PTID);
    }

    public Menu getPopupMenuObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (Menu)getObjectProperty(JdapiTypes.POPUP_MENU_OBJECT_PTID);
    }

    public void setPopupMenuObject(Menu menu)
    {
        setObjectProperty(JdapiTypes.POPUP_MENU_OBJECT_PTID, menu);
    }

    public JdapiObject getSource()
    {
        return getObjectProperty(JdapiTypes.SOURCE_PTID);
    }

    public JdapiIterator getTabPages()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.TAB_PAGE_PTID, JdapiTypes.TAB_PAGE_OTID);
    }

    public VisualAttribute getVisualAttributeObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (VisualAttribute)getObjectProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID);
    }

    public void setVisualAttributeObject(VisualAttribute visualattribute)
    {
        setObjectProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, visualattribute);
    }

    public JdapiIterator getVisualStates()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.VISUAL_STATE_PTID, JdapiTypes.VISUAL_STATE_OTID);
    }

    public Window getWindowObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (Window)getObjectProperty(JdapiTypes.WINDOW_OBJECT_PTID);
    }

    public void setWindowObject(Window window)
    {
        setObjectProperty(JdapiTypes.WINDOW_OBJECT_PTID, window);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.CANVAS_OTID;
    }
}
