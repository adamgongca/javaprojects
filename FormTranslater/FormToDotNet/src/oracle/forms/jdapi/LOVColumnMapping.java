// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            LOV, PropertyClass

public class LOVColumnMapping extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public LOVColumnMapping(LOV lov, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), lov.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public LOVColumnMapping(LOV lov, String s, LOVColumnMapping lovcolumnmapping)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), lov.getObjectPointer(), s_foType, s, 0L, lovcolumnmapping.getObjectPointer());
        Jdapi.addObject(this);
    }

    public LOVColumnMapping(LOV lov, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), lov.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected LOVColumnMapping(long l)
    {
        super(l);
    }

    public LOVColumnMapping clone(LOV lov, String s)
    {
        return (LOVColumnMapping)super.clone(lov, s);
    }

    public static LOVColumnMapping find(LOV lov, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), lov.getObjectPointer(), s, s_foType);
        LOVColumnMapping lovcolumnmapping = null;
        if(l1 != 0L)
            lovcolumnmapping = (LOVColumnMapping)Jdapi.getObject(l1);
        return lovcolumnmapping;
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
    }

    public String getReturnItem()
    {
        return getStringProperty(JdapiTypes.RETURN_ITEM_PTID);
    }

    public void setReturnItem(String s)
    {
        setStringProperty(JdapiTypes.RETURN_ITEM_PTID, s);
    }

    public String getTitle()
    {
        return getStringProperty(JdapiTypes.TITLE_PTID);
    }

    public void setTitle(String s)
    {
        setStringProperty(JdapiTypes.TITLE_PTID, s);
    }

    public int getDisplayWidth()
    {
        return getIntegerProperty(JdapiTypes.DISPLAY_WIDTH_PTID);
    }

    public void setDisplayWidth(int i)
    {
        setIntegerProperty(JdapiTypes.DISPLAY_WIDTH_PTID, i);
    }

    public int getPersistentClientInfoLength()
    {
        return getIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID);
    }

    public void setPersistentClientInfoLength(int i)
    {
        setIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, i);
    }

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.LV_COLMAP_OTID;
    }
}
