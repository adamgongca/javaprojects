// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.util.xmltools;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import oracle.forms.jdapi.*;
import oracle.xml.parser.schema.XMLSchema;
import oracle.xml.parser.schema.XSDBuilder;
import oracle.xml.parser.v2.XMLDocument;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package oracle.forms.util.xmltools:
//            ConverterUtilities

public class SchemaGenerator
{

    public SchemaGenerator()
    {
        ConverterUtilities.testJdapi();
        loadJdapiClasses();
        loadJdapiProperties();
    }

    private void loadJdapiClasses()
    {
        Iterator iterator = JdapiMetadata.getJdapiClasses();
        m_jdapiClasses = new Vector();
        while(iterator.hasNext()) 
        {
            Class class1 = (Class)iterator.next();
            if(class1 != (oracle.forms.jdapi.PlsqlModule.class))
            {
                boolean flag = false;
                for(int i = 0; !flag; i++)
                    if(i == m_jdapiClasses.size())
                    {
                        m_jdapiClasses.add(class1);
                        flag = true;
                    } else
                    if(class1.getName().compareTo(((Class)m_jdapiClasses.get(i)).getName()) < 0)
                    {
                        m_jdapiClasses.insertElementAt(class1, i);
                        flag = true;
                    }

            }
        }
    }

    private void loadJdapiProperties()
    {
        m_jdapiProperties = new Vector();
        m_enumerations = new HashMap();
        for(int i = 0; i < m_jdapiClasses.size(); i++)
        {
            Class class1 = (Class)m_jdapiClasses.elementAt(i);
            JdapiMetaObject jdapimetaobject = JdapiMetadata.getJdapiMetaObject(class1);
            for(JdapiIterator jdapiiterator = jdapimetaobject.getMetaProperties(); jdapiiterator.hasNext();)
            {
                JdapiMetaProperty jdapimetaproperty = (JdapiMetaProperty)jdapiiterator.next();
                String s = jdapimetaproperty.getPropertyName();
                int j = jdapimetaproperty.getPropertyId();
                if(!m_jdapiProperties.contains(jdapimetaproperty) && j != JdapiTypes.JDAPI_OLT_OBJECTS_PTID)
                {
                    boolean flag = false;
                    for(int k = 0; !flag; k++)
                        if(k == m_jdapiProperties.size())
                        {
                            m_jdapiProperties.add(jdapimetaproperty);
                            flag = true;
                        } else
                        {
                            String s1 = ((JdapiMetaProperty)m_jdapiProperties.get(k)).getPropertyName();
                            if(s.equals(s1))
                                flag = true;
                            else
                            if(s.compareTo(s1) < 0)
                            {
                                m_jdapiProperties.insertElementAt(jdapimetaproperty, k);
                                flag = true;
                            }
                        }

                }
                int ai[] = jdapimetaproperty.getAllowedValues();
                if(ai != null)
                {
                    HashMap hashmap = new HashMap();
                    for(int l = 0; l < ai.length; l++)
                        try
                        {
                            hashmap.put(new Integer(ai[l]), JdapiMetaProperty.getPropertyValueName(j, ai[l]));
                        }
                        catch(JdapiException jdapiexception)
                        {
                            hashmap.put(new Integer(ai[l]), l + jdapiexception.getMessage());
                        }

                    m_enumerations.put(new Integer(j), hashmap);
                }
            }

        }

    }

