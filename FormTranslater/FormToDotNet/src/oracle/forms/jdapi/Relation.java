// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, Jdapi, BaseAPI, JdapiTypes, 
//            Block, PropertyClass, JdapiObject

public class Relation extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public Relation(Block block, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), block.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public Relation(Block block, String s, Relation relation)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), block.getObjectPointer(), s_foType, s, 0L, relation.getObjectPointer());
        Jdapi.addObject(this);
    }

    public Relation(Block block, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), block.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected Relation(long l)
    {
        super(l);
    }

    public Relation clone(Block block, String s)
    {
        return (Relation)super.clone(block, s);
    }

    public static Relation find(Block block, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), block.getObjectPointer(), s, s_foType);
        Relation relation = null;
        if(l1 != 0L)
            relation = (Relation)Jdapi.getObject(l1);
        return relation;
    }

    public String getComment()
    {
        return getStringProperty(JdapiTypes.COMMENT_PTID);
    }

    public void setComment(String s)
    {
        setStringProperty(JdapiTypes.COMMENT_PTID, s);
    }

    public String getDetailBlock()
    {
        return getStringProperty(JdapiTypes.DETAIL_BLOCK_PTID);
    }

    public void setDetailBlock(String s)
    {
        setStringProperty(JdapiTypes.DETAIL_BLOCK_PTID, s);
    }

    public String getDetailItemref()
    {
        return getStringProperty(JdapiTypes.DETAIL_ITEMREF_PTID);
    }

    public void setDetailItemref(String s)
    {
        setStringProperty(JdapiTypes.DETAIL_ITEMREF_PTID, s);
    }

    public String getJoinCondition()
    {
        return getStringProperty(JdapiTypes.JOIN_CONDITION_PTID);
    }

    public void setJoinCondition(String s)
    {
        setStringProperty(JdapiTypes.JOIN_CONDITION_PTID, s);
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
    }

    public int getDeleteRecord()
    {
        return getIntegerProperty(JdapiTypes.DELETE_RECORD_PTID);
    }

    public void setDeleteRecord(int i)
    {
        setIntegerProperty(JdapiTypes.DELETE_RECORD_PTID, i);
    }

    public int getPersistentClientInfoLength()
    {
        return getIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID);
    }

    public void setPersistentClientInfoLength(int i)
    {
        setIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, i);
    }

    public int getRelationType()
    {
        return getIntegerProperty(JdapiTypes.RELATION_TYPE_PTID);
    }

    public void setRelationType(int i)
    {
        setIntegerProperty(JdapiTypes.RELATION_TYPE_PTID, i);
    }

    public boolean isAutoQuery()
    {
        return getBooleanProperty(JdapiTypes.AUTO_QUERY_PTID);
    }

    public void setAutoQuery(boolean flag)
    {
        setBooleanProperty(JdapiTypes.AUTO_QUERY_PTID, flag);
    }

    public boolean isDeferred()
    {
        return getBooleanProperty(JdapiTypes.DEFERRED_PTID);
    }

    public void setDeferred(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DEFERRED_PTID, flag);
    }

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
    }

    public boolean isPreventMasterlessOperations()
    {
        return getBooleanProperty(JdapiTypes.PREVENT_MASTERLESS_OPERATIONS_PTID);
    }

    public void setPreventMasterlessOperations(boolean flag)
    {
        setBooleanProperty(JdapiTypes.PREVENT_MASTERLESS_OPERATIONS_PTID, flag);
    }

    public boolean isSubclassSubObject()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID);
    }

    public void setSubclassSubObject(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, flag);
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
        s_foType = JdapiTypes.RELATION_OTID;
    }
}
