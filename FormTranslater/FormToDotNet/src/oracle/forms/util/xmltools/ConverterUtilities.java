// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.util.xmltools;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.*;
import oracle.forms.jdapi.*;
import oracle.xml.parser.v2.XMLDocument;

class ConverterUtilities
{

    ConverterUtilities()
    {
    }

    public static ResourceBundle getResourceBundle()
    {
        return s_resBund;
    }

    public static int getObjectPropertyId(String s)
    {
        Integer integer = (Integer)m_objectPropertyIds.get(s);
        return integer.intValue();
    }

    public static String getDataSourceArgumentType(int i)
    {
        return (String)m_dataSourceArgs.get(new Integer(i));
    }

    public static String getDataSourceColumnType(int i)
    {
        return (String)m_dataSourceCols.get(new Integer(i));
    }

    public static int getDataSourceColumnTypeId(String s)
    {
        Integer integer = (Integer)reverseHash(m_dataSourceCols).get(s);
        if(integer == null)
            println(s);
        return integer.intValue();
    }

    public static int getDataSourceArgumentTypeId(String s)
    {
        Integer integer = (Integer)reverseHash(m_dataSourceArgs).get(s);
        if(integer == null)
            println(s);
        return integer.intValue();
    }

    public static int getObjectId(String s)
    {
        Integer integer = (Integer)m_objectIds.get(s);
        return integer.intValue();
    }

    public static String getImageFileExtension(int i)
    {
        return (String)m_imageExtensions.get(new Integer(i));
    }

    public static int getImageFormat(String s)
    {
        return ((Integer)reverseHash(m_imageExtensions).get(s)).intValue();
    }

    public static boolean isValidObjectName(String s)
    {
        return m_objectIds.containsKey(s);
    }

    public static boolean isValidExtraElementName(String s)
    {
        return m_extraElements.contains(s);
    }

    public static Iterator getSubclassPropertyIds()
    {
        return m_subclassProperties.keySet().iterator();
    }

    public static boolean isSubclassProperty(int i)
    {
        return m_subclassProperties.containsKey(new Integer(i));
    }

    public static boolean isSubclassProperty(Integer integer)
    {
        return m_subclassProperties.containsKey(integer);
    }

    public static String getSubclassPropertyType(int i)
    {
        return (String)m_subclassProperties.get(new Integer(i));
    }

    public static String getSubclassPropertyType(Integer integer)
    {
        return (String)m_subclassProperties.get(integer);
    }

    public static JdapiObject findObject(String s, String s1, JdapiObject jdapiobject)
    {
        JdapiObject jdapiobject1 = null;
        JdapiIterator jdapiiterator = jdapiobject.getOwnedObjects();
        if(s1 == null || s1.equals(""))
            while(jdapiiterator.hasNext() && jdapiobject1 == null) 
            {
                JdapiObject jdapiobject2 = (JdapiObject)jdapiiterator.next();
                if(jdapiobject2.getName().equals(s))
                    jdapiobject1 = jdapiobject2;
            }
        else
            while(jdapiiterator.hasNext() && jdapiobject1 == null) 
            {
                JdapiObject jdapiobject3 = (JdapiObject)jdapiiterator.next();
                if(jdapiobject3.getName().equals(s1))
                    jdapiobject1 = findObject(s, null, jdapiobject3);
                else
                    jdapiobject1 = findObject(s, s1, jdapiobject3);
            }
        return jdapiobject1;
    }

    public static String getQualifiedObjectName(JdapiObject jdapiobject)
    {
        String s = jdapiobject.getName();
        JdapiObject jdapiobject1 = jdapiobject.getOwner();
        if(jdapiobject1 != null)
            if(jdapiobject1.getOwner() == null)
                s = jdapiobject1.getName() + "_" + s;
            else
                s = getQualifiedObjectName(jdapiobject1) + "_" + s;
        return s;
    }

    public static JdapiObject constructObject(Class class1, Object aobj[])
    {
        JdapiObject jdapiobject = null;
        Class aclass[] = (Class[])Array.newInstance(java.lang.Class.class, aobj.length);
        for(int i = 0; i < aclass.length; i++)
            aclass[i] = Array.get(((Object) (aobj)), i).getClass();

        Constructor constructor = null;
        try
        {
            constructor = class1.getConstructor(aclass);
        }
        catch(NoSuchMethodException nosuchmethodexception)
        {
            printResourceMessage("constructor_find", new Object[] {
                class1.toString()
            });
            println(nosuchmethodexception.getMessage());
        }
        try
        {
            jdapiobject = (JdapiObject)constructor.newInstance(aobj);
        }
        catch(Exception exception)
        {
            printResourceMessage("constructor_error");
            println(exception.getMessage());
        }
        if(jdapiobject != null)
            jdapiobject = fixFormsConstructionBugs(jdapiobject);
        return jdapiobject;
    }

