// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, JdapiException, Canvas, Editor, 
//            LOV, Menu, VisualAttribute, JdapiObjectListIterator, 
//            RecordGroup, TabPage, Jdapi, BaseAPI, 
//            JdapiTypes, Block, PropertyClass, ObjectLibrary, 
//            ObjectLibraryTab, JdapiObject, JdapiIterator

public class Item extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public Item(Block block, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), block.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Item(Block block, String s, Item item)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), block.getObjectPointer(), s_foType, s, 0L, item.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Item(Block block, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), block.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Item(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), 0L);
        Jdapi.addObject(this);
    }

    public Item(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, Item item)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), item.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Item(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected Item(long l)
    {
        super(l);
    }

    public Item clone(Block block, String s)
    {
        return (Item)super.clone(block, s);
    }

    public Item clone(ObjectLibraryTab objectlibrarytab, String s)
    {
        return (Item)super.clone(objectlibrarytab, s);
    }

    public static Item find(Block block, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), block.getObjectPointer(), s, s_foType);
        Item item = null;
        if(l1 != 0L)
            item = (Item)Jdapi.getObject(l1);
        return item;
    }

    public static Item find(ObjectLibraryTab objectlibrarytab, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s, s_foType);
        Item item = null;
        if(l1 != 0L)
            item = (Item)Jdapi.getObject(l1);
        return item;
    }

    public void insertElement(int i, String s, String s1)
    {
        BaseAPI._jni_itm_insert_element(Jdapi.getContextPointer(), super.m_pd2fob, i, s, s1);
    }

    public void deleteElement(int i)
    {
        BaseAPI._jni_itm_delete_element(Jdapi.getContextPointer(), super.m_pd2fob, i);
    }

    public String getElementLabel(int i)
    {
        return BaseAPI._jni_itm_get_element_label(Jdapi.getContextPointer(), super.m_pd2fob, i);
    }

    public String getElementValue(int i)
    {
        return BaseAPI._jni_itm_get_element_value(Jdapi.getContextPointer(), super.m_pd2fob, i);
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

    public String getCheckedValue()
    {
        return getStringProperty(JdapiTypes.CHECKED_VALUE_PTID);
    }

    public void setCheckedValue(String s)
    {
        setStringProperty(JdapiTypes.CHECKED_VALUE_PTID, s);
    }

    public String getCanvasName()
    {
        return getStringProperty(JdapiTypes.CANVAS_NAME_PTID);
    }

    public void setCanvasName(String s)
    {
        setStringProperty(JdapiTypes.CANVAS_NAME_PTID, s);
    }

    public String getColumnName()
    {
        return getStringProperty(JdapiTypes.COLUMN_NAME_PTID);
    }

    public void setColumnName(String s)
    {
        setStringProperty(JdapiTypes.COLUMN_NAME_PTID, s);
    }

    public String getComment()
    {
        return getStringProperty(JdapiTypes.COMMENT_PTID);
    }

    public void setComment(String s)
    {
        setStringProperty(JdapiTypes.COMMENT_PTID, s);
    }

    public String getCopyValueFromItem()
    {
        return getStringProperty(JdapiTypes.COPY_VALUE_FROM_ITEM_PTID);
    }

    public void setCopyValueFromItem(String s)
    {
        setStringProperty(JdapiTypes.COPY_VALUE_FROM_ITEM_PTID, s);
    }

    public String getDataSourceBlock()
    {
        return getStringProperty(JdapiTypes.DATA_SOURCE_BLOCK_PTID);
    }

    public void setDataSourceBlock(String s)
    {
        setStringProperty(JdapiTypes.DATA_SOURCE_BLOCK_PTID, s);
    }

    public String getDataSourceXAxis()
    {
        return getStringProperty(JdapiTypes.DATA_SOURCE_X_AXIS_PTID);
    }

    public void setDataSourceXAxis(String s)
    {
        setStringProperty(JdapiTypes.DATA_SOURCE_X_AXIS_PTID, s);
    }

    public String getDataSourceYAxis()
    {
        return getStringProperty(JdapiTypes.DATA_SOURCE_Y_AXIS_PTID);
    }

    public void setDataSourceYAxis(String s)
    {
        setStringProperty(JdapiTypes.DATA_SOURCE_Y_AXIS_PTID, s);
    }

    public String getEditName()
    {
        return getStringProperty(JdapiTypes.EDIT_NAME_PTID);
    }

    public void setEditName(String s)
    {
        setStringProperty(JdapiTypes.EDIT_NAME_PTID, s);
    }

    public String getFillPattern()
    {
        return getStringProperty(JdapiTypes.FILL_PATTERN_PTID);
    }

    public void setFillPattern(String s)
    {
        setStringProperty(JdapiTypes.FILL_PATTERN_PTID, s);
    }

    public String getFilename()
    {
        return getStringProperty(JdapiTypes.FILENAME_PTID);
    }

    public void setFilename(String s)
    {
        setStringProperty(JdapiTypes.FILENAME_PTID, s);
    }

    public String getFormatMask()
    {
        return getStringProperty(JdapiTypes.FORMAT_MASK_PTID);
    }

    public void setFormatMask(String s)
    {
        setStringProperty(JdapiTypes.FORMAT_MASK_PTID, s);
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

    public String getFormula()
    {
        return getStringProperty(JdapiTypes.FORMULA_PTID);
    }

    public void setFormula(String s)
    {
        setStringProperty(JdapiTypes.FORMULA_PTID, s);
    }

    public String getHelpBookTopic()
    {
        return getStringProperty(JdapiTypes.HELP_BOOK_TOPIC_PTID);
    }

    public void setHelpBookTopic(String s)
    {
        setStringProperty(JdapiTypes.HELP_BOOK_TOPIC_PTID, s);
    }

    public String getHighestAllowedValue()
    {
        return getStringProperty(JdapiTypes.HIGHEST_ALLOWED_VALUE_PTID);
    }

    public void setHighestAllowedValue(String s)
    {
        setStringProperty(JdapiTypes.HIGHEST_ALLOWED_VALUE_PTID, s);
    }

    public String getHint()
    {
        return getStringProperty(JdapiTypes.HINT_PTID);
    }

    public void setHint(String s)
    {
        setStringProperty(JdapiTypes.HINT_PTID, s);
    }

    public String getIconFilename()
    {
        return getStringProperty(JdapiTypes.ICON_FILENAME_PTID);
    }

    public void setIconFilename(String s)
    {
        setStringProperty(JdapiTypes.ICON_FILENAME_PTID, s);
    }

    public String getImplementationClass()
    {
        return getStringProperty(JdapiTypes.IMPLEMENTATION_CLASS_PTID);
    }

    public void setImplementationClass(String s)
    {
        setStringProperty(JdapiTypes.IMPLEMENTATION_CLASS_PTID, s);
    }

    public String getInitializeValue()
    {
        return getStringProperty(JdapiTypes.INITIALIZE_VALUE_PTID);
    }

    public void setInitializeValue(String s)
    {
        setStringProperty(JdapiTypes.INITIALIZE_VALUE_PTID, s);
    }

    public String getLabel()
    {
        return getStringProperty(JdapiTypes.LABEL_PTID);
    }

    public void setLabel(String s)
    {
        setStringProperty(JdapiTypes.LABEL_PTID, s);
    }

    public String getLovName()
    {
        return getStringProperty(JdapiTypes.LOV_NAME_PTID);
    }

    public void setLovName(String s)
    {
        setStringProperty(JdapiTypes.LOV_NAME_PTID, s);
    }

    public String getLowestAllowedValue()
    {
        return getStringProperty(JdapiTypes.LOWEST_ALLOWED_VALUE_PTID);
    }

    public void setLowestAllowedValue(String s)
    {
        setStringProperty(JdapiTypes.LOWEST_ALLOWED_VALUE_PTID, s);
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
    }

    public String getNextNavigationItemName()
    {
        return getStringProperty(JdapiTypes.NEXT_NAVIGATION_ITEM_NAME_PTID);
    }

    public void setNextNavigationItemName(String s)
    {
        setStringProperty(JdapiTypes.NEXT_NAVIGATION_ITEM_NAME_PTID, s);
    }

    public String getOleClass()
    {
        return getStringProperty(JdapiTypes.OLE_CLASS_PTID);
    }

    public void setOleClass(String s)
    {
        setStringProperty(JdapiTypes.OLE_CLASS_PTID, s);
    }

    public String getOtherValues()
    {
        return getStringProperty(JdapiTypes.OTHER_VALUES_PTID);
    }

    public void setOtherValues(String s)
    {
        setStringProperty(JdapiTypes.OTHER_VALUES_PTID, s);
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

    public String getPopupMenuName()
    {
        return getStringProperty(JdapiTypes.POPUP_MENU_NAME_PTID);
    }

    public void setPopupMenuName(String s)
    {
        setStringProperty(JdapiTypes.POPUP_MENU_NAME_PTID, s);
    }

    public String getPreviousNavigationItemName()
    {
        return getStringProperty(JdapiTypes.PREVIOUS_NAVIGATION_ITEM_NAME_PTID);
    }

    public void setPreviousNavigationItemName(String s)
    {
        setStringProperty(JdapiTypes.PREVIOUS_NAVIGATION_ITEM_NAME_PTID, s);
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

    public String getQueryName()
    {
        return getStringProperty(JdapiTypes.QUERY_NAME_PTID);
    }

    public void setQueryName(String s)
    {
        setStringProperty(JdapiTypes.QUERY_NAME_PTID, s);
    }

    public String getRecordGroupName()
    {
        return getStringProperty(JdapiTypes.RECORD_GROUP_NAME_PTID);
    }

    public void setRecordGroupName(String s)
    {
        setStringProperty(JdapiTypes.RECORD_GROUP_NAME_PTID, s);
    }

    public String getRecordVisualAttributeGroupName()
    {
        return getStringProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_NAME_PTID);
    }

    public void setRecordVisualAttributeGroupName(String s)
    {
        setStringProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_NAME_PTID, s);
    }

    public String getSummaryBlockName()
    {
        return getStringProperty(JdapiTypes.SUMMARY_BLOCK_NAME_PTID);
    }

    public void setSummaryBlockName(String s)
    {
        setStringProperty(JdapiTypes.SUMMARY_BLOCK_NAME_PTID, s);
    }

    public String getSummaryItemName()
    {
        return getStringProperty(JdapiTypes.SUMMARY_ITEM_NAME_PTID);
    }

    public void setSummaryItemName(String s)
    {
        setStringProperty(JdapiTypes.SUMMARY_ITEM_NAME_PTID, s);
    }

    public String getSynchronizedItemName()
    {
        return getStringProperty(JdapiTypes.SYNCHRONIZED_ITEM_NAME_PTID);
    }

    public void setSynchronizedItemName(String s)
    {
        setStringProperty(JdapiTypes.SYNCHRONIZED_ITEM_NAME_PTID, s);
    }

    public String getTabPageName()
    {
        return getStringProperty(JdapiTypes.TABPAGE_NAME_PTID);
    }

    public void setTabPageName(String s)
    {
        setStringProperty(JdapiTypes.TABPAGE_NAME_PTID, s);
    }

    public String getTooltip()
    {
        return getStringProperty(JdapiTypes.TOOLTIP_PTID);
    }

    public void setTooltip(String s)
    {
        setStringProperty(JdapiTypes.TOOLTIP_PTID, s);
    }

    public String getTooltipVisualAttributeGroup()
    {
        return getStringProperty(JdapiTypes.TOOLTIP_VISUALATTRIBUTE_GROUP_PTID);
    }

    public void setTooltipVisualAttributeGroup(String s)
    {
        setStringProperty(JdapiTypes.TOOLTIP_VISUALATTRIBUTE_GROUP_PTID, s);
    }

    public String getTreeDataQuery()
    {
        return getStringProperty(JdapiTypes.TREE_DATA_QUERY_PTID);
    }

    public void setTreeDataQuery(String s)
    {
        setStringProperty(JdapiTypes.TREE_DATA_QUERY_PTID, s);
    }

    public String getUncheckedValue()
    {
        return getStringProperty(JdapiTypes.UNCHECKED_VALUE_PTID);
    }

    public void setUncheckedValue(String s)
    {
        setStringProperty(JdapiTypes.UNCHECKED_VALUE_PTID, s);
    }

    public String getVisualAttributeName()
    {
        return getStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID);
    }

    public void setVisualAttributeName(String s)
    {
        setStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, s);
    }

    public int getAudioChannels()
    {
        return getIntegerProperty(JdapiTypes.AUDIO_CHANNELS_PTID);
    }

    public void setAudioChannels(int i)
    {
        setIntegerProperty(JdapiTypes.AUDIO_CHANNELS_PTID, i);
    }

    public int getBevel()
    {
        return getIntegerProperty(JdapiTypes.BEVEL_PTID);
    }

    public void setBevel(int i)
    {
        setIntegerProperty(JdapiTypes.BEVEL_PTID, i);
    }

    public int getCalculateMode()
    {
        return getIntegerProperty(JdapiTypes.CALCULATE_MODE_PTID);
    }

    public void setCalculateMode(int i)
    {
        setIntegerProperty(JdapiTypes.CALCULATE_MODE_PTID, i);
    }

    public int getCaseRestriction()
    {
        return getIntegerProperty(JdapiTypes.CASE_RESTRICTION_PTID);
    }

    public void setCaseRestriction(int i)
    {
        setIntegerProperty(JdapiTypes.CASE_RESTRICTION_PTID, i);
    }

    public int getCheckBoxOtherValues()
    {
        return getIntegerProperty(JdapiTypes.CHECK_BOX_OTHER_VALUES_PTID);
    }

    public void setCheckBoxOtherValues(int i)
    {
        setIntegerProperty(JdapiTypes.CHECK_BOX_OTHER_VALUES_PTID, i);
    }

    public int getCompressionQuality()
    {
        return getIntegerProperty(JdapiTypes.COMPRESSION_QUALITY_PTID);
    }

    public void setCompressionQuality(int i)
    {
        setIntegerProperty(JdapiTypes.COMPRESSION_QUALITY_PTID, i);
    }

    public int getCommMode()
    {
        return getIntegerProperty(JdapiTypes.COMM_MODE_PTID);
    }

    public void setCommMode(int i)
    {
        setIntegerProperty(JdapiTypes.COMM_MODE_PTID, i);
    }

    public int getCompress()
    {
        return getIntegerProperty(JdapiTypes.COMPRESS_PTID);
    }

    public void setCompress(int i)
    {
        setIntegerProperty(JdapiTypes.COMPRESS_PTID, i);
    }

    public int getDataType()
    {
        return getIntegerProperty(JdapiTypes.DATA_TYPE_PTID);
    }

    public void setDataType(int i)
    {
        setIntegerProperty(JdapiTypes.DATA_TYPE_PTID, i);
    }

    public int getDataLengthSemantics()
    {
        return getIntegerProperty(JdapiTypes.DATA_LENGTH_SEMANTICS_PTID);
    }

    public void setDataLengthSemantics(int i)
    {
        setIntegerProperty(JdapiTypes.DATA_LENGTH_SEMANTICS_PTID, i);
    }

    public int getDisplayQuality()
    {
        return getIntegerProperty(JdapiTypes.DISPLAY_QUALITY_PTID);
    }

    public void setDisplayQuality(int i)
    {
        setIntegerProperty(JdapiTypes.DISPLAY_QUALITY_PTID, i);
    }

    public int getDistanceBetweenRecords()
    {
        return getIntegerProperty(JdapiTypes.DISTANCE_BETWEEN_RECORDS_PTID);
    }

    public void setDistanceBetweenRecords(int i)
    {
        setIntegerProperty(JdapiTypes.DISTANCE_BETWEEN_RECORDS_PTID, i);
    }

    public int getEditXPosition()
    {
        return getIntegerProperty(JdapiTypes.EDIT_X_POSITION_PTID);
    }

    public void setEditXPosition(int i)
    {
        setIntegerProperty(JdapiTypes.EDIT_X_POSITION_PTID, i);
    }

    public int getEditYPosition()
    {
        return getIntegerProperty(JdapiTypes.EDIT_Y_POSITION_PTID);
    }

    public void setEditYPosition(int i)
    {
        setIntegerProperty(JdapiTypes.EDIT_Y_POSITION_PTID, i);
    }

    public int getExecuteMode()
    {
        return getIntegerProperty(JdapiTypes.EXECUTE_MODE_PTID);
    }

    public void setExecuteMode(int i)
    {
        setIntegerProperty(JdapiTypes.EXECUTE_MODE_PTID, i);
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

    public int getImageDepth()
    {
        return getIntegerProperty(JdapiTypes.IMAGE_DEPTH_PTID);
    }

    public void setImageDepth(int i)
    {
        setIntegerProperty(JdapiTypes.IMAGE_DEPTH_PTID, i);
    }

    public int getImageFormat()
    {
        return getIntegerProperty(JdapiTypes.IMAGE_FORMAT_PTID);
    }

    public void setImageFormat(int i)
    {
        setIntegerProperty(JdapiTypes.IMAGE_FORMAT_PTID, i);
    }

    public int getInitializeKeyboardDirection()
    {
        return getIntegerProperty(JdapiTypes.INITIALIZE_KEYBOARD_DIRECTION_PTID);
    }

    public void setInitializeKeyboardDirection(int i)
    {
        setIntegerProperty(JdapiTypes.INITIALIZE_KEYBOARD_DIRECTION_PTID, i);
    }

    public int getItemType()
    {
        return getIntegerProperty(JdapiTypes.ITEM_TYPE_PTID);
    }

    public void setItemType(int i)
    {
        setIntegerProperty(JdapiTypes.ITEM_TYPE_PTID, i);
    }

    public int getItemsDisplay()
    {
        return getIntegerProperty(JdapiTypes.ITEMS_DISPLAY_PTID);
    }

    public void setItemsDisplay(int i)
    {
        setIntegerProperty(JdapiTypes.ITEMS_DISPLAY_PTID, i);
    }

    public int getJustification()
    {
        return getIntegerProperty(JdapiTypes.JUSTIFICATION_PTID);
    }

    public void setJustification(int i)
    {
        setIntegerProperty(JdapiTypes.JUSTIFICATION_PTID, i);
    }

    public int getKeyboardState()
    {
        return getIntegerProperty(JdapiTypes.KEYBOARD_STATE_PTID);
    }

    public void setKeyboardState(int i)
    {
        setIntegerProperty(JdapiTypes.KEYBOARD_STATE_PTID, i);
    }

    public int getLanguageDirection()
    {
        return getIntegerProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID);
    }

    public void setLanguageDirection(int i)
    {
        setIntegerProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, i);
    }

    public int getLovXPosition()
    {
        return getIntegerProperty(JdapiTypes.LOV_X_POSITION_PTID);
    }

    public void setLovXPosition(int i)
    {
        setIntegerProperty(JdapiTypes.LOV_X_POSITION_PTID, i);
    }

    public int getLovYPosition()
    {
        return getIntegerProperty(JdapiTypes.LOV_Y_POSITION_PTID);
    }

    public void setLovYPosition(int i)
    {
        setIntegerProperty(JdapiTypes.LOV_Y_POSITION_PTID, i);
    }

    public int getListElementCount()
    {
        return getIntegerProperty(JdapiTypes.LIST_ELEMENT_COUNT_PTID);
    }

    public int getListStyle()
    {
        return getIntegerProperty(JdapiTypes.LIST_STYLE_PTID);
    }

    public void setListStyle(int i)
    {
        setIntegerProperty(JdapiTypes.LIST_STYLE_PTID, i);
    }

    public int getMaximumLength()
    {
        return getIntegerProperty(JdapiTypes.MAXIMUM_LENGTH_PTID);
    }

    public void setMaximumLength(int i)
    {
        setIntegerProperty(JdapiTypes.MAXIMUM_LENGTH_PTID, i);
    }

    public int getOleActionStyle()
    {
        return getIntegerProperty(JdapiTypes.OLE_ACTION_STYLE_PTID);
    }

    public void setOleActionStyle(int i)
    {
        setIntegerProperty(JdapiTypes.OLE_ACTION_STYLE_PTID, i);
    }

    public int getOlePopupMenuItems()
    {
        return getIntegerProperty(JdapiTypes.OLE_POPUP_MENU_ITEMS_PTID);
    }

    public void setOlePopupMenuItems(int i)
    {
        setIntegerProperty(JdapiTypes.OLE_POPUP_MENU_ITEMS_PTID, i);
    }

    public int getOleResizStyle()
    {
        return getIntegerProperty(JdapiTypes.OLE_RESIZ_STYLE_PTID);
    }

    public void setOleResizStyle(int i)
    {
        setIntegerProperty(JdapiTypes.OLE_RESIZ_STYLE_PTID, i);
    }

    public int getOleTenantTypeAspect()
    {
        return getIntegerProperty(JdapiTypes.OLE_TENANTTYPE_ASPECT_PTID);
    }

    public void setOleTenantTypeAspect(int i)
    {
        setIntegerProperty(JdapiTypes.OLE_TENANTTYPE_ASPECT_PTID, i);
    }

    public int getOleTenantTypeType()
    {
        return getIntegerProperty(JdapiTypes.OLE_TENANTTYPE_TYPE_PTID);
    }

    public void setOleTenantTypeType(int i)
    {
        setIntegerProperty(JdapiTypes.OLE_TENANTTYPE_TYPE_PTID, i);
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

    public int getQueryLength()
    {
        return getIntegerProperty(JdapiTypes.QUERY_LENGTH_PTID);
    }

    public void setQueryLength(int i)
    {
        setIntegerProperty(JdapiTypes.QUERY_LENGTH_PTID, i);
    }

    public int getReadingOrder()
    {
        return getIntegerProperty(JdapiTypes.READING_ORDER_PTID);
    }

    public void setReadingOrder(int i)
    {
        setIntegerProperty(JdapiTypes.READING_ORDER_PTID, i);
    }

    public int getSizingStyle()
    {
        return getIntegerProperty(JdapiTypes.SIZING_STYLE_PTID);
    }

    public void setSizingStyle(int i)
    {
        setIntegerProperty(JdapiTypes.SIZING_STYLE_PTID, i);
    }

    public int getSoundFormat()
    {
        return getIntegerProperty(JdapiTypes.SOUND_FORMAT_PTID);
    }

    public void setSoundFormat(int i)
    {
        setIntegerProperty(JdapiTypes.SOUND_FORMAT_PTID, i);
    }

    public int getSoundQuality()
    {
        return getIntegerProperty(JdapiTypes.SOUND_QUALITY_PTID);
    }

    public void setSoundQuality(int i)
    {
        setIntegerProperty(JdapiTypes.SOUND_QUALITY_PTID, i);
    }

    public int getSummaryFunction()
    {
        return getIntegerProperty(JdapiTypes.SUMMARY_FUNCTION_PTID);
    }

    public void setSummaryFunction(int i)
    {
        setIntegerProperty(JdapiTypes.SUMMARY_FUNCTION_PTID, i);
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

    public boolean isAutoHint()
    {
        return getBooleanProperty(JdapiTypes.AUTO_HINT_PTID);
    }

    public void setAutoHint(boolean flag)
    {
        setBooleanProperty(JdapiTypes.AUTO_HINT_PTID, flag);
    }

    public boolean isAutoSkip()
    {
        return getBooleanProperty(JdapiTypes.AUTO_SKIP_PTID);
    }

    public void setAutoSkip(boolean flag)
    {
        setBooleanProperty(JdapiTypes.AUTO_SKIP_PTID, flag);
    }

    public boolean isCaseInsensitiveQuery()
    {
        return getBooleanProperty(JdapiTypes.CASE_INSENSITIVE_QUERY_PTID);
    }

    public void setCaseInsensitiveQuery(boolean flag)
    {
        setBooleanProperty(JdapiTypes.CASE_INSENSITIVE_QUERY_PTID, flag);
    }

    public boolean isConcealData()
    {
        return getBooleanProperty(JdapiTypes.CONCEAL_DATA_PTID);
    }

    public void setConcealData(boolean flag)
    {
        setBooleanProperty(JdapiTypes.CONCEAL_DATA_PTID, flag);
    }

    public boolean isDatabaseItem()
    {
        return getBooleanProperty(JdapiTypes.DATABASE_ITEM_PTID);
    }

    public void setDatabaseItem(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DATABASE_ITEM_PTID, flag);
    }

    public boolean isDefaultButton()
    {
        return getBooleanProperty(JdapiTypes.DEFAULT_BUTTON_PTID);
    }

    public void setDefaultButton(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DEFAULT_BUTTON_PTID, flag);
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

    public boolean isFixedLength()
    {
        return getBooleanProperty(JdapiTypes.FIXED_LENGTH_PTID);
    }

    public void setFixedLength(boolean flag)
    {
        setBooleanProperty(JdapiTypes.FIXED_LENGTH_PTID, flag);
    }

    public boolean isIconic()
    {
        return getBooleanProperty(JdapiTypes.ICONIC_PTID);
    }

    public void setIconic(boolean flag)
    {
        setBooleanProperty(JdapiTypes.ICONIC_PTID, flag);
    }

    public boolean isInsertAllowed()
    {
        return getBooleanProperty(JdapiTypes.INSERT_ALLOWED_PTID);
    }

    public void setInsertAllowed(boolean flag)
    {
        setBooleanProperty(JdapiTypes.INSERT_ALLOWED_PTID, flag);
    }

    public boolean isKeyboardNavigable()
    {
        return getBooleanProperty(JdapiTypes.KEYBOARD_NAVIGABLE_PTID);
    }

    public void setKeyboardNavigable(boolean flag)
    {
        setBooleanProperty(JdapiTypes.KEYBOARD_NAVIGABLE_PTID, flag);
    }

    public boolean isKeepCursorPosition()
    {
        return getBooleanProperty(JdapiTypes.KEEP_CURSOR_POSITION_PTID);
    }

    public void setKeepCursorPosition(boolean flag)
    {
        setBooleanProperty(JdapiTypes.KEEP_CURSOR_POSITION_PTID, flag);
    }

    public boolean isLockRecord()
    {
        return getBooleanProperty(JdapiTypes.LOCK_RECORD_PTID);
    }

    public void setLockRecord(boolean flag)
    {
        setBooleanProperty(JdapiTypes.LOCK_RECORD_PTID, flag);
    }

    public boolean isMultiLine()
    {
        return getBooleanProperty(JdapiTypes.MULTI_LINE_PTID);
    }

    public void setMultiLine(boolean flag)
    {
        setBooleanProperty(JdapiTypes.MULTI_LINE_PTID, flag);
    }

    public boolean isMouseNavigate()
    {
        return getBooleanProperty(JdapiTypes.MOUSE_NAVIGATE_PTID);
    }

    public void setMouseNavigate(boolean flag)
    {
        setBooleanProperty(JdapiTypes.MOUSE_NAVIGATE_PTID, flag);
    }

    public boolean isOleInPlaceAction()
    {
        return getBooleanProperty(JdapiTypes.OLE_IN_PLACE_ACTION_PTID);
    }

    public void setOleInPlaceAction(boolean flag)
    {
        setBooleanProperty(JdapiTypes.OLE_IN_PLACE_ACTION_PTID, flag);
    }

    public boolean isOleInsideOutSupport()
    {
        return getBooleanProperty(JdapiTypes.OLE_INSIDE_OUT_SUPPORT_PTID);
    }

    public void setOleInsideOutSupport(boolean flag)
    {
        setBooleanProperty(JdapiTypes.OLE_INSIDE_OUT_SUPPORT_PTID, flag);
    }

    public boolean isOleShowPopupMenu()
    {
        return getBooleanProperty(JdapiTypes.OLE_SHOW_POPUP_MENU_PTID);
    }

    public void setOleShowPopupMenu(boolean flag)
    {
        setBooleanProperty(JdapiTypes.OLE_SHOW_POPUP_MENU_PTID, flag);
    }

    public boolean isOleShowTenantTypeType()
    {
        return getBooleanProperty(JdapiTypes.OLE_SHOW_TENANTTYPE_TYPE_PTID);
    }

    public void setOleShowTenantTypeType(boolean flag)
    {
        setBooleanProperty(JdapiTypes.OLE_SHOW_TENANTTYPE_TYPE_PTID, flag);
    }

    public boolean isPrimaryKey()
    {
        return getBooleanProperty(JdapiTypes.PRIMARY_KEY_PTID);
    }

    public void setPrimaryKey(boolean flag)
    {
        setBooleanProperty(JdapiTypes.PRIMARY_KEY_PTID, flag);
    }

    public boolean isQueryAllowed()
    {
        return getBooleanProperty(JdapiTypes.QUERY_ALLOWED_PTID);
    }

    public void setQueryAllowed(boolean flag)
    {
        setBooleanProperty(JdapiTypes.QUERY_ALLOWED_PTID, flag);
    }

    public boolean isQueryOnly()
    {
        return getBooleanProperty(JdapiTypes.QUERY_ONLY_PTID);
    }

    public void setQueryOnly(boolean flag)
    {
        setBooleanProperty(JdapiTypes.QUERY_ONLY_PTID, flag);
    }

    public boolean isRendered()
    {
        return getBooleanProperty(JdapiTypes.RENDERED_PTID);
    }

    public void setRendered(boolean flag)
    {
        setBooleanProperty(JdapiTypes.RENDERED_PTID, flag);
    }

    public boolean isRequired()
    {
        return getBooleanProperty(JdapiTypes.REQUIRED_PTID);
    }

    public void setRequired(boolean flag)
    {
        setBooleanProperty(JdapiTypes.REQUIRED_PTID, flag);
    }

    public boolean isShowFastForward()
    {
        return getBooleanProperty(JdapiTypes.SHOW_FAST_FORWARD_PTID);
    }

    public void setShowFastForward(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_FAST_FORWARD_PTID, flag);
    }

    public boolean isShowHorizontalScrollbar()
    {
        return getBooleanProperty(JdapiTypes.SHOW_HORIZONTAL_SCROLLBAR_PTID);
    }

    public void setShowHorizontalScrollbar(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_HORIZONTAL_SCROLLBAR_PTID, flag);
    }

    public boolean isShowPlay()
    {
        return getBooleanProperty(JdapiTypes.SHOW_PLAY_PTID);
    }

    public void setShowPlay(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_PLAY_PTID, flag);
    }

    public boolean isShowRecord()
    {
        return getBooleanProperty(JdapiTypes.SHOW_RECORD_PTID);
    }

    public void setShowRecord(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_RECORD_PTID, flag);
    }

    public boolean isShowRewind()
    {
        return getBooleanProperty(JdapiTypes.SHOW_REWIND_PTID);
    }

    public void setShowRewind(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_REWIND_PTID, flag);
    }

    public boolean isShowSlider()
    {
        return getBooleanProperty(JdapiTypes.SHOW_SLIDER_PTID);
    }

    public void setShowSlider(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_SLIDER_PTID, flag);
    }

    public boolean isShowTime()
    {
        return getBooleanProperty(JdapiTypes.SHOW_TIME_PTID);
    }

    public void setShowTime(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_TIME_PTID, flag);
    }

    public boolean isShowVerticalScrollbar()
    {
        return getBooleanProperty(JdapiTypes.SHOW_VERTICAL_SCROLLBAR_PTID);
    }

    public void setShowVerticalScrollbar(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_VERTICAL_SCROLLBAR_PTID, flag);
    }

    public boolean isShowVolume()
    {
        return getBooleanProperty(JdapiTypes.SHOW_VOLUME_PTID);
    }

    public void setShowVolume(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_VOLUME_PTID, flag);
    }

    public boolean isSubclassSubObject()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID);
    }

    public void setSubclassSubObject(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, flag);
    }

    public boolean isTreeAllowEmpBranch()
    {
        return getBooleanProperty(JdapiTypes.TREE_ALLOW_EMP_BRANCH_PTID);
    }

    public void setTreeAllowEmpBranch(boolean flag)
    {
        setBooleanProperty(JdapiTypes.TREE_ALLOW_EMP_BRANCH_PTID, flag);
    }

    public boolean isTreeMultiSelect()
    {
        return getBooleanProperty(JdapiTypes.TREE_MULTI_SELECT_PTID);
    }

    public void setTreeMultiSelect(boolean flag)
    {
        setBooleanProperty(JdapiTypes.TREE_MULTI_SELECT_PTID, flag);
    }

    public boolean isTreeShowLines()
    {
        return getBooleanProperty(JdapiTypes.TREE_SHOW_LINES_PTID);
    }

    public void setTreeShowLines(boolean flag)
    {
        setBooleanProperty(JdapiTypes.TREE_SHOW_LINES_PTID, flag);
    }

    public boolean isTreeShowSymbol()
    {
        return getBooleanProperty(JdapiTypes.TREE_SHOW_SYMBOL_PTID);
    }

    public void setTreeShowSymbol(boolean flag)
    {
        setBooleanProperty(JdapiTypes.TREE_SHOW_SYMBOL_PTID, flag);
    }

    public boolean isUpdateAllowed()
    {
        return getBooleanProperty(JdapiTypes.UPDATE_ALLOWED_PTID);
    }

    public void setUpdateAllowed(boolean flag)
    {
        setBooleanProperty(JdapiTypes.UPDATE_ALLOWED_PTID, flag);
    }

    public boolean isUpdateCommit()
    {
        return getBooleanProperty(JdapiTypes.UPDATE_COMMIT_PTID);
    }

    public void setUpdateCommit(boolean flag)
    {
        setBooleanProperty(JdapiTypes.UPDATE_COMMIT_PTID, flag);
    }

    public boolean isUpdateIfNull()
    {
        return getBooleanProperty(JdapiTypes.UPDATE_IF_NULL_PTID);
    }

    public void setUpdateIfNull(boolean flag)
    {
        setBooleanProperty(JdapiTypes.UPDATE_IF_NULL_PTID, flag);
    }

    public boolean isUpdateQuery()
    {
        return getBooleanProperty(JdapiTypes.UPDATE_QUERY_PTID);
    }

    public void setUpdateQuery(boolean flag)
    {
        setBooleanProperty(JdapiTypes.UPDATE_QUERY_PTID, flag);
    }

    public boolean isValidateFromList()
    {
        return getBooleanProperty(JdapiTypes.VALIDATE_FROM_LIST_PTID);
    }

    public void setValidateFromList(boolean flag)
    {
        setBooleanProperty(JdapiTypes.VALIDATE_FROM_LIST_PTID, flag);
    }

    public boolean isVisible()
    {
        return getBooleanProperty(JdapiTypes.VISIBLE_PTID);
    }

    public void setVisible(boolean flag)
    {
        setBooleanProperty(JdapiTypes.VISIBLE_PTID, flag);
    }

    public Canvas getCanvasObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (Canvas)getObjectProperty(JdapiTypes.CANVAS_OBJECT_PTID);
    }

    public void setCanvasObject(Canvas canvas)
    {
        setObjectProperty(JdapiTypes.CANVAS_OBJECT_PTID, canvas);
    }

    public Editor getEditObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (Editor)getObjectProperty(JdapiTypes.EDIT_OBJECT_PTID);
    }

    public void setEditObject(Editor editor)
    {
        setObjectProperty(JdapiTypes.EDIT_OBJECT_PTID, editor);
    }

    public LOV getLovObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (LOV)getObjectProperty(JdapiTypes.LOV_OBJECT_PTID);
    }

    public void setLovObject(LOV lov)
    {
        setObjectProperty(JdapiTypes.LOV_OBJECT_PTID, lov);
    }

    public JdapiObject getModule()
    {
        return getObjectProperty(JdapiTypes.MODULE_PTID);
    }

    public Item getNextNavigationItemObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (Item)getObjectProperty(JdapiTypes.NEXT_NAVIGATION_ITEM_OBJECT_PTID);
    }

    public void setNextNavigationItemObject(Item item)
    {
        setObjectProperty(JdapiTypes.NEXT_NAVIGATION_ITEM_OBJECT_PTID, item);
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

    public VisualAttribute getPopupVisualAttributeObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (VisualAttribute)getObjectProperty(JdapiTypes.POPUP_VISUALATTRIBUTE_OBJECT_PTID);
    }

    public void setPopupVisualAttributeObject(VisualAttribute visualattribute)
    {
        setObjectProperty(JdapiTypes.POPUP_VISUALATTRIBUTE_OBJECT_PTID, visualattribute);
    }

    public Item getPreviousNavigationItemObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (Item)getObjectProperty(JdapiTypes.PREVIOUS_NAVIGATION_ITEM_OBJECT_PTID);
    }

    public void setPreviousNavigationItemObject(Item item)
    {
        setObjectProperty(JdapiTypes.PREVIOUS_NAVIGATION_ITEM_OBJECT_PTID, item);
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

    public JdapiIterator getRadioButtons()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.RADIO_BUTTON_PTID, JdapiTypes.RADIO_BUTTON_OTID);
    }

    public RecordGroup getRecordGroupObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (RecordGroup)getObjectProperty(JdapiTypes.RECORD_GROUP_OBJECT_PTID);
    }

    public void setRecordGroupObject(RecordGroup recordgroup)
    {
        setObjectProperty(JdapiTypes.RECORD_GROUP_OBJECT_PTID, recordgroup);
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

    public JdapiObject getSource()
    {
        return getObjectProperty(JdapiTypes.SOURCE_PTID);
    }

    public Item getSynchronizedItemObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (Item)getObjectProperty(JdapiTypes.SYNCHRONIZED_ITEM_OBJECT_PTID);
    }

    public void setSynchronizedItemObject(Item item)
    {
        setObjectProperty(JdapiTypes.SYNCHRONIZED_ITEM_OBJECT_PTID, item);
    }

    public TabPage getTabPageObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (TabPage)getObjectProperty(JdapiTypes.TABPAGE_OBJECT_PTID);
    }

    public void setTabPageObject(TabPage tabpage)
    {
        setObjectProperty(JdapiTypes.TABPAGE_OBJECT_PTID, tabpage);
    }

    public JdapiIterator getTriggers()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.TRIGGER_PTID, JdapiTypes.TRIGGER_OTID);
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
        s_foType = JdapiTypes.ITEM_OTID;
    }
}
