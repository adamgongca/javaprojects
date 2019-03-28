// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.util.Arrays;
import java.util.Vector;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiUnsupportedOperationException, JdapiIterator, JdapiMetaProperty

class JdapiAllPropertyIterator
    implements JdapiIterator
{

    JdapiAllPropertyIterator(JdapiMetaProperty ajdapimetaproperty[], JdapiMetaProperty ajdapimetaproperty1[], JdapiMetaProperty ajdapimetaproperty2[], JdapiMetaProperty ajdapimetaproperty3[], JdapiMetaProperty ajdapimetaproperty4[])
    {
        m_properties = new Vector();
        m_position = 0;
        m_properties.addAll(Arrays.asList(ajdapimetaproperty));
        m_properties.addAll(Arrays.asList(ajdapimetaproperty1));
        m_properties.addAll(Arrays.asList(ajdapimetaproperty2));
        m_properties.addAll(Arrays.asList(ajdapimetaproperty3));
        m_properties.addAll(Arrays.asList(ajdapimetaproperty4));
    }

    public void goLast()
    {
        m_position = m_properties.size();
    }

    public void goStart()
    {
        m_position = 0;
    }

    public boolean hasNext()
    {
        return m_position < m_properties.size();
    }

    public boolean hasPrevious()
    {
        return m_position > 0;
    }

    public Object next()
    {
        Object obj = null;
        if(m_position < m_properties.size())
            obj = m_properties.elementAt(m_position++);
        return obj;
    }

    public Object previous()
    {
        Object obj = null;
        if(m_position > 0)
            obj = m_properties.elementAt(--m_position);
        return obj;
    }

    public void remove()
    {
        throw new JdapiUnsupportedOperationException("Can't remove metaproperties");
    }

    private Vector m_properties;
    private int m_position;
}
