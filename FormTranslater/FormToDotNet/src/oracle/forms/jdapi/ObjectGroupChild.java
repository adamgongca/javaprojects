// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            ObjectGroup, PropertyClass, JdapiObject

public class ObjectGroupChild extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public ObjectGroupChild(ObjectGroup objectgroup, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectgroup.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public ObjectGroupChild(ObjectGroup objectgroup, String s, ObjectGroupChild objectgroupchild)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectgroup.getObjectPointer(), s_foType, s, 0L, objectgroupchild.getObjectPointer());
        Jdapi.addObject(this);
    }

    public ObjectGroupChild(ObjectGroup objectgroup, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectgroup.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected ObjectGroupChild(long l)
    {
        super(l);
    }

    public ObjectGroupChild clone(ObjectGroup objectgroup, String s)
    {
        return (ObjectGroupChild)super.clone(objectgroup, s);
    }

    public static ObjectGroupChild find(ObjectGroup objectgroup, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectgroup.getObjectPointer(), s, s_foType);
        ObjectGroupChild objectgroupchild = null;
        if(l1 != 0L)
            objectgroupchild = (ObjectGroupChild)Jdapi.getObject(l1);
        return objectgroupchild;
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
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

    public boolean isSubclassSubObject()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID);
    }

    public void setSubclassSubObject(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, flag);
    }

    public JdapiObject getObjectGroupChildRealObject()
    {
        return getObjectProperty(JdapiTypes.OBJECT_GROUP_CHILD_REAL_OBJECT_PTID);
    }

    public void setObjectGroupChildRealObject(JdapiObject jdapiobject)
    {
        setObjectProperty(JdapiTypes.OBJECT_GROUP_CHILD_REAL_OBJECT_PTID, jdapiobject);
    }

    public JdapiObject getSource()
    {
        return getObjectProperty(JdapiTypes.SOURCE_PTID);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.OBJECTGROUP_CHILD_OTID;
    }
}
