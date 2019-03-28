// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.io.File;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiModule, JdapiException, JdapiUnsupportedOperationException, JdapiObjectListIterator, 
//            Jdapi, JdapiIterator, BaseAPI, BaseFormsObject, 
//            JdapiTypes

public class PlsqlModule extends JdapiModule
{

    public int getTypeId()
    {
        return s_foType;
    }

    protected PlsqlModule(long l)
    {
        super(l);
    }

    public static PlsqlModule open(String s)
    {
        return open(new File(s), null);
    }

    public static PlsqlModule open(File file)
    {
        return open(file, null);
    }

    public static PlsqlModule open(String s, String s1)
    {
        return open(new File(s), s1);
    }

    public static PlsqlModule open(File file, String s)
    {
        for(JdapiIterator jdapiiterator = Jdapi.getModules(); jdapiiterator.hasNext();)
        {
            JdapiModule jdapimodule = (JdapiModule)jdapiiterator.next();
            String s1 = jdapimodule.getAbsolutePath();
            if(s1 != null && s1.equals(file.getAbsolutePath()))
                return (PlsqlModule)jdapimodule;
        }

        if(!file.exists())
        {
            throw new JdapiException("'" + file.getAbsolutePath() + "' not found");
        } else
        {
            PlsqlModule plsqlmodule = BaseAPI._jni_load_plsqllib(Jdapi.getContextPointer(), file.getAbsolutePath(), s);
            plsqlmodule.setAbsolutePath(file.getAbsolutePath());
            return plsqlmodule;
        }
    }

    public void save(String s)
    {
        throw new JdapiUnsupportedOperationException("This module type does not currently support saving to filesystem");
    }

    public void compile()
    {
        throw new JdapiUnsupportedOperationException("This module type does not currently support compilation");
    }

    public PlsqlModule clone(String s)
    {
        return (PlsqlModule)super.clone(null, s);
    }

    public static PlsqlModule find(String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), Jdapi.getContextPointer(), s, s_foType);
        PlsqlModule plsqlmodule = null;
        if(l1 != 0L)
            plsqlmodule = (PlsqlModule)Jdapi.getObject(l1);
        return plsqlmodule;
    }

    public String getLibraryLocation()
    {
        return getStringProperty(JdapiTypes.LIBRARY_LOCATION_PTID);
    }

    public int getLibrarySource()
    {
        return getIntegerProperty(JdapiTypes.LIBRARY_SOURCE_PTID);
    }

    public JdapiIterator getAttachedLibraries()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.ATTACHMENT_LIBRARY_PTID, JdapiTypes.ATTACHMENT_LIBRARY_OTID);
    }

    public JdapiIterator getProgramUnits()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return new JdapiObjectListIterator(Jdapi.getContextPointer(), super.m_pd2fob, JdapiTypes.LIBRARY_PROGRAM_UNIT_PTID, JdapiTypes.PROGRAM_UNIT_OTID);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.LIBRARY_MODULE_OTID;
    }
}
