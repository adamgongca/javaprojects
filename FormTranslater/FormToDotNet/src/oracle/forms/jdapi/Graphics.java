// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, JdapiException, JdapiObjectListIterator, VisualAttribute, 
//            TabPage, Jdapi, BaseAPI, JdapiTypes, 
//            Canvas, PropertyClass, ObjectLibrary, ObjectLibraryTab, 
//            JdapiIterator, JdapiObject

public class Graphics extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public Graphics(Canvas canvas, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), canvas.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Graphics(Canvas canvas, String s, Graphics g)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), canvas.getObjectPointer(), s_foType, s, 0L, g.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Graphics(Canvas canvas, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), canvas.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Graphics(Graphics g, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), g.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Graphics(Graphics g, String s, Graphics g1)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), g.getObjectPointer(), s_foType, s, 0L, g1.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Graphics(Graphics g, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), g.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Graphics(TabPage tabpage, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), tabpage.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Graphics(TabPage tabpage, String s, Graphics g)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), tabpage.getObjectPointer(), s_foType, s, 0L, g.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Graphics(TabPage tabpage, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), tabpage.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Graphics(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), 0L);
        Jdapi.addObject(this);
    }

    public Graphics(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, Graphics g)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), g.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Graphics(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected Graphics(long l)
    {
        super(l);
    }

    public Graphics clone(Canvas canvas, String s)
    {
        return (Graphics)super.clone(canvas, s);
    }

    public Graphics clone(Graphics g, String s)
    {
        return (Graphics)super.clone(g, s);
    }

    public Graphics clone(TabPage tabpage, String s)
    {
        return (Graphics)super.clone(tabpage, s);
    }

    public Graphics clone(ObjectLibraryTab objectlibrarytab, String s)
    {
        return (Graphics)super.clone(objectlibrarytab, s);
    }

    public static Graphics find(Canvas canvas, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), canvas.getObjectPointer(), s, s_foType);
        Graphics g = null;
        if(l1 != 0L)
            g = (Graphics)Jdapi.getObject(l1);
        return g;
    }

    public static Graphics find(Graphics g, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), g.getObjectPointer(), s, s_foType);
        Graphics g1 = null;
        if(l1 != 0L)
            g1 = (Graphics)Jdapi.getObject(l1);
        return g1;
    }

    public static Graphics find(TabPage tabpage, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), tabpage.getObjectPointer(), s, s_foType);
        Graphics g = null;
        if(l1 != 0L)
            g = (Graphics)Jdapi.getObject(l1);
        return g;
    }

    public static Graphics find(ObjectLibraryTab objectlibrarytab, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s, s_foType);
        Graphics g = null;
        if(l1 != 0L)
            g = (Graphics)Jdapi.getObject(l1);
        return g;
    }

    public void importImage(String s, int i)
    {
        BaseAPI._jni_gra_import_image(Jdapi.getContextPointer(), super.m_pd2fob, s, i);
    }

    public void exportImage(String s)
    {
        BaseAPI._jni_gra_export_image(Jdapi.getContextPointer(), super.m_pd2fob, s);
    }

    public String getBackColor()
    {
        return getStringProperty(JdapiTypes.BACK_COLOR_PTID);
    }

    public void setBackColor(String s)
    {
        setStringProperty(JdapiTypes.BACK_COLOR_PTID, s);
    }

    public String getEdgeBackColor()
    {
        return getStringProperty(JdapiTypes.EDGE_BACK_COLOR_PTID);
    }

    public void setEdgeBackColor(String s)
    {
        setStringProperty(JdapiTypes.EDGE_BACK_COLOR_PTID, s);
    }

    public String getEdgeForegroundColor()
    {
        return getStringProperty(JdapiTypes.EDGE_FOREGROUND_COLOR_PTID);
    }

    public void setEdgeForegroundColor(String s)
    {
        setStringProperty(JdapiTypes.EDGE_FOREGROUND_COLOR_PTID, s);
    }

    public String getEdgePattern()
    {
        return getStringProperty(JdapiTypes.EDGE_PATTERN_PTID);
    }

    public void setEdgePattern(String s)
    {
        setStringProperty(JdapiTypes.EDGE_PATTERN_PTID, s);
    }

    public String getFillPattern()
    {
        return getStringProperty(JdapiTypes.FILL_PATTERN_PTID);
    }

    public void setFillPattern(String s)
    {
        setStringProperty(JdapiTypes.FILL_PATTERN_PTID, s);
    }

    public String getForegroundColor()
    {
        return getStringProperty(JdapiTypes.FOREGROUND_COLOR_PTID);
    }

    public void setForegroundColor(String s)
    {
        setStringProperty(JdapiTypes.FOREGROUND_COLOR_PTID, s);
    }

    public String getFrameTitle()
    {
        return getStringProperty(JdapiTypes.FRAME_TITLE_PTID);
    }

    public void setFrameTitle(String s)
    {
        setStringProperty(JdapiTypes.FRAME_TITLE_PTID, s);
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

    public String getFrameTitleVisualAttributeName()
    {
        return getStringProperty(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_NAME_PTID);
    }

    public void setFrameTitleVisualAttributeName(String s)
    {
        setStringProperty(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_NAME_PTID, s);
    }

    public String getGraphicsFontColor()
    {
        return getStringProperty(JdapiTypes.GRAPHICS_FONT_COLOR_PTID);
    }

    public void setGraphicsFontColor(String s)
    {
        setStringProperty(JdapiTypes.GRAPHICS_FONT_COLOR_PTID, s);
    }

    public String getGraphicsFontName()
    {
        return getStringProperty(JdapiTypes.GRAPHICS_FONT_NAME_PTID);
    }

    public void setGraphicsFontName(String s)
    {
        setStringProperty(JdapiTypes.GRAPHICS_FONT_NAME_PTID, s);
    }

    public String getGraphicsText()
    {
        return getStringProperty(JdapiTypes.GRAPHICS_TEXT_PTID);
    }

    public void setGraphicsText(String s)
    {
        setStringProperty(JdapiTypes.GRAPHICS_TEXT_PTID, s);
    }

    public String getLayoutDataBlockName()
    {
        return getStringProperty(JdapiTypes.LAYOUT_DATA_BLOCK_NAME_PTID);
    }

    public void setLayoutDataBlockName(String s)
    {
        setStringProperty(JdapiTypes.LAYOUT_DATA_BLOCK_NAME_PTID, s);
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

    public String getTabPageName()
    {
        return getStringProperty(JdapiTypes.TABPAGE_NAME_PTID);
    }

    public void setTabPageName(String s)
    {
        setStringProperty(JdapiTypes.TABPAGE_NAME_PTID, s);
    }

    public String getVisualAttributeName()
    {
        return getStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID);
    }

    public void setVisualAttributeName(String s)
    {
        setStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, s);
    }

    public int getArrowStyle()
    {
        return getIntegerProperty(JdapiTypes.ARROW_STYLE_PTID);
    }

    public void setArrowStyle(int i)
    {
        setIntegerProperty(JdapiTypes.ARROW_STYLE_PTID, i);
    }

    public int getBevel()
    {
        return getIntegerProperty(JdapiTypes.BEVEL_PTID);
    }

    public void setBevel(int i)
    {
        setIntegerProperty(JdapiTypes.BEVEL_PTID, i);
    }

    public int getCapStyle()
    {
        return getIntegerProperty(JdapiTypes.CAP_STYLE_PTID);
    }

    public void setCapStyle(int i)
    {
        setIntegerProperty(JdapiTypes.CAP_STYLE_PTID, i);
    }

    public int getClipHeight()
    {
        return getIntegerProperty(JdapiTypes.CLIP_HEIGHT_PTID);
    }

    public void setClipHeight(int i)
    {
        setIntegerProperty(JdapiTypes.CLIP_HEIGHT_PTID, i);
    }

    public int getClipWidth()
    {
        return getIntegerProperty(JdapiTypes.CLIP_WIDTH_PTID);
    }

    public void setClipWidth(int i)
    {
        setIntegerProperty(JdapiTypes.CLIP_WIDTH_PTID, i);
    }

    public int getClipXPosition()
    {
        return getIntegerProperty(JdapiTypes.CLIP_X_POSITION_PTID);
    }

    public void setClipXPosition(int i)
    {
        setIntegerProperty(JdapiTypes.CLIP_X_POSITION_PTID, i);
    }

    public int getClipYPosition()
    {
        return getIntegerProperty(JdapiTypes.CLIP_Y_POSITION_PTID);
    }

    public void setClipYPosition(int i)
    {
        setIntegerProperty(JdapiTypes.CLIP_Y_POSITION_PTID, i);
    }

    public int getCornerRadiusX()
    {
        return getIntegerProperty(JdapiTypes.CORNER_RADIUS_X_PTID);
    }

    public void setCornerRadiusX(int i)
    {
        setIntegerProperty(JdapiTypes.CORNER_RADIUS_X_PTID, i);
    }

    public int getCornerRadiusY()
    {
        return getIntegerProperty(JdapiTypes.CORNER_RADIUS_Y_PTID);
    }

    public void setCornerRadiusY(int i)
    {
        setIntegerProperty(JdapiTypes.CORNER_RADIUS_Y_PTID, i);
    }

    public int getCustomSpacing()
    {
        return getIntegerProperty(JdapiTypes.CUSTOM_SPACING_PTID);
    }

    public void setCustomSpacing(int i)
    {
        setIntegerProperty(JdapiTypes.CUSTOM_SPACING_PTID, i);
    }

    public int getDashStyle()
    {
        return getIntegerProperty(JdapiTypes.DASH_STYLE_PTID);
    }

    public void setDashStyle(int i)
    {
        setIntegerProperty(JdapiTypes.DASH_STYLE_PTID, i);
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

    public int getFrameAlign()
    {
        return getIntegerProperty(JdapiTypes.FRAME_ALIGN_PTID);
    }

    public void setFrameAlign(int i)
    {
        setIntegerProperty(JdapiTypes.FRAME_ALIGN_PTID, i);
    }

    public int getFrameTitleAlign()
    {
        return getIntegerProperty(JdapiTypes.FRAME_TITLE_ALIGN_PTID);
    }

    public void setFrameTitleAlign(int i)
    {
        setIntegerProperty(JdapiTypes.FRAME_TITLE_ALIGN_PTID, i);
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

    public int getFrameTitleOffset()
    {
        return getIntegerProperty(JdapiTypes.FRAME_TITLE_OFFSET_PTID);
    }

    public void setFrameTitleOffset(int i)
    {
        setIntegerProperty(JdapiTypes.FRAME_TITLE_OFFSET_PTID, i);
    }

    public int getFrameTitleSpacing()
    {
        return getIntegerProperty(JdapiTypes.FRAME_TITLE_SPACING_PTID);
    }

    public void setFrameTitleSpacing(int i)
    {
        setIntegerProperty(JdapiTypes.FRAME_TITLE_SPACING_PTID, i);
    }

    public int getGraphicsFontColorCode()
    {
        return getIntegerProperty(JdapiTypes.GRAPHICS_FONT_COLOR_CODE_PTID);
    }

    public void setGraphicsFontColorCode(int i)
    {
        setIntegerProperty(JdapiTypes.GRAPHICS_FONT_COLOR_CODE_PTID, i);
    }

    public int getGraphicsFontSize()
    {
        return getIntegerProperty(JdapiTypes.GRAPHICS_FONT_SIZE_PTID);
    }

    public void setGraphicsFontSize(int i)
    {
        setIntegerProperty(JdapiTypes.GRAPHICS_FONT_SIZE_PTID, i);
    }

    public int getGraphicsFontSpacing()
    {
        return getIntegerProperty(JdapiTypes.GRAPHICS_FONT_SPACING_PTID);
    }

    public void setGraphicsFontSpacing(int i)
    {
        setIntegerProperty(JdapiTypes.GRAPHICS_FONT_SPACING_PTID, i);
    }

    public int getGraphicsFontStyle()
    {
        return getIntegerProperty(JdapiTypes.GRAPHICS_FONT_STYLE_PTID);
    }

    public void setGraphicsFontStyle(int i)
    {
        setIntegerProperty(JdapiTypes.GRAPHICS_FONT_STYLE_PTID, i);
    }

    public int getGraphicsFontWeight()
    {
        return getIntegerProperty(JdapiTypes.GRAPHICS_FONT_WEIGHT_PTID);
    }

    public void setGraphicsFontWeight(int i)
    {
        setIntegerProperty(JdapiTypes.GRAPHICS_FONT_WEIGHT_PTID, i);
    }

    public int getGraphicsType()
    {
        return getIntegerProperty(JdapiTypes.GRAPHICS_TYPE_PTID);
    }

    public void setGraphicsType(int i)
    {
        setIntegerProperty(JdapiTypes.GRAPHICS_TYPE_PTID, i);
    }

    public int getHeight()
    {
        return getIntegerProperty(JdapiTypes.HEIGHT_PTID);
    }

    public void setHeight(int i)
    {
        setIntegerProperty(JdapiTypes.HEIGHT_PTID, i);
    }

    public int getHorizontalJustification()
    {
        return getIntegerProperty(JdapiTypes.HORIZONTAL_JUSTIFICATION_PTID);
    }

    public void setHorizontalJustification(int i)
    {
        setIntegerProperty(JdapiTypes.HORIZONTAL_JUSTIFICATION_PTID, i);
    }

    public int getHorizontalMargin()
    {
        return getIntegerProperty(JdapiTypes.HORIZONTAL_MARGIN_PTID);
    }

    public void setHorizontalMargin(int i)
    {
        setIntegerProperty(JdapiTypes.HORIZONTAL_MARGIN_PTID, i);
    }

    public int getHorizontalObjectOffset()
    {
        return getIntegerProperty(JdapiTypes.HORIZONTAL_OBJECT_OFFSET_PTID);
    }

    public void setHorizontalObjectOffset(int i)
    {
        setIntegerProperty(JdapiTypes.HORIZONTAL_OBJECT_OFFSET_PTID, i);
    }

    public int getHorizontalOrigin()
    {
        return getIntegerProperty(JdapiTypes.HORIZONTAL_ORIGIN_PTID);
    }

    public void setHorizontalOrigin(int i)
    {
        setIntegerProperty(JdapiTypes.HORIZONTAL_ORIGIN_PTID, i);
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

    public int getInternalEndAngle()
    {
        return getIntegerProperty(JdapiTypes.INTERNAL_END_ANGLE_PTID);
    }

    public void setInternalEndAngle(int i)
    {
        setIntegerProperty(JdapiTypes.INTERNAL_END_ANGLE_PTID, i);
    }

    public int getInternalLineWidth()
    {
        return getIntegerProperty(JdapiTypes.INTERNAL_LINE_WIDTH_PTID);
    }

    public void setInternalLineWidth(int i)
    {
        setIntegerProperty(JdapiTypes.INTERNAL_LINE_WIDTH_PTID, i);
    }

    public int getInternalRotationAngle()
    {
        return getIntegerProperty(JdapiTypes.INTERNAL_ROTATION_ANGLE_PTID);
    }

    public void setInternalRotationAngle(int i)
    {
        setIntegerProperty(JdapiTypes.INTERNAL_ROTATION_ANGLE_PTID, i);
    }

    public int getInternalStartAngle()
    {
        return getIntegerProperty(JdapiTypes.INTERNAL_START_ANGLE_PTID);
    }

    public void setInternalStartAngle(int i)
    {
        setIntegerProperty(JdapiTypes.INTERNAL_START_ANGLE_PTID, i);
    }

    public int getJoinStyle()
    {
        return getIntegerProperty(JdapiTypes.JOIN_STYLE_PTID);
    }

    public void setJoinStyle(int i)
    {
        setIntegerProperty(JdapiTypes.JOIN_STYLE_PTID, i);
    }

    public int getLanguageDirection()
    {
        return getIntegerProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID);
    }

    public void setLanguageDirection(int i)
    {
        setIntegerProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, i);
    }

    public int getLayoutStyle()
    {
        return getIntegerProperty(JdapiTypes.LAYOUT_STYLE_PTID);
    }

    public void setLayoutStyle(int i)
    {
        setIntegerProperty(JdapiTypes.LAYOUT_STYLE_PTID, i);
    }

    public int getLineSpacing()
    {
        return getIntegerProperty(JdapiTypes.LINE_SPACING_PTID);
    }

    public void setLineSpacing(int i)
    {
        setIntegerProperty(JdapiTypes.LINE_SPACING_PTID, i);
    }

    public int getMaximumObjs()
    {
        return getIntegerProperty(JdapiTypes.MAXIMUM_OBJS_PTID);
    }

    public void setMaximumObjs(int i)
    {
        setIntegerProperty(JdapiTypes.MAXIMUM_OBJS_PTID, i);
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

    public int getRecordsDisplayCount()
    {
        return getIntegerProperty(JdapiTypes.RECORDS_DISPLAY_COUNT_PTID);
    }

    public void setRecordsDisplayCount(int i)
    {
        setIntegerProperty(JdapiTypes.RECORDS_DISPLAY_COUNT_PTID, i);
    }

    public int getScrollbarAlign()
    {
        return getIntegerProperty(JdapiTypes.SCROLLBAR_ALIGN_PTID);
    }

    public void setScrollbarAlign(int i)
    {
        setIntegerProperty(JdapiTypes.SCROLLBAR_ALIGN_PTID, i);
    }

    public int getScrollbarWidth()
    {
        return getIntegerProperty(JdapiTypes.SCROLLBAR_WIDTH_PTID);
    }

    public void setScrollbarWidth(int i)
    {
        setIntegerProperty(JdapiTypes.SCROLLBAR_WIDTH_PTID, i);
    }

    public int getSingleObjectAlign()
    {
        return getIntegerProperty(JdapiTypes.SINGLE_OBJECT_ALIGN_PTID);
    }

    public void setSingleObjectAlign(int i)
    {
        setIntegerProperty(JdapiTypes.SINGLE_OBJECT_ALIGN_PTID, i);
    }

    public int getStartPromptAlign()
    {
        return getIntegerProperty(JdapiTypes.START_PROMPT_ALIGN_PTID);
    }

    public void setStartPromptAlign(int i)
    {
        setIntegerProperty(JdapiTypes.START_PROMPT_ALIGN_PTID, i);
    }

    public int getStartPromptOffset()
    {
        return getIntegerProperty(JdapiTypes.START_PROMPT_OFFSET_PTID);
    }

    public void setStartPromptOffset(int i)
    {
        setIntegerProperty(JdapiTypes.START_PROMPT_OFFSET_PTID, i);
    }

    public int getTopPromptAlign()
    {
        return getIntegerProperty(JdapiTypes.TOP_PROMPT_ALIGN_PTID);
    }

    public void setTopPromptAlign(int i)
    {
        setIntegerProperty(JdapiTypes.TOP_PROMPT_ALIGN_PTID, i);
    }

    public int getTopPromptOffset()
    {
        return getIntegerProperty(JdapiTypes.TOP_PROMPT_OFFSET_PTID);
    }

    public void setTopPromptOffset(int i)
    {
        setIntegerProperty(JdapiTypes.TOP_PROMPT_OFFSET_PTID, i);
    }

    public int getTitleReadingOrder()
    {
        return getIntegerProperty(JdapiTypes.TITLE_READING_ORDER_PTID);
    }

    public void setTitleReadingOrder(int i)
    {
        setIntegerProperty(JdapiTypes.TITLE_READING_ORDER_PTID, i);
    }

    public int getUpdateLayout()
    {
        return getIntegerProperty(JdapiTypes.UPDATE_LAYOUT_PTID);
    }

    public void setUpdateLayout(int i)
    {
        setIntegerProperty(JdapiTypes.UPDATE_LAYOUT_PTID, i);
    }

    public int getVerticalJustification()
    {
        return getIntegerProperty(JdapiTypes.VERTICAL_JUSTIFICATION_PTID);
    }

    public void setVerticalJustification(int i)
    {
        setIntegerProperty(JdapiTypes.VERTICAL_JUSTIFICATION_PTID, i);
    }

    public int getVerticalMargin()
    {
        return getIntegerProperty(JdapiTypes.VERTICAL_MARGIN_PTID);
    }

    public void setVerticalMargin(int i)
    {
        setIntegerProperty(JdapiTypes.VERTICAL_MARGIN_PTID, i);
    }

    public int getVerticalObjectOffset()
    {
        return getIntegerProperty(JdapiTypes.VERTICAL_OBJECT_OFFSET_PTID);
    }

    public void setVerticalObjectOffset(int i)
    {
        setIntegerProperty(JdapiTypes.VERTICAL_OBJECT_OFFSET_PTID, i);
    }

    public int getVerticalOrigin()
    {
        return getIntegerProperty(JdapiTypes.VERTICAL_ORIGIN_PTID);
    }

    public void setVerticalOrigin(int i)
    {
        setIntegerProperty(JdapiTypes.VERTICAL_ORIGIN_PTID, i);
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

    public boolean isAllowExpansion()
    {
        return getBooleanProperty(JdapiTypes.ALLOW_EXPANSION_PTID);
    }

    public void setAllowExpansion(boolean flag)
    {
        setBooleanProperty(JdapiTypes.ALLOW_EXPANSION_PTID, flag);
    }

    public boolean isAllowMultiLinePrompts()
    {
        return getBooleanProperty(JdapiTypes.ALLOW_MULTI_LINE_PROMPTS_PTID);
    }

    public void setAllowMultiLinePrompts(boolean flag)
    {
        setBooleanProperty(JdapiTypes.ALLOW_MULTI_LINE_PROMPTS_PTID, flag);
    }

    public boolean isAllowStartAttachmentPrompts()
    {
        return getBooleanProperty(JdapiTypes.ALLOW_START_ATTACHMENT_PROMPTS_PTID);
    }

    public void setAllowStartAttachmentPrompts(boolean flag)
    {
        setBooleanProperty(JdapiTypes.ALLOW_START_ATTACHMENT_PROMPTS_PTID, flag);
    }

    public boolean isAllowTopAttachmentPrompts()
    {
        return getBooleanProperty(JdapiTypes.ALLOW_TOP_ATTACHMENT_PROMPTS_PTID);
    }

    public void setAllowTopAttachmentPrompts(boolean flag)
    {
        setBooleanProperty(JdapiTypes.ALLOW_TOP_ATTACHMENT_PROMPTS_PTID, flag);
    }

    public boolean isBoundingBoxScalable()
    {
        return getBooleanProperty(JdapiTypes.BOUNDING_BOX_SCALABLE_PTID);
    }

    public void setBoundingBoxScalable(boolean flag)
    {
        setBooleanProperty(JdapiTypes.BOUNDING_BOX_SCALABLE_PTID, flag);
    }

    public boolean isClosed()
    {
        return getBooleanProperty(JdapiTypes.CLOSED_PTID);
    }

    public void setClosed(boolean flag)
    {
        setBooleanProperty(JdapiTypes.CLOSED_PTID, flag);
    }

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
    }

    public boolean isDither()
    {
        return getBooleanProperty(JdapiTypes.DITHER_PTID);
    }

    public void setDither(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DITHER_PTID, flag);
    }

    public boolean isFixedBoundingBox()
    {
        return getBooleanProperty(JdapiTypes.FIXED_BOUNDING_BOX_PTID);
    }

    public void setFixedBoundingBox(boolean flag)
    {
        setBooleanProperty(JdapiTypes.FIXED_BOUNDING_BOX_PTID, flag);
    }

    public boolean isFontScaleable()
    {
        return getBooleanProperty(JdapiTypes.FONT_SCALEABLE_PTID);
    }

    public void setFontScaleable(boolean flag)
    {
        setBooleanProperty(JdapiTypes.FONT_SCALEABLE_PTID, flag);
    }

    public boolean isShowScrollbar()
    {
        return getBooleanProperty(JdapiTypes.SHOW_SCROLLBAR_PTID);
    }

    public void setShowScrollbar(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_SCROLLBAR_PTID, flag);
    }

    public boolean isShrinkwrap()
    {
        return getBooleanProperty(JdapiTypes.SHRINKWRAP_PTID);
    }

    public void setShrinkwrap(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHRINKWRAP_PTID, flag);
    }

    public boolean isSubclassSubObject()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID);
    }

    public void setSubclassSubObject(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, flag);
    }

    public boolean isVerticalFill()
    {
        return getBooleanProperty(JdapiTypes.VERTICAL_FILL_PTID);
    }

    public void setVerticalFill(boolean flag)
    {
        setBooleanProperty(JdapiTypes.VERTICAL_FILL_PTID, flag);
    }

    public boolean isWrapText()
    {
        return getBooleanProperty(JdapiTypes.WRAP_TEXT_PTID);
    }

    public void setWrapText(boolean flag)
    {
        setBooleanProperty(JdapiTypes.WRAP_TEXT_PTID, flag);
    }

    public JdapiIterator getCompoundTexts()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.COMPOUNDTEXT_PTID, JdapiTypes.COMPOUNDTEXT_OTID);
    }

    public VisualAttribute getFrameTitleVisualAttributeObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (VisualAttribute)getObjectProperty(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_OBJECT_PTID);
    }

    public void setFrameTitleVisualAttributeObject(VisualAttribute visualattribute)
    {
        setObjectProperty(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_OBJECT_PTID, visualattribute);
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

    public JdapiIterator getPoints()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.POINT_PTID, JdapiTypes.POINT_OTID);
    }

    public JdapiObject getSource()
    {
        return getObjectProperty(JdapiTypes.SOURCE_PTID);
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
        s_foType = JdapiTypes.GRAPHIC_OTID;
    }
}
