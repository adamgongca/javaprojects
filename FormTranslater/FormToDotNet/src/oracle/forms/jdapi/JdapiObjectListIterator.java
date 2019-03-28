// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, JdapiIllegalStateException, JdapiIterator, Jdapi, 
//            BaseAPI, JdapiTypes, JdapiObject

class JdapiObjectListIterator
    implements JdapiIterator
{

    public JdapiObjectListIterator(JdapiObject jdapiobject)
    {
        m_pd2fob = 0L;
        m_next = 0L;
        m_prev = 0L;
        m_d2ffox = 0L;
        m_removed = false;
        m_d2ffox = ((BaseFormsObject)jdapiobject).getTypeId();
        m_pd2fob = 0L;
        m_next = ((BaseFormsObject)jdapiobject).getObjectPointer();
    }

    protected JdapiObjectListIterator(long l, long l1, int i, long l2)
    {
        m_pd2fob = 0L;
        m_next = 0L;
        m_prev = 0L;
        m_d2ffox = 0L;
        m_removed = false;
        m_pd2fob = 0L;
        m_next = BaseAPI._jni_get_obj_prop(Jdapi.getContextPointer(), l1, i);
        m_d2ffox = l2;
    }

    protected JdapiObjectListIterator(long l, long l1, long l2)
    {
        m_pd2fob = 0L;
        m_next = 0L;
        m_prev = 0L;
        m_d2ffox = 0L;
        m_removed = false;
        m_pd2fob = 0L;
        m_next = l1;
        m_d2ffox = l2;
    }

    public JdapiObjectListIterator(JdapiObjectListIterator jdapiobjectlistiterator)
    {
        m_pd2fob = 0L;
        m_next = 0L;
        m_prev = 0L;
        m_d2ffox = 0L;
        m_removed = false;
        m_pd2fob = jdapiobjectlistiterator.m_pd2fob;
        m_next = jdapiobjectlistiterator.m_next;
        m_prev = jdapiobjectlistiterator.m_prev;
        m_removed = jdapiobjectlistiterator.m_removed;
        m_d2ffox = jdapiobjectlistiterator.m_d2ffox;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(getClass().getName());
        stringbuffer.append("@");
        stringbuffer.append(Long.toHexString(hashCode()));
        stringbuffer.append('(');
        stringbuffer.append("m_pd2fob:" + BaseAPI.pointerToString(m_pd2fob));
        stringbuffer.append(", m_next:" + BaseAPI.pointerToString(m_next));
        stringbuffer.append(", m_prev:" + BaseAPI.pointerToString(m_prev));
        stringbuffer.append(", m_d2ffox:" + m_d2ffox);
        stringbuffer.append(')');
        return stringbuffer.toString();
    }

    public Object clone()
    {
        return new JdapiObjectListIterator(this);
    }

    public void goLast()
    {
        for(; hasNext(); next());
    }

    public void goStart()
    {
        for(; hasPrevious(); previous());
    }

    public boolean hasMoreElements()
    {
        return hasNext();
    }

    public boolean hasNext()
    {
        boolean flag = false;
        if(m_next == 0L && m_pd2fob != 0L)
            m_next = BaseAPI._jni_get_obj_prop(Jdapi.getContextPointer(), m_pd2fob, JdapiTypes.NEXT_PTID);
        if(m_next != 0L)
            flag = true;
        return flag;
    }

    public boolean hasPrevious()
    {
        boolean flag = false;
        if(m_prev == 0L && m_pd2fob != 0L)
            m_prev = BaseAPI._jni_get_obj_prop(Jdapi.getContextPointer(), m_pd2fob, JdapiTypes.PREVIOUS_PTID);
        if(m_prev != 0L)
            flag = true;
        return flag;
    }

    public Object nextElement()
    {
        return next();
    }

    public Object next()
    {
        if(m_next != 0L)
        {
            m_prev = m_pd2fob;
            m_pd2fob = m_next;
            m_next = 0L;
        } else
        if(m_pd2fob != 0L)
        {
            m_prev = m_pd2fob;
            m_pd2fob = BaseAPI._jni_get_obj_prop(Jdapi.getContextPointer(), m_pd2fob, JdapiTypes.NEXT_PTID);
            m_next = 0L;
        }
        JdapiObject jdapiobject = null;
        if(m_pd2fob != 0L)
        {
            m_removed = false;
            jdapiobject = Jdapi.getObject(m_pd2fob);
        }
        return jdapiobject;
    }

    public Object previous()
    {
        if(m_prev != 0L)
        {
            m_next = m_pd2fob;
            m_pd2fob = m_prev;
            m_prev = 0L;
        } else
        if(m_pd2fob != 0L)
        {
            m_next = m_pd2fob;
            m_pd2fob = BaseAPI._jni_get_obj_prop(Jdapi.getContextPointer(), m_pd2fob, JdapiTypes.PREVIOUS_PTID);
            m_prev = 0L;
        }
        JdapiObject jdapiobject = null;
        if(m_pd2fob != 0L)
        {
            m_removed = false;
            jdapiobject = Jdapi.getObject(m_pd2fob);
        }
        return jdapiobject;
    }

    public void remove()
    {
        if(m_removed)
            throw new JdapiIllegalStateException("May only call remove() on an iteration once per object");
        if(m_pd2fob == 0L && hasNext())
            next();
        if(m_pd2fob != 0L)
        {
            if(m_next == 0L)
                m_next = BaseAPI._jni_get_obj_prop(Jdapi.getContextPointer(), m_pd2fob, JdapiTypes.NEXT_PTID);
            BaseAPI._jni_destroy(Jdapi.getContextPointer(), m_pd2fob);
            m_pd2fob = 0L;
            m_removed = true;
        } else
        {
            throw new JdapiIllegalStateException("No current object to remove()");
        }
    }

    private transient long m_pd2fob;
    private transient long m_next;
    private transient long m_prev;
    private transient long m_d2ffox;
    private transient boolean m_removed;
}
