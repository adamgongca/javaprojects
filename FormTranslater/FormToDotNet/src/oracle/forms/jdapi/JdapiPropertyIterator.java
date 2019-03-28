// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            JdapiUnsupportedOperationException, JdapiIterator, JdapiMetaProperty

class JdapiPropertyIterator
    implements JdapiIterator
{

    JdapiPropertyIterator(JdapiMetaProperty ajdapimetaproperty[])
    {
        m_Properties = null;
        m_position = 0;
        m_propCount = 0;
        m_Properties = ajdapimetaproperty;
        m_propCount = ajdapimetaproperty.length;
    }

    public void goLast()
    {
        m_position = m_propCount - 1;
    }

    public void goStart()
    {
        m_position = 0;
    }

    public boolean hasNext()
    {
        return m_position <= m_propCount - 1;
    }

    public boolean hasPrevious()
    {
        return m_position > 0;
    }

    public Object next()
    {
        JdapiMetaProperty jdapimetaproperty = null;
        if(m_position <= m_propCount - 1)
            jdapimetaproperty = m_Properties[m_position++];
        return jdapimetaproperty;
    }

    public Object previous()
    {
        JdapiMetaProperty jdapimetaproperty = null;
        if(m_position > 0)
            jdapimetaproperty = m_Properties[--m_position];
        return jdapimetaproperty;
    }

    public void remove()
    {
        throw new JdapiUnsupportedOperationException("Can't remove metaproperties");
    }

    protected JdapiMetaProperty m_Properties[];
    private int m_position;
    private int m_propCount;
}
