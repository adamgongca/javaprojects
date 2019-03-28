// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            Graphics, PropertyClass

public class Point extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public Point(Graphics g, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), g.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Point(Graphics g, String s, Point point)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), g.getObjectPointer(), s_foType, s, 0L, point.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Point(Graphics g, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), g.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected Point(long l)
    {
        super(l);
    }

    public Point clone(Graphics g, String s)
    {
        return (Point)super.clone(g, s);
    }

    public static Point find(Graphics g, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), g.getObjectPointer(), s, s_foType);
        Point point = null;
        if(l1 != 0L)
            point = (Point)Jdapi.getObject(l1);
        return point;
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
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
        s_foType = JdapiTypes.POINT_OTID;
    }
}
