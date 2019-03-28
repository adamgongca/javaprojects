// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            FormModule, MenuModule

public class AttachedLibrary extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    protected AttachedLibrary(long l)
    {
        super(l);
    }

    public AttachedLibrary clone(FormModule formmodule, String s)
    {
        return (AttachedLibrary)super.clone(formmodule, s);
    }

    public AttachedLibrary clone(MenuModule menumodule, String s)
    {
        return (AttachedLibrary)super.clone(menumodule, s);
    }

    public static AttachedLibrary find(FormModule formmodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s, s_foType);
        AttachedLibrary attachedlibrary = null;
        if(l1 != 0L)
            attachedlibrary = (AttachedLibrary)Jdapi.getObject(l1);
        return attachedlibrary;
    }

    public static AttachedLibrary find(MenuModule menumodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), menumodule.getObjectPointer(), s, s_foType);
        AttachedLibrary attachedlibrary = null;
        if(l1 != 0L)
            attachedlibrary = (AttachedLibrary)Jdapi.getObject(l1);
        return attachedlibrary;
    }

    public AttachedLibrary(FormModule formmodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_attach_lib(Jdapi.getContextPointer(), formmodule.getObjectPointer(), false, s);
        Jdapi.addObject(this);
    }

    public AttachedLibrary(MenuModule menumodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_attach_lib(Jdapi.getContextPointer(), menumodule.getObjectPointer(), false, s);
        Jdapi.addObject(this);
    }

    public void detach()
    {
        BaseAPI._jni_detach_lib(Jdapi.getContextPointer(), super.m_pd2fob);
        destroy();
    }

    public String getComment()
    {
        return getStringProperty(JdapiTypes.COMMENT_PTID);
    }

    public void setComment(String s)
    {
        setStringProperty(JdapiTypes.COMMENT_PTID, s);
    }

    public String getLibraryLocation()
    {
        return getStringProperty(JdapiTypes.LIBRARY_LOCATION_PTID);
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public int getLibrarySource()
    {
        return getIntegerProperty(JdapiTypes.LIBRARY_SOURCE_PTID);
    }

    public int getPersistentClientInfoLength()
    {
        return getIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID);
    }

    public void setPersistentClientInfoLength(int i)
    {
        setIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, i);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.ATTACHMENT_LIBRARY_OTID;
    }
}
