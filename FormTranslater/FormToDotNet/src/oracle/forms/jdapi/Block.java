// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, JdapiException, JdapiObjectListIterator, VisualAttribute, 
//            Canvas, TabPage, Jdapi, BaseAPI, 
//            JdapiTypes, FormModule, PropertyClass, ObjectLibrary, 
//            ObjectLibraryTab, JdapiIterator, JdapiObject

public class Block extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public Block(FormModule formmodule, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Block(FormModule formmodule, String s, Block block)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, block.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Block(FormModule formmodule, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Block(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), 0L);
        Jdapi.addObject(this);
    }

    public Block(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, Block block)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), block.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Block(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected Block(long l)
    {
        super(l);
    }

    public Block clone(FormModule formmodule, String s)
    {
        return (Block)super.clone(formmodule, s);
    }

    public Block clone(ObjectLibraryTab objectlibrarytab, String s)
    {
        return (Block)super.clone(objectlibrarytab, s);
    }

    public static Block find(FormModule formmodule, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), formmodule.getObjectPointer(), s, s_foType);
        Block block = null;
        if(l1 != 0L)
            block = (Block)Jdapi.getObject(l1);
        return block;
    }

    public static Block find(ObjectLibraryTab objectlibrarytab, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s, s_foType);
        Block block = null;
        if(l1 != 0L)
            block = (Block)Jdapi.getObject(l1);
        return block;
    }

    public String getAlias()
    {
        return getStringProperty(JdapiTypes.ALIAS_PTID);
    }

    public void setAlias(String s)
    {
        setStringProperty(JdapiTypes.ALIAS_PTID, s);
    }

    public String getBackColor()
    {
        return getStringProperty(JdapiTypes.BACK_COLOR_PTID);
    }

    public void setBackColor(String s)
    {
        setStringProperty(JdapiTypes.BACK_COLOR_PTID, s);
    }

    public String getComment()
    {
        return getStringProperty(JdapiTypes.COMMENT_PTID);
    }

    public void setComment(String s)
    {
        setStringProperty(JdapiTypes.COMMENT_PTID, s);
    }

    public String getDeleteProcedureName()
    {
        return getStringProperty(JdapiTypes.DELETE_PROCEDURE_NAME_PTID);
    }

    public void setDeleteProcedureName(String s)
    {
        setStringProperty(JdapiTypes.DELETE_PROCEDURE_NAME_PTID, s);
    }

    public String getDMLDataName()
    {
        return getStringProperty(JdapiTypes.DML_DATA_NAME_PTID);
    }

    public void setDMLDataName(String s)
    {
        setStringProperty(JdapiTypes.DML_DATA_NAME_PTID, s);
    }

    public String getFillPattern()
    {
        return getStringProperty(JdapiTypes.FILL_PATTERN_PTID);
    }

    public void setFillPattern(String s)
    {
        setStringProperty(JdapiTypes.FILL_PATTERN_PTID, s);
    }

    public String getForegroundColor()
    {
        return getStringProperty(JdapiTypes.FOREGROUND_COLOR_PTID);
    }

    public void setForegroundColor(String s)
    {
        setStringProperty(JdapiTypes.FOREGROUND_COLOR_PTID, s);
    }

    public String getInsertProcedureName()
    {
        return getStringProperty(JdapiTypes.INSERT_PROCEDURE_NAME_PTID);
    }

    public void setInsertProcedureName(String s)
    {
        setStringProperty(JdapiTypes.INSERT_PROCEDURE_NAME_PTID, s);
    }

    public String getLockProcedureName()
    {
        return getStringProperty(JdapiTypes.LOCK_PROCEDURE_NAME_PTID);
    }

    public void setLockProcedureName(String s)
    {
        setStringProperty(JdapiTypes.LOCK_PROCEDURE_NAME_PTID, s);
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
    }

    public String getNextNavigationBlockName()
    {
        return getStringProperty(JdapiTypes.NEXT_NAVIGATION_BLOCK_NAME_PTID);
    }

    public void setNextNavigationBlockName(String s)
    {
        setStringProperty(JdapiTypes.NEXT_NAVIGATION_BLOCK_NAME_PTID, s);
    }

    public String getOptionHint()
    {
        return getStringProperty(JdapiTypes.OPTION_HINT_PTID);
    }

    public void setOptionHint(String s)
    {
        setStringProperty(JdapiTypes.OPTION_HINT_PTID, s);
    }

    public String getOrderByClause()
    {
        return getStringProperty(JdapiTypes.ORDER_BY_CLAUSE_PTID);
    }

    public void setOrderByClause(String s)
    {
        setStringProperty(JdapiTypes.ORDER_BY_CLAUSE_PTID, s);
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

    public String getPreviousNavigationBlockName()
    {
        return getStringProperty(JdapiTypes.PREVIOUS_NAVIGATION_BLOCK_NAME_PTID);
    }

    public void setPreviousNavigationBlockName(String s)
    {
        setStringProperty(JdapiTypes.PREVIOUS_NAVIGATION_BLOCK_NAME_PTID, s);
    }

    public String getQueryDataSourceName()
    {
        return getStringProperty(JdapiTypes.QUERY_DATA_SOURCE_NAME_PTID);
    }

    public void setQueryDataSourceName(String s)
    {
        setStringProperty(JdapiTypes.QUERY_DATA_SOURCE_NAME_PTID, s);
    }

    public String getRecordVisualAttributeGroupName()
    {
        return getStringProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_NAME_PTID);
    }

    public void setRecordVisualAttributeGroupName(String s)
    {
        setStringProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_NAME_PTID, s);
    }

    public String getScrollbarCanvasName()
    {
        return getStringProperty(JdapiTypes.SCROLLBAR_CANVAS_NAME_PTID);
    }

    public void setScrollbarCanvasName(String s)
    {
        setStringProperty(JdapiTypes.SCROLLBAR_CANVAS_NAME_PTID, s);
    }

    public String getScrollbarTabPageName()
    {
        return getStringProperty(JdapiTypes.SCROLLBAR_TABPAGE_NAME_PTID);
    }

    public void setScrollbarTabPageName(String s)
    {
        setStringProperty(JdapiTypes.SCROLLBAR_TABPAGE_NAME_PTID, s);
    }

    public String getUpdateProcedureName()
    {
        return getStringProperty(JdapiTypes.UPDATE_PROCEDURE_NAME_PTID);
    }

    public void setUpdateProcedureName(String s)
    {
        setStringProperty(JdapiTypes.UPDATE_PROCEDURE_NAME_PTID, s);
    }

    public String getVisualAttributeName()
    {
        return getStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID);
    }

    public void setVisualAttributeName(String s)
    {
        setStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, s);
    }

    public String getWhereClause()
    {
        return getStringProperty(JdapiTypes.WHERE_CLAUSE_PTID);
    }

    public void setWhereClause(String s)
    {
        setStringProperty(JdapiTypes.WHERE_CLAUSE_PTID, s);
    }

    public int getDMLArraySize()
    {
        return getIntegerProperty(JdapiTypes.DML_ARRAY_SIZE_PTID);
    }

    public void setDMLArraySize(int i)
    {
        setIntegerProperty(JdapiTypes.DML_ARRAY_SIZE_PTID, i);
    }

    public int getDMLDataType()
    {
        return getIntegerProperty(JdapiTypes.DML_DATA_TYPE_PTID);
    }

    public void setDMLDataType(int i)
    {
        setIntegerProperty(JdapiTypes.DML_DATA_TYPE_PTID, i);
    }

    public int getKeyMode()
    {
        return getIntegerProperty(JdapiTypes.KEY_MODE_PTID);
    }

    public void setKeyMode(int i)
    {
        setIntegerProperty(JdapiTypes.KEY_MODE_PTID, i);
    }

    public int getLanguageDirection()
    {
        return getIntegerProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID);
    }

    public void setLanguageDirection(int i)
    {
        setIntegerProperty(JdapiTypes.LANGUAGE_DIRECTION_PTID, i);
    }

    public int getLockMode()
    {
        return getIntegerProperty(JdapiTypes.LOCK_MODE_PTID);
    }

    public void setLockMode(int i)
    {
        setIntegerProperty(JdapiTypes.LOCK_MODE_PTID, i);
    }

    public int getMaximumQueryTime()
    {
        return getIntegerProperty(JdapiTypes.MAXIMUM_QUERY_TIME_PTID);
    }

    public void setMaximumQueryTime(int i)
    {
        setIntegerProperty(JdapiTypes.MAXIMUM_QUERY_TIME_PTID, i);
    }

    public int getMaximumRecordsFetched()
    {
        return getIntegerProperty(JdapiTypes.MAXIMUM_RECORDS_FETCHED_PTID);
    }

    public void setMaximumRecordsFetched(int i)
    {
        setIntegerProperty(JdapiTypes.MAXIMUM_RECORDS_FETCHED_PTID, i);
    }

    public int getNavigationStyle()
    {
        return getIntegerProperty(JdapiTypes.NAVIGATION_STYLE_PTID);
    }

    public void setNavigationStyle(int i)
    {
        setIntegerProperty(JdapiTypes.NAVIGATION_STYLE_PTID, i);
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

    public int getQueryDataSourceType()
    {
        return getIntegerProperty(JdapiTypes.QUERY_DATA_SOURCE_TYPE_PTID);
    }

    public void setQueryDataSourceType(int i)
    {
        setIntegerProperty(JdapiTypes.QUERY_DATA_SOURCE_TYPE_PTID, i);
    }

    public int getRecordOrientation()
    {
        return getIntegerProperty(JdapiTypes.RECORD_ORIENTATION_PTID);
    }

    public void setRecordOrientation(int i)
    {
        setIntegerProperty(JdapiTypes.RECORD_ORIENTATION_PTID, i);
    }

    public int getRecordsBufferedCount()
    {
        return getIntegerProperty(JdapiTypes.RECORDS_BUFFERED_COUNT_PTID);
    }

    public void setRecordsBufferedCount(int i)
    {
        setIntegerProperty(JdapiTypes.RECORDS_BUFFERED_COUNT_PTID, i);
    }

    public int getRecordsDisplayCount()
    {
        return getIntegerProperty(JdapiTypes.RECORDS_DISPLAY_COUNT_PTID);
    }

    public void setRecordsDisplayCount(int i)
    {
        setIntegerProperty(JdapiTypes.RECORDS_DISPLAY_COUNT_PTID, i);
    }

    public int getRecordsFetchedCount()
    {
        return getIntegerProperty(JdapiTypes.RECORDS_FETCHED_COUNT_PTID);
    }

    public void setRecordsFetchedCount(int i)
    {
        setIntegerProperty(JdapiTypes.RECORDS_FETCHED_COUNT_PTID, i);
    }

    public int getScrollbarLength()
    {
        return getIntegerProperty(JdapiTypes.SCROLLBAR_LENGTH_PTID);
    }

    public void setScrollbarLength(int i)
    {
        setIntegerProperty(JdapiTypes.SCROLLBAR_LENGTH_PTID, i);
    }

    public int getScrollbarOrientation()
    {
        return getIntegerProperty(JdapiTypes.SCROLLBAR_ORIENTATION_PTID);
    }

    public void setScrollbarOrientation(int i)
    {
        setIntegerProperty(JdapiTypes.SCROLLBAR_ORIENTATION_PTID, i);
    }

    public int getScrollbarWidth()
    {
        return getIntegerProperty(JdapiTypes.SCROLLBAR_WIDTH_PTID);
    }

    public void setScrollbarWidth(int i)
    {
        setIntegerProperty(JdapiTypes.SCROLLBAR_WIDTH_PTID, i);
    }

    public int getScrollbarXPosition()
    {
        return getIntegerProperty(JdapiTypes.SCROLLBAR_X_POSITION_PTID);
    }

    public void setScrollbarXPosition(int i)
    {
        setIntegerProperty(JdapiTypes.SCROLLBAR_X_POSITION_PTID, i);
    }

    public int getScrollbarYPosition()
    {
        return getIntegerProperty(JdapiTypes.SCROLLBAR_Y_POSITION_PTID);
    }

    public void setScrollbarYPosition(int i)
    {
        setIntegerProperty(JdapiTypes.SCROLLBAR_Y_POSITION_PTID, i);
    }

    public boolean isDatabaseBlock()
    {
        return getBooleanProperty(JdapiTypes.DATABASE_BLOCK_PTID);
    }

    public void setDatabaseBlock(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DATABASE_BLOCK_PTID, flag);
    }

    public boolean isDeleteAllowed()
    {
        return getBooleanProperty(JdapiTypes.DELETE_ALLOWED_PTID);
    }

    public void setDeleteAllowed(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DELETE_ALLOWED_PTID, flag);
    }

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
    }

    public boolean isDMLReturnValue()
    {
        return getBooleanProperty(JdapiTypes.DML_RETURN_VALUE_PTID);
    }

    public void setDMLReturnValue(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DML_RETURN_VALUE_PTID, flag);
    }

    public boolean isEnforcedColumnSecurity()
    {
        return getBooleanProperty(JdapiTypes.ENFORCED_COLUMN_SECURITY_PTID);
    }

    public void setEnforcedColumnSecurity(boolean flag)
    {
        setBooleanProperty(JdapiTypes.ENFORCED_COLUMN_SECURITY_PTID, flag);
    }

    public boolean isEnforcedPrimaryKey()
    {
        return getBooleanProperty(JdapiTypes.ENFORCED_PRIMARY_KEY_PTID);
    }

    public void setEnforcedPrimaryKey(boolean flag)
    {
        setBooleanProperty(JdapiTypes.ENFORCED_PRIMARY_KEY_PTID, flag);
    }

    public boolean isIncludeRefitem()
    {
        return getBooleanProperty(JdapiTypes.INCLUDE_REFITEM_PTID);
    }

    public void setIncludeRefitem(boolean flag)
    {
        setBooleanProperty(JdapiTypes.INCLUDE_REFITEM_PTID, flag);
    }

    public boolean isInsertAllowed()
    {
        return getBooleanProperty(JdapiTypes.INSERT_ALLOWED_PTID);
    }

    public void setInsertAllowed(boolean flag)
    {
        setBooleanProperty(JdapiTypes.INSERT_ALLOWED_PTID, flag);
    }

    public boolean isPrecompSummary()
    {
        return getBooleanProperty(JdapiTypes.PRECOMP_SUMMARY_PTID);
    }

    public void setPrecompSummary(boolean flag)
    {
        setBooleanProperty(JdapiTypes.PRECOMP_SUMMARY_PTID, flag);
    }

    public boolean isQueryAllRecords()
    {
        return getBooleanProperty(JdapiTypes.QUERY_ALL_RECORDS_PTID);
    }

    public void setQueryAllRecords(boolean flag)
    {
        setBooleanProperty(JdapiTypes.QUERY_ALL_RECORDS_PTID, flag);
    }

    public boolean isQueryAllowed()
    {
        return getBooleanProperty(JdapiTypes.QUERY_ALLOWED_PTID);
    }

    public void setQueryAllowed(boolean flag)
    {
        setBooleanProperty(JdapiTypes.QUERY_ALLOWED_PTID, flag);
    }

    public boolean isReverseDirection()
    {
        return getBooleanProperty(JdapiTypes.REVERSE_DIRECTION_PTID);
    }

    public void setReverseDirection(boolean flag)
    {
        setBooleanProperty(JdapiTypes.REVERSE_DIRECTION_PTID, flag);
    }

    public boolean isShowScrollbar()
    {
        return getBooleanProperty(JdapiTypes.SHOW_SCROLLBAR_PTID);
    }

    public void setShowScrollbar(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SHOW_SCROLLBAR_PTID, flag);
    }

    public boolean isSingleRecord()
    {
        return getBooleanProperty(JdapiTypes.SINGLE_RECORD_PTID);
    }

    public void setSingleRecord(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SINGLE_RECORD_PTID, flag);
    }

    public boolean isSubclassObjectGroup()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID);
    }

    public void setSubclassObjectGroup(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID, flag);
    }

    public boolean isUpdateAllowed()
    {
        return getBooleanProperty(JdapiTypes.UPDATE_ALLOWED_PTID);
    }

    public void setUpdateAllowed(boolean flag)
    {
        setBooleanProperty(JdapiTypes.UPDATE_ALLOWED_PTID, flag);
    }

    public boolean isUpdateChangedColumns()
    {
        return getBooleanProperty(JdapiTypes.UPDATE_CHANGED_COLUMNS_PTID);
    }

    public void setUpdateChangedColumns(boolean flag)
    {
        setBooleanProperty(JdapiTypes.UPDATE_CHANGED_COLUMNS_PTID, flag);
    }

    public JdapiIterator getDeleteDataSourceArguments()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.DELETE_DATA_SOURCE_ARGUMENT_PTID, JdapiTypes.DATA_SOURCE_ARGUMENT_OTID);
    }

    public JdapiIterator getDeleteDataSourceColumns()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.DELETE_DATA_SOURCE_COLUMN_PTID, JdapiTypes.DATA_SOURCE_COLUMN_OTID);
    }

    public JdapiIterator getInsertDataSourceArguments()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.INSERT_DATA_SOURCE_ARGUMENT_PTID, JdapiTypes.DATA_SOURCE_ARGUMENT_OTID);
    }

    public JdapiIterator getInsertDataSourceColumns()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.INSERT_DATA_SOURCE_COLUMN_PTID, JdapiTypes.DATA_SOURCE_COLUMN_OTID);
    }

    public JdapiIterator getItems()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.ITEM_PTID, JdapiTypes.ITEM_OTID);
    }

    public JdapiIterator getLockDataSourceArguments()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.LOCK_DATA_SOURCE_ARGUMENT_PTID, JdapiTypes.DATA_SOURCE_ARGUMENT_OTID);
    }

    public JdapiIterator getLockDataSourceColumns()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.LOCK_DATA_SOURCE_COLUMN_PTID, JdapiTypes.DATA_SOURCE_COLUMN_OTID);
    }

    public JdapiObject getModule()
    {
        return getObjectProperty(JdapiTypes.MODULE_PTID);
    }

    public Block getNextNavigationBlockObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (Block)getObjectProperty(JdapiTypes.NEXT_NAVIGATION_BLOCK_OBJECT_PTID);
    }

    public void setNextNavigationBlockObject(Block block)
    {
        setObjectProperty(JdapiTypes.NEXT_NAVIGATION_BLOCK_OBJECT_PTID, block);
    }

    public JdapiObject getOwner()
    {
        return getObjectProperty(JdapiTypes.OWNER_PTID);
    }

    public Block getPreviousNavigationBlockObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (Block)getObjectProperty(JdapiTypes.PREVIOUS_NAVIGATION_BLOCK_OBJECT_PTID);
    }

    public void setPreviousNavigationBlockObject(Block block)
    {
        setObjectProperty(JdapiTypes.PREVIOUS_NAVIGATION_BLOCK_OBJECT_PTID, block);
    }

    public JdapiIterator getQueryDataSourceArguments()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.QUERY_DATA_SOURCE_ARGUMENT_PTID, JdapiTypes.DATA_SOURCE_ARGUMENT_OTID);
    }

    public JdapiIterator getQueryDataSourceColumns()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.QUERY_DATA_SOURCE_COLUMN_PTID, JdapiTypes.DATA_SOURCE_COLUMN_OTID);
    }

    public VisualAttribute getRecordVisualAttributeGroupObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (VisualAttribute)getObjectProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_OBJECT_PTID);
    }

    public void setRecordVisualAttributeGroupObject(VisualAttribute visualattribute)
    {
        setObjectProperty(JdapiTypes.RECORD_VISUALATTRIBUTE_GROUP_OBJECT_PTID, visualattribute);
    }

    public JdapiIterator getRelations()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.RELATION_PTID, JdapiTypes.RELATION_OTID);
    }

    public Canvas getScrollbarCanvasObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (Canvas)getObjectProperty(JdapiTypes.SCROLLBAR_CANVAS_OBJECT_PTID);
    }

    public void setScrollbarCanvasObject(Canvas canvas)
    {
        setObjectProperty(JdapiTypes.SCROLLBAR_CANVAS_OBJECT_PTID, canvas);
    }

    public TabPage getScrollbarTabPageObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (TabPage)getObjectProperty(JdapiTypes.SCROLLBAR_TABPAGE_OBJECT_PTID);
    }

    public void setScrollbarTabPageObject(TabPage tabpage)
    {
        setObjectProperty(JdapiTypes.SCROLLBAR_TABPAGE_OBJECT_PTID, tabpage);
    }

    public JdapiObject getSource()
    {
        return getObjectProperty(JdapiTypes.SOURCE_PTID);
    }

    public JdapiIterator getTriggers()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.TRIGGER_PTID, JdapiTypes.TRIGGER_OTID);
    }

    public JdapiIterator getUpdateDataSourceArguments()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.UPDATE_DATA_SOURCE_ARGUMENT_PTID, JdapiTypes.DATA_SOURCE_ARGUMENT_OTID);
    }

    public JdapiIterator getUpdateDataSourceColumns()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.UPDATE_DATA_SOURCE_COLUMN_PTID, JdapiTypes.DATA_SOURCE_COLUMN_OTID);
    }

    public VisualAttribute getVisualAttributeObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (VisualAttribute)getObjectProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID);
    }

    public void setVisualAttributeObject(VisualAttribute visualattribute)
    {
        setObjectProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, visualattribute);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.BLOCK_OTID;
    }
}
