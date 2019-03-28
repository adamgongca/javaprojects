// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            JdapiIterator, ObjectLibrary

class JdapiObjectLibraryObjectIterator
    implements JdapiIterator
{

    protected JdapiObjectLibraryObjectIterator(ObjectLibrary objectlibrary)
    {
        m_olb = null;
        m_position = 1;
        m_lastPosition = 0;
        m_olb = objectlibrary;
        m_lastPosition = m_olb.getObjectCount();
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
    {
        JdapiObject jdapiobject = null;
        if(hasNext())
        {
            jdapiobject = m_olb.findObjectByPosition(m_position);
            m_position++;
        }
        return jdapiobject;
    }

    public Object previous()
    {
        JdapiObject jdapiobject = null;
        if(hasPrevious())
        {
            m_position--;
            jdapiobject = m_olb.findObjectByPosition(m_position);
        }
        return jdapiobject;
    }

    public void remove()
    {
        JdapiObject jdapiobject = m_olb.findObjectByPosition(m_position);
        m_olb.removeObject(jdapiobject);
        m_lastPosition--;
    }

    ObjectLibrary m_olb;
    int m_position;
    int m_lastPosition;
}
