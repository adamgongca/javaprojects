// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.util.Hashtable;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiException, JdapiTypes, JdapiObject

public class PropertyMap
{

    public PropertyMap()
    {
    }

    static String getFormattedPropertyName(int i)
    {
        return (String)m_nameMap.get(new Integer(i));
    }

    static int getFormattedPropertyId(String s)
    {
        return ((Integer)m_reverse_nameMap.get(s)).intValue();
    }

    static int[] getAllowedValues(int i)
    {
        return (int[])m_enumMap.get(new Integer(i));
    }

    public static Class[] getPropertyTypes(JdapiObject jdapiobject, int i)
    {
        return getPropertyTypes(jdapiobject.getClass(), i);
    }

    public static Class[] getPropertyTypes(Class class1, int i)
    {
        String as[] = (String[])m_map.get(new Integer(i));
        Class aclass[] = null;
        if(as != null)
        {
            aclass = new Class[as.length];
            for(int j = 0; j < as.length; j++)
                if(as[j].equals("self"))
                    aclass[j] = class1;
                else
                if(as[j].equals("parent"))
                    aclass[j] = oracle.forms.jdapi.JdapiObject.class;
                else
                    try
                    {
                        aclass[j] = Class.forName("oracle.forms.jdapi." + as[j]);
                    }
                    catch(ClassNotFoundException classnotfoundexception)
                    {
                        throw new JdapiException("Can't find class " + as[j]);
                    }

        }
        return aclass;
    }

    private static final Hashtable m_enumMap;
    private static final Hashtable m_nameMap;
    private static final Hashtable m_reverse_nameMap;
    private static final Hashtable m_map;

