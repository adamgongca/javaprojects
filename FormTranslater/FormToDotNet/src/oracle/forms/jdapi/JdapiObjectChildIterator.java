// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.util.Vector;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiMetaProperty, JdapiObject, JdapiUnsupportedOperationException, JdapiIterator, 
//            JdapiMetadata, JdapiMetaObject

class JdapiObjectChildIterator
    implements JdapiIterator
{

    JdapiObjectChildIterator(JdapiObject jdapiobject)
    {
        m_children = new Vector();
        m_position = 0;
        JdapiMetaObject jdapimetaobject = JdapiMetadata.getJdapiMetaObject(jdapiobject.getClass());
        for(JdapiIterator jdapiiterator = jdapimetaobject.getChildObjectMetaProperties(); jdapiiterator.hasNext();)
        {
            JdapiMetaProperty jdapimetaproperty = (JdapiMetaProperty)jdapiiterator.next();
            int i = jdapimetaproperty.getPropertyId();
            if(jdapimetaproperty.allowGet())
            {
                JdapiIterator jdapiiterator1 = jdapiobject.getChildObjectProperty(i);
                if(jdapiiterator1 != null)
                {
                    JdapiObject jdapiobject1;
                    for(; jdapiiterator1.hasNext(); m_children.add(jdapiobject1))
                        jdapiobject1 = (JdapiObject)jdapiiterator1.next();

                }
            }
        }

    }

    public void goLast()
    {
        m_position = m_children.size();
    }

    public void goStart()
    {
        m_position = 0;
    }

    public boolean hasNext()
    {
        return m_position < m_children.size();
    }

    public boolean hasPrevious()
    {
        return m_position > 0;
    }

    public Object next()
    {
        Object obj = null;
        if(m_position < m_children.size())
            obj = m_children.elementAt(m_position++);
        return obj;
    }

    public Object previous()
    {
        Object obj = null;
        if(m_position > 0)
            obj = m_children.elementAt(--m_position);
        return obj;
    }

    public void remove()
    {
        throw new JdapiUnsupportedOperationException("Can't remove metaproperties");
    }

    protected Vector m_children;
    private int m_position;
}
