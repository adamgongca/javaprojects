// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.*;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiIllegalStateException, CacheEvent, BaseFormsObject, CacheListener, 
//            BaseAPI, JdapiTypes

class ContextCache
{

    protected ContextCache(long l)
    {
        m_pd2fctx = 0L;
        m_cache = new Hashtable();
        m_listeners = null;
        m_pd2fctx = l;
    }

    protected void addObject(BaseFormsObject baseformsobject)
    {
        long l = baseformsobject.getObjectPointer();
        if(l == 0L)
            throw new JdapiIllegalStateException("Tried to add illegal state object to context cache");
        if(m_listeners != null)
            processCacheEvent(new CacheEvent(this, 2500, baseformsobject));
        m_cache.put(new Long(l), baseformsobject);
    }

    protected BaseFormsObject getObject(long l)
    {
        BaseFormsObject baseformsobject = null;
        if(l != 0L)
        {
            Long long1 = new Long(l);
            baseformsobject = (BaseFormsObject)m_cache.get(long1);
            if(baseformsobject == null)
                baseformsobject = BaseAPI.createObject(m_pd2fctx, l);
            else
                baseformsobject = validateObject(baseformsobject);
        }
        if(m_listeners != null)
            processCacheEvent(new CacheEvent(this, 2501, baseformsobject));
        return baseformsobject;
    }

    protected BaseFormsObject getObject(long l, long l1)
    {
        BaseFormsObject baseformsobject = null;
        if(l != 0L)
        {
            Long long1 = new Long(l);
            baseformsobject = (BaseFormsObject)m_cache.get(long1);
            if(baseformsobject == null)
                baseformsobject = BaseAPI.createObject(l1, m_pd2fctx, l);
            else
                baseformsobject = validateObject(baseformsobject, l1);
        }
        if(m_listeners != null)
            processCacheEvent(new CacheEvent(this, 2501, baseformsobject));
        return baseformsobject;
    }

    protected BaseFormsObject getObject(long l, Constructor constructor)
    {
        BaseFormsObject baseformsobject = null;
        if(l != 0L)
        {
            Long long1 = new Long(l);
            baseformsobject = (BaseFormsObject)m_cache.get(long1);
            if(baseformsobject == null)
                baseformsobject = BaseAPI.createObject(constructor, m_pd2fctx, l);
            else
                baseformsobject = validateObject(baseformsobject);
        }
        if(m_listeners != null)
            processCacheEvent(new CacheEvent(this, 2501, baseformsobject));
        return baseformsobject;
    }

    private BaseFormsObject validateObject(BaseFormsObject baseformsobject, long l)
    {
        if((long)baseformsobject.getTypeId() != l)
        {
            if(m_listeners != null)
                processCacheEvent(new CacheEvent(this, 2503, baseformsobject));
            long l1 = baseformsobject.getObjectPointer();
            removeObject(l1);
            baseformsobject = BaseAPI.createObject(l, m_pd2fctx, l1);
        }
        return baseformsobject;
    }

    private BaseFormsObject validateObject(BaseFormsObject baseformsobject)
    {
        long l = BaseAPI._jni_query_type(m_pd2fctx, baseformsobject.getObjectPointer());
        return validateObject(baseformsobject, l);
    }

    protected void removeObject(long l)
    {
        if(l == 0L)
            throw new JdapiIllegalStateException("Tried to remove null (0) d2fob* from context cache");
        BaseFormsObject baseformsobject = (BaseFormsObject)m_cache.remove(new Long(l));
        if(m_listeners != null)
            processCacheEvent(new CacheEvent(this, 2502, baseformsobject));
        if(baseformsobject != null)
            baseformsobject.clearObjectPointer();
    }

    public void dump(PrintWriter printwriter)
    {
        if(printwriter != null)
        {
            printwriter.println("Dump of Context Cache (" + toString() + ")");
            BaseFormsObject baseformsobject;
            for(Enumeration enumeration = m_cache.elements(); enumeration.hasMoreElements(); printwriter.println("  " + baseformsobject.toString()))
                baseformsobject = (BaseFormsObject)enumeration.nextElement();

            printwriter.println("End of " + toString());
            printwriter.flush();
        }
    }

    public void purge(boolean flag)
    {
        for(Enumeration enumeration = m_cache.elements(); enumeration.hasMoreElements();)
        {
            BaseFormsObject baseformsobject = (BaseFormsObject)enumeration.nextElement();
            if(baseformsobject.isValidFormsObject())
                if(flag)
                    baseformsobject.destroy();
                else
                    removeObject(baseformsobject.getObjectPointer());
        }

    }

    public void purgeModules(boolean flag)
    {
        long l = -1L;
        for(Enumeration enumeration = m_cache.elements(); enumeration.hasMoreElements();)
        {
            BaseFormsObject baseformsobject = (BaseFormsObject)enumeration.nextElement();
            if(baseformsobject.isValidFormsObject())
            {
                long l1 = baseformsobject.getTypeId();
                if(l1 == (long)JdapiTypes.FORM_MODULE_OTID || l1 == (long)JdapiTypes.OBJECT_LIBRARY_OTID || l1 == (long)JdapiTypes.MENU_MODULE_OTID)
                    if(flag)
                        baseformsobject.destroy();
                    else
                        removeObject(baseformsobject.getObjectPointer());
            }
        }

    }

    public void addCacheListener(CacheListener cachelistener)
    {
        if(m_listeners == null)
            m_listeners = new Vector();
        if(!m_listeners.contains(cachelistener))
            m_listeners.addElement(cachelistener);
    }

    public void removeCacheListener(CacheListener cachelistener)
    {
        if(m_listeners != null)
        {
            m_listeners.removeElement(cachelistener);
            if(m_listeners.isEmpty())
                m_listeners = null;
        }
    }

    protected void processCacheEvent(CacheEvent cacheevent)
    {
        if(m_listeners != null)
        {
            Vector vector;
            synchronized(this)
            {
                vector = (Vector)m_listeners.clone();
            }
            int i = vector.size();
            int j = cacheevent.getId();
            for(int k = 0; k < i; k++)
            {
                CacheListener cachelistener = (CacheListener)vector.elementAt(k);
                switch(j)
                {
                case 2500: 
                    cachelistener.cacheAdd(cacheevent);
                    break;

                case 2501: 
                    cachelistener.cacheGet(cacheevent);
                    break;

                case 2502: 
                    cachelistener.cacheRemove(cacheevent);
                    break;
                }
            }

        }
    }

    protected transient long m_pd2fctx;
    private Hashtable m_cache;
    protected Vector m_listeners;
}
