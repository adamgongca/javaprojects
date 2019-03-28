// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.util.EventListener;

// Referenced classes of package oracle.forms.jdapi:
//            CacheEvent

interface CacheListener
    extends EventListener
{

    public abstract void cacheAdd(CacheEvent cacheevent);

    public abstract void cacheGet(CacheEvent cacheevent);

    public abstract void cacheRemove(CacheEvent cacheevent);
}
