package net.adamdog.form2njp;

import java.awt.BorderLayout;

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
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileFilter;

public class LicencedFilesPanel extends JPanel {
    private BorderLayout borderLayout1 = new BorderLayout();
    private JLabel jLabel1 = new JLabel();
    private JList licencedFilesList = new JList();
    private JPanel jPanel1 = new JPanel();
    private JButton buttonImportLicence = new JButton();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private DefaultListModel listModel = new DefaultListModel();
    private JButton removeLicenceButton = new JButton();

    public LicencedFilesPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout(borderLayout1);
        jLabel1.setText("Licenced File List:");
        jLabel1.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 0));
        licencedFilesList.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        buttonImportLicence.setText("Import Licence");
        buttonImportLicence.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        buttonImportLicence_actionPerformed(e);
                    }
                });
        removeLicenceButton.setText("Remove Licence");
        removeLicenceButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        removeLicenceButton_actionPerformed(e);
                    }
                });
        this.add(jLabel1, BorderLayout.NORTH);
        jScrollPane1.setViewportView(licencedFilesList);
        this.add(jScrollPane1, BorderLayout.CENTER);
        jPanel1.add(buttonImportLicence, null);
        jPanel1.add(removeLicenceButton, null);
        this.add(jPanel1, BorderLayout.SOUTH);
        licencedFilesList.setModel(listModel);
    }
    

    private void buttonImportLicence_actionPerformed(ActionEvent e) {
        JFileChooser importLicenceDialog = new JFileChooser(){
            {
                try {
                    jbInit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void jbInit() throws Exception {
                this.setMultiSelectionEnabled(false);
                this.addChoosableFileFilter( new FileFilter(){
                    public boolean accept(File file) {
                        return (file.getName().endsWith(".lic") || file.isDirectory());
                    }
                    
                    public String getDescription() {
                        return ("Licenced Files(*.lic)");
                    }            
                });
                this.setDialogTitle("Please choose Licenced files");
                this.setMultiSelectionEnabled(true);
            }
        };
        File[] selectedFiles;
        importLicenceDialog.setApproveButtonText("Select");
        int returnVal = importLicenceDialog.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectedFiles = importLicenceDialog.getSelectedFiles();
            for(File aFile :selectedFiles ){
                listModel.addElement(aFile.getAbsolutePath());
            }
        }
    }


    private void removeLicenceButton_actionPerformed(ActionEvent e) {
        int[] iA = licencedFilesList.getSelectedIndices();
        for(int i = iA.length-1; i>=0; i--){
            listModel.remove(iA[i]);
        }
    }
    
    public Object[] getLicencedFiles(){
        return listModel.toArray();
    }
    
    public void setLicencedFiles(List<String> licencedFiles){
        listModel.removeAllElements();
        for(String aFile : licencedFiles ){
            listModel.addElement(aFile);
        }
    }
    
}
