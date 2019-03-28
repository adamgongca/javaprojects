// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, ObjectLibrary, JdapiException, JdapiObjectLibraryTabObjectIterator, 
//            Jdapi, BaseAPI, JdapiTypes, PropertyClass, 
//            JdapiObject, JdapiIterator

public class ObjectLibraryTab extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public ObjectLibraryTab(ObjectLibrary objectlibrary, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrary.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public ObjectLibraryTab(ObjectLibrary objectlibrary, String s, ObjectLibraryTab objectlibrarytab)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrary.getObjectPointer(), s_foType, s, 0L, objectlibrarytab.getObjectPointer());
        Jdapi.addObject(this);
    }

    public ObjectLibraryTab(ObjectLibrary objectlibrary, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrary.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected ObjectLibraryTab(long l)
    {
        super(l);
    }

    public ObjectLibraryTab clone(ObjectLibrary objectlibrary, String s)
    {
        return (ObjectLibraryTab)super.clone(objectlibrary, s);
    }

    public static ObjectLibraryTab find(ObjectLibrary objectlibrary, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrary.getObjectPointer(), s, s_foType);
        ObjectLibraryTab objectlibrarytab = null;
        if(l1 != 0L)
            objectlibrarytab = (ObjectLibraryTab)Jdapi.getObject(l1);
        return objectlibrarytab;
    }

    public JdapiObject addObject(JdapiObject jdapiobject, boolean flag)
    {
        JdapiObject jdapiobject1 = getObjectProperty(JdapiTypes.OWNER_PTID);
        if(jdapiobject1 instanceof ObjectLibrary)
            return ((ObjectLibrary)jdapiobject1).addObject(this, jdapiobject, flag);
        else
            throw new JdapiException("Unexpected owner of OLT");
    }

    public void removeObject(JdapiObject jdapiobject)
    {
        JdapiObject jdapiobject1 = getObjectProperty(JdapiTypes.OWNER_PTID);
        if(jdapiobject1 instanceof ObjectLibrary)
            ((ObjectLibrary)jdapiobject1).removeObject(jdapiobject);
        else
            throw new JdapiException("Unexpected owner of OLT");
    }

    public JdapiIterator getTabObjects()
    {
        return new JdapiObjectLibraryTabObjectIterator(this);
    }

    public JdapiObject findObjectByPosition(int i)
    {
        JdapiObject jdapiobject = null;
        long l = BaseAPI._jni_find_olt_obj_by_pos(Jdapi.getContextPointer(), super.m_pd2fob, i);
        if(l != 0L)
            jdapiobject = Jdapi.getObject(l);
        return jdapiobject;
    }

    public String getComment()
    {
        return getStringProperty(JdapiTypes.COMMENT_PTID);
    }

    public void setComment(String s)
    {
        setStringProperty(JdapiTypes.COMMENT_PTID, s);
    }

    public String getLabel()
    {
        return getStringProperty(JdapiTypes.LABEL_PTID);
    }

    public void setLabel(String s)
    {
        setStringProperty(JdapiTypes.LABEL_PTID, s);
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
    }

    public int getObjectCount()
    {
        return getIntegerProperty(JdapiTypes.OBJECT_COUNT_PTID);
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
        s_foType = JdapiTypes.OBJECT_LIBRARY_TAB_OTID;
    }
}
