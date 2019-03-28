// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            Canvas, PropertyClass

public class VisualState extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public VisualState(Canvas canvas, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), canvas.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public VisualState(Canvas canvas, String s, VisualState visualstate)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), canvas.getObjectPointer(), s_foType, s, 0L, visualstate.getObjectPointer());
        Jdapi.addObject(this);
    }

    public VisualState(Canvas canvas, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), canvas.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected VisualState(long l)
    {
        super(l);
    }

    public VisualState clone(Canvas canvas, String s)
    {
        return (VisualState)super.clone(canvas, s);
    }

    public static VisualState find(Canvas canvas, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), canvas.getObjectPointer(), s, s_foType);
        VisualState visualstate = null;
        if(l1 != 0L)
            visualstate = (VisualState)Jdapi.getObject(l1);
        return visualstate;
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

    public int getArrowStyle()
    {
        return getIntegerProperty(JdapiTypes.ARROW_STYLE_PTID);
    }

    public void setArrowStyle(int i)
    {
        setIntegerProperty(JdapiTypes.ARROW_STYLE_PTID, i);
    }

    public int getCapStyle()
    {
        return getIntegerProperty(JdapiTypes.CAP_STYLE_PTID);
    }

    public void setCapStyle(int i)
    {
        setIntegerProperty(JdapiTypes.CAP_STYLE_PTID, i);
    }

    public int getCharacterCellHden()
    {
        return getIntegerProperty(JdapiTypes.CHARACTER_CELL_HDEN_PTID);
    }

    public void setCharacterCellHden(int i)
    {
        setIntegerProperty(JdapiTypes.CHARACTER_CELL_HDEN_PTID, i);
    }

    public int getCharacterCellHnum()
    {
        return getIntegerProperty(JdapiTypes.CHARACTER_CELL_HNUM_PTID);
    }

    public void setCharacterCellHnum(int i)
    {
        setIntegerProperty(JdapiTypes.CHARACTER_CELL_HNUM_PTID, i);
    }

    public int getCharacterCellVden()
    {
        return getIntegerProperty(JdapiTypes.CHARACTER_CELL_VDEN_PTID);
    }

    public void setCharacterCellVden(int i)
    {
        setIntegerProperty(JdapiTypes.CHARACTER_CELL_VDEN_PTID, i);
    }

    public int getCharacterCellVnum()
    {
        return getIntegerProperty(JdapiTypes.CHARACTER_CELL_VNUM_PTID);
    }

    public void setCharacterCellVnum(int i)
    {
        setIntegerProperty(JdapiTypes.CHARACTER_CELL_VNUM_PTID, i);
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

    public int getDrawingHden()
    {
        return getIntegerProperty(JdapiTypes.DRAWING_HDEN_PTID);
    }

    public void setDrawingHden(int i)
    {
        setIntegerProperty(JdapiTypes.DRAWING_HDEN_PTID, i);
    }

    public int getDrawingHnum()
    {
        return getIntegerProperty(JdapiTypes.DRAWING_HNUM_PTID);
    }

    public void setDrawingHnum(int i)
    {
        setIntegerProperty(JdapiTypes.DRAWING_HNUM_PTID, i);
    }

    public int getDrawingWden()
    {
        return getIntegerProperty(JdapiTypes.DRAWING_WDEN_PTID);
    }

    public void setDrawingWden(int i)
    {
        setIntegerProperty(JdapiTypes.DRAWING_WDEN_PTID, i);
    }

    public int getDrawingWnum()
    {
        return getIntegerProperty(JdapiTypes.DRAWING_WNUM_PTID);
    }

    public void setDrawingWnum(int i)
    {
        setIntegerProperty(JdapiTypes.DRAWING_WNUM_PTID, i);
    }

    public int getEditorHeight()
    {
        return getIntegerProperty(JdapiTypes.EDITOR_HEIGHT_PTID);
    }

    public void setEditorHeight(int i)
    {
        setIntegerProperty(JdapiTypes.EDITOR_HEIGHT_PTID, i);
    }

    public int getEditorWidth()
    {
        return getIntegerProperty(JdapiTypes.EDITOR_WIDTH_PTID);
    }

    public void setEditorWidth(int i)
    {
        setIntegerProperty(JdapiTypes.EDITOR_WIDTH_PTID, i);
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

    public int getFrameTitleAlign()
    {
        return getIntegerProperty(JdapiTypes.FRAME_TITLE_ALIGN_PTID);
    }

    public void setFrameTitleAlign(int i)
    {
        setIntegerProperty(JdapiTypes.FRAME_TITLE_ALIGN_PTID, i);
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

    public int getGridIntervalCnt()
    {
        return getIntegerProperty(JdapiTypes.GRID_INTERVAL_CNT_PTID);
    }

    public void setGridIntervalCnt(int i)
    {
        setIntegerProperty(JdapiTypes.GRID_INTERVAL_CNT_PTID, i);
    }

    public int getGridSnapCnt()
    {
        return getIntegerProperty(JdapiTypes.GRID_SNAP_CNT_PTID);
    }

    public void setGridSnapCnt(int i)
    {
        setIntegerProperty(JdapiTypes.GRID_SNAP_CNT_PTID, i);
    }

    public int getGridUnitCnt()
    {
        return getIntegerProperty(JdapiTypes.GRID_UNIT_CNT_PTID);
    }

    public void setGridUnitCnt(int i)
    {
        setIntegerProperty(JdapiTypes.GRID_UNIT_CNT_PTID, i);
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

    public int getRulerMajor()
    {
        return getIntegerProperty(JdapiTypes.RULER_MAJOR_PTID);
    }

    public void setRulerMajor(int i)
    {
        setIntegerProperty(JdapiTypes.RULER_MAJOR_PTID, i);
    }

    public int getRulerMinor()
    {
        return getIntegerProperty(JdapiTypes.RULER_MINOR_PTID);
    }

    public void setRulerMinor(int i)
    {
        setIntegerProperty(JdapiTypes.RULER_MINOR_PTID, i);
    }

    public int getRulerUnit()
    {
        return getIntegerProperty(JdapiTypes.RULER_UNIT_PTID);
    }

    public void setRulerUnit(int i)
    {
        setIntegerProperty(JdapiTypes.RULER_UNIT_PTID, i);
    }

    public int getWindowHeight()
    {
        return getIntegerProperty(JdapiTypes.WINDOW_HEIGHT_PTID);
    }

    public void setWindowHeight(int i)
    {
        setIntegerProperty(JdapiTypes.WINDOW_HEIGHT_PTID, i);
    }

    public int getWindowWidth()
    {
        return getIntegerProperty(JdapiTypes.WINDOW_WIDTH_PTID);
    }

    public void setWindowWidth(int i)
    {
        setIntegerProperty(JdapiTypes.WINDOW_WIDTH_PTID, i);
    }

    public int getWindowXPosition()
    {
        return getIntegerProperty(JdapiTypes.WINDOW_X_POSITION_PTID);
    }

    public void setWindowXPosition(int i)
    {
        setIntegerProperty(JdapiTypes.WINDOW_X_POSITION_PTID, i);
    }

    public int getWindowYPosition()
    {
        return getIntegerProperty(JdapiTypes.WINDOW_Y_POSITION_PTID);
    }

    public void setWindowYPosition(int i)
    {
        setIntegerProperty(JdapiTypes.WINDOW_Y_POSITION_PTID, i);
    }

    public int getZoomLevel()
    {
        return getIntegerProperty(JdapiTypes.ZOOM_LEVEL_PTID);
    }

    public void setZoomLevel(int i)
    {
        setIntegerProperty(JdapiTypes.ZOOM_LEVEL_PTID, i);
    }

    public boolean isBoundingBoxScalable()
    {
        return getBooleanProperty(JdapiTypes.BOUNDING_BOX_SCALABLE_PTID);
    }

    public void setBoundingBoxScalable(boolean flag)
    {
        setBooleanProperty(JdapiTypes.BOUNDING_BOX_SCALABLE_PTID, flag);
    }

    public boolean isCenterTracking()
    {
        return getBooleanProperty(JdapiTypes.CENTER_TRACKING_PTID);
    }

    public void setCenterTracking(boolean flag)
    {
        setBooleanProperty(JdapiTypes.CENTER_TRACKING_PTID, flag);
    }

    public boolean isClosed()
    {
        return getBooleanProperty(JdapiTypes.CLOSED_PTID);
    }

    public void setClosed(boolean flag)
    {
        setBooleanProperty(JdapiTypes.CLOSED_PTID, flag);
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

    public boolean isGridFlag()
    {
        return getBooleanProperty(JdapiTypes.GRID_FLAG_PTID);
    }

    public void setGridFlag(boolean flag)
    {
        setBooleanProperty(JdapiTypes.GRID_FLAG_PTID, flag);
    }

    public boolean isGridsnapFlag()
    {
        return getBooleanProperty(JdapiTypes.GRIDSNAP_FLAG_PTID);
    }

    public void setGridsnapFlag(boolean flag)
    {
        setBooleanProperty(JdapiTypes.GRIDSNAP_FLAG_PTID, flag);
    }

    public boolean isPageCountSeq()
    {
        return getBooleanProperty(JdapiTypes.PAGE_COUNT_SEQ_PTID);
    }

    public void setPageCountSeq(boolean flag)
    {
        setBooleanProperty(JdapiTypes.PAGE_COUNT_SEQ_PTID, flag);
    }

    public boolean isPagebreakFlag()
    {
        return getBooleanProperty(JdapiTypes.PAGEBREAK_FLAG_PTID);
    }

    public void setPagebreakFlag(boolean flag)
    {
        setBooleanProperty(JdapiTypes.PAGEBREAK_FLAG_PTID, flag);
    }

    public boolean isResizableFlag()
    {
        return getBooleanProperty(JdapiTypes.RESIZABLE_FLAG_PTID);
    }

    public void setResizableFlag(boolean flag)
    {
        setBooleanProperty(JdapiTypes.RESIZABLE_FLAG_PTID, flag);
    }

    public boolean isRulerFlag()
    {
        return getBooleanProperty(JdapiTypes.RULER_FLAG_PTID);
    }

    public void setRulerFlag(boolean flag)
    {
        setBooleanProperty(JdapiTypes.RULER_FLAG_PTID, flag);
    }

    public boolean isRulerGuideFlag()
    {
        return getBooleanProperty(JdapiTypes.RULER_GUIDE_FLAG_PTID);
    }

    public void setRulerGuideFlag(boolean flag)
    {
        setBooleanProperty(JdapiTypes.RULER_GUIDE_FLAG_PTID, flag);
    }

    public boolean isShowCanvas()
    {
        return getBooleanProperty(JdapiTypes.SHOW_CANVAS_PTID);
    }

    public void setShowCanvas(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_CANVAS_PTID, flag);
    }

    public boolean isShowView()
    {
        return getBooleanProperty(JdapiTypes.SHOW_VIEW_PTID);
    }

    public void setShowView(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_VIEW_PTID, flag);
    }

    public boolean isStatusLineFlag()
    {
        return getBooleanProperty(JdapiTypes.STATUS_LINE_FLAG_PTID);
    }

    public void setStatusLineFlag(boolean flag)
    {
        setBooleanProperty(JdapiTypes.STATUS_LINE_FLAG_PTID, flag);
    }

    public boolean isToolpaletteFlag()
    {
        return getBooleanProperty(JdapiTypes.TOOLPALETTE_FLAG_PTID);
    }

    public void setToolpaletteFlag(boolean flag)
    {
        setBooleanProperty(JdapiTypes.TOOLPALETTE_FLAG_PTID, flag);
    }

    public boolean isVisualStateValid()
    {
        return getBooleanProperty(JdapiTypes.VISUAL_STATE_VALID_PTID);
    }

    public void setVisualStateValid(boolean flag)
    {
        setBooleanProperty(JdapiTypes.VISUAL_STATE_VALID_PTID, flag);
    }

    public boolean isWrapText()
    {
        return getBooleanProperty(JdapiTypes.WRAP_TEXT_PTID);
    }

    public void setWrapText(boolean flag)
    {
        setBooleanProperty(JdapiTypes.WRAP_TEXT_PTID, flag);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.VISUAL_STATE_OTID;
    }
}