    public XMLDocument generateSchema()
    {
        m_xmlDoc = new XMLDocument();
        m_xmlDoc.setEncoding("UTF-8");
        Element element = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "schema");
        element.setAttributeNS("xmlns", "xmlns:tns", "http://xmlns.oracle.com/Forms");
        element.setAttribute("targetNamespace", "http://xmlns.oracle.com/Forms");
        m_xmlDoc.appendChild(element);
        addCopyrightAnnotation(element);
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "element");
        element1.setAttribute("name", "Module");
        element1.setAttribute("type", "tns:Module");
        element.appendChild(element1);
        for(int i = 0; i < m_jdapiClasses.size(); i++)
            addJdapiClassElement((Class)m_jdapiClasses.get(i), element);

        addModuleComplexTypeDefinition(element);
        for(int j = 0; j < m_jdapiClasses.size(); j++)
            addJdapiComplexTypeDefinition((Class)m_jdapiClasses.get(j), element);

        addJdapiAttributeGroup(element);
        addJdapiElementGroup(element);
        addEnumerationSimpleTypes(element);
        addListElements(element);
        addNameType(element);
        return m_xmlDoc;
    }

    private void addCopyrightAnnotation(Element element)
    {
        String s = Locale.getDefault().getLanguage();
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "annotation");
        Element element2 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "documentation");
        element2.setAttributeNS("http://www.w3.org/XML/1998/namespace", "xml:lang", s);
        ResourceBundle resourcebundle = ConverterUtilities.getResourceBundle();
        String s1 = "\n         " + resourcebundle.getString("Schema") + "\n         " + resourcebundle.getString("Copyright") + "\n      ";
        org.w3c.dom.Text text = m_xmlDoc.createTextNode(s1);
        element2.appendChild(text);
        element1.appendChild(element2);
        element.appendChild(element1);
    }

    private void addJdapiClassElement(Class class1, Element element)
    {
        JdapiMetaObject jdapimetaobject = JdapiMetadata.getJdapiMetaObject(class1);
        String s = jdapimetaobject.getClassName();
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "element");
        element1.setAttribute("name", s);
        element1.setAttribute("type", "tns:" + s);
        element.appendChild(element1);
    }

    private void addJdapiComplexTypeDefinition(Class class1, Element element)
    {
        JdapiMetaObject jdapimetaobject = JdapiMetadata.getJdapiMetaObject(class1);
        String s = jdapimetaobject.getClassName();
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "complexType");
        element1.setAttribute("name", s);
        JdapiIterator jdapiiterator = jdapimetaobject.getChildObjectMetaProperties();
        addChildElements(element1, jdapiiterator, class1);
        if(!s.equals("PropertyClass"))
        {
            JdapiIterator jdapiiterator1 = jdapimetaobject.getBooleanMetaProperties();
            addPropertyAttributeElements(element1, jdapiiterator1, "boolean");
            jdapiiterator1 = jdapimetaobject.getIntegerMetaProperties();
            addPropertyAttributeElements(element1, jdapiiterator1, "integer");
            jdapiiterator1 = jdapimetaobject.getStringMetaProperties();
            addPropertyAttributeElements(element1, jdapiiterator1, "string");
        }
        if(s.equals("ObjectGroupChild"))
            addAttributeElement(element1, "Type", "string");
        if(s.equals("DataSourceArgument") || s.equals("DataSourceColumn"))
            addAttributeElement(element1, "Type", "string", new String[] {
                "Delete", "Insert", "Lock", "Query", "Update"
            });
        if(s.equals("Graphics"))
            addAttributeElement(element1, "ImageFilename", "string");
        else
        if(s.equals("PropertyClass"))
        {
            Element element2 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "attributeGroup");
            element2.setAttribute("ref", "tns:JdapiProperties");
            element1.appendChild(element2);
        }
        if(!s.equals("AttachedLibrary") && !s.equals("CompoundText") && !s.equals("Coordinate") && !s.equals("DataSourceArgument") && !s.equals("DataSourceColumn") && !s.equals("Font") && !s.equals("FormModule") && !s.equals("LOVColumnMapping") && !s.equals("MenuModule") && !s.equals("ObjectGroupChild") && !s.equals("ObjectLibrary") && !s.equals("ObjectLibraryTab") && !s.equals("PlsqlModule") && !s.equals("Point") && !s.equals("RecordGroupColumn") && !s.equals("Relation") && !s.equals("TextSegment") && !s.equals("VisualState"))
            addAttributeElement(element1, "SmartClass", "boolean");
        element.appendChild(element1);
    }

    private void addJdapiAttributeGroup(Element element)
    {
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "attributeGroup");
        element1.setAttribute("name", "JdapiProperties");
        for(int i = 0; i < m_jdapiProperties.size(); i++)
        {
            JdapiMetaProperty jdapimetaproperty = (JdapiMetaProperty)m_jdapiProperties.elementAt(i);
            String s = jdapimetaproperty.getPropertyName();
            Class class1 = jdapimetaproperty.getPropertyType();
            if(class1 != (oracle.forms.jdapi.JdapiObject.class))
            {
                int ai[] = jdapimetaproperty.getAllowedValues();
                if(ai == null)
                {
                    String s1 = class1.getName();
                    s1 = s1.substring(s1.lastIndexOf('.') + 1).toLowerCase();
                    addAttributeElement(element1, s, s1);
                } else
                {
                    String s2 = "tns:" + s + "Type";
                    addAttributeElement(element1, s, s2);
                }
            }
        }

        element.appendChild(element1);
    }

    private void addJdapiElementGroup(Element element)
    {
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "group");
        element1.setAttribute("name", "JdapiElements");
        Element element2 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "choice");
        for(int i = 0; i < m_jdapiClasses.size(); i++)
        {
            Class class1 = (Class)m_jdapiClasses.get(i);
            if(class1 != (oracle.forms.jdapi.FormModule.class) && class1 != (oracle.forms.jdapi.MenuModule.class) && class1 != (oracle.forms.jdapi.ObjectLibrary.class) && class1 != (oracle.forms.jdapi.ObjectLibraryTab.class) && class1 != (oracle.forms.jdapi.PlsqlModule.class) && class1 != (oracle.forms.jdapi.ObjectGroupChild.class))
            {
                String s = JdapiMetadata.getJdapiMetaObject(class1).getClassName();
                Element element3 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "element");
                element3.setAttribute("ref", "tns:" + s);
                element2.appendChild(element3);
            }
        }

        element1.appendChild(element2);
        element.appendChild(element1);
    }

    private void addModuleComplexTypeDefinition(Element element)
    {
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "complexType");
        element1.setAttribute("name", "Module");
        Element element2 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "choice");
        Element element3 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "element");
        element3.setAttribute("ref", "tns:FormModule");
        Element element4 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "element");
        element4.setAttribute("ref", "tns:ObjectLibrary");
        Element element5 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "element");
        element5.setAttribute("ref", "tns:MenuModule");
        element2.appendChild(element3);
        element2.appendChild(element4);
        element2.appendChild(element5);
        element1.appendChild(element2);
        addAttributeElement(element1, "version", "long");
        element.appendChild(element1);
    }

    private void addNameType(Element element)
    {
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "simpleType");
        element1.setAttribute("name", "nameType");
        Element element2 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "restriction");
        element2.setAttribute("base", "string");
        Element element3 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "minLength");
        element3.setAttribute("value", "1");
        element2.appendChild(element3);
        Element element4 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "maxLength");
        element4.setAttribute("value", "30");
        element2.appendChild(element4);
        element1.appendChild(element2);
        element.appendChild(element1);
    }

    private void addListElements(Element element)
    {
        generateElement("ListItemElement", "tns:IndexedListWithName", element);
        generateElement("MenuItemRole", "tns:IndexedListWithoutName", element);
        generateElement("MenuModuleRole", "tns:IndexedListWithoutName", element);
        generateElement("RecordGroupColumnRow", "tns:IndexedListWithoutName", element);
        Element element1 = generateComplexType(new String[] {
            "Index", "Name", "Value"
        }, new String[] {
            "positiveInteger", "string", "string"
        }, element);
        element1.setAttribute("name", "IndexedListWithName");
        Element element2 = generateComplexType(new String[] {
            "Index", "Value"
        }, new String[] {
            "positiveInteger", "string"
        }, element);
        element2.setAttribute("name", "IndexedListWithoutName");
    }

    private void addEnumerationSimpleTypes(Element element)
    {
        Element element1;
        for(Iterator iterator = m_enumerations.keySet().iterator(); iterator.hasNext(); element.appendChild(element1))
        {
            Integer integer = (Integer)iterator.next();
            HashMap hashmap = (HashMap)m_enumerations.get(integer);
            element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "simpleType");
            element1.setAttribute("name", JdapiMetaProperty.getPropertyName(integer.intValue()) + "Type");
            Element element2 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "restriction");
            element2.setAttribute("base", "string");
            Element element4;
            for(Iterator iterator1 = hashmap.keySet().iterator(); iterator1.hasNext(); element2.appendChild(element4))
            {
                Integer integer1 = (Integer)iterator1.next();
                String s = (String)hashmap.get(integer1);
                Element element3 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "enumeration");
                element3.setAttribute("value", s);
                element2.appendChild(element3);
                element4 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "enumeration");
                element4.setAttribute("value", integer1.toString());
            }

            element1.appendChild(element2);
        }

    }

    private void addPropertyAttributeElements(Element element, Iterator iterator, String s)
    {
        while(iterator.hasNext()) 
        {
            JdapiMetaProperty jdapimetaproperty = (JdapiMetaProperty)iterator.next();
            String s1 = jdapimetaproperty.getPropertyName();
            int ai[] = jdapimetaproperty.getAllowedValues();
            Element element1 = null;
            if(ai != null)
                element1 = addAttributeElement(element, s1, "tns:" + s1 + "Type");
            else
                element1 = addAttributeElement(element, s1, s);
            if(element1.getAttribute("name").equals("Name"))
            {
                element1.setAttribute("use", "required");
                element1.setAttribute("type", "tns:nameType");
            }
        }
    }

    private Element addAttributeElement(Element element, String s, String s1)
    {
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "attribute");
        element1.setAttribute("name", s);
        element1.setAttribute("type", s1);
        element.appendChild(element1);
        return element1;
    }

    private Element addAttributeElement(Element element, String s, String s1, String as[])
    {
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "attribute");
        element1.setAttribute("name", s);
        Element element2 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "simpleType");
        Element element3 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "restriction");
        element3.setAttribute("base", "string");
        for(int i = 0; i < as.length; i++)
        {
            Element element4 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "enumeration");
            element4.setAttribute("value", String.valueOf(as[i]));
            element3.appendChild(element4);
        }

        element2.appendChild(element3);
        element1.appendChild(element2);
        element.appendChild(element1);
        return element1;
    }

    private void addChildElements(Element element, Iterator iterator, Class class1)
    {
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "choice");
        element1.setAttribute("maxOccurs", "unbounded");
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        String s = element.getAttribute("name");
        if(class1 == (oracle.forms.jdapi.FormModule.class))
            generateElementRef("Coordinate", element1);
        while(iterator.hasNext()) 
        {
            flag = true;
            int i = ((JdapiMetaProperty)iterator.next()).getPropertyId();
            if(i == JdapiTypes.JDAPI_OLT_OBJECTS_PTID)
                continue;
            Class aclass[] = PropertyMap.getPropertyTypes(class1, i);
            String s1 = aclass[0].getName();
            s1 = s1.substring(s1.lastIndexOf(".") + 1);
            if(s1.equals("DataSourceArgument"))
            {
                if(flag1)
                    continue;
                flag1 = true;
            } else
            if(s1.equals("DataSourceColumn"))
            {
                if(flag2)
                    continue;
                flag2 = true;
            }
            generateElementRef(s1, element1);
        }
        if(class1 == (oracle.forms.jdapi.Item.class))
        {
            Element element2 = generateElementRef("ListItemElement", element1);
            flag = true;
        } else
        if(class1 == (oracle.forms.jdapi.MenuModule.class))
        {
            Element element3 = generateElementRef("MenuModuleRole", element1);
            flag = true;
        } else
        if(class1 == (oracle.forms.jdapi.RecordGroupColumn.class))
        {
            Element element4 = generateElementRef("RecordGroupColumnRow", element1);
            flag = true;
        } else
        if(class1 == (oracle.forms.jdapi.MenuItem.class))
        {
            Element element5 = generateElementRef("MenuItemRole", element1);
            flag = true;
        } else
        if(class1 == (oracle.forms.jdapi.ObjectLibrary.class) || class1 == (oracle.forms.jdapi.ObjectLibraryTab.class))
        {
            Element element6 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "group");
            element6.setAttribute("ref", "tns:JdapiElements");
            element6.setAttribute("minOccurs", "0");
            element6.setAttribute("maxOccurs", "unbounded");
            element1.appendChild(element6);
            flag = true;
        }
        if(flag)
            element.appendChild(element1);
    }

    private Element generateElement(String s, String s1, Element element)
    {
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "element");
        element1.setAttribute("name", s);
        if(s1 != null)
            element1.setAttribute("type", s1);
        element.appendChild(element1);
        return element1;
    }

    private Element generateElementRef(String s, Element element)
    {
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "element");
        element1.setAttribute("ref", "tns:" + s);
        element1.setAttribute("minOccurs", "0");
        element1.setAttribute("maxOccurs", "unbounded");
        element.appendChild(element1);
        return element1;
    }

    private Element generateComplexType(String as[], String as1[], Element element)
    {
        Element element1 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "complexType");
        for(int i = 0; i < as.length; i++)
        {
            Element element2 = m_xmlDoc.createElementNS("http://www.w3.org/2001/XMLSchema", "attribute");
            element2.setAttribute("name", as[i]);
            element2.setAttribute("type", as1[i]);
            element2.setAttribute("use", "required");
            element1.appendChild(element2);
        }

        element.appendChild(element1);
        return element1;
    }

    public static XMLSchema getSchemaObject()
    {
        XMLSchema xmlschema = null;
        SchemaGenerator schemagenerator = new SchemaGenerator();
        XMLDocument xmldocument = schemagenerator.generateSchema();
        try
        {
            XSDBuilder xsdbuilder = new XSDBuilder();
            xmlschema = xsdbuilder.build(xmldocument, new URL("http://xmlns.oracle.com/Forms"));
        }
        catch(Exception exception)
        {
            ConverterUtilities.printResourceMessage("schema_fail");
            ConverterUtilities.println(exception.getMessage());
            if(ConverterUtilities.DEBUG)
                exception.printStackTrace();
        }
        return (XMLSchema)xmlschema;
    }

    public static void main(String args[])
    {
        ConverterUtilities.printResourceMessage("SchemaGenerator");
        ConverterUtilities.printResourceMessage("Copyright");
        ConverterUtilities.println();
        SchemaGenerator schemagenerator = new SchemaGenerator();
        XMLDocument xmldocument = schemagenerator.generateSchema();
        try
        {
            ConverterUtilities.writeXML(xmldocument, "forms.xsd");
            ConverterUtilities.printResourceMessage("schema_saved", new Object[] {
                "forms.xsd"
            });
        }
        catch(IOException ioexception)
        {
            ConverterUtilities.println(ioexception.getMessage());
        }
    }

    public static final String FORMSSCHEMA_FILENAME = "forms.xsd";
    public static final String XMLSCHEMA_URI = "http://www.w3.org/2001/XMLSchema";
    public static final String FORMSSCHEMA_URI = "http://xmlns.oracle.com/Forms";
    private XMLDocument m_xmlDoc;
    private Vector m_jdapiClasses;
    private Vector m_jdapiProperties;
    private HashMap m_enumerations;
}
