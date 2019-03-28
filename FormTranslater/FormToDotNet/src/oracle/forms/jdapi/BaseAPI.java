// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiException, BaseFormsObject, JdapiTypes, FormModule, 
//            MenuModule, ObjectLibrary, PlsqlModule

final class BaseAPI
{

    BaseAPI()
    {
    }

    public static Class getClass(long l)
    {
        return (Class)m_d2ffoxClassMap.get(new Long(l));
    }

    protected static Constructor getInternalConstructor(Class class1)
        throws NoSuchMethodException
    {
        Constructor constructor = (Constructor)m_constructorMap.get(class1);
        if(constructor == null)
        {
            Class aclass[] = {
                Long.TYPE
            };
            constructor = class1.getDeclaredConstructor(aclass);
            m_constructorMap.put(class1, constructor);
        }
        return constructor;
    }

    protected static BaseFormsObject createObject(long l, long l1)
    {
        long l2 = _jni_query_type(l, l1);
        return createObject(l2, l, l1);
    }

    protected static BaseFormsObject createObject(long l, long l1, long l2)
    {
        Class class1 = getClass(l);
        if(class1 == null)
            return null;
        Constructor constructor = null;
        try
        {
            constructor = getInternalConstructor(class1);
        }
        catch(NoSuchMethodException nosuchmethodexception)
        {
            throw new JdapiException("Internal constructor not found for" + class1.getName());
        }
        return createObject(constructor, l1, l2);
    }

    protected static BaseFormsObject createObject(Constructor constructor, long l, long l1)
    {
        BaseFormsObject baseformsobject = null;
        Object aobj[] = {
            new Long(l1)
        };
        try
        {
            baseformsobject = (BaseFormsObject)constructor.newInstance(aobj);
        }
        catch(InvocationTargetException invocationtargetexception)
        {
            throw new JdapiException("Failed to create new instance of " + constructor.getDeclaringClass().getName());
        }
        catch(InstantiationException instantiationexception)
        {
            throw new JdapiException("Failed to create new instance of " + constructor.getDeclaringClass().getName());
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            throw new JdapiException("Failed to create new instance of " + constructor.getDeclaringClass().getName());
        }
        return baseformsobject;
    }

    public static String pointerToString(long l)
    {
        StringBuffer stringbuffer;
        for(stringbuffer = new StringBuffer(Long.toHexString(l).toUpperCase()); stringbuffer.length() < 8; stringbuffer.insert(0, '0'));
        stringbuffer.insert(0, "0x");
        return stringbuffer.toString();
    }

    public static void setSubclassFlag(boolean flag)
    {
        _jni_set_subclass_flag(flag);
    }

    private static native void _jni_set_subclass_flag(boolean flag);

    public static boolean isSubclassFlagSet()
    {
        return _jni_get_subclass_flag();
    }

    private static native boolean _jni_get_subclass_flag();

    public static void setFailSubclassLoad(boolean flag)
    {
        _jni_set_subclass_load_flag(flag);
    }

    private static native void _jni_set_subclass_load_flag(boolean flag);

    public static boolean isFailSubclassLoad()
    {
        return _jni_get_subclass_load_flag();
    }

    private static native boolean _jni_get_subclass_load_flag();

    public static void setFailLibraryLoad(boolean flag)
    {
        _jni_set_library_load_flag(flag);
    }

    private static native void _jni_set_library_load_flag(boolean flag);

    public static boolean isFailLibraryLoad()
    {
        return _jni_get_library_load_flag();
    }

    private static native boolean _jni_get_library_load_flag();

    protected static native boolean _jni_get_bool_prop(long l, long l1, int i);

    protected static native String _jni_get_text_prop(long l, long l1, int i);

    protected static native int _jni_get_num_prop(long l, long l1, int i);

    protected static native long _jni_get_obj_prop(long l, long l1, int i);

    protected static native void _jni_set_bool_prop(long l, long l1, int i, boolean flag);

    protected static native void _jni_set_text_prop(long l, long l1, int i, String s);

    protected static native void _jni_set_num_prop(long l, long l1, int i, int j);

    protected static native void _jni_set_obj_prop(long l, long l1, int i, long l2);

    protected static native boolean _jni_has_prop(long l, long l1, int i);

    protected static native void _jni_inherit_prop(long l, long l1, int i);

    protected static native boolean _jni_is_prop_inherited(long l, long l1, int i);

    protected static native boolean _jni_is_subclassed(long l, long l1);

    protected static native void _jni_set_subclass_parent(long l, long l1, long l2);

    protected static native int _jni_query_type(long l, long l1);

