// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            Block

public class DataSourceArgument extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public DataSourceArgument(Block block, int i)
    {
        this(block, String.valueOf(i));
    }

    public DataSourceArgument(Block block, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), block.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    protected DataSourceArgument(long l)
    {
        super(l);
    }

    public DataSourceArgument clone(Block block, String s)
    {
        return (DataSourceArgument)super.clone(block, s);
    }

    public static DataSourceArgument find(Block block, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), block.getObjectPointer(), s, s_foType);
        DataSourceArgument datasourceargument = null;
        if(l1 != 0L)
            datasourceargument = (DataSourceArgument)Jdapi.getObject(l1);
        return datasourceargument;
    }

    public String getDSAName()
    {
        return getStringProperty(JdapiTypes.DSA_NAME_PTID);
    }

    public void setDSAName(String s)
    {
        setStringProperty(JdapiTypes.DSA_NAME_PTID, s);
    }

    public String getDSATypeName()
    {
        return getStringProperty(JdapiTypes.DSA_TYPE_NAME_PTID);
    }

    public void setDSATypeName(String s)
    {
        setStringProperty(JdapiTypes.DSA_TYPE_NAME_PTID, s);
    }

    public String getDSAValue()
    {
        return getStringProperty(JdapiTypes.DSA_VALUE_PTID);
    }

    public void setDSAValue(String s)
    {
        setStringProperty(JdapiTypes.DSA_VALUE_PTID, s);
    }

    public int getDSAMode()
    {
        return getIntegerProperty(JdapiTypes.DSA_MODE_PTID);
    }

    public void setDSAMode(int i)
    {
        setIntegerProperty(JdapiTypes.DSA_MODE_PTID, i);
    }

    public int getDSAType()
    {
        return getIntegerProperty(JdapiTypes.DSA_TYPE_PTID);
    }

    public void setDSAType(int i)
    {
        setIntegerProperty(JdapiTypes.DSA_TYPE_PTID, i);
    }

    public int getPersistentClientInfoLength()
    {
        return getIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID);
    }

    public void setPersistentClientInfoLength(int i)
    {
        setIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, i);
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
        s_foType = JdapiTypes.DATA_SOURCE_ARGUMENT_OTID;
    }
}
