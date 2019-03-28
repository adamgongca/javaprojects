// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            JdapiAllPropertyIterator, JdapiPropertyIterator, JdapiMetaProperty, JdapiIterator

public class JdapiMetaObject
{

    JdapiMetaObject(String s, JdapiMetaProperty ajdapimetaproperty[], JdapiMetaProperty ajdapimetaproperty1[], JdapiMetaProperty ajdapimetaproperty2[], JdapiMetaProperty ajdapimetaproperty3[], JdapiMetaProperty ajdapimetaproperty4[], Class aclass[])
    {
        m_className = s;
        m_stringProperties = ajdapimetaproperty;
        m_booleanProperties = ajdapimetaproperty1;
        m_integerProperties = ajdapimetaproperty2;
        m_objectProperties = ajdapimetaproperty3;
        m_childObjectProperties = ajdapimetaproperty4;
        m_parentClasses = aclass;
    }

    public String getClassName()
    {
        return m_className;
    }

    public JdapiIterator getMetaProperties()
    {
        return new JdapiAllPropertyIterator(m_stringProperties, m_booleanProperties, m_integerProperties, m_objectProperties, m_childObjectProperties);
    }

    public JdapiIterator getStringMetaProperties()
    {
        return new JdapiPropertyIterator(m_stringProperties);
    }

    public JdapiIterator getBooleanMetaProperties()
    {
        return new JdapiPropertyIterator(m_booleanProperties);
    }

    public JdapiIterator getIntegerMetaProperties()
    {
        return new JdapiPropertyIterator(m_integerProperties);
    }

    public JdapiIterator getObjectMetaProperties()
    {
        return new JdapiPropertyIterator(m_objectProperties);
    }

    public JdapiIterator getChildObjectMetaProperties()
    {
        return new JdapiPropertyIterator(m_childObjectProperties);
    }

    public JdapiMetaProperty getStringMetaProperty(int i)
    {
        return getMetaProperty(m_stringProperties, i);
    }

    public JdapiMetaProperty getIntegerMetaProperty(int i)
    {
        return getMetaProperty(m_integerProperties, i);
    }

    public JdapiMetaProperty getBooleanMetaProperty(int i)
    {
        return getMetaProperty(m_booleanProperties, i);
    }

    public JdapiMetaProperty getObjectMetaProperty(int i)
    {
        return getMetaProperty(m_objectProperties, i);
    }

    public JdapiMetaProperty getChildObjectMetaProperty(int i)
    {
        return getMetaProperty(m_childObjectProperties, i);
    }

    public JdapiMetaProperty getMetaProperty(int i)
    {
        JdapiMetaProperty jdapimetaproperty = null;
        jdapimetaproperty = getStringMetaProperty(i);
        if(jdapimetaproperty == null)
            jdapimetaproperty = getIntegerMetaProperty(i);
        if(jdapimetaproperty == null)
            jdapimetaproperty = getBooleanMetaProperty(i);
        if(jdapimetaproperty == null)
            jdapimetaproperty = getObjectMetaProperty(i);
        if(jdapimetaproperty == null)
            jdapimetaproperty = getChildObjectMetaProperty(i);
        return jdapimetaproperty;
    }

    private JdapiMetaProperty getMetaProperty(JdapiMetaProperty ajdapimetaproperty[], int i)
    {
        JdapiMetaProperty jdapimetaproperty = null;
        for(int j = 0; j < ajdapimetaproperty.length; j++)
        {
            if(ajdapimetaproperty[j].getPropertyId() != i)
                continue;
            jdapimetaproperty = ajdapimetaproperty[j];
            break;
        }

        return jdapimetaproperty;
    }

    public Class[] getParentClasses()
    {
        return m_parentClasses;
    }

    final String m_className;
    final JdapiMetaProperty m_stringProperties[];
    final JdapiMetaProperty m_booleanProperties[];
    final JdapiMetaProperty m_integerProperties[];
    final JdapiMetaProperty m_objectProperties[];
    final JdapiMetaProperty m_childObjectProperties[];
    final Class m_parentClasses[];
}
