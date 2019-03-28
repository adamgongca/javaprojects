// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.util.xmltools;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import oracle.forms.jdapi.*;
import oracle.xml.parser.schema.XSDException;
import oracle.xml.parser.v2.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

// Referenced classes of package oracle.forms.util.xmltools:
//            XMLValidator, TempFormsObjectTree, TempFormsObject, ConverterUtilities, 
//            SchemaGenerator

public class XML2Forms
{

    public XML2Forms(URL url)
    {
        m_xmlURL = null;
        m_indent = new String();
        m_writeTree = true;
        m_cmdLine = false;
        m_moduleStart = false;
        m_v = new XMLValidator();
        ConverterUtilities.testJdapi();
        m_xmlURL = url;
        m_schema = SchemaGenerator.getSchemaObject();
    }

    public void commandLine(Boolean boolean1)
    {
        m_cmdLine = true;
        m_writeTree = boolean1.booleanValue();
    }

    public void connectToDatabase(String s)
    {
        if(s != null && !s.equals(""))
            try
            {
                Jdapi.connectToDatabase(s);
            }
            catch(JdapiException jdapiexception)
            {
                ConverterUtilities.printResourceMessage("db_connect");
                ConverterUtilities.println("   " + jdapiexception.getMessage());
                ConverterUtilities.printResourceMessage("db_continue");
            }
    }

    public JdapiModule createModule()
        throws XMLParseException, XSDException, SAXException, IOException
    {
        m_TempFormsObjectTree = new TempFormsObjectTree(m_writeTree);
        parseXML();
        return m_TempFormsObjectTree.processModule();
    }

    public void parseXML()
        throws UTFDataFormatException, XMLParseException, SAXException, IOException, XSDException
    {
        XMLDocument xmldocument = m_v.validateXML(m_xmlURL);
        process((XMLElement)xmldocument.getDocumentElement());
    }

    private void process(XMLElement xmlelement)
    {
        startElement(xmlelement);
        NodeList nodelist = xmlelement.getChildrenByTagName("*");
        for(int i = 0; i < nodelist.getLength(); i++)
        {
            Node node = nodelist.item(i);
            if(node instanceof XMLElement)
                process((XMLElement)node);
        }

        endElement(xmlelement);
    }

    public void startElement(XMLElement xmlelement)
    {
        String s = xmlelement.getLocalName();
        if(s.equals("Module"))
        {
            if(m_cmdLine)
            {
                String s1 = m_xmlURL.getFile();
                ConverterUtilities.println();
                ConverterUtilities.printResourceMessage("process_xml", new Object[] {
                    s1.substring(s1.lastIndexOf("/") + 1)
                });
                String s3 = xmlelement.getAttribute("version");
            }
            m_moduleStart = true;
        } else
        if(!m_moduleStart)
        {
            ConverterUtilities.printResourceMessage("root_error");
            System.exit(1);
        } else
        if(ConverterUtilities.isValidObjectName(s))
        {
            if(s.equals("ObjectGroupChild"))
            {
                int i = ConverterUtilities.getObjectPropertyId(xmlelement.getAttribute("Type"));
                m_temp = new TempFormsObject(s, i, m_temp);
            } else
            if(s.equals("DataSourceArgument"))
            {
                int j = ConverterUtilities.getDataSourceArgumentTypeId(xmlelement.getAttribute("Type"));
                m_temp = new TempFormsObject(s, j, m_temp);
            } else
            if(s.equals("DataSourceColumn"))
            {
                int k = ConverterUtilities.getDataSourceColumnTypeId(xmlelement.getAttribute("Type"));
                m_temp = new TempFormsObject(s, k, m_temp);
            } else
            {
                m_temp = new TempFormsObject(s, m_temp);
            }
            if(m_previous != null && m_previous.getOwner() == m_temp.getOwner() && m_previous.getTypeId() == m_temp.getTypeId())
            {
                m_previous.setNext(m_temp);
                m_temp.setPrevious(m_previous);
            }
            m_TempFormsObjectTree.add(m_temp);
            NamedNodeMap namednodemap = xmlelement.getAttributes();
            for(int l = 0; l < namednodemap.getLength(); l++)
            {
                Node node = namednodemap.item(l);
                String s6 = node.getLocalName();
                String s7 = node.getNodeValue();
                s7 = ConverterUtilities.replaceHtmlEntities(s7);
                if(s6.equals("RecordGroupQuery"))
                    s7 = ConverterUtilities.handleSingleQuotes(s7);
                if(s6.equals("Type"))
                {
                    if(s.equals("ObjectGroupChild") || s.equals("DataSourceArgument") || !s.equals("DataSourceColumn"));
                } else
                if(s6.equals("ImageFilename"))
                    m_temp.setProperty(ConverterUtilities.IMAGE_FILENAME_PTID, "String", s7);
                else
                if(s6.equals("SmartClass"))
                {
                    m_temp.setProperty(ConverterUtilities.SMARTCLASS_PTID, "Boolean", s7);
                } else
                {
                    int i1 = JdapiMetaProperty.getPropertyId(s6);
                    String s8 = JdapiMetaProperty.getPropertyType(i1).getName();
                    s8 = s8.substring(s8.lastIndexOf(".") + 1);
                    int j1;
                    if(s8.equals("Integer"))
                        try
                        {
                            j1 = Integer.parseInt(s7);
                        }
                        catch(NumberFormatException numberformatexception)
                        {
                            s7 = "" + JdapiMetaProperty.getPropertyValueValue(i1, s7);
                        }
                    m_temp.setProperty(i1, s8, s7);
                }
            }

        } else
        if(ConverterUtilities.isValidExtraElementName(s))
        {
            String s2 = xmlelement.getAttribute("Name");
            String s4 = xmlelement.getAttribute("Value");
            String s5 = xmlelement.getAttribute("Index");
            s4 = ConverterUtilities.replaceHtmlEntities(s4);
            if(s2 != null)
                s2 = ConverterUtilities.replaceHtmlEntities(s2);
            if(s.equals("ListItemElement"))
            {
                String as[] = {
                    s2, s4
                };
                m_temp.setExtraProperty(Integer.parseInt(s5), as);
            } else
            {
                m_temp.setExtraProperty(Integer.parseInt(s5), s4);
            }
        }
    }

