// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            FormModule, Font

public class Coordinate extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    protected Coordinate(long l)
    {
        super(l);
    }

    public Coordinate clone(FormModule formmodule, String s)
    {
        return (Coordinate)super.clone(formmodule, s);
    }

    public static Coordinate find(FormModule formmodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s, s_foType);
        Coordinate coordinate = null;
        if(l1 != 0L)
            coordinate = (Coordinate)Jdapi.getObject(l1);
        return coordinate;
    }

    public Coordinate(FormModule formmodule)
    {
        super(Jdapi.getContextPointer());
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), 0L, s_foType, "", 0L, 0L);
        Jdapi.addObject(this);
        extract(formmodule);
    }

    public void apply(FormModule formmodule)
    {
        BaseAPI._jni_coord_apply(Jdapi.getContextPointer(), super.m_pd2fob, formmodule.getObjectPointer());
    }

    public void extract(FormModule formmodule)
    {
        BaseAPI._jni_coord_extract(Jdapi.getContextPointer(), super.m_pd2fob, formmodule.getObjectPointer());
    }

    public int[] stringSize(String s, Font font)
    {
        return BaseAPI._jni_string_size(Jdapi.getContextPointer(), s, font.getObjectPointer(), super.m_pd2fob);
    }

    public int[] charSize(int i, int j, Font font)
    {
        return BaseAPI._jni_char_size(Jdapi.getContextPointer(), i, j, font.getObjectPointer(), super.m_pd2fob);
    }

    public int getCharacterCellHeight()
    {
        return getIntegerProperty(JdapiTypes.CHARACTER_CELL_HEIGHT_PTID);
    }

    public void setCharacterCellHeight(int i)
    {
        setIntegerProperty(JdapiTypes.CHARACTER_CELL_HEIGHT_PTID, i);
    }

    public int getCharacterCellWidth()
    {
        return getIntegerProperty(JdapiTypes.CHARACTER_CELL_WIDTH_PTID);
    }

    public void setCharacterCellWidth(int i)
    {
        setIntegerProperty(JdapiTypes.CHARACTER_CELL_WIDTH_PTID, i);
    }

    public int getCoordinateSystem()
    {
        return getIntegerProperty(JdapiTypes.COORDINATE_SYSTEM_PTID);
    }

    public void setCoordinateSystem(int i)
    {
        setIntegerProperty(JdapiTypes.COORDINATE_SYSTEM_PTID, i);
    }

    public int getRealUnit()
    {
        return getIntegerProperty(JdapiTypes.REAL_UNIT_PTID);
    }

    public void setRealUnit(int i)
    {
        setIntegerProperty(JdapiTypes.REAL_UNIT_PTID, i);
    }

    public boolean isDefaultFontScaling()
    {
        return getBooleanProperty(JdapiTypes.DEFAULT_FONT_SCALING_PTID);
    }

    public void setDefaultFontScaling(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DEFAULT_FONT_SCALING_PTID, flag);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.COORDINATE_OTID;
    }
}