    private static JdapiObject fixFormsConstructionBugs(JdapiObject jdapiobject)
    {
        if(jdapiobject.getClass() == (oracle.forms.jdapi.FormModule.class))
        {
            for(JdapiIterator jdapiiterator = ((FormModule)jdapiobject).getWindows(); jdapiiterator.hasNext(); jdapiiterator.remove());
        } else
        if(jdapiobject.getClass() == (oracle.forms.jdapi.Block.class))
        {
            jdapiobject.inheritProperty(JdapiTypes.SCROLLBAR_WIDTH_PTID);
            jdapiobject.inheritProperty(JdapiTypes.SCROLLBAR_LENGTH_PTID);
        } else
        if(jdapiobject.getClass() == (oracle.forms.jdapi.Canvas.class))
        {
            jdapiobject.inheritProperty(JdapiTypes.VIEWPORT_HEIGHT_PTID);
            jdapiobject.inheritProperty(JdapiTypes.VIEWPORT_WIDTH_PTID);
            jdapiobject.inheritProperty(JdapiTypes.HEIGHT_PTID);
            jdapiobject.inheritProperty(JdapiTypes.WIDTH_PTID);
        } else
        if(jdapiobject.getClass() == (oracle.forms.jdapi.Editor.class))
        {
            jdapiobject.inheritProperty(JdapiTypes.WIDTH_PTID);
            jdapiobject.inheritProperty(JdapiTypes.HEIGHT_PTID);
        } else
        if(jdapiobject.getClass() == (oracle.forms.jdapi.FormModule.class))
            jdapiobject.inheritProperty(JdapiTypes.MENU_MODULE_PTID);
        else
        if(jdapiobject.getClass() == (oracle.forms.jdapi.Graphics.class))
        {
            jdapiobject.inheritProperty(JdapiTypes.SCROLLBAR_WIDTH_PTID);
            jdapiobject.inheritProperty(JdapiTypes.HORIZONTAL_MARGIN_PTID);
            jdapiobject.inheritProperty(JdapiTypes.HORIZONTAL_OBJECT_OFFSET_PTID);
            jdapiobject.inheritProperty(JdapiTypes.START_PROMPT_OFFSET_PTID);
            jdapiobject.inheritProperty(JdapiTypes.VERTICAL_MARGIN_PTID);
            jdapiobject.inheritProperty(JdapiTypes.GRAPHICS_FONT_NAME_PTID);
            jdapiobject.inheritProperty(JdapiTypes.GRAPHICS_FONT_SIZE_PTID);
        } else
        if(jdapiobject.getClass() == (oracle.forms.jdapi.LOV.class))
        {
            jdapiobject.inheritProperty(JdapiTypes.WIDTH_PTID);
            jdapiobject.inheritProperty(JdapiTypes.HEIGHT_PTID);
        } else
        if(jdapiobject.getClass() == (oracle.forms.jdapi.ObjectLibraryTab.class))
            jdapiobject.inheritProperty(JdapiTypes.LABEL_PTID);
        else
        if(jdapiobject.getClass() == (oracle.forms.jdapi.RadioButton.class))
        {
            jdapiobject.inheritProperty(JdapiTypes.WIDTH_PTID);
            jdapiobject.inheritProperty(JdapiTypes.HEIGHT_PTID);
            jdapiobject.inheritProperty(JdapiTypes.LABEL_PTID);
        } else
        if(jdapiobject.getClass() == (oracle.forms.jdapi.TabPage.class))
            jdapiobject.inheritProperty(JdapiTypes.LABEL_PTID);
        else
        if(jdapiobject.getClass() == (oracle.forms.jdapi.Window.class))
        {
            jdapiobject.inheritProperty(JdapiTypes.WIDTH_PTID);
            jdapiobject.inheritProperty(JdapiTypes.HEIGHT_PTID);
        } else
        if(jdapiobject.getClass() == (oracle.forms.jdapi.Item.class))
        {
            jdapiobject.inheritProperty(JdapiTypes.WIDTH_PTID);
            jdapiobject.inheritProperty(JdapiTypes.HEIGHT_PTID);
            jdapiobject.inheritProperty(JdapiTypes.X_POSITION_PTID);
            jdapiobject.inheritProperty(JdapiTypes.Y_POSITION_PTID);
        }
        return jdapiobject;
    }

    public static HashMap getOverriddenProperties(JdapiObject jdapiobject)
    {
        HashMap hashmap = new HashMap();
        for(JdapiIterator jdapiiterator = jdapiobject.getMetaProperties(); jdapiiterator.hasNext();)
        {
            JdapiMetaProperty jdapimetaproperty = (JdapiMetaProperty)jdapiiterator.next();
            int i = jdapimetaproperty.getPropertyId();
            if(jdapiobject.hasProperty(i))
            {
                int j = jdapiobject.getPropertyState(i);
                if(j == 4 || j == 2)
                    if(JdapiMetaProperty.getPropertyType(i).equals(java.lang.String.class))
                        hashmap.put(new Integer(i), jdapiobject.getStringProperty(i));
                    else
                    if(JdapiMetaProperty.getPropertyType(i).equals(java.lang.Integer.class))
                        hashmap.put(new Integer(i), new Integer(jdapiobject.getIntegerProperty(i)));
                    else
                    if(JdapiMetaProperty.getPropertyType(i).equals(java.lang.Boolean.class))
                        hashmap.put(new Integer(i), new Boolean(jdapiobject.getBooleanProperty(i)));
            }
        }

        return hashmap;
    }

