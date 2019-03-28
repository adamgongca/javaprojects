// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, JdapiException, VisualAttribute, Jdapi, 
//            BaseAPI, JdapiTypes, Item, PropertyClass, 
//            ObjectLibrary, ObjectLibraryTab, JdapiObject

public class RadioButton extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public RadioButton(Item item, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), item.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public RadioButton(Item item, String s, RadioButton radiobutton)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), item.getObjectPointer(), s_foType, s, 0L, radiobutton.getObjectPointer());
        Jdapi.addObject(this);
    }

    public RadioButton(Item item, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), item.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public RadioButton(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), 0L);
        Jdapi.addObject(this);
    }

    public RadioButton(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, RadioButton radiobutton)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), radiobutton.getObjectPointer());
        Jdapi.addObject(this);
    }

    public RadioButton(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected RadioButton(long l)
    {
        super(l);
    }

    public RadioButton clone(Item item, String s)
    {
        return (RadioButton)super.clone(item, s);
    }

    public RadioButton clone(ObjectLibraryTab objectlibrarytab, String s)
    {
        return (RadioButton)super.clone(objectlibrarytab, s);
    }

    public static RadioButton find(Item item, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), item.getObjectPointer(), s, s_foType);
        RadioButton radiobutton = null;
        if(l1 != 0L)
            radiobutton = (RadioButton)Jdapi.getObject(l1);
        return radiobutton;
    }

    public static RadioButton find(ObjectLibraryTab objectlibrarytab, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s, s_foType);
        RadioButton radiobutton = null;
        if(l1 != 0L)
            radiobutton = (RadioButton)Jdapi.getObject(l1);
        return radiobutton;
    }

    public String getAccessKey()
    {
        return getStringProperty(JdapiTypes.ACCESS_KEY_PTID);
    }

    public void setAccessKey(String s)
    {
        setStringProperty(JdapiTypes.ACCESS_KEY_PTID, s);
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

    public String getLabel()
    {
        return getStringProperty(JdapiTypes.LABEL_PTID);
    }

    public void setLabel(String s)
    {
        setStringProperty(JdapiTypes.LABEL_PTID, s);
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

    public String getPrompt()
    {
        return getStringProperty(JdapiTypes.PROMPT_PTID);
    }

    public void setPrompt(String s)
    {
        setStringProperty(JdapiTypes.PROMPT_PTID, s);
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

    public String getPromptVisualAttributeName()
    {
        return getStringProperty(JdapiTypes.PROMPT_VISUALATTRIBUTE_NAME_PTID);
    }

    public void setPromptVisualAttributeName(String s)
    {
        setStringProperty(JdapiTypes.PROMPT_VISUALATTRIBUTE_NAME_PTID, s);
    }

    public String getRadioButtonValue()
    {
        return getStringProperty(JdapiTypes.RADIOBUTTON_VALUE_PTID);
    }

    public void setRadioButtonValue(String s)
    {
        setStringProperty(JdapiTypes.RADIOBUTTON_VALUE_PTID, s);
    }

    public String getVisualAttributeName()
    {
        return getStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID);
    }

    public void setVisualAttributeName(String s)
    {
        setStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, s);
    }

    public int getDistanceBetweenRecords()
    {
        return getIntegerProperty(JdapiTypes.DISTANCE_BETWEEN_RECORDS_PTID);
    }

    public void setDistanceBetweenRecords(int i)
    {
        setIntegerProperty(JdapiTypes.DISTANCE_BETWEEN_RECORDS_PTID, i);
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

    public int getPromptAlign()
    {
        return getIntegerProperty(JdapiTypes.PROMPT_ALIGN_PTID);
    }

    public void setPromptAlign(int i)
    {
        setIntegerProperty(JdapiTypes.PROMPT_ALIGN_PTID, i);
    }

    public int getPromptAlignOffset()
    {
        return getIntegerProperty(JdapiTypes.PROMPT_ALIGN_OFFSET_PTID);
    }

    public void setPromptAlignOffset(int i)
    {
        setIntegerProperty(JdapiTypes.PROMPT_ALIGN_OFFSET_PTID, i);
    }

    public int getPromptAttachmentEdge()
    {
        return getIntegerProperty(JdapiTypes.PROMPT_ATTACHMENT_EDGE_PTID);
    }

    public void setPromptAttachmentEdge(int i)
    {
        setIntegerProperty(JdapiTypes.PROMPT_ATTACHMENT_EDGE_PTID, i);
    }

    public int getPromptAttachmentOffset()
    {
        return getIntegerProperty(JdapiTypes.PROMPT_ATTACHMENT_OFFSET_PTID);
    }

    public void setPromptAttachmentOffset(int i)
    {
        setIntegerProperty(JdapiTypes.PROMPT_ATTACHMENT_OFFSET_PTID, i);
    }

    public int getPromptDisplayStyle()
    {
        return getIntegerProperty(JdapiTypes.PROMPT_DISPLAY_STYLE_PTID);
    }

    public void setPromptDisplayStyle(int i)
    {
        setIntegerProperty(JdapiTypes.PROMPT_DISPLAY_STYLE_PTID, i);
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

    public int getPromptJustification()
    {
        return getIntegerProperty(JdapiTypes.PROMPT_JUSTIFICATION_PTID);
    }

    public void setPromptJustification(int i)
    {
        setIntegerProperty(JdapiTypes.PROMPT_JUSTIFICATION_PTID, i);
    }

    public int getPromptReadingOrder()
    {
        return getIntegerProperty(JdapiTypes.PROMPT_READING_ORDER_PTID);
    }

    public void setPromptReadingOrder(int i)
    {
        setIntegerProperty(JdapiTypes.PROMPT_READING_ORDER_PTID, i);
    }

    public int getWidth()
    {
        return getIntegerProperty(JdapiTypes.WIDTH_PTID);
    }

    public void setWidth(int i)
    {
        setIntegerProperty(JdapiTypes.WIDTH_PTID, i);
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

    public boolean isEnabled()
    {
        return getBooleanProperty(JdapiTypes.ENABLED_PTID);
    }

    public void setEnabled(boolean flag)
    {
        setBooleanProperty(JdapiTypes.ENABLED_PTID, flag);
    }

    public boolean isSubclassSubObject()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID);
    }

    public void setSubclassSubObject(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, flag);
    }

    public boolean isVisible()
    {
        return getBooleanProperty(JdapiTypes.VISIBLE_PTID);
    }

    public void setVisible(boolean flag)
    {
        setBooleanProperty(JdapiTypes.VISIBLE_PTID, flag);
    }

    public JdapiObject getModule()
    {
        return getObjectProperty(JdapiTypes.MODULE_PTID);
    }

    public JdapiObject getOwner()
    {
        return getObjectProperty(JdapiTypes.OWNER_PTID);
    }

    public VisualAttribute getPromptVisualAttributeObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (VisualAttribute)getObjectProperty(JdapiTypes.PROMPT_VISUALATTRIBUTE_OBJECT_PTID);
    }

    public void setPromptVisualAttributeObject(VisualAttribute visualattribute)
    {
        setObjectProperty(JdapiTypes.PROMPT_VISUALATTRIBUTE_OBJECT_PTID, visualattribute);
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
        s_foType = JdapiTypes.RADIO_BUTTON_OTID;
    }
}