    protected static native boolean _jni_is_prop_default(long l, long l1, int i);

    protected static native long _jni_create_object(long l, long l1, int i, String s, long l2, 
            long l3);

    protected static native void _jni_destroy(long l, long l1);

    protected static native void _jni_move(long l, long l1, long l2);

    protected static native long _jni_find_obj(long l, long l1, String s, int i);

    protected static native long _jni_replicate(long l, long l1, long l2, String s);

    protected static native void _jni_reattach(long l, long l1);

    protected static native int _jni_get_prop_type(long l, int i);

    protected static native String _jni_get_prop_name(long l, int i);

    protected static native int _jni_get_prop_value_value(long l, int i, String s);

    protected static native String _jni_get_prop_value_name(long l, int i, int j);

    protected static native int _jni_get_prop_const_value(long l, String s);

    protected static native String _jni_get_prop_const_name(long l, int i);

    protected static native long _jni_initialize(boolean flag, boolean flag1, boolean flag2);

    protected static native void _jni_finalize(long l);

    protected static native void _jni_connect(long l, String s);

    protected static native void _jni_disconnect(long l);

    protected static native FormModule _jni_load_form(long l, String s, String s1);

    protected static native MenuModule _jni_load_menu(long l, String s, String s1);

    protected static native ObjectLibrary _jni_load_objlib(long l, String s, String s1);

    protected static native void _jni_save_form(long l, long l1, String s);

    protected static native void _jni_save_menu(long l, long l1, String s);

    protected static native void _jni_save_objlib(long l, long l1, String s);

    protected static native int _jni_builder_version(long l);

    protected static native void _jni_compile_form(long l, long l1);

    protected static native void _jni_compile_menu(long l, long l1);

    protected static native int _jni_get_form_version(long l, String s);

    protected static native int _jni_get_menu_version(long l, String s);

    protected static native int _jni_get_objlib_version(long l, String s);

    protected static native void _jni_remove_obj(long l, long l1, long l2);

    protected static native long _jni_add_obj(long l, long l1, long l2, long l3, 
            boolean flag);

    protected static native long _jni_find_obj_by_pos(long l, long l1, int i);

    protected static native long _jni_find_olt_obj_by_pos(long l, long l1, int i);

    protected static native void _jni_set_smart_class(long l, long l1, long l2, boolean flag);

    protected static native boolean _jni_is_smart_class(long l, long l1, long l2);

    protected static native void _jni_set_desc(long l, long l1, long l2, String s);

    protected static native String _jni_get_desc(long l, long l1, long l2);

    protected static native String _jni_obj_tabname(long l, long l1, long l2);

    protected static native byte[] _jni_get_persist_client_info(long l, long l1);

    protected static native void _jni_set_persist_client_info(long l, long l1, byte abyte0[]);

    protected static native Hashtable _jni_get_built_ins(long l);

    protected static native PlsqlModule _jni_load_plsqllib(long l, String s, String s1);

    protected static native int[] _jni_string_size(long l, String s, long l1, long l2);

    protected static native int[] _jni_char_size(long l, int i, int j, long l1, long l2);

    protected static native void _jni_coord_extract(long l, long l1, long l2);

    protected static native void _jni_coord_apply(long l, long l1, long l2);

    protected static native void _jni_font_extract(long l, long l1, long l2, int i);

    protected static native void _jni_font_apply(long l, long l1, long l2, int i);

    protected static native void _jni_gra_export_image(long l, long l1, String s);

    protected static native void _jni_gra_import_image(long l, long l1, String s, int i);

    protected static native long _jni_attach_lib(long l, long l1, boolean flag, String s);

    protected static native void _jni_detach_lib(long l, long l1);

    protected static native void _jni_rcg_qry_noparse(long l, long l1, String s);

    protected static native void _jni_itm_insert_element(long l, long l1, int i, String s, String s1);

    protected static native void _jni_itm_delete_element(long l, long l1, int i);

    protected static native String _jni_itm_get_element_label(long l, long l1, int i);

    protected static native String _jni_itm_get_element_value(long l, long l1, int i);

    protected static native void _jni_rcs_insert_row(long l, long l1, int i, String s, String s1);

    protected static native void _jni_rcs_delete_row(long l, long l1, int i);

    protected static native String _jni_rcs_get_row(long l, long l1, int i);

    protected static native void _jni_mmd_add_role(long l, long l1, int i, String s);

    protected static native void _jni_mmd_remove_role(long l, long l1, int i);

    protected static native String _jni_mmd_get_role(long l, long l1, int i);

    protected static native void _jni_mni_add_role(long l, long l1, int i, String s);