    static 
    {
        m_enumMap = new Hashtable();
        m_nameMap = new Hashtable();
        m_reverse_nameMap = new Hashtable();
        m_map = new Hashtable();
        m_map.put(new Integer(JdapiTypes.COLUMN_VALUE_PTID), new String[0]);
        m_map.put(new Integer(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_OBJECT_PTID), new String[] {
            "VisualAttribute"
        });
        m_map.put(new Integer(JdapiTypes.CANVAS_OBJECT_PTID), new String[] {
            "Canvas"
        });
        m_map.put(new Integer(JdapiTypes.POPUP_MENU_OBJECT_PTID), new String[] {
            "Menu"
        });
        m_map.put(new Integer(JdapiTypes.PROMPT_VISUALATTRIBUTE_OBJECT_PTID), new String[] {
            "VisualAttribute"
        });
        m_map.put(new Integer(JdapiTypes.SUB_MENU_OBJECT_PTID), new String[] {
            "MenuItem"
        });
        m_map.put(new Integer(JdapiTypes.PREVIOUS_NAVIGATION_ITEM_OBJECT_PTID), new String[] {
            "Item"
        });
        m_map.put(new Integer(JdapiTypes.OWNER_PTID), new String[] {
            "parent", "ObjectGroup"
        });
        m_map.put(new Integer(JdapiTypes.LOV_OBJECT_PTID), new String[] {
            "LOV"
        });
        m_map.put(new Integer(JdapiTypes.EDIT_OBJECT_PTID), new String[] {
            "Editor"
        });
        m_map.put(new Integer(JdapiTypes.LIBRARY_PROGRAM_UNIT_PTID), new String[] {
            "ProgramUnit"
        });
        m_map.put(new Integer(JdapiTypes.MODULE_PTID), new String[] {
            "FormModule", "ObjectLibrary", "MenuModule"
        });
        m_map.put(new Integer(JdapiTypes.SCROLLBAR_TABPAGE_OBJECT_PTID), new String[] {
            "TabPage"
        });
        m_map.put(new Integer(JdapiTypes.NEXT_NAVIGATION_BLOCK_OBJECT_PTID), new String[] {
            "Block"
        });
        m_map.put(new Integer(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID), new String[] {
            "VisualAttribute"
        });
        m_map.put(new Integer(JdapiTypes.FIRST_NAVIGATION_BLOCK_OBJECT_PTID), new String[] {
            "Block"
        });
        m_map.put(new Integer(JdapiTypes.TABPAGE_OBJECT_PTID), new String[] {
            "TabPage"
        });
        m_map.put(new Integer(JdapiTypes.POPUP_VISUALATTRIBUTE_OBJECT_PTID), new String[] {
            "VisualAttribute"
        });
        m_map.put(new Integer(JdapiTypes.OBJECT_GROUP_CHILD_REAL_OBJECT_PTID), new String[0]);
        m_map.put(new Integer(JdapiTypes.WINDOW_OBJECT_PTID), new String[] {
            "Window"
        });
        m_map.put(new Integer(JdapiTypes.SOURCE_PTID), new String[] {
            "self", "PropertyClass"
        });
        m_map.put(new Integer(JdapiTypes.NEXT_NAVIGATION_ITEM_OBJECT_PTID), new String[] {
            "Item"
        });
        m_map.put(new Integer(JdapiTypes.RECORD_GROUP_OBJECT_PTID), new String[] {
            "RecordGroup"
        });
        m_map.put(new Integer(JdapiTypes.SCROLLBAR_CANVAS_OBJECT_PTID), new String[] {
            "Canvas"
        });
        m_map.put(new Integer(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_OBJECT_PTID), new String[] {
            "VisualAttribute"
        });
        m_map.put(new Integer(JdapiTypes.PREVIOUS_NAVIGATION_BLOCK_OBJECT_PTID), new String[] {
            "Block"
        });
        m_map.put(new Integer(JdapiTypes.SYNCHRONIZED_ITEM_OBJECT_PTID), new String[] {
            "Item"
        });
        m_map.put(new Integer(JdapiTypes.EDITOR_PTID), new String[] {
            "Editor"
        });
        m_map.put(new Integer(JdapiTypes.ALERT_PTID), new String[] {
            "Alert"
        });
        m_map.put(new Integer(JdapiTypes.TAB_PAGE_PTID), new String[] {
            "TabPage"
        });
        m_map.put(new Integer(JdapiTypes.PROPERTY_CLASS_PTID), new String[] {
            "PropertyClass"
        });
        m_map.put(new Integer(JdapiTypes.QUERY_DATA_SOURCE_ARGUMENT_PTID), new String[] {
            "DataSourceArgument"
        });
        m_map.put(new Integer(JdapiTypes.INSERT_DATA_SOURCE_ARGUMENT_PTID), new String[] {
            "DataSourceArgument"
        });
        m_map.put(new Integer(JdapiTypes.UPDATE_DATA_SOURCE_ARGUMENT_PTID), new String[] {
            "DataSourceArgument"
        });
        m_map.put(new Integer(JdapiTypes.DELETE_DATA_SOURCE_ARGUMENT_PTID), new String[] {
            "DataSourceArgument"
        });
        m_map.put(new Integer(JdapiTypes.LOCK_DATA_SOURCE_ARGUMENT_PTID), new String[] {
            "DataSourceArgument"
        });
        m_map.put(new Integer(JdapiTypes.QUERY_DATA_SOURCE_COLUMN_PTID), new String[] {
            "DataSourceColumn"
        });
        m_map.put(new Integer(JdapiTypes.INSERT_DATA_SOURCE_COLUMN_PTID), new String[] {
            "DataSourceColumn"
        });
        m_map.put(new Integer(JdapiTypes.UPDATE_DATA_SOURCE_COLUMN_PTID), new String[] {
            "DataSourceColumn"
        });
        m_map.put(new Integer(JdapiTypes.DELETE_DATA_SOURCE_COLUMN_PTID), new String[] {
            "DataSourceColumn"
        });
        m_map.put(new Integer(JdapiTypes.LOCK_DATA_SOURCE_COLUMN_PTID), new String[] {
            "DataSourceColumn"
        });
        m_map.put(new Integer(JdapiTypes.COMPOUNDTEXT_PTID), new String[] {
            "CompoundText"
        });
        m_map.put(new Integer(JdapiTypes.COLUMN_MAP_PTID), new String[] {
            "LOVColumnMapping"
        });
        m_map.put(new Integer(JdapiTypes.OBJECT_GROUP_PTID), new String[] {
            "ObjectGroup"
        });
        m_map.put(new Integer(JdapiTypes.GRAPHIC_PTID), new String[] {
            "Graphics"
        });
        m_map.put(new Integer(JdapiTypes.CANVAS_PTID), new String[] {
            "Canvas"
        });
        m_map.put(new Integer(JdapiTypes.VISUAL_STATE_PTID), new String[] {
            "VisualState"
        });
        m_map.put(new Integer(JdapiTypes.POINT_PTID), new String[] {
            "Point"
        });
        m_map.put(new Integer(JdapiTypes.RECORD_GROUP_PTID), new String[] {
            "RecordGroup"
        });
        m_map.put(new Integer(JdapiTypes.WINDOW_PTID), new String[] {
            "Window"
        });
        m_map.put(new Integer(JdapiTypes.TRIGGER_PTID), new String[] {
            "Trigger"
        });
        m_map.put(new Integer(JdapiTypes.BLOCK_PTID), new String[] {
            "Block"
        });
        m_map.put(new Integer(JdapiTypes.REPORT_PTID), new String[] {
            "Report"
        });
        m_map.put(new Integer(JdapiTypes.RELATION_PTID), new String[] {
            "Relation"
        });
        m_map.put(new Integer(JdapiTypes.MENU_ITEM_PTID), new String[] {
            "MenuItem"
        });
        m_map.put(new Integer(JdapiTypes.COLUMN_SPECIFICATION_PTID), new String[] {
            "RecordGroupColumn"
        });
        m_map.put(new Integer(JdapiTypes.ITEM_PTID), new String[] {
            "Item"
        });
        m_map.put(new Integer(JdapiTypes.PROGRAM_UNIT_PTID), new String[] {
            "ProgramUnit"
        });
        m_map.put(new Integer(JdapiTypes.VISUAL_ATTRIBUTE_PTID), new String[] {
            "VisualAttribute"
        });
        m_map.put(new Integer(JdapiTypes.MENU_PTID), new String[] {
            "Menu"
        });
        m_map.put(new Integer(JdapiTypes.LOV_PTID), new String[] {
            "LOV"
        });
        m_map.put(new Integer(JdapiTypes.OBJECT_LIBRARY_TAB_PTID), new String[] {
            "ObjectLibraryTab"
        });
        m_map.put(new Integer(JdapiTypes.ATTACHMENT_LIBRARY_PTID), new String[] {
            "AttachedLibrary"
        });
        m_map.put(new Integer(JdapiTypes.OBJECTGROUP_CHILD_PTID), new String[] {
            "ObjectGroupChild"
        });
        m_map.put(new Integer(JdapiTypes.FORM_PARAMETER_PTID), new String[] {
            "ModuleParameter"
        });
        m_map.put(new Integer(JdapiTypes.TEXT_SEGMENT_PTID), new String[] {
            "TextSegment"
        });
        m_map.put(new Integer(JdapiTypes.RADIO_BUTTON_PTID), new String[] {
            "RadioButton"
        });
        m_nameMap.put(new Integer(JdapiTypes.ACCESS_KEY_PTID), "AccessKey");
        m_reverse_nameMap.put("AccessKey", new Integer(JdapiTypes.ACCESS_KEY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ALERT_MESSAGE_PTID), "AlertMessage");
        m_reverse_nameMap.put("AlertMessage", new Integer(JdapiTypes.ALERT_MESSAGE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ALERT_PTID), "Alert");
        m_reverse_nameMap.put("Alert", new Integer(JdapiTypes.ALERT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ALERT_STYLE_PTID), "AlertStyle");
        m_reverse_nameMap.put("AlertStyle", new Integer(JdapiTypes.ALERT_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ALIAS_PTID), "Alias");
        m_reverse_nameMap.put("Alias", new Integer(JdapiTypes.ALIAS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ALLOW_EXPANSION_PTID), "AllowExpansion");
        m_reverse_nameMap.put("AllowExpansion", new Integer(JdapiTypes.ALLOW_EXPANSION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ALLOW_MULTI_LINE_PROMPTS_PTID), "AllowMultiLinePrompts");
        m_reverse_nameMap.put("AllowMultiLinePrompts", new Integer(JdapiTypes.ALLOW_MULTI_LINE_PROMPTS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ALLOW_START_ATTACHMENT_PROMPTS_PTID), "AllowStartAttachmentPrompts");
        m_reverse_nameMap.put("AllowStartAttachmentPrompts", new Integer(JdapiTypes.ALLOW_START_ATTACHMENT_PROMPTS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ALLOW_TOP_ATTACHMENT_PROMPTS_PTID), "AllowTopAttachmentPrompts");
        m_reverse_nameMap.put("AllowTopAttachmentPrompts", new Integer(JdapiTypes.ALLOW_TOP_ATTACHMENT_PROMPTS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ARROW_STYLE_PTID), "ArrowStyle");
        m_reverse_nameMap.put("ArrowStyle", new Integer(JdapiTypes.ARROW_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ATTACHMENT_LIBRARY_PTID), "AttachmentLibrary");
        m_reverse_nameMap.put("AttachmentLibrary", new Integer(JdapiTypes.ATTACHMENT_LIBRARY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.AUDIO_CHANNELS_PTID), "AudioChannels");
        m_reverse_nameMap.put("AudioChannels", new Integer(JdapiTypes.AUDIO_CHANNELS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.AUTO_COLUMN_WIDTH_PTID), "AutoColumnWidth");
        m_reverse_nameMap.put("AutoColumnWidth", new Integer(JdapiTypes.AUTO_COLUMN_WIDTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.AUTO_DISPLAY_PTID), "AutoDisplay");
        m_reverse_nameMap.put("AutoDisplay", new Integer(JdapiTypes.AUTO_DISPLAY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.AUTO_HINT_PTID), "AutoHint");
        m_reverse_nameMap.put("AutoHint", new Integer(JdapiTypes.AUTO_HINT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.AUTO_POSITION_PTID), "AutoPosition");
        m_reverse_nameMap.put("AutoPosition", new Integer(JdapiTypes.AUTO_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.AUTO_QUERY_PTID), "AutoQuery");
        m_reverse_nameMap.put("AutoQuery", new Integer(JdapiTypes.AUTO_QUERY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.AUTO_REFRESH_PTID), "AutoRefresh");
        m_reverse_nameMap.put("AutoRefresh", new Integer(JdapiTypes.AUTO_REFRESH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.AUTO_SELECT_PTID), "AutoSelect");
        m_reverse_nameMap.put("AutoSelect", new Integer(JdapiTypes.AUTO_SELECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.AUTO_SKIP_PTID), "AutoSkip");
        m_reverse_nameMap.put("AutoSkip", new Integer(JdapiTypes.AUTO_SKIP_PTID));
        m_nameMap.put(new Integer(JdapiTypes.BACK_COLOR_PTID), "BackColor");
        m_reverse_nameMap.put("BackColor", new Integer(JdapiTypes.BACK_COLOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.BEVEL_PTID), "Bevel");
        m_reverse_nameMap.put("Bevel", new Integer(JdapiTypes.BEVEL_PTID));
        m_nameMap.put(new Integer(JdapiTypes.BLOCK_PTID), "Block");
        m_reverse_nameMap.put("Block", new Integer(JdapiTypes.BLOCK_PTID));
        m_nameMap.put(new Integer(JdapiTypes.BOTTOM_TITLE_PTID), "BottomTitle");
        m_reverse_nameMap.put("BottomTitle", new Integer(JdapiTypes.BOTTOM_TITLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.BOUNDING_BOX_SCALABLE_PTID), "BoundingBoxScalable");
        m_reverse_nameMap.put("BoundingBoxScalable", new Integer(JdapiTypes.BOUNDING_BOX_SCALABLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.BUTTON_1_LABEL_PTID), "Button1Label");
        m_reverse_nameMap.put("Button1Label", new Integer(JdapiTypes.BUTTON_1_LABEL_PTID));
        m_nameMap.put(new Integer(JdapiTypes.BUTTON_2_LABEL_PTID), "Button2Label");
        m_reverse_nameMap.put("Button2Label", new Integer(JdapiTypes.BUTTON_2_LABEL_PTID));
        m_nameMap.put(new Integer(JdapiTypes.BUTTON_3_LABEL_PTID), "Button3Label");
        m_reverse_nameMap.put("Button3Label", new Integer(JdapiTypes.BUTTON_3_LABEL_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CALCULATE_MODE_PTID), "CalculateMode");
        m_reverse_nameMap.put("CalculateMode", new Integer(JdapiTypes.CALCULATE_MODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CANVAS_NAME_PTID), "CanvasName");
        m_reverse_nameMap.put("CanvasName", new Integer(JdapiTypes.CANVAS_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CANVAS_OBJECT_PTID), "CanvasObject");
        m_reverse_nameMap.put("CanvasObject", new Integer(JdapiTypes.CANVAS_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CANVAS_PTID), "Canvas");
        m_reverse_nameMap.put("Canvas", new Integer(JdapiTypes.CANVAS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CANVAS_TYPE_PTID), "CanvasType");
        m_reverse_nameMap.put("CanvasType", new Integer(JdapiTypes.CANVAS_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CAP_STYLE_PTID), "CapStyle");
        m_reverse_nameMap.put("CapStyle", new Integer(JdapiTypes.CAP_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CASE_INSENSITIVE_QUERY_PTID), "CaseInsensitiveQuery");
        m_reverse_nameMap.put("CaseInsensitiveQuery", new Integer(JdapiTypes.CASE_INSENSITIVE_QUERY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CASE_RESTRICTION_PTID), "CaseRestriction");
        m_reverse_nameMap.put("CaseRestriction", new Integer(JdapiTypes.CASE_RESTRICTION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CENTER_TRACKING_PTID), "CenterTracking");
        m_reverse_nameMap.put("CenterTracking", new Integer(JdapiTypes.CENTER_TRACKING_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CHARACTER_CELL_HDEN_PTID), "CharacterCellHden");
        m_reverse_nameMap.put("CharacterCellHden", new Integer(JdapiTypes.CHARACTER_CELL_HDEN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CHARACTER_CELL_HEIGHT_PTID), "CharacterCellHeight");
        m_reverse_nameMap.put("CharacterCellHeight", new Integer(JdapiTypes.CHARACTER_CELL_HEIGHT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CHARACTER_CELL_HNUM_PTID), "CharacterCellHnum");
        m_reverse_nameMap.put("CharacterCellHnum", new Integer(JdapiTypes.CHARACTER_CELL_HNUM_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CHARACTER_CELL_VDEN_PTID), "CharacterCellVden");
        m_reverse_nameMap.put("CharacterCellVden", new Integer(JdapiTypes.CHARACTER_CELL_VDEN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CHARACTER_CELL_VNUM_PTID), "CharacterCellVnum");
        m_reverse_nameMap.put("CharacterCellVnum", new Integer(JdapiTypes.CHARACTER_CELL_VNUM_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CHARACTER_CELL_WIDTH_PTID), "CharacterCellWidth");
        m_reverse_nameMap.put("CharacterCellWidth", new Integer(JdapiTypes.CHARACTER_CELL_WIDTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CHECKED_VALUE_PTID), "CheckedValue");
        m_reverse_nameMap.put("CheckedValue", new Integer(JdapiTypes.CHECKED_VALUE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CHECK_BOX_OTHER_VALUES_PTID), "CheckBoxOtherValues");
        m_reverse_nameMap.put("CheckBoxOtherValues", new Integer(JdapiTypes.CHECK_BOX_OTHER_VALUES_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CLEAR_ALLOWED_PTID), "ClearAllowed");
        m_reverse_nameMap.put("ClearAllowed", new Integer(JdapiTypes.CLEAR_ALLOWED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CLIP_HEIGHT_PTID), "ClipHeight");
        m_reverse_nameMap.put("ClipHeight", new Integer(JdapiTypes.CLIP_HEIGHT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CLIP_WIDTH_PTID), "ClipWidth");
        m_reverse_nameMap.put("ClipWidth", new Integer(JdapiTypes.CLIP_WIDTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CLIP_X_POSITION_PTID), "ClipXPosition");
        m_reverse_nameMap.put("ClipXPosition", new Integer(JdapiTypes.CLIP_X_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CLIP_Y_POSITION_PTID), "ClipYPosition");
        m_reverse_nameMap.put("ClipYPosition", new Integer(JdapiTypes.CLIP_Y_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CLOSED_PTID), "Closed");
        m_reverse_nameMap.put("Closed", new Integer(JdapiTypes.CLOSED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COLUMN_DATA_TYPE_PTID), "ColumnDataType");
        m_reverse_nameMap.put("ColumnDataType", new Integer(JdapiTypes.COLUMN_DATA_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COLUMN_MAP_PTID), "ColumnMap");
        m_reverse_nameMap.put("ColumnMap", new Integer(JdapiTypes.COLUMN_MAP_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COLUMN_NAME_PTID), "ColumnName");
        m_reverse_nameMap.put("ColumnName", new Integer(JdapiTypes.COLUMN_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COLUMN_SPECIFICATION_PTID), "ColumnSpecification");
        m_reverse_nameMap.put("ColumnSpecification", new Integer(JdapiTypes.COLUMN_SPECIFICATION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COLUMN_VALUES_COUNT_PTID), "ColumnValuesCount");
        m_reverse_nameMap.put("ColumnValuesCount", new Integer(JdapiTypes.COLUMN_VALUES_COUNT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COLUMN_VALUE_PTID), "ColumnValue");
        m_reverse_nameMap.put("ColumnValue", new Integer(JdapiTypes.COLUMN_VALUE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COMMAND_TEXT_PTID), "CommandText");
        m_reverse_nameMap.put("CommandText", new Integer(JdapiTypes.COMMAND_TEXT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COMMAND_TYPE_PTID), "CommandType");
        m_reverse_nameMap.put("CommandType", new Integer(JdapiTypes.COMMAND_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COMMENT_PTID), "Comment");
        m_reverse_nameMap.put("Comment", new Integer(JdapiTypes.COMMENT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COMM_MODE_PTID), "CommMode");
        m_reverse_nameMap.put("CommMode", new Integer(JdapiTypes.COMM_MODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COMPOUNDTEXT_PTID), "CompoundText");
        m_reverse_nameMap.put("CompoundText", new Integer(JdapiTypes.COMPOUNDTEXT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COMPRESSION_QUALITY_PTID), "CompressionQuality");
        m_reverse_nameMap.put("CompressionQuality", new Integer(JdapiTypes.COMPRESSION_QUALITY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COMPRESS_PTID), "Compress");
        m_reverse_nameMap.put("Compress", new Integer(JdapiTypes.COMPRESS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CONCEAL_DATA_PTID), "ConcealData");
        m_reverse_nameMap.put("ConcealData", new Integer(JdapiTypes.CONCEAL_DATA_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CONSOLE_WINDOW_PTID), "ConsoleWindow");
        m_reverse_nameMap.put("ConsoleWindow", new Integer(JdapiTypes.CONSOLE_WINDOW_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COORDINATE_SYSTEM_PTID), "CoordinateSystem");
        m_reverse_nameMap.put("CoordinateSystem", new Integer(JdapiTypes.COORDINATE_SYSTEM_PTID));
        m_nameMap.put(new Integer(JdapiTypes.COPY_VALUE_FROM_ITEM_PTID), "CopyValueFromItem");
        m_reverse_nameMap.put("CopyValueFromItem", new Integer(JdapiTypes.COPY_VALUE_FROM_ITEM_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CORNER_RADIUS_X_PTID), "CornerRadiusX");
        m_reverse_nameMap.put("CornerRadiusX", new Integer(JdapiTypes.CORNER_RADIUS_X_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CORNER_RADIUS_Y_PTID), "CornerRadiusY");
        m_reverse_nameMap.put("CornerRadiusY", new Integer(JdapiTypes.CORNER_RADIUS_Y_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CURSOR_MODE_PTID), "CursorMode");
        m_reverse_nameMap.put("CursorMode", new Integer(JdapiTypes.CURSOR_MODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.CUSTOM_SPACING_PTID), "CustomSpacing");
        m_reverse_nameMap.put("CustomSpacing", new Integer(JdapiTypes.CUSTOM_SPACING_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DASH_STYLE_PTID), "DashStyle");
        m_reverse_nameMap.put("DashStyle", new Integer(JdapiTypes.DASH_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DATABASE_BLOCK_PTID), "DatabaseBlock");
        m_reverse_nameMap.put("DatabaseBlock", new Integer(JdapiTypes.DATABASE_BLOCK_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DATABASE_ITEM_PTID), "DatabaseItem");
        m_reverse_nameMap.put("DatabaseItem", new Integer(JdapiTypes.DATABASE_ITEM_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DATA_LENGTH_SEMANTICS_PTID), "DataLengthSemantics");
        m_reverse_nameMap.put("DataLengthSemantics", new Integer(JdapiTypes.DATA_LENGTH_SEMANTICS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DATA_SOURCE_BLOCK_PTID), "DataSourceBlock");
        m_reverse_nameMap.put("DataSourceBlock", new Integer(JdapiTypes.DATA_SOURCE_BLOCK_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DATA_SOURCE_X_AXIS_PTID), "DataSourceXAxis");
        m_reverse_nameMap.put("DataSourceXAxis", new Integer(JdapiTypes.DATA_SOURCE_X_AXIS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DATA_SOURCE_Y_AXIS_PTID), "DataSourceYAxis");
        m_reverse_nameMap.put("DataSourceYAxis", new Integer(JdapiTypes.DATA_SOURCE_Y_AXIS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DATA_TYPE_PTID), "DataType");
        m_reverse_nameMap.put("DataType", new Integer(JdapiTypes.DATA_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DEFAULT_ALERT_BUTTON_PTID), "DefaultAlertButton");
        m_reverse_nameMap.put("DefaultAlertButton", new Integer(JdapiTypes.DEFAULT_ALERT_BUTTON_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DEFAULT_BUTTON_PTID), "DefaultButton");
        m_reverse_nameMap.put("DefaultButton", new Integer(JdapiTypes.DEFAULT_BUTTON_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DEFAULT_FONT_SCALING_PTID), "DefaultFontScaling");
        m_reverse_nameMap.put("DefaultFontScaling", new Integer(JdapiTypes.DEFAULT_FONT_SCALING_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DEFERRED_PTID), "Deferred");
        m_reverse_nameMap.put("Deferred", new Integer(JdapiTypes.DEFERRED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DELETE_ALLOWED_PTID), "DeleteAllowed");
        m_reverse_nameMap.put("DeleteAllowed", new Integer(JdapiTypes.DELETE_ALLOWED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DELETE_DATA_SOURCE_ARGUMENT_PTID), "DeleteDataSourceArgument");
        m_reverse_nameMap.put("DeleteDataSourceArgument", new Integer(JdapiTypes.DELETE_DATA_SOURCE_ARGUMENT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DELETE_DATA_SOURCE_COLUMN_PTID), "DeleteDataSourceColumn");
        m_reverse_nameMap.put("DeleteDataSourceColumn", new Integer(JdapiTypes.DELETE_DATA_SOURCE_COLUMN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DELETE_PROCEDURE_NAME_PTID), "DeleteProcedureName");
        m_reverse_nameMap.put("DeleteProcedureName", new Integer(JdapiTypes.DELETE_PROCEDURE_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DELETE_RECORD_PTID), "DeleteRecord");
        m_reverse_nameMap.put("DeleteRecord", new Integer(JdapiTypes.DELETE_RECORD_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DETAIL_BLOCK_PTID), "DetailBlock");
        m_reverse_nameMap.put("DetailBlock", new Integer(JdapiTypes.DETAIL_BLOCK_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DETAIL_ITEMREF_PTID), "DetailItemref");
        m_reverse_nameMap.put("DetailItemref", new Integer(JdapiTypes.DETAIL_ITEMREF_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DIRTY_INFO_PTID), "DirtyInfo");
        m_reverse_nameMap.put("DirtyInfo", new Integer(JdapiTypes.DIRTY_INFO_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DISPLAY_IN_KEYBOARD_HELP_PTID), "DisplayInKeyboardHelp");
        m_reverse_nameMap.put("DisplayInKeyboardHelp", new Integer(JdapiTypes.DISPLAY_IN_KEYBOARD_HELP_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DISPLAY_NO_PRIV_PTID), "DisplayNoPriv");
        m_reverse_nameMap.put("DisplayNoPriv", new Integer(JdapiTypes.DISPLAY_NO_PRIV_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DISPLAY_QUALITY_PTID), "DisplayQuality");
        m_reverse_nameMap.put("DisplayQuality", new Integer(JdapiTypes.DISPLAY_QUALITY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DISPLAY_VIEWPORT_PTID), "DisplayViewport");
        m_reverse_nameMap.put("DisplayViewport", new Integer(JdapiTypes.DISPLAY_VIEWPORT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DISPLAY_WIDTH_PTID), "DisplayWidth");
        m_reverse_nameMap.put("DisplayWidth", new Integer(JdapiTypes.DISPLAY_WIDTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DISTANCE_BETWEEN_RECORDS_PTID), "DistanceBetweenRecords");
        m_reverse_nameMap.put("DistanceBetweenRecords", new Integer(JdapiTypes.DISTANCE_BETWEEN_RECORDS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DITHER_PTID), "Dither");
        m_reverse_nameMap.put("Dither", new Integer(JdapiTypes.DITHER_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DML_ARRAY_SIZE_PTID), "DMLArraySize");
        m_reverse_nameMap.put("DMLArraySize", new Integer(JdapiTypes.DML_ARRAY_SIZE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DML_DATA_NAME_PTID), "DMLDataName");
        m_reverse_nameMap.put("DMLDataName", new Integer(JdapiTypes.DML_DATA_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DML_DATA_TYPE_PTID), "DMLDataType");
        m_reverse_nameMap.put("DMLDataType", new Integer(JdapiTypes.DML_DATA_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DML_RETURN_VALUE_PTID), "DMLReturnValue");
        m_reverse_nameMap.put("DMLReturnValue", new Integer(JdapiTypes.DML_RETURN_VALUE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DRAWING_HDEN_PTID), "DrawingHden");
        m_reverse_nameMap.put("DrawingHden", new Integer(JdapiTypes.DRAWING_HDEN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DRAWING_HNUM_PTID), "DrawingHnum");
        m_reverse_nameMap.put("DrawingHnum", new Integer(JdapiTypes.DRAWING_HNUM_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DRAWING_WDEN_PTID), "DrawingWden");
        m_reverse_nameMap.put("DrawingWden", new Integer(JdapiTypes.DRAWING_WDEN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DRAWING_WNUM_PTID), "DrawingWnum");
        m_reverse_nameMap.put("DrawingWnum", new Integer(JdapiTypes.DRAWING_WNUM_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSA_MODE_PTID), "DSAMode");
        m_reverse_nameMap.put("DSAMode", new Integer(JdapiTypes.DSA_MODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSA_NAME_PTID), "DSAName");
        m_reverse_nameMap.put("DSAName", new Integer(JdapiTypes.DSA_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSA_TYPE_NAME_PTID), "DSATypeName");
        m_reverse_nameMap.put("DSATypeName", new Integer(JdapiTypes.DSA_TYPE_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSA_TYPE_PTID), "DSAType");
        m_reverse_nameMap.put("DSAType", new Integer(JdapiTypes.DSA_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSA_VALUE_PTID), "DSAValue");
        m_reverse_nameMap.put("DSAValue", new Integer(JdapiTypes.DSA_VALUE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSC_LENGTH_PTID), "DSCLength");
        m_reverse_nameMap.put("DSCLength", new Integer(JdapiTypes.DSC_LENGTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSC_MANDATORY_PTID), "DSCMandatory");
        m_reverse_nameMap.put("DSCMandatory", new Integer(JdapiTypes.DSC_MANDATORY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSC_NAME_PTID), "DSCName");
        m_reverse_nameMap.put("DSCName", new Integer(JdapiTypes.DSC_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSC_NOCHILDREN_PTID), "DSCNochildren");
        m_reverse_nameMap.put("DSCNochildren", new Integer(JdapiTypes.DSC_NOCHILDREN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSC_PARENT_NAME_PTID), "DSCParentName");
        m_reverse_nameMap.put("DSCParentName", new Integer(JdapiTypes.DSC_PARENT_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSC_PRECISION_PTID), "DSCPrecision");
        m_reverse_nameMap.put("DSCPrecision", new Integer(JdapiTypes.DSC_PRECISION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSC_SCALE_PTID), "DSCScale");
        m_reverse_nameMap.put("DSCScale", new Integer(JdapiTypes.DSC_SCALE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSC_TYPE_NAME_PTID), "DSCTypeName");
        m_reverse_nameMap.put("DSCTypeName", new Integer(JdapiTypes.DSC_TYPE_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.DSC_TYPE_PTID), "DSCType");
        m_reverse_nameMap.put("DSCType", new Integer(JdapiTypes.DSC_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.EDGE_BACK_COLOR_PTID), "EdgeBackColor");
        m_reverse_nameMap.put("EdgeBackColor", new Integer(JdapiTypes.EDGE_BACK_COLOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.EDGE_FOREGROUND_COLOR_PTID), "EdgeForegroundColor");
        m_reverse_nameMap.put("EdgeForegroundColor", new Integer(JdapiTypes.EDGE_FOREGROUND_COLOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.EDGE_PATTERN_PTID), "EdgePattern");
        m_reverse_nameMap.put("EdgePattern", new Integer(JdapiTypes.EDGE_PATTERN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.EDITOR_HEIGHT_PTID), "EditorHeight");
        m_reverse_nameMap.put("EditorHeight", new Integer(JdapiTypes.EDITOR_HEIGHT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.EDITOR_PTID), "Editor");
        m_reverse_nameMap.put("Editor", new Integer(JdapiTypes.EDITOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.EDITOR_WIDTH_PTID), "EditorWidth");
        m_reverse_nameMap.put("EditorWidth", new Integer(JdapiTypes.EDITOR_WIDTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.EDIT_NAME_PTID), "EditName");
        m_reverse_nameMap.put("EditName", new Integer(JdapiTypes.EDIT_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.EDIT_OBJECT_PTID), "EditObject");
        m_reverse_nameMap.put("EditObject", new Integer(JdapiTypes.EDIT_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.EDIT_X_POSITION_PTID), "EditXPosition");
        m_reverse_nameMap.put("EditXPosition", new Integer(JdapiTypes.EDIT_X_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.EDIT_Y_POSITION_PTID), "EditYPosition");
        m_reverse_nameMap.put("EditYPosition", new Integer(JdapiTypes.EDIT_Y_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ENABLED_PTID), "Enabled");
        m_reverse_nameMap.put("Enabled", new Integer(JdapiTypes.ENABLED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ENFORCED_COLUMN_SECURITY_PTID), "EnforcedColumnSecurity");
        m_reverse_nameMap.put("EnforcedColumnSecurity", new Integer(JdapiTypes.ENFORCED_COLUMN_SECURITY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ENFORCED_PRIMARY_KEY_PTID), "EnforcedPrimaryKey");
        m_reverse_nameMap.put("EnforcedPrimaryKey", new Integer(JdapiTypes.ENFORCED_PRIMARY_KEY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.EXECUTE_HIERARCHY_PTID), "ExecuteHierarchy");
        m_reverse_nameMap.put("ExecuteHierarchy", new Integer(JdapiTypes.EXECUTE_HIERARCHY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.EXECUTE_MODE_PTID), "ExecuteMode");
        m_reverse_nameMap.put("ExecuteMode", new Integer(JdapiTypes.EXECUTE_MODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FILENAME_PTID), "Filename");
        m_reverse_nameMap.put("Filename", new Integer(JdapiTypes.FILENAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FILL_PATTERN_PTID), "FillPattern");
        m_reverse_nameMap.put("FillPattern", new Integer(JdapiTypes.FILL_PATTERN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FILTER_BEFORE_DISPLAY_PTID), "FilterBeforeDisplay");
        m_reverse_nameMap.put("FilterBeforeDisplay", new Integer(JdapiTypes.FILTER_BEFORE_DISPLAY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FIRE_IN_QUERY_PTID), "FireInQuery");
        m_reverse_nameMap.put("FireInQuery", new Integer(JdapiTypes.FIRE_IN_QUERY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FIRST_NAVIGATION_BLOCK_NAME_PTID), "FirstNavigationBlockName");
        m_reverse_nameMap.put("FirstNavigationBlockName", new Integer(JdapiTypes.FIRST_NAVIGATION_BLOCK_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FIRST_NAVIGATION_BLOCK_OBJECT_PTID), "FirstNavigationBlockObject");
        m_reverse_nameMap.put("FirstNavigationBlockObject", new Integer(JdapiTypes.FIRST_NAVIGATION_BLOCK_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FIXED_BOUNDING_BOX_PTID), "FixedBoundingBox");
        m_reverse_nameMap.put("FixedBoundingBox", new Integer(JdapiTypes.FIXED_BOUNDING_BOX_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FIXED_LENGTH_PTID), "FixedLength");
        m_reverse_nameMap.put("FixedLength", new Integer(JdapiTypes.FIXED_LENGTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FONT_NAME_PTID), "FontName");
        m_reverse_nameMap.put("FontName", new Integer(JdapiTypes.FONT_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FONT_SCALEABLE_PTID), "FontScaleable");
        m_reverse_nameMap.put("FontScaleable", new Integer(JdapiTypes.FONT_SCALEABLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FONT_SIZE_PTID), "FontSize");
        m_reverse_nameMap.put("FontSize", new Integer(JdapiTypes.FONT_SIZE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FONT_SPACING_PTID), "FontSpacing");
        m_reverse_nameMap.put("FontSpacing", new Integer(JdapiTypes.FONT_SPACING_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FONT_STYLE_PTID), "FontStyle");
        m_reverse_nameMap.put("FontStyle", new Integer(JdapiTypes.FONT_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FONT_WEIGHT_PTID), "FontWeight");
        m_reverse_nameMap.put("FontWeight", new Integer(JdapiTypes.FONT_WEIGHT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FOREGROUND_COLOR_PTID), "ForegroundColor");
        m_reverse_nameMap.put("ForegroundColor", new Integer(JdapiTypes.FOREGROUND_COLOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FORMAT_MASK_PTID), "FormatMask");
        m_reverse_nameMap.put("FormatMask", new Integer(JdapiTypes.FORMAT_MASK_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FORMULA_PTID), "Formula");
        m_reverse_nameMap.put("Formula", new Integer(JdapiTypes.FORMULA_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FORM_PARAMETER_PTID), "FormParameter");
        m_reverse_nameMap.put("FormParameter", new Integer(JdapiTypes.FORM_PARAMETER_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_ALIGN_PTID), "FrameAlign");
        m_reverse_nameMap.put("FrameAlign", new Integer(JdapiTypes.FRAME_ALIGN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_ALIGN_PTID), "FrameTitleAlign");
        m_reverse_nameMap.put("FrameTitleAlign", new Integer(JdapiTypes.FRAME_TITLE_ALIGN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_BACK_COLOR_PTID), "FrameTitleBackColor");
        m_reverse_nameMap.put("FrameTitleBackColor", new Integer(JdapiTypes.FRAME_TITLE_BACK_COLOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_FILL_PATTERN_PTID), "FrameTitleFillPattern");
        m_reverse_nameMap.put("FrameTitleFillPattern", new Integer(JdapiTypes.FRAME_TITLE_FILL_PATTERN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_FONT_NAME_PTID), "FrameTitleFontName");
        m_reverse_nameMap.put("FrameTitleFontName", new Integer(JdapiTypes.FRAME_TITLE_FONT_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_FONT_SIZE_PTID), "FrameTitleFontSize");
        m_reverse_nameMap.put("FrameTitleFontSize", new Integer(JdapiTypes.FRAME_TITLE_FONT_SIZE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_FONT_SPACING_PTID), "FrameTitleFontSpacing");
        m_reverse_nameMap.put("FrameTitleFontSpacing", new Integer(JdapiTypes.FRAME_TITLE_FONT_SPACING_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_FONT_STYLE_PTID), "FrameTitleFontStyle");
        m_reverse_nameMap.put("FrameTitleFontStyle", new Integer(JdapiTypes.FRAME_TITLE_FONT_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_FONT_WEIGHT_PTID), "FrameTitleFontWeight");
        m_reverse_nameMap.put("FrameTitleFontWeight", new Integer(JdapiTypes.FRAME_TITLE_FONT_WEIGHT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_FOREGROUND_COLOR_PTID), "FrameTitleForegroundColor");
        m_reverse_nameMap.put("FrameTitleForegroundColor", new Integer(JdapiTypes.FRAME_TITLE_FOREGROUND_COLOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_OFFSET_PTID), "FrameTitleOffset");
        m_reverse_nameMap.put("FrameTitleOffset", new Integer(JdapiTypes.FRAME_TITLE_OFFSET_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_PTID), "FrameTitle");
        m_reverse_nameMap.put("FrameTitle", new Integer(JdapiTypes.FRAME_TITLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_SPACING_PTID), "FrameTitleSpacing");
        m_reverse_nameMap.put("FrameTitleSpacing", new Integer(JdapiTypes.FRAME_TITLE_SPACING_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_NAME_PTID), "FrameTitleVisualAttributeName");
        m_reverse_nameMap.put("FrameTitleVisualAttributeName", new Integer(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_OBJECT_PTID), "FrameTitleVisualAttributeObject");
        m_reverse_nameMap.put("FrameTitleVisualAttributeObject", new Integer(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRAPHICS_FONT_COLOR_CODE_PTID), "GraphicsFontColorCode");
        m_reverse_nameMap.put("GraphicsFontColorCode", new Integer(JdapiTypes.GRAPHICS_FONT_COLOR_CODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRAPHICS_FONT_COLOR_PTID), "GraphicsFontColor");
        m_reverse_nameMap.put("GraphicsFontColor", new Integer(JdapiTypes.GRAPHICS_FONT_COLOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRAPHICS_FONT_NAME_PTID), "GraphicsFontName");
        m_reverse_nameMap.put("GraphicsFontName", new Integer(JdapiTypes.GRAPHICS_FONT_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRAPHICS_FONT_SIZE_PTID), "GraphicsFontSize");
        m_reverse_nameMap.put("GraphicsFontSize", new Integer(JdapiTypes.GRAPHICS_FONT_SIZE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRAPHICS_FONT_SPACING_PTID), "GraphicsFontSpacing");
        m_reverse_nameMap.put("GraphicsFontSpacing", new Integer(JdapiTypes.GRAPHICS_FONT_SPACING_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRAPHICS_FONT_STYLE_PTID), "GraphicsFontStyle");
        m_reverse_nameMap.put("GraphicsFontStyle", new Integer(JdapiTypes.GRAPHICS_FONT_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRAPHICS_FONT_WEIGHT_PTID), "GraphicsFontWeight");
        m_reverse_nameMap.put("GraphicsFontWeight", new Integer(JdapiTypes.GRAPHICS_FONT_WEIGHT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRAPHICS_TEXT_PTID), "GraphicsText");
        m_reverse_nameMap.put("GraphicsText", new Integer(JdapiTypes.GRAPHICS_TEXT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRAPHICS_TYPE_PTID), "GraphicsType");
        m_reverse_nameMap.put("GraphicsType", new Integer(JdapiTypes.GRAPHICS_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRAPHIC_PTID), "Graphic");
        m_reverse_nameMap.put("Graphic", new Integer(JdapiTypes.GRAPHIC_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRIDSNAP_FLAG_PTID), "GridsnapFlag");
        m_reverse_nameMap.put("GridsnapFlag", new Integer(JdapiTypes.GRIDSNAP_FLAG_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRID_FLAG_PTID), "GridFlag");
        m_reverse_nameMap.put("GridFlag", new Integer(JdapiTypes.GRID_FLAG_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRID_INTERVAL_CNT_PTID), "GridIntervalCnt");
        m_reverse_nameMap.put("GridIntervalCnt", new Integer(JdapiTypes.GRID_INTERVAL_CNT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRID_SNAP_CNT_PTID), "GridSnapCnt");
        m_reverse_nameMap.put("GridSnapCnt", new Integer(JdapiTypes.GRID_SNAP_CNT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.GRID_UNIT_CNT_PTID), "GridUnitCnt");
        m_reverse_nameMap.put("GridUnitCnt", new Integer(JdapiTypes.GRID_UNIT_CNT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HEIGHT_PTID), "Height");
        m_reverse_nameMap.put("Height", new Integer(JdapiTypes.HEIGHT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HELP_BOOK_TITLE_PTID), "HelpBookTitle");
        m_reverse_nameMap.put("HelpBookTitle", new Integer(JdapiTypes.HELP_BOOK_TITLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HELP_BOOK_TOPIC_PTID), "HelpBookTopic");
        m_reverse_nameMap.put("HelpBookTopic", new Integer(JdapiTypes.HELP_BOOK_TOPIC_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HIDE_ON_EXIT_PTID), "HideOnExit");
        m_reverse_nameMap.put("HideOnExit", new Integer(JdapiTypes.HIDE_ON_EXIT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HIDE_PTID), "Hide");
        m_reverse_nameMap.put("Hide", new Integer(JdapiTypes.HIDE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HIGHEST_ALLOWED_VALUE_PTID), "HighestAllowedValue");
        m_reverse_nameMap.put("HighestAllowedValue", new Integer(JdapiTypes.HIGHEST_ALLOWED_VALUE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HINT_PTID), "Hint");
        m_reverse_nameMap.put("Hint", new Integer(JdapiTypes.HINT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HORIZONTALTOOLBAR_CANVAS_NAME_PTID), "HorizontalToolbarCanvasName");
        m_reverse_nameMap.put("HorizontalToolbarCanvasName", new Integer(JdapiTypes.HORIZONTALTOOLBAR_CANVAS_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HORIZONTAL_JUSTIFICATION_PTID), "HorizontalJustification");
        m_reverse_nameMap.put("HorizontalJustification", new Integer(JdapiTypes.HORIZONTAL_JUSTIFICATION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HORIZONTAL_MARGIN_PTID), "HorizontalMargin");
        m_reverse_nameMap.put("HorizontalMargin", new Integer(JdapiTypes.HORIZONTAL_MARGIN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HORIZONTAL_OBJECT_OFFSET_PTID), "HorizontalObjectOffset");
        m_reverse_nameMap.put("HorizontalObjectOffset", new Integer(JdapiTypes.HORIZONTAL_OBJECT_OFFSET_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HORIZONTAL_ORIGIN_PTID), "HorizontalOrigin");
        m_reverse_nameMap.put("HorizontalOrigin", new Integer(JdapiTypes.HORIZONTAL_ORIGIN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.HORIZONTAL_TOOLBAR_CANVAS_PTID), "HorizontalToolbarCanvas");
        m_reverse_nameMap.put("HorizontalToolbarCanvas", new Integer(JdapiTypes.HORIZONTAL_TOOLBAR_CANVAS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ICONIC_PTID), "Iconic");
        m_reverse_nameMap.put("Iconic", new Integer(JdapiTypes.ICONIC_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ICON_FILENAME_PTID), "IconFilename");
        m_reverse_nameMap.put("IconFilename", new Integer(JdapiTypes.ICON_FILENAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ICON_IN_MENU_PTID), "IconInMenu");
        m_reverse_nameMap.put("IconInMenu", new Integer(JdapiTypes.ICON_IN_MENU_PTID));
        m_nameMap.put(new Integer(JdapiTypes.IMAGE_DEPTH_PTID), "ImageDepth");
        m_reverse_nameMap.put("ImageDepth", new Integer(JdapiTypes.IMAGE_DEPTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.IMAGE_FORMAT_PTID), "ImageFormat");
        m_reverse_nameMap.put("ImageFormat", new Integer(JdapiTypes.IMAGE_FORMAT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.IMPLEMENTATION_CLASS_PTID), "ImplementationClass");
        m_reverse_nameMap.put("ImplementationClass", new Integer(JdapiTypes.IMPLEMENTATION_CLASS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INCLUDE_REFITEM_PTID), "IncludeRefitem");
        m_reverse_nameMap.put("IncludeRefitem", new Integer(JdapiTypes.INCLUDE_REFITEM_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INHERIT_MENU_PTID), "InheritMenu");
        m_reverse_nameMap.put("InheritMenu", new Integer(JdapiTypes.INHERIT_MENU_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INITIALIZE_KEYBOARD_DIRECTION_PTID), "InitializeKeyboardDirection");
        m_reverse_nameMap.put("InitializeKeyboardDirection", new Integer(JdapiTypes.INITIALIZE_KEYBOARD_DIRECTION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INITIALIZE_MENU_PTID), "InitializeMenu");
        m_reverse_nameMap.put("InitializeMenu", new Integer(JdapiTypes.INITIALIZE_MENU_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INITIALIZE_VALUE_PTID), "InitializeValue");
        m_reverse_nameMap.put("InitializeValue", new Integer(JdapiTypes.INITIALIZE_VALUE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INSERT_ALLOWED_PTID), "InsertAllowed");
        m_reverse_nameMap.put("InsertAllowed", new Integer(JdapiTypes.INSERT_ALLOWED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INSERT_DATA_SOURCE_ARGUMENT_PTID), "InsertDataSourceArgument");
        m_reverse_nameMap.put("InsertDataSourceArgument", new Integer(JdapiTypes.INSERT_DATA_SOURCE_ARGUMENT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INSERT_DATA_SOURCE_COLUMN_PTID), "InsertDataSourceColumn");
        m_reverse_nameMap.put("InsertDataSourceColumn", new Integer(JdapiTypes.INSERT_DATA_SOURCE_COLUMN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INSERT_PROCEDURE_NAME_PTID), "InsertProcedureName");
        m_reverse_nameMap.put("InsertProcedureName", new Integer(JdapiTypes.INSERT_PROCEDURE_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INTERACTION_MODE_PTID), "InteractionMode");
        m_reverse_nameMap.put("InteractionMode", new Integer(JdapiTypes.INTERACTION_MODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INTERNAL_END_ANGLE_PTID), "InternalEndAngle");
        m_reverse_nameMap.put("InternalEndAngle", new Integer(JdapiTypes.INTERNAL_END_ANGLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INTERNAL_LINE_WIDTH_PTID), "InternalLineWidth");
        m_reverse_nameMap.put("InternalLineWidth", new Integer(JdapiTypes.INTERNAL_LINE_WIDTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INTERNAL_ROTATION_ANGLE_PTID), "InternalRotationAngle");
        m_reverse_nameMap.put("InternalRotationAngle", new Integer(JdapiTypes.INTERNAL_ROTATION_ANGLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.INTERNAL_START_ANGLE_PTID), "InternalStartAngle");
        m_reverse_nameMap.put("InternalStartAngle", new Integer(JdapiTypes.INTERNAL_START_ANGLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ISOLATION_MODE_PTID), "IsolationMode");
        m_reverse_nameMap.put("IsolationMode", new Integer(JdapiTypes.ISOLATION_MODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ITEMS_DISPLAY_PTID), "ItemsDisplay");
        m_reverse_nameMap.put("ItemsDisplay", new Integer(JdapiTypes.ITEMS_DISPLAY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ITEM_PTID), "Item");
        m_reverse_nameMap.put("Item", new Integer(JdapiTypes.ITEM_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ITEM_TYPE_PTID), "ItemType");
        m_reverse_nameMap.put("ItemType", new Integer(JdapiTypes.ITEM_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.JOIN_CONDITION_PTID), "JoinCondition");
        m_reverse_nameMap.put("JoinCondition", new Integer(JdapiTypes.JOIN_CONDITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.JOIN_STYLE_PTID), "JoinStyle");
        m_reverse_nameMap.put("JoinStyle", new Integer(JdapiTypes.JOIN_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.JUSTIFICATION_PTID), "Justification");
        m_reverse_nameMap.put("Justification", new Integer(JdapiTypes.JUSTIFICATION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.KEEP_CURSOR_POSITION_PTID), "KeepCursorPosition");
        m_reverse_nameMap.put("KeepCursorPosition", new Integer(JdapiTypes.KEEP_CURSOR_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.KEYBOARD_ACCELERATOR_PTID), "KeyboardAccelerator");
        m_reverse_nameMap.put("KeyboardAccelerator", new Integer(JdapiTypes.KEYBOARD_ACCELERATOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.KEYBOARD_HELP_TEXT_PTID), "KeyboardHelpText");
        m_reverse_nameMap.put("KeyboardHelpText", new Integer(JdapiTypes.KEYBOARD_HELP_TEXT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.KEYBOARD_NAVIGABLE_PTID), "KeyboardNavigable");
        m_reverse_nameMap.put("KeyboardNavigable", new Integer(JdapiTypes.KEYBOARD_NAVIGABLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.KEYBOARD_STATE_PTID), "KeyboardState");
        m_reverse_nameMap.put("KeyboardState", new Integer(JdapiTypes.KEYBOARD_STATE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.KEY_MODE_PTID), "KeyMode");
        m_reverse_nameMap.put("KeyMode", new Integer(JdapiTypes.KEY_MODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LABEL_PTID), "Label");
        m_reverse_nameMap.put("Label", new Integer(JdapiTypes.LABEL_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LANGUAGE_DIRECTION_PTID), "LanguageDirection");
        m_reverse_nameMap.put("LanguageDirection", new Integer(JdapiTypes.LANGUAGE_DIRECTION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LAYOUT_DATA_BLOCK_NAME_PTID), "LayoutDataBlockName");
        m_reverse_nameMap.put("LayoutDataBlockName", new Integer(JdapiTypes.LAYOUT_DATA_BLOCK_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LAYOUT_STYLE_PTID), "LayoutStyle");
        m_reverse_nameMap.put("LayoutStyle", new Integer(JdapiTypes.LAYOUT_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LIBRARY_LOCATION_PTID), "LibraryLocation");
        m_reverse_nameMap.put("LibraryLocation", new Integer(JdapiTypes.LIBRARY_LOCATION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LIBRARY_PROGRAM_UNIT_PTID), "LibraryProgramUnit");
        m_reverse_nameMap.put("LibraryProgramUnit", new Integer(JdapiTypes.LIBRARY_PROGRAM_UNIT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LIBRARY_SOURCE_PTID), "LibrarySource");
        m_reverse_nameMap.put("LibrarySource", new Integer(JdapiTypes.LIBRARY_SOURCE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LINE_SPACING_PTID), "LineSpacing");
        m_reverse_nameMap.put("LineSpacing", new Integer(JdapiTypes.LINE_SPACING_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LIST_ELEMENT_COUNT_PTID), "ListElementCount");
        m_reverse_nameMap.put("ListElementCount", new Integer(JdapiTypes.LIST_ELEMENT_COUNT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LIST_STYLE_PTID), "ListStyle");
        m_reverse_nameMap.put("ListStyle", new Integer(JdapiTypes.LIST_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LIST_TYPE_PTID), "ListType");
        m_reverse_nameMap.put("ListType", new Integer(JdapiTypes.LIST_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LOCK_DATA_SOURCE_ARGUMENT_PTID), "LockDataSourceArgument");
        m_reverse_nameMap.put("LockDataSourceArgument", new Integer(JdapiTypes.LOCK_DATA_SOURCE_ARGUMENT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LOCK_DATA_SOURCE_COLUMN_PTID), "LockDataSourceColumn");
        m_reverse_nameMap.put("LockDataSourceColumn", new Integer(JdapiTypes.LOCK_DATA_SOURCE_COLUMN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LOCK_MODE_PTID), "LockMode");
        m_reverse_nameMap.put("LockMode", new Integer(JdapiTypes.LOCK_MODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LOCK_PROCEDURE_NAME_PTID), "LockProcedureName");
        m_reverse_nameMap.put("LockProcedureName", new Integer(JdapiTypes.LOCK_PROCEDURE_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LOCK_RECORD_PTID), "LockRecord");
        m_reverse_nameMap.put("LockRecord", new Integer(JdapiTypes.LOCK_RECORD_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LOV_NAME_PTID), "LovName");
        m_reverse_nameMap.put("LovName", new Integer(JdapiTypes.LOV_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LOV_OBJECT_PTID), "LovObject");
        m_reverse_nameMap.put("LovObject", new Integer(JdapiTypes.LOV_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LOV_PTID), "Lov");
        m_reverse_nameMap.put("Lov", new Integer(JdapiTypes.LOV_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LOV_X_POSITION_PTID), "LovXPosition");
        m_reverse_nameMap.put("LovXPosition", new Integer(JdapiTypes.LOV_X_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LOV_Y_POSITION_PTID), "LovYPosition");
        m_reverse_nameMap.put("LovYPosition", new Integer(JdapiTypes.LOV_Y_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.LOWEST_ALLOWED_VALUE_PTID), "LowestAllowedValue");
        m_reverse_nameMap.put("LowestAllowedValue", new Integer(JdapiTypes.LOWEST_ALLOWED_VALUE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MAGIC_ITEM_PTID), "MagicItem");
        m_reverse_nameMap.put("MagicItem", new Integer(JdapiTypes.MAGIC_ITEM_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MAIN_MENU_PTID), "MainMenu");
        m_reverse_nameMap.put("MainMenu", new Integer(JdapiTypes.MAIN_MENU_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MAXIMIZE_ALLOWED_PTID), "MaximizeAllowed");
        m_reverse_nameMap.put("MaximizeAllowed", new Integer(JdapiTypes.MAXIMIZE_ALLOWED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MAXIMUM_LENGTH_PTID), "MaximumLength");
        m_reverse_nameMap.put("MaximumLength", new Integer(JdapiTypes.MAXIMUM_LENGTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MAXIMUM_OBJS_PTID), "MaximumObjs");
        m_reverse_nameMap.put("MaximumObjs", new Integer(JdapiTypes.MAXIMUM_OBJS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MAXIMUM_QUERY_TIME_PTID), "MaximumQueryTime");
        m_reverse_nameMap.put("MaximumQueryTime", new Integer(JdapiTypes.MAXIMUM_QUERY_TIME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MAXIMUM_RECORDS_FETCHED_PTID), "MaximumRecordsFetched");
        m_reverse_nameMap.put("MaximumRecordsFetched", new Integer(JdapiTypes.MAXIMUM_RECORDS_FETCHED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MENU_DIRECTORY_PTID), "MenuDirectory");
        m_reverse_nameMap.put("MenuDirectory", new Integer(JdapiTypes.MENU_DIRECTORY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MENU_FILENAME_PTID), "MenuFilename");
        m_reverse_nameMap.put("MenuFilename", new Integer(JdapiTypes.MENU_FILENAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MENU_ITEM_CODE_PTID), "MenuItemCode");
        m_reverse_nameMap.put("MenuItemCode", new Integer(JdapiTypes.MENU_ITEM_CODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MENU_ITEM_PTID), "MenuItem");
        m_reverse_nameMap.put("MenuItem", new Integer(JdapiTypes.MENU_ITEM_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MENU_ITEM_RADIO_GROUP_PTID), "MenuItemRadioGroup");
        m_reverse_nameMap.put("MenuItemRadioGroup", new Integer(JdapiTypes.MENU_ITEM_RADIO_GROUP_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MENU_ITEM_TYPE_PTID), "MenuItemType");
        m_reverse_nameMap.put("MenuItemType", new Integer(JdapiTypes.MENU_ITEM_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MENU_MODULE_PTID), "MenuModule");
        m_reverse_nameMap.put("MenuModule", new Integer(JdapiTypes.MENU_MODULE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MENU_PTID), "Menu");
        m_reverse_nameMap.put("Menu", new Integer(JdapiTypes.MENU_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MENU_ROLE_PTID), "MenuRole");
        m_reverse_nameMap.put("MenuRole", new Integer(JdapiTypes.MENU_ROLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MINIMIZE_ALLOWED_PTID), "MinimizeAllowed");
        m_reverse_nameMap.put("MinimizeAllowed", new Integer(JdapiTypes.MINIMIZE_ALLOWED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MINIMIZE_TITLE_PTID), "MinimizeTitle");
        m_reverse_nameMap.put("MinimizeTitle", new Integer(JdapiTypes.MINIMIZE_TITLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MODAL_PTID), "Modal");
        m_reverse_nameMap.put("Modal", new Integer(JdapiTypes.MODAL_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MODULE_PTID), "Module");
        m_reverse_nameMap.put("Module", new Integer(JdapiTypes.MODULE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MOUSE_NAVIGATE_PTID), "MouseNavigate");
        m_reverse_nameMap.put("MouseNavigate", new Integer(JdapiTypes.MOUSE_NAVIGATE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MOUSE_NAVIGATION_LIMIT_PTID), "MouseNavigationLimit");
        m_reverse_nameMap.put("MouseNavigationLimit", new Integer(JdapiTypes.MOUSE_NAVIGATION_LIMIT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MOVE_ALLOWED_PTID), "MoveAllowed");
        m_reverse_nameMap.put("MoveAllowed", new Integer(JdapiTypes.MOVE_ALLOWED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.MULTI_LINE_PTID), "MultiLine");
        m_reverse_nameMap.put("MultiLine", new Integer(JdapiTypes.MULTI_LINE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.NAME_PTID), "Name");
        m_reverse_nameMap.put("Name", new Integer(JdapiTypes.NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.NAVIGATION_STYLE_PTID), "NavigationStyle");
        m_reverse_nameMap.put("NavigationStyle", new Integer(JdapiTypes.NAVIGATION_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.NEWDEFER_REQ_ENF_PTID), "NewdeferReqEnf");
        m_reverse_nameMap.put("NewdeferReqEnf", new Integer(JdapiTypes.NEWDEFER_REQ_ENF_PTID));
        m_nameMap.put(new Integer(JdapiTypes.NEXT_NAVIGATION_BLOCK_NAME_PTID), "NextNavigationBlockName");
        m_reverse_nameMap.put("NextNavigationBlockName", new Integer(JdapiTypes.NEXT_NAVIGATION_BLOCK_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.NEXT_NAVIGATION_BLOCK_OBJECT_PTID), "NextNavigationBlockObject");
        m_reverse_nameMap.put("NextNavigationBlockObject", new Integer(JdapiTypes.NEXT_NAVIGATION_BLOCK_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.NEXT_NAVIGATION_ITEM_NAME_PTID), "NextNavigationItemName");
        m_reverse_nameMap.put("NextNavigationItemName", new Integer(JdapiTypes.NEXT_NAVIGATION_ITEM_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.NEXT_NAVIGATION_ITEM_OBJECT_PTID), "NextNavigationItemObject");
        m_reverse_nameMap.put("NextNavigationItemObject", new Integer(JdapiTypes.NEXT_NAVIGATION_ITEM_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.NEXT_PTID), "Next");
        m_reverse_nameMap.put("Next", new Integer(JdapiTypes.NEXT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OBJECTGROUP_CHILD_PTID), "ObjectGroupChild");
        m_reverse_nameMap.put("ObjectGroupChild", new Integer(JdapiTypes.OBJECTGROUP_CHILD_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OBJECT_COUNT_PTID), "ObjectCount");
        m_reverse_nameMap.put("ObjectCount", new Integer(JdapiTypes.OBJECT_COUNT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OBJECT_GROUP_CHILD_REAL_OBJECT_PTID), "ObjectGroupChildRealObject");
        m_reverse_nameMap.put("ObjectGroupChildRealObject", new Integer(JdapiTypes.OBJECT_GROUP_CHILD_REAL_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OBJECT_GROUP_PTID), "ObjectGroup");
        m_reverse_nameMap.put("ObjectGroup", new Integer(JdapiTypes.OBJECT_GROUP_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OBJECT_GROUP_TYPE_PTID), "ObjectGroupType");
        m_reverse_nameMap.put("ObjectGroupType", new Integer(JdapiTypes.OBJECT_GROUP_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OBJECT_LIBRARY_TAB_PTID), "ObjectLibraryTab");
        m_reverse_nameMap.put("ObjectLibraryTab", new Integer(JdapiTypes.OBJECT_LIBRARY_TAB_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OLD_LOV_TEXT_PTID), "OldLovText");
        m_reverse_nameMap.put("OldLovText", new Integer(JdapiTypes.OLD_LOV_TEXT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OLE_ACTION_STYLE_PTID), "OleActionStyle");
        m_reverse_nameMap.put("OleActionStyle", new Integer(JdapiTypes.OLE_ACTION_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OLE_CLASS_PTID), "OleClass");
        m_reverse_nameMap.put("OleClass", new Integer(JdapiTypes.OLE_CLASS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OLE_INSIDE_OUT_SUPPORT_PTID), "OleInsideOutSupport");
        m_reverse_nameMap.put("OleInsideOutSupport", new Integer(JdapiTypes.OLE_INSIDE_OUT_SUPPORT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OLE_IN_PLACE_ACTION_PTID), "OleInPlaceAction");
        m_reverse_nameMap.put("OleInPlaceAction", new Integer(JdapiTypes.OLE_IN_PLACE_ACTION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OLE_POPUP_MENU_ITEMS_PTID), "OlePopupMenuItems");
        m_reverse_nameMap.put("OlePopupMenuItems", new Integer(JdapiTypes.OLE_POPUP_MENU_ITEMS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OLE_RESIZ_STYLE_PTID), "OleResizStyle");
        m_reverse_nameMap.put("OleResizStyle", new Integer(JdapiTypes.OLE_RESIZ_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OLE_SHOW_POPUP_MENU_PTID), "OleShowPopupMenu");
        m_reverse_nameMap.put("OleShowPopupMenu", new Integer(JdapiTypes.OLE_SHOW_POPUP_MENU_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OLE_SHOW_TENANTTYPE_TYPE_PTID), "OleShowTenantTypeType");
        m_reverse_nameMap.put("OleShowTenantTypeType", new Integer(JdapiTypes.OLE_SHOW_TENANTTYPE_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OLE_TENANTTYPE_ASPECT_PTID), "OleTenantTypeAspect");
        m_reverse_nameMap.put("OleTenantTypeAspect", new Integer(JdapiTypes.OLE_TENANTTYPE_ASPECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OLE_TENANTTYPE_TYPE_PTID), "OleTenantTypeType");
        m_reverse_nameMap.put("OleTenantTypeType", new Integer(JdapiTypes.OLE_TENANTTYPE_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OPTION_HINT_PTID), "OptionHint");
        m_reverse_nameMap.put("OptionHint", new Integer(JdapiTypes.OPTION_HINT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ORDER_BY_CLAUSE_PTID), "OrderByClause");
        m_reverse_nameMap.put("OrderByClause", new Integer(JdapiTypes.ORDER_BY_CLAUSE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OTHER_VALUES_PTID), "OtherValues");
        m_reverse_nameMap.put("OtherValues", new Integer(JdapiTypes.OTHER_VALUES_PTID));
        m_nameMap.put(new Integer(JdapiTypes.OWNER_PTID), "Owner");
        m_reverse_nameMap.put("Owner", new Integer(JdapiTypes.OWNER_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PAGEBREAK_FLAG_PTID), "PagebreakFlag");
        m_reverse_nameMap.put("PagebreakFlag", new Integer(JdapiTypes.PAGEBREAK_FLAG_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PAGE_COUNT_SEQ_PTID), "PageCountSeq");
        m_reverse_nameMap.put("PageCountSeq", new Integer(JdapiTypes.PAGE_COUNT_SEQ_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PARAMETER_DATA_TYPE_PTID), "ParameterDataType");
        m_reverse_nameMap.put("ParameterDataType", new Integer(JdapiTypes.PARAMETER_DATA_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PARAMETER_INITIALIZE_VALUE_PTID), "ParameterInitializeValue");
        m_reverse_nameMap.put("ParameterInitializeValue", new Integer(JdapiTypes.PARAMETER_INITIALIZE_VALUE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PARENT_FILENAME_PTID), "ParentFilename");
        m_reverse_nameMap.put("ParentFilename", new Integer(JdapiTypes.PARENT_FILENAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PARENT_FILEPATH_PTID), "ParentFilepath");
        m_reverse_nameMap.put("ParentFilepath", new Integer(JdapiTypes.PARENT_FILEPATH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PARENT_MODULETYPE_PTID), "ParentModuleType");
        m_reverse_nameMap.put("ParentModuleType", new Integer(JdapiTypes.PARENT_MODULETYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PARENT_MODULE_PTID), "ParentModule");
        m_reverse_nameMap.put("ParentModule", new Integer(JdapiTypes.PARENT_MODULE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PARENT_NAME_PTID), "ParentName");
        m_reverse_nameMap.put("ParentName", new Integer(JdapiTypes.PARENT_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID), "ParentSourceLevel1ObjectName");
        m_reverse_nameMap.put("ParentSourceLevel1ObjectName", new Integer(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID), "ParentSourceLevel1ObjectType");
        m_reverse_nameMap.put("ParentSourceLevel1ObjectType", new Integer(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_NAME_PTID), "ParentSourceLevel2ObjectName");
        m_reverse_nameMap.put("ParentSourceLevel2ObjectName", new Integer(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_TYPE_PTID), "ParentSourceLevel2ObjectType");
        m_reverse_nameMap.put("ParentSourceLevel2ObjectType", new Integer(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PARENT_TYPE_PTID), "ParentType");
        m_reverse_nameMap.put("ParentType", new Integer(JdapiTypes.PARENT_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID), "PersistentClientInfoLength");
        m_reverse_nameMap.put("PersistentClientInfoLength", new Integer(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PERSISTENT_CLIENT_INFO_PTID), "PersistentClientInfo");
        m_reverse_nameMap.put("PersistentClientInfo", new Integer(JdapiTypes.PERSISTENT_CLIENT_INFO_PTID));
        m_nameMap.put(new Integer(JdapiTypes.POINT_PTID), "Point");
        m_reverse_nameMap.put("Point", new Integer(JdapiTypes.POINT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.POPUP_MENU_NAME_PTID), "PopupMenuName");
        m_reverse_nameMap.put("PopupMenuName", new Integer(JdapiTypes.POPUP_MENU_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.POPUP_MENU_OBJECT_PTID), "PopupMenuObject");
        m_reverse_nameMap.put("PopupMenuObject", new Integer(JdapiTypes.POPUP_MENU_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.POPUP_VISUALATTRIBUTE_OBJECT_PTID), "PopupVisualAttributeObject");
        m_reverse_nameMap.put("PopupVisualAttributeObject", new Integer(JdapiTypes.POPUP_VISUALATTRIBUTE_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PRECOMP_SUMMARY_PTID), "PrecompSummary");
        m_reverse_nameMap.put("PrecompSummary", new Integer(JdapiTypes.PRECOMP_SUMMARY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PREVENT_MASTERLESS_OPERATIONS_PTID), "PreventMasterlessOperations");
        m_reverse_nameMap.put("PreventMasterlessOperations", new Integer(JdapiTypes.PREVENT_MASTERLESS_OPERATIONS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PREVIOUS_NAVIGATION_BLOCK_NAME_PTID), "PreviousNavigationBlockName");
        m_reverse_nameMap.put("PreviousNavigationBlockName", new Integer(JdapiTypes.PREVIOUS_NAVIGATION_BLOCK_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PREVIOUS_NAVIGATION_BLOCK_OBJECT_PTID), "PreviousNavigationBlockObject");
        m_reverse_nameMap.put("PreviousNavigationBlockObject", new Integer(JdapiTypes.PREVIOUS_NAVIGATION_BLOCK_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PREVIOUS_NAVIGATION_ITEM_NAME_PTID), "PreviousNavigationItemName");
        m_reverse_nameMap.put("PreviousNavigationItemName", new Integer(JdapiTypes.PREVIOUS_NAVIGATION_ITEM_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PREVIOUS_NAVIGATION_ITEM_OBJECT_PTID), "PreviousNavigationItemObject");
        m_reverse_nameMap.put("PreviousNavigationItemObject", new Integer(JdapiTypes.PREVIOUS_NAVIGATION_ITEM_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PREVIOUS_PTID), "Previous");
        m_reverse_nameMap.put("Previous", new Integer(JdapiTypes.PREVIOUS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PRIMARY_CANVAS_PTID), "PrimaryCanvas");
        m_reverse_nameMap.put("PrimaryCanvas", new Integer(JdapiTypes.PRIMARY_CANVAS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PRIMARY_KEY_PTID), "PrimaryKey");
        m_reverse_nameMap.put("PrimaryKey", new Integer(JdapiTypes.PRIMARY_KEY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROGRAMUNIT_TEXT_PTID), "ProgramUnitText");
        m_reverse_nameMap.put("ProgramUnitText", new Integer(JdapiTypes.PROGRAMUNIT_TEXT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROGRAMUNIT_TYPE_PTID), "ProgramUnitType");
        m_reverse_nameMap.put("ProgramUnitType", new Integer(JdapiTypes.PROGRAMUNIT_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROGRAM_UNIT_PTID), "ProgramUnit");
        m_reverse_nameMap.put("ProgramUnit", new Integer(JdapiTypes.PROGRAM_UNIT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_ALIGN_OFFSET_PTID), "PromptAlignOffset");
        m_reverse_nameMap.put("PromptAlignOffset", new Integer(JdapiTypes.PROMPT_ALIGN_OFFSET_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_ALIGN_PTID), "PromptAlign");
        m_reverse_nameMap.put("PromptAlign", new Integer(JdapiTypes.PROMPT_ALIGN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_ATTACHMENT_EDGE_PTID), "PromptAttachmentEdge");
        m_reverse_nameMap.put("PromptAttachmentEdge", new Integer(JdapiTypes.PROMPT_ATTACHMENT_EDGE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_ATTACHMENT_OFFSET_PTID), "PromptAttachmentOffset");
        m_reverse_nameMap.put("PromptAttachmentOffset", new Integer(JdapiTypes.PROMPT_ATTACHMENT_OFFSET_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_BACK_COLOR_PTID), "PromptBackColor");
        m_reverse_nameMap.put("PromptBackColor", new Integer(JdapiTypes.PROMPT_BACK_COLOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_DISPLAY_STYLE_PTID), "PromptDisplayStyle");
        m_reverse_nameMap.put("PromptDisplayStyle", new Integer(JdapiTypes.PROMPT_DISPLAY_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_FILL_PATTERN_PTID), "PromptFillPattern");
        m_reverse_nameMap.put("PromptFillPattern", new Integer(JdapiTypes.PROMPT_FILL_PATTERN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_FONT_NAME_PTID), "PromptFontName");
        m_reverse_nameMap.put("PromptFontName", new Integer(JdapiTypes.PROMPT_FONT_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_FONT_SIZE_PTID), "PromptFontSize");
        m_reverse_nameMap.put("PromptFontSize", new Integer(JdapiTypes.PROMPT_FONT_SIZE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_FONT_SPACING_PTID), "PromptFontSpacing");
        m_reverse_nameMap.put("PromptFontSpacing", new Integer(JdapiTypes.PROMPT_FONT_SPACING_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_FONT_STYLE_PTID), "PromptFontStyle");
        m_reverse_nameMap.put("PromptFontStyle", new Integer(JdapiTypes.PROMPT_FONT_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_FONT_WEIGHT_PTID), "PromptFontWeight");
        m_reverse_nameMap.put("PromptFontWeight", new Integer(JdapiTypes.PROMPT_FONT_WEIGHT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_FOREGROUND_COLOR_PTID), "PromptForegroundColor");
        m_reverse_nameMap.put("PromptForegroundColor", new Integer(JdapiTypes.PROMPT_FOREGROUND_COLOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_JUSTIFICATION_PTID), "PromptJustification");
        m_reverse_nameMap.put("PromptJustification", new Integer(JdapiTypes.PROMPT_JUSTIFICATION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_PTID), "Prompt");
        m_reverse_nameMap.put("Prompt", new Integer(JdapiTypes.PROMPT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_READING_ORDER_PTID), "PromptReadingOrder");
        m_reverse_nameMap.put("PromptReadingOrder", new Integer(JdapiTypes.PROMPT_READING_ORDER_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_VISUALATTRIBUTE_NAME_PTID), "PromptVisualAttributeName");
        m_reverse_nameMap.put("PromptVisualAttributeName", new Integer(JdapiTypes.PROMPT_VISUALATTRIBUTE_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROMPT_VISUALATTRIBUTE_OBJECT_PTID), "PromptVisualAttributeObject");
        m_reverse_nameMap.put("PromptVisualAttributeObject", new Integer(JdapiTypes.PROMPT_VISUALATTRIBUTE_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.PROPERTY_CLASS_PTID), "PropertyClass");
        m_reverse_nameMap.put("PropertyClass", new Integer(JdapiTypes.PROPERTY_CLASS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.QUERY_ALLOWED_PTID), "QueryAllowed");
        m_reverse_nameMap.put("QueryAllowed", new Integer(JdapiTypes.QUERY_ALLOWED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.QUERY_ALL_RECORDS_PTID), "QueryAllRecords");
        m_reverse_nameMap.put("QueryAllRecords", new Integer(JdapiTypes.QUERY_ALL_RECORDS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.QUERY_DATA_SOURCE_ARGUMENT_PTID), "QueryDataSourceArgument");
        m_reverse_nameMap.put("QueryDataSourceArgument", new Integer(JdapiTypes.QUERY_DATA_SOURCE_ARGUMENT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.QUERY_DATA_SOURCE_COLUMN_PTID), "QueryDataSourceColumn");
        m_reverse_nameMap.put("QueryDataSourceColumn", new Integer(JdapiTypes.QUERY_DATA_SOURCE_COLUMN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.QUERY_DATA_SOURCE_NAME_PTID), "QueryDataSourceName");
        m_reverse_nameMap.put("QueryDataSourceName", new Integer(JdapiTypes.QUERY_DATA_SOURCE_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.QUERY_DATA_SOURCE_TYPE_PTID), "QueryDataSourceType");
        m_reverse_nameMap.put("QueryDataSourceType", new Integer(JdapiTypes.QUERY_DATA_SOURCE_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.QUERY_LENGTH_PTID), "QueryLength");
        m_reverse_nameMap.put("QueryLength", new Integer(JdapiTypes.QUERY_LENGTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.QUERY_NAME_PTID), "QueryName");
        m_reverse_nameMap.put("QueryName", new Integer(JdapiTypes.QUERY_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.QUERY_ONLY_PTID), "QueryOnly");
        m_reverse_nameMap.put("QueryOnly", new Integer(JdapiTypes.QUERY_ONLY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RADIOBUTTON_VALUE_PTID), "RadioButtonValue");
        m_reverse_nameMap.put("RadioButtonValue", new Integer(JdapiTypes.RADIOBUTTON_VALUE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RADIO_BUTTON_PTID), "RadioButton");
        m_reverse_nameMap.put("RadioButton", new Integer(JdapiTypes.RADIO_BUTTON_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RAISE_ON_ENTER_PTID), "RaiseOnEnter");
        m_reverse_nameMap.put("RaiseOnEnter", new Integer(JdapiTypes.RAISE_ON_ENTER_PTID));
        m_nameMap.put(new Integer(JdapiTypes.READING_ORDER_PTID), "ReadingOrder");
        m_reverse_nameMap.put("ReadingOrder", new Integer(JdapiTypes.READING_ORDER_PTID));
        m_nameMap.put(new Integer(JdapiTypes.REAL_UNIT_PTID), "RealUnit");
        m_reverse_nameMap.put("RealUnit", new Integer(JdapiTypes.REAL_UNIT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RECORDS_BUFFERED_COUNT_PTID), "RecordsBufferedCount");
        m_reverse_nameMap.put("RecordsBufferedCount", new Integer(JdapiTypes.RECORDS_BUFFERED_COUNT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RECORDS_DISPLAY_COUNT_PTID), "RecordsDisplayCount");
        m_reverse_nameMap.put("RecordsDisplayCount", new Integer(JdapiTypes.RECORDS_DISPLAY_COUNT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RECORDS_FETCHED_COUNT_PTID), "RecordsFetchedCount");
        m_reverse_nameMap.put("RecordsFetchedCount", new Integer(JdapiTypes.RECORDS_FETCHED_COUNT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RECORD_GROUP_FETCH_SIZE_PTID), "RecordGroupFetchSize");
        m_reverse_nameMap.put("RecordGroupFetchSize", new Integer(JdapiTypes.RECORD_GROUP_FETCH_SIZE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RECORD_GROUP_NAME_PTID), "RecordGroupName");
        m_reverse_nameMap.put("RecordGroupName", new Integer(JdapiTypes.RECORD_GROUP_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RECORD_GROUP_OBJECT_PTID), "RecordGroupObject");
        m_reverse_nameMap.put("RecordGroupObject", new Integer(JdapiTypes.RECORD_GROUP_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RECORD_GROUP_PTID), "RecordGroup");
        m_reverse_nameMap.put("RecordGroup", new Integer(JdapiTypes.RECORD_GROUP_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RECORD_GROUP_QUERY_PTID), "RecordGroupQuery");
        m_reverse_nameMap.put("RecordGroupQuery", new Integer(JdapiTypes.RECORD_GROUP_QUERY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RECORD_GROUP_TYPE_PTID), "RecordGroupType");
        m_reverse_nameMap.put("RecordGroupType", new Integer(JdapiTypes.RECORD_GROUP_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RECORD_ORIENTATION_PTID), "RecordOrientation");
        m_reverse_nameMap.put("RecordOrientation", new Integer(JdapiTypes.RECORD_ORIENTATION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_NAME_PTID), "RecordVisualAttributeGroupName");
        m_reverse_nameMap.put("RecordVisualAttributeGroupName", new Integer(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_OBJECT_PTID), "RecordVisualAttributeGroupObject");
        m_reverse_nameMap.put("RecordVisualAttributeGroupObject", new Integer(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RELATION_PTID), "Relation");
        m_reverse_nameMap.put("Relation", new Integer(JdapiTypes.RELATION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RELATION_TYPE_PTID), "RelationType");
        m_reverse_nameMap.put("RelationType", new Integer(JdapiTypes.RELATION_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RENDERED_PTID), "Rendered");
        m_reverse_nameMap.put("Rendered", new Integer(JdapiTypes.RENDERED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.REPORT_DESTINATION_FORMAT_PTID), "ReportDestinationFormat");
        m_reverse_nameMap.put("ReportDestinationFormat", new Integer(JdapiTypes.REPORT_DESTINATION_FORMAT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.REPORT_DESTINATION_NAME_PTID), "ReportDestinationName");
        m_reverse_nameMap.put("ReportDestinationName", new Integer(JdapiTypes.REPORT_DESTINATION_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.REPORT_DESTINATION_TYPE_PTID), "ReportDestinationType");
        m_reverse_nameMap.put("ReportDestinationType", new Integer(JdapiTypes.REPORT_DESTINATION_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.REPORT_PARAMETERS_PTID), "ReportParameters");
        m_reverse_nameMap.put("ReportParameters", new Integer(JdapiTypes.REPORT_PARAMETERS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.REPORT_PTID), "Report");
        m_reverse_nameMap.put("Report", new Integer(JdapiTypes.REPORT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.REPORT_SERVER_PTID), "ReportServer");
        m_reverse_nameMap.put("ReportServer", new Integer(JdapiTypes.REPORT_SERVER_PTID));
        m_nameMap.put(new Integer(JdapiTypes.REQUIRED_PTID), "Required");
        m_reverse_nameMap.put("Required", new Integer(JdapiTypes.REQUIRED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RESIZABLE_FLAG_PTID), "ResizableFlag");
        m_reverse_nameMap.put("ResizableFlag", new Integer(JdapiTypes.RESIZABLE_FLAG_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RESIZE_ALLOWED_PTID), "ResizeAllowed");
        m_reverse_nameMap.put("ResizeAllowed", new Integer(JdapiTypes.RESIZE_ALLOWED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RETURN_ITEM_PTID), "ReturnItem");
        m_reverse_nameMap.put("ReturnItem", new Integer(JdapiTypes.RETURN_ITEM_PTID));
        m_nameMap.put(new Integer(JdapiTypes.REVERSE_DIRECTION_PTID), "ReverseDirection");
        m_reverse_nameMap.put("ReverseDirection", new Integer(JdapiTypes.REVERSE_DIRECTION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ROLE_COUNT_PTID), "RoleCount");
        m_reverse_nameMap.put("RoleCount", new Integer(JdapiTypes.ROLE_COUNT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RULER_FLAG_PTID), "RulerFlag");
        m_reverse_nameMap.put("RulerFlag", new Integer(JdapiTypes.RULER_FLAG_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RULER_GUIDE_FLAG_PTID), "RulerGuideFlag");
        m_reverse_nameMap.put("RulerGuideFlag", new Integer(JdapiTypes.RULER_GUIDE_FLAG_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RULER_MAJOR_PTID), "RulerMajor");
        m_reverse_nameMap.put("RulerMajor", new Integer(JdapiTypes.RULER_MAJOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RULER_MINOR_PTID), "RulerMinor");
        m_reverse_nameMap.put("RulerMinor", new Integer(JdapiTypes.RULER_MINOR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RULER_UNIT_PTID), "RulerUnit");
        m_reverse_nameMap.put("RulerUnit", new Integer(JdapiTypes.RULER_UNIT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.RUNTIME_COMP_PTID), "RuntimeComp");
        m_reverse_nameMap.put("RuntimeComp", new Integer(JdapiTypes.RUNTIME_COMP_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SAVEPOINT_MODE_PTID), "SavepointMode");
        m_reverse_nameMap.put("SavepointMode", new Integer(JdapiTypes.SAVEPOINT_MODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SCROLLBAR_ALIGN_PTID), "ScrollbarAlign");
        m_reverse_nameMap.put("ScrollbarAlign", new Integer(JdapiTypes.SCROLLBAR_ALIGN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SCROLLBAR_CANVAS_NAME_PTID), "ScrollbarCanvasName");
        m_reverse_nameMap.put("ScrollbarCanvasName", new Integer(JdapiTypes.SCROLLBAR_CANVAS_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SCROLLBAR_CANVAS_OBJECT_PTID), "ScrollbarCanvasObject");
        m_reverse_nameMap.put("ScrollbarCanvasObject", new Integer(JdapiTypes.SCROLLBAR_CANVAS_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SCROLLBAR_LENGTH_PTID), "ScrollbarLength");
        m_reverse_nameMap.put("ScrollbarLength", new Integer(JdapiTypes.SCROLLBAR_LENGTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SCROLLBAR_ORIENTATION_PTID), "ScrollbarOrientation");
        m_reverse_nameMap.put("ScrollbarOrientation", new Integer(JdapiTypes.SCROLLBAR_ORIENTATION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SCROLLBAR_TABPAGE_NAME_PTID), "ScrollbarTabPageName");
        m_reverse_nameMap.put("ScrollbarTabPageName", new Integer(JdapiTypes.SCROLLBAR_TABPAGE_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SCROLLBAR_TABPAGE_OBJECT_PTID), "ScrollbarTabPageObject");
        m_reverse_nameMap.put("ScrollbarTabPageObject", new Integer(JdapiTypes.SCROLLBAR_TABPAGE_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SCROLLBAR_WIDTH_PTID), "ScrollbarWidth");
        m_reverse_nameMap.put("ScrollbarWidth", new Integer(JdapiTypes.SCROLLBAR_WIDTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SCROLLBAR_X_POSITION_PTID), "ScrollbarXPosition");
        m_reverse_nameMap.put("ScrollbarXPosition", new Integer(JdapiTypes.SCROLLBAR_X_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SCROLLBAR_Y_POSITION_PTID), "ScrollbarYPosition");
        m_reverse_nameMap.put("ScrollbarYPosition", new Integer(JdapiTypes.SCROLLBAR_Y_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHARE_LIBRARY_PTID), "ShareLibrary");
        m_reverse_nameMap.put("ShareLibrary", new Integer(JdapiTypes.SHARE_LIBRARY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHOW_CANVAS_PTID), "ShowCanvas");
        m_reverse_nameMap.put("ShowCanvas", new Integer(JdapiTypes.SHOW_CANVAS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHOW_FAST_FORWARD_PTID), "ShowFastForward");
        m_reverse_nameMap.put("ShowFastForward", new Integer(JdapiTypes.SHOW_FAST_FORWARD_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHOW_HORIZONTAL_SCROLLBAR_PTID), "ShowHorizontalScrollbar");
        m_reverse_nameMap.put("ShowHorizontalScrollbar", new Integer(JdapiTypes.SHOW_HORIZONTAL_SCROLLBAR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHOW_PLAY_PTID), "ShowPlay");
        m_reverse_nameMap.put("ShowPlay", new Integer(JdapiTypes.SHOW_PLAY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHOW_RECORD_PTID), "ShowRecord");
        m_reverse_nameMap.put("ShowRecord", new Integer(JdapiTypes.SHOW_RECORD_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHOW_REWIND_PTID), "ShowRewind");
        m_reverse_nameMap.put("ShowRewind", new Integer(JdapiTypes.SHOW_REWIND_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHOW_SCROLLBAR_PTID), "ShowScrollbar");
        m_reverse_nameMap.put("ShowScrollbar", new Integer(JdapiTypes.SHOW_SCROLLBAR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHOW_SLIDER_PTID), "ShowSlider");
        m_reverse_nameMap.put("ShowSlider", new Integer(JdapiTypes.SHOW_SLIDER_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHOW_TIME_PTID), "ShowTime");
        m_reverse_nameMap.put("ShowTime", new Integer(JdapiTypes.SHOW_TIME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHOW_VERTICAL_SCROLLBAR_PTID), "ShowVerticalScrollbar");
        m_reverse_nameMap.put("ShowVerticalScrollbar", new Integer(JdapiTypes.SHOW_VERTICAL_SCROLLBAR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHOW_VIEW_PTID), "ShowView");
        m_reverse_nameMap.put("ShowView", new Integer(JdapiTypes.SHOW_VIEW_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHOW_VOLUME_PTID), "ShowVolume");
        m_reverse_nameMap.put("ShowVolume", new Integer(JdapiTypes.SHOW_VOLUME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SHRINKWRAP_PTID), "Shrinkwrap");
        m_reverse_nameMap.put("Shrinkwrap", new Integer(JdapiTypes.SHRINKWRAP_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SINGLE_OBJECT_ALIGN_PTID), "SingleObjectAlign");
        m_reverse_nameMap.put("SingleObjectAlign", new Integer(JdapiTypes.SINGLE_OBJECT_ALIGN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SINGLE_RECORD_PTID), "SingleRecord");
        m_reverse_nameMap.put("SingleRecord", new Integer(JdapiTypes.SINGLE_RECORD_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SIZING_STYLE_PTID), "SizingStyle");
        m_reverse_nameMap.put("SizingStyle", new Integer(JdapiTypes.SIZING_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SOUND_FORMAT_PTID), "SoundFormat");
        m_reverse_nameMap.put("SoundFormat", new Integer(JdapiTypes.SOUND_FORMAT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SOUND_QUALITY_PTID), "SoundQuality");
        m_reverse_nameMap.put("SoundQuality", new Integer(JdapiTypes.SOUND_QUALITY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SOURCE_PTID), "Source");
        m_reverse_nameMap.put("Source", new Integer(JdapiTypes.SOURCE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.STARTUP_CODE_PTID), "StartupCode");
        m_reverse_nameMap.put("StartupCode", new Integer(JdapiTypes.STARTUP_CODE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.START_PROMPT_ALIGN_PTID), "StartPromptAlign");
        m_reverse_nameMap.put("StartPromptAlign", new Integer(JdapiTypes.START_PROMPT_ALIGN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.START_PROMPT_OFFSET_PTID), "StartPromptOffset");
        m_reverse_nameMap.put("StartPromptOffset", new Integer(JdapiTypes.START_PROMPT_OFFSET_PTID));
        m_nameMap.put(new Integer(JdapiTypes.STATUS_LINE_FLAG_PTID), "StatusLineFlag");
        m_reverse_nameMap.put("StatusLineFlag", new Integer(JdapiTypes.STATUS_LINE_FLAG_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID), "SubclassObjectGroup");
        m_reverse_nameMap.put("SubclassObjectGroup", new Integer(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SUBCLASS_SUBOBJECT_PTID), "SubclassSubObject");
        m_reverse_nameMap.put("SubclassSubObject", new Integer(JdapiTypes.SUBCLASS_SUBOBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SUB_MENU_NAME_PTID), "SubMenuName");
        m_reverse_nameMap.put("SubMenuName", new Integer(JdapiTypes.SUB_MENU_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SUB_MENU_OBJECT_PTID), "SubMenuObject");
        m_reverse_nameMap.put("SubMenuObject", new Integer(JdapiTypes.SUB_MENU_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SUB_TITLE_PTID), "SubTitle");
        m_reverse_nameMap.put("SubTitle", new Integer(JdapiTypes.SUB_TITLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SUMMARY_BLOCK_NAME_PTID), "SummaryBlockName");
        m_reverse_nameMap.put("SummaryBlockName", new Integer(JdapiTypes.SUMMARY_BLOCK_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SUMMARY_FUNCTION_PTID), "SummaryFunction");
        m_reverse_nameMap.put("SummaryFunction", new Integer(JdapiTypes.SUMMARY_FUNCTION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SUMMARY_ITEM_NAME_PTID), "SummaryItemName");
        m_reverse_nameMap.put("SummaryItemName", new Integer(JdapiTypes.SUMMARY_ITEM_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SYNCHRONIZED_ITEM_NAME_PTID), "SynchronizedItemName");
        m_reverse_nameMap.put("SynchronizedItemName", new Integer(JdapiTypes.SYNCHRONIZED_ITEM_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.SYNCHRONIZED_ITEM_OBJECT_PTID), "SynchronizedItemObject");
        m_reverse_nameMap.put("SynchronizedItemObject", new Integer(JdapiTypes.SYNCHRONIZED_ITEM_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TABPAGE_NAME_PTID), "TabPageName");
        m_reverse_nameMap.put("TabPageName", new Integer(JdapiTypes.TABPAGE_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TABPAGE_OBJECT_PTID), "TabPageObject");
        m_reverse_nameMap.put("TabPageObject", new Integer(JdapiTypes.TABPAGE_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TAB_ACTION_STYLE_PTID), "TabActionStyle");
        m_reverse_nameMap.put("TabActionStyle", new Integer(JdapiTypes.TAB_ACTION_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TAB_ATTACHMENT_EDGE_PTID), "TabAttachmentEdge");
        m_reverse_nameMap.put("TabAttachmentEdge", new Integer(JdapiTypes.TAB_ATTACHMENT_EDGE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TAB_PAGE_PTID), "TabPage");
        m_reverse_nameMap.put("TabPage", new Integer(JdapiTypes.TAB_PAGE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TAB_STYLE_PTID), "TabStyle");
        m_reverse_nameMap.put("TabStyle", new Integer(JdapiTypes.TAB_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TAB_WIDTH_STYLE_PTID), "TabWidthStyle");
        m_reverse_nameMap.put("TabWidthStyle", new Integer(JdapiTypes.TAB_WIDTH_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TEAR_OFF_MENU_PTID), "TearOffMenu");
        m_reverse_nameMap.put("TearOffMenu", new Integer(JdapiTypes.TEAR_OFF_MENU_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TEXT_PTID), "Text");
        m_reverse_nameMap.put("Text", new Integer(JdapiTypes.TEXT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TEXT_SEGMENT_PTID), "TextSegment");
        m_reverse_nameMap.put("TextSegment", new Integer(JdapiTypes.TEXT_SEGMENT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TITLE_PTID), "Title");
        m_reverse_nameMap.put("Title", new Integer(JdapiTypes.TITLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TITLE_READING_ORDER_PTID), "TitleReadingOrder");
        m_reverse_nameMap.put("TitleReadingOrder", new Integer(JdapiTypes.TITLE_READING_ORDER_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TOOLPALETTE_FLAG_PTID), "ToolpaletteFlag");
        m_reverse_nameMap.put("ToolpaletteFlag", new Integer(JdapiTypes.TOOLPALETTE_FLAG_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TOOLTIP_PTID), "Tooltip");
        m_reverse_nameMap.put("Tooltip", new Integer(JdapiTypes.TOOLTIP_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TOOLTIP_VISUALATTRIBUTE_GROUP_PTID), "TooltipVisualAttributeGroup");
        m_reverse_nameMap.put("TooltipVisualAttributeGroup", new Integer(JdapiTypes.TOOLTIP_VISUALATTRIBUTE_GROUP_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TOP_PROMPT_ALIGN_PTID), "TopPromptAlign");
        m_reverse_nameMap.put("TopPromptAlign", new Integer(JdapiTypes.TOP_PROMPT_ALIGN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TOP_PROMPT_OFFSET_PTID), "TopPromptOffset");
        m_reverse_nameMap.put("TopPromptOffset", new Integer(JdapiTypes.TOP_PROMPT_OFFSET_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TREE_ALLOW_EMP_BRANCH_PTID), "TreeAllowEmpBranch");
        m_reverse_nameMap.put("TreeAllowEmpBranch", new Integer(JdapiTypes.TREE_ALLOW_EMP_BRANCH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TREE_DATA_QUERY_PTID), "TreeDataQuery");
        m_reverse_nameMap.put("TreeDataQuery", new Integer(JdapiTypes.TREE_DATA_QUERY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TREE_MULTI_SELECT_PTID), "TreeMultiSelect");
        m_reverse_nameMap.put("TreeMultiSelect", new Integer(JdapiTypes.TREE_MULTI_SELECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TREE_SHOW_LINES_PTID), "TreeShowLines");
        m_reverse_nameMap.put("TreeShowLines", new Integer(JdapiTypes.TREE_SHOW_LINES_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TREE_SHOW_SYMBOL_PTID), "TreeShowSymbol");
        m_reverse_nameMap.put("TreeShowSymbol", new Integer(JdapiTypes.TREE_SHOW_SYMBOL_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TRIGGER_INTERNAL_TYPE_PTID), "TriggerInternalType");
        m_reverse_nameMap.put("TriggerInternalType", new Integer(JdapiTypes.TRIGGER_INTERNAL_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TRIGGER_PTID), "Trigger");
        m_reverse_nameMap.put("Trigger", new Integer(JdapiTypes.TRIGGER_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TRIGGER_STYLE_PTID), "TriggerStyle");
        m_reverse_nameMap.put("TriggerStyle", new Integer(JdapiTypes.TRIGGER_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TRIGGER_TEXT_PTID), "TriggerText");
        m_reverse_nameMap.put("TriggerText", new Integer(JdapiTypes.TRIGGER_TEXT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.TRIG_STEP_PTID), "TrigStep");
        m_reverse_nameMap.put("TrigStep", new Integer(JdapiTypes.TRIG_STEP_PTID));
        m_nameMap.put(new Integer(JdapiTypes.UNCHECKED_VALUE_PTID), "UncheckedValue");
        m_reverse_nameMap.put("UncheckedValue", new Integer(JdapiTypes.UNCHECKED_VALUE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.UPDATE_ALLOWED_PTID), "UpdateAllowed");
        m_reverse_nameMap.put("UpdateAllowed", new Integer(JdapiTypes.UPDATE_ALLOWED_PTID));
        m_nameMap.put(new Integer(JdapiTypes.UPDATE_CHANGED_COLUMNS_PTID), "UpdateChangedColumns");
        m_reverse_nameMap.put("UpdateChangedColumns", new Integer(JdapiTypes.UPDATE_CHANGED_COLUMNS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.UPDATE_COMMIT_PTID), "UpdateCommit");
        m_reverse_nameMap.put("UpdateCommit", new Integer(JdapiTypes.UPDATE_COMMIT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.UPDATE_DATA_SOURCE_ARGUMENT_PTID), "UpdateDataSourceArgument");
        m_reverse_nameMap.put("UpdateDataSourceArgument", new Integer(JdapiTypes.UPDATE_DATA_SOURCE_ARGUMENT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.UPDATE_DATA_SOURCE_COLUMN_PTID), "UpdateDataSourceColumn");
        m_reverse_nameMap.put("UpdateDataSourceColumn", new Integer(JdapiTypes.UPDATE_DATA_SOURCE_COLUMN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.UPDATE_IF_NULL_PTID), "UpdateIfNull");
        m_reverse_nameMap.put("UpdateIfNull", new Integer(JdapiTypes.UPDATE_IF_NULL_PTID));
        m_nameMap.put(new Integer(JdapiTypes.UPDATE_LAYOUT_PTID), "UpdateLayout");
        m_reverse_nameMap.put("UpdateLayout", new Integer(JdapiTypes.UPDATE_LAYOUT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.UPDATE_PROCEDURE_NAME_PTID), "UpdateProcedureName");
        m_reverse_nameMap.put("UpdateProcedureName", new Integer(JdapiTypes.UPDATE_PROCEDURE_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.UPDATE_QUERY_PTID), "UpdateQuery");
        m_reverse_nameMap.put("UpdateQuery", new Integer(JdapiTypes.UPDATE_QUERY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.USE_3D_CONTROLS_PTID), "Use3dControls");
        m_reverse_nameMap.put("Use3dControls", new Integer(JdapiTypes.USE_3D_CONTROLS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.USE_SECURITY_PTID), "UseSecurity");
        m_reverse_nameMap.put("UseSecurity", new Integer(JdapiTypes.USE_SECURITY_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VALIDATE_FROM_LIST_PTID), "ValidateFromList");
        m_reverse_nameMap.put("ValidateFromList", new Integer(JdapiTypes.VALIDATE_FROM_LIST_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VALIDATION_UNIT_PTID), "ValidationUnit");
        m_reverse_nameMap.put("ValidationUnit", new Integer(JdapiTypes.VALIDATION_UNIT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VERTICALTOOLBAR_CANVAS_NAME_PTID), "VerticalToolbarCanvasName");
        m_reverse_nameMap.put("VerticalToolbarCanvasName", new Integer(JdapiTypes.VERTICALTOOLBAR_CANVAS_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VERTICAL_FILL_PTID), "VerticalFill");
        m_reverse_nameMap.put("VerticalFill", new Integer(JdapiTypes.VERTICAL_FILL_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VERTICAL_JUSTIFICATION_PTID), "VerticalJustification");
        m_reverse_nameMap.put("VerticalJustification", new Integer(JdapiTypes.VERTICAL_JUSTIFICATION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VERTICAL_MARGIN_PTID), "VerticalMargin");
        m_reverse_nameMap.put("VerticalMargin", new Integer(JdapiTypes.VERTICAL_MARGIN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VERTICAL_OBJECT_OFFSET_PTID), "VerticalObjectOffset");
        m_reverse_nameMap.put("VerticalObjectOffset", new Integer(JdapiTypes.VERTICAL_OBJECT_OFFSET_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VERTICAL_ORIGIN_PTID), "VerticalOrigin");
        m_reverse_nameMap.put("VerticalOrigin", new Integer(JdapiTypes.VERTICAL_ORIGIN_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VERTICAL_TOOLBAR_CANVAS_PTID), "VerticalToolbarCanvas");
        m_reverse_nameMap.put("VerticalToolbarCanvas", new Integer(JdapiTypes.VERTICAL_TOOLBAR_CANVAS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VIEWPORT_HEIGHT_PTID), "ViewportHeight");
        m_reverse_nameMap.put("ViewportHeight", new Integer(JdapiTypes.VIEWPORT_HEIGHT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VIEWPORT_WIDTH_PTID), "ViewportWidth");
        m_reverse_nameMap.put("ViewportWidth", new Integer(JdapiTypes.VIEWPORT_WIDTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VIEWPORT_X_POSITION_ON_CANVAS_PTID), "ViewportXPositionOnCanvas");
        m_reverse_nameMap.put("ViewportXPositionOnCanvas", new Integer(JdapiTypes.VIEWPORT_X_POSITION_ON_CANVAS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VIEWPORT_X_POSITION_PTID), "ViewportXPosition");
        m_reverse_nameMap.put("ViewportXPosition", new Integer(JdapiTypes.VIEWPORT_X_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VIEWPORT_Y_POSITION_ON_CANVAS_PTID), "ViewportYPositionOnCanvas");
        m_reverse_nameMap.put("ViewportYPositionOnCanvas", new Integer(JdapiTypes.VIEWPORT_Y_POSITION_ON_CANVAS_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VIEWPORT_Y_POSITION_PTID), "ViewportYPosition");
        m_reverse_nameMap.put("ViewportYPosition", new Integer(JdapiTypes.VIEWPORT_Y_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VISIBLE_IN_HORIZONTAL_MENU_TOOLBAR_PTID), "VisibleInHorizontalMenuToolbar");
        m_reverse_nameMap.put("VisibleInHorizontalMenuToolbar", new Integer(JdapiTypes.VISIBLE_IN_HORIZONTAL_MENU_TOOLBAR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VISIBLE_IN_MENU_PTID), "VisibleInMenu");
        m_reverse_nameMap.put("VisibleInMenu", new Integer(JdapiTypes.VISIBLE_IN_MENU_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VISIBLE_IN_VERTICAL_MENU_TOOLBAR_PTID), "VisibleInVerticalMenuToolbar");
        m_reverse_nameMap.put("VisibleInVerticalMenuToolbar", new Integer(JdapiTypes.VISIBLE_IN_VERTICAL_MENU_TOOLBAR_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VISIBLE_PTID), "Visible");
        m_reverse_nameMap.put("Visible", new Integer(JdapiTypes.VISIBLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VISUALATTRIBUTE_NAME_PTID), "VisualAttributeName");
        m_reverse_nameMap.put("VisualAttributeName", new Integer(JdapiTypes.VISUALATTRIBUTE_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID), "VisualAttributeObject");
        m_reverse_nameMap.put("VisualAttributeObject", new Integer(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VISUALATTRIBUTE_TYPE_PTID), "VisualAttributeType");
        m_reverse_nameMap.put("VisualAttributeType", new Integer(JdapiTypes.VISUALATTRIBUTE_TYPE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VISUAL_ATTRIBUTE_PTID), "VisualAttribute");
        m_reverse_nameMap.put("VisualAttribute", new Integer(JdapiTypes.VISUAL_ATTRIBUTE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VISUAL_STATE_PTID), "VisualState");
        m_reverse_nameMap.put("VisualState", new Integer(JdapiTypes.VISUAL_STATE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.VISUAL_STATE_VALID_PTID), "VisualStateValid");
        m_reverse_nameMap.put("VisualStateValid", new Integer(JdapiTypes.VISUAL_STATE_VALID_PTID));
        m_nameMap.put(new Integer(JdapiTypes.WHERE_CLAUSE_PTID), "WhereClause");
        m_reverse_nameMap.put("WhereClause", new Integer(JdapiTypes.WHERE_CLAUSE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.WIDTH_PTID), "Width");
        m_reverse_nameMap.put("Width", new Integer(JdapiTypes.WIDTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.WINDOW_HEIGHT_PTID), "WindowHeight");
        m_reverse_nameMap.put("WindowHeight", new Integer(JdapiTypes.WINDOW_HEIGHT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.WINDOW_NAME_PTID), "WindowName");
        m_reverse_nameMap.put("WindowName", new Integer(JdapiTypes.WINDOW_NAME_PTID));
        m_nameMap.put(new Integer(JdapiTypes.WINDOW_OBJECT_PTID), "WindowObject");
        m_reverse_nameMap.put("WindowObject", new Integer(JdapiTypes.WINDOW_OBJECT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.WINDOW_PTID), "Window");
        m_reverse_nameMap.put("Window", new Integer(JdapiTypes.WINDOW_PTID));
        m_nameMap.put(new Integer(JdapiTypes.WINDOW_STYLE_PTID), "WindowStyle");
        m_reverse_nameMap.put("WindowStyle", new Integer(JdapiTypes.WINDOW_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.WINDOW_WIDTH_PTID), "WindowWidth");
        m_reverse_nameMap.put("WindowWidth", new Integer(JdapiTypes.WINDOW_WIDTH_PTID));
        m_nameMap.put(new Integer(JdapiTypes.WINDOW_X_POSITION_PTID), "WindowXPosition");
        m_reverse_nameMap.put("WindowXPosition", new Integer(JdapiTypes.WINDOW_X_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.WINDOW_Y_POSITION_PTID), "WindowYPosition");
        m_reverse_nameMap.put("WindowYPosition", new Integer(JdapiTypes.WINDOW_Y_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.WRAP_STYLE_PTID), "WrapStyle");
        m_reverse_nameMap.put("WrapStyle", new Integer(JdapiTypes.WRAP_STYLE_PTID));
        m_nameMap.put(new Integer(JdapiTypes.WRAP_TEXT_PTID), "WrapText");
        m_reverse_nameMap.put("WrapText", new Integer(JdapiTypes.WRAP_TEXT_PTID));
        m_nameMap.put(new Integer(JdapiTypes.X_POSITION_PTID), "XPosition");
        m_reverse_nameMap.put("XPosition", new Integer(JdapiTypes.X_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.Y_POSITION_PTID), "YPosition");
        m_reverse_nameMap.put("YPosition", new Integer(JdapiTypes.Y_POSITION_PTID));
        m_nameMap.put(new Integer(JdapiTypes.ZOOM_LEVEL_PTID), "ZoomLevel");
        m_reverse_nameMap.put("ZoomLevel", new Integer(JdapiTypes.ZOOM_LEVEL_PTID));
        m_enumMap.put(new Integer(JdapiTypes.ALERT_STYLE_PTID), new int[] {
            JdapiTypes.ALST_STOP_CTID, JdapiTypes.ALST_CAUTION_CTID, JdapiTypes.ALST_NOTE_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.ARROW_STYLE_PTID), new int[] {
            JdapiTypes.ARST_NONE_CTID, JdapiTypes.ARST_START_CTID, JdapiTypes.ARST_END_CTID, JdapiTypes.ARST_BOTH_CTID, JdapiTypes.ARST_MDLTOSTRT_CTID, JdapiTypes.ARST_MDLTOEND_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.AUDIO_CHANNELS_PTID), new int[] {
            JdapiTypes.AUCH_AUTO_CTID, JdapiTypes.AUCH_MONO_CTID, JdapiTypes.AUCH_STEREO_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.BEVEL_PTID), new int[] {
            JdapiTypes.BEST_RAISED_CTID, JdapiTypes.BEST_LOWERED_CTID, JdapiTypes.BEST_NONE_CTID, JdapiTypes.BEST_NSET_CTID, JdapiTypes.BEST_OUTSET_CTID, JdapiTypes.BEST_PLAIN_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.CALCULATE_MODE_PTID), new int[] {
            JdapiTypes.CAMO_NONE_CTID, JdapiTypes.CAMO_FORMULA_CTID, JdapiTypes.CAMO_SUMMARY_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.CANVAS_TYPE_PTID), new int[] {
            JdapiTypes.CNTY_CONTENT_CTID, JdapiTypes.CNTY_STACKED_CTID, JdapiTypes.CNTY_VTOOLBAR_CTID, JdapiTypes.CNTY_HTOOLBAR_CTID, JdapiTypes.CNTY_TAB_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.CAP_STYLE_PTID), new int[] {
            JdapiTypes.CAST_BUTT_CTID, JdapiTypes.CAST_ROUND_CTID, JdapiTypes.CAST_PROJECT_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.CASE_RESTRICTION_PTID), new int[] {
            JdapiTypes.CARS_MIXED_CTID, JdapiTypes.CARS_UPPER_CTID, JdapiTypes.CARS_LOWER_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.CHECK_BOX_OTHER_VALUES_PTID), new int[] {
            JdapiTypes.CHECKBOX_ILLEGAL_CTID, JdapiTypes.CHECKBOX_CHECKED_CTID, JdapiTypes.CHECKBOX_UNCHECKED_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.COLUMN_DATA_TYPE_PTID), new int[] {
            JdapiTypes.CODA_CHARACTER_CTID, JdapiTypes.CODA_NUMBER_CTID, JdapiTypes.CODA_DATE_CTID, JdapiTypes.CODA_LONG_CTID, JdapiTypes.CODA_REFERENCE_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.COMMAND_TYPE_PTID), new int[] {
            JdapiTypes.COTY_NULL_CTID, JdapiTypes.COTY_MENU_CTID, JdapiTypes.COTY_PLSQL_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.COMM_MODE_PTID), new int[] {
            JdapiTypes.COMO_SYNCH_CTID, JdapiTypes.COMO_ASYNCH_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.COMPRESSION_QUALITY_PTID), new int[] {
            JdapiTypes.CMQL_NONE_CTID, JdapiTypes.CMQL_MINIMUM_CTID, JdapiTypes.CMQL_LOW_CTID, JdapiTypes.CMQL_MED_CTID, JdapiTypes.CMQL_HIGH_CTID, JdapiTypes.CMQL_MAXIMUM_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.COMPRESS_PTID), new int[] {
            JdapiTypes.COMP_AUTO_CTID, JdapiTypes.COMP_OFF_CTID, JdapiTypes.COMP_ON_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.COORDINATE_SYSTEM_PTID), new int[] {
            JdapiTypes.COSY_CHARACTER_CTID, JdapiTypes.COSY_REAL_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.CURSOR_MODE_PTID), new int[] {
            JdapiTypes.CRMO_OPEN_CTID, JdapiTypes.CRMO_CLOSE_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.DASH_STYLE_PTID), new int[] {
            JdapiTypes.DAST_SOLID_CTID, JdapiTypes.DAST_DOT_CTID, JdapiTypes.DAST_DASH_CTID, JdapiTypes.DAST_DASHDOT_CTID, JdapiTypes.DAST_DOUBDOT_CTID, JdapiTypes.DAST_LONGDASH_CTID, JdapiTypes.DAST_DASHDOUBDOT_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.DATA_LENGTH_SEMANTICS_PTID), new int[] {
            JdapiTypes.CHLE_NULL_CTID, JdapiTypes.CHLE_BYTE_CTID, JdapiTypes.CHLE_CHARACTER_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.DATA_TYPE_PTID), new int[] {
            JdapiTypes.DATY_CHARACTER_CTID, JdapiTypes.DATY_NUMBER_CTID, JdapiTypes.DATY_DATE_CTID, JdapiTypes.DATY_ALPHA_CTID, JdapiTypes.DATY_INTEGER_CTID, JdapiTypes.DATY_DATETIME_CTID, JdapiTypes.DATY_LONG_CTID, JdapiTypes.DATY_RNUMBER_CTID, JdapiTypes.DATY_JDATE_CTID, JdapiTypes.DATY_EDATE_CTID, 
            JdapiTypes.DATY_TIME_CTID, JdapiTypes.DATY_RINTEGER_CTID, JdapiTypes.DATY_MONEY_CTID, JdapiTypes.DATY_RMONEY_CTID, JdapiTypes.DATY_OBJECTREF_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.DEFAULT_ALERT_BUTTON_PTID), new int[] {
            JdapiTypes.DFAL_BTN1_CTID, JdapiTypes.DFAL_BTN2_CTID, JdapiTypes.DFAL_BTN3_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.DELETE_RECORD_PTID), new int[] {
            JdapiTypes.DERE_CASCADING_CTID, JdapiTypes.DERE_ISOLATED_CTID, JdapiTypes.DERE_NON_ISOLATED_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.DISPLAY_QUALITY_PTID), new int[] {
            JdapiTypes.DIQL_HIGH_CTID, JdapiTypes.DIQL_MEDIUM_CTID, JdapiTypes.DIQL_LOW_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.DML_DATA_TYPE_PTID), new int[] {
            JdapiTypes.DMDA_NONE_CTID, JdapiTypes.DMDA_TABLE_CTID, JdapiTypes.DMDA_PROCEDURE_CTID, JdapiTypes.DMDA_TRANS_TRIG_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.DSA_MODE_PTID), new int[] {
            JdapiTypes.DSMO_IN_CTID, JdapiTypes.DSMO_OUT_CTID, JdapiTypes.DSMO_IN_OUT_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.DSA_TYPE_PTID), new int[] {
            JdapiTypes.DSTY_VARCHAR2_CTID, JdapiTypes.DSTY_NUMBER_CTID, JdapiTypes.DSTY_LONG_CTID, JdapiTypes.DSTY_ROWID_CTID, JdapiTypes.DSTY_DATE_CTID, JdapiTypes.DSTY_RAW_CTID, JdapiTypes.DSTY_LONG_RAW_CTID, JdapiTypes.DSTY_CHARACTER_CTID, JdapiTypes.DSTY_MLSLABEL_CTID, JdapiTypes.DSTY_TABLE_CTID, 
            JdapiTypes.DSTY_RECORD_CTID, JdapiTypes.DSTY_REFCURSOR_CTID, JdapiTypes.DSTY_NAMEDTYPE_CTID, JdapiTypes.DSTY_OBJECTREF_CTID, JdapiTypes.DSTY_VARRAY_CTID, JdapiTypes.DSTY_NESTEDTAB_CTID, JdapiTypes.DSTY_BLOB_CTID, JdapiTypes.DSTY_CLOB_CTID, JdapiTypes.DSTY_BFILE_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.DSC_TYPE_PTID), new int[] {
            JdapiTypes.DSTY_VARCHAR2_CTID, JdapiTypes.DSTY_NUMBER_CTID, JdapiTypes.DSTY_LONG_CTID, JdapiTypes.DSTY_ROWID_CTID, JdapiTypes.DSTY_DATE_CTID, JdapiTypes.DSTY_RAW_CTID, JdapiTypes.DSTY_LONG_RAW_CTID, JdapiTypes.DSTY_CHARACTER_CTID, JdapiTypes.DSTY_MLSLABEL_CTID, JdapiTypes.DSTY_TABLE_CTID, 
            JdapiTypes.DSTY_RECORD_CTID, JdapiTypes.DSTY_REFCURSOR_CTID, JdapiTypes.DSTY_NAMEDTYPE_CTID, JdapiTypes.DSTY_OBJECTREF_CTID, JdapiTypes.DSTY_VARRAY_CTID, JdapiTypes.DSTY_NESTEDTAB_CTID, JdapiTypes.DSTY_BLOB_CTID, JdapiTypes.DSTY_CLOB_CTID, JdapiTypes.DSTY_BFILE_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.EXECUTE_HIERARCHY_PTID), new int[] {
            JdapiTypes.EXHI_OVERRIDE_CTID, JdapiTypes.EXHI_BEFORE_CTID, JdapiTypes.EXHI_AFTER_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.EXECUTE_MODE_PTID), new int[] {
            JdapiTypes.EXMO_BATCH_CTID, JdapiTypes.EXMO_RUNTIME_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.FONT_SPACING_PTID), new int[] {
            JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.FONT_STYLE_PTID), new int[] {
            JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.FONT_WEIGHT_PTID), new int[] {
            JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.FRAME_ALIGN_PTID), new int[] {
            JdapiTypes.FRAL_START_CTID, JdapiTypes.FRAL_END_CTID, JdapiTypes.FRAL_CENTER_CTID, JdapiTypes.FRAL_FILL_CTID, JdapiTypes.FRAL_COLUMN_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.FRAME_TITLE_ALIGN_PTID), new int[] {
            JdapiTypes.JUSTIFICATION_LEFT_CTID, JdapiTypes.JUSTIFICATION_RIGHT_CTID, JdapiTypes.JUSTIFICATION_CENTER_CTID, JdapiTypes.JUSTIFICATION_START_CTID, JdapiTypes.JUSTIFICATION_END_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.FRAME_TITLE_FONT_SPACING_PTID), new int[] {
            JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.FRAME_TITLE_FONT_STYLE_PTID), new int[] {
            JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.FRAME_TITLE_FONT_WEIGHT_PTID), new int[] {
            JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.GRAPHICS_FONT_SPACING_PTID), new int[] {
            JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.GRAPHICS_FONT_WEIGHT_PTID), new int[] {
            JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.GRAPHICS_TYPE_PTID), new int[] {
            JdapiTypes.GRTY_ARC_CTID, JdapiTypes.GRTY_IMAGE_CTID, JdapiTypes.GRTY_LINE_CTID, JdapiTypes.GRTY_POLY_CTID, JdapiTypes.GRTY_RECT_CTID, JdapiTypes.GRTY_RREC_CTID, JdapiTypes.GRTY_TEXT_CTID, JdapiTypes.GRTY_GROUP_CTID, JdapiTypes.GRTY_FRAME_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.HORIZONTAL_JUSTIFICATION_PTID), new int[] {
            JdapiTypes.HOJU_LEFT_CTID, JdapiTypes.HOJU_RIGHT_CTID, JdapiTypes.HOJU_CENTER_CTID, JdapiTypes.HOJU_START_CTID, JdapiTypes.HOJU_END_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.HORIZONTAL_ORIGIN_PTID), new int[] {
            JdapiTypes.HOOR_LEFT_CTID, JdapiTypes.HOOR_RIGHT_CTID, JdapiTypes.HOOR_CENTER_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.IMAGE_DEPTH_PTID), new int[] {
            JdapiTypes.IMDP_ORIG_CTID, JdapiTypes.IMDP_MONO_CTID, JdapiTypes.IMDP_GRAY_CTID, JdapiTypes.IMDP_LUT_CTID, JdapiTypes.IMDP_RGB_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.IMAGE_FORMAT_PTID), new int[] {
            JdapiTypes.IMFM_BMP_CTID, JdapiTypes.IMFM_CALS_CTID, JdapiTypes.IMFM_GIF_CTID, JdapiTypes.IMFM_JFIF_CTID, JdapiTypes.IMFM_PICT_CTID, JdapiTypes.IMFM_RAS_CTID, JdapiTypes.IMFM_TIFF_CTID, JdapiTypes.IMFM_TPIC_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.INITIALIZE_KEYBOARD_DIRECTION_PTID), new int[] {
            JdapiTypes.INKB_DEFAULT_CTID, JdapiTypes.INKB_ROMAN_CTID, JdapiTypes.INKB_NATIVE_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.INTERACTION_MODE_PTID), new int[] {
            JdapiTypes.INMO_BLOCKING_CTID, JdapiTypes.INMO_NONBLOCKING_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.ISOLATION_MODE_PTID), new int[] {
            JdapiTypes.ISMO_READ_CTID, JdapiTypes.ISMO_SERIAL_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.ITEM_TYPE_PTID), new int[] {
            JdapiTypes.ITTY_BA_CTID, JdapiTypes.ITTY_CA_CTID, JdapiTypes.ITTY_CB_CTID, JdapiTypes.ITTY_DI_CTID, JdapiTypes.ITTY_TREE_CTID, JdapiTypes.ITTY_IM_CTID, JdapiTypes.ITTY_LS_CTID, JdapiTypes.ITTY_PB_CTID, JdapiTypes.ITTY_RD_CTID, JdapiTypes.ITTY_TI_CTID, 
            JdapiTypes.ITTY_UA_CTID, JdapiTypes.ITTY_ACTION_CTID, JdapiTypes.ITTY_OLE_CTID, JdapiTypes.ITTY_SN_CTID, JdapiTypes.ITTY_VBX_CTID, JdapiTypes.ITTY_MAXIMUM_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.JOIN_STYLE_PTID), new int[] {
            JdapiTypes.JOST_MITRE_CTID, JdapiTypes.JOST_BEVEL_CTID, JdapiTypes.JOST_ROUND_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.JUSTIFICATION_PTID), new int[] {
            JdapiTypes.JUSTIFICATION_LEFT_CTID, JdapiTypes.JUSTIFICATION_RIGHT_CTID, JdapiTypes.JUSTIFICATION_CENTER_CTID, JdapiTypes.JUSTIFICATION_START_CTID, JdapiTypes.JUSTIFICATION_END_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.KEYBOARD_STATE_PTID), new int[] {
            JdapiTypes.KBST_ANY_CTID, JdapiTypes.KBST_ROMAN_CTID, JdapiTypes.KBST_NATIVE_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.KEY_MODE_PTID), new int[] {
            JdapiTypes.KEMO_UNIQUE_CTID, JdapiTypes.KEMO_UPDATEABLE_CTID, JdapiTypes.KEMO_NUPDATEABLE_CTID, JdapiTypes.KEMO_AUTO_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.LANGUAGE_DIRECTION_PTID), new int[] {
            JdapiTypes.LADI_DEFAULT_CTID, JdapiTypes.LADI_TORIGHT_CTID, JdapiTypes.LADI_TOLEFT_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.LAYOUT_STYLE_PTID), new int[] {
            JdapiTypes.LAST_FORM_CTID, JdapiTypes.LAST_TABULAR_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.LIBRARY_SOURCE_PTID), new int[] {
            JdapiTypes.LISR_FS_CTID, JdapiTypes.LISR_DATABASE_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.LINE_SPACING_PTID), new int[] {
            JdapiTypes.LISP_SINGLE_CTID, JdapiTypes.LISP_ONEHALF_CTID, JdapiTypes.LISP_DOUBLE_CTID, JdapiTypes.LISP_CUSTOM_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.LIST_STYLE_PTID), new int[] {
            JdapiTypes.LSST_POPLIST_CTID, JdapiTypes.LSST_TLIST_CTID, JdapiTypes.LSST_COMBO_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.LIST_TYPE_PTID), new int[] {
            JdapiTypes.LSTY_RECORDGROUP_CTID, JdapiTypes.LSTY_OLD_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.LOCK_MODE_PTID), new int[] {
            JdapiTypes.LOMO_IMMEDIATE_CTID, JdapiTypes.LOMO_DELAYED_CTID, JdapiTypes.LOMO_AUTO_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.MAGIC_ITEM_PTID), new int[] {
            JdapiTypes.MAIT_NONE_CTID, JdapiTypes.MAIT_CUT_CTID, JdapiTypes.MAIT_COPY_CTID, JdapiTypes.MAIT_PASTE_CTID, JdapiTypes.MAIT_CLEAR_CTID, JdapiTypes.MAIT_UNDO_CTID, JdapiTypes.MAIT_HELP_CTID, JdapiTypes.MAIT_ABOUT_CTID, JdapiTypes.MAIT_QUIT_CTID, JdapiTypes.MAIT_WINDOW_CTID, 
            JdapiTypes.MAIT_PAGESETUP_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.MENU_ITEM_TYPE_PTID), new int[] {
            JdapiTypes.MNIT_PLAIN_CTID, JdapiTypes.MNIT_CHECK_CTID, JdapiTypes.MNIT_RADIO_CTID, JdapiTypes.MNIT_SEPARATOR_CTID, JdapiTypes.MNIT_MAGIC_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.MOUSE_NAVIGATION_LIMIT_PTID), new int[] {
            JdapiTypes.MONA_FORM_CTID, JdapiTypes.MONA_BLOCK_CTID, JdapiTypes.MONA_RECORD_CTID, JdapiTypes.MONA_ITEM_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.NAVIGATION_STYLE_PTID), new int[] {
            JdapiTypes.NAST_SAMERECORD_CTID, JdapiTypes.NAST_CHANGERECORD_CTID, JdapiTypes.NAST_CHANGEBLOCK_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.OLE_ACTION_STYLE_PTID), new int[] {
            JdapiTypes.OLAC_DOUBLECLICK_CTID, JdapiTypes.OLAC_MANUAL_CTID, JdapiTypes.OLAC_FOCUS_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.OLE_RESIZ_STYLE_PTID), new int[] {
            JdapiTypes.OLRE_CLIP_CTID, JdapiTypes.OLRE_SCALE_CTID, JdapiTypes.OLRE_INITIAL_CTID, JdapiTypes.OLRE_DYNAMIC_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.OLE_TENANTTYPE_ASPECT_PTID), new int[] {
            JdapiTypes.OLET_CONTENT_CTID, JdapiTypes.OLET_ICON_CTID, JdapiTypes.OLET_THUMBNAIL_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.OLE_TENANTTYPE_TYPE_PTID), new int[] {
            JdapiTypes.OLTN_ANY_CTID, JdapiTypes.OLTN_NONE_CTID, JdapiTypes.OLTN_STATIC_CTID, JdapiTypes.OLTN_LINKED_CTID, JdapiTypes.OLTN_EMBEDDED_CTID, JdapiTypes.OLTN_CONTROL_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.PARAMETER_DATA_TYPE_PTID), new int[] {
            JdapiTypes.PADA_CHARACTER_CTID, JdapiTypes.PADA_NUMBER_CTID, JdapiTypes.PADA_DATE_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.PROGRAMUNIT_TYPE_PTID), new int[] {
            JdapiTypes.PGTY_UNKNOWN_CTID, JdapiTypes.PGTY_PROCEDURE_CTID, JdapiTypes.PGTY_FUNCTION_CTID, JdapiTypes.PGTY_PACKAGESPEC_CTID, JdapiTypes.PGTY_PACKAGEBODY_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.PROMPT_ALIGN_PTID), new int[] {
            JdapiTypes.ALIG_START_CTID, JdapiTypes.ALIG_END_CTID, JdapiTypes.ALIG_CENTER_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.PROMPT_ATTACHMENT_EDGE_PTID), new int[] {
            JdapiTypes.PRAT_START_CTID, JdapiTypes.PRAT_END_CTID, JdapiTypes.PRAT_TOP_CTID, JdapiTypes.PRAT_BOTTOM_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.PROMPT_DISPLAY_STYLE_PTID), new int[] {
            JdapiTypes.PRDI_HIDDEN_CTID, JdapiTypes.PRDI_FIRST_CTID, JdapiTypes.PRDI_EACH_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.PROMPT_FONT_SPACING_PTID), new int[] {
            JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.PROMPT_FONT_STYLE_PTID), new int[] {
            JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.PROMPT_FONT_WEIGHT_PTID), new int[] {
            JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.PROMPT_JUSTIFICATION_PTID), new int[] {
            JdapiTypes.HOJU_LEFT_CTID, JdapiTypes.HOJU_RIGHT_CTID, JdapiTypes.HOJU_CENTER_CTID, JdapiTypes.HOJU_START_CTID, JdapiTypes.HOJU_END_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.PROMPT_READING_ORDER_PTID), new int[] {
            JdapiTypes.READ_DEFAULT_CTID, JdapiTypes.READ_TORIGHT_CTID, JdapiTypes.READ_TOLEFT_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.QUERY_DATA_SOURCE_TYPE_PTID), new int[] {
            JdapiTypes.QRDA_NONE_CTID, JdapiTypes.QRDA_TABLE_CTID, JdapiTypes.QRDA_PROCEDURE_CTID, JdapiTypes.QRDA_TRANS_TRIG_CTID, JdapiTypes.QRDA_FRM_CLEAR_QUERY_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.READING_ORDER_PTID), new int[] {
            JdapiTypes.READ_DEFAULT_CTID, JdapiTypes.READ_TORIGHT_CTID, JdapiTypes.READ_TOLEFT_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.REAL_UNIT_PTID), new int[] {
            JdapiTypes.REUN_PIXEL_CTID, JdapiTypes.REUN_CENTIMETER_CTID, JdapiTypes.REUN_INCH_CTID, JdapiTypes.REUN_POINT_CTID, JdapiTypes.REUN_DECIPOINT_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.RECORD_GROUP_TYPE_PTID), new int[] {
            JdapiTypes.REGR_QUERY_CTID, JdapiTypes.REGR_STATIC_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.RECORD_ORIENTATION_PTID), new int[] {
            JdapiTypes.REOR_VERTICAL_CTID, JdapiTypes.REOR_HORIZONTAL_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.RELATION_TYPE_PTID), new int[] {
            JdapiTypes.RELT_JOIN_CTID, JdapiTypes.RELT_REFERENCE_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.REPORT_DESTINATION_TYPE_PTID), new int[] {
            JdapiTypes.RPDE_PREVIEW_CTID, JdapiTypes.RPDE_FILE_CTID, JdapiTypes.RPDE_PRINTER_CTID, JdapiTypes.RPDE_MAIL_CTID, JdapiTypes.RPDE_CACHE_CTID, JdapiTypes.RPDE_SCREEN_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.RUNTIME_COMP_PTID), new int[] {
            JdapiTypes.RUCO_45_CTID, JdapiTypes.RUCO_50_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.SCROLLBAR_ALIGN_PTID), new int[] {
            JdapiTypes.SCAL_START_CTID, JdapiTypes.SCAL_END_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.SCROLLBAR_ORIENTATION_PTID), new int[] {
            JdapiTypes.SCOR_VERTICAL_CTID, JdapiTypes.SCOR_HORIZONTAL_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.SINGLE_OBJECT_ALIGN_PTID), new int[] {
            JdapiTypes.ALIG_START_CTID, JdapiTypes.ALIG_END_CTID, JdapiTypes.ALIG_CENTER_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.SIZING_STYLE_PTID), new int[] {
            JdapiTypes.SIST_CROP_CTID, JdapiTypes.SIST_ADJUST_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.SOUND_FORMAT_PTID), new int[] {
            JdapiTypes.SNFM_AU_CTID, JdapiTypes.SNFM_AIFF_CTID, JdapiTypes.SNFM_AIFF_C_CTID, JdapiTypes.SNFM_WAVE_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.SOUND_QUALITY_PTID), new int[] {
            JdapiTypes.SNQL_AUTO_CTID, JdapiTypes.SNQL_HIGHEST_CTID, JdapiTypes.SNQL_HIGH_CTID, JdapiTypes.SNQL_MEDIUM_CTID, JdapiTypes.SNQL_LOW_CTID, JdapiTypes.SNQL_LOWEST_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.START_PROMPT_ALIGN_PTID), new int[] {
            JdapiTypes.ALIG_START_CTID, JdapiTypes.ALIG_END_CTID, JdapiTypes.ALIG_CENTER_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.SUMMARY_FUNCTION_PTID), new int[] {
            JdapiTypes.SUFU_NONE_CTID, JdapiTypes.SUFU_AVG_CTID, JdapiTypes.SUFU_COUNT_CTID, JdapiTypes.SUFU_MAXIMUM_CTID, JdapiTypes.SUFU_MINIMUM_CTID, JdapiTypes.SUFU_STDDEV_CTID, JdapiTypes.SUFU_SUM_CTID, JdapiTypes.SUFU_VAR_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.TAB_ATTACHMENT_EDGE_PTID), new int[] {
            JdapiTypes.TAAT_TOP_CTID, JdapiTypes.TAAT_BOTTOM_CTID, JdapiTypes.TAAT_LEFT_CTID, JdapiTypes.TAAT_RIGHT_CTID, JdapiTypes.TAAT_START_CTID, JdapiTypes.TAAT_END_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.TAB_STYLE_PTID), new int[] {
            JdapiTypes.TAST_CHAMFERED_CTID, JdapiTypes.TAST_SQUARE_CTID, JdapiTypes.TAST_ROUNDED_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.TITLE_READING_ORDER_PTID), new int[] {
            JdapiTypes.READ_DEFAULT_CTID, JdapiTypes.READ_TORIGHT_CTID, JdapiTypes.READ_TOLEFT_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.TOP_PROMPT_ALIGN_PTID), new int[] {
            JdapiTypes.ALIG_START_CTID, JdapiTypes.ALIG_END_CTID, JdapiTypes.ALIG_CENTER_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.TRIGGER_STYLE_PTID), new int[] {
            JdapiTypes.TRST_PLSQL_CTID, JdapiTypes.TRST_V2_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.UPDATE_LAYOUT_PTID), new int[] {
            JdapiTypes.UPLA_MANUAL_CTID, JdapiTypes.UPLA_AUTO_CTID, JdapiTypes.UPLA_LOCKED_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.VALIDATION_UNIT_PTID), new int[] {
            JdapiTypes.VAUN_DEFAULT_CTID, JdapiTypes.VAUN_FORM_CTID, JdapiTypes.VAUN_BLOCK_CTID, JdapiTypes.VAUN_RECORD_CTID, JdapiTypes.VAUN_ITEM_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.VERTICAL_JUSTIFICATION_PTID), new int[] {
            JdapiTypes.VEJU_TOP_CTID, JdapiTypes.VEJU_CENTER_CTID, JdapiTypes.VEJU_BOTTOM_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.VERTICAL_ORIGIN_PTID), new int[] {
            JdapiTypes.VEOR_TOP_CTID, JdapiTypes.VEOR_CENTER_CTID, JdapiTypes.VEOR_BOTTOM_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.VISUALATTRIBUTE_TYPE_PTID), new int[] {
            JdapiTypes.VATY_COMMON_CTID, JdapiTypes.VATY_PROMPT_CTID, JdapiTypes.VATY_TITLE_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.WINDOW_STYLE_PTID), new int[] {
            JdapiTypes.WIST_DOCUMENT_CTID, JdapiTypes.WIST_DIALOG_CTID
        });
        m_enumMap.put(new Integer(JdapiTypes.WRAP_STYLE_PTID), new int[] {
            JdapiTypes.WRST_NONE_CTID, JdapiTypes.WRST_CHARACTER_CTID, JdapiTypes.WRST_WORD_CTID
        });
    }
}
