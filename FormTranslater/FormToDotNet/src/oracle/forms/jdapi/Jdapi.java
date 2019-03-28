// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.io.PrintWriter;
import java.util.*;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiUnsupportedOperationException, ContextCache, JdapiObject, JdapiIllegalStateException, 
//            JdapiModuleListIterator, BaseAPI, JdapiModule, JdapiTypes, 
//            JdapiIterator, BaseFormsObject, CacheListener

public class Jdapi
{

    private Jdapi()
    {
    }

    public static void startup(boolean flag, boolean flag1, boolean flag2)
    {
        if(s_pd2fctx == 0L)
        {
            s_clientData = flag;
            s_noDecode = flag1;
            s_transMode = flag2;
            initialize(flag, flag1, flag2);
        } else
        {
            throw new JdapiUnsupportedOperationException("Jdapi session already initialised");
        }
    }

    public static void shutdown()
    {
        if(s_pd2fctx != 0L)
        {
            destroyAllModules();
            s_clientData = s_noDecode = s_transMode = false;
            BaseAPI._jni_finalize(s_pd2fctx);
            s_pd2fctx = 0L;
        }
    }

    public static Object getClientContext()
    {
        return s_ClientContext;
    }

    public static void setClientContext(Object obj)
    {
        s_ClientContext = obj;
    }

    protected static void initialize(boolean flag, boolean flag1, boolean flag2)
    {
        s_pd2fctx = BaseAPI._jni_initialize(flag, flag1, flag2);
        s_objectCache = new ContextCache(getContextPointer());
    }

    protected static long getContextPointer()
    {
        if(s_pd2fctx == 0L)
            initialize(false, false, false);
        return s_pd2fctx;
    }

    public static void connectToDatabase(String s)
    {
        BaseAPI._jni_connect(getContextPointer(), s);
        s_connected = true;
    }

    public static boolean isConnectedToDatabase()
    {
        return s_connected;
    }

    public static void disconnectFromDatabase()
    {
        BaseAPI._jni_disconnect(getContextPointer());
        s_connected = false;
    }

    public static void setFailLibraryLoad(boolean flag)
    {
        BaseAPI.setFailLibraryLoad(flag);
    }

    public static void setFailSubclassLoad(boolean flag)
    {
        BaseAPI.setFailSubclassLoad(flag);
    }

    public static String[] getSubclassingDependencies(String s)
    {
        String as[] = null;
        boolean flag = BaseAPI.isSubclassFlagSet();
        BaseAPI.setFailSubclassLoad(false);
        try
        {
            JdapiModule jdapimodule = JdapiModule.openModule(s);
            as = getSubclassingDependencies(((JdapiObject) (jdapimodule)));
            jdapimodule.destroy();
        }
        finally
        {
            BaseAPI.setFailSubclassLoad(flag);
        }
        return as;
    }

    public static String[] getSubclassingDependencies(JdapiObject jdapiobject)
    {
        String as[] = null;
        HashSet hashset = new HashSet();
        getSubclassingDependencies(hashset, jdapiobject);
        as = new String[hashset.size()];
        int i = 0;
        for(Iterator iterator = hashset.iterator(); iterator.hasNext();)
        {
            as[i] = (String)iterator.next();
            i++;
        }

        return as;
    }

    private static void getSubclassingDependencies(HashSet hashset, JdapiObject jdapiobject)
    {
        if(jdapiobject.hasProperty(JdapiTypes.PARENT_FILENAME_PTID))
        {
            String s = jdapiobject.getStringProperty(JdapiTypes.PARENT_FILENAME_PTID);
            if(s.length() > 0)
            {
                if(s.lastIndexOf('.') == -1)
                {
                    StringBuffer stringbuffer = new StringBuffer(s);
                    int i = jdapiobject.getIntegerProperty(JdapiTypes.PARENT_MODULETYPE_PTID);
                    if(i == JdapiTypes.FORM_MODULE_OTID)
                        stringbuffer.append(".fmb");
                    else
                    if(i == JdapiTypes.MENU_MODULE_OTID)
                        stringbuffer.append(".mmb");
                    else
                    if(i == JdapiTypes.OBJECT_LIBRARY_OTID)
                        stringbuffer.append(".olb");
                    else
                        throw new IllegalStateException(i + " is not a recognized module type for '" + s + "'");
                    s = stringbuffer.toString();
                }
                hashset.add(s);
            }
        }
        for(JdapiIterator jdapiiterator = jdapiobject.getOwnedObjects(); jdapiiterator.hasNext(); getSubclassingDependencies(hashset, (JdapiObject)jdapiiterator.next()));
    }

    public static long getProductVersion()
    {
        return (long)BaseAPI._jni_builder_version(getContextPointer());
    }

    public static Hashtable getBuiltIns()
    {
        return BaseAPI._jni_get_built_ins(getContextPointer());
    }

    protected static JdapiObject getObject(long l)
    {
        return s_objectCache.getObject(l);
    }

    protected static void addObject(BaseFormsObject baseformsobject)
    {
        s_objectCache.addObject(baseformsobject);
    }

    private static void removeObject(long l)
    {
        s_objectCache.removeObject(l);
    }

    static void addModule(JdapiModule jdapimodule)
    {
        s_moduleList.addElement(jdapimodule);
    }

    static void removeModule(JdapiModule jdapimodule)
    {
        if(!s_moduleList.removeElement(jdapimodule))
            throw new JdapiIllegalStateException("'" + jdapimodule.getName() + "' cannot be remove from module list as it is not in!");
        else
            return;
    }

    public static JdapiIterator getModules()
    {
        return new JdapiModuleListIterator(s_moduleList);
    }

    public static void destroyAllModules()
    {
        for(JdapiIterator jdapiiterator = getModules(); jdapiiterator.hasNext(); jdapiiterator.remove());
    }

    protected static ContextCache getObjectCache()
    {
        return s_objectCache;
    }

    protected static void dumpContextCache(PrintWriter printwriter)
    {
        s_objectCache.dump(printwriter);
    }

    protected static void purgeContextCache(boolean flag)
    {
        s_objectCache.purge(flag);
    }

    protected static void purgeContextCacheModules(boolean flag)
    {
        s_objectCache.purgeModules(flag);
    }

    protected static void addCacheListener(CacheListener cachelistener)
    {
        s_objectCache.addCacheListener(cachelistener);
    }

    protected static void removeCacheListener(CacheListener cachelistener)
    {
        s_objectCache.removeCacheListener(cachelistener);
    }

    private static long s_pd2fctx;
    static boolean s_clientData = false;
    static boolean s_noDecode = false;
    static boolean s_transMode = false;
    private static boolean s_connected = false;
    private static ContextCache s_objectCache = null;
    private static Vector s_moduleList = new Vector();
    private static Object s_ClientContext = null;

    static 
    {
        System.loadLibrary("frmjapi");
    }
}
