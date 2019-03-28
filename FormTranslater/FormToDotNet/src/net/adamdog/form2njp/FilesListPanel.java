package net.adamdog.form2njp;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

import oracle.jdeveloper.layout.VerticalFlowLayout;

public class FilesListPanel extends JPanel {
    private JList formFilesList = new JList();
    private JButton buttonAdd = new JButton();
    private JButton buttonRemove = new JButton();
    private JLabel jLabel1 = new JLabel();
    private BorderLayout borderLayout1 = new BorderLayout();
    private JPanel jPanel1 = new JPanel();
    private DefaultListModel listModel = new DefaultListModel();

    private File currentDir ;
    private JScrollPane jScrollPane1 = new JScrollPane();

    public FilesListPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout(borderLayout1);
        this.setSize(new Dimension(339, 337));
        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        buttonAdd_actionPerformed(e);
                    }
                });
        buttonRemove.setText("remove");
        buttonRemove.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        buttonRemove_actionPerformed(e);
                    }
                });
        jLabel1.setText("Oracle Form Files (*.fmb,*.mmb,*.pll,*.xml)");
        jLabel1.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 0));
        jScrollPane1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jScrollPane1.setAutoscrolls(true);
        this.add(jLabel1, BorderLayout.NORTH);
        jScrollPane1.setViewportView(formFilesList);
        this.add(jScrollPane1, BorderLayout.CENTER);
        this.add(jPanel1, BorderLayout.SOUTH);
        jPanel1.add(buttonAdd, null);
        jPanel1.add(buttonRemove, null);
        formFilesList.setModel(listModel);
    }

    private void buttonAdd_actionPerformed(ActionEvent e) {
        File[] selectedFiles;
        ChooseFormFiles chooseFormFiles = new ChooseFormFiles();
        chooseFormFiles.setDialogTitle("Please choose Oracle Form files");
        if (currentDir != null ) chooseFormFiles.setCurrentDirectory(currentDir);
        chooseFormFiles.setApproveButtonText("Select");
        int returnVal = chooseFormFiles.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            currentDir = chooseFormFiles.getCurrentDirectory();
            selectedFiles = chooseFormFiles.getSelectedFiles();
            for(File aFile :selectedFiles ){
                listModel.addElement(aFile.getAbsolutePath());
            }
        }
    }

    private void buttonRemove_actionPerformed(ActionEvent e) {
        int[] iA = formFilesList.getSelectedIndices();
        for(int i = iA.length-1; i>=0; i--){
            listModel.remove(iA[i]);
        }
    }
    
    public Object[] getFormFiles(){
        return listModel.toArray();
    }
    
    public void setFormFiles(List<String> formFiles){
        listModel.removeAllElements();
        for(String aFile : formFiles ){
            listModel.addElement(aFile);
        }
    }
}
