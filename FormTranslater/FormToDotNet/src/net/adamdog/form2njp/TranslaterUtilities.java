package net.adamdog.form2njp;

import java.io.FileOutputStream;
import java.io.IOException;

import java.text.MessageFormat;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.SwingUtilities;

import oracle.xml.parser.v2.XMLDocument;

public class TranslaterUtilities {

    private static ResourceBundle s_resBund = ResourceBundle.getBundle("net.adamdog.form2njp.TranslaterBundle", Locale.getDefault());

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

    static void stepIt(){
        SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                      MainFrame aMainFrame = MainFrame.getAMainFrameInstance();
                      if (aMainFrame != null) aMainFrame.stepIt();
                    }
                });
    }
    
    static void stepToEnd(){
        SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                      MainFrame aMainFrame = MainFrame.getAMainFrameInstance();
                      if (aMainFrame != null) aMainFrame.stepToEnd();
                    }
                });
    }    

    public static boolean isModule(String s)
    {
        return s.trim().endsWith(".fmb") || s.trim().endsWith(".olb") || s.trim().endsWith(".mmb") || s.trim().endsWith(".fmb".toUpperCase()) || s.trim().endsWith(".olb".toUpperCase()) || s.trim().endsWith(".mmb".toUpperCase());
    }
    
    public static void writeXML(XMLDocument xmldocument, String s)
        throws IOException
    {
        FileOutputStream fileoutputstream = new FileOutputStream(s);
        xmldocument.print(fileoutputstream, "UTF-8");
        fileoutputstream.close();
    }  
    
    static void processException(Exception exception)
    {
        System.err.println(s_resBund.getString("general_exception"));
        System.err.println(exception.getMessage());
        System.err.println();
    }    
}
