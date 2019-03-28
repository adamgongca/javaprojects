// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            JdapiException

public class JdapiIllegalStateException extends JdapiException
{

    public JdapiIllegalStateException()
    {
    }

    public JdapiIllegalStateException(String s)
    {
        super(s);
    }

    public JdapiIllegalStateException(Throwable throwable)
    {
        super(throwable.getMessage());
    }
}