    protected static native void _jni_mni_remove_role(long l, long l1, int i);

    protected static native String _jni_mni_get_role(long l, long l1, int i);

    protected static native Vector _jni_trn_get_translations(long l, long l1);

    protected static native Object[] _jni_trn_get_module_translations(long l, long l1);

    protected static native int _jni_trn_add_translation(long l, long l1, String s, int i);

    protected static native void _jni_trn_del_translation(long l, long l1, int i);

    protected static native int _jni_trn_string_count(long l, long l1);

    protected static native boolean _jni_trn_string_in_use(long l, long l1, int i);

    protected static native String _jni_trn_get_string(long l, long l1, int i, int j);

    protected static native void _jni_trn_set_string(long l, long l1, int i, int j, String s);

    protected static native int[] _jni_trn_get_string_info(long l, long l1, int i);

    protected static native void _jni_trn_wrap_translated_text(long l, long l1, int i);

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

    private static final Hashtable m_d2ffoxClassMap;
    private static final Hashtable m_constructorMap = new Hashtable();

    static 
    {
        m_d2ffoxClassMap = new Hashtable();
        m_d2ffoxClassMap.put(new Long(JdapiTypes.MENU_MODULE_OTID), oracle.forms.jdapi.MenuModule.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.EDITOR_OTID), oracle.forms.jdapi.Editor.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.ALERT_OTID), oracle.forms.jdapi.Alert.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.FORM_MODULE_OTID), oracle.forms.jdapi.FormModule.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.COORDINATE_OTID), oracle.forms.jdapi.Coordinate.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.TAB_PAGE_OTID), oracle.forms.jdapi.TabPage.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.PROPERTY_CLASS_OTID), oracle.forms.jdapi.PropertyClass.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.DATA_SOURCE_ARGUMENT_OTID), oracle.forms.jdapi.DataSourceArgument.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.DATA_SOURCE_COLUMN_OTID), oracle.forms.jdapi.DataSourceColumn.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.COMPOUNDTEXT_OTID), oracle.forms.jdapi.CompoundText.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.LV_COLMAP_OTID), oracle.forms.jdapi.LOVColumnMapping.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.LIBRARY_MODULE_OTID), oracle.forms.jdapi.PlsqlModule.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.OBJECT_GROUP_OTID), oracle.forms.jdapi.ObjectGroup.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.GRAPHIC_OTID), oracle.forms.jdapi.Graphics.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.CANVAS_OTID), oracle.forms.jdapi.Canvas.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.VISUAL_STATE_OTID), oracle.forms.jdapi.VisualState.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.POINT_OTID), oracle.forms.jdapi.Point.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.RECORD_GROUP_OTID), oracle.forms.jdapi.RecordGroup.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.WINDOW_OTID), oracle.forms.jdapi.Window.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.OBJECT_LIBRARY_OTID), oracle.forms.jdapi.ObjectLibrary.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.TRIGGER_OTID), oracle.forms.jdapi.Trigger.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.BLOCK_OTID), oracle.forms.jdapi.Block.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.REPORT_OTID), oracle.forms.jdapi.Report.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.RELATION_OTID), oracle.forms.jdapi.Relation.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.MENU_ITEM_OTID), oracle.forms.jdapi.MenuItem.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.RECORDGROUP_COLUMNSPECIFICATION_OTID), oracle.forms.jdapi.RecordGroupColumn.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.ITEM_OTID), oracle.forms.jdapi.Item.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.PROGRAM_UNIT_OTID), oracle.forms.jdapi.ProgramUnit.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.VISUAL_ATTRIBUTE_OTID), oracle.forms.jdapi.VisualAttribute.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.MENU_OTID), oracle.forms.jdapi.Menu.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.LOV_OTID), oracle.forms.jdapi.LOV.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.OBJECT_LIBRARY_TAB_OTID), oracle.forms.jdapi.ObjectLibraryTab.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.ATTACHMENT_LIBRARY_OTID), oracle.forms.jdapi.AttachedLibrary.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.OBJECTGROUP_CHILD_OTID), oracle.forms.jdapi.ObjectGroupChild.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.FORM_PARAMETER_OTID), oracle.forms.jdapi.ModuleParameter.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.TEXT_SEGMENT_OTID), oracle.forms.jdapi.TextSegment.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.RADIO_BUTTON_OTID), oracle.forms.jdapi.RadioButton.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.FONT_OTID), oracle.forms.jdapi.Font.class);
        m_d2ffoxClassMap.put(new Long(JdapiTypes.LIBRARY_PROGRAM_UNIT_OTID), oracle.forms.jdapi.ProgramUnit.class);
    }
}
