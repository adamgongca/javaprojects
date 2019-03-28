// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.util.Iterator;

public interface JdapiIterator
    extends Iterator
{

    public abstract void goLast();

    public abstract void goStart();

    public abstract boolean hasNext();

    public abstract boolean hasPrevious();

    public abstract Object next();

    public abstract Object previous();

    public abstract void remove();
}
