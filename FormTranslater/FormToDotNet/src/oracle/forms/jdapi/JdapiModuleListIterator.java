// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.util.Vector;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiModule, JdapiIllegalStateException, JdapiIterator, JdapiException

class JdapiModuleListIterator
    implements JdapiIterator
{

    public JdapiModuleListIterator(Vector vector)
    {
        m_current = -1;
        m_list = null;
        m_list = vector;
    }

    public JdapiModuleListIterator(JdapiModuleListIterator jdapimodulelistiterator)
    {
        m_current = -1;
        m_list = null;
        m_current = jdapimodulelistiterator.m_current;
        m_list = jdapimodulelistiterator.m_list;
    }

    public String toString()
    {
        String s = getClass().getName();
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(s.substring(s.lastIndexOf('.') + 1));
        stringbuffer.append("@");
        stringbuffer.append(Integer.toHexString(hashCode()));
        stringbuffer.append('(');
        stringbuffer.append("m_current:" + m_current);
        stringbuffer.append(", m_list.size:" + m_list.size());
        stringbuffer.append(')');
        return stringbuffer.toString();
    }

    public Object clone()
    {
        return new JdapiModuleListIterator(this);
    }

    public void goLast()
    {
        m_current = m_list.size();
    }

    public void goStart()
    {
        m_current = -1;
    }

    public boolean hasNext()
    {
        int i = m_list.size();
        return i > 0 && m_current < i - 1;
    }

    public boolean hasPrevious()
    {
        return m_current > 0;
    }

    public Object next()
    {
        if(!hasNext())
        {
            return null;
        } else
        {
            m_current++;
            return m_list.elementAt(m_current);
        }
    }

    public Object previous()
    {
        if(!hasPrevious())
        {
            return null;
        } else
        {
            m_current--;
            return m_list.elementAt(m_current);
        }
    }

    public void remove()
        throws JdapiException
    {
        if(hasNext())
        {
            JdapiModule jdapimodule = (JdapiModule)m_list.elementAt(m_current + 1);
            jdapimodule.destroy();
            jdapimodule = null;
        } else
        {
            throw new JdapiIllegalStateException("No current object to remove()");
        }
    }

    private transient int m_current;
    private transient Vector m_list;
}
