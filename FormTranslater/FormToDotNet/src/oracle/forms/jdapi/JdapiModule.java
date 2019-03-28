// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.io.File;

// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, JdapiException, Jdapi, BaseAPI, 
//            FormModule, ObjectLibrary, MenuModule, PlsqlModule

public abstract class JdapiModule extends BaseFormsObject
{

    protected JdapiModule(long l)
    {
        super(l);
        m_filePath = null;
        Jdapi.addModule(this);
    }

    public String getAbsolutePath()
    {
        return m_filePath;
    }

    protected void setAbsolutePath(String s)
    {
        m_filePath = s;
    }

    public static long getModulesProductVersion(String s)
    {
        File file = new File(s);
        if(!file.exists())
            throw new JdapiException("'" + file.getAbsolutePath() + "' not found");
        int i = s.lastIndexOf('.');
        if(i == -1)
            throw new JdapiException("'" + s + "' does not have an extension");
        String s1 = s.substring(i + 1).toLowerCase();
        Object obj = null;
        if(s1.equals("fmb"))
            return (long)BaseAPI._jni_get_form_version(Jdapi.getContextPointer(), s);
        if(s1.equals("olb"))
            return (long)BaseAPI._jni_get_objlib_version(Jdapi.getContextPointer(), s);
        if(s1.equals("mmb"))
            return (long)BaseAPI._jni_get_menu_version(Jdapi.getContextPointer(), s);
        else
            return -1L;
    }

    public static JdapiModule openModule(String s)
    {
        return openModule(new File(s), null);
    }

    public static JdapiModule openModule(File file)
    {
        return openModule(file, null);
    }

    public static JdapiModule openModule(String s, String s1)
    {
        return openModule(new File(s), s1);
    }

    public static JdapiModule openModule(File file, String s)
    {
        String s1 = file.getName();
        int i = s1.lastIndexOf('.');
        if(i == -1)
            throw new JdapiException("'" + s1 + "' does not have an extension");
        String s2 = s1.substring(i + 1).toLowerCase();
        Object obj = null;
        if(s2.equals("fmb"))
            obj = FormModule.open(file, s);
        else
        if(s2.equals("olb"))
            obj = ObjectLibrary.open(file, s);
        else
        if(s2.equals("mmb"))
            obj = MenuModule.open(file, s);
        else
        if(s2.equals("pll"))
            obj = PlsqlModule.open(file, s);
        else
            throw new JdapiException("'" + s1 + "' does not have a valid Forms extension");
        return ((JdapiModule) (obj));
    }

    public abstract void save(String s);

    public abstract void compile();

    public void destroy()
    {
        Jdapi.removeModule(this);
        super.destroy();
    }

    private String m_filePath;
}
