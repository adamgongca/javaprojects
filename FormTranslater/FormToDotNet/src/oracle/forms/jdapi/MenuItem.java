// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.jdapi;


// Referenced classes of package oracle.forms.jdapi:
//            BaseFormsObject, JdapiException, VisualAttribute, Jdapi, 
//            BaseAPI, JdapiTypes, Menu, PropertyClass, 
//            ObjectLibrary, ObjectLibraryTab, JdapiObject

public class MenuItem extends BaseFormsObject
{

    public int getTypeId()
    {
        return s_foType;
    }

    public MenuItem(Menu menu, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), menu.getObjectPointer(), s_foType, s, 0L, 0L);
        Jdapi.addObject(this);
    }

    public MenuItem(Menu menu, String s, MenuItem menuitem)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), menu.getObjectPointer(), s_foType, s, 0L, menuitem.getObjectPointer());
        Jdapi.addObject(this);
    }

    public MenuItem(Menu menu, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), menu.getObjectPointer(), s_foType, s, 0L, propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    public MenuItem(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), 0L);
        Jdapi.addObject(this);
    }

    public MenuItem(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, MenuItem menuitem)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), menuitem.getObjectPointer());
        Jdapi.addObject(this);
    }

    public MenuItem(ObjectLibrary objectlibrary, ObjectLibraryTab objectlibrarytab, String s, PropertyClass propertyclass)
    {
        super(0L);
        super.m_pd2fob = BaseAPI._jni_create_object(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s_foType, s, objectlibrary.getObjectPointer(), propertyclass.getObjectPointer());
        Jdapi.addObject(this);
    }

    protected MenuItem(long l)
    {
        super(l);
    }

    public MenuItem clone(Menu menu, String s)
    {
        return (MenuItem)super.clone(menu, s);
    }

    public MenuItem clone(ObjectLibraryTab objectlibrarytab, String s)
    {
        return (MenuItem)super.clone(objectlibrarytab, s);
    }

    public static MenuItem find(Menu menu, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), menu.getObjectPointer(), s, s_foType);
        MenuItem menuitem = null;
        if(l1 != 0L)
            menuitem = (MenuItem)Jdapi.getObject(l1);
        return menuitem;
    }

    public static MenuItem find(ObjectLibraryTab objectlibrarytab, String s)
    {
        long l = Jdapi.getContextPointer();
        long l1 = BaseAPI._jni_find_obj(Jdapi.getContextPointer(), objectlibrarytab.getObjectPointer(), s, s_foType);
        MenuItem menuitem = null;
        if(l1 != 0L)
            menuitem = (MenuItem)Jdapi.getObject(l1);
        return menuitem;
    }

    public void addRole(int i, String s)
    {
        BaseAPI._jni_mni_add_role(Jdapi.getContextPointer(), super.m_pd2fob, i, s);
    }

    public void removeRole(int i)
    {
        BaseAPI._jni_mni_remove_role(Jdapi.getContextPointer(), super.m_pd2fob, i);
    }

    public String getRole(int i)
    {
        return BaseAPI._jni_mni_get_role(Jdapi.getContextPointer(), super.m_pd2fob, i);
    }

    public String getCommandText()
    {
        return getStringProperty(JdapiTypes.COMMAND_TEXT_PTID);
    }

    public void setCommandText(String s)
    {
        setStringProperty(JdapiTypes.COMMAND_TEXT_PTID, s);
    }

    public String getComment()
    {
        return getStringProperty(JdapiTypes.COMMENT_PTID);
    }

    public void setComment(String s)
    {
        setStringProperty(JdapiTypes.COMMENT_PTID, s);
    }

    public String getFontName()
    {
        return getStringProperty(JdapiTypes.FONT_NAME_PTID);
    }

    public void setFontName(String s)
    {
        setStringProperty(JdapiTypes.FONT_NAME_PTID, s);
    }

    public String getHint()
    {
        return getStringProperty(JdapiTypes.HINT_PTID);
    }

    public void setHint(String s)
    {
        setStringProperty(JdapiTypes.HINT_PTID, s);
    }

    public String getIconFilename()
    {
        return getStringProperty(JdapiTypes.ICON_FILENAME_PTID);
    }

    public void setIconFilename(String s)
    {
        setStringProperty(JdapiTypes.ICON_FILENAME_PTID, s);
    }

    public String getKeyboardAccelerator()
    {
        return getStringProperty(JdapiTypes.KEYBOARD_ACCELERATOR_PTID);
    }

    public void setKeyboardAccelerator(String s)
    {
        setStringProperty(JdapiTypes.KEYBOARD_ACCELERATOR_PTID, s);
    }

    public String getLabel()
    {
        return getStringProperty(JdapiTypes.LABEL_PTID);
    }

    public void setLabel(String s)
    {
        setStringProperty(JdapiTypes.LABEL_PTID, s);
    }

    public String getMenuItemCode()
    {
        return getStringProperty(JdapiTypes.MENU_ITEM_CODE_PTID);
    }

    public void setMenuItemCode(String s)
    {
        setStringProperty(JdapiTypes.MENU_ITEM_CODE_PTID, s);
    }

    public String getMenuItemRadioGroup()
    {
        return getStringProperty(JdapiTypes.MENU_ITEM_RADIO_GROUP_PTID);
    }

    public void setMenuItemRadioGroup(String s)
    {
        setStringProperty(JdapiTypes.MENU_ITEM_RADIO_GROUP_PTID, s);
    }

    public String getName()
    {
        return getStringProperty(JdapiTypes.NAME_PTID);
    }

    public void setName(String s)
    {
        setStringProperty(JdapiTypes.NAME_PTID, s);
    }

    public String getParentFilename()
    {
        return getStringProperty(JdapiTypes.PARENT_FILENAME_PTID);
    }

    public void setParentFilename(String s)
    {
        setStringProperty(JdapiTypes.PARENT_FILENAME_PTID, s);
    }

    public String getParentFilepath()
    {
        return getStringProperty(JdapiTypes.PARENT_FILEPATH_PTID);
    }

    public void setParentFilepath(String s)
    {
        setStringProperty(JdapiTypes.PARENT_FILEPATH_PTID, s);
    }

    public String getParentModule()
    {
        return getStringProperty(JdapiTypes.PARENT_MODULE_PTID);
    }

    public void setParentModule(String s)
    {
        setStringProperty(JdapiTypes.PARENT_MODULE_PTID, s);
    }

    public String getParentName()
    {
        return getStringProperty(JdapiTypes.PARENT_NAME_PTID);
    }

    public void setParentName(String s)
    {
        setStringProperty(JdapiTypes.PARENT_NAME_PTID, s);
    }

    public String getParentSourceLevel1ObjectName()
    {
        return getStringProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID);
    }

    public void setParentSourceLevel1ObjectName(String s)
    {
        setStringProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID, s);
    }

    public String getSubMenuName()
    {
        return getStringProperty(JdapiTypes.SUB_MENU_NAME_PTID);
    }

    public void setSubMenuName(String s)
    {
        setStringProperty(JdapiTypes.SUB_MENU_NAME_PTID, s);
    }

    public String getVisualAttributeName()
    {
        return getStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID);
    }

    public void setVisualAttributeName(String s)
    {
        setStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID, s);
    }

    public int getCommandType()
    {
        return getIntegerProperty(JdapiTypes.COMMAND_TYPE_PTID);
    }

    public void setCommandType(int i)
    {
        setIntegerProperty(JdapiTypes.COMMAND_TYPE_PTID, i);
    }

    public int getFontSize()
    {
        return getIntegerProperty(JdapiTypes.FONT_SIZE_PTID);
    }

    public void setFontSize(int i)
    {
        setIntegerProperty(JdapiTypes.FONT_SIZE_PTID, i);
    }

    public int getFontSpacing()
    {
        return getIntegerProperty(JdapiTypes.FONT_SPACING_PTID);
    }

    public void setFontSpacing(int i)
    {
        setIntegerProperty(JdapiTypes.FONT_SPACING_PTID, i);
    }

    public int getFontStyle()
    {
        return getIntegerProperty(JdapiTypes.FONT_STYLE_PTID);
    }

    public void setFontStyle(int i)
    {
        setIntegerProperty(JdapiTypes.FONT_STYLE_PTID, i);
    }

    public int getFontWeight()
    {
        return getIntegerProperty(JdapiTypes.FONT_WEIGHT_PTID);
    }

    public void setFontWeight(int i)
    {
        setIntegerProperty(JdapiTypes.FONT_WEIGHT_PTID, i);
    }

    public int getMagicItem()
    {
        return getIntegerProperty(JdapiTypes.MAGIC_ITEM_PTID);
    }

    public void setMagicItem(int i)
    {
        setIntegerProperty(JdapiTypes.MAGIC_ITEM_PTID, i);
    }

    public int getMenuItemType()
    {
        return getIntegerProperty(JdapiTypes.MENU_ITEM_TYPE_PTID);
    }

    public void setMenuItemType(int i)
    {
        setIntegerProperty(JdapiTypes.MENU_ITEM_TYPE_PTID, i);
    }

    public int getParentModuleType()
    {
        return getIntegerProperty(JdapiTypes.PARENT_MODULETYPE_PTID);
    }

    public void setParentModuleType(int i)
    {
        setIntegerProperty(JdapiTypes.PARENT_MODULETYPE_PTID, i);
    }

    public int getParentSourceLevel1ObjectType()
    {
        return getIntegerProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID);
    }

    public void setParentSourceLevel1ObjectType(int i)
    {
        setIntegerProperty(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID, i);
    }

    public int getParentType()
    {
        return getIntegerProperty(JdapiTypes.PARENT_TYPE_PTID);
    }

    public void setParentType(int i)
    {
        setIntegerProperty(JdapiTypes.PARENT_TYPE_PTID, i);
    }

    public int getPersistentClientInfoLength()
    {
        return getIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID);
    }

    public void setPersistentClientInfoLength(int i)
    {
        setIntegerProperty(JdapiTypes.PERSISTENT_CLIENT_INFO_LENGTH_PTID, i);
    }

    public int getRoleCount()
    {
        return getIntegerProperty(JdapiTypes.ROLE_COUNT_PTID);
    }

    public boolean isDirtyInfo()
    {
        return getBooleanProperty(JdapiTypes.DIRTY_INFO_PTID);
    }

    public void setDirtyInfo(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DIRTY_INFO_PTID, flag);
    }

    public boolean isDisplayNoPriv()
    {
        return getBooleanProperty(JdapiTypes.DISPLAY_NO_PRIV_PTID);
    }

    public void setDisplayNoPriv(boolean flag)
    {
        setBooleanProperty(JdapiTypes.DISPLAY_NO_PRIV_PTID, flag);
    }

    public boolean isEnabled()
    {
        return getBooleanProperty(JdapiTypes.ENABLED_PTID);
    }

    public void setEnabled(boolean flag)
    {
        setBooleanProperty(JdapiTypes.ENABLED_PTID, flag);
    }

    public boolean isIconInMenu()
    {
        return getBooleanProperty(JdapiTypes.ICON_IN_MENU_PTID);
    }

    public void setIconInMenu(boolean flag)
    {
        setBooleanProperty(JdapiTypes.ICON_IN_MENU_PTID, flag);
    }

    public boolean isSubclassSubObject()
    {
        return getBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID);
    }

    public void setSubclassSubObject(boolean flag)
    {
        setBooleanProperty(JdapiTypes.SUBCLASS_SUBOBJECT_PTID, flag);
    }

    public boolean isVisible()
    {
        return getBooleanProperty(JdapiTypes.VISIBLE_PTID);
    }

    public void setVisible(boolean flag)
    {
        setBooleanProperty(JdapiTypes.VISIBLE_PTID, flag);
    }

    public boolean isVisibleInHorizontalMenuToolbar()
    {
        return getBooleanProperty(JdapiTypes.VISIBLE_IN_HORIZONTAL_MENU_TOOLBAR_PTID);
    }

    public void setVisibleInHorizontalMenuToolbar(boolean flag)
    {
        setBooleanProperty(JdapiTypes.VISIBLE_IN_HORIZONTAL_MENU_TOOLBAR_PTID, flag);
    }

    public boolean isVisibleInMenu()
    {
        return getBooleanProperty(JdapiTypes.VISIBLE_IN_MENU_PTID);
    }

    public void setVisibleInMenu(boolean flag)
    {
        setBooleanProperty(JdapiTypes.VISIBLE_IN_MENU_PTID, flag);
    }

    public boolean isVisibleInVerticalMenuToolbar()
    {
        return getBooleanProperty(JdapiTypes.VISIBLE_IN_VERTICAL_MENU_TOOLBAR_PTID);
    }

    public void setVisibleInVerticalMenuToolbar(boolean flag)
    {
        setBooleanProperty(JdapiTypes.VISIBLE_IN_VERTICAL_MENU_TOOLBAR_PTID, flag);
    }

    public JdapiObject getModule()
    {
        return getObjectProperty(JdapiTypes.MODULE_PTID);
    }

    public JdapiObject getOwner()
    {
        return getObjectProperty(JdapiTypes.OWNER_PTID);
    }

    public JdapiObject getSource()
    {
        return getObjectProperty(JdapiTypes.SOURCE_PTID);
    }

    public MenuItem getSubMenuObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (MenuItem)getObjectProperty(JdapiTypes.SUB_MENU_OBJECT_PTID);
    }

    public void setSubMenuObject(MenuItem menuitem)
    {
        setObjectProperty(JdapiTypes.SUB_MENU_OBJECT_PTID, menuitem);
    }

    public VisualAttribute getVisualAttributeObject()
    {
        if(super.m_pd2fob == 0L)
            throw new JdapiException("Null d2fob pointer");
        else
            return (VisualAttribute)getObjectProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID);
    }

    public void setVisualAttributeObject(VisualAttribute visualattribute)
    {
        setObjectProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID, visualattribute);
    }

    private static int s_foType;

    static 
    {
        s_foType = JdapiTypes.MENU_ITEM_OTID;
    }
}
