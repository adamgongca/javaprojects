// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;

import java.io.Serializable;

// Referenced classes of package oracle.forms.jdapi:
//            JdapiIterator, Blob, JdapiMetaObject

public interface JdapiObject
{

    public abstract void destroy();

    public abstract JdapiObject clone(JdapiObject jdapiobject, String s);

    public abstract void move(JdapiObject jdapiobject);

    public abstract int getTypeId();

    public abstract int queryType();

    public abstract String getClassName();

    public abstract String getName();

    public abstract String getQualifiedName(boolean flag);

    public abstract JdapiObject getModule();

    public abstract boolean equals(JdapiObject jdapiobject);

    public abstract JdapiObject getOwner();

    public abstract void changeOwner(JdapiObject jdapiobject);

    public abstract JdapiIterator getOwnedObjects();

    public abstract void setClientInfo(Object obj);

    public abstract Object getClientInfo();

    public abstract Blob getPersistentClientInfoBlob();

    public abstract Object getPersistentClientInfoObject();

    public abstract void setPersistentClientInfo(Blob blob);

    public abstract void setPersistentClientInfo(Serializable serializable);

    public abstract boolean isValidFormsObject();

    public abstract String toString();

    public abstract boolean getBooleanProperty(int i);

    public abstract int getIntegerProperty(int i);

    public abstract String getStringProperty(int i);

    public abstract int getStringIDProperty(int i);

    public abstract JdapiObject getObjectProperty(int i);

    public abstract JdapiIterator getChildObjectProperty(int i);

    public abstract void setBooleanProperty(int i, boolean flag);

    public abstract void setIntegerProperty(int i, int j);

    public abstract void setStringProperty(int i, String s);

    public abstract void setObjectProperty(int i, JdapiObject jdapiobject);

    public abstract boolean hasProperty(int i);

    public abstract boolean isSubclassed();

    public abstract JdapiObject getSubclassParent();

    public abstract void setSubclassParent(JdapiObject jdapiobject);

    public abstract JdapiObject createSubclassedChild(JdapiObject jdapiobject, String s);

    public abstract void reattach();

    public abstract boolean hasOverriddenProperty(int i);

    public abstract boolean hasInheritedProperty(int i);

    public abstract boolean hasDefaultedProperty(int i);

    public abstract int getPropertyState(int i);

    public abstract String getPropertyValueName(int i, int j);

    public abstract String getIntegerPropertyString(int i);

    public abstract void inheritProperty(int i);

    public abstract JdapiMetaObject getJdapiMetaObject();

    public abstract JdapiIterator getMetaProperties();

    public static final int PROPERTY_STATE_UNKNOWN = 0;
    public static final int PROPERTY_DEFAULT_VALUE = 1;
    public static final int PROPERTY_OVERRIDDEN_DEFAULT_VALUE = 2;
    public static final int PROPERTY_INHERITED_VALUE = 3;
    public static final int PROPERTY_OVERRIDDEN_INHERITED_VALUE = 4;
}
