// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            FormModule, PropertyClass, MenuModule, ObjectLibrary, 
//            ObjectLibraryTab, JdapiObject

public class VisualAttribute extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public VisualAttribute(FormModule formmodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public VisualAttribute(FormModule formmodule, String s, VisualAttribute visualattribute)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, visualattribute.getObjectPointer());
        Jdapi.addObject(this);
    }

    public VisualAttribute(FormModule formmodule, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public VisualAttribute(MenuModule menumodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), menumodule.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public VisualAttribute(MenuModule menumodule, String s, VisualAttribute visualattribute)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), menumodule.getObjectPointer(), s_foType, s, 0L, visualattribute.getObjectPointer());
        Jdapi.addObject(this);
    }

    public VisualAttribute(MenuModule menumodule, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), menumodule.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public VisualAttribute(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), 0L);
        Jdapi.addObject(this);
    }

    public VisualAttribute(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, VisualAttribute visualattribute)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), visualattribute.getObjectPointer());
        Jdapi.addObject(this);
    }

    public VisualAttribute(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected VisualAttribute(long l)
    {
        super(l);
    }

    public VisualAttribute clone(FormModule formmodule, String s)
    {
        return (VisualAttribute)super.clone(formmodule, s);
    }

    public VisualAttribute clone(MenuModule menumodule, String s)
    {
        return (VisualAttribute)super.clone(menumodule, s);
    }

    public VisualAttribute clone(ObjectLibraryTab objectlibrarytab, String s)
    {
        return (VisualAttribute)super.clone(objectlibrarytab, s);
    }

    public static VisualAttribute find(FormModule formmodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s, s_foType);
        VisualAttribute visualattribute = null;
        if(l1 != 0L)
            visualattribute = (VisualAttribute)Jdapi.getObject(l1);
        return visualattribute;
    }

    public static VisualAttribute find(MenuModule menumodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), menumodule.getObjectPointer(), s, s_foType);
        VisualAttribute visualattribute = null;
        if(l1 != 0L)
            visualattribute = (VisualAttribute)Jdapi.getObject(l1);
        return visualattribute;
    }

    public static VisualAttribute find(ObjectLibraryTab objectlibrarytab, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s, s_foType);
        VisualAttribute visualattribute = null;
        if(l1 != 0L)
            visualattribute = (VisualAttribute)Jdapi.getObject(l1);
        return visualattribute;
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

    public String getFrameTitleBackColor()
    {
        return getStringProperty(JdapiTypes.FRAME_TITLE_BACK_COLOR_PTID);
    }

    public void setFrameTitleBackColor(String s)
    {
        setStringProperty(JdapiTypes.FRAME_TITLE_BACK_COLOR_PTID, s);
    }

    public String getFrameTitleFillPattern()
    {
        return getStringProperty(JdapiTypes.FRAME_TITLE_FILL_PATTERN_PTID);
    }

    public void setFrameTitleFillPattern(String s)
    {
        setStringProperty(JdapiTypes.FRAME_TITLE_FILL_PATTERN_PTID, s);
    }

    public String getFrameTitleFontName()
    {
        return getStringProperty(JdapiTypes.FRAME_TITLE_FONT_NAME_PTID);
    }

    public void setFrameTitleFontName(String s)
    {
        setStringProperty(JdapiTypes.FRAME_TITLE_FONT_NAME_PTID, s);
    }

    public String getFrameTitleForegroundColor()
    {
        return getStringProperty(JdapiTypes.FRAME_TITLE_FOREGROUND_COLOR_PTID);
    }

    public void setFrameTitleForegroundColor(String s)
    {
        setStringProperty(JdapiTypes.FRAME_TITLE_FOREGROUND_COLOR_PTID, s);
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

    public String getPromptBackColor()
    {
        return getStringProperty(JdapiTypes.PROMPT_BACK_COLOR_PTID);
    }

    public void setPromptBackColor(String s)
    {
        setStringProperty(JdapiTypes.PROMPT_BACK_COLOR_PTID, s);
    }

    public String getPromptFillPattern()
    {
        return getStringProperty(JdapiTypes.PROMPT_FILL_PATTERN_PTID);
    }

    public void setPromptFillPattern(String s)
    {
        setStringProperty(JdapiTypes.PROMPT_FILL_PATTERN_PTID, s);
    }

    public String getPromptFontName()
    {
        return getStringProperty(JdapiTypes.PROMPT_FONT_NAME_PTID);
    }

    public void setPromptFontName(String s)
    {
        setStringProperty(JdapiTypes.PROMPT_FONT_NAME_PTID, s);
    }

    public String getPromptForegroundColor()
    {
        return getStringProperty(JdapiTypes.PROMPT_FOREGROUND_COLOR_PTID);
    }

    public void setPromptForegroundColor(String s)
    {
        setStringProperty(JdapiTypes.PROMPT_FOREGROUND_COLOR_PTID, s);
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

    public int getFrameTitleFontSize()
    {
        return getIntegerProperty(JdapiTypes.FRAME_TITLE_FONT_SIZE_PTID);
    }

    public void setFrameTitleFontSize(int i)
    {
        setIntegerProperty(JdapiTypes.FRAME_TITLE_FONT_SIZE_PTID, i);
    }

    public int getFrameTitleFontSpacing()
    {
        return getIntegerProperty(JdapiTypes.FRAME_TITLE_FONT_SPACING_PTID);
    }

    public void setFrameTitleFontSpacing(int i)
    {
        setIntegerProperty(JdapiTypes.FRAME_TITLE_FONT_SPACING_PTID, i);
    }

    public int getFrameTitleFontStyle()
    {
        return getIntegerProperty(JdapiTypes.FRAME_TITLE_FONT_STYLE_PTID);
    }

    public void setFrameTitleFontStyle(int i)
    {
        setIntegerProperty(JdapiTypes.FRAME_TITLE_FONT_STYLE_PTID, i);
    }

    public int getFrameTitleFontWeight()
    {
        return getIntegerProperty(JdapiTypes.FRAME_TITLE_FONT_WEIGHT_PTID);
    }

    public void setFrameTitleFontWeight(int i)
    {
        setIntegerProperty(JdapiTypes.FRAME_TITLE_FONT_WEIGHT_PTID, i);
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

    public int getPromptFontSize()
    {
        return getIntegerProperty(JdapiTypes.PROMPT_FONT_SIZE_PTID);
    }

    public void setPromptFontSize(int i)
    {
        setIntegerProperty(JdapiTypes.PROMPT_FONT_SIZE_PTID, i);
    }

    public int getPromptFontSpacing()
    {
        return getIntegerProperty(JdapiTypes.PROMPT_FONT_SPACING_PTID);
    }

    public void setPromptFontSpacing(int i)
    {
        setIntegerProperty(JdapiTypes.PROMPT_FONT_SPACING_PTID, i);
    }

    public int getPromptFontStyle()
    {
        return getIntegerProperty(JdapiTypes.PROMPT_FONT_STYLE_PTID);
    }

    public void setPromptFontStyle(int i)
    {
        setIntegerProperty(JdapiTypes.PROMPT_FONT_STYLE_PTID, i);
    }

    public int getPromptFontWeight()
    {
        return getIntegerProperty(JdapiTypes.PROMPT_FONT_WEIGHT_PTID);
    }

    public void setPromptFontWeight(int i)
    {
        setIntegerProperty(JdapiTypes.PROMPT_FONT_WEIGHT_PTID, i);
    }

    public int getVisualAttributeType()
    {
        return getIntegerProperty(JdapiTypes.VISUALATTRIBUTE_TYPE_PTID);
    }

    public void setVisualAttributeType(int i)
    {
        setIntegerProperty(JdapiTypes.VISUALATTRIBUTE_TYPE_PTID, i);
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

    public JdapiObject getSource()
    {
        return getObjectProperty(JdapiTypes.SOURCE_PTID);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.VISUAL_ATTRIBUTE_OTID;
    }
}
