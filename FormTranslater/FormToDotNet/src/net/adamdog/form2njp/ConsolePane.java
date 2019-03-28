package net.adamdog.form2njp;

import java.awt.Color;

import java.awt.Dimension;

import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ConsolePane extends JScrollPane {
    private JTextPane textPane = new JTextPane();   
    
    private static ConsolePane console = null;   
    
    public static synchronized ConsolePane getInstance() {   
        if (console == null) {   
            console = new ConsolePane();   
        }   
        return console;   
    }   
    
    private ConsolePane() {   
    
        setViewportView(textPane);   
    
        PrintStream mySystemOut = new MyPrintStream(System.out, Color.BLACK);   
        //System.setOut(mySystemOut);   
        //TODO
        PrintStream mySystemErr = new MyPrintStream(System.err, Color.RED);   
        //System.setErr(mySystemErr);   
           
        textPane.setEditable(false);   

    }   
    
    private final int getLineCount() {   
        return textPane.getDocument().getDefaultRootElement().getElementCount();   
    }   
    
    private int getLineStartOffset(int line) {   
        Element lineElement = textPane.getDocument().getDefaultRootElement()   
                .getElement(line);   
        if (lineElement == null)   
            return -1;   
        else  
            return lineElement.getStartOffset();   
    }   
    
    private void replaceRange(String str, int start, int end) {   
        if (end < start) {   
            throw new IllegalArgumentException("end before start");   
        }   
        Document doc = textPane.getDocument();   
        if (doc != null) {   
            try {   
                if (doc instanceof AbstractDocument) {   
                    ((AbstractDocument) doc).replace(start, end - start, str,   
                            null);   
                } else {   
                    doc.remove(start, end - start);   
                    doc.insertString(start, str, null);   
                }   
            } catch (BadLocationException e) {   
                throw new IllegalArgumentException(e.getMessage());   
            }   
        }   
        
        
    }   
    
    class MyPrintStream extends PrintStream {   
    
        private Color foreground; 
        MyPrintStream(OutputStream out,Color foreground) {   
            super(out,true);   
            this.foreground = foreground;   
        }   
    
        public void write(byte[] buf, int off, int len) {   
            final String message = new String(buf, off, len);   
    
            SwingUtilities.invokeLater(new Runnable() {   
                public void run() {   
                    try {   
    
                        StyledDocument doc = (StyledDocument) textPane   
                                .getDocument();   
                        Style style = doc.addStyle("StyleName", null);   
                        StyleConstants.setForeground(style, foreground);   
    
                        doc.insertString(doc.getLength(), message, style);   
    
                    } catch (BadLocationException e) {   
                        // e.printStackTrace();   
                    }   
    
                    textPane.setCaretPosition(textPane.getDocument()   
                            .getLength());   
    
                    int idealLine = 150;   
                    int maxExcess = 50;   
    
                    int excess = getLineCount() - idealLine;   
                    if (excess >= maxExcess) {   
                        replaceRange("", 0, getLineStartOffset(excess));   
                    }   
                }   
            });   
        }   
    }   
   
    public String getLogMessage(){
        return textPane.getText();
    }    
    
    public void clearLogMessage(){
        textPane.setText("");
    }
    
}
    
