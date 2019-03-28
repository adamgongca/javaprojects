// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            JdapiTypes, Jdapi, BaseAPI, PropertyMap

public class JdapiMetaProperty
{

    JdapiMetaProperty(int i, boolean flag, boolean flag1, int ai[])
    {
        m_allowedValues = null;
        m_propId = i;
        m_allowGet = flag;
        m_allowSet = flag1;
        m_allowedValues = ai;
    }

    public int getPropertyId()
    {
        return m_propId;
    }

    public boolean allowGet()
    {
        return m_allowGet;
    }

    public boolean allowSet()
    {
        return m_allowSet;
    }

    public int[] getAllowedValues()
    {
        return m_allowedValues;
    }

    public String getPropertyName()
    {
        return getPropertyName(m_propId);
    }

    public Class getPropertyType()
    {
        return getPropertyType(m_propId);
    }

    public String getPropertyDescription()
    {
        return getPropertyDescription(m_propId);
    }

    public static Class getPropertyType(int i)
    {
        Class class1 = null;
        if(i == JdapiTypes.JDAPI_OLB_OBJECTS_PTID)
            class1 = oracle.forms.jdapi.JdapiObject.class;
        else
        if(i == JdapiTypes.JDAPI_OLT_OBJECTS_PTID)
        {
            class1 = oracle.forms.jdapi.JdapiObject.class;
        } else
        {
            int j = BaseAPI._jni_get_prop_type(Jdapi.getContextPointer(), i);
            if(j == JdapiTypes.TYP_BOOLEAN_PTID)
                class1 = java.lang.Boolean.class;
            else
            if(j == JdapiTypes.TYP_NUMBER_PTID)
                class1 = java.lang.Integer.class;
            else
            if(j == JdapiTypes.TYP_TEXT_PTID)
                class1 = java.lang.String.class;
            else
            if(j == JdapiTypes.TYP_OBJECT_PTID)
                class1 = oracle.forms.jdapi.JdapiObject.class;
        }
        return class1;
    }

    public static String getPropertyDescription(int i)
    {
        if(i == JdapiTypes.JDAPI_OLB_OBJECTS_PTID)
            return "Library Objects";
        if(i == JdapiTypes.JDAPI_OLT_OBJECTS_PTID)
            return "Tab Objects";
        else
            return BaseAPI._jni_get_prop_name(Jdapi.getContextPointer(), i);
    }

    public static String getPropertyName(int i)
    {
        return PropertyMap.getFormattedPropertyName(i);
    }

    public static int getPropertyId(String s)
    {
        return PropertyMap.getFormattedPropertyId(s);
    }

    public static int[] getAllowedValues(int i)
    {
        return PropertyMap.getAllowedValues(i);
    }

    public static String getPropertyValueName(int i, int j)
    {
        return BaseAPI._jni_get_prop_value_name(Jdapi.getContextPointer(), i, j);
    }

    public static int getPropertyValueValue(int i, String s)
    {
        return BaseAPI._jni_get_prop_value_value(Jdapi.getContextPointer(), i, s);
    }

    public static int getPropertyConstantValue(String s)
    {
        if(s.equals("JDAPI_OLB_OBJECTS"))
            return JdapiTypes.JDAPI_OLB_OBJECTS_PTID;
        if(s.equals("JDAPI_OLT_OBJECTS"))
            return JdapiTypes.JDAPI_OLT_OBJECTS_PTID;
        else
            return BaseAPI._jni_get_prop_const_value(Jdapi.getContextPointer(), s);
    }

    public static String getPropertyConstantName(int i)
    {
        if(i == JdapiTypes.JDAPI_OLB_OBJECTS_PTID)
            return "JDAPI_OLB_OBJECTS";
        if(i == JdapiTypes.JDAPI_OLT_OBJECTS_PTID)
            return "JDAPI_OLT_OBJECTS";
        else
            return BaseAPI._jni_get_prop_const_name(Jdapi.getContextPointer(), i);
    }

    private int m_propId;
    private boolean m_allowGet;
    private boolean m_allowSet;
    private int m_allowedValues[];
}
