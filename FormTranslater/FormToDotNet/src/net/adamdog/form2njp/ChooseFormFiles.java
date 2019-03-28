package net.adamdog.form2njp;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class ChooseFormFiles extends JFileChooser {

    public ChooseFormFiles() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setMultiSelectionEnabled(true);
        this.addChoosableFileFilter( new FileFilter(){
            public boolean accept(File file) {
                return (file.getName().endsWith(".fmb") || 
                        file.getName().endsWith(".mmb") || 
                        file.getName().endsWith(".pll") || 
                        file.getName().endsWith(".xml") || file.isDirectory());
            }

            public String getDescription() {
                return ("Forms(*.fmb)|Menus(*.mmb)|PL/SQL Libraries(*.pll)|Oracle XML(*.xml)");
            }            
        });
    }


}