    public static void setProperties(JdapiObject jdapiobject, HashMap hashmap)
    {
        for(Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext();)
        {
            Integer integer = (Integer)iterator.next();
            int i = integer.intValue();
            Object obj = hashmap.get(integer);
            if(!m_subclassProperties.containsKey(integer))
                if(obj.getClass().equals(java.lang.String.class))
                    jdapiobject.setStringProperty(i, (String)obj);
                else
                if(obj.getClass().equals(java.lang.Integer.class))
                    jdapiobject.setIntegerProperty(i, ((Integer)obj).intValue());
                else
                if(obj.getClass().equals(java.lang.Boolean.class))
                    jdapiobject.setBooleanProperty(i, ((Boolean)obj).booleanValue());
        }

    }

    public static HashMap processCommandLine(String as[], String as1[], String as2[])
    {
        Vector vector = new Vector();
        if(as1 != null)
        {
            for(int i = 0; i < as1.length; i++)
                vector.add(as1[i]);

        }
        Vector vector1 = new Vector();
        if(as2 != null)
        {
            for(int j = 0; j < as2.length; j++)
                vector1.add(as2[j]);

        }
        HashMap hashmap = null;
        Object obj = null;
        if(as.length != 0)
        {
            hashmap = new HashMap();
            Vector vector2 = new Vector();
            for(Iterator iterator = vector1.iterator(); iterator.hasNext(); hashmap.put((String)iterator.next(), new Boolean(false)));
            for(int k = 0; k < as.length && hashmap != null; k++)
            {
                String s = as[k].toUpperCase();
                int l = as[k].indexOf('=');
                if(l != -1)
                {
                    String s1 = as[k].substring(0, l).toUpperCase();
                    String s2 = as[k].substring(l + 1).toUpperCase();
                    if(vector.contains(s1))
                        hashmap.put(s1, s2);
                    else
                    if(vector1.contains(s1))
                    {
                        if(s2.equals("YES") || s2.equals("TRUE"))
                            hashmap.put(s1, new Boolean(true));
                    } else
                    {
                        printResourceMessage("invalid_option", new Object[] {
                            s1
                        });
                    }
                } else
                if(vector.contains(s))
                {
                    hashmap.put(s, as[k + 1]);
                    k++;
                } else
                if(vector1.contains(s))
                {
                    if(as[k + 1].equalsIgnoreCase("YES") || as[k + 1].equalsIgnoreCase("TRUE"))
                        hashmap.put(s, new Boolean(true));
                    else
                        hashmap.put(s, new Boolean(false));
                    k++;
                } else
                if(as[k].charAt(0) == '-')
                    printResourceMessage("invalid_option", new Object[] {
                        as[k]
                    });
                else
                    vector2.add(as[k]);
            }

            hashmap.put("args", vector2.iterator());
        }
        return hashmap;
    }

    public static String loadString(String s)
        throws IOException
    {
        StringBuffer stringbuffer = new StringBuffer();
        BufferedReader bufferedreader = new BufferedReader(new FileReader(s));
        for(String s1 = null; (s1 = bufferedreader.readLine()) != null;)
        {
            stringbuffer.append(s1);
            stringbuffer.append("\n");
        }

        bufferedreader.close();
        return stringbuffer.toString();
    }

    public static void writeString(String s, String s1)
        throws IOException
    {
        FileOutputStream fileoutputstream = new FileOutputStream(s1);
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(fileoutputstream, "UTF-8");
        outputstreamwriter.write(s, 0, s.length());
        outputstreamwriter.close();
        fileoutputstream.close();
    }

    public static void writeXML(XMLDocument xmldocument, String s)
        throws IOException
    {
        FileOutputStream fileoutputstream = new FileOutputStream(s);
        xmldocument.print(fileoutputstream, "UTF-8");
        fileoutputstream.close();
    }

    public static URL fileToURL(File file)
        throws MalformedURLException
    {
        String s = file.getAbsolutePath();
        String s1 = System.getProperty("file.separator");
        if(s1 != null && s1.length() == 1)
            s = s.replace(s1.charAt(0), '/');
        if(s.length() > 0 && s.charAt(0) != '/')
            s = '/' + s;
        return new URL("file", null, s);
    }

    public static URL createURL(String s)
    {
        URL url = null;
        try
        {
            url = new URL(s);
        }
        catch(MalformedURLException malformedurlexception)
        {
            File file = new File(s);
            try
            {
                url = fileToURL(file);
            }
            catch(MalformedURLException malformedurlexception1)
            {
                println("Cannot create url for: " + s);
                System.exit(0);
            }
        }
        return url;
    }

    public static String URLToFileName(URL url)
    {
        String s = url.toString();
        s = s.substring(s.lastIndexOf('/') + 1);
        return s;
    }

    public static boolean isModule(String s)
    {
        return s.trim().endsWith(".fmb") || s.trim().endsWith(".olb") || s.trim().endsWith(".mmb") || s.trim().endsWith(".fmb".toUpperCase()) || s.trim().endsWith(".olb".toUpperCase()) || s.trim().endsWith(".mmb".toUpperCase());
    }

