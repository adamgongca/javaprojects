// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, JdapiException, JdapiObjectListIterator, Jdapi, 
//            BaseAPI, JdapiTypes, Graphics, PropertyClass, 
//            JdapiIterator

public class CompoundText extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public CompoundText(Graphics g, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), g.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public CompoundText(Graphics g, String s, CompoundText compoundtext)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), g.getObjectPointer(), s_foType, s, 0L, compoundtext.getObjectPointer());
        Jdapi.addObject(this);
    }

    public CompoundText(Graphics g, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), g.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected CompoundText(long l)
    {
        super(l);
    }

    public CompoundText clone(Graphics g, String s)
    {
        return (CompoundText)super.clone(g, s);
    }

    public static CompoundText find(Graphics g, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), g.getObjectPointer(), s, s_foType);
        CompoundText compoundtext = null;
        if(l1 != 0L)
            compoundtext = (CompoundText)Jdapi.getObject(l1);
        return compoundtext;
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
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

    public JdapiIterator getTextSegments()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.TEXT_SEGMENT_PTID, JdapiTypes.TEXT_SEGMENT_OTID);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.COMPOUNDTEXT_OTID;
    }
}
