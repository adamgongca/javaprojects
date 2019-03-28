// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiIllegalStateException, Jdapi, BaseAPI, BaseFormsObject, 
//            JdapiModule, Graphics

public final class TranslationTable
    implements Iterator
{

    protected TranslationTable(JdapiModule jdapimodule)
    {
        m_Module = jdapimodule;
        getTranslations();
    }

    private void getTranslations()
    {
        m_langArray = BaseAPI._jni_trn_get_translations(Jdapi.getContextPointer(), getModulePointer());
        m_charSetArray = (int[])m_langArray.elementAt(0);
        m_langArray.removeElementAt(0);
    }

    public JdapiModule getModule()
    {
        return m_Module;
    }

    private long getModulePointer()
    {
        long l = m_Module.getObjectPointer();
        if(l == 0L)
            throw new JdapiIllegalStateException("Null d2fob pointer");
        else
            return l;
    }

    public int getCharacterSet(String s)
    {
        int i = m_langArray.indexOf(s);
        if(i == -1)
            throw new JdapiIllegalStateException("Unknown language: " + s);
        else
            return m_charSetArray[i];
    }

    public String getLanguageString(int i)
    {
        String s = null;
        for(int j = 0; j < m_charSetArray.length; j++)
            if(m_charSetArray[j] == i)
                s = (String)m_langArray.elementAt(j);

        return s;
    }

    public String getCurrentLanguageString()
    {
        Object aobj[] = BaseAPI._jni_trn_get_module_translations(Jdapi.getContextPointer(), getModulePointer());
        return (String)aobj[0];
    }

    public int addTranslation(String s, int i)
    {
        int j = BaseAPI._jni_trn_add_translation(Jdapi.getContextPointer(), getModulePointer(), s, i);
        getTranslations();
        return j;
    }

    public void deleteTranslation(String s)
    {
        int i = m_langArray.indexOf(s);
        if(i == -1)
            throw new JdapiIllegalStateException("Unknown language: " + s);
        BaseAPI._jni_trn_del_translation(Jdapi.getContextPointer(), getModulePointer(), i + 1);
        m_langArray.removeElementAt(i);
        if(i < m_position)
            m_position--;
        getTranslations();
    }

    public int getStringCount()
    {
        return BaseAPI._jni_trn_string_count(Jdapi.getContextPointer(), getModulePointer());
    }

    public boolean isStringInUse(int i)
    {
        return BaseAPI._jni_trn_string_in_use(Jdapi.getContextPointer(), getModulePointer(), i);
    }

    public String getString(String s, int i)
    {
        int j = m_langArray.indexOf(s);
        if(j == -1)
            throw new JdapiIllegalStateException("Unknown language: " + s);
        else
            return BaseAPI._jni_trn_get_string(Jdapi.getContextPointer(), getModulePointer(), j + 1, i);
    }

    public void setString(String s, int i, String s1)
    {
        int j = m_langArray.indexOf(s);
        if(j == -1)
        {
            throw new JdapiIllegalStateException("Unknown language: " + s);
        } else
        {
            BaseAPI._jni_trn_set_string(Jdapi.getContextPointer(), getModulePointer(), j + 1, i, s1);
            return;
        }
    }

    public int getStringPropertyNumber(int i)
    {
        int ai[] = BaseAPI._jni_trn_get_string_info(Jdapi.getContextPointer(), getModulePointer(), i);
        return ai[0];
    }

    public int getStringObjectType(int i)
    {
        int ai[] = BaseAPI._jni_trn_get_string_info(Jdapi.getContextPointer(), getModulePointer(), i);
        return ai[1];
    }

    public Class getStringObjectClass(int i)
    {
        return BaseAPI.getClass(getStringObjectType(i));
    }

    public boolean hasNext()
    {
        return m_position < m_langArray.size();
    }

    public Object next()
    {
        Object obj = null;
        if(m_position < m_langArray.size())
        {
            obj = m_langArray.elementAt(m_position);
            m_position++;
        }
        return obj;
    }

    public void goStart()
    {
        m_position = 0;
    }

    public void remove()
    {
        deleteTranslation((String)m_langArray.elementAt(m_position));
    }

    public void wrapTranslatedText(Graphics g, String s)
    {
        int i = m_langArray.indexOf(s);
        if(i == -1)
        {
            throw new JdapiIllegalStateException("Unknown language: " + s);
        } else
        {
            BaseAPI._jni_trn_wrap_translated_text(Jdapi.getContextPointer(), g.getObjectPointer(), i + 1);
            return;
        }
    }

    private JdapiModule m_Module;
    protected Vector m_langArray;
    protected int m_charSetArray[];
    private int m_position;
}