    public static String replaceHtmlCharacters(String s)
    {
        String s1 = "\n";
        String s2 = "&#10;";
        for(int i = s.indexOf(s1); i != -1; i = s.indexOf(s1, i + 1))
            s = s.substring(0, i) + s2 + s.substring(i + 1);

        return s;
    }

    public static String replaceHtmlEntities(String s)
    {
        String s1 = "\n";
        char c = ' ';
        String s2 = "&#10;";
        for(int i = s.indexOf(s2); i != -1;)
            if(i - 1 >= 0 && s.charAt(i - 1) != c)
            {
                s = s.substring(0, i) + c + s1 + s.substring(i + s2.length());
                i = s.indexOf(s2, i + 2);
            } else
            {
                s = s.substring(0, i) + s1 + s.substring(i + s2.length());
                i = s.indexOf(s2, i + 1);
            }

        return s;
    }

    public static String handleSingleQuotes(String s)
    {
        char c = ' ';
        byte byte0 = 39;
        byte byte1 = 40;
        byte byte2 = 41;
        for(int i = s.indexOf(byte0); i != -1;)
        {
            if(i - 1 >= 0 && s.charAt(i - 1) != c && s.charAt(i - 1) != byte0 && s.charAt(i - 1) != byte1)
            {
                s = s.substring(0, i) + c + s.substring(i);
                i = s.indexOf(byte0, i + 2);
            } else
            {
                i = s.indexOf(byte0, i + 1);
            }
            if(i == -1)
                break;
            if(i + 1 < s.length() && s.charAt(i + 1) != c && s.charAt(i + 1) != byte0 && s.charAt(i + 1) != byte2)
            {
                s = s.substring(0, i + 1) + c + s.substring(i + 1);
                i = s.indexOf(byte0, i + 2);
            } else
            {
                i = s.indexOf(byte0, i + 1);
            }
        }

        return s;
    }

    static void processException(Exception exception)
    {
        printResourceMessage("general_exception");
        if(DEBUG)
        {
            println(exception.getMessage());
            exception.printStackTrace();
        } else
        {
            println(exception.getMessage());
        }
        println();
    }

    static void printResourceMessage(String s, Object aobj[])
    {
        println(MessageFormat.format(s_resBund.getString(s), aobj));
    }

    static void printResourceMessage(String s)
    {
        println(s_resBund.getString(s));
    }

    static void println(Object obj)
    {
        System.out.println(obj);
    }

    static void println()
    {
        println("");
    }

    public static void testJdapi()
    {
        try
        {
            Jdapi.getProductVersion();
        }
        catch(Exception exception)
        {
            println();
            printResourceMessage("init_fail");
            println(exception.getMessage());
            System.exit(1);
        }
        catch(Error error)
        {
            println();
            printResourceMessage("init_fail");
            println(error.getMessage());
            System.exit(1);
        }
    }

    public static HashMap reverseHash(HashMap hashmap)
    {
        HashMap hashmap1 = new HashMap();
        Object obj;
        for(Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); hashmap1.put(hashmap.get(obj), obj))
            obj = iterator.next();

