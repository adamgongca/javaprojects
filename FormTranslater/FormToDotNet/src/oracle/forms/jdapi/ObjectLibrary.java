// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.io.File;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiModule, JdapiException, JdapiUnsupportedOperationException, BaseFormsObject, 
//            JdapiObjectLibraryObjectIterator, TranslationTable, JdapiObjectListIterator, Jdapi, 
//            BaseAPI, JdapiIterator, ObjectLibraryTab, JdapiTypes, 
//            JdapiObject

public class ObjectLibrary extends JdapiModule
{

    public int getTypeId()
    {
        return s_foType;
    }

    public ObjectLibrary(String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), Jdapi.getContextPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    protected ObjectLibrary(long l)
    {
        super(l);
    }

    public static ObjectLibrary open(String s)
    {
        return open(new File(s), null);
    }

    public static ObjectLibrary open(File file)
    {
        return open(file, null);
    }

    public static ObjectLibrary open(String s, String s1)
    {
        return open(new File(s), s1);
    }

    public static ObjectLibrary open(File file, String s)
    {
        for(JdapiIterator jdapiiterator = Jdapi.getModules(); jdapiiterator.hasNext();)
        {
            JdapiModule jdapimodule = (JdapiModule)jdapiiterator.next();
            String s1 = jdapimodule.getAbsolutePath();
            if(s1 != null && s1.equals(file.getAbsolutePath()))
                return (ObjectLibrary)jdapimodule;
        }

        if(!file.exists())
        {
            throw new JdapiException("'" + file.getAbsolutePath() + "' not found");
        } else
        {
            ObjectLibrary objectlibrary = BaseAPI._jni_load_objlib(Jdapi.getContextPointer(), file.getAbsolutePath(), s);
            objectlibrary.setAbsolutePath(file.getAbsolutePath());
            return objectlibrary;
        }
    }

    public void save(String s)
    {
        File file = new File(s);
        setAbsolutePath(file.getAbsolutePath());
        BaseAPI._jni_save_objlib(Jdapi.getContextPointer(), getObjectPointer(), getAbsolutePath());
    }

    public void compile()
    {
        throw new JdapiUnsupportedOperationException("This module type does not currently support compilation");
    }

    public ObjectLibrary clone(String s)
    {
        return (ObjectLibrary)super.clone(null, s);
    }

    public static ObjectLibrary find(String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), Jdapi.getContextPointer(), s, s_foType);
        ObjectLibrary objectlibrary = null;
        if(l1 != 0L)
            objectlibrary = (ObjectLibrary)Jdapi.getObject(l1);
        return objectlibrary;
    }

    public JdapiObject addObject(ObjectLibraryTab objectlibrarytab, JdapiObject jdapiobject, boolean flag)
    {
        JdapiObject jdapiobject1 = null;
        long l = BaseAPI._jni_add_obj(Jdapi.getContextPointer(), super.m_pd2fob, objectlibrarytab.getObjectPointer(), ((BaseFormsObject)jdapiobject).getObjectPointer(), flag);
        if(l != 0L)
            jdapiobject1 = Jdapi.getObject(l);
        return jdapiobject1;
    }

    public void removeObject(JdapiObject jdapiobject)
    {
        BaseAPI._jni_remove_obj(Jdapi.getContextPointer(), super.m_pd2fob, ((BaseFormsObject)jdapiobject).getObjectPointer());
    }

    public JdapiIterator getObjectLibraryObjects()
    {
        return new JdapiObjectLibraryObjectIterator(this);
    }

    public JdapiObject findObjectByPosition(int i)
    {
        JdapiObject jdapiobject = null;
        long l = BaseAPI._jni_find_obj_by_pos(Jdapi.getContextPointer(), super.m_pd2fob, i);
        if(l != 0L)
            jdapiobject = Jdapi.getObject(l);
        return jdapiobject;
    }

    public void setSmartClass(JdapiObject jdapiobject, boolean flag)
    {
        BaseAPI._jni_set_smart_class(Jdapi.getContextPointer(), super.m_pd2fob, ((BaseFormsObject)jdapiobject).getObjectPointer(), flag);
    }

    public boolean isSmartClass(JdapiObject jdapiobject)
    {
        return BaseAPI._jni_is_smart_class(Jdapi.getContextPointer(), super.m_pd2fob, ((BaseFormsObject)jdapiobject).getObjectPointer());
    }

    public void setDescription(JdapiObject jdapiobject, String s)
    {
        BaseAPI._jni_set_desc(Jdapi.getContextPointer(), super.m_pd2fob, ((BaseFormsObject)jdapiobject).getObjectPointer(), s);
    }

    public String getDescription(JdapiObject jdapiobject)
    {
        return BaseAPI._jni_get_desc(Jdapi.getContextPointer(), super.m_pd2fob, ((BaseFormsObject)jdapiobject).getObjectPointer());
    }

    public String getObjectTabName(JdapiObject jdapiobject)
    {
        return BaseAPI._jni_obj_tabname(Jdapi.getContextPointer(), super.m_pd2fob, ((BaseFormsObject)jdapiobject).getObjectPointer());
    }

    public ObjectLibraryTab getObjectTab(JdapiObject jdapiobject)
    {
        return ObjectLibraryTab.find(this, getObjectTabName(jdapiobject));
    }

    public TranslationTable getTranslationTable()
    {
        if(Jdapi.s_transMode)
            return new TranslationTable(this);
        else
            throw new JdapiUnsupportedOperationException("Session not in Translation Mode");
    }

    public String getComment()
    {
        return getStringProperty(JdapiTypes.COMMENT_PTID);
    }

    public void setComment(String s)
    {
        setStringProperty(JdapiTypes.COMMENT_PTID, s);
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

    public JdapiIterator getObjectLibraryTabs()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.OBJECT_LIBRARY_TAB_PTID, JdapiTypes.OBJECT_LIBRARY_TAB_OTID);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.OBJECT_LIBRARY_OTID;
    }
}
