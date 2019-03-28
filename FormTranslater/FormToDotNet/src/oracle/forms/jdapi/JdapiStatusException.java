// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            JdapiException

public class JdapiStatusException extends JdapiException
{

    public JdapiStatusException(String s, int i)
    {
        super(s);
        m_status = i;
    }

    public int getStatusCode()
    {
        return m_status;
    }

    private int m_status;
}