        return hashmap1;
    }

    public static JdapiObject getParentObject(JdapiObject jdapiobject, int i)
    {
        if(jdapiobject == null)
            return jdapiobject;
        String s = jdapiobject.getName();
        if(jdapiobject instanceof PropertyClass)
        {
            if(jdapiobject.hasProperty(i))
                return jdapiobject;
            if((i == JdapiTypes.BACK_COLOR_PTID || i == JdapiTypes.FOREGROUND_COLOR_PTID || i == JdapiTypes.FILL_PATTERN_PTID || i == JdapiTypes.FONT_NAME_PTID || i == JdapiTypes.FONT_SIZE_PTID || i == JdapiTypes.FONT_WEIGHT_PTID || i == JdapiTypes.FONT_STYLE_PTID || i == JdapiTypes.FONT_SPACING_PTID) && jdapiobject.hasProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID))
                return jdapiobject;
            if((i == JdapiTypes.FRAME_TITLE_BACK_COLOR_PTID || i == JdapiTypes.FRAME_TITLE_FOREGROUND_COLOR_PTID || i == JdapiTypes.FRAME_TITLE_FILL_PATTERN_PTID || i == JdapiTypes.FRAME_TITLE_FONT_NAME_PTID || i == JdapiTypes.FRAME_TITLE_FONT_SIZE_PTID || i == JdapiTypes.FRAME_TITLE_FONT_WEIGHT_PTID || i == JdapiTypes.FRAME_TITLE_FONT_STYLE_PTID || i == JdapiTypes.FRAME_TITLE_FONT_SPACING_PTID) && jdapiobject.hasProperty(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_NAME_PTID))
                return jdapiobject;
            if((i == JdapiTypes.PROMPT_FOREGROUND_COLOR_PTID || i == JdapiTypes.PROMPT_FONT_NAME_PTID || i == JdapiTypes.PROMPT_FONT_SIZE_PTID || i == JdapiTypes.PROMPT_FONT_WEIGHT_PTID || i == JdapiTypes.PROMPT_FONT_STYLE_PTID || i == JdapiTypes.PROMPT_FONT_SPACING_PTID) && jdapiobject.hasProperty(JdapiTypes.PROMPT_VISUALATTRIBUTE_NAME_PTID))
                return jdapiobject;
            if(jdapiobject.isSubclassed())
            {
                JdapiObject jdapiobject1 = jdapiobject.getSubclassParent();
                jdapiobject1 = getParentObject(jdapiobject1, i);
                return jdapiobject1;
            } else
            {
                return null;
            }
        }
        int j = jdapiobject.getPropertyState(i);
        if(j != 3)
            return jdapiobject;
        if((i == JdapiTypes.BACK_COLOR_PTID || i == JdapiTypes.FOREGROUND_COLOR_PTID || i == JdapiTypes.FILL_PATTERN_PTID || i == JdapiTypes.FONT_NAME_PTID || i == JdapiTypes.FONT_SIZE_PTID || i == JdapiTypes.FONT_WEIGHT_PTID || i == JdapiTypes.FONT_STYLE_PTID || i == JdapiTypes.FONT_SPACING_PTID) && jdapiobject.hasProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID))
        {
            int k = jdapiobject.getPropertyState(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID);
            String s1 = jdapiobject.getStringProperty(JdapiTypes.VISUALATTRIBUTE_NAME_PTID);
            if(k == 1 || k == 3)
            {
                JdapiObject jdapiobject3 = jdapiobject.getSubclassParent();
                jdapiobject3 = getParentObject(jdapiobject3, i);
                return jdapiobject3;
            }
            if(k == 2 || k == 4)
            {
                JdapiObject jdapiobject4 = jdapiobject.getObjectProperty(JdapiTypes.VISUALATTRIBUTE_OBJECT_PTID);
                if(jdapiobject4 == null)
                    return null;
                if(jdapiobject4.isSubclassed())
                {
                    int j1 = jdapiobject4.getPropertyState(i);
                    if(j1 == 3)
                    {
                        JdapiObject jdapiobject9 = jdapiobject4.getSubclassParent();
                        jdapiobject9 = getParentObject(jdapiobject9, i);
                        return jdapiobject9;
                    } else
                    {
                        return jdapiobject4;
                    }
                } else
                {
                    return jdapiobject;
                }
            } else
            {
                return null;
            }
        }
        if((i == JdapiTypes.FRAME_TITLE_BACK_COLOR_PTID || i == JdapiTypes.FRAME_TITLE_FOREGROUND_COLOR_PTID || i == JdapiTypes.FRAME_TITLE_FILL_PATTERN_PTID || i == JdapiTypes.FRAME_TITLE_FONT_NAME_PTID || i == JdapiTypes.FRAME_TITLE_FONT_SIZE_PTID || i == JdapiTypes.FRAME_TITLE_FONT_WEIGHT_PTID || i == JdapiTypes.FRAME_TITLE_FONT_STYLE_PTID || i == JdapiTypes.FRAME_TITLE_FONT_SPACING_PTID) && jdapiobject.hasProperty(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_NAME_PTID))
        {
            int l = jdapiobject.getPropertyState(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_OBJECT_PTID);
            String s2 = jdapiobject.getStringProperty(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_NAME_PTID);
            if(l == 1 || l == 3)
            {
                JdapiObject jdapiobject5 = jdapiobject.getSubclassParent();
                jdapiobject5 = getParentObject(jdapiobject5, i);
                return jdapiobject5;
            }
            if(l == 2 || l == 4)
            {
                JdapiObject jdapiobject6 = jdapiobject.getObjectProperty(JdapiTypes.FRAME_TITLE_VISUALATTRIBUTE_OBJECT_PTID);
                if(jdapiobject6 == null)
                    return null;
                if(jdapiobject6.isSubclassed())
                {
                    int k1 = jdapiobject6.getPropertyState(i);
                    if(k1 == 3)
                    {
                        JdapiObject jdapiobject10 = jdapiobject6.getSubclassParent();
                        jdapiobject10 = getParentObject(jdapiobject10, i);
                        return jdapiobject10;
                    } else
                    {
                        return jdapiobject6;
                    }
                } else
                {
                    return jdapiobject;
                }
            } else
            {
                return null;
            }
        }
        if((i == JdapiTypes.PROMPT_FOREGROUND_COLOR_PTID || i == JdapiTypes.PROMPT_FONT_NAME_PTID || i == JdapiTypes.PROMPT_FONT_SIZE_PTID || i == JdapiTypes.PROMPT_FONT_WEIGHT_PTID || i == JdapiTypes.PROMPT_FONT_STYLE_PTID || i == JdapiTypes.PROMPT_FONT_SPACING_PTID) && jdapiobject.hasProperty(JdapiTypes.PROMPT_VISUALATTRIBUTE_NAME_PTID))
        {
            int i1 = jdapiobject.getPropertyState(JdapiTypes.PROMPT_VISUALATTRIBUTE_OBJECT_PTID);
            String s3 = jdapiobject.getStringProperty(JdapiTypes.PROMPT_VISUALATTRIBUTE_NAME_PTID);
            if(i1 == 1 || i1 == 3)
            {
                JdapiObject jdapiobject7 = jdapiobject.getSubclassParent();
                jdapiobject7 = getParentObject(jdapiobject7, i);
                return jdapiobject7;
            }
            if(i1 == 2 || i1 == 4)
            {
                JdapiObject jdapiobject8 = jdapiobject.getObjectProperty(JdapiTypes.PROMPT_VISUALATTRIBUTE_OBJECT_PTID);
                if(jdapiobject8 == null)
                    return null;
                if(jdapiobject8.isSubclassed())
                {
                    int l1 = jdapiobject8.getPropertyState(i);
                    if(l1 == 3)
                    {
                        JdapiObject jdapiobject11 = jdapiobject8.getSubclassParent();
                        jdapiobject11 = getParentObject(jdapiobject11, i);
                        return jdapiobject11;
                    } else
                    {
                        return jdapiobject8;
                    }
                } else
                {
                    return jdapiobject;
                }
            } else
            {
                return null;
            }
        } else
        {
            JdapiObject jdapiobject2 = jdapiobject.getSubclassParent();
            jdapiobject2 = getParentObject(jdapiobject2, i);
            return jdapiobject2;
        }
    }

    public static boolean DEBUG = false;
    public static final String FORMSSCHEMA_FILENAME = "forms.xsd";
    public static final String XMLSCHEMA_URI = "http://www.w3.org/2001/XMLSchema";
    public static final String FORMSSCHEMA_URI = "http://xmlns.oracle.com/Forms";
    public static final String ROOT_ELEMENT_NAME = "Module";
    public static final String FORM_EXTENSION = ".fmb";
    public static final String OBJECTLIBRARY_EXTENSION = ".olb";
    public static final String MENUMODULE_EXTENSION = ".mmb";
    public static final String XML_EXTENSION = ".xml";
    private static final String HTML_CHARACTERS[] = {
        "&", "\"", "<", ">", "'", "\n"
    };
    private static final String HTML_ENTITIES[] = {
        "&amp;", "&quot;", "&lt;", "&gt;", "&apos;", "&#10;"
    };
    private static final String RESOURCE_BUNDLE = "oracle.forms.util.xmltools.ConverterBundle";
    public static int IMAGE_FILENAME_PTID;
    public static int SMARTCLASS_PTID;
    private static ResourceBundle s_resBund = ResourceBundle.getBundle("oracle.forms.util.xmltools.ConverterBundle", Locale.getDefault());
    private static HashMap m_dataSourceCols;
    private static HashMap m_dataSourceArgs;
    private static HashMap m_subclassProperties;
    private static HashMap m_objectPropertyIds;
    private static HashMap m_objectIds;
    private static Vector m_extraElements;
    private static HashMap m_imageExtensions;

    static 
    {
        IMAGE_FILENAME_PTID = JdapiTypes.MAXIMUM_PTID + 1;
        SMARTCLASS_PTID = JdapiTypes.MAXIMUM_PTID + 2;
        m_dataSourceCols = new HashMap();
        m_dataSourceArgs = new HashMap();
        m_subclassProperties = new HashMap();
        m_objectPropertyIds = new HashMap();
        m_objectIds = new HashMap();
        m_extraElements = new Vector();
        m_imageExtensions = new HashMap();
        m_dataSourceArgs.put(new Integer(JdapiTypes.QUERY_DATA_SOURCE_ARGUMENT_PTID), "Query");
        m_dataSourceCols.put(new Integer(JdapiTypes.QUERY_DATA_SOURCE_COLUMN_PTID), "Query");
        m_dataSourceArgs.put(new Integer(JdapiTypes.LOCK_DATA_SOURCE_ARGUMENT_PTID), "Lock");
        m_dataSourceCols.put(new Integer(JdapiTypes.LOCK_DATA_SOURCE_COLUMN_PTID), "Lock");
        m_dataSourceArgs.put(new Integer(JdapiTypes.INSERT_DATA_SOURCE_ARGUMENT_PTID), "Insert");
        m_dataSourceCols.put(new Integer(JdapiTypes.INSERT_DATA_SOURCE_COLUMN_PTID), "Insert");
        m_dataSourceArgs.put(new Integer(JdapiTypes.DELETE_DATA_SOURCE_ARGUMENT_PTID), "Delete");
        m_dataSourceCols.put(new Integer(JdapiTypes.DELETE_DATA_SOURCE_COLUMN_PTID), "Delete");
        m_dataSourceArgs.put(new Integer(JdapiTypes.UPDATE_DATA_SOURCE_ARGUMENT_PTID), "Update");
        m_dataSourceCols.put(new Integer(JdapiTypes.UPDATE_DATA_SOURCE_COLUMN_PTID), "Update");
        m_subclassProperties.put(new Integer(JdapiTypes.PARENT_FILENAME_PTID), "String");
        m_subclassProperties.put(new Integer(JdapiTypes.PARENT_FILEPATH_PTID), "String");
        m_subclassProperties.put(new Integer(JdapiTypes.PARENT_MODULE_PTID), "String");
        m_subclassProperties.put(new Integer(JdapiTypes.PARENT_NAME_PTID), "String");
        m_subclassProperties.put(new Integer(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_NAME_PTID), "String");
        m_subclassProperties.put(new Integer(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_NAME_PTID), "String");
        m_subclassProperties.put(new Integer(JdapiTypes.PARENT_MODULETYPE_PTID), "Integer");
        m_subclassProperties.put(new Integer(JdapiTypes.PARENT_TYPE_PTID), "Integer");
        m_subclassProperties.put(new Integer(JdapiTypes.PARENT_SOURCELEVEL1OBJECT_TYPE_PTID), "Integer");
        m_subclassProperties.put(new Integer(JdapiTypes.PARENT_SOURCELEVEL2OBJECT_TYPE_PTID), "Integer");
        m_subclassProperties.put(new Integer(JdapiTypes.SUBCLASS_SUBOBJECT_PTID), "Boolean");
        m_subclassProperties.put(new Integer(JdapiTypes.SUBCLASS_OBJECTGROUP_PTID), "Boolean");
        m_objectPropertyIds.put("Alert", new Integer(JdapiTypes.ALERT_PTID));
        m_objectPropertyIds.put("AttachedLibrary", new Integer(JdapiTypes.ATTACHMENT_LIBRARY_PTID));
        m_objectPropertyIds.put("Block", new Integer(JdapiTypes.BLOCK_PTID));
        m_objectPropertyIds.put("Canvas", new Integer(JdapiTypes.CANVAS_PTID));
        m_objectPropertyIds.put("CompoundText", new Integer(JdapiTypes.COMPOUNDTEXT_PTID));
        m_objectPropertyIds.put("Coordinate", new Integer(JdapiTypes.COORDINATE_SYSTEM_PTID));
        m_objectPropertyIds.put("Editor", new Integer(JdapiTypes.EDITOR_PTID));
        m_objectPropertyIds.put("Graphics", new Integer(JdapiTypes.GRAPHIC_PTID));
        m_objectPropertyIds.put("Item", new Integer(JdapiTypes.ITEM_PTID));
        m_objectPropertyIds.put("LOV", new Integer(JdapiTypes.LOV_PTID));
        m_objectPropertyIds.put("LOVColumnMapping", new Integer(JdapiTypes.COLUMN_MAP_PTID));
        m_objectPropertyIds.put("Menu", new Integer(JdapiTypes.MENU_PTID));
        m_objectPropertyIds.put("MenuItem", new Integer(JdapiTypes.MENU_ITEM_PTID));
        m_objectPropertyIds.put("MenuModule", new Integer(JdapiTypes.MENU_MODULE_PTID));
        m_objectPropertyIds.put("ModuleParameter", new Integer(JdapiTypes.FORM_PARAMETER_PTID));
        m_objectPropertyIds.put("ObjectGroup", new Integer(JdapiTypes.OBJECT_GROUP_PTID));
        m_objectPropertyIds.put("ObjectGroupChild", new Integer(JdapiTypes.OBJECTGROUP_CHILD_PTID));
        m_objectPropertyIds.put("ObjectLibraryTab", new Integer(JdapiTypes.OBJECT_LIBRARY_TAB_PTID));
        m_objectPropertyIds.put("Point", new Integer(JdapiTypes.POINT_PTID));
        m_objectPropertyIds.put("ProgramUnit", new Integer(JdapiTypes.PROGRAM_UNIT_PTID));
        m_objectPropertyIds.put("PropertyClass", new Integer(JdapiTypes.PROPERTY_CLASS_PTID));
        m_objectPropertyIds.put("RadioButton", new Integer(JdapiTypes.RADIO_BUTTON_PTID));
        m_objectPropertyIds.put("RecordGroup", new Integer(JdapiTypes.RECORD_GROUP_PTID));
        m_objectPropertyIds.put("RecordGroupColumn", new Integer(JdapiTypes.COLUMN_SPECIFICATION_PTID));
        m_objectPropertyIds.put("Relation", new Integer(JdapiTypes.RELATION_PTID));
        m_objectPropertyIds.put("Report", new Integer(JdapiTypes.REPORT_PTID));
        m_objectPropertyIds.put("TabPage", new Integer(JdapiTypes.TAB_PAGE_PTID));
        m_objectPropertyIds.put("TextSegment", new Integer(JdapiTypes.TEXT_SEGMENT_PTID));
        m_objectPropertyIds.put("Trigger", new Integer(JdapiTypes.TRIGGER_PTID));
        m_objectPropertyIds.put("VisualAttribute", new Integer(JdapiTypes.VISUAL_ATTRIBUTE_PTID));
        m_objectPropertyIds.put("Window", new Integer(JdapiTypes.WINDOW_PTID));
        m_objectIds.put("MenuItem", new Integer(JdapiTypes.MENU_ITEM_OTID));
        m_objectIds.put("TabPage", new Integer(JdapiTypes.TAB_PAGE_OTID));
        m_objectIds.put("Canvas", new Integer(JdapiTypes.CANVAS_OTID));
        m_objectIds.put("Font", new Integer(JdapiTypes.FONT_OTID));
        m_objectIds.put("Item", new Integer(JdapiTypes.ITEM_OTID));
        m_objectIds.put("Trigger", new Integer(JdapiTypes.TRIGGER_OTID));
        m_objectIds.put("ObjectLibraryTab", new Integer(JdapiTypes.OBJECT_LIBRARY_TAB_OTID));
        m_objectIds.put("Menu", new Integer(JdapiTypes.MENU_OTID));
        m_objectIds.put("Point", new Integer(JdapiTypes.POINT_OTID));
        m_objectIds.put("Report", new Integer(JdapiTypes.REPORT_OTID));
        m_objectIds.put("PlsqlModule", new Integer(JdapiTypes.LIBRARY_MODULE_OTID));
        m_objectIds.put("FormModule", new Integer(JdapiTypes.FORM_MODULE_OTID));
        m_objectIds.put("DataSourceArgument", new Integer(JdapiTypes.DATA_SOURCE_ARGUMENT_OTID));
        m_objectIds.put("ObjectGroupChild", new Integer(JdapiTypes.OBJECTGROUP_CHILD_OTID));
        m_objectIds.put("DataSourceColumn", new Integer(JdapiTypes.DATA_SOURCE_COLUMN_OTID));
        m_objectIds.put("RecordGroup", new Integer(JdapiTypes.RECORD_GROUP_OTID));
        m_objectIds.put("LOVColumnMapping", new Integer(JdapiTypes.LV_COLMAP_OTID));
        m_objectIds.put("MenuModule", new Integer(JdapiTypes.MENU_MODULE_OTID));
        m_objectIds.put("TextSegment", new Integer(JdapiTypes.TEXT_SEGMENT_OTID));
        m_objectIds.put("Relation", new Integer(JdapiTypes.RELATION_OTID));
        m_objectIds.put("RecordGroupColumn", new Integer(JdapiTypes.RECORDGROUP_COLUMNSPECIFICATION_OTID));
        m_objectIds.put("VisualAttribute", new Integer(JdapiTypes.VISUAL_ATTRIBUTE_OTID));
        m_objectIds.put("ProgramUnit", new Integer(JdapiTypes.PROGRAM_UNIT_OTID));
        m_objectIds.put("Window", new Integer(JdapiTypes.WINDOW_OTID));
        m_objectIds.put("AttachedLibrary", new Integer(JdapiTypes.ATTACHMENT_LIBRARY_OTID));
        m_objectIds.put("LOV", new Integer(JdapiTypes.LOV_OTID));
        m_objectIds.put("ObjectGroup", new Integer(JdapiTypes.OBJECT_GROUP_OTID));
        m_objectIds.put("RadioButton", new Integer(JdapiTypes.RADIO_BUTTON_OTID));
        m_objectIds.put("Coordinate", new Integer(JdapiTypes.COORDINATE_OTID));
        m_objectIds.put("Block", new Integer(JdapiTypes.BLOCK_OTID));
        m_objectIds.put("Graphics", new Integer(JdapiTypes.GRAPHIC_OTID));
        m_objectIds.put("CompoundText", new Integer(JdapiTypes.COMPOUNDTEXT_OTID));
        m_objectIds.put("Editor", new Integer(JdapiTypes.EDITOR_OTID));
        m_objectIds.put("ObjectLibrary", new Integer(JdapiTypes.OBJECT_LIBRARY_OTID));
        m_objectIds.put("Alert", new Integer(JdapiTypes.ALERT_OTID));
        m_objectIds.put("ModuleParameter", new Integer(JdapiTypes.FORM_PARAMETER_OTID));
        m_objectIds.put("PropertyClass", new Integer(JdapiTypes.PROPERTY_CLASS_OTID));
        m_objectIds.put("ProgramUnit", new Integer(JdapiTypes.LIBRARY_PROGRAM_UNIT_OTID));
        m_extraElements.add("ListItemElement");
        m_extraElements.add("RecordGroupColumnRow");
        m_extraElements.add("MenuItemRole");
        m_extraElements.add("MenuModuleRole");
        m_imageExtensions.put(new Integer(JdapiTypes.IMFM_BMP_CTID), "bmp");
        m_imageExtensions.put(new Integer(JdapiTypes.IMFM_CALS_CTID), "cals");
        m_imageExtensions.put(new Integer(JdapiTypes.IMFM_GIF_CTID), "gif");
        m_imageExtensions.put(new Integer(JdapiTypes.IMFM_JFIF_CTID), "jpg");
        m_imageExtensions.put(new Integer(JdapiTypes.IMFM_PICT_CTID), "pict");
        m_imageExtensions.put(new Integer(JdapiTypes.IMFM_RAS_CTID), "ras");
        m_imageExtensions.put(new Integer(JdapiTypes.IMFM_TIFF_CTID), "tif");
        m_imageExtensions.put(new Integer(JdapiTypes.IMFM_TPIC_CTID), "tpic");
    }
}
