// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            FormModule, PropertyClass, ObjectLibrary, ObjectLibraryTab, 
//            JdapiObject

public class Report extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public Report(FormModule formmodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Report(FormModule formmodule, String s, Report report)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, report.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Report(FormModule formmodule, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Report(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), 0L);
        Jdapi.addObject(this);
    }

    public Report(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, Report report)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), report.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Report(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected Report(long l)
    {
        super(l);
    }

    public Report clone(FormModule formmodule, String s)
    {
        return (Report)super.clone(formmodule, s);
    }

    public Report clone(ObjectLibraryTab objectlibrarytab, String s)
    {
        return (Report)super.clone(objectlibrarytab, s);
    }

    public static Report find(FormModule formmodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s, s_foType);
        Report report = null;
        if(l1 != 0L)
            report = (Report)Jdapi.getObject(l1);
        return report;
    }

    public static Report find(ObjectLibraryTab objectlibrarytab, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s, s_foType);
        Report report = null;
        if(l1 != 0L)
            report = (Report)Jdapi.getObject(l1);
        return report;
    }

    public String getComment()
    {
        return getStringProperty(JdapiTypes.COMMENT_PTID);
    }

    public void setComment(String s)
    {
        setStringProperty(JdapiTypes.COMMENT_PTID, s);
    }

    public String getDataSourceBlock()
    {
        return getStringProperty(JdapiTypes.DATA_SOURCE_BLOCK_PTID);
    }

    public void setDataSourceBlock(String s)
    {
        setStringProperty(JdapiTypes.DATA_SOURCE_BLOCK_PTID, s);
    }

    public String getFilename()
    {
        return getStringProperty(JdapiTypes.FILENAME_PTID);
    }

    public void setFilename(String s)
    {
        setStringProperty(JdapiTypes.FILENAME_PTID, s);
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
    }

    public String getParentFilename()
    {
        return getStringProperty(JdapiTypes.PARENT_FILENAME_PTID);
    }

    public void setParentFilename(String s)
    {
        setStringProperty(JdapiTypes.PARENT_FILENAME_PTID, s);
    }

    public String getParentFilepath()
    {
        return getStringProperty(JdapiTypes.PARENT_FILEPATH_PTID);
    }

    public void setParentFilepath(String s)
    {
        setStringProperty(JdapiTypes.PARENT_FILEPATH_PTID, s);
    }

    public String getParentModule()
    {
        return getStringProperty(JdapiTypes.PARENT_MODULE_PTID);
    }

    public void setParentModule(String s)
    {
        setStringProperty(JdapiTypes.PARENT_MODULE_PTID, s);
    }

    public String getParentName()
    {
        return getStringProperty(JdapiTypes.PARENT_NAME_PTID);
    }

    public void setParentName(String s)
    {
        setStringProperty(JdapiTypes.PARENT_NAME_PTID, s);
    }

    public String getQueryName()
    {
        return getStringProperty(JdapiTypes.QUERY_NAME_PTID);
    }

    public void setQueryName(String s)
    {
        setStringProperty(JdapiTypes.QUERY_NAME_PTID, s);
    }

    public String getReportDestinationFormat()
    {
        return getStringProperty(JdapiTypes.REPORT_DESTINATION_FORMAT_PTID);
    }

    public void setReportDestinationFormat(String s)
    {
        setStringProperty(JdapiTypes.REPORT_DESTINATION_FORMAT_PTID, s);
    }

    public String getReportDestinationName()
    {
        return getStringProperty(JdapiTypes.REPORT_DESTINATION_NAME_PTID);
    }

    public void setReportDestinationName(String s)
    {
        setStringProperty(JdapiTypes.REPORT_DESTINATION_NAME_PTID, s);
    }

    public String getReportParameters()
    {
        return getStringProperty(JdapiTypes.REPORT_PARAMETERS_PTID);
    }

    public void setReportParameters(String s)
    {
        setStringProperty(JdapiTypes.REPORT_PARAMETERS_PTID, s);
    }

    public String getReportServer()
    {
        return getStringProperty(JdapiTypes.REPORT_SERVER_PTID);
    }

    public void setReportServer(String s)
    {
        setStringProperty(JdapiTypes.REPORT_SERVER_PTID, s);
    }

    public int getCommMode()
    {
        return getIntegerProperty(JdapiTypes.COMM_MODE_PTID);
    }

    public void setCommMode(int i)
    {
        setIntegerProperty(JdapiTypes.COMM_MODE_PTID, i);
    }

    public int getExecuteMode()
    {
        return getIntegerProperty(JdapiTypes.EXECUTE_MODE_PTID);
    }

    public void setExecuteMode(int i)
    {
        setIntegerProperty(JdapiTypes.EXECUTE_MODE_PTID, i);
    }

    public int getParentModuleType()
    {
        return getIntegerProperty(JdapiTypes.PARENT_MODULETYPE_PTID);
    }

    public void setParentModuleType(int i)
    {
        setIntegerProperty(JdapiTypes.PARENT_MODULETYPE_PTID, i);
    }

    public int getParentType()
    {
        return getIntegerProperty(JdapiTypes.PARENT_TYPE_PTID);
    }

    public void setParentType(int i)
    {
        setIntegerProperty(JdapiTypes.PARENT_TYPE_PTID, i);
    }

    public int getPersistentClientInfoLength()
    {
        return getIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID);
    }

    public void setPersistentClientInfoLength(int i)
    {
        setIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, i);
    }

    public int getReportDestinationType()
    {
        return getIntegerProperty(JdapiTypes.REPORT_DESTINATION_TYPE_PTID);
    }

    public void setReportDestinationType(int i)
    {
        setIntegerProperty(JdapiTypes.REPORT_DESTINATION_TYPE_PTID, i);
    }

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
    }

    public boolean isSubclassObjectGroup()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID);
    }

    public void setSubclassObjectGroup(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, flag);
    }

    public JdapiObject getModule()
    {
        return getObjectProperty(JdapiTypes.MODULE_PTID);
    }

    public JdapiObject getOwner()
    {
        return getObjectProperty(JdapiTypes.OWNER_PTID);
    }

    public JdapiObject getSource()
    {
        return getObjectProperty(JdapiTypes.SOURCE_PTID);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.REPORT_OTID;
    }
}
