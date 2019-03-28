// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.io.*;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiIllegalStateException, Blob, JdapiException, ObjectLibrary, 
//            JdapiObjectLibraryObjectIterator, ObjectLibraryTab, JdapiObjectLibraryTabObjectIterator, JdapiObjectListIterator, 
//            JdapiObjectChildIterator, JdapiModule, JdapiObject, Jdapi, 
//            BaseAPI, JdapiTypes, ContextCache, JdapiMetadata, 
//            JdapiMetaObject, JdapiIterator

abstract class BaseFormsObject
    implements JdapiObject
{

    protected BaseFormsObject(long l)
    {
        m_pd2fob = 0L;
        m_clientInfo = null;
        m_pd2fob = l;
        if(m_pd2fob != 0L)
            Jdapi.addObject(this);
    }

    public abstract int getTypeId();

    protected long getObjectPointer()
    {
        return m_pd2fob;
    }

    public int queryType()
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        else
            return BaseAPI._jni_query_type(Jdapi.getContextPointer(), m_pd2fob);
    }

    public void setClientInfo(Object obj)
    {
        m_clientInfo = obj;
    }

    public Object getClientInfo()
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        else
            return m_clientInfo;
    }

    public Blob getPersistentClientInfoBlob()
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        else
            return new Blob(BaseAPI._jni_get_persist_client_info(Jdapi.getContextPointer(), m_pd2fob));
    }

    public Object getPersistentClientInfoObject()
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        byte abyte0[] = BaseAPI._jni_get_persist_client_info(Jdapi.getContextPointer(), m_pd2fob);
        Object obj;
        try
        {
            ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(abyte0);
            ObjectInputStream objectinputstream = new ObjectInputStream(bytearrayinputstream);
            obj = objectinputstream.readObject();
            objectinputstream.close();
            bytearrayinputstream.close();
        }
        catch(Exception exception)
        {
            throw new JdapiException(exception.getMessage());
        }
        return obj;
    }

    public void setPersistentClientInfo(Blob blob)
    {
        if(m_pd2fob == 0L)
        {
            throw new JdapiIllegalStateException("Null d2fob pointer");
        } else
        {
            BaseAPI._jni_set_persist_client_info(Jdapi.getContextPointer(), m_pd2fob, blob.getBytes());
            return;
        }
    }

    public void setPersistentClientInfo(Serializable serializable)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
            objectoutputstream.writeObject(serializable);
            objectoutputstream.close();
            bytearrayoutputstream.close();
            BaseAPI._jni_set_persist_client_info(Jdapi.getContextPointer(), m_pd2fob, bytearrayoutputstream.toByteArray());
        }
        catch(Exception exception)
        {
            throw new JdapiException(exception.getMessage());
        }
    }

    public boolean equals(JdapiObject jdapiobject)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        boolean flag = false;
        if(getClass().isInstance(jdapiobject))
        {
            BaseFormsObject baseformsobject = (BaseFormsObject)jdapiobject;
            if(m_pd2fob == baseformsobject.m_pd2fob)
                flag = true;
        }
        return flag;
    }

    public JdapiObject clone(JdapiObject jdapiobject, String s)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        if(s == null)
            throw new JdapiException("Must pass in a valid name for cloned object");
        long l = 0L;
        if(jdapiobject == null)
            l = Jdapi.getContextPointer();
        else
            l = ((BaseFormsObject)jdapiobject).m_pd2fob;
        long l1 = BaseAPI._jni_replicate(Jdapi.getContextPointer(), l, m_pd2fob, s);
        JdapiObject jdapiobject1 = null;
        if(l1 != 0L)
            jdapiobject1 = Jdapi.getObject(l1);
        return jdapiobject1;
    }

    public void changeOwner(JdapiObject jdapiobject)
    {
        if(getModule() == ((BaseFormsObject)jdapiobject).getModule())
            setObjectProperty(JdapiTypes.OWNER_PTID, jdapiobject);
        else
            throw new JdapiException("Wrong owner type for this object");
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        try
        {
            if(m_pd2fob == 0L)
                stringbuffer.append("<Null Object Ptr>");
            else
            if(hasProperty(JdapiTypes.NAME_PTID))
                try
                {
                    stringbuffer.append(getStringProperty(JdapiTypes.NAME_PTID));
                }
                catch(JdapiException jdapiexception) { }
            else
                stringbuffer.append("<No Name Property>");
            stringbuffer.append('(');
            stringbuffer.append(getClass().getName());
            stringbuffer.append("@");
            stringbuffer.append(Integer.toHexString(hashCode()));
            stringbuffer.append(", ptr:");
            stringbuffer.append(BaseAPI.pointerToString(m_pd2fob));
            stringbuffer.append(", d2ffo:");
            stringbuffer.append(getTypeId());
            stringbuffer.append(", ctx:");
            stringbuffer.append(BaseAPI.pointerToString(Jdapi.getContextPointer()));
            stringbuffer.append(")");
        }
        catch(JdapiException jdapiexception1) { }
        return stringbuffer.toString();
    }

    protected void clearObjectPointer()
    {
        m_pd2fob = 0L;
    }

    public boolean isValidFormsObject()
    {
        return m_pd2fob != 0L;
    }

    public void destroy()
    {
        if(m_pd2fob == 0L)
        {
            throw new JdapiIllegalStateException("Null d2fob pointer");
        } else
        {
            BaseAPI._jni_destroy(Jdapi.getContextPointer(), m_pd2fob);
            clearObjectPointer();
            return;
        }
    }

    public void move(JdapiObject jdapiobject)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        long l = 0L;
        if(jdapiobject != null)
            l = ((BaseFormsObject)jdapiobject).m_pd2fob;
        BaseAPI._jni_move(Jdapi.getContextPointer(), m_pd2fob, l);
    }

    public boolean getBooleanProperty(int i)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        else
            return BaseAPI._jni_get_bool_prop(Jdapi.getContextPointer(), m_pd2fob, i);
    }

    public String getStringProperty(int i)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        else
            return BaseAPI._jni_get_text_prop(Jdapi.getContextPointer(), m_pd2fob, i);
    }

    public int getIntegerProperty(int i)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        else
            return BaseAPI._jni_get_num_prop(Jdapi.getContextPointer(), m_pd2fob, i);
    }

    public int getStringIDProperty(int i)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        if(!hasProperty(i))
            return 0;
        else
            return BaseAPI._jni_get_num_prop(Jdapi.getContextPointer(), m_pd2fob, i);
    }

    public String getPropertyValueName(int i, int j)
    {
        return BaseAPI._jni_get_prop_value_name(Jdapi.getContextPointer(), i, j);
    }

    public String getIntegerPropertyString(int i)
    {
        if(m_pd2fob == 0L)
        {
            throw new JdapiIllegalStateException("Null d2fob pointer");
        } else
        {
            int j = getIntegerProperty(i);
            return getPropertyValueName(i, j);
        }
    }

    protected long getObjProp(int i)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        else
            return BaseAPI._jni_get_obj_prop(Jdapi.getContextPointer(), m_pd2fob, i);
    }

    public JdapiObject getObjectProperty(int i)
    {
        long l = getObjProp(i);
        if(l == 0L)
            return null;
        else
            return Jdapi.getObjectCache().getObject(l);
    }

    public JdapiIterator getChildObjectProperty(int i)
    {
        Object obj = null;
        if(i == JdapiTypes.JDAPI_OLB_OBJECTS_PTID)
        {
            if(this instanceof ObjectLibrary)
                obj = new JdapiObjectLibraryObjectIterator((ObjectLibrary)this);
            else
                throw new JdapiException("ObjectLibrary only property");
        } else
        if(i == JdapiTypes.JDAPI_OLT_OBJECTS_PTID)
        {
            if(this instanceof ObjectLibraryTab)
                obj = new JdapiObjectLibraryTabObjectIterator((ObjectLibraryTab)this);
            else
                throw new JdapiException("ObjectLibraryTab only property");
        } else
        {
            JdapiObject jdapiobject = Jdapi.getObject(getObjProp(i));
            if(jdapiobject != null)
                obj = new JdapiObjectListIterator(jdapiobject);
        }
        return ((JdapiIterator) (obj));
    }

    public void setBooleanProperty(int i, boolean flag)
    {
        if(m_pd2fob == 0L)
        {
            throw new JdapiIllegalStateException("Null d2fob pointer");
        } else
        {
            BaseAPI._jni_set_bool_prop(Jdapi.getContextPointer(), m_pd2fob, i, flag);
            return;
        }
    }

    public void setStringProperty(int i, String s)
    {
        if(m_pd2fob == 0L)
        {
            throw new JdapiIllegalStateException("Null d2fob pointer");
        } else
        {
            BaseAPI._jni_set_text_prop(Jdapi.getContextPointer(), m_pd2fob, i, s);
            return;
        }
    }

    public void setIntegerProperty(int i, int j)
    {
        if(m_pd2fob == 0L)
        {
            throw new JdapiIllegalStateException("Null d2fob pointer");
        } else
        {
            BaseAPI._jni_set_num_prop(Jdapi.getContextPointer(), m_pd2fob, i, j);
            return;
        }
    }

    protected void setObjProp(int i, long l)
    {
        if(m_pd2fob == 0L)
        {
            throw new JdapiIllegalStateException("Null d2fob pointer");
        } else
        {
            BaseAPI._jni_set_obj_prop(Jdapi.getContextPointer(), m_pd2fob, i, l);
            return;
        }
    }

    public void setObjectProperty(int i, JdapiObject jdapiobject)
    {
        long l = 0L;
        if(jdapiobject != null)
        {
            if(!((BaseFormsObject)jdapiobject).isValidFormsObject())
                throw new JdapiIllegalStateException("Value has null d2fob pointer");
            l = ((BaseFormsObject)jdapiobject).m_pd2fob;
        }
        if(m_pd2fob == 0L)
        {
            throw new JdapiIllegalStateException("Null d2fob pointer");
        } else
        {
            setObjProp(i, l);
            return;
        }
    }

    public boolean hasProperty(int i)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        if(i == JdapiTypes.JDAPI_OLT_OBJECTS_PTID && (this instanceof ObjectLibraryTab))
            return true;
        if(i == JdapiTypes.JDAPI_OLB_OBJECTS_PTID && (this instanceof ObjectLibrary))
            return true;
        else
            return BaseAPI._jni_has_prop(Jdapi.getContextPointer(), m_pd2fob, i);
    }

    public void inheritProperty(int i)
    {
        if(m_pd2fob == 0L)
        {
            throw new JdapiIllegalStateException("Null d2fob pointer");
        } else
        {
            BaseAPI._jni_inherit_prop(Jdapi.getContextPointer(), m_pd2fob, i);
            return;
        }
    }

    public boolean hasInheritedProperty(int i)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        else
            return BaseAPI._jni_is_prop_inherited(Jdapi.getContextPointer(), m_pd2fob, i);
    }

    public boolean hasOverriddenProperty(int i)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        else
            return !BaseAPI._jni_is_prop_default(Jdapi.getContextPointer(), m_pd2fob, i);
    }

    public boolean hasDefaultedProperty(int i)
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        else
            return BaseAPI._jni_is_prop_default(Jdapi.getContextPointer(), m_pd2fob, i);
    }

    public int getPropertyState(int i)
    {
        byte byte0 = 0;
        if(hasInheritedProperty(i))
            byte0 = 3;
        else
        if(hasDefaultedProperty(i))
            byte0 = 1;
        else
        if(hasOverriddenProperty(i))
            if(isSubclassed())
                byte0 = 4;
            else
                byte0 = 2;
        return byte0;
    }

    public boolean isSubclassed()
    {
        if(m_pd2fob == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        else
            return BaseAPI._jni_is_subclassed(Jdapi.getContextPointer(), m_pd2fob);
    }

    public JdapiObject getSubclassParent()
    {
        if(!hasProperty(JdapiTypes.SOURCE_PTID))
            return null;
        else
            return getObjectProperty(JdapiTypes.SOURCE_PTID);
    }

    public void setSubclassParent(JdapiObject jdapiobject)
    {
        BaseAPI._jni_set_subclass_parent(Jdapi.getContextPointer(), getObjectPointer(), ((BaseFormsObject)jdapiobject).getObjectPointer());
    }

    public JdapiObject createSubclassedChild(JdapiObject jdapiobject, String s)
    {
        BaseFormsObject baseformsobject = (BaseFormsObject)clone(jdapiobject, s);
        BaseAPI._jni_set_subclass_parent(Jdapi.getContextPointer(), baseformsobject.getObjectPointer(), getObjectPointer());
        return baseformsobject;
    }

    public void reattach()
    {
        if(m_pd2fob == 0L)
        {
            throw new JdapiIllegalStateException("Null d2fob pointer");
        } else
        {
            BaseAPI._jni_reattach(Jdapi.getContextPointer(), m_pd2fob);
            return;
        }
    }

    public JdapiObject getModule()
    {
        return getObjectProperty(JdapiTypes.MODULE_PTID);
    }

    public JdapiObject getOwner()
    {
        return getObjectProperty(JdapiTypes.OWNER_PTID);
    }

    public JdapiIterator getOwnedObjects()
    {
        return new JdapiObjectChildIterator(this);
    }

    public String getName()
    {
        if(!hasProperty(JdapiTypes.NAME_PTID))
            return "<none>";
        else
            return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public String getClassName()
    {
        String s = getClass().getName();
        return s.substring(s.lastIndexOf('.') + 1);
    }

    public String getQualifiedName(boolean flag)
    {
        StringBuffer stringbuffer = new StringBuffer();
        BaseFormsObject baseformsobject = (BaseFormsObject)getOwner();
        if(baseformsobject != null && (flag || !(baseformsobject instanceof JdapiModule)))
        {
            stringbuffer.append(baseformsobject.getQualifiedName(flag));
            stringbuffer.append(".");
        }
        stringbuffer.append(getName());
        return stringbuffer.toString();
    }

    public JdapiMetaObject getJdapiMetaObject()
    {
        JdapiMetaObject jdapimetaobject = JdapiMetadata.getJdapiMetaObject(getClass());
        return jdapimetaobject;
    }

    public JdapiIterator getMetaProperties()
    {
        return getJdapiMetaObject().getMetaProperties();
    }

    protected transient long m_pd2fob;
    protected transient Object m_clientInfo;
}
