// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            JdapiObject

public class Font extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public Font(String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), Jdapi.getContextPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    protected Font(long l)
    {
        super(l);
    }

    public Font clone(String s)
    {
        return (Font)super.clone(null, s);
    }

    public static Font find(String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), Jdapi.getContextPointer(), s, s_foType);
        Font font = null;
        if(l1 != 0L)
            font = (Font)Jdapi.getObject(l1);
        return font;
    }

    public void apply(JdapiObject jdapiobject, int i)
    {
        BaseAPI._jni_font_apply(Jdapi.getContextPointer(), super.m_pd2fob, ((BaseFormsObject)jdapiobject).getObjectPointer(), i);
    }

    public void extract(JdapiObject jdapiobject, int i)
    {
        BaseAPI._jni_font_extract(Jdapi.getContextPointer(), super.m_pd2fob, ((BaseFormsObject)jdapiobject).getObjectPointer(), i);
    }

    public String getFontName()
    {
        return getStringProperty(JdapiTypes.FONT_NAME_PTID);
    }

    public void setFontName(String s)
    {
        setStringProperty(JdapiTypes.FONT_NAME_PTID, s);
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

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.FONT_OTID;
    }
}