    public void endElement(XMLElement xmlelement)
    {
        String s = xmlelement.getLocalName();
        if(ConverterUtilities.isValidObjectName(s))
        {
            m_previous = m_temp;
            m_temp = m_temp.getOwner();
        }
    }

    private static void printUsage()
    {
        ConverterUtilities.println();
        ConverterUtilities.printResourceMessage("XML2Forms_usage");
        System.exit(1);
    }

    public static void main(String args[])
    {
        ConverterUtilities.printResourceMessage("XML2Forms");
        ConverterUtilities.printResourceMessage("Copyright");
        HashMap hashmap = ConverterUtilities.processCommandLine(args, new String[] {
            "USERID"
        }, new String[] {
            "PRINTTREE", "OVERWRITE"
        });
        if(hashmap == null)
            printUsage();
        Iterator iterator = (Iterator)hashmap.get("args");
        Boolean boolean1 = (Boolean)hashmap.get("OVERWRITE");
        if(!iterator.hasNext())
        {
            ConverterUtilities.printResourceMessage("nothing_to_do");
            printUsage();
        }
        while(iterator.hasNext()) 
        {
            String s = (String)iterator.next();
            File file = new File(s);
            if(!file.exists())
            {
                ConverterUtilities.printResourceMessage("file_doesnt_exist", new Object[] {
                    s
                });
                continue;
            }
            XML2Forms xml2forms = null;
            URL url = null;
            try
            {
                url = ConverterUtilities.fileToURL(file);
                boolean flag = false;
                try
                {
                    Object obj = null;
                    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
                    String s1;
                    for(int i = 3; (s1 = bufferedreader.readLine()) != null && i != 0; i--)
                        if(s1.indexOf("Dump=\"All\"") > 0 && s1.indexOf("Module") > 0)
                        {
                            ConverterUtilities.printResourceMessage("xml_to_forms_stop", new Object[] {
                                s
                            });
                            flag = true;
                        }

                    bufferedreader.close();
                }
                catch(IOException ioexception)
                {
                    ConverterUtilities.processException(ioexception);
                }
                if(flag)
                    continue;
                xml2forms = new XML2Forms(url);
            }
            catch(MalformedURLException malformedurlexception)
            {
                ConverterUtilities.printResourceMessage("url_exception");
                printUsage();
            }
            xml2forms.commandLine((Boolean)hashmap.get("PRINTTREE"));
            xml2forms.connectToDatabase((String)hashmap.get("USERID"));
            try
            {
                JdapiModule jdapimodule = xml2forms.createModule();
                String s2 = null;
                if(jdapimodule instanceof FormModule)
                {
                    s2 = s.substring(0, s.lastIndexOf(".xml"));
                    if(s2.endsWith("_fmb"))
                        s2 = s2.substring(0, s2.length() - 4);
                    s2 = s2 + ".fmb";
                } else
                if(jdapimodule instanceof ObjectLibrary)
                {
                    s2 = s.substring(0, s.lastIndexOf(".xml"));
                    if(s2.endsWith("_olb"))
                        s2 = s2.substring(0, s2.length() - 4);
                    s2 = s2 + ".olb";
                } else
                if(jdapimodule instanceof MenuModule)
                {
                    s2 = s.substring(0, s.lastIndexOf(".xml"));
                    if(s2.endsWith("_mmb"))
                        s2 = s2.substring(0, s2.length() - 4);
                    s2 = s2 + ".mmb";
                }
                File file1 = new File(s2);
                if(file1.exists() && !boolean1.booleanValue())
                {
                    ConverterUtilities.printResourceMessage("overwrite", new Object[] {
                        s2
                    });
                    jdapimodule.destroy();
                    continue;
                }
                jdapimodule.save(s2);
                jdapimodule.destroy();
                ConverterUtilities.printResourceMessage("module_saved", new Object[] {
                    s2
                });
            }
            catch(UTFDataFormatException utfdataformatexception)
            {
                ConverterUtilities.printResourceMessage("invalid_xml", new String[] {
                    ConverterUtilities.URLToFileName(url)
                });
                ConverterUtilities.println("  " + utfdataformatexception.getMessage());
            }
            catch(XMLParseException xmlparseexception)
            {
                ConverterUtilities.printResourceMessage("invalid_xml_format", new String[] {
                    ConverterUtilities.URLToFileName(url)
                });
                ConverterUtilities.println("  " + xmlparseexception.getMessage());
            }
            catch(SAXException saxexception)
            {
                ConverterUtilities.printResourceMessage("invalid_xml_format", new String[] {
                    ConverterUtilities.URLToFileName(url)
                });
                ConverterUtilities.println("  " + saxexception.getMessage());
            }
            catch(Exception exception)
            {
                ConverterUtilities.processException(exception);
            }
            Jdapi.destroyAllModules();
        }
    }

    private Object m_schema;
    private URL m_xmlURL;
    private String m_indent;
    private TempFormsObject m_temp;
    private TempFormsObject m_previous;
    private TempFormsObjectTree m_TempFormsObjectTree;
    private boolean m_writeTree;
    private boolean m_cmdLine;
    private boolean m_moduleStart;
    XMLValidator m_v;
}
