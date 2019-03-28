// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            Block

public class DataSourceColumn extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public DataSourceColumn(Block block, int i)
    {
        this(block, String.valueOf(i));
    }

    public DataSourceColumn(Block block, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), block.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    protected DataSourceColumn(long l)
    {
        super(l);
    }

    public DataSourceColumn clone(Block block, String s)
    {
        return (DataSourceColumn)super.clone(block, s);
    }

    public static DataSourceColumn find(Block block, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), block.getObjectPointer(), s, s_foType);
        DataSourceColumn datasourcecolumn = null;
        if(l1 != 0L)
            datasourcecolumn = (DataSourceColumn)Jdapi.getObject(l1);
        return datasourcecolumn;
    }

    public String getDSCName()
    {
        return getStringProperty(JdapiTypes.DSC_NAME_PTID);
    }

    public void setDSCName(String s)
    {
        setStringProperty(JdapiTypes.DSC_NAME_PTID, s);
    }

    public String getDSCParentName()
    {
        return getStringProperty(JdapiTypes.DSC_PARENT_NAME_PTID);
    }

    public void setDSCParentName(String s)
    {
        setStringProperty(JdapiTypes.DSC_PARENT_NAME_PTID, s);
    }

    public String getDSCTypeName()
    {
        return getStringProperty(JdapiTypes.DSC_TYPE_NAME_PTID);
    }

    public void setDSCTypeName(String s)
    {
        setStringProperty(JdapiTypes.DSC_TYPE_NAME_PTID, s);
    }

    public int getDSCLength()
    {
        return getIntegerProperty(JdapiTypes.DSC_LENGTH_PTID);
    }

    public void setDSCLength(int i)
    {
        setIntegerProperty(JdapiTypes.DSC_LENGTH_PTID, i);
    }

    public int getDSCPrecision()
    {
        return getIntegerProperty(JdapiTypes.DSC_PRECISION_PTID);
    }

    public void setDSCPrecision(int i)
    {
        setIntegerProperty(JdapiTypes.DSC_PRECISION_PTID, i);
    }

    public int getDSCScale()
    {
        return getIntegerProperty(JdapiTypes.DSC_SCALE_PTID);
    }

    public void setDSCScale(int i)
    {
        setIntegerProperty(JdapiTypes.DSC_SCALE_PTID, i);
    }

    public int getDSCType()
    {
        return getIntegerProperty(JdapiTypes.DSC_TYPE_PTID);
    }

    public void setDSCType(int i)
    {
        setIntegerProperty(JdapiTypes.DSC_TYPE_PTID, i);
    }

    public int getPersistentClientInfoLength()
    {
        return getIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID);
    }

    public void setPersistentClientInfoLength(int i)
    {
        setIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, i);
    }

    public boolean isDSCMandatory()
    {
        return getBooleanProperty(JdapiTypes.DSC_MANDATORY_PTID);
    }

    public void setDSCMandatory(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DSC_MANDATORY_PTID, flag);
    }

    public boolean isDSCNochildren()
    {
        return getBooleanProperty(JdapiTypes.DSC_NOCHILDREN_PTID);
    }

    public void setDSCNochildren(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DSC_NOCHILDREN_PTID, flag);
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
        s_foType = JdapiTypes.DATA_SOURCE_COLUMN_OTID;
    }
}
