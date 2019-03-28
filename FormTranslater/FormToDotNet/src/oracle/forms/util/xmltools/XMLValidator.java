// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package oracle.forms.util.xmltools;

import java.io.*;
import java.net.URL;
import oracle.xml.parser.schema.XSDException;
import oracle.xml.parser.v2.*;
import org.xml.sax.SAXException;

// Referenced classes of package oracle.forms.util.xmltools:
//            ConverterUtilities, SchemaGenerator

public class XMLValidator
{

    public XMLValidator()
    {
        ConverterUtilities.testJdapi();
        m_schema = SchemaGenerator.getSchemaObject();
    }

    public XMLDocument validateXML(URL url)
        throws XMLParseException, XSDException, SAXException, IOException
    {
        return validateXML(url, ((OutputStream) (System.out)));
    }

    public XMLDocument validateXML(URL url, OutputStream outputstream)
        throws XMLParseException, XSDException, SAXException, IOException
    {
        DOMParser domparser = new DOMParser();
        domparser.setXMLSchema(m_schema);
        domparser.setValidationMode(3);
        domparser.setErrorStream(outputstream);
        domparser.parse(url);
        return domparser.getDocument();
    }

    private static void printUsage()
    {
        ConverterUtilities.println();
        ConverterUtilities.printResourceMessage("Validator_usage");
        System.exit(1);
    }

    public static void main(String args[])
    {
        ConverterUtilities.printResourceMessage("XMLValidator");
        ConverterUtilities.printResourceMessage("Copyright");
        ConverterUtilities.println();
        if(args.length < 1)
            printUsage();
        for(int i = 0; i < args.length; i++)
        {
            String s = args[i];
            try
            {
                URL url = ConverterUtilities.createURL(s);
                XMLValidator xmlvalidator = new XMLValidator();
                xmlvalidator.validateXML(url, System.out);
                ConverterUtilities.printResourceMessage("validate_success", new Object[] {
                    s
                });
            }
            catch(UTFDataFormatException utfdataformatexception)
            {
                ConverterUtilities.printResourceMessage("invalid_xml", new Object[] {
                    s
                });
                ConverterUtilities.println(utfdataformatexception.getMessage());
            }
            catch(XMLParseException xmlparseexception)
            {
                ConverterUtilities.printResourceMessage("invalid_xml_format", new Object[] {
                    s
                });
                ConverterUtilities.println(xmlparseexception.getMessage());
            }
            catch(SAXException saxexception)
            {
                ConverterUtilities.printResourceMessage("invalid_xml_format", new Object[] {
                    s
                });
                ConverterUtilities.println(saxexception.getMessage());
            }
            catch(IOException ioexception)
            {
                ConverterUtilities.println(ioexception.getMessage());
            }
            catch(Exception exception)
            {
                ConverterUtilities.processException(exception);
            }
        }

    }

    private Object m_schema;
}
