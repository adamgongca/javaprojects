// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            JdapiException

public class Blob
{

    public Blob()
    {
        m_Count = 0;
        m_Buffer = new byte[0];
        m_Count = m_Buffer.length;
    }

    public Blob(String s)
        throws JdapiException
    {
        this(s.getBytes());
    }

    public Blob(byte abyte0[])
        throws JdapiException
    {
        m_Count = 0;
        setBytes(abyte0);
    }

    public byte[] getBytes()
    {
        return m_Buffer;
    }

    public void setBytes(byte abyte0[])
        throws JdapiException
    {
        m_Buffer = abyte0;
        m_Count = m_Buffer.length;
    }

    public int size()
    {
        return m_Count;
    }

    public String toString()
    {
        return new String(m_Buffer);
    }

    public boolean equals(Blob blob)
    {
        if(!blob.getClass().equals(oracle.forms.jdapi.Blob.class))
            return false;
        return m_Buffer.equals(blob.m_Buffer);
    }

    private byte m_Buffer[];
    private int m_Count;
}
