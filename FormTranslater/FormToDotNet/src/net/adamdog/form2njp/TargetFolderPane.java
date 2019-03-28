package net.adamdog.form2njp;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TargetFolderPane extends JPanel {
    private JButton jButton3 = new JButton();
    private JTextField targeFolderTextField = new JTextField();
    private JLabel jLabel5 = new JLabel();

    private static TargetFolderPane targetFolderPane = null;
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    
    private String returnStr;

    public static synchronized TargetFolderPane getInstance() {   
        if (targetFolderPane == null) {   
            targetFolderPane = new TargetFolderPane();   
        }   
        return targetFolderPane;   
    }   


    private TargetFolderPane() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(420, 147));
        jButton3.setText("jButton3");
        jButton3.setBounds(new Rectangle(310, 40, 35, 25));
        jButton3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButton3_actionPerformed(e);
                    }
                });
        targeFolderTextField.setBounds(new Rectangle(15, 40, 285, 25));
        jLabel5.setText("Target Folder:");
        jLabel5.setBounds(new Rectangle(15, 15, 80, 20));
        jLabel5.setToolTipText("null");
        jButton1.setText("next");
        jButton1.setBounds(new Rectangle(90, 80, 73, 22));
        jButton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButton1_actionPerformed(e);
                    }
                });
        jButton2.setText("cancel");
        jButton2.setBounds(new Rectangle(220, 80, 73, 22));
        jButton2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButton2_actionPerformed(e);
                    }
                });
        this.add(jButton2, null);
        this.add(jButton1, null);
        this.add(jLabel5, null);
        this.add(targeFolderTextField, null);
        this.add(jButton3, null);
    }

    private void jButton3_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        if (targeFolderTextField.getText() != null && !"".equals(targeFolderTextField.getText()))
            chooser.setCurrentDirectory(new File(targeFolderTextField.getText()));
        else
            chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("Choose target folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            targeFolderTextField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    
    }
    
    public String getTargetFolder(){
        return targeFolderTextField.getText();
    }
    
    public void setTargetFolder(String folderStr){
        targeFolderTextField.setText(folderStr);
    }
    
    private void jButton1_actionPerformed(ActionEvent e) {
        returnStr = "NEXT";
        Window w= getWindowForComponent((Component)e.getSource() );
        if (w != null )w.setVisible(false);
    }

    public void setReturnStr(String returnStr) {
        this.returnStr = returnStr;
    }

    public String getReturnStr() {
        return returnStr;
    }

    private void jButton2_actionPerformed(ActionEvent e) {
        returnStr ="CANCEL";
        Window w= getWindowForComponent((Component)e.getSource() );
        if (w != null )w.setVisible(false);
    }
        
    private Window getWindowForComponent(Component parentComponent){
        if (parentComponent == null)
            return null;
        if (parentComponent instanceof Frame || parentComponent instanceof Dialog)
            return (Window)parentComponent;
        return getWindowForComponent(parentComponent.getParent());
        }
}
