package net.adamdog.form2njp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;

import java.awt.Frame;
import java.awt.Rectangle;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SystemConfigurePanel extends JPanel {
    private JLabel jLabel1 = new JLabel();
    private ImageIcon imageLogo =new ImageIcon(Main.class.getResource("resource/database.jpg"));
    private JButton finishButton = new JButton();
    private JButton cancelButton = new JButton();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JRadioButton sidRadioButton = new JRadioButton();
    private JRadioButton serviceNameRadioButton = new JRadioButton();
    private JCheckBox jdbcURLCheckBox = new JCheckBox();
    private JTextArea jdbcURLTextArea = new JTextArea();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JTextField gwtHomeFolderTextField = new JTextField();
    private JButton jButton3 = new JButton();
    private JTextField hostNameTextField = new JTextField();
    private JTextField portTextField = new JTextField();
    private JTextField sidTextField = new JTextField();
    private JTextField serviceNameTextField = new JTextField();
    private JButton testButton = new JButton();
    private JTextField userNameTextField = new JTextField();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();
    private JTextField passwordTextField = new JTextField();

    public String resultStr ;
    private JButton jButton4 = new JButton();
    private JTextField antHomeFolderTextField = new JTextField();
    private JLabel jLabel8 = new JLabel();
    private JLabel jLabel9 = new JLabel();
    private JTextField packagePrefixTextField = new JTextField();

    public SystemConfigurePanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(512, 375));
        ButtonGroup buttonGroup = new ButtonGroup();
        jLabel1.setIcon(imageLogo);
        jLabel1.setText("");
        jLabel1.setBounds(new Rectangle(15, 20, 130, 295));
        finishButton.setText("Finish");
        finishButton.setBounds(new Rectangle(235, 340, 73, 22));
        finishButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        finishButton_actionPerformed(e);
                    }
                });
        cancelButton.setText("Cancel");
        cancelButton.setBounds(new Rectangle(365, 340, 73, 22));
        cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cancelButton_actionPerformed(e);
                    }
                });
        jLabel2.setText("Host Name:");
        jLabel2.setBounds(new Rectangle(155, 5, 70, 20));
        jLabel2.setToolTipText("null");
        jLabel3.setText("JDBC Port:");
        jLabel3.setBounds(new Rectangle(155, 30, 70, 20));
        jLabel3.setToolTipText("null");
        sidRadioButton.setText("SID");
        sidRadioButton.setBounds(new Rectangle(155, 55, 86, 18));
        sidRadioButton.setSelected(true);
        sidRadioButton.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        sidRadioButton_stateChanged(e);
                    }
                });
        buttonGroup.add(sidRadioButton);
        serviceNameRadioButton.setText("Services Name:");
        serviceNameRadioButton.setBounds(new Rectangle(155, 80, 105, 20));
        buttonGroup.add(serviceNameRadioButton);       
        serviceNameRadioButton.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        sidRadioButton_stateChanged(e);
                    }
                });

        jdbcURLCheckBox.setText("Enter Custom JDBC URL:");
        jdbcURLCheckBox.setBounds(new Rectangle(150, 130, 170, 20));
        jdbcURLCheckBox.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        jdbcURLCheckBox_stateChanged(e);
                    }
                });
        jdbcURLTextArea.setBounds(new Rectangle(150, 155, 270, 70));
        jdbcURLTextArea.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        jdbcURLTextArea.setBackground(new Color(255, 225, 225));
        jdbcURLTextArea.setEnabled(false);
        jLabel4.setBounds(new Rectangle(150, 235, 335, 2));
        jLabel4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jLabel4.setSize(new Dimension(335, 2));
        jLabel5.setText("GWT_HOME:");
        jLabel5.setBounds(new Rectangle(150, 245, 65, 20));
        jLabel5.setToolTipText("null");
        gwtHomeFolderTextField.setBounds(new Rectangle(215, 240, 220, 25));
        jButton3.setText("jButton3");
        jButton3.setBounds(new Rectangle(445, 240, 35, 25));
        jButton3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButton3_actionPerformed(e);
                    }
                });
        hostNameTextField.setBounds(new Rectangle(260, 5, 210, 20));
        portTextField.setBounds(new Rectangle(260, 30, 210, 20));
        sidTextField.setBounds(new Rectangle(260, 55, 210, 20));
        serviceNameTextField.setBounds(new Rectangle(260, 80, 210, 20));
        serviceNameTextField.setEnabled(false);
        testButton.setText("Test");
        testButton.setBounds(new Rectangle(425, 170, 55, 35));
        userNameTextField.setBounds(new Rectangle(210, 105, 95, 20));
        jLabel6.setText("User Name:");
        jLabel6.setBounds(new Rectangle(150, 105, 70, 20));
        jLabel6.setToolTipText("null");
        jLabel7.setText("Password:");
        jLabel7.setBounds(new Rectangle(320, 105, 70, 20));
        jLabel7.setToolTipText("null");
        passwordTextField.setBounds(new Rectangle(375, 105, 95, 20));
        jButton4.setText("jButton3");
        jButton4.setBounds(new Rectangle(445, 270, 35, 25));
        jButton4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jButton4_actionPerformed(e);
                    }
                });
        antHomeFolderTextField.setBounds(new Rectangle(215, 270, 220, 25));
        jLabel8.setText("ANT_HOME:");
        jLabel8.setBounds(new Rectangle(150, 275, 65, 20));
        jLabel8.setToolTipText("null");
        jLabel9.setText("Package Prefix:");
        jLabel9.setBounds(new Rectangle(150, 305, 80, 20));
        jLabel9.setToolTipText("null");
        packagePrefixTextField.setBounds(new Rectangle(235, 300, 245, 25));
        this.add(packagePrefixTextField, null);
        this.add(jLabel9, null);
        this.add(jLabel8, null);
        this.add(antHomeFolderTextField, null);
        this.add(jButton4, null);
        this.add(passwordTextField, null);
        this.add(jLabel7, null);
        this.add(jLabel6, null);
        this.add(userNameTextField, null);
        this.add(testButton, null);
        this.add(serviceNameTextField, null);
        this.add(sidTextField, null);
        this.add(portTextField, null);
        this.add(hostNameTextField, null);
        this.add(jButton3, null);
        this.add(gwtHomeFolderTextField, null);
        this.add(jLabel5, null);
        this.add(jLabel4, null);
        this.add(jdbcURLTextArea, null);
        this.add(jdbcURLCheckBox, null);
        this.add(serviceNameRadioButton, null);
        this.add(sidRadioButton, null);
        this.add(jLabel3, null);
        this.add(jLabel2, null);
        this.add(cancelButton, null);
        this.add(finishButton, null);
        this.add(jLabel1);
    }

    private void sidRadioButton_stateChanged(ChangeEvent e) {
        if (sidRadioButton.isSelected() ) {
            sidTextField.setEnabled(true);
            serviceNameTextField.setEnabled(false);
        } else {
            sidTextField.setEnabled(false);
            serviceNameTextField.setEnabled(true);
        }   
    }

    private void jdbcURLCheckBox_stateChanged(ChangeEvent e) {
        if (jdbcURLCheckBox.isSelected()){
            jdbcURLTextArea.setEnabled(true);
            hostNameTextField.setEnabled(false);
            portTextField.setEnabled(false);
            sidTextField.setEnabled(false);
            serviceNameTextField.setEnabled(false);
            sidRadioButton.setEnabled(false);
            serviceNameRadioButton.setEnabled(false);
            userNameTextField.setEnabled(false);
            passwordTextField.setEditable(false);
        } else {
            jdbcURLTextArea.setEnabled(false);
            hostNameTextField.setEnabled(true);
            portTextField.setEnabled(true);
            sidRadioButton.setEnabled(true);
            serviceNameRadioButton.setEnabled(true);            
            userNameTextField.setEnabled(true);
            passwordTextField.setEditable(true);
            if (sidRadioButton.isSelected() ) {
                sidTextField.setEnabled(true);
                serviceNameTextField.setEnabled(false);
            } else {
                sidTextField.setEnabled(false);
                serviceNameTextField.setEnabled(true);
            }   
        }
    }

    private void cancelButton_actionPerformed(ActionEvent e) {
       resultStr = "CANCEL";
       Window w= getWindowForComponent((Component)e.getSource() );
       if (w != null )w.setVisible(false);
    }
    
    private void finishButton_actionPerformed(ActionEvent e) {
        resultStr = "OK";
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

    public Dataconnection backupValueToDataconnection(){
        Dataconnection dataconnection = new Dataconnection();
        if (jdbcURLCheckBox.isSelected()) dataconnection.setJdbcStr(jdbcURLTextArea.getText());
        else {
            dataconnection.setHostName(hostNameTextField.getText());
            dataconnection.setJdbcPort(portTextField.getText());
            if (sidRadioButton.isSelected()) dataconnection.setSidName(sidTextField.getText());
            else dataconnection.setServicesName(serviceNameTextField.getText());
            dataconnection.setUserName(userNameTextField.getText());
            dataconnection.setPassword(passwordTextField.getText());
        }       
        return dataconnection;
    }
    
    public void restoreValueFromDataconnection(Dataconnection dataconnection){
        if (dataconnection.getJdbcStr() != null && !"".equals(dataconnection.getJdbcStr())){
            jdbcURLCheckBox.setSelected(true);
            jdbcURLTextArea.setText(dataconnection.getJdbcStr());
        } else {
            jdbcURLCheckBox.setSelected(false);
            hostNameTextField.setText(dataconnection.getHostName());
            portTextField.setText(dataconnection.getJdbcPort());
            if (dataconnection.getServicesName() != null && !"".equals(dataconnection.getServicesName())){
                serviceNameRadioButton.setSelected(true);
                serviceNameTextField.setText(dataconnection.getServicesName());
            }   else {
                sidRadioButton.setSelected(true);
                sidTextField.setText(dataconnection.getSidName());
            }
            userNameTextField.setText(dataconnection.getUserName());
            passwordTextField.setText(dataconnection.getPassword());
        }
    }

    public String getGwtHomeFolder(){
        return gwtHomeFolderTextField.getText();
    }
    
    public void setGwtHomeFolder(String s){
        gwtHomeFolderTextField.setText(s);
    }

    public String getAntHomeFolder(){
        return antHomeFolderTextField.getText();
    }
    
    public void setAntHomeFolder(String s){
        antHomeFolderTextField.setText(s);
    }
    
    public String getPackagePrefix(){
        return packagePrefixTextField.getText();
    }
    
    public void setPackagePrefix(String s){
        packagePrefixTextField.setText(s);
    }
    
    

    private void jButton3_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        if (gwtHomeFolderTextField.getText() != null && !"".equals(gwtHomeFolderTextField.getText()))
            chooser.setCurrentDirectory(new File(gwtHomeFolderTextField.getText()));
        else
            chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("Choose target folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            gwtHomeFolderTextField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void jButton4_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        if (antHomeFolderTextField.getText() != null && !"".equals(antHomeFolderTextField.getText()))
            chooser.setCurrentDirectory(new File(antHomeFolderTextField.getText()));
        else
            chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle("Choose target folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            antHomeFolderTextField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }
}
