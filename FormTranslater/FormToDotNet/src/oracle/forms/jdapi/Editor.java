// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, JdapiException, VisualAttribute, Jdapi, 
//            BaseAPI, JdapiTypes, FormModule, PropertyClass, 
//            ObjectLibrary, ObjectLibraryTab, JdapiObject

public class Editor extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public Editor(FormModule formmodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Editor(FormModule formmodule, String s, Editor editor)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, editor.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Editor(FormModule formmodule, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Editor(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), 0L);
        Jdapi.addObject(this);
    }

    public Editor(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, Editor editor)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), editor.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Editor(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected Editor(long l)
    {
        super(l);
    }

    public Editor clone(FormModule formmodule, String s)
    {
        return (Editor)super.clone(formmodule, s);
    }

    public Editor clone(ObjectLibraryTab objectlibrarytab, String s)
    {
        return (Editor)super.clone(objectlibrarytab, s);
    }

    public static Editor find(FormModule formmodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s, s_foType);
        Editor editor = null;
        if(l1 != 0L)
            editor = (Editor)Jdapi.getObject(l1);
        return editor;
    }

    public static Editor find(ObjectLibraryTab objectlibrarytab, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s, s_foType);
        Editor editor = null;
        if(l1 != 0L)
            editor = (Editor)Jdapi.getObject(l1);
        return editor;
    }

    public String getBackColor()
    {
        return getStringProperty(JdapiTypes.BACK_COLOR_PTID);
    }

    public void setBackColor(String s)
    {
        setStringProperty(JdapiTypes.BACK_COLOR_PTID, s);
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

    public String getTitle()
    {
        return getStringProperty(JdapiTypes.TITLE_PTID);
    }

    public void setTitle(String s)
    {
        setStringProperty(JdapiTypes.TITLE_PTID, s);
    }

    public String getVisualAttributeName()
    {
        return getStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID);
    }

    public void setVisualAttributeName(String s)
    {
        setStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, s);
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

    public int getWidth()
    {
        return getIntegerProperty(JdapiTypes.WIDTH_PTID);
    }

    public void setWidth(int i)
    {
        setIntegerProperty(JdapiTypes.WIDTH_PTID, i);
    }

    public int getWrapStyle()
    {
        return getIntegerProperty(JdapiTypes.WRAP_STYLE_PTID);
    }

    public void setWrapStyle(int i)
    {
        setIntegerProperty(JdapiTypes.WRAP_STYLE_PTID, i);
    }

    public int getXPosition()
    {
        return getIntegerProperty(JdapiTypes.X_POSITION_PTID);
    }

    public void setXPosition(int i)
    {
        setIntegerProperty(JdapiTypes.X_POSITION_PTID, i);
    }

    public int getYPosition()
    {
        return getIntegerProperty(JdapiTypes.Y_POSITION_PTID);
    }

    public void setYPosition(int i)
    {
        setIntegerProperty(JdapiTypes.Y_POSITION_PTID, i);
    }

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
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

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.EDITOR_OTID;
    }
}
