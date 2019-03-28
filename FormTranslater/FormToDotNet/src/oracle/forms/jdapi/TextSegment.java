// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            CompoundText, PropertyClass

public class TextSegment extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public TextSegment(CompoundText compoundtext, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), compoundtext.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public TextSegment(CompoundText compoundtext, String s, TextSegment textsegment)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), compoundtext.getObjectPointer(), s_foType, s, 0L, textsegment.getObjectPointer());
        Jdapi.addObject(this);
    }

    public TextSegment(CompoundText compoundtext, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), compoundtext.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected TextSegment(long l)
    {
        super(l);
    }

    public TextSegment clone(CompoundText compoundtext, String s)
    {
        return (TextSegment)super.clone(compoundtext, s);
    }

    public static TextSegment find(CompoundText compoundtext, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), compoundtext.getObjectPointer(), s, s_foType);
        TextSegment textsegment = null;
        if(l1 != 0L)
            textsegment = (TextSegment)Jdapi.getObject(l1);
        return textsegment;
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

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
    }

    public String getText()
    {
        return getStringProperty(JdapiTypes.TEXT_PTID);
    }

    public void setText(String s)
    {
        setStringProperty(JdapiTypes.TEXT_PTID, s);
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

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
    }

    public boolean isSubclassSubObject()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID);
    }

    public void setSubclassSubObject(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, flag);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.TEXT_SEGMENT_OTID;
    }
}
