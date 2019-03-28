// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            RecordGroup, PropertyClass

public class RecordGroupColumn extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public RecordGroupColumn(RecordGroup recordgroup, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), recordgroup.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public RecordGroupColumn(RecordGroup recordgroup, String s, RecordGroupColumn recordgroupcolumn)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), recordgroup.getObjectPointer(), s_foType, s, 0L, recordgroupcolumn.getObjectPointer());
        Jdapi.addObject(this);
    }

    public RecordGroupColumn(RecordGroup recordgroup, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), recordgroup.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected RecordGroupColumn(long l)
    {
        super(l);
    }

    public RecordGroupColumn clone(RecordGroup recordgroup, String s)
    {
        return (RecordGroupColumn)super.clone(recordgroup, s);
    }

    public static RecordGroupColumn find(RecordGroup recordgroup, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), recordgroup.getObjectPointer(), s, s_foType);
        RecordGroupColumn recordgroupcolumn = null;
        if(l1 != 0L)
            recordgroupcolumn = (RecordGroupColumn)Jdapi.getObject(l1);
        return recordgroupcolumn;
    }

    public void insertRow(int i, String s)
    {
        BaseAPI._jni_rcs_insert_row(Jdapi.getContextPointer(), super.m_pd2fob, i, s, null);
    }

    public void insertFormattedRow(int i, String s, String s1)
    {
        BaseAPI._jni_rcs_insert_row(Jdapi.getContextPointer(), super.m_pd2fob, i, s, s1);
    }

    public void deleteRow(int i)
    {
        BaseAPI._jni_rcs_delete_row(Jdapi.getContextPointer(), super.m_pd2fob, i);
    }

    public String getRow(int i)
    {
        return BaseAPI._jni_rcs_get_row(Jdapi.getContextPointer(), super.m_pd2fob, i);
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
    }

    public int getColumnDataType()
    {
        return getIntegerProperty(JdapiTypes.COLUMN_DATA_TYPE_PTID);
    }

    public void setColumnDataType(int i)
    {
        setIntegerProperty(JdapiTypes.COLUMN_DATA_TYPE_PTID, i);
    }

    public int getColumnValuesCount()
    {
        return getIntegerProperty(JdapiTypes.COLUMN_VALUES_COUNT_PTID);
    }

    public int getDataLengthSemantics()
    {
        return getIntegerProperty(JdapiTypes.DATA_LENGTH_SEMANTICS_PTID);
    }

    public void setDataLengthSemantics(int i)
    {
        setIntegerProperty(JdapiTypes.DATA_LENGTH_SEMANTICS_PTID, i);
    }

    public int getMaximumLength()
    {
        return getIntegerProperty(JdapiTypes.MAXIMUM_LENGTH_PTID);
    }

    public void setMaximumLength(int i)
    {
        setIntegerProperty(JdapiTypes.MAXIMUM_LENGTH_PTID, i);
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
        s_foType = JdapiTypes.RECORDGROUP_COLUMNSPECIFICATION_OTID;
    }
}
