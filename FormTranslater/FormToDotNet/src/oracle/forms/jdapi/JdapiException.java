// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


public class JdapiException extends RuntimeException
{

    public JdapiException()
    {
    }

    public JdapiException(String s)
    {
        super(s);
    }

    public JdapiException(Throwable throwable)
    {
        super(throwable.getMessage());
    }
}
