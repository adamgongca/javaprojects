package net.adamdog.form2njp;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import java.io.FileWriter;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileFilter;

import oracle.jdeveloper.layout.BoxLayout2;
import oracle.jdeveloper.layout.VerticalFlowLayout;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class MainFrame extends JFrame {
    private BorderLayout layoutMain = new BorderLayout();
    private JPanel panelCenter = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenuItem menuFileExit = new JMenuItem();
    private JMenu menuHelp = new JMenu();
    private JMenuItem menuHelpAbout = new JMenuItem();
    private JPanel statusBar = new JPanel();
    private JToolBar fileToolBar = new JToolBar();
    private JToolBar toolsToolBar = new JToolBar();
    private JPanel toolBarPanel = new JPanel();
    private JButton buttonOpen = new JButton();
    private JButton buttonClose = new JButton();
    private JButton buttonHelp = new JButton();
    private ImageIcon imageOpen = new ImageIcon(MainFrame.class.getResource("resource/openfile.gif"));
    private ImageIcon imageClose = new ImageIcon(MainFrame.class.getResource("resource/closefile.gif"));
    private ImageIcon imageHelp = new ImageIcon(MainFrame.class.getResource("resource/help.gif"));
    private ImageIcon imageDotNet = new ImageIcon(MainFrame.class.getResource("resource/dotnet.gif"));
    private ImageIcon imageJava = new ImageIcon(MainFrame.class.getResource("resource/java.gif"));
    private ImageIcon imagePhp = new ImageIcon(MainFrame.class.getResource("resource/php.gif"));
    private ImageIcon imageDataconn = new ImageIcon(MainFrame.class.getResource("resource/dataconn.gif"));
    private ImageIcon imageResize = new ImageIcon(MainFrame.class.getResource("resource/resize.gif"));
    private JMenu menuTools = new JMenu();
    private JMenuItem menuSystemConfigure = new JMenuItem();
    private JMenuItem menuOpen = new JMenuItem();
    private JMenuItem menuSave = new JMenuItem();
    private JMenuItem menuSaveAs = new JMenuItem();
    private JMenuItem menuTran2dotNet = new JMenuItem();
    private JMenuItem menuTran2Java = new JMenuItem();
    private JMenuItem menuTran2Php = new JMenuItem();
    private FilesListPanel filesListPanel = new FilesListPanel();
    private LicencedFilesPanel licencedFilesPanel = new LicencedFilesPanel();
    private JSplitPane jSplitPane1 = new JSplitPane();
    private JSplitPane jSplitPane2 = new JSplitPane();

    private Dataconnection dataconnection = new Dataconnection();
    private String gwtHomeFolder;
    private String antHomeFolder;
    private String packagePrefix;
    private File currentPrjFile;
    private String dotnetTargetFolderStr;
    private static MainFrame aMainFrameInstance;

    private JScrollPane jScrollPane1 = ConsolePane.getInstance();
    private BorderLayout borderLayout1 = new BorderLayout();
    private JPanel statusPanel = new JPanel();
    private JLabel msgLabel1 = new JLabel();
    private JProgressBar translateProgressBar = new JProgressBar();
    private JLabel verMsgLabel = new JLabel();
    private JButton toDotNetButton = new JButton();
    private JButton toJavaButton = new JButton();
    private JButton toPhpButton = new JButton();
    private JButton systemConfigButton = new JButton();
    private BoxLayout2 boxLayout21 = new BoxLayout2();
    private JPanel jPanel1 = new JPanel();
    private JButton clearButton = new JButton();
    private JButton CopyButton = new JButton();
    private VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();
    private JLabel jLabel1 = new JLabel();
    private BoxLayout2 boxLayout22 = new BoxLayout2();

    public MainFrame() {
        try {
            jbInit();
            aMainFrameInstance = this;
            getProjectToDefaultFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MainFrame getAMainFrameInstance(){
        return aMainFrameInstance;
    }
    
    private void jbInit() throws Exception {
        this.setJMenuBar( menuBar );
        this.getContentPane().setLayout( layoutMain );
        panelCenter.setLayout( new BorderLayout() );
        this.setSize(new Dimension(800, 500));
        this.setTitle( "Oracle Form Translater" );
        menuFile.setText( "File" );
        menuFileExit.setText( "Exit" );
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        menuHelp.setText( "Help" );
        menuHelpAbout.setText( "About" );
        menuHelpAbout.setIcon(imageHelp);
        menuHelpAbout.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { helpAbout_ActionPerformed( ae ); } } );
        statusBar.setLayout(borderLayout1);
        statusBar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        fileToolBar.setToolTipText("File Toolbar");
        toolsToolBar.setToolTipText("Tools Toolbar");
        toolBarPanel.setLayout(boxLayout21);
        buttonOpen.setToolTipText( "Open File" );
        buttonOpen.setIcon( imageOpen );
        buttonOpen.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        menuOpen_actionPerformed(e);
                    }
                });
        buttonClose.setToolTipText( "Close File" );
        buttonClose.setIcon( imageClose );
        buttonClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                menuSave_actionPerformed(e);
            }        
        });
        buttonHelp.setToolTipText( "About" );
        buttonHelp.setIcon( imageHelp );
        buttonHelp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                helpAbout_ActionPerformed(e);
            }        
        });
        
        menuTools.setText("Tools");
        menuSystemConfigure.setText("System Configure");
        menuSystemConfigure.setIcon(imageDataconn);
        menuSystemConfigure.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        menuDatabaseConnection_actionPerformed(e);
                    }
                });
        menuOpen.setText("Open");
        menuOpen.setActionCommand("menuOpen");
        menuOpen.setIcon(imageOpen);
        menuOpen.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        menuOpen_actionPerformed(e);
                    }
                });
        menuSave.setText("Save");
        menuSave.setIcon(imageClose);
        menuSave.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        menuSave_actionPerformed(e);
                    }
                });
        menuSaveAs.setText("Save as ...");
        menuSaveAs.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        menuSaveAs_actionPerformed(e);
                    }
                });
        menuTran2dotNet.setText("Translate to .Net");
        menuTran2dotNet.setIcon(imageDotNet);
        menuTran2dotNet.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        menuTran2dotNet_actionPerformed(e);
                    }
                });
        menuTran2Java.setText("Translate to Java");
        menuTran2Java.setIcon(imageJava);
        menuTran2Php.setText("Translate to PHP");
        menuTran2Php.setIcon(imagePhp);
        jSplitPane1.setDividerLocation(450);
        jSplitPane1.setDividerSize(4);
        jSplitPane1.setLastDividerLocation(500);
        jSplitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setDividerLocation(330);
        jSplitPane2.setDividerSize(4);
        jSplitPane2.setLastDividerLocation(300);
        jScrollPane1.setSize(new Dimension(795, 50));
        jScrollPane1.setPreferredSize(new Dimension(9, 60));
        statusPanel.setPreferredSize(new Dimension(10, 20));
        statusPanel.setLayout(boxLayout22);
        msgLabel1.setText("Oracle Forms");
        msgLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        msgLabel1.setPreferredSize(new Dimension(300, 14));
        msgLabel1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        verMsgLabel.setText("Oracle Forms To .Net  Java  PHP Ver 1.0 Copyright 2010");
        verMsgLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        toDotNetButton.setText("Translate to .Net");
        toDotNetButton.setIcon(imageDotNet);
        toDotNetButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        menuTran2dotNet_actionPerformed(e);
                    }
                });
        toJavaButton.setText("Translate to Java");
        toJavaButton.setIcon(imageJava);
        toPhpButton.setText("Translate to PHP");
        toPhpButton.setIcon(imagePhp);
        systemConfigButton.setText("System Configure");
        systemConfigButton.setIcon(imageDataconn);
        systemConfigButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        menuDatabaseConnection_actionPerformed(e);
                    }
                });
        jPanel1.setLayout(verticalFlowLayout1);
        clearButton.setText("Clear");
        clearButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        clearButton_actionPerformed(e);
                    }
                });
        CopyButton.setText("CopyAll");
        CopyButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        CopyButton_actionPerformed(e);
                    }
                });
        jLabel1.setIcon(imageResize);
        menuFile.add(menuOpen);
        menuFile.add(menuSave);
        menuFile.add(menuSaveAs);
        menuFile.addSeparator();
        menuFile.add(menuFileExit);
        menuBar.add(menuFile);
        menuTools.add(menuSystemConfigure);
        menuTools.addSeparator();
        menuTools.add(menuTran2dotNet);
        menuTools.add(menuTran2Java);
        menuTools.add(menuTran2Php);
        menuBar.add(menuTools);
        menuHelp.add(menuHelpAbout);
        menuBar.add(menuHelp);
        statusBar.add(jScrollPane1, BorderLayout.CENTER);
        statusPanel.add(msgLabel1, BorderLayout.WEST);
        statusPanel.add(translateProgressBar, BorderLayout.CENTER);
        statusPanel.add(verMsgLabel, BorderLayout.NORTH);
        statusPanel.add(jLabel1, BorderLayout.EAST);
        statusBar.add(statusPanel, BorderLayout.SOUTH);
        jPanel1.add(clearButton, null);
        jPanel1.add(CopyButton, null);
        statusBar.add(jPanel1, BorderLayout.EAST);
        panelCenter.add(jSplitPane2, BorderLayout.CENTER);
        jSplitPane2.add(statusBar, JSplitPane.BOTTOM);
        fileToolBar.add(buttonOpen);
        fileToolBar.add(buttonClose);
        fileToolBar.add(buttonHelp, null);
        toolsToolBar.add(systemConfigButton, null);
        toolsToolBar.addSeparator();
        toolsToolBar.add(toDotNetButton, null);
        toolsToolBar.add(toJavaButton, null);
        toolsToolBar.add(toPhpButton, null);
        toolBarPanel.add(fileToolBar, "fileToolBar");
        toolBarPanel.add(toolsToolBar, "toolsToolBar");
        jSplitPane2.add(jSplitPane1, JSplitPane.TOP);
        jSplitPane1.add(filesListPanel, JSplitPane.LEFT);
        jSplitPane1.add(licencedFilesPanel, JSplitPane.RIGHT);
        
        this.getContentPane().add(toolBarPanel, BorderLayout.NORTH);
        this.getContentPane().add(panelCenter, BorderLayout.CENTER);
    }

    void fileExit_ActionPerformed(ActionEvent e) {
        saveProjectToDefaultFile();
        System.exit(0);
    }

    void helpAbout_ActionPerformed(ActionEvent e) {
        //JOptionPane.showMessageDialog(this, new MainFrame_AboutBoxPanel1(), "About", JOptionPane.PLAIN_MESSAGE);
        JDialog jdialog = new JDialog(this, true);
        jdialog.setContentPane(new MainFrame_AboutBoxPanel1());
        jdialog.setSize(580, 400);
        jdialog.setResizable(false);
        jdialog.setTitle("About");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = jdialog.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        jdialog.setLocation((screenSize.width - frameSize.width) / 2, 
                            (screenSize.height - frameSize.height) / 2);

        jdialog.setVisible(true);
    }

    private void menuDatabaseConnection_actionPerformed(ActionEvent e) {
        //JOptionPane.showMessageDialog(this, new ConfigDatabaseConnectionPanel(), "Configure Database connection", JOptionPane.PLAIN_MESSAGE);    
        JDialog jdialog = new JDialog(this, true);
        SystemConfigurePanel scp = new SystemConfigurePanel();
        scp.restoreValueFromDataconnection(dataconnection);
        scp.setGwtHomeFolder(gwtHomeFolder);
        scp.setAntHomeFolder(antHomeFolder);
        scp.setPackagePrefix(packagePrefix);
        jdialog.setContentPane(scp);
        jdialog.setSize(520, 400);
        jdialog.setResizable(false);
        jdialog.setTitle("System Configure");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = jdialog.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        jdialog.setLocation((screenSize.width - frameSize.width) / 2, 
                            (screenSize.height - frameSize.height) / 2);

        jdialog.setVisible(true);   
        
        if ("OK".equals(scp.resultStr)){
            dataconnection = scp.backupValueToDataconnection();
            gwtHomeFolder = scp.getGwtHomeFolder();
            antHomeFolder = scp.getAntHomeFolder();
            packagePrefix = scp.getPackagePrefix();
            
        }
    }

    private void menuOpen_actionPerformed(ActionEvent e) {
        JFileChooser openDialog = new JFileChooser(){
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
                        return (file.getName().endsWith(".oft") || file.isDirectory());
                    }

                    public String getDescription() {
                        return ("Project File(*.oft)");
                    }            
                });
                this.setDialogTitle("Open Project file:");
            }
        };
        int returnVal = openDialog.showOpenDialog(this);
        if (returnVal== JFileChooser.APPROVE_OPTION){
            File file = openDialog.getSelectedFile();
            if (file.exists()){
                openProjectFromFile(file);
            } 
        } 
        
    }


    private void menuSave_actionPerformed(ActionEvent e) {
        if (currentPrjFile == null) menuSaveAs_actionPerformed(e) ;
        else saveProjectToFile(currentPrjFile);
    }

    private void menuSaveAs_actionPerformed(ActionEvent e) {
        JFileChooser saveDialog = new JFileChooser(){
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
                        return (file.getName().endsWith(".oft") || file.isDirectory());
                    }
                    
                    public String getDescription() {
                        return ("Project File(*.oft)");
                    }            
                });
                this.setDialogTitle("Save Project as ... :");
            }
        };
        int returnVal = saveDialog.showSaveDialog(this);
        if (returnVal== JFileChooser.APPROVE_OPTION){
            File file = saveDialog.getSelectedFile();
            if (file.exists()){
                if (JOptionPane.showConfirmDialog(new JFrame(),
                        "Do you want to overwrite the existing file ?", "File is exist",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    saveProjectToFile(file);
            } else saveProjectToFile(file);
        } 
    }
    
    private void saveProjectToFile(File file){

        Document document = DocumentHelper.createDocument();
        Element ProjectElement = document.addElement("OracleToNJP");
        ProjectElement.addAttribute("version","1.0");
        ProjectElement.addComment(" This is a project file for Oracle Forms to .NET , JAVA and PHP, Adam Gong, " + 
                                  new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " ");
        Element formFilesElement = ProjectElement.addElement("FormFiles");
        
        for (Object o : filesListPanel.getFormFiles()){
            Element formFileElement = formFilesElement.addElement("FormFile");
            formFileElement.addAttribute("Name", o.toString());
        }

        Element licencedFilesElement = 
            ProjectElement.addElement("LicencedFiles");
        for (Object o : licencedFilesPanel.getLicencedFiles()){
            Element formFileElement = licencedFilesElement.addElement("LicencedFile");
            formFileElement.addAttribute("Name", o.toString());
        }


        Element DataConnectionElement = 
            ProjectElement.addElement("DataConnection");
        DataConnectionElement.addAttribute("HostName", 
                                           dataconnection.getHostName());
        DataConnectionElement.addAttribute("Port", 
                                           dataconnection.getJdbcPort());
        DataConnectionElement.addAttribute("SID", dataconnection.getSidName());
        DataConnectionElement.addAttribute("ServiceName", 
                                           dataconnection.getServicesName());
        DataConnectionElement.addAttribute("UserName", 
                                           dataconnection.getUserName());
        DataConnectionElement.addAttribute("Password", 
                                           dataconnection.getPassword());
        DataConnectionElement.addAttribute("JdbcURL", 
                                           dataconnection.getJdbcStr());

         Element gwtHomeFolderElement = 
             ProjectElement.addElement("GwtHome");
         gwtHomeFolderElement.addAttribute("FolderName", gwtHomeFolder);
        
        Element antHomeFolderElement = 
            ProjectElement.addElement("AntHome");
        antHomeFolderElement.addAttribute("FolderName", antHomeFolder);

        Element packagePrefixElement = 
            ProjectElement.addElement("PackagePrefix");
        packagePrefixElement.addAttribute("PrefixString", packagePrefix);

        Element tran2DotNetElement = 
            ProjectElement.addElement("Tran2DotNet");
        tran2DotNetElement.addAttribute("DotnetTargetFolder", dotnetTargetFolderStr);        

        try {

            XMLWriter writer = new XMLWriter(new FileWriter(file));
            writer.write(document);
            writer.close();

            currentPrjFile = file;

            JOptionPane.showMessageDialog(this, 
                                          "Project already save in " + file.getAbsolutePath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    
    private void openProjectFromFile(File file) {
        SAXReader reader = new SAXReader();
        Document document;
        ArrayList<String> formFilesList = new ArrayList<String>();
        ArrayList<String> licencedFilesList = new ArrayList<String>();
        
        try {
            document = reader.read(file);
            Element ProjectElement = document.getRootElement();
            if (!"OracleToNJP".equals(ProjectElement.getName()))
                JOptionPane.showMessageDialog(this, file.getAbsolutePath() + " is not a vaild project file, Please choose again!");
            else {
                if (ProjectElement.attribute("version") != null && "1.0".equals(ProjectElement.attribute("version").getValue())){
                    Element formFilesElement = ProjectElement.element("FormFiles");
                    if (formFilesElement != null) {
                        Iterator iter1 = formFilesElement.elementIterator("FormFile");
                        while ( iter1.hasNext() ){
                            Object aFormFile = iter1.next();
                            if (aFormFile instanceof Element && ((Element)aFormFile).attribute("Name") != null )
                                formFilesList.add(((Element)aFormFile).attribute("Name").getValue());
                        }
                    }
                    filesListPanel.setFormFiles(formFilesList);
                    Element licencedFilesElement = ProjectElement.element("LicencedFiles");
                    if (licencedFilesElement != null){
                        Iterator iter2 = licencedFilesElement.elementIterator("LicencedFile");
                        while (iter2.hasNext()){
                            Object aLicencedFile  = iter2.next();
                            if (aLicencedFile instanceof Element && ((Element)aLicencedFile).attribute("Name") != null)
                                licencedFilesList.add(((Element)aLicencedFile).attribute("Name").getValue());
                        }
                    }
                    licencedFilesPanel.setLicencedFiles(licencedFilesList);
                    Element DataConnectionElement = ProjectElement.element("DataConnection"); 
                    if (DataConnectionElement != null){
                        Dataconnection datacon = new Dataconnection(); 
                        if (DataConnectionElement.attribute("HostName") != null)
                            datacon.setHostName(DataConnectionElement.attribute("HostName").getValue()); 
                        if (DataConnectionElement.attribute("Port") != null)    
                            datacon.setJdbcPort(DataConnectionElement.attribute("Port").getValue()); 
                        if (DataConnectionElement.attribute("SID") != null)    
                            datacon.setSidName(DataConnectionElement.attribute("SID").getValue());
                        if (DataConnectionElement.attribute("ServiceName") != null)       
                            datacon.setServicesName(DataConnectionElement.attribute("ServiceName").getValue()); 
                        if (DataConnectionElement.attribute("UserName") != null)       
                            datacon.setUserName(DataConnectionElement.attribute("UserName").getValue()); 
                        if (DataConnectionElement.attribute("Password") != null)       
                            datacon.setPassword(DataConnectionElement.attribute("Password").getValue()); 
                        if (DataConnectionElement.attribute("JdbcURL") != null)
                            datacon.setJdbcStr(DataConnectionElement.attribute("JdbcURL").getValue());
                        dataconnection = datacon;
                    }
                    Element gwtHomeFolderElement = ProjectElement.element("GwtHome");
                    if (gwtHomeFolderElement != null)
                        if (gwtHomeFolderElement.attribute("FolderName") != null) gwtHomeFolder = gwtHomeFolderElement.attribute("FolderName").getValue();
                    Element antHomeFolderElement = ProjectElement.element("AntHome");
                    if (antHomeFolderElement != null)
                        if (antHomeFolderElement.attribute("FolderName") != null) antHomeFolder = antHomeFolderElement.attribute("FolderName").getValue();
                    Element packagePrefixElement = ProjectElement.element("PackagePrefix");
                    if (packagePrefixElement != null)
                        if (packagePrefixElement.attribute("PrefixString") != null) packagePrefix = packagePrefixElement.attribute("PrefixString").getValue();
                   
                    Element tran2DotNetElement = ProjectElement.element("Tran2DotNet");
                    if (tran2DotNetElement != null)
                        if (tran2DotNetElement.attribute("DotnetTargetFolder") != null) dotnetTargetFolderStr = tran2DotNetElement.attribute("DotnetTargetFolder").getValue();
                        
                } else {                    
                    JOptionPane.showMessageDialog(this, file.getAbsolutePath() + " is a different version project file, Please choose again!");
                } 
            }
            
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    
    private void menuTran2dotNet_actionPerformed(ActionEvent e) {
    
        while (gwtHomeFolder == null || "".equals(gwtHomeFolder) || antHomeFolder == null || "".equals(antHomeFolder))
            if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "You have to configure the ANT_HOME and GWT_HOME", "Mandatory Configuration",JOptionPane.OK_CANCEL_OPTION) )
                menuDatabaseConnection_actionPerformed(e);
            else return;
        
        TargetFolderPane targetFolderPane = TargetFolderPane.getInstance();
        targetFolderPane.setTargetFolder(dotnetTargetFolderStr);

        JDialog jdialog = new JDialog(this, true);
        jdialog.setContentPane(targetFolderPane);
        jdialog.setSize(360,150);
        jdialog.setResizable(false);
        jdialog.setTitle("Please input target folder ");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = jdialog.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        jdialog.setLocation((screenSize.width - frameSize.width) / 2, 
                            (screenSize.height - frameSize.height) / 2);

        jdialog.setVisible(true);

        if ("NEXT".equalsIgnoreCase(targetFolderPane.getReturnStr())){  
            dotnetTargetFolderStr = targetFolderPane.getTargetFolder();            
            Object[] files = filesListPanel.getFormFiles();
            translateProgressBar.setValue(0);
            translateProgressBar.setMinimum(0);
            translateProgressBar.setMaximum(files.length*4);
            Thread th = new TranslateThread(files,dotnetTargetFolderStr,gwtHomeFolder,antHomeFolder,packagePrefix);
            th.start();
        }
    }
    
    private void clearButton_actionPerformed(ActionEvent e) {
        ConsolePane.getInstance().clearLogMessage();
    }

    private void CopyButton_actionPerformed(ActionEvent e) {
        Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(ConsolePane.getInstance().getLogMessage());
        sysc.setContents(tText, null);
    }
    
    public void stepIt(){
        translateProgressBar.setValue(translateProgressBar.getValue()+1);
    }

    public void stepToEnd(){
        translateProgressBar.setValue(translateProgressBar.getMaximum());
    }
    
     private void saveProjectToDefaultFile() {
        File file = new File("default.oft");
        if (file.exists()) file.delete();
         saveProjectToFile(file);
     }
     
    private void getProjectToDefaultFile() {
       File file = new File("default.oft");
       if (file.exists()) openProjectFromFile(file);
    }
     

    
}
