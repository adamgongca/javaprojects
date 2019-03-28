// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            JdapiIterator, JdapiException, ObjectLibraryTab

class JdapiObjectLibraryTabObjectIterator
    implements JdapiIterator
{

    protected JdapiObjectLibraryTabObjectIterator(ObjectLibraryTab objectlibrarytab)
        throws JdapiException
    {
        m_olt = null;
        m_position = 1;
        m_lastPosition = 0;
        m_olt = objectlibrarytab;
        m_lastPosition = m_olt.getObjectCount();
    }

    public void goLast()
    {
        m_position = m_lastPosition;
    }

    public void goStart()
    {
        m_position = 1;
    }

    public boolean hasNext()
    {
        return m_position <= m_lastPosition;
    }

    public boolean hasPrevious()
    {
        return m_position > 1;
    }

    public Object next()
        throws JdapiException
    {
        JdapiObject jdapiobject = null;
        if(hasNext())
        {
            jdapiobject = m_olt.findObjectByPosition(m_position);
            m_position++;
        }
        return jdapiobject;
    }

    public Object previous()
        throws JdapiException
    {
        JdapiObject jdapiobject = null;
        if(hasPrevious())
        {
            m_position--;
            jdapiobject = m_olt.findObjectByPosition(m_position);
        }
        return jdapiobject;
    }

    public void remove()
        throws JdapiException
    {
        JdapiObject jdapiobject = m_olt.findObjectByPosition(m_position);
        m_olt.removeObject(jdapiobject);
        m_lastPosition--;
    }

    ObjectLibraryTab m_olt;
    int m_position;
    int m_lastPosition;
}
