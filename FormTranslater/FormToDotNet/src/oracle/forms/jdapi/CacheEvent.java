// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.util.EventObject;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiObject

class CacheEvent extends EventObject
{

    public CacheEvent(Object obj, int i, JdapiObject jdapiobject)
    {
        super(obj);
        m_bfo = null;
        m_id = i;
        m_bfo = jdapiobject;
    }

    public int getId()
    {
        return m_id;
    }

    public JdapiObject getFormsObject()
    {
        return m_bfo;
    }

    public static final int CACHE_FIRST = 2500;
    public static final int CACHE_LAST = 2503;
    public static final int CACHE_ADD = 2500;
    public static final int CACHE_GET = 2501;
    public static final int CACHE_REMOVE = 2502;
    public static final int CACHE_INVALID = 2503;
    protected int m_id;
    protected JdapiObject m_bfo;
}
