// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.util.*;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiMetaObject, JdapiMetaProperty, JdapiTypes

public class JdapiMetadata
{

    public JdapiMetadata()
    {
    }

    public static Iterator getJdapiClasses()
    {
        return s_classes.keySet().iterator();
    }

    public static JdapiMetaObject getJdapiMetaObject(Class class1)
    {
        return (JdapiMetaObject)s_classes.get(class1);
    }

    static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }

    private static final Hashtable s_classes;

    static 
    {
        s_classes = new Hashtable();
        JdapiMetaObject jdapimetaobject = null;
        JdapiMetaProperty ajdapimetaproperty[] = {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MAIN_MENU_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MENU_DIRECTORY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MENU_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.STARTUP_CODE_PTID, true, true, null)
        };
        JdapiMetaProperty ajdapimetaproperty1[] = {
            new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ROLE_COUNT_PTID, true, false, null)
        };
        JdapiMetaProperty ajdapimetaproperty2[] = {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHARE_LIBRARY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.USE_SECURITY_PTID, true, true, null)
        };
        JdapiMetaProperty ajdapimetaproperty3[] = {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        };
        JdapiMetaProperty ajdapimetaproperty4[] = {
            new JdapiMetaProperty(JdapiTypes.ATTACHMENT_LIBRARY_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.MENU_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OBJECT_GROUP_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PROGRAM_UNIT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PROPERTY_CLASS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.VISUAL_ATTRIBUTE_PTID, true, false, null)
        };
        Class aclass[] = new Class[0];
        jdapimetaobject = new JdapiMetaObject("MenuModule", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.MenuModule.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.BOTTOM_TITLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TITLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.HEIGHT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WRAP_STYLE_PTID, true, true, new int[] {
                JdapiTypes.WRST_NONE_CTID, JdapiTypes.WRST_CHARACTER_CTID, JdapiTypes.WRST_WORD_CTID
            }), 
            new JdapiMetaProperty(JdapiTypes.X_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.Y_POSITION_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_HORIZONTAL_SCROLLBAR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_VERTICAL_SCROLLBAR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("Editor", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Editor.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.ALERT_MESSAGE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.BUTTON_1_LABEL_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.BUTTON_2_LABEL_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.BUTTON_3_LABEL_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TITLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.ALERT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.ALST_STOP_CTID, JdapiTypes.ALST_CAUTION_CTID, JdapiTypes.ALST_NOTE_CTID
            }), new JdapiMetaProperty(JdapiTypes.DEFAULT_ALERT_BUTTON_PTID, true, true, new int[] {
                JdapiTypes.DFAL_BTN1_CTID, JdapiTypes.DFAL_BTN2_CTID, JdapiTypes.DFAL_BTN3_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, true, true, new int[] {
                JdapiTypes.LADI_DEFAULT_CTID, JdapiTypes.LADI_TORIGHT_CTID, JdapiTypes.LADI_TOLEFT_CTID
            }), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("Alert", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Alert.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CONSOLE_WINDOW_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FIRST_NAVIGATION_BLOCK_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HELP_BOOK_TITLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HORIZONTAL_TOOLBAR_CANVAS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.INITIALIZE_MENU_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MENU_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MENU_ROLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TITLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VERTICAL_TOOLBAR_CANVAS_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.CURSOR_MODE_PTID, true, false, new int[] {
                JdapiTypes.CRMO_OPEN_CTID, JdapiTypes.CRMO_CLOSE_CTID
            }), new JdapiMetaProperty(JdapiTypes.INTERACTION_MODE_PTID, true, true, new int[] {
                JdapiTypes.INMO_BLOCKING_CTID, JdapiTypes.INMO_NONBLOCKING_CTID
            }), new JdapiMetaProperty(JdapiTypes.ISOLATION_MODE_PTID, true, true, new int[] {
                JdapiTypes.ISMO_READ_CTID, JdapiTypes.ISMO_SERIAL_CTID
            }), new JdapiMetaProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, true, true, new int[] {
                JdapiTypes.LADI_DEFAULT_CTID, JdapiTypes.LADI_TORIGHT_CTID, JdapiTypes.LADI_TOLEFT_CTID
            }), new JdapiMetaProperty(JdapiTypes.MAXIMUM_QUERY_TIME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MAXIMUM_RECORDS_FETCHED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MOUSE_NAVIGATION_LIMIT_PTID, true, true, new int[] {
                JdapiTypes.MONA_FORM_CTID, JdapiTypes.MONA_BLOCK_CTID, JdapiTypes.MONA_RECORD_CTID, JdapiTypes.MONA_ITEM_CTID
            }), new JdapiMetaProperty(JdapiTypes.NEWDEFER_REQ_ENF_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RUNTIME_COMP_PTID, true, true, new int[] {
                JdapiTypes.RUCO_45_CTID, JdapiTypes.RUCO_50_CTID
            }), new JdapiMetaProperty(JdapiTypes.VALIDATION_UNIT_PTID, true, true, new int[] {
                JdapiTypes.VAUN_DEFAULT_CTID, JdapiTypes.VAUN_FORM_CTID, JdapiTypes.VAUN_BLOCK_CTID, JdapiTypes.VAUN_RECORD_CTID, JdapiTypes.VAUN_ITEM_CTID
            })
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SAVEPOINT_MODE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.USE_3D_CONTROLS_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.FIRST_NAVIGATION_BLOCK_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_OBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.ALERT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.ATTACHMENT_LIBRARY_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.BLOCK_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.CANVAS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.EDITOR_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.FORM_PARAMETER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.LOV_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.MENU_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OBJECT_GROUP_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PROGRAM_UNIT_PTID, true, false, null), 
            new JdapiMetaProperty(JdapiTypes.PROPERTY_CLASS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.RECORD_GROUP_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.REPORT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.TRIGGER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.VISUAL_ATTRIBUTE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.WINDOW_PTID, true, false, null)
        });
        aclass = new Class[0];
        jdapimetaobject = new JdapiMetaObject("FormModule", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.FormModule.class, jdapimetaobject);
        ajdapimetaproperty = new JdapiMetaProperty[0];
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.CHARACTER_CELL_HEIGHT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CHARACTER_CELL_WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COORDINATE_SYSTEM_PTID, true, true, new int[] {
                JdapiTypes.COSY_CHARACTER_CTID, JdapiTypes.COSY_REAL_CTID
            }), new JdapiMetaProperty(JdapiTypes.REAL_UNIT_PTID, true, true, new int[] {
                JdapiTypes.REUN_PIXEL_CTID, JdapiTypes.REUN_CENTIMETER_CTID, JdapiTypes.REUN_INCH_CTID, JdapiTypes.REUN_POINT_CTID, JdapiTypes.REUN_DECIPOINT_CTID
            })
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DEFAULT_FONT_SCALING_PTID, true, true, null)
        });
        ajdapimetaproperty3 = new JdapiMetaProperty[0];
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class
        });
        jdapimetaobject = new JdapiMetaObject("Coordinate", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Coordinate.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LABEL_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ENABLED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISIBLE_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.GRAPHIC_PTID, true, false, null)
        });
        aclass = (new Class[] {
            oracle.forms.jdapi.Canvas.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("TabPage", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.TabPage.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.TRIGGER_PTID, true, false, null)
        });
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.MenuModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("PropertyClass", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.PropertyClass.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DSA_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DSA_TYPE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DSA_VALUE_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DSA_MODE_PTID, true, true, new int[] {
                JdapiTypes.DSMO_IN_CTID, JdapiTypes.DSMO_OUT_CTID, JdapiTypes.DSMO_IN_OUT_CTID
            }), new JdapiMetaProperty(JdapiTypes.DSA_TYPE_PTID, true, true, new int[] {
                JdapiTypes.DSTY_VARCHAR2_CTID, JdapiTypes.DSTY_NUMBER_CTID, JdapiTypes.DSTY_LONG_CTID, JdapiTypes.DSTY_ROWID_CTID, JdapiTypes.DSTY_DATE_CTID, JdapiTypes.DSTY_RAW_CTID, JdapiTypes.DSTY_LONG_RAW_CTID, JdapiTypes.DSTY_CHARACTER_CTID, JdapiTypes.DSTY_MLSLABEL_CTID, JdapiTypes.DSTY_TABLE_CTID, 
                JdapiTypes.DSTY_RECORD_CTID, JdapiTypes.DSTY_REFCURSOR_CTID, JdapiTypes.DSTY_NAMEDTYPE_CTID, JdapiTypes.DSTY_OBJECTREF_CTID, JdapiTypes.DSTY_VARRAY_CTID, JdapiTypes.DSTY_NESTEDTAB_CTID, JdapiTypes.DSTY_BLOB_CTID, JdapiTypes.DSTY_CLOB_CTID, JdapiTypes.DSTY_BFILE_CTID
            }), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.Block.class
        });
        jdapimetaobject = new JdapiMetaObject("DataSourceArgument", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.DataSourceArgument.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DSC_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DSC_PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DSC_TYPE_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DSC_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DSC_PRECISION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DSC_SCALE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DSC_TYPE_PTID, true, true, new int[] {
                JdapiTypes.DSTY_VARCHAR2_CTID, JdapiTypes.DSTY_NUMBER_CTID, JdapiTypes.DSTY_LONG_CTID, JdapiTypes.DSTY_ROWID_CTID, JdapiTypes.DSTY_DATE_CTID, JdapiTypes.DSTY_RAW_CTID, JdapiTypes.DSTY_LONG_RAW_CTID, JdapiTypes.DSTY_CHARACTER_CTID, JdapiTypes.DSTY_MLSLABEL_CTID, JdapiTypes.DSTY_TABLE_CTID, 
                JdapiTypes.DSTY_RECORD_CTID, JdapiTypes.DSTY_REFCURSOR_CTID, JdapiTypes.DSTY_NAMEDTYPE_CTID, JdapiTypes.DSTY_OBJECTREF_CTID, JdapiTypes.DSTY_VARRAY_CTID, JdapiTypes.DSTY_NESTEDTAB_CTID, JdapiTypes.DSTY_BLOB_CTID, JdapiTypes.DSTY_CLOB_CTID, JdapiTypes.DSTY_BFILE_CTID
            }), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DSC_MANDATORY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DSC_NOCHILDREN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.Block.class
        });
        jdapimetaobject = new JdapiMetaObject("DataSourceColumn", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.DataSourceColumn.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = new JdapiMetaProperty[0];
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.TEXT_SEGMENT_PTID, true, false, null)
        });
        aclass = (new Class[] {
            oracle.forms.jdapi.Graphics.class
        });
        jdapimetaobject = new JdapiMetaObject("CompoundText", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.CompoundText.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RETURN_ITEM_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TITLE_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DISPLAY_WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.LOV.class
        });
        jdapimetaobject = new JdapiMetaObject("LOVColumnMapping", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.LOVColumnMapping.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.LIBRARY_LOCATION_PTID, true, false, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.LIBRARY_SOURCE_PTID, true, false, new int[] {
                JdapiTypes.LISR_FS_CTID, JdapiTypes.LISR_DATABASE_CTID
            })
        });
        ajdapimetaproperty2 = new JdapiMetaProperty[0];
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.ATTACHMENT_LIBRARY_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.LIBRARY_PROGRAM_UNIT_PTID, true, false, null)
        });
        aclass = new Class[0];
        jdapimetaobject = new JdapiMetaObject("PlsqlModule", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.PlsqlModule.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.OBJECT_GROUP_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.OBJECTGROUP_CHILD_PTID, true, false, null)
        });
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.MenuModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("ObjectGroup", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.ObjectGroup.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.EDGE_BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.EDGE_FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.EDGE_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FONT_NAME_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.GRAPHICS_FONT_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.GRAPHICS_FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.GRAPHICS_TEXT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LAYOUT_DATA_BLOCK_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TABPAGE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.ARROW_STYLE_PTID, true, true, new int[] {
                JdapiTypes.ARST_NONE_CTID, JdapiTypes.ARST_START_CTID, JdapiTypes.ARST_END_CTID, JdapiTypes.ARST_BOTH_CTID, JdapiTypes.ARST_MDLTOSTRT_CTID, JdapiTypes.ARST_MDLTOEND_CTID
            }), new JdapiMetaProperty(JdapiTypes.BEVEL_PTID, true, true, new int[] {
                JdapiTypes.BEST_RAISED_CTID, JdapiTypes.BEST_LOWERED_CTID, JdapiTypes.BEST_NONE_CTID, JdapiTypes.BEST_NSET_CTID, JdapiTypes.BEST_OUTSET_CTID, JdapiTypes.BEST_PLAIN_CTID
            }), new JdapiMetaProperty(JdapiTypes.CAP_STYLE_PTID, true, true, new int[] {
                JdapiTypes.CAST_BUTT_CTID, JdapiTypes.CAST_ROUND_CTID, JdapiTypes.CAST_PROJECT_CTID
            }), new JdapiMetaProperty(JdapiTypes.CLIP_HEIGHT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CLIP_WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CLIP_X_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CLIP_Y_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CORNER_RADIUS_X_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CORNER_RADIUS_Y_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CUSTOM_SPACING_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.DASH_STYLE_PTID, true, true, new int[] {
                JdapiTypes.DAST_SOLID_CTID, JdapiTypes.DAST_DOT_CTID, JdapiTypes.DAST_DASH_CTID, JdapiTypes.DAST_DASHDOT_CTID, JdapiTypes.DAST_DOUBDOT_CTID, JdapiTypes.DAST_LONGDASH_CTID, JdapiTypes.DAST_DASHDOUBDOT_CTID
            }), new JdapiMetaProperty(JdapiTypes.DISPLAY_QUALITY_PTID, true, true, new int[] {
                JdapiTypes.DIQL_HIGH_CTID, JdapiTypes.DIQL_MEDIUM_CTID, JdapiTypes.DIQL_LOW_CTID
            }), new JdapiMetaProperty(JdapiTypes.DISTANCE_BETWEEN_RECORDS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_ALIGN_PTID, true, true, new int[] {
                JdapiTypes.FRAL_START_CTID, JdapiTypes.FRAL_END_CTID, JdapiTypes.FRAL_CENTER_CTID, JdapiTypes.FRAL_FILL_CTID, JdapiTypes.FRAL_COLUMN_CTID
            }), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_ALIGN_PTID, true, true, new int[] {
                JdapiTypes.JUSTIFICATION_LEFT_CTID, JdapiTypes.JUSTIFICATION_RIGHT_CTID, JdapiTypes.JUSTIFICATION_CENTER_CTID, JdapiTypes.JUSTIFICATION_START_CTID, JdapiTypes.JUSTIFICATION_END_CTID
            }), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_OFFSET_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_SPACING_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.GRAPHICS_FONT_COLOR_CODE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.GRAPHICS_FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.GRAPHICS_FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.GRAPHICS_FONT_STYLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.GRAPHICS_FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.GRAPHICS_TYPE_PTID, true, true, new int[] {
                JdapiTypes.GRTY_ARC_CTID, JdapiTypes.GRTY_IMAGE_CTID, JdapiTypes.GRTY_LINE_CTID, JdapiTypes.GRTY_POLY_CTID, JdapiTypes.GRTY_RECT_CTID, JdapiTypes.GRTY_RREC_CTID, JdapiTypes.GRTY_TEXT_CTID, JdapiTypes.GRTY_GROUP_CTID, JdapiTypes.GRTY_FRAME_CTID
            }), new JdapiMetaProperty(JdapiTypes.HEIGHT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HORIZONTAL_JUSTIFICATION_PTID, true, true, new int[] {
                JdapiTypes.HOJU_LEFT_CTID, JdapiTypes.HOJU_RIGHT_CTID, JdapiTypes.HOJU_CENTER_CTID, JdapiTypes.HOJU_START_CTID, JdapiTypes.HOJU_END_CTID
            }), new JdapiMetaProperty(JdapiTypes.HORIZONTAL_MARGIN_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.HORIZONTAL_OBJECT_OFFSET_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HORIZONTAL_ORIGIN_PTID, true, true, new int[] {
                JdapiTypes.HOOR_LEFT_CTID, JdapiTypes.HOOR_RIGHT_CTID, JdapiTypes.HOOR_CENTER_CTID
            }), new JdapiMetaProperty(JdapiTypes.IMAGE_DEPTH_PTID, true, true, new int[] {
                JdapiTypes.IMDP_ORIG_CTID, JdapiTypes.IMDP_MONO_CTID, JdapiTypes.IMDP_GRAY_CTID, JdapiTypes.IMDP_LUT_CTID, JdapiTypes.IMDP_RGB_CTID
            }), new JdapiMetaProperty(JdapiTypes.IMAGE_FORMAT_PTID, true, true, new int[] {
                JdapiTypes.IMFM_BMP_CTID, JdapiTypes.IMFM_CALS_CTID, JdapiTypes.IMFM_GIF_CTID, JdapiTypes.IMFM_JFIF_CTID, JdapiTypes.IMFM_PICT_CTID, JdapiTypes.IMFM_RAS_CTID, JdapiTypes.IMFM_TIFF_CTID, JdapiTypes.IMFM_TPIC_CTID
            }), new JdapiMetaProperty(JdapiTypes.INTERNAL_END_ANGLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.INTERNAL_LINE_WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.INTERNAL_ROTATION_ANGLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.INTERNAL_START_ANGLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.JOIN_STYLE_PTID, true, true, new int[] {
                JdapiTypes.JOST_MITRE_CTID, JdapiTypes.JOST_BEVEL_CTID, JdapiTypes.JOST_ROUND_CTID
            }), new JdapiMetaProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, true, true, new int[] {
                JdapiTypes.LADI_DEFAULT_CTID, JdapiTypes.LADI_TORIGHT_CTID, JdapiTypes.LADI_TOLEFT_CTID
            }), 
            new JdapiMetaProperty(JdapiTypes.LAYOUT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.LAST_FORM_CTID, JdapiTypes.LAST_TABULAR_CTID
            }), new JdapiMetaProperty(JdapiTypes.LINE_SPACING_PTID, true, true, new int[] {
                JdapiTypes.LISP_SINGLE_CTID, JdapiTypes.LISP_ONEHALF_CTID, JdapiTypes.LISP_DOUBLE_CTID, JdapiTypes.LISP_CUSTOM_CTID
            }), new JdapiMetaProperty(JdapiTypes.MAXIMUM_OBJS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORDS_DISPLAY_COUNT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SCROLLBAR_ALIGN_PTID, true, true, new int[] {
                JdapiTypes.SCAL_START_CTID, JdapiTypes.SCAL_END_CTID
            }), new JdapiMetaProperty(JdapiTypes.SCROLLBAR_WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SINGLE_OBJECT_ALIGN_PTID, true, true, new int[] {
                JdapiTypes.ALIG_START_CTID, JdapiTypes.ALIG_END_CTID, JdapiTypes.ALIG_CENTER_CTID
            }), 
            new JdapiMetaProperty(JdapiTypes.START_PROMPT_ALIGN_PTID, true, true, new int[] {
                JdapiTypes.ALIG_START_CTID, JdapiTypes.ALIG_END_CTID, JdapiTypes.ALIG_CENTER_CTID
            }), new JdapiMetaProperty(JdapiTypes.START_PROMPT_OFFSET_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TOP_PROMPT_ALIGN_PTID, true, true, new int[] {
                JdapiTypes.ALIG_START_CTID, JdapiTypes.ALIG_END_CTID, JdapiTypes.ALIG_CENTER_CTID
            }), new JdapiMetaProperty(JdapiTypes.TOP_PROMPT_OFFSET_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TITLE_READING_ORDER_PTID, true, true, new int[] {
                JdapiTypes.READ_DEFAULT_CTID, JdapiTypes.READ_TORIGHT_CTID, JdapiTypes.READ_TOLEFT_CTID
            }), new JdapiMetaProperty(JdapiTypes.UPDATE_LAYOUT_PTID, true, true, new int[] {
                JdapiTypes.UPLA_MANUAL_CTID, JdapiTypes.UPLA_AUTO_CTID, JdapiTypes.UPLA_LOCKED_CTID
            }), new JdapiMetaProperty(JdapiTypes.VERTICAL_JUSTIFICATION_PTID, true, true, new int[] {
                JdapiTypes.VEJU_TOP_CTID, JdapiTypes.VEJU_CENTER_CTID, JdapiTypes.VEJU_BOTTOM_CTID
            }), new JdapiMetaProperty(JdapiTypes.VERTICAL_MARGIN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VERTICAL_OBJECT_OFFSET_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VERTICAL_ORIGIN_PTID, true, true, new int[] {
                JdapiTypes.VEOR_TOP_CTID, JdapiTypes.VEOR_CENTER_CTID, JdapiTypes.VEOR_BOTTOM_CTID
            }), 
            new JdapiMetaProperty(JdapiTypes.WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.X_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.Y_POSITION_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.ALLOW_EXPANSION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ALLOW_MULTI_LINE_PROMPTS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ALLOW_START_ATTACHMENT_PROMPTS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ALLOW_TOP_ATTACHMENT_PROMPTS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.BOUNDING_BOX_SCALABLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CLOSED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DITHER_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FIXED_BOUNDING_BOX_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SCALEABLE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.SHOW_SCROLLBAR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHRINKWRAP_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VERTICAL_FILL_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WRAP_TEXT_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.TABPAGE_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMPOUNDTEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.GRAPHIC_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.POINT_PTID, true, false, null)
        });
        aclass = (new Class[] {
            oracle.forms.jdapi.Canvas.class, oracle.forms.jdapi.Graphics.class, oracle.forms.jdapi.TabPage.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("Graphics", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Graphics.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HELP_BOOK_TOPIC_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.POPUP_MENU_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WINDOW_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.BEVEL_PTID, true, true, new int[] {
                JdapiTypes.BEST_RAISED_CTID, JdapiTypes.BEST_LOWERED_CTID, JdapiTypes.BEST_NONE_CTID, JdapiTypes.BEST_NSET_CTID, JdapiTypes.BEST_OUTSET_CTID, JdapiTypes.BEST_PLAIN_CTID
            }), new JdapiMetaProperty(JdapiTypes.CANVAS_TYPE_PTID, true, true, new int[] {
                JdapiTypes.CNTY_CONTENT_CTID, JdapiTypes.CNTY_STACKED_CTID, JdapiTypes.CNTY_VTOOLBAR_CTID, JdapiTypes.CNTY_HTOOLBAR_CTID, JdapiTypes.CNTY_TAB_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.HEIGHT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, true, true, new int[] {
                JdapiTypes.LADI_DEFAULT_CTID, JdapiTypes.LADI_TORIGHT_CTID, JdapiTypes.LADI_TOLEFT_CTID
            }), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TAB_ACTION_STYLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TAB_ATTACHMENT_EDGE_PTID, true, true, new int[] {
                JdapiTypes.TAAT_TOP_CTID, JdapiTypes.TAAT_BOTTOM_CTID, JdapiTypes.TAAT_LEFT_CTID, JdapiTypes.TAAT_RIGHT_CTID, JdapiTypes.TAAT_START_CTID, JdapiTypes.TAAT_END_CTID
            }), new JdapiMetaProperty(JdapiTypes.TAB_STYLE_PTID, true, true, new int[] {
                JdapiTypes.TAST_CHAMFERED_CTID, JdapiTypes.TAST_SQUARE_CTID, JdapiTypes.TAST_ROUNDED_CTID
            }), new JdapiMetaProperty(JdapiTypes.TAB_WIDTH_STYLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VIEWPORT_HEIGHT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VIEWPORT_WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VIEWPORT_X_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VIEWPORT_X_POSITION_ON_CANVAS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VIEWPORT_Y_POSITION_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.VIEWPORT_Y_POSITION_ON_CANVAS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WIDTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DISPLAY_VIEWPORT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RAISE_ON_ENTER_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_HORIZONTAL_SCROLLBAR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_VERTICAL_SCROLLBAR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISIBLE_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.POPUP_MENU_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WINDOW_OBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.GRAPHIC_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.TAB_PAGE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.VISUAL_STATE_PTID, true, true, null)
        });
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("Canvas", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Canvas.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.EDGE_BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.EDGE_FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.EDGE_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.ARROW_STYLE_PTID, true, true, new int[] {
                JdapiTypes.ARST_NONE_CTID, JdapiTypes.ARST_START_CTID, JdapiTypes.ARST_END_CTID, JdapiTypes.ARST_BOTH_CTID, JdapiTypes.ARST_MDLTOSTRT_CTID, JdapiTypes.ARST_MDLTOEND_CTID
            }), new JdapiMetaProperty(JdapiTypes.CAP_STYLE_PTID, true, true, new int[] {
                JdapiTypes.CAST_BUTT_CTID, JdapiTypes.CAST_ROUND_CTID, JdapiTypes.CAST_PROJECT_CTID
            }), new JdapiMetaProperty(JdapiTypes.CHARACTER_CELL_HDEN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CHARACTER_CELL_HNUM_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CHARACTER_CELL_VDEN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CHARACTER_CELL_VNUM_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CORNER_RADIUS_X_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CORNER_RADIUS_Y_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DASH_STYLE_PTID, true, true, new int[] {
                JdapiTypes.DAST_SOLID_CTID, JdapiTypes.DAST_DOT_CTID, JdapiTypes.DAST_DASH_CTID, JdapiTypes.DAST_DASHDOT_CTID, JdapiTypes.DAST_DOUBDOT_CTID, JdapiTypes.DAST_LONGDASH_CTID, JdapiTypes.DAST_DASHDOUBDOT_CTID
            }), new JdapiMetaProperty(JdapiTypes.DISPLAY_QUALITY_PTID, true, true, new int[] {
                JdapiTypes.DIQL_HIGH_CTID, JdapiTypes.DIQL_MEDIUM_CTID, JdapiTypes.DIQL_LOW_CTID
            }), 
            new JdapiMetaProperty(JdapiTypes.DRAWING_HDEN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DRAWING_HNUM_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DRAWING_WDEN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DRAWING_WNUM_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.EDITOR_HEIGHT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.EDITOR_WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), 
            new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_ALIGN_PTID, true, true, new int[] {
                JdapiTypes.JUSTIFICATION_LEFT_CTID, JdapiTypes.JUSTIFICATION_RIGHT_CTID, JdapiTypes.JUSTIFICATION_CENTER_CTID, JdapiTypes.JUSTIFICATION_START_CTID, JdapiTypes.JUSTIFICATION_END_CTID
            }), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_OFFSET_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_SPACING_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.GRID_INTERVAL_CNT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.GRID_SNAP_CNT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.GRID_UNIT_CNT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.INTERNAL_LINE_WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.INTERNAL_ROTATION_ANGLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RULER_MAJOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RULER_MINOR_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.RULER_UNIT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WINDOW_HEIGHT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WINDOW_WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WINDOW_X_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WINDOW_Y_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ZOOM_LEVEL_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.BOUNDING_BOX_SCALABLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CENTER_TRACKING_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CLOSED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DITHER_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FIXED_BOUNDING_BOX_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SCALEABLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.GRID_FLAG_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.GRIDSNAP_FLAG_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PAGE_COUNT_SEQ_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PAGEBREAK_FLAG_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.RESIZABLE_FLAG_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RULER_FLAG_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RULER_GUIDE_FLAG_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_CANVAS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_VIEW_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.STATUS_LINE_FLAG_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TOOLPALETTE_FLAG_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUAL_STATE_VALID_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WRAP_TEXT_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.Canvas.class
        });
        jdapimetaobject = new JdapiMetaObject("VisualState", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.VisualState.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.X_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.Y_POSITION_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.Graphics.class
        });
        jdapimetaobject = new JdapiMetaObject("Point", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Point.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORD_GROUP_QUERY_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORD_GROUP_FETCH_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORD_GROUP_TYPE_PTID, true, true, new int[] {
                JdapiTypes.REGR_QUERY_CTID, JdapiTypes.REGR_STATIC_CTID
            })
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COLUMN_SPECIFICATION_PTID, true, false, null)
        });
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("RecordGroup", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.RecordGroup.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HELP_BOOK_TOPIC_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HORIZONTALTOOLBAR_CANVAS_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ICON_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MINIMIZE_TITLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PRIMARY_CANVAS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TITLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VERTICALTOOLBAR_CANVAS_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.BEVEL_PTID, true, true, new int[] {
                JdapiTypes.BEST_RAISED_CTID, JdapiTypes.BEST_LOWERED_CTID, JdapiTypes.BEST_NONE_CTID, JdapiTypes.BEST_NSET_CTID, JdapiTypes.BEST_OUTSET_CTID, JdapiTypes.BEST_PLAIN_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.HEIGHT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, true, true, new int[] {
                JdapiTypes.LADI_DEFAULT_CTID, JdapiTypes.LADI_TORIGHT_CTID, JdapiTypes.LADI_TOLEFT_CTID
            }), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WINDOW_STYLE_PTID, true, true, new int[] {
                JdapiTypes.WIST_DOCUMENT_CTID, JdapiTypes.WIST_DIALOG_CTID
            }), new JdapiMetaProperty(JdapiTypes.X_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.Y_POSITION_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.CLEAR_ALLOWED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HIDE_ON_EXIT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.INHERIT_MENU_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MAXIMIZE_ALLOWED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MINIMIZE_ALLOWED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MODAL_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MOVE_ALLOWED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RESIZE_ALLOWED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_HORIZONTAL_SCROLLBAR_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.SHOW_VERTICAL_SCROLLBAR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("Window", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Window.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.OBJECT_COUNT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.OBJECT_LIBRARY_TAB_PTID, true, false, null)
        });
        aclass = new Class[0];
        jdapimetaobject = new JdapiMetaObject("ObjectLibrary", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.ObjectLibrary.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.KEYBOARD_HELP_TEXT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TRIGGER_TEXT_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.EXECUTE_HIERARCHY_PTID, true, true, new int[] {
                JdapiTypes.EXHI_OVERRIDE_CTID, JdapiTypes.EXHI_BEFORE_CTID, JdapiTypes.EXHI_AFTER_CTID
            }), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TRIGGER_INTERNAL_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TRIGGER_STYLE_PTID, true, true, new int[] {
                JdapiTypes.TRST_PLSQL_CTID, JdapiTypes.TRST_V2_CTID
            })
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DISPLAY_IN_KEYBOARD_HELP_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FIRE_IN_QUERY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HIDE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.TRIG_STEP_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.Item.class, oracle.forms.jdapi.Block.class, oracle.forms.jdapi.PropertyClass.class, oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("Trigger", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Trigger.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.ALIAS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DELETE_PROCEDURE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DML_DATA_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.INSERT_PROCEDURE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LOCK_PROCEDURE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.NEXT_NAVIGATION_BLOCK_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.OPTION_HINT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ORDER_BY_CLAUSE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_NAVIGATION_BLOCK_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.QUERY_DATA_SOURCE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_NAME_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.SCROLLBAR_CANVAS_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SCROLLBAR_TABPAGE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.UPDATE_PROCEDURE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.WHERE_CLAUSE_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DML_ARRAY_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DML_DATA_TYPE_PTID, true, true, new int[] {
                JdapiTypes.DMDA_NONE_CTID, JdapiTypes.DMDA_TABLE_CTID, JdapiTypes.DMDA_PROCEDURE_CTID, JdapiTypes.DMDA_TRANS_TRIG_CTID
            }), new JdapiMetaProperty(JdapiTypes.KEY_MODE_PTID, true, true, new int[] {
                JdapiTypes.KEMO_UNIQUE_CTID, JdapiTypes.KEMO_UPDATEABLE_CTID, JdapiTypes.KEMO_NUPDATEABLE_CTID, JdapiTypes.KEMO_AUTO_CTID
            }), new JdapiMetaProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, true, true, new int[] {
                JdapiTypes.LADI_DEFAULT_CTID, JdapiTypes.LADI_TORIGHT_CTID, JdapiTypes.LADI_TOLEFT_CTID
            }), new JdapiMetaProperty(JdapiTypes.LOCK_MODE_PTID, true, true, new int[] {
                JdapiTypes.LOMO_IMMEDIATE_CTID, JdapiTypes.LOMO_DELAYED_CTID, JdapiTypes.LOMO_AUTO_CTID
            }), new JdapiMetaProperty(JdapiTypes.MAXIMUM_QUERY_TIME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MAXIMUM_RECORDS_FETCHED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAVIGATION_STYLE_PTID, true, true, new int[] {
                JdapiTypes.NAST_SAMERECORD_CTID, JdapiTypes.NAST_CHANGERECORD_CTID, JdapiTypes.NAST_CHANGEBLOCK_CTID
            }), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.QUERY_DATA_SOURCE_TYPE_PTID, true, true, new int[] {
                JdapiTypes.QRDA_NONE_CTID, JdapiTypes.QRDA_TABLE_CTID, JdapiTypes.QRDA_PROCEDURE_CTID, JdapiTypes.QRDA_TRANS_TRIG_CTID, JdapiTypes.QRDA_FRM_CLEAR_QUERY_CTID
            }), new JdapiMetaProperty(JdapiTypes.RECORD_ORIENTATION_PTID, true, true, new int[] {
                JdapiTypes.REOR_VERTICAL_CTID, JdapiTypes.REOR_HORIZONTAL_CTID
            }), new JdapiMetaProperty(JdapiTypes.RECORDS_BUFFERED_COUNT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORDS_DISPLAY_COUNT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORDS_FETCHED_COUNT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SCROLLBAR_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SCROLLBAR_ORIENTATION_PTID, true, true, new int[] {
                JdapiTypes.SCOR_VERTICAL_CTID, JdapiTypes.SCOR_HORIZONTAL_CTID
            }), new JdapiMetaProperty(JdapiTypes.SCROLLBAR_WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SCROLLBAR_X_POSITION_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.SCROLLBAR_Y_POSITION_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DATABASE_BLOCK_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DELETE_ALLOWED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DML_RETURN_VALUE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ENFORCED_COLUMN_SECURITY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ENFORCED_PRIMARY_KEY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.INCLUDE_REFITEM_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.INSERT_ALLOWED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PRECOMP_SUMMARY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.QUERY_ALL_RECORDS_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.QUERY_ALLOWED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.REVERSE_DIRECTION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_SCROLLBAR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SINGLE_RECORD_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.UPDATE_ALLOWED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.UPDATE_CHANGED_COLUMNS_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_NAVIGATION_BLOCK_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_NAVIGATION_BLOCK_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SCROLLBAR_CANVAS_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SCROLLBAR_TABPAGE_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null), 
            new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DELETE_DATA_SOURCE_ARGUMENT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.DELETE_DATA_SOURCE_COLUMN_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.INSERT_DATA_SOURCE_ARGUMENT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.INSERT_DATA_SOURCE_COLUMN_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.ITEM_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.LOCK_DATA_SOURCE_ARGUMENT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.LOCK_DATA_SOURCE_COLUMN_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.QUERY_DATA_SOURCE_ARGUMENT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.QUERY_DATA_SOURCE_COLUMN_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.RELATION_PTID, true, false, null), 
            new JdapiMetaProperty(JdapiTypes.TRIGGER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.UPDATE_DATA_SOURCE_ARGUMENT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.UPDATE_DATA_SOURCE_COLUMN_PTID, true, false, null)
        });
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("Block", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Block.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DATA_SOURCE_BLOCK_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.QUERY_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.REPORT_DESTINATION_FORMAT_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.REPORT_DESTINATION_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.REPORT_PARAMETERS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.REPORT_SERVER_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMM_MODE_PTID, true, true, new int[] {
                JdapiTypes.COMO_SYNCH_CTID, JdapiTypes.COMO_ASYNCH_CTID
            }), new JdapiMetaProperty(JdapiTypes.EXECUTE_MODE_PTID, true, true, new int[] {
                JdapiTypes.EXMO_BATCH_CTID, JdapiTypes.EXMO_RUNTIME_CTID
            }), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.REPORT_DESTINATION_TYPE_PTID, true, true, new int[] {
                JdapiTypes.RPDE_PREVIEW_CTID, JdapiTypes.RPDE_FILE_CTID, JdapiTypes.RPDE_PRINTER_CTID, JdapiTypes.RPDE_MAIL_CTID, JdapiTypes.RPDE_CACHE_CTID, JdapiTypes.RPDE_SCREEN_CTID
            })
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("Report", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Report.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DETAIL_BLOCK_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DETAIL_ITEMREF_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.JOIN_CONDITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DELETE_RECORD_PTID, true, true, new int[] {
                JdapiTypes.DERE_CASCADING_CTID, JdapiTypes.DERE_ISOLATED_CTID, JdapiTypes.DERE_NON_ISOLATED_CTID
            }), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RELATION_TYPE_PTID, true, true, new int[] {
                JdapiTypes.RELT_JOIN_CTID, JdapiTypes.RELT_REFERENCE_CTID
            })
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.AUTO_QUERY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DEFERRED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PREVENT_MASTERLESS_OPERATIONS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.Block.class
        });
        jdapimetaobject = new JdapiMetaObject("Relation", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Relation.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMAND_TEXT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HINT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ICON_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.KEYBOARD_ACCELERATOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LABEL_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MENU_ITEM_CODE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MENU_ITEM_RADIO_GROUP_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUB_MENU_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMAND_TYPE_PTID, true, true, new int[] {
                JdapiTypes.COTY_NULL_CTID, JdapiTypes.COTY_MENU_CTID, JdapiTypes.COTY_PLSQL_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.MAGIC_ITEM_PTID, true, true, new int[] {
                JdapiTypes.MAIT_NONE_CTID, JdapiTypes.MAIT_CUT_CTID, JdapiTypes.MAIT_COPY_CTID, JdapiTypes.MAIT_PASTE_CTID, JdapiTypes.MAIT_CLEAR_CTID, JdapiTypes.MAIT_UNDO_CTID, JdapiTypes.MAIT_HELP_CTID, JdapiTypes.MAIT_ABOUT_CTID, JdapiTypes.MAIT_QUIT_CTID, JdapiTypes.MAIT_WINDOW_CTID, 
                JdapiTypes.MAIT_PAGESETUP_CTID
            }), new JdapiMetaProperty(JdapiTypes.MENU_ITEM_TYPE_PTID, true, true, new int[] {
                JdapiTypes.MNIT_PLAIN_CTID, JdapiTypes.MNIT_CHECK_CTID, JdapiTypes.MNIT_RADIO_CTID, JdapiTypes.MNIT_SEPARATOR_CTID, JdapiTypes.MNIT_MAGIC_CTID
            }), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ROLE_COUNT_PTID, true, false, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DISPLAY_NO_PRIV_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ENABLED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ICON_IN_MENU_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISIBLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISIBLE_IN_HORIZONTAL_MENU_TOOLBAR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISIBLE_IN_MENU_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISIBLE_IN_VERTICAL_MENU_TOOLBAR_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SUB_MENU_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.Menu.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("MenuItem", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.MenuItem.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COLUMN_DATA_TYPE_PTID, true, true, new int[] {
                JdapiTypes.CODA_CHARACTER_CTID, JdapiTypes.CODA_NUMBER_CTID, JdapiTypes.CODA_DATE_CTID, JdapiTypes.CODA_LONG_CTID, JdapiTypes.CODA_REFERENCE_CTID
            }), new JdapiMetaProperty(JdapiTypes.COLUMN_VALUES_COUNT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.DATA_LENGTH_SEMANTICS_PTID, true, true, new int[] {
                JdapiTypes.CHLE_NULL_CTID, JdapiTypes.CHLE_BYTE_CTID, JdapiTypes.CHLE_CHARACTER_CTID
            }), new JdapiMetaProperty(JdapiTypes.MAXIMUM_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COLUMN_VALUE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.RecordGroup.class
        });
        jdapimetaobject = new JdapiMetaObject("RecordGroupColumn", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.RecordGroupColumn.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.ACCESS_KEY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CHECKED_VALUE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CANVAS_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COLUMN_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COPY_VALUE_FROM_ITEM_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DATA_SOURCE_BLOCK_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DATA_SOURCE_X_AXIS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DATA_SOURCE_Y_AXIS_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.EDIT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FORMAT_MASK_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FORMULA_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HELP_BOOK_TOPIC_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HIGHEST_ALLOWED_VALUE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.HINT_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.ICON_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.IMPLEMENTATION_CLASS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.INITIALIZE_VALUE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LABEL_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LOV_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LOWEST_ALLOWED_VALUE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NEXT_NAVIGATION_ITEM_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.OLE_CLASS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.OTHER_VALUES_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.POPUP_MENU_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_NAVIGATION_ITEM_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_FILL_PATTERN_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_VISUALATTRIBUTE_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.QUERY_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORD_GROUP_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUMMARY_BLOCK_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUMMARY_ITEM_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SYNCHRONIZED_ITEM_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TABPAGE_NAME_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.TOOLTIP_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TOOLTIP_VISUALATTRIBUTE_GROUP_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TREE_DATA_QUERY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.UNCHECKED_VALUE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.AUDIO_CHANNELS_PTID, true, true, new int[] {
                JdapiTypes.AUCH_AUTO_CTID, JdapiTypes.AUCH_MONO_CTID, JdapiTypes.AUCH_STEREO_CTID
            }), new JdapiMetaProperty(JdapiTypes.BEVEL_PTID, true, true, new int[] {
                JdapiTypes.BEST_RAISED_CTID, JdapiTypes.BEST_LOWERED_CTID, JdapiTypes.BEST_NONE_CTID, JdapiTypes.BEST_NSET_CTID, JdapiTypes.BEST_OUTSET_CTID, JdapiTypes.BEST_PLAIN_CTID
            }), new JdapiMetaProperty(JdapiTypes.CALCULATE_MODE_PTID, true, true, new int[] {
                JdapiTypes.CAMO_NONE_CTID, JdapiTypes.CAMO_FORMULA_CTID, JdapiTypes.CAMO_SUMMARY_CTID
            }), new JdapiMetaProperty(JdapiTypes.CASE_RESTRICTION_PTID, true, true, new int[] {
                JdapiTypes.CARS_MIXED_CTID, JdapiTypes.CARS_UPPER_CTID, JdapiTypes.CARS_LOWER_CTID
            }), new JdapiMetaProperty(JdapiTypes.CHECK_BOX_OTHER_VALUES_PTID, true, true, new int[] {
                JdapiTypes.CHECKBOX_ILLEGAL_CTID, JdapiTypes.CHECKBOX_CHECKED_CTID, JdapiTypes.CHECKBOX_UNCHECKED_CTID
            }), new JdapiMetaProperty(JdapiTypes.COMPRESSION_QUALITY_PTID, true, true, new int[] {
                JdapiTypes.CMQL_NONE_CTID, JdapiTypes.CMQL_MINIMUM_CTID, JdapiTypes.CMQL_LOW_CTID, JdapiTypes.CMQL_MED_CTID, JdapiTypes.CMQL_HIGH_CTID, JdapiTypes.CMQL_MAXIMUM_CTID
            }), new JdapiMetaProperty(JdapiTypes.COMM_MODE_PTID, true, true, new int[] {
                JdapiTypes.COMO_SYNCH_CTID, JdapiTypes.COMO_ASYNCH_CTID
            }), new JdapiMetaProperty(JdapiTypes.COMPRESS_PTID, true, true, new int[] {
                JdapiTypes.COMP_AUTO_CTID, JdapiTypes.COMP_OFF_CTID, JdapiTypes.COMP_ON_CTID
            }), new JdapiMetaProperty(JdapiTypes.DATA_TYPE_PTID, true, true, new int[] {
                JdapiTypes.DATY_CHARACTER_CTID, JdapiTypes.DATY_NUMBER_CTID, JdapiTypes.DATY_DATE_CTID, JdapiTypes.DATY_ALPHA_CTID, JdapiTypes.DATY_INTEGER_CTID, JdapiTypes.DATY_DATETIME_CTID, JdapiTypes.DATY_LONG_CTID, JdapiTypes.DATY_RNUMBER_CTID, JdapiTypes.DATY_JDATE_CTID, JdapiTypes.DATY_EDATE_CTID, 
                JdapiTypes.DATY_TIME_CTID, JdapiTypes.DATY_RINTEGER_CTID, JdapiTypes.DATY_MONEY_CTID, JdapiTypes.DATY_RMONEY_CTID, JdapiTypes.DATY_OBJECTREF_CTID
            }), new JdapiMetaProperty(JdapiTypes.DATA_LENGTH_SEMANTICS_PTID, true, true, new int[] {
                JdapiTypes.CHLE_NULL_CTID, JdapiTypes.CHLE_BYTE_CTID, JdapiTypes.CHLE_CHARACTER_CTID
            }), 
            new JdapiMetaProperty(JdapiTypes.DISPLAY_QUALITY_PTID, true, true, new int[] {
                JdapiTypes.DIQL_HIGH_CTID, JdapiTypes.DIQL_MEDIUM_CTID, JdapiTypes.DIQL_LOW_CTID
            }), new JdapiMetaProperty(JdapiTypes.DISTANCE_BETWEEN_RECORDS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.EDIT_X_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.EDIT_Y_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.EXECUTE_MODE_PTID, true, true, new int[] {
                JdapiTypes.EXMO_BATCH_CTID, JdapiTypes.EXMO_RUNTIME_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.HEIGHT_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.IMAGE_DEPTH_PTID, true, true, new int[] {
                JdapiTypes.IMDP_ORIG_CTID, JdapiTypes.IMDP_MONO_CTID, JdapiTypes.IMDP_GRAY_CTID, JdapiTypes.IMDP_LUT_CTID, JdapiTypes.IMDP_RGB_CTID
            }), new JdapiMetaProperty(JdapiTypes.IMAGE_FORMAT_PTID, true, true, new int[] {
                JdapiTypes.IMFM_BMP_CTID, JdapiTypes.IMFM_CALS_CTID, JdapiTypes.IMFM_GIF_CTID, JdapiTypes.IMFM_JFIF_CTID, JdapiTypes.IMFM_PICT_CTID, JdapiTypes.IMFM_RAS_CTID, JdapiTypes.IMFM_TIFF_CTID, JdapiTypes.IMFM_TPIC_CTID
            }), new JdapiMetaProperty(JdapiTypes.INITIALIZE_KEYBOARD_DIRECTION_PTID, true, true, new int[] {
                JdapiTypes.INKB_DEFAULT_CTID, JdapiTypes.INKB_ROMAN_CTID, JdapiTypes.INKB_NATIVE_CTID
            }), new JdapiMetaProperty(JdapiTypes.ITEM_TYPE_PTID, true, true, new int[] {
                JdapiTypes.ITTY_BA_CTID, JdapiTypes.ITTY_CA_CTID, JdapiTypes.ITTY_CB_CTID, JdapiTypes.ITTY_DI_CTID, JdapiTypes.ITTY_TREE_CTID, JdapiTypes.ITTY_IM_CTID, JdapiTypes.ITTY_LS_CTID, JdapiTypes.ITTY_PB_CTID, JdapiTypes.ITTY_RD_CTID, JdapiTypes.ITTY_TI_CTID, 
                JdapiTypes.ITTY_UA_CTID, JdapiTypes.ITTY_ACTION_CTID, JdapiTypes.ITTY_OLE_CTID, JdapiTypes.ITTY_SN_CTID, JdapiTypes.ITTY_VBX_CTID, JdapiTypes.ITTY_MAXIMUM_CTID
            }), new JdapiMetaProperty(JdapiTypes.ITEMS_DISPLAY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.JUSTIFICATION_PTID, true, true, new int[] {
                JdapiTypes.JUSTIFICATION_LEFT_CTID, JdapiTypes.JUSTIFICATION_RIGHT_CTID, JdapiTypes.JUSTIFICATION_CENTER_CTID, JdapiTypes.JUSTIFICATION_START_CTID, JdapiTypes.JUSTIFICATION_END_CTID
            }), new JdapiMetaProperty(JdapiTypes.KEYBOARD_STATE_PTID, true, true, new int[] {
                JdapiTypes.KBST_ANY_CTID, JdapiTypes.KBST_ROMAN_CTID, JdapiTypes.KBST_NATIVE_CTID
            }), new JdapiMetaProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, true, true, new int[] {
                JdapiTypes.LADI_DEFAULT_CTID, JdapiTypes.LADI_TORIGHT_CTID, JdapiTypes.LADI_TOLEFT_CTID
            }), new JdapiMetaProperty(JdapiTypes.LOV_X_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LOV_Y_POSITION_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.LIST_ELEMENT_COUNT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.LIST_STYLE_PTID, true, true, new int[] {
                JdapiTypes.LSST_POPLIST_CTID, JdapiTypes.LSST_TLIST_CTID, JdapiTypes.LSST_COMBO_CTID
            }), new JdapiMetaProperty(JdapiTypes.MAXIMUM_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.OLE_ACTION_STYLE_PTID, true, true, new int[] {
                JdapiTypes.OLAC_DOUBLECLICK_CTID, JdapiTypes.OLAC_MANUAL_CTID, JdapiTypes.OLAC_FOCUS_CTID
            }), new JdapiMetaProperty(JdapiTypes.OLE_POPUP_MENU_ITEMS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.OLE_RESIZ_STYLE_PTID, true, true, new int[] {
                JdapiTypes.OLRE_CLIP_CTID, JdapiTypes.OLRE_SCALE_CTID, JdapiTypes.OLRE_INITIAL_CTID, JdapiTypes.OLRE_DYNAMIC_CTID
            }), new JdapiMetaProperty(JdapiTypes.OLE_TENANTTYPE_ASPECT_PTID, true, true, new int[] {
                JdapiTypes.OLET_CONTENT_CTID, JdapiTypes.OLET_ICON_CTID, JdapiTypes.OLET_THUMBNAIL_CTID
            }), new JdapiMetaProperty(JdapiTypes.OLE_TENANTTYPE_TYPE_PTID, true, true, new int[] {
                JdapiTypes.OLTN_ANY_CTID, JdapiTypes.OLTN_NONE_CTID, JdapiTypes.OLTN_STATIC_CTID, JdapiTypes.OLTN_LINKED_CTID, JdapiTypes.OLTN_EMBEDDED_CTID, JdapiTypes.OLTN_CONTROL_CTID
            }), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_ALIGN_PTID, true, true, new int[] {
                JdapiTypes.ALIG_START_CTID, JdapiTypes.ALIG_END_CTID, JdapiTypes.ALIG_CENTER_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_ALIGN_OFFSET_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_ATTACHMENT_EDGE_PTID, true, true, new int[] {
                JdapiTypes.PRAT_START_CTID, JdapiTypes.PRAT_END_CTID, JdapiTypes.PRAT_TOP_CTID, JdapiTypes.PRAT_BOTTOM_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_ATTACHMENT_OFFSET_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_DISPLAY_STYLE_PTID, true, true, new int[] {
                JdapiTypes.PRDI_HIDDEN_CTID, JdapiTypes.PRDI_FIRST_CTID, JdapiTypes.PRDI_EACH_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), 
            new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_JUSTIFICATION_PTID, true, true, new int[] {
                JdapiTypes.HOJU_LEFT_CTID, JdapiTypes.HOJU_RIGHT_CTID, JdapiTypes.HOJU_CENTER_CTID, JdapiTypes.HOJU_START_CTID, JdapiTypes.HOJU_END_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_READING_ORDER_PTID, true, true, new int[] {
                JdapiTypes.READ_DEFAULT_CTID, JdapiTypes.READ_TORIGHT_CTID, JdapiTypes.READ_TOLEFT_CTID
            }), new JdapiMetaProperty(JdapiTypes.QUERY_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.READING_ORDER_PTID, true, true, new int[] {
                JdapiTypes.READ_DEFAULT_CTID, JdapiTypes.READ_TORIGHT_CTID, JdapiTypes.READ_TOLEFT_CTID
            }), new JdapiMetaProperty(JdapiTypes.SIZING_STYLE_PTID, true, true, new int[] {
                JdapiTypes.SIST_CROP_CTID, JdapiTypes.SIST_ADJUST_CTID
            }), new JdapiMetaProperty(JdapiTypes.SOUND_FORMAT_PTID, true, true, new int[] {
                JdapiTypes.SNFM_AU_CTID, JdapiTypes.SNFM_AIFF_CTID, JdapiTypes.SNFM_AIFF_C_CTID, JdapiTypes.SNFM_WAVE_CTID
            }), new JdapiMetaProperty(JdapiTypes.SOUND_QUALITY_PTID, true, true, new int[] {
                JdapiTypes.SNQL_AUTO_CTID, JdapiTypes.SNQL_HIGHEST_CTID, JdapiTypes.SNQL_HIGH_CTID, JdapiTypes.SNQL_MEDIUM_CTID, JdapiTypes.SNQL_LOW_CTID, JdapiTypes.SNQL_LOWEST_CTID
            }), new JdapiMetaProperty(JdapiTypes.SUMMARY_FUNCTION_PTID, true, true, new int[] {
                JdapiTypes.SUFU_NONE_CTID, JdapiTypes.SUFU_AVG_CTID, JdapiTypes.SUFU_COUNT_CTID, JdapiTypes.SUFU_MAXIMUM_CTID, JdapiTypes.SUFU_MINIMUM_CTID, JdapiTypes.SUFU_STDDEV_CTID, JdapiTypes.SUFU_SUM_CTID, JdapiTypes.SUFU_VAR_CTID
            }), new JdapiMetaProperty(JdapiTypes.WIDTH_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.WRAP_STYLE_PTID, true, true, new int[] {
                JdapiTypes.WRST_NONE_CTID, JdapiTypes.WRST_CHARACTER_CTID, JdapiTypes.WRST_WORD_CTID
            }), new JdapiMetaProperty(JdapiTypes.X_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.Y_POSITION_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.AUTO_HINT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.AUTO_SKIP_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CASE_INSENSITIVE_QUERY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.CONCEAL_DATA_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DATABASE_ITEM_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DEFAULT_BUTTON_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ENABLED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FIXED_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ICONIC_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.INSERT_ALLOWED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.KEYBOARD_NAVIGABLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.KEEP_CURSOR_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LOCK_RECORD_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MULTI_LINE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MOUSE_NAVIGATE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.OLE_IN_PLACE_ACTION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.OLE_INSIDE_OUT_SUPPORT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.OLE_SHOW_POPUP_MENU_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.OLE_SHOW_TENANTTYPE_TYPE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PRIMARY_KEY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.QUERY_ALLOWED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.QUERY_ONLY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RENDERED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.REQUIRED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_FAST_FORWARD_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_HORIZONTAL_SCROLLBAR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_PLAY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_RECORD_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_REWIND_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.SHOW_SLIDER_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_TIME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_VERTICAL_SCROLLBAR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SHOW_VOLUME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TREE_ALLOW_EMP_BRANCH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TREE_MULTI_SELECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TREE_SHOW_LINES_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TREE_SHOW_SYMBOL_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.UPDATE_ALLOWED_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.UPDATE_COMMIT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.UPDATE_IF_NULL_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.UPDATE_QUERY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VALIDATE_FROM_LIST_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISIBLE_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.CANVAS_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.EDIT_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LOV_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_NAVIGATION_ITEM_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.POPUP_MENU_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.POPUP_VISUALATTRIBUTE_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_NAVIGATION_ITEM_OBJECT_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PROMPT_VISUALATTRIBUTE_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORD_GROUP_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SYNCHRONIZED_ITEM_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TABPAGE_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.RADIO_BUTTON_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.TRIGGER_PTID, true, false, null)
        });
        aclass = (new Class[] {
            oracle.forms.jdapi.Block.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("Item", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Item.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROGRAMUNIT_TEXT_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROGRAMUNIT_TYPE_PTID, true, false, new int[] {
                JdapiTypes.PGTY_UNKNOWN_CTID, JdapiTypes.PGTY_PROCEDURE_CTID, JdapiTypes.PGTY_FUNCTION_CTID, JdapiTypes.PGTY_PACKAGESPEC_CTID, JdapiTypes.PGTY_PACKAGEBODY_CTID
            })
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.MenuModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("ProgramUnit", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.ProgramUnit.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_FOREGROUND_COLOR_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FRAME_TITLE_FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_TYPE_PTID, true, true, new int[] {
                JdapiTypes.VATY_COMMON_CTID, JdapiTypes.VATY_PROMPT_CTID, JdapiTypes.VATY_TITLE_CTID
            })
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.MenuModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("VisualAttribute", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.VisualAttribute.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.BOTTOM_TITLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUB_TITLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TITLE_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TEAR_OFF_MENU_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MENU_ITEM_PTID, true, false, null)
        });
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.MenuModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("Menu", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Menu.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.OLD_LOV_TEXT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.RECORD_GROUP_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TITLE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.HEIGHT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, true, true, new int[] {
                JdapiTypes.LADI_DEFAULT_CTID, JdapiTypes.LADI_TORIGHT_CTID, JdapiTypes.LADI_TOLEFT_CTID
            }), new JdapiMetaProperty(JdapiTypes.LIST_TYPE_PTID, true, true, new int[] {
                JdapiTypes.LSTY_RECORDGROUP_CTID, JdapiTypes.LSTY_OLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.X_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.Y_POSITION_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.AUTO_COLUMN_WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.AUTO_DISPLAY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.AUTO_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.AUTO_REFRESH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.AUTO_SKIP_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.AUTO_SELECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILTER_BEFORE_DISPLAY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.RECORD_GROUP_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COLUMN_MAP_PTID, true, false, null)
        });
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("LOV", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.LOV.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LABEL_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.OBJECT_COUNT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        });
        ajdapimetaproperty4 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.JDAPI_OLT_OBJECTS_PTID, true, false, null)
        });
        aclass = (new Class[] {
            oracle.forms.jdapi.ObjectLibrary.class
        });
        jdapimetaobject = new JdapiMetaObject("ObjectLibraryTab", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.ObjectLibraryTab.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LIBRARY_LOCATION_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, false, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.LIBRARY_SOURCE_PTID, true, false, new int[] {
                JdapiTypes.LISR_FS_CTID, JdapiTypes.LISR_DATABASE_CTID
            }), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = new JdapiMetaProperty[0];
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.MenuModule.class
        });
        jdapimetaobject = new JdapiMetaObject("AttachedLibrary", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.AttachedLibrary.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OBJECT_GROUP_CHILD_REAL_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.ObjectGroup.class
        });
        jdapimetaobject = new JdapiMetaObject("ObjectGroupChild", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.ObjectGroupChild.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARAMETER_INITIALIZE_VALUE_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARAMETER_DATA_TYPE_PTID, true, true, new int[] {
                JdapiTypes.PADA_CHARACTER_CTID, JdapiTypes.PADA_NUMBER_CTID, JdapiTypes.PADA_DATE_CTID
            }), new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.FormModule.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("ModuleParameter", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.ModuleParameter.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.TEXT_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            })
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.CompoundText.class
        });
        jdapimetaobject = new JdapiMetaObject("TextSegment", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.TextSegment.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.ACCESS_KEY_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.COMMENT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.LABEL_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILENAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_FILEPATH_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PARENT_MODULE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_BACK_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_FILL_PATTERN_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_NAME_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_FOREGROUND_COLOR_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_VISUALATTRIBUTE_NAME_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.RADIOBUTTON_VALUE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DISTANCE_BETWEEN_RECORDS_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), new JdapiMetaProperty(JdapiTypes.HEIGHT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_MODULETYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_TYPE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PARENT_TYPE_PTID, true, true, null), 
            new JdapiMetaProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_ALIGN_PTID, true, true, new int[] {
                JdapiTypes.ALIG_START_CTID, JdapiTypes.ALIG_END_CTID, JdapiTypes.ALIG_CENTER_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_ALIGN_OFFSET_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_ATTACHMENT_EDGE_PTID, true, true, new int[] {
                JdapiTypes.PRAT_START_CTID, JdapiTypes.PRAT_END_CTID, JdapiTypes.PRAT_TOP_CTID, JdapiTypes.PRAT_BOTTOM_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_ATTACHMENT_OFFSET_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_DISPLAY_STYLE_PTID, true, true, new int[] {
                JdapiTypes.PRDI_HIDDEN_CTID, JdapiTypes.PRDI_FIRST_CTID, JdapiTypes.PRDI_EACH_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            }), 
            new JdapiMetaProperty(JdapiTypes.PROMPT_JUSTIFICATION_PTID, true, true, new int[] {
                JdapiTypes.HOJU_LEFT_CTID, JdapiTypes.HOJU_RIGHT_CTID, JdapiTypes.HOJU_CENTER_CTID, JdapiTypes.HOJU_START_CTID, JdapiTypes.HOJU_END_CTID
            }), new JdapiMetaProperty(JdapiTypes.PROMPT_READING_ORDER_PTID, true, true, new int[] {
                JdapiTypes.READ_DEFAULT_CTID, JdapiTypes.READ_TORIGHT_CTID, JdapiTypes.READ_TOLEFT_CTID
            }), new JdapiMetaProperty(JdapiTypes.WIDTH_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.X_POSITION_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.Y_POSITION_PTID, true, true, null)
        });
        ajdapimetaproperty2 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.DIRTY_INFO_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.ENABLED_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.VISIBLE_PTID, true, true, null)
        });
        ajdapimetaproperty3 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.MODULE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.NEXT_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.OWNER_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PREVIOUS_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.PROMPT_VISUALATTRIBUTE_OBJECT_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.SOURCE_PTID, true, false, null), new JdapiMetaProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, true, true, null)
        });
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = (new Class[] {
            oracle.forms.jdapi.Item.class, oracle.forms.jdapi.ObjectLibraryTab.class
        });
        jdapimetaobject = new JdapiMetaObject("RadioButton", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.RadioButton.class, jdapimetaobject);
        ajdapimetaproperty = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.FONT_NAME_PTID, true, true, null)
        });
        ajdapimetaproperty1 = (new JdapiMetaProperty[] {
            new JdapiMetaProperty(JdapiTypes.FONT_SIZE_PTID, true, true, null), new JdapiMetaProperty(JdapiTypes.FONT_SPACING_PTID, true, true, new int[] {
                JdapiTypes.FOSP_ULTRADENSE_CTID, JdapiTypes.FOSP_EXTRADENSE_CTID, JdapiTypes.FOSP_DENSE_CTID, JdapiTypes.FOSP_SEMIDENSE_CTID, JdapiTypes.FOSP_NORMAL_CTID, JdapiTypes.FOSP_SEMIEXPAND_CTID, JdapiTypes.FOSP_EXPAND_CTID, JdapiTypes.FOSP_EXTRAEXPAND_CTID, JdapiTypes.FOSP_ULTRAEXPAND_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_STYLE_PTID, true, true, new int[] {
                JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
            }), new JdapiMetaProperty(JdapiTypes.FONT_WEIGHT_PTID, true, true, new int[] {
                JdapiTypes.FOWG_ULTRALIGHT_CTID, JdapiTypes.FOWG_EXTRALIGHT_CTID, JdapiTypes.FOWG_LIGHT_CTID, JdapiTypes.FOWG_DEMILIGHT_CTID, JdapiTypes.FOWG_MEDIUM_CTID, JdapiTypes.FOWG_DEMIBOLD_CTID, JdapiTypes.FOWG_BOLD_CTID, JdapiTypes.FOWG_EXTRABOLD_CTID, JdapiTypes.FOWG_ULTRABOLD_CTID
            })
        });
        ajdapimetaproperty2 = new JdapiMetaProperty[0];
        ajdapimetaproperty3 = new JdapiMetaProperty[0];
        ajdapimetaproperty4 = new JdapiMetaProperty[0];
        aclass = new Class[0];
        jdapimetaobject = new JdapiMetaObject("Font", ajdapimetaproperty, ajdapimetaproperty2, ajdapimetaproperty1, ajdapimetaproperty3, ajdapimetaproperty4, aclass);
        s_classes.put(oracle.forms.jdapi.Font.class, jdapimetaobject);
    }
}
