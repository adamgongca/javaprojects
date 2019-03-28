package net.adamdog.form2njp;

import com.google.gwt.user.tools.WebAppCreator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

import java.awt.image.BufferedImage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;
import java.io.StringReader;

import java.net.URISyntaxException;

import java.security.CodeSource;
import java.security.ProtectionDomain;

import java.util.ArrayList;
import java.util.Date;

import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.HashMap;

import java.util.Hashtable;

import javax.imageio.ImageIO;

import oracle.forms.jdapi.Block;
import oracle.forms.jdapi.Canvas;
import oracle.forms.jdapi.Coordinate;
import oracle.forms.jdapi.Font;
import oracle.forms.jdapi.FormModule;
import oracle.forms.jdapi.Graphics;
import oracle.forms.jdapi.Item;
import oracle.forms.jdapi.RadioButton;
import oracle.forms.jdapi.Jdapi;
import oracle.forms.jdapi.JdapiIterator;
import oracle.forms.jdapi.JdapiModule;
import oracle.forms.jdapi.JdapiObject;
import oracle.forms.jdapi.JdapiTypes;
import oracle.forms.jdapi.Menu;
import oracle.forms.jdapi.MenuItem;
import oracle.forms.jdapi.MenuModule;
import oracle.forms.jdapi.Point;
import oracle.forms.jdapi.TabPage;
import oracle.forms.jdapi.Window;
import oracle.forms.util.xmltools.Forms2XML;
import oracle.xml.parser.v2.XMLDocument;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

public class TranslateThread extends Thread {
    private static final String packagePath = "net/adamdog/form2njp/";
    private static final String newline = System.getProperty("line.separator");

    private Object[] files;
    private String targetFolderStr;
    private String gwtHomeFolder;
    private String antHomeFolder;
    private String packagePrefix;
    
    private Hashtable<String,MenuModule> ManuFiles = new Hashtable<String,MenuModule>();
    
    private double coordinateXCoefficient = 1.3d;
    private double coordinateYCoefficient = 1.3d;
    
    private java.awt.Font defaultFont = new java.awt.Font("Default",0,16);

    public TranslateThread(Object[] fs,String targetFolder,String gwtHome, String antHome,String prefix) {
        files = fs;
        targetFolderStr = targetFolder;
        gwtHomeFolder = gwtHome ;
        antHomeFolder = antHome ;
        packagePrefix = (prefix==null || prefix.equals(""))?"":(prefix + ((".".equals(prefix.substring(prefix.length()-1)))?"":".")) ;
    }

    public void run() {
        boolean flag = false;

        Boolean boolean1 = false; //(Boolean)hashmap.get("OVERWRITE");
        Boolean m_usePropertyIds = 
            false; // ((Boolean)hashmap.get("USE_PROPERTY_IDS")).booleanValue();
        Boolean s_visualState = false; // (Boolean)hashmap.get("VISUALSTATE");
        
        Long cTimeMillis = System.currentTimeMillis();
        
        try
        {
            Jdapi.getProductVersion();
        }
        catch(Exception exception)
        {
            TranslaterUtilities.println();
            TranslaterUtilities.printResourceMessage("init_fail");
            TranslaterUtilities.println(exception.getMessage());
            
        }
        catch(Error error)
        {
            TranslaterUtilities.println();
            TranslaterUtilities.printResourceMessage("init_fail");
            TranslaterUtilities.println(error.getMessage());
            
        }
       
        Object[] filesList = SortMenufileFirst(files);
        
        for (Object f: filesList) {
            try {
                String s1 = f.toString();
                File file = new File(s1);
                String fileName = file.getName();
                fileName = fileName.substring(0,fileName.lastIndexOf('.'));
                
                if (targetFolderStr==null || targetFolderStr.equals("")) targetFolderStr = file.getParent();
                if (targetFolderStr.substring(targetFolderStr.length()-1).equals("\\"))
                    targetFolderStr = targetFolderStr.substring(0,targetFolderStr.length()-1);
                    
                if (!file.exists())
                    TranslaterUtilities.printResourceMessage("file_doesnt_exist", new Object[] { s1 });
                else if (!TranslaterUtilities.isModule(s1)) {
                    TranslaterUtilities.printResourceMessage("not_a_module", new Object[] { s1 });
                } else {
                    TranslaterUtilities.printResourceMessage("process_module", new Object[] { s1 });
                                                             
                    try {
                    
                        JdapiModule module = JdapiModule.openModule(file);
                        
                        //ManuFiles
                        if (module instanceof MenuModule){
                            TranslaterUtilities.stepIt();
                            ManuFiles.put( module.getName(),(MenuModule)module.clone(module, module.getName()));
                            TranslaterUtilities.stepIt();
                            TranslaterUtilities.stepIt();
                        }
                        
                        if (module instanceof FormModule){
                            FormModule formModule = (FormModule)module;
                            calculateCoordinateCoefficient(formModule);
                            String moduleName = formModule.getName();
                            
                            CreatGWTProject(fileName,moduleName);
                            TranslaterUtilities.stepIt();
                            
                            GenerateProjectFiles(fileName, module);
                            TranslaterUtilities.stepIt();
                            
                            AntCompileGWTProject(fileName,moduleName);
                            TranslaterUtilities.stepIt();
                            
                            CopyFilesToGWTProjectAfterCompile(fileName,moduleName);
                        }
                        module.destroy();                           
                    } catch (Exception exception) {
                        TranslaterUtilities.processException(exception);
                        exception.printStackTrace();
                    }
                }
            } catch (Exception exception) {
                TranslaterUtilities.processException(exception);
            }
            TranslaterUtilities.stepIt();
        }
        cTimeMillis = System.currentTimeMillis() - cTimeMillis ;
        long tian = cTimeMillis / 1000 / 3600 / 24 ;
        long shi = cTimeMillis / 1000 / 3600 - 24 * tian;
        long fen = cTimeMillis / 1000 / 60 - (24 * tian + shi) * 60 ;
        long miao = cTimeMillis / 1000 - ((24 * tian + shi) * 60 + fen) * 60;
        
        TranslaterUtilities.printResourceMessage("translate_finish");
        TranslaterUtilities.println("total use:" + ((tian>0)?(tian + "days "):"") +  shi + "h:"  + fen + "m:" + miao + "s");
        TranslaterUtilities.stepToEnd();
    }   

    private Object[] SortMenufileFirst(Object[] files){
        Object[] fileList = new Object[files.length];
        int i = 0;
        int j = files.length - 1;
        for (Object afile: files ) {
            String s = afile.toString().trim().toLowerCase();
            if (s.endsWith(".mmb")) fileList[i++] = s;
            else fileList[j--] = s;
        }
        return fileList;
    }

    private void CreatGWTProject(String fileName,String moduleName){
        
        WebAppCreator.main(new String[]{"-overwrite" , "-out", targetFolderStr ,packagePrefix + fileName.toLowerCase() +"." + moduleName});
        
        String[] willDeleteFiles = {targetFolderStr + "\\src\\" + packagePrefix.replaceAll("\\.","\\\\") + fileName.toLowerCase() + "\\client\\GreetingService.java",
                                targetFolderStr + "\\src\\" + packagePrefix.replaceAll("\\.","\\\\") + fileName.toLowerCase() + "\\client\\GreetingServiceAsync.java", 
                                targetFolderStr + "\\src\\" + packagePrefix.replaceAll("\\.","\\\\") + fileName.toLowerCase() + "\\server\\GreetingServiceImpl.java", 
                                targetFolderStr + "\\src\\" + packagePrefix.replaceAll("\\.","\\\\") + fileName.toLowerCase() + "\\shared\\FieldVerifier.java"
                                };
        for (String willDeleteFile : willDeleteFiles ){
            File fd = new File(willDeleteFile);
            if (fd.exists()) 
                //TODO
                //if (fd.delete()) 
                    System.out.println("delete : " + willDeleteFile);
        }
    }
    
    private void CopyFilesToGWTProjectAfterCompile(String fileName,String moduleName) {
        try {

            ProtectionDomain pd = this.getClass().getProtectionDomain();
            CodeSource cs = pd.getCodeSource();
            File fLoc = new File(cs.getLocation().toURI());

            if (fLoc.isDirectory()){
                if (this.getClass().getResource("resource/template/icons") != null){       
                    File f = new File(this.getClass().getResource("resource/template/icons").toURI());
                    if (f.exists()) copyAllFilesToTargetFolder(f,targetFolderStr + "\\war");   
                    
                    f = new File(this.getClass().getResource("resource/template/gwt").toURI());
                    if (f.exists()) copyAllFilesToTargetFolder(f,targetFolderStr + "\\war\\" + moduleName.toLowerCase() );   
                }
            } else if (fLoc.getName().lastIndexOf(".jar") > 0) {
                    JarFile jarFile = new JarFile(fLoc);
                    CopyFilesFromJarToGWTProject(jarFile, fileName, moduleName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void copyAllFilesToTargetFolder(File f, String folderName ){
        File folder = new File(folderName);
        if (folder.exists()) 
            if(folder.isFile()) 
                if (folder.delete()) copyAllFilesToTargetFolder(f, folderName );
                else copyAllFilesToTargetFolder(f, folderName + "_" + Math.round(Math.random()*100));
            else copyAllFilesToTargetFolder(f,folder);
        else {
            makeTargetFolder(folderName);
            copyAllFilesToTargetFolder(f, folderName );
        }
    }

    private void makeTargetFolder(String folderName){
        File f = new File(folderName);
        if (!f.mkdir()) makeTargetFolder(f.getParent());
        f.mkdir();
    }
    
    private void copyAllFilesToTargetFolder(File f, File folder ){
        if (f.isFile()) copyFile(f,folder);
        if (f.isDirectory()) {
            File t = new File(folder,f.getName());
            t.mkdir();
            File[] fList = f.listFiles();
            for (File f1 : fList) {
                copyAllFilesToTargetFolder(f1, t);
            }
        }
    }


    private  void copyFile(File f, File folder) {
        try {
                int c = (int)f.length();
                FileInputStream in = new FileInputStream(f);
                File x = new File(folder,f.getName());
                FileOutputStream out = new FileOutputStream(x);
                byte[] b = new byte[c];
                in.read(b);
                in.close();
                out.write(b);
                out.close();
            System.out.println("copy : " + f.getAbsolutePath() + " to " + folder.getAbsolutePath() );
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private  void copyFile(JarFile jarFile, JarEntry je, File folder) {
        try {
                InputStream in = jarFile.getInputStream(je);
                int c = (int)je.getSize();
                String s = je.getName();
                s = s.substring(s.lastIndexOf("/"));
                File x = new File(folder,s);
                FileOutputStream out = new FileOutputStream(x);
                byte[] b = new byte[c];
                in.read(b);
                in.close();
                out.write(b);
                out.close();
            System.out.println("copy : " + jarFile.getName() + "!" + je.getName()  + " to " + folder.getAbsolutePath() + " size: " + c);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void CopyFilesFromJarToGWTProject(JarFile jarFile,String fileName, String moduleName){
        copyAllFilesToTargetFolder(jarFile,"resource/template/icons",targetFolderStr + "\\war\\icons");
        copyAllFilesToTargetFolder(jarFile,"resource/template/gwt",targetFolderStr + "\\war\\" + moduleName.toLowerCase() +"\\gwt" );   
    }

    private void copyAllFilesToTargetFolder(JarFile jarFile, String resourcePath, String folderName ){
        File folder = new File(folderName);
        if (folder.exists()) 
            if(folder.isFile()) 
                if (folder.delete()) copyAllFilesToTargetFolder(jarFile,resourcePath, folderName );
                else copyAllFilesToTargetFolder(jarFile, resourcePath, folderName + "_" + Math.round(Math.random()*100));
            else copyAllFilesToTargetFolder(jarFile,resourcePath,folder);
        else {
            makeTargetFolder(folderName);
            copyAllFilesToTargetFolder(jarFile, resourcePath, folderName );
        }
    }

    private void copyAllFilesToTargetFolder(JarFile jarFile, String resourcePath, File folder ){
            ArrayList<JarEntry> jeList = getSubEntries(jarFile, resourcePath) ;
            for (JarEntry je : jeList) {
                String s = je.getName();
                s = s.substring((packagePath + resourcePath).length(),s.lastIndexOf("/"));
                copyAllFilesToTargetFolder(jarFile, je, folder.getAbsolutePath() +  s.replaceAll("/","\\\\") );
            }
    }

    private void copyAllFilesToTargetFolder(JarFile jarFile, JarEntry je, String folderName ){
        File folder = new File(folderName);
        if (folder.exists()) 
            if(folder.isFile()) 
                if (folder.delete()) copyAllFilesToTargetFolder(jarFile,je, folderName );
                else copyAllFilesToTargetFolder(jarFile, je, folderName + "_" + Math.round(Math.random()*100));
            else copyFile(jarFile, je, folder);
        else {
            makeTargetFolder(folderName);
            copyAllFilesToTargetFolder(jarFile, je, folderName );
        }
    }


    private ArrayList<JarEntry> getSubEntries(JarFile jarFile, String resourcePath){
        ArrayList<JarEntry> arrayJE = new ArrayList<JarEntry>();
        Enumeration<JarEntry> enu = jarFile.entries();
        while(enu.hasMoreElements()){
            JarEntry je1 = enu.nextElement();
            if (je1.getName().startsWith(packagePath + resourcePath) )
                arrayJE.add(je1);
        }
        return arrayJE;
    }


    private void saveTemplateStringToTargetFolder(StringTemplate st, String fileName, String folderName ){
        File folder = new File(folderName);
        if (folder.exists()) 
            if(folder.isFile()) 
                if (folder.delete()) saveTemplateStringToTargetFolder(st, fileName, folderName );
                else saveTemplateStringToTargetFolder(st, fileName, folderName + "_" + Math.round(Math.random()*100));
            else saveTemplateStringToTargetFolder(st, fileName,folder);
        else {
            makeTargetFolder(folderName);
            saveTemplateStringToTargetFolder(st, fileName, folderName );
        }
    }
    
    private void saveTemplateStringToTargetFolder(StringTemplate st, String fileName, File folder){
        try {
            File x = new File(folder,fileName);
            BufferedWriter out = new BufferedWriter(new FileWriter(x));
            out.write(st.toString().replaceAll("&#60","<").replaceAll("&#62",">"));
            out.close();
            System.out.println("Generated : " + fileName + " to " + folder.getAbsolutePath() );
        } catch (Exception e1) {
            e1.printStackTrace();
        }    
    }

    private void AntCompileGWTProject(String fileName,String moduleName){
        System.out.println("Compiling ......");
        System.setProperty("ant.home",antHomeFolder);
        System.setProperty("gwt.sdk",gwtHomeFolder);
        try {
           File buildFile = new File(targetFolderStr+"\\build.xml");
           Project ant_Project = new Project();
           ant_Project.init();
           ProjectHelper helper = ProjectHelper.getProjectHelper();
           helper.parse(ant_Project, buildFile);
           ant_Project.executeTarget(ant_Project.getDefaultTarget());
           ant_Project.fireBuildFinished(null);
          } catch (Exception e) {
             e.printStackTrace();
          }
        System.out.println("Compiling is done!");
    }
    
    
    private StringTemplateGroup getStringTemplateGroup(String templateName){
        try {

            ProtectionDomain pd = this.getClass().getProtectionDomain();
            CodeSource cs = pd.getCodeSource();
            File fLoc = new File(cs.getLocation().toURI());

            if (fLoc.isDirectory()){
                if (this.getClass().getResource("resource/template") != null){       
                    File f = new File(this.getClass().getResource("resource/template/" + templateName).toURI());
                    if (f.exists()) {
                        FileReader fr = new FileReader(f);
                        StringTemplateGroup group =  new StringTemplateGroup(fr);     
                        fr.close();
                        return group;
                    } else return null;
                } else return null;
            } else if (fLoc.getName().lastIndexOf(".jar") > 0) {
                    JarFile jarFile = new JarFile(fLoc);
                    ArrayList<JarEntry> jeList = getSubEntries(jarFile, "resource/template/" + templateName) ;                    
                    if (jeList.size()>0){
                        JarEntry je = jeList.get(0);
                        InputStream is = jarFile.getInputStream(je);
                        InputStreamReader isr = new InputStreamReader(is);
                        StringTemplateGroup group =  new StringTemplateGroup(isr);
                        isr.close();
                        is.close();
                        return group;                        
                    } else return null;
                } else return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private void GenerateProjectFiles(String oraFileName, JdapiModule module){
        if (module instanceof FormModule)
            GenerateFormProjectFiles(oraFileName, (FormModule) module);
    }
    
    
    private void GenerateFormProjectFiles(String oraFileName, FormModule formmodule){

        //======= gegerate main page
        StringTemplateGroup forms2gwt = getStringTemplateGroup("forms2gwt.stg");
        if (forms2gwt != null) {
            final StringTemplate mainpageTemplate = forms2gwt.getInstanceOf("mainpageTpl");            
            mainpageTemplate.reset();
            mainpageTemplate.setAttribute("module", formmodule);
            mainpageTemplate.setAttribute("packageprefix", packagePrefix + oraFileName.toLowerCase() +"." );
            mainpageTemplate.setAttribute("classname",formmodule.getName());
        
            final StringTemplate canvasTemplate = forms2gwt.getInstanceOf("canvasTpl");
            final StringTemplate windowTemplate = forms2gwt.getInstanceOf("windowTpl");
            final StringTemplate graphicsTemplate = forms2gwt.getInstanceOf("graphicsTpl");
            final StringTemplate blockitemTemplate = forms2gwt.getInstanceOf("blockitemTpl");
            
            String initializeMenuStr = formmodule.getInitializeMenu();
            String menuModuleStr = formmodule.getMenuModule().toUpperCase();
            
            boolean useDefaultMenu = menuModuleStr.indexOf("DEFAULT")>=0;
            boolean useSmartbar = menuModuleStr.indexOf("SMARTBAR")>=0;
            mainpageTemplate.setAttribute("useDefaultMenu", useDefaultMenu);
            mainpageTemplate.setAttribute("useSmartbar", useSmartbar);
                      
            
            Menu mainMenu = null;
            Menu initializeMenu = null;
            
            if (!useDefaultMenu && !useSmartbar && menuModuleStr != null && !menuModuleStr.equals("")){
                MenuModule m = ManuFiles.get(menuModuleStr);
                if (m != null) {
                    String mainMenuStr = m.getMainMenu();
                    JdapiIterator menus =  m.getMenus();
                    while (menus.hasNext()){
                        Menu mitem = (Menu)menus.next();
                        if (mitem.getName().equals(mainMenuStr)) mainMenu = mitem;
                        if (mitem.getName().equals(initializeMenuStr)) initializeMenu = mitem;
                    }
                    if (initializeMenu != null) mainMenu = initializeMenu;
                    if (mainMenu != null){
                        StringBuffer codesBuffer = new StringBuffer();
                        GenerateMenuCodes(codesBuffer,mainMenu,(MenuModule)m.clone(m,m.getName()));
                        mainpageTemplate.setAttribute("useCustomizedMenu",true);
                        mainpageTemplate.setAttribute("mainmenu",mainMenu.getName());
                        mainpageTemplate.setAttribute("customizedMenuCodes",codesBuffer.toString());                        
                    }else{
                        mainpageTemplate.setAttribute("useCustomizedMenu",false);
                        mainpageTemplate.setAttribute("mainmenu","");
                        mainpageTemplate.setAttribute("customizedMenuCodes","");
                    }
                } else {
                    mainpageTemplate.setAttribute("useCustomizedMenu",false);
                    mainpageTemplate.setAttribute("mainmenu","");
                    mainpageTemplate.setAttribute("customizedMenuCodes","");                    
                }
            } else {
                mainpageTemplate.setAttribute("useCustomizedMenu",false);
                mainpageTemplate.setAttribute("mainmenu","");
                mainpageTemplate.setAttribute("customizedMenuCodes","");
            }
            JdapiIterator  Canvases =  formmodule.getCanvases(); 
            StringBuilder canvansescodeSB = new StringBuilder();
            HashMap<String, StringBuilder> CanvansMap = new HashMap<String, StringBuilder>();
            
            while (Canvases.hasNext()) {
                canvasTemplate.reset();
                Canvas c = (Canvas)Canvases.next();
                canvasTemplate.setAttribute("canvas",c);
                canvasTemplate.setAttribute("canvasname",c.getName());

                
                boolean isCanvasTypeContent = false;
                boolean isCanvasTypeStacked = false;
                boolean isCanvasTypeVToolbar = false;
                boolean isCanvasTypeHToolbar = false;
                boolean isCanvasTypeTab = false;
                StringBuilder tabconvascodeSB = new StringBuilder();
                
                switch (c.getCanvasType()) {
                //JdapiTypes.CNTY_CONTENT_CTID, JdapiTypes.CNTY_STACKED_CTID, JdapiTypes.CNTY_VTOOLBAR_CTID, JdapiTypes.CNTY_HTOOLBAR_CTID, JdapiTypes.CNTY_TAB_CTID
                    case 0 /* JdapiTypes.CNTY_CONTENT_CTID */ : 
                            isCanvasTypeContent = true ; 
                            canvasTemplate.setAttribute("backgroundimage", generateCanvasBackimage(c,oraFileName, formmodule));
                            canvasTemplate.setAttribute("backgroundimagewidth",formsX2Page(c.getWidth()));
                            canvasTemplate.setAttribute("backgroundimageheight",formsX2Page(c.getHeight()));                            
                        break;
                    case 1 /* JdapiTypes.CNTY_STACKED_CTID */ : 
                            isCanvasTypeStacked = true ; 
                            canvasTemplate.setAttribute("backgroundimage", generateCanvasBackimage(c,oraFileName, formmodule));
                            canvasTemplate.setAttribute("backgroundimagewidth",formsX2Page(c.getViewportWidth()));
                            canvasTemplate.setAttribute("backgroundimageheight",formsX2Page(c.getViewportHeight()));                            
                            StringBuilder stackedcanvansSb = null;
                            if (CanvansMap.keySet().contains(c.getWindowName())){
                                stackedcanvansSb = CanvansMap.get(c.getWindowName());
                            }else {
                                stackedcanvansSb = new StringBuilder();
                           }
                            stackedcanvansSb.append("" + c.getWindowName() +  ".addComponent(" + c.getName() + ", " + formsX2Page(c.getViewportXPosition()) + ", " + formsX2Page(c.getViewportYPosition()) + ");\n");
                            CanvansMap.put(c.getWindowName(),stackedcanvansSb);
                        break;
                    case 2 /* JdapiTypes.CNTY_VTOOLBAR_CTID */ : isCanvasTypeVToolbar = true ; break;
                    case 3 /* JdapiTypes.CNTY_HTOOLBAR_CTID */ : isCanvasTypeHToolbar = true ; break;
                    case 4 /* JdapiTypes.CNTY_TAB_CTID */ : 
                            isCanvasTypeTab = true ; 
                            JdapiIterator tabpages = c.getTabPages();
                            canvasTemplate.setAttribute("backgroundimage", generateCanvasBackimage(c,oraFileName, formmodule));
                            canvasTemplate.setAttribute("backgroundimagewidth",formsX2Page(c.getViewportWidth()));
                            canvasTemplate.setAttribute("backgroundimageheight",formsX2Page(c.getViewportHeight()));   
                    
                            while (tabpages.hasNext()) {
                                TabPage p = (TabPage)tabpages.next();
                                tabconvascodeSB.append("                 final AbsolutePanel " + c.getName() + "_" + p.getName() + " = new AbsolutePanel();\n");
                                tabconvascodeSB.append("                 " + c.getName() + "_" + p.getName() + ".getElement().setId(\"" + c.getName() + "_" + p.getName() + "\");\n");
                                tabconvascodeSB.append("                 DOM.setStyleAttribute(" + c.getName() + "_" + p.getName() + ".getElement(), \"position\", \"\");\n ");            
                                //tabconvascodeSB.append("                 " + c.getName() + "_" + p.getName() + ".setSize(\"" + c.getWidth() + "\", \"" + ( c.getViewportHeight()- 30 ) + "\");\n");         
                                tabconvascodeSB.append("                 final Image " +  c.getName() + "_" + p.getName() + "backimage =new Image(\""+ generateTabPageBackimage(p,oraFileName, formmodule) +"\");\n ");            
                                tabconvascodeSB.append("                 " + c.getName() + "_" + p.getName() + "backimage.setSize(\"" + formsX2Page(c.getViewportWidth()) + "\", \"" + formsX2Page(c.getViewportWidth()) + "\");\n ");            
                                tabconvascodeSB.append("                 " + c.getName() + "_" + p.getName() + ".add(" +  c.getName() + "_" + p.getName() + "backimage);\n ");                                            
                                tabconvascodeSB.append("                 " + c.getName()  +".add(" + c.getName() + "_" + p.getName() + ", \"" + p.getLabel() + "\");\n");
                            }
                            StringBuilder tabcanvansSb = null;
                            if (CanvansMap.keySet().contains(c.getWindowName())){
                                tabcanvansSb = CanvansMap.get(c.getWindowName());
                            }else {
                                tabcanvansSb = new StringBuilder();
                            }
                            tabcanvansSb.append("" + c.getWindowName() +  ".addComponent(" + c.getName() + ", " + formsX2Page(c.getViewportXPosition()) + ", " + formsX2Page(c.getViewportYPosition()) + ");\n");
                            CanvansMap.put(c.getWindowName(),tabcanvansSb);                            
                            
                        break;
                }
                
                
                 canvasTemplate.setAttribute("isCanvasTypeContent",isCanvasTypeContent);
                 canvasTemplate.setAttribute("isCanvasTypeStacked",isCanvasTypeStacked);
                 
                 canvasTemplate.setAttribute("isCanvasTypeTab",isCanvasTypeTab);
                 canvasTemplate.setAttribute("tabconvaswidth",formsX2Page(c.getViewportWidth()));
                 canvasTemplate.setAttribute("tabconvasheight",formsX2Page(c.getViewportHeight() - 35 ));
                 canvasTemplate.setAttribute("tabconvascode",tabconvascodeSB.toString());

                
                int xoffset =0;
                int yoffset =0;
                if (c.getCanvasType() == JdapiTypes.CNTY_CONTENT_CTID){
                    Window w = getWindowByName(formmodule,c.getWindowName());
                    if (w!=null) {
                        Canvas ch = getCanvasByName(formmodule,w.getHorizontalToolbarCanvasName());
                        if (ch!=null) yoffset = formsY2Page(ch.getHeight());
                        Canvas cv = getCanvasByName(formmodule,w.getVerticalToolbarCanvasName());
                        if (cv!=null) xoffset = formsX2Page(cv.getWidth());
                    }
                } else 
                if (c.getCanvasType() == JdapiTypes.CNTY_VTOOLBAR_CTID){
                    Window w = getWindowByName(formmodule,c.getWindowName());
                    if (w!=null) {
                        if (w.getVerticalToolbarCanvasName()==null || w.getVerticalToolbarCanvasName().equals(""))
                            w.setVerticalToolbarCanvasName(c.getName());
                        Canvas ch = getCanvasByName(formmodule,w.getHorizontalToolbarCanvasName());
                        if (ch!=null) yoffset = formsY2Page(ch.getHeight());
                    }                    
                } else 
                if (c.getCanvasType() == JdapiTypes.CNTY_HTOOLBAR_CTID){
                    Window w = getWindowByName(formmodule,c.getWindowName());
                    if (w!=null) {
                        if (w.getHorizontalToolbarCanvasName()==null || w.getHorizontalToolbarCanvasName().equals(""))
                            w.setHorizontalToolbarCanvasName(c.getName());
                    }                    
                } else 
                if (c.getCanvasType() == JdapiTypes.CNTY_TAB_CTID){
                        yoffset = 40;
                        xoffset = 10;
                }                
                 //JdapiTypes.CNTY_CONTENT_CTID, 
                 //JdapiTypes.CNTY_STACKED_CTID, 
                 //JdapiTypes.CNTY_VTOOLBAR_CTID, 
                 //JdapiTypes.CNTY_HTOOLBAR_CTID, 
                 //JdapiTypes.CNTY_TAB_CTID
                StringBuilder sbCodes = new StringBuilder();
                if (c.getCanvasType() == JdapiTypes.CNTY_TAB_CTID){
                    JdapiIterator pages = c.getTabPages();
                    while (pages.hasNext()){
                        TabPage tp = (TabPage)pages.next();
                        JdapiIterator Graphicses =  tp.getGraphicses();
                        StringBuilder sb = generateGraphicsCode(Graphicses, graphicsTemplate,  c, tp , oraFileName,  formmodule,  xoffset,  yoffset);
                        sbCodes.append(sb);
                        sbCodes.append(newline);
                    }
                } else {
                    JdapiIterator Graphicses =  c.getGraphicses();
                    StringBuilder sb = generateGraphicsCode(Graphicses, graphicsTemplate,  c,  oraFileName,  formmodule,  xoffset,  yoffset);
                    sbCodes.append(sb);
                    sbCodes.append(newline);
                }
                 
                canvasTemplate.setAttribute("graphicsescode",sbCodes.toString());
                canvansescodeSB.append(canvasTemplate.toString());
                canvansescodeSB.append(newline);
                
             }
            mainpageTemplate.setAttribute("canvasescode", canvansescodeSB.toString());
            
            JdapiIterator Blocks = formmodule.getBlocks();
            StringBuilder blockscodeSB = new StringBuilder();
            while (Blocks.hasNext()){
                Block b = (Block)Blocks.next();
                JdapiIterator Items = b.getItems();
                while (Items.hasNext()){
                    Item item = (Item)Items.next();
                    
                    int itemdisplay = item.getItemsDisplay();
                    if (itemdisplay==0) itemdisplay = b.getRecordsDisplayCount();
                    int recordOrientation = b.getRecordOrientation(); //JdapiTypes.REOR_VERTICAL_CTID, JdapiTypes.REOR_HORIZONTAL_CTID
                    //int promptDisplayStyle = item.getPromptDisplayStyle(); //JdapiTypes.PRDI_HIDDEN_CTID, JdapiTypes.PRDI_FIRST_CTID, JdapiTypes.PRDI_EACH_CTID
                    
                    int xoffset =0;
                    int yoffset =0;
                    Canvas c = getCanvasByName(formmodule,item.getCanvasName());
                    if (c!=null){
                        if (c.getCanvasType() == JdapiTypes.CNTY_CONTENT_CTID){
                            Window w = getWindowByName(formmodule,c.getWindowName());
                            if (w!=null) {
                                Canvas ch = getCanvasByName(formmodule,w.getHorizontalToolbarCanvasName());
                                if (ch!=null) yoffset = formsY2Page(ch.getHeight());
                                Canvas cv = getCanvasByName(formmodule,w.getVerticalToolbarCanvasName());
                                if (cv!=null) xoffset = formsX2Page(cv.getWidth());
                            }
                        } else 
                        if (c.getCanvasType() == JdapiTypes.CNTY_VTOOLBAR_CTID){
                            Window w = getWindowByName(formmodule,c.getWindowName());
                            if (w!=null) {
                                Canvas ch = getCanvasByName(formmodule,w.getHorizontalToolbarCanvasName());
                                if (ch!=null) yoffset = formsY2Page(ch.getHeight());
                            }                    
                        }
                        if (c.getCanvasType() == JdapiTypes.CNTY_TAB_CTID){
                                yoffset = 40;
                                xoffset = 10;
                        }
                    }
                    
                    for (int i=0; i< itemdisplay; i++ ){
                        String canvasname = item.getCanvasName();
                        if (canvasname == null || canvasname.equals("")) canvasname = null;
                        else {
                            Canvas c1 = getCanvasByName(formmodule,canvasname);
                            if (c1 != null && c1.getCanvasType() == JdapiTypes.CNTY_TAB_CTID){
                                String sp = item.getTabPageName();
                                if (sp != null && !sp.equals("")) canvasname = c1.getName() + "_" + sp; 
                            }
                        }
                        
                        boolean isImage_ItemType = false;
                        boolean isCheckbox_ItemType = false;
                        boolean isDisplayItem_ItemType = false;
                        boolean isListItem_ItemType = false;
                        boolean isPushButton_ItemType = false;
                        boolean isRadioGroup_ItemType = false;
                        boolean isTextItem_ItemType = false;
                        boolean isHierarchicalTree_ItemType = false;
                        
                        switch (item.getItemType()) {
                            case 0 /*JdapiTypes.ITTY_BA_CTID*/ : continue; 
                            case 1/*JdapiTypes.ITTY_CA_CTID*/ :  continue; 
                            case 2/*JdapiTypes.ITTY_CB_CTID*/ :  isCheckbox_ItemType = true;  break; 
                            case 3/*JdapiTypes.ITTY_DI_CTID*/ :  isDisplayItem_ItemType = true;  break; 
                            case 4/*JdapiTypes.ITTY_TREE_CTID*/ :  isHierarchicalTree_ItemType = true;  break; 
                            case 5/*JdapiTypes.ITTY_IM_CTID  Image */  : isImage_ItemType = true;  break;
                            case 6/*JdapiTypes.ITTY_LS_CTID  List Item*/ : isListItem_ItemType = true;   break;
                            case 7/*JdapiTypes.ITTY_PB_CTID  Push Button*/ : isPushButton_ItemType = true; break;
                            case 8/*JdapiTypes.ITTY_RD_CTID  Radio Group*/ : isRadioGroup_ItemType = true; break;
                            case 9/*JdapiTypes.ITTY_TI_CTID  Text Item*/ : isTextItem_ItemType = true; break;
                            case 10/*JdapiTypes.ITTY_UA_CTID User Area*/ : continue; 
                            case 11/*JdapiTypes.ITTY_ACTION_CTID ActiveX Control*/ : continue; 
                            case 12/*JdapiTypes.ITTY_OLE_CTID  OLE Container*/ : continue; 
                            case 13/*JdapiTypes.ITTY_SN_CTID  Sound*/ : continue; 
                            case 14/*JdapiTypes.ITTY_VBX_CTID JdapiTypes.ITTY_MAXIMUM_CTID VBX Control*/ : continue; 

                        }
                        
                        
                        if (isRadioGroup_ItemType){
                            JdapiIterator radioButtons = item.getRadioButtons();
                            int rbCount = 0 ;
                            ArrayList<RadioButton> radioButtonArrayList = new ArrayList<RadioButton>();
                            while (radioButtons.hasNext()){
                                RadioButton rb = (RadioButton) radioButtons.next();
                                radioButtonArrayList.add(rb);
                                rbCount++ ;
                            }
                            
                            int radiobuttonNo = 0 ;
                            for (RadioButton rb: radioButtonArrayList){
                                int promptDisplayStyle = rb.getPromptDisplayStyle(); //JdapiTypes.PRDI_HIDDEN_CTID, JdapiTypes.PRDI_FIRST_CTID, JdapiTypes.PRDI_EACH_CTID
                                java.awt.Font itemfont = getItemFont(rb,item);
                                java.awt.Font rbPromptfont = getItemPromptFont(rb,item);

                                int x =0 ;
                                int y =0 ;
                                if (recordOrientation == JdapiTypes.REOR_VERTICAL_CTID){
                                    x = rb.getXPosition();
                                    y = rb.getYPosition() + ((rb.getDistanceBetweenRecords() + rb.getHeight()) * i);
                                } else {
                                    //  JdapiTypes.REOR_HORIZONTAL_CTID;
                                     x = rb.getXPosition() + (rb.getDistanceBetweenRecords() + rb.getWidth()) * i;
                                     y = rb.getYPosition();
                                }

                                blockitemTemplate.reset();
                                blockitemTemplate.setAttribute("radiobuttonNo", radiobuttonNo);
                                blockitemTemplate.setAttribute("radiobuttonItemLabel",rb.getLabel());

                                blockitemTemplate.setAttribute("block",b);
                                blockitemTemplate.setAttribute("blockitem",rb);
                                blockitemTemplate.setAttribute("blockitemname",b.getName()+"_"+ item.getName());
                                blockitemTemplate.setAttribute("canvasname", canvasname);

                                blockitemTemplate.setAttribute("initialize", i==0 && radiobuttonNo==0 );
                                blockitemTemplate.setAttribute("displaycount", itemdisplay);
                                blockitemTemplate.setAttribute("itemno", i);
                                blockitemTemplate.setAttribute("isTextItemItemType_OR_isDisplayItemItemType", isDisplayItem_ItemType || isTextItem_ItemType);
                                blockitemTemplate.setAttribute("isCheckboxItemType", isCheckbox_ItemType);
                                blockitemTemplate.setAttribute("isDisplayItemItemType", isDisplayItem_ItemType);
                                blockitemTemplate.setAttribute("isImageItemType", isImage_ItemType );
                                blockitemTemplate.setAttribute("isListItemItemType",isListItem_ItemType); 
                                blockitemTemplate.setAttribute("isPushButtonItemType",isPushButton_ItemType);
                                blockitemTemplate.setAttribute("isRadioGroupItemType",isRadioGroup_ItemType);
                                blockitemTemplate.setAttribute("isTextItemItemType",isTextItem_ItemType);
                                blockitemTemplate.setAttribute("isHierarchicalTreeItemType", isHierarchicalTree_ItemType);
                                blockitemTemplate.setAttribute("buttonlabel",item.getLabel());
                                //JdapiTypes.LSST_POPLIST_CTID, JdapiTypes.LSST_TLIST_CTID, JdapiTypes.LSST_COMBO_CTID
                                blockitemTemplate.setAttribute("liststyle", (item.getListStyle() == JdapiTypes.LSST_TLIST_CTID)?"true":"false" ) ;
                                blockitemTemplate.setAttribute("checkboxItemLabel", item.getLabel());
                                blockitemTemplate.setAttribute("radiobuttonGroup",item.getName());
                                blockitemTemplate.setAttribute("blockitemx",formsX2Page(x + xoffset));
                                blockitemTemplate.setAttribute("blockitemy",formsY2Page(y + yoffset));
                                 
                                blockitemTemplate.setAttribute("blockitemwidth",Math.max(0,formsX2Page(rb.getWidth()) -2 -2 ));
                                blockitemTemplate.setAttribute("blockitemheight",Math.max(0,formsY2Page(rb.getHeight()) -2 -2));
                                java.awt.Point p = getPromptPoint(rb,x + xoffset,y + yoffset,rbPromptfont);
                                blockitemTemplate.setAttribute("promptx",formsX2Page(p.x));
                                blockitemTemplate.setAttribute("prompty",formsY2Page(p.y));
                                blockitemTemplate.setAttribute("hasprompt", !(rb.getPrompt()==null || rb.getPrompt().equals("")) && ((promptDisplayStyle==JdapiTypes.PRDI_FIRST_CTID && i==0) || (promptDisplayStyle==JdapiTypes.PRDI_EACH_CTID)));
                                blockitemTemplate.setAttribute("prompthide", promptDisplayStyle==JdapiTypes.PRDI_HIDDEN_CTID);
                                blockitemTemplate.setAttribute("promptfirst", promptDisplayStyle==JdapiTypes.PRDI_FIRST_CTID);
                                blockitemTemplate.setAttribute("promptall", promptDisplayStyle==JdapiTypes.PRDI_EACH_CTID);                        
                                blockitemTemplate.setAttribute("blockitemfontfamily",itemfont.getFontName());
                                blockitemTemplate.setAttribute("blockitemfontsize",itemfont.getSize());
                                blockitemTemplate.setAttribute("blockitempromptfontfamily",rbPromptfont.getFontName());
                                blockitemTemplate.setAttribute("blockitempromptfontsize",rbPromptfont.getSize());
                                blockitemTemplate.setAttribute("radiobuttonCount",rbCount);
                                blockscodeSB.append(blockitemTemplate.toString());
                                blockscodeSB.append(newline);                        
                                radiobuttonNo ++ ;
                            }
                        } else {
                            int x =0 ;
                            int y =0 ;
                            if (recordOrientation == JdapiTypes.REOR_VERTICAL_CTID){
                                x = item.getXPosition();
                                y = item.getYPosition() + ((item.getDistanceBetweenRecords()+item.getHeight()) *i);
                            } else {
                                //  JdapiTypes.REOR_HORIZONTAL_CTID;
                                 x = item.getXPosition() + (item.getDistanceBetweenRecords()+item.getWidth())*i;
                                 y = item.getYPosition();
                            }

                            int promptDisplayStyle = item.getPromptDisplayStyle(); //JdapiTypes.PRDI_HIDDEN_CTID, JdapiTypes.PRDI_FIRST_CTID, JdapiTypes.PRDI_EACH_CTID
                            java.awt.Font itemfont = getItemFont(item);
                            java.awt.Font itemPromptfont = getItemPromptFont(item);

                            blockitemTemplate.reset();
                            blockitemTemplate.setAttribute("block",b);
                            blockitemTemplate.setAttribute("blockitem",item);
                            blockitemTemplate.setAttribute("blockitemname",b.getName()+"_"+ item.getName());
                            blockitemTemplate.setAttribute("canvasname", canvasname);

                            blockitemTemplate.setAttribute("initialize", i==0);
                            blockitemTemplate.setAttribute("displaycount", itemdisplay);
                            blockitemTemplate.setAttribute("itemno", i);
                            blockitemTemplate.setAttribute("isTextItemItemType_OR_isDisplayItemItemType", isDisplayItem_ItemType || isTextItem_ItemType);
                            blockitemTemplate.setAttribute("isCheckboxItemType", isCheckbox_ItemType);
                            blockitemTemplate.setAttribute("isDisplayItemItemType", isDisplayItem_ItemType);
                            blockitemTemplate.setAttribute("isImageItemType", isImage_ItemType );
                            blockitemTemplate.setAttribute("isListItemItemType",isListItem_ItemType); 
                            blockitemTemplate.setAttribute("isPushButtonItemType",isPushButton_ItemType);
                            blockitemTemplate.setAttribute("isRadioGroupItemType",isRadioGroup_ItemType);
                            blockitemTemplate.setAttribute("isTextItemItemType",isTextItem_ItemType);
                            blockitemTemplate.setAttribute("isHierarchicalTreeItemType", isHierarchicalTree_ItemType);
                            blockitemTemplate.setAttribute("buttonlabel",item.getLabel());
                            //JdapiTypes.LSST_POPLIST_CTID, JdapiTypes.LSST_TLIST_CTID, JdapiTypes.LSST_COMBO_CTID
                            blockitemTemplate.setAttribute("liststyle", (item.getListStyle() == JdapiTypes.LSST_TLIST_CTID)?"true":"false" ) ;
                            blockitemTemplate.setAttribute("checkboxItemLabel", item.getLabel());
                            blockitemTemplate.setAttribute("radiobuttonGroup",item.getName());
                            blockitemTemplate.setAttribute("blockitemx",formsX2Page(x + xoffset));
                            blockitemTemplate.setAttribute("blockitemy",formsY2Page(y + yoffset));
                            
                            blockitemTemplate.setAttribute("blockitemwidth",Math.max(0,formsX2Page(item.getWidth()) -2 -2 ));
                            blockitemTemplate.setAttribute("blockitemheight",Math.max(0,formsY2Page(item.getHeight()) -2 -2));
                            java.awt.Point p = getPromptPoint(item,x + xoffset,y + yoffset,itemPromptfont);
                            blockitemTemplate.setAttribute("promptx",formsX2Page(p.x));
                            blockitemTemplate.setAttribute("prompty",formsY2Page(p.y));
                            blockitemTemplate.setAttribute("hasprompt", !(item.getPrompt()==null || item.getPrompt().equals("")) && ((promptDisplayStyle==JdapiTypes.PRDI_FIRST_CTID && i==0) || (promptDisplayStyle==JdapiTypes.PRDI_EACH_CTID)));
                            blockitemTemplate.setAttribute("prompthide", promptDisplayStyle==JdapiTypes.PRDI_HIDDEN_CTID);
                            blockitemTemplate.setAttribute("promptfirst", promptDisplayStyle==JdapiTypes.PRDI_FIRST_CTID);
                            blockitemTemplate.setAttribute("promptall", promptDisplayStyle==JdapiTypes.PRDI_EACH_CTID);                        
                            blockitemTemplate.setAttribute("blockitemfontfamily",itemfont.getFontName());
                            blockitemTemplate.setAttribute("blockitemfontsize",itemfont.getSize());
                            blockitemTemplate.setAttribute("blockitempromptfontfamily",itemPromptfont.getFontName());
                            blockitemTemplate.setAttribute("blockitempromptfontsize",itemPromptfont.getSize());
                            blockitemTemplate.setAttribute("radiobuttonCount",0);
                            blockitemTemplate.setAttribute("radiobuttonNo",0);
                            blockitemTemplate.setAttribute("radiobuttonItemLabel","");
                            
                            blockscodeSB.append(blockitemTemplate.toString());
                            blockscodeSB.append(newline);
                        }
                    }
                }
                
            }
            
            mainpageTemplate.setAttribute("blockscode", blockscodeSB.toString());
            
            JdapiIterator  Windows =  formmodule.getWindows(); 
            StringBuilder windowscodeSB = new StringBuilder();
            while (Windows.hasNext()) {
                windowTemplate.reset();
                Window w = (Window)Windows.next();
                windowTemplate.setAttribute("window",w);
                windowTemplate.setAttribute("windowname", w.getName());
                windowTemplate.setAttribute("windowwidth",formsX2Page(w.getWidth()));
                windowTemplate.setAttribute("windowheight",formsY2Page(w.getHeight()) + 5 );
                windowTemplate.setAttribute("windowx",formsX2Page(w.getXPosition()));
                windowTemplate.setAttribute("windowy",formsY2Page(w.getYPosition()));
                String pc =  w.getPrimaryCanvas(); 
                String htc =  w.getHorizontalToolbarCanvasName(); 
                String vtc =  w.getVerticalToolbarCanvasName(); 
                if ( (pc == null || pc.equals("")) && (htc == null || htc.equals("")) && (vtc == null || vtc.equals("")) ) {
                    windowTemplate.setAttribute("primarycanvas", getWindowDefautCanvan(formmodule,w.getName()));
                    windowTemplate.setAttribute("horizontaltoolbarcanvas", null);
                    windowTemplate.setAttribute("verticaltoolbarcanvas", null);
                    windowTemplate.setAttribute("horizontaltoolbarcanvasheigh", 0);
                    windowTemplate.setAttribute("verticaltoolbarcanvaswidth", 0); 
                } else {
                    windowTemplate.setAttribute("primarycanvas", pc);
                    windowTemplate.setAttribute("horizontaltoolbarcanvas", (htc==null || htc.equals(""))?null:htc );
                    windowTemplate.setAttribute("verticaltoolbarcanvas", (vtc==null || vtc.equals(""))?null:vtc );
                    Canvas c= getCanvasByName(formmodule,htc);
                    windowTemplate.setAttribute("horizontaltoolbarcanvasheigh", (c==null)?0:formsY2Page(c.getHeight()));
                    c= getCanvasByName(formmodule,vtc);
                    windowTemplate.setAttribute("verticaltoolbarcanvaswidth", (c==null)?0:formsX2Page(c.getWidth()));             
                }
                
                if (CanvansMap.keySet().contains(w.getName())){
                    StringBuilder CanvansObj = CanvansMap.get(w.getName());
                    windowTemplate.setAttribute("canvanscontent",CanvansObj.toString());
                } else windowTemplate.setAttribute("canvanscontent","");
                windowscodeSB.append(windowTemplate.toString());
                windowscodeSB.append(newline);
            }
        
            mainpageTemplate.setAttribute("windowscode", windowscodeSB.toString());
            
            saveTemplateStringToTargetFolder(mainpageTemplate,formmodule.getName() + ".java",targetFolderStr + "\\src\\" + (packagePrefix + oraFileName.toLowerCase()).replaceAll("\\.","\\\\")+"\\client");
       
        } 
        
        StringTemplateGroup htmlcss = getStringTemplateGroup("htmlcss.stg"); 
        if (htmlcss != null) {
            final StringTemplate htmlTemplate = htmlcss.getInstanceOf("htmlpageTpl");
            htmlTemplate.reset();
            htmlTemplate.setAttribute("cssfilename", formmodule.getName()+ ".css");            
            htmlTemplate.setAttribute("jsfilename", formmodule.getName().toLowerCase() + "/" + formmodule.getName().toLowerCase() + ".nocache.js");            
            final StringTemplate cssTemplate = htmlcss.getInstanceOf("cssfileTpl");
            cssTemplate.reset();
            cssTemplate.setAttribute("nullparameter", ""); 
            saveTemplateStringToTargetFolder(htmlTemplate,formmodule.getName() + ".html",targetFolderStr + "\\war\\");
            saveTemplateStringToTargetFolder(cssTemplate,formmodule.getName() + ".css",targetFolderStr + "\\war\\");      
        }
        
        
        StringTemplateGroup supportedjavaclass = getStringTemplateGroup("supportedjavaclass.stg"); 
        if (supportedjavaclass != null) {
            final StringTemplate oracleformswindowTemplate = supportedjavaclass.getInstanceOf("oracleformswindowTpl");  
            oracleformswindowTemplate.reset();
            oracleformswindowTemplate.setAttribute("packageprefix", packagePrefix + oraFileName.toLowerCase() +"." );
            final StringTemplate oraclformssupportfunctionsTemplate = supportedjavaclass.getInstanceOf("oraclformssupportfunctionsTpl");  
            oraclformssupportfunctionsTemplate.reset();
            oraclformssupportfunctionsTemplate.setAttribute("packageprefix", packagePrefix + oraFileName.toLowerCase() +"." );
            final StringTemplate oracleformssmartbarpanelTemplate = supportedjavaclass.getInstanceOf("oracleformssmartbarpanelTpl");  
            oracleformssmartbarpanelTemplate.reset();
            oracleformssmartbarpanelTemplate.setAttribute("packageprefix", packagePrefix + oraFileName.toLowerCase() +"." );
            final StringTemplate oracleformsdefaultmenupanelTemplate = supportedjavaclass.getInstanceOf("oracleformsdefaultmenupanelTpl");  
            oracleformsdefaultmenupanelTemplate.reset();
            oracleformsdefaultmenupanelTemplate.setAttribute("packageprefix", packagePrefix + oraFileName.toLowerCase() +"." );
           
            saveTemplateStringToTargetFolder(oracleformswindowTemplate,"OracleFormsWindow.java",targetFolderStr + "\\src\\" + (packagePrefix + oraFileName.toLowerCase()).replaceAll("\\.","\\\\")+"\\client");      
            saveTemplateStringToTargetFolder(oraclformssupportfunctionsTemplate,"OracleFormsSupportFunctions.java",targetFolderStr + "\\src\\" + (packagePrefix + oraFileName.toLowerCase()).replaceAll("\\.","\\\\")+"\\client");      
            saveTemplateStringToTargetFolder(oracleformssmartbarpanelTemplate,"OracleFormsSmartbarPanel.java",targetFolderStr + "\\src\\" + (packagePrefix + oraFileName.toLowerCase()).replaceAll("\\.","\\\\")+"\\client");      
            saveTemplateStringToTargetFolder(oracleformsdefaultmenupanelTemplate,"OracleFormsDefaultMenuPanel.java",targetFolderStr + "\\src\\" + (packagePrefix + oraFileName.toLowerCase()).replaceAll("\\.","\\\\")+"\\client");      
                
        }        
    }

    private StringBuilder generateGraphicsCode(JdapiIterator Graphicses,StringTemplate graphicsTemplate, Canvas c, TabPage tp ,String oraFileName, FormModule formmodule, int xoffset, int yoffset){
        StringBuilder graphicsescodeSB = new StringBuilder();
        while (Graphicses.hasNext()){
            Graphics g = (Graphics)Graphicses.next();
            java.awt.Point pOffset = new java.awt.Point();
            java.awt.Point realSize = new java.awt.Point();
            String s = generateGraphicsPic(g,c,oraFileName,formmodule,pOffset, graphicsTemplate,  xoffset,  yoffset, graphicsescodeSB,realSize);
            graphicsTemplate.reset();
            graphicsTemplate.setAttribute("graphics",g);
            graphicsTemplate.setAttribute("canvasname",c.getName() + ((tp==null)?"":("_" + tp.getName())));
            graphicsTemplate.setAttribute("graphicsname",c.getName() + ((tp==null)?"":("_" + tp.getName())) + "_" + g.getName());
            graphicsTemplate.setAttribute("graphicswidth", realSize.x);
            graphicsTemplate.setAttribute("graphicsheight", realSize.y);
            graphicsTemplate.setAttribute("imgfilename",s);
            graphicsTemplate.setAttribute("graphicsx", Math.max(10,formsX2Page(g.getXPosition() + xoffset - pOffset.x )));
            graphicsTemplate.setAttribute("graphicsy", Math.max(10,formsY2Page(g.getYPosition() + yoffset - pOffset.y )));         
            graphicsescodeSB.append(graphicsTemplate.toString());
            graphicsescodeSB.append(newline);
        }        
        return graphicsescodeSB;
    }

    private StringBuilder generateGraphicsCode(JdapiIterator Graphicses,StringTemplate graphicsTemplate, Canvas c, String oraFileName, FormModule formmodule, int xoffset, int yoffset){
        return generateGraphicsCode( Graphicses, graphicsTemplate,  c,  null , oraFileName,  formmodule,  xoffset,  yoffset);
    }

    private void GenerateMenuCodes(StringBuffer codesBuffer, Menu mainMenu, MenuModule m){
        GenerateMenuCodes(codesBuffer,  mainMenu, m , false );
    }
    
    private void GenerateMenuCodes(StringBuffer codesBuffer, Menu menu, MenuModule m, boolean t ){
      String menuStr =  "		MenuBar " + menu.getName() + " = new MenuBar("+ (t?"true":"")  +");\n" ;
      codesBuffer.append(menuStr);
      JdapiIterator  menuItems = menu.getMenuItems();
      while (menuItems.hasNext()){
        MenuItem mitem = (MenuItem)menuItems.next();
        int menuItemType = mitem.getMenuItemType();
        //JdapiTypes.MNIT_PLAIN_CTID, JdapiTypes.MNIT_CHECK_CTID, JdapiTypes.MNIT_RADIO_CTID, JdapiTypes.MNIT_SEPARATOR_CTID, JdapiTypes.MNIT_MAGIC_CTID
         int commandType = mitem.getCommandType();
         //JdapiTypes.COTY_NULL_CTID, JdapiTypes.COTY_MENU_CTID, JdapiTypes.COTY_PLSQL_CTID
        if (menuItemType == JdapiTypes.MNIT_SEPARATOR_CTID){
            String menuItemStr =  "		" + menu.getName() + ".addSeparator();\n" ;
            codesBuffer.append(menuItemStr);            
        } else if (menuItemType == JdapiTypes.MNIT_MAGIC_CTID) { 
            //JdapiTypes.MAIT_NONE_CTID, JdapiTypes.MAIT_CUT_CTID, JdapiTypes.MAIT_COPY_CTID, JdapiTypes.MAIT_PASTE_CTID, JdapiTypes.MAIT_CLEAR_CTID, JdapiTypes.MAIT_UNDO_CTID, JdapiTypes.MAIT_HELP_CTID, JdapiTypes.MAIT_ABOUT_CTID, JdapiTypes.MAIT_QUIT_CTID, JdapiTypes.MAIT_WINDOW_CTID, JdapiTypes.MAIT_PAGESETUP_CTID
             String menuItemStr = "";
            menuItemStr = 
             "               " + menu.getName() + ".addItem(\""+ mitem.getLabel() +"\", new Command() {\n" + 
             "                       public void execute() {\n" + 
             "                       Window.alert(\"You selected a menu item!\");\n" + 
             "                   }\n" + 
             "               });\n";            
            switch (mitem.getMagicItem()){
                case 0 /* JdapiTypes.MAIT_NONE_CTID  */: 
                
                    break;
                case 1 /* JdapiTypes.MAIT_CUT_CTID  */: 
                    
                    break;
                case 2 /* JdapiTypes.MAIT_COPY_CTID  */: 
                
                    break;
                case 3 /* JdapiTypes.MAIT_PASTE_CTID  */: 
                    
                    break;
                case 4 /* JdapiTypes.MAIT_CLEAR_CTID  */: 
                    
                    break;
                case 5 /* JdapiTypes.MAIT_UNDO_CTID  */: 
                    
                    break;
                case 6 /* JdapiTypes.MAIT_HELP_CTID  */: 
                    
                    break;
                case 7 /* JdapiTypes.MAIT_ABOUT_CTID  */: 
                
                    break;
                case 8 /* JdapiTypes.MAIT_QUIT_CTID  */: 
                    
                    break;
                case 9 /* JdapiTypes.MAIT_WINDOW_CTID  */: 
                    
                    break;
                case 10 /* JdapiTypes.MAIT_PAGESETUP_CTID  */: 
                    
                    break;
            }
            codesBuffer.append(menuItemStr);
        } else {
            if (commandType == JdapiTypes.COTY_MENU_CTID ){
                String subMenuName = mitem.getSubMenuName();
                JdapiIterator  menus =  m.getMenus();
                while(menus.hasNext()){
                    Menu subMenu = (Menu)menus.next();
                    if (subMenu.getName().equals(subMenuName) ){
                        GenerateMenuCodes(codesBuffer, subMenu  , (MenuModule)m.clone(m,m.getName()),true);   
                        codesBuffer.append("		"+ menu.getName() + ".addItem(\"" + mitem.getLabel() + "\"," + subMenu.getName() +  ");\n");
                        break;
                    }
                }
                
            } else {
                String menuItemStr =  
                "		" + menu.getName() + ".addItem(\""+ mitem.getLabel() +"\", new Command() {\n" + 
                "		        public void execute() {\n" + 
                "		        Window.alert(\"You selected a menu item!\");\n" + 
                "		    }\n" + 
                "		});\n";
                codesBuffer.append(menuItemStr);
            }
        }
      }
        
    }
    
    
    private Canvas getCanvasByName(FormModule formmodule, String canvasName){
        if (formmodule == null || canvasName==null) return null;
        JdapiIterator  canvases =  formmodule.getCanvases();
        while (canvases.hasNext()){
            Canvas canvas = (Canvas) canvases.next();
            if (canvas.getName().equals(canvasName)) return canvas;
        }
        return null;
    }
    
    private Window getWindowByName(FormModule formmodule, String windowName){
        if (formmodule == null || windowName==null) return null;
        JdapiIterator  windows =  formmodule.getWindows(); ;
        while (windows.hasNext()){
            Window window = (Window) windows.next();
            if (window.getName().equals(windowName)) return window;
        }
        return null;
    }
    
    private String getWindowDefautCanvan(FormModule formmodule, String windowName){
        JdapiIterator  canvases =  formmodule.getCanvases();
        String s = "null";
        while (canvases.hasNext()){
            Canvas canvas = (Canvas) canvases.next();
            if (s.equals("null")) s = canvas.getName();
            if (canvas.getWindowName().equals(windowName)) return canvas.getName();
        }
        return s;
    }


    private String generateCanvasBackimage(Canvas c, String oraFileName, FormModule formmodule){
        String fileName = c.getName();
        if (fileName==null || fileName.equals("")) fileName = "img_" + Math.round((Math.random()*1000000));
        else fileName= fileName + "_backimage";
        File f = new File(targetFolderStr + "\\war\\"+ formmodule.getName().toLowerCase() + "_images\\" + fileName + ".png");
        if (f.exists()) {
            fileName = fileName + "_" + Math.round((Math.random()*100));
            f = new File(targetFolderStr + "\\war\\"+ formmodule.getName().toLowerCase() + "_images\\" + fileName + ".png");
        }        
        
        if (!f.getParentFile().exists()) makeTargetFolder(f.getParent());
        
        BufferedImage  image = new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(formsColor2Java(c.getBackColor()));
        g2d.fillRect(0,0,10,10);
        
        try {
            ImageIO.write(image,"png",f);
            return formmodule.getName().toLowerCase() + "_images/" + fileName+".png";
        } catch (IOException e) {
            return null;
        }
    }
    
    private String generateTabPageBackimage(TabPage p, String oraFileName, FormModule formmodule){
        String fileName = p.getName();
        if (fileName==null || fileName.equals("")) fileName = "img_" + Math.round((Math.random()*1000000));
        else fileName= fileName + "_backimage";
        File f = new File(targetFolderStr + "\\war\\"+ formmodule.getName().toLowerCase() + "_images\\" + fileName + ".png");
        if (f.exists()) {
            fileName = fileName + "_" + Math.round((Math.random()*100));
            f = new File(targetFolderStr + "\\war\\"+ formmodule.getName().toLowerCase() + "_images\\" + fileName + ".png");
        }        
        
        if (!f.getParentFile().exists()) makeTargetFolder(f.getParent());
        
        BufferedImage  image = new BufferedImage(10,10,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        String colorStr = p.getBackColor();
        if (colorStr == null || colorStr.equals("")) {
            Object c =  p.getOwner();
            if (c != null && c instanceof Canvas) {
                colorStr = ((Canvas)c).getBackColor(); 
            }
        }
        g2d.setColor(formsColor2Java(colorStr));
        g2d.fillRect(0,0,10,10);
        
        try {
            ImageIO.write(image,"png",f);
            return formmodule.getName().toLowerCase() + "_images/" + fileName+".png";
        } catch (IOException e) {
            return null;
        }
    }
    private String generateGraphicsPic(Graphics g, Canvas c, String oraFileName, FormModule formmodule, java.awt.Point pOffset, StringTemplate graphicsTemplate, int xoffset, int yoffset , StringBuilder graphicsescodeSB ,java.awt.Point realSize) {
        return generateGraphicsPic ( g,  c, null , oraFileName,  formmodule,  pOffset,  graphicsTemplate,  xoffset,  yoffset ,  graphicsescodeSB , realSize);
    }
    
    private String generateGraphicsPic(Graphics g, Canvas c, TabPage tp ,String oraFileName, FormModule formmodule, java.awt.Point pOffset, StringTemplate graphicsTemplate, int xoffset, int yoffset , StringBuilder graphicsescodeSB ,java.awt.Point realSize) {
        String fileName = c.getName() + ((tp==null)?"":("_" + tp.getName()))  + "_" + g.getName();
        if (fileName==null || fileName.equals("")) fileName = "img_" + Math.round((Math.random()*1000000));
        File f = new File(targetFolderStr + "\\war\\"+ formmodule.getName().toLowerCase() + "_images\\" + fileName + ".png");
        if (f.exists()) {
            fileName = fileName + "_" + Math.round((Math.random()*100));
            f = new File(targetFolderStr + "\\war\\"+ formmodule.getName().toLowerCase() + "_images\\" + fileName + ".png");
        }
        
        int width = formsX2Page(g.getWidth());
        int height = formsY2Page(g.getHeight());
        
        if (g.getGraphicsType()==JdapiTypes.GRTY_POLY_CTID){
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            for(JdapiIterator iter = g.getPoints(); iter.hasNext();){
                Point pt = (Point)iter.next();
                int x = formsX2Page(pt.getXPosition());
                int y = formsX2Page(pt.getYPosition());
                if (x>width) width = x;
                if (y>height) height = y;  
                if (x<minX) minX = x;
                if (y<minY) minY = y;
            }
            width = Math.max(0,formsX2Page(width-minX + 10));
            height = Math.max(0,formsY2Page(height-minY + 10));
            g.setXPosition(Math.max(0,minX -5));
            g.setYPosition(Math.max(0,minY -5));
        }
        
        int internalLineWidth = (g.getInternalLineWidth()<=0)?1:(int)Math.round(g.getInternalLineWidth() / 113.8 + 0.5 ) ;
        int rotationAngle = g.getInternalRotationAngle();
        
        BufferedImage image = new BufferedImage(Math.max(Math.abs(width),1), Math.max(Math.abs(height),1),BufferedImage.TYPE_INT_RGB);
        
        if (g.getGraphicsType() == JdapiTypes.GRTY_LINE_CTID) {
            if (g.getArrowStyle() != JdapiTypes.ARST_NONE_CTID){
                pOffset.x= 18;
                pOffset.y= 18;                
            } else {
                pOffset.x= 5;
                pOffset.y= 5;                 
            }
            
            if (width<0) pOffset.x= pOffset.x + Math.abs(width);
            if (height<0) pOffset.y= pOffset.y + Math.abs(height);
            //image = new BufferedImage(Math.max(Math.abs(width) ,internalLineWidth) , Math.max(Math.abs(height),internalLineWidth),BufferedImage.TYPE_INT_RGB);
             image = new BufferedImage(Math.max(width + 2 * pOffset.x ,internalLineWidth) , Math.max(Math.abs(height + 2 * pOffset.y),internalLineWidth),BufferedImage.TYPE_INT_RGB);
        }
        
        
        Graphics2D g2d = image.createGraphics();
        image = g2d.getDeviceConfiguration().createCompatibleImage(image.getWidth(), image.getHeight(), Transparency.TRANSLUCENT);
        g2d.dispose();
        
        g2d = image.createGraphics();
        
        if (rotationAngle != 0) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
            g2d.translate( image.getWidth() / 2  , image.getHeight() / 2 ); 
            g2d.rotate(rotationAngle * Math.PI / 180.0 / 64.0);
            g2d.translate( - image.getWidth() / 2  , - image.getHeight() / 2 ); 
        }
        
        int halflinewidth = (int)Math.round(g.getInternalLineWidth()/113.8/2);
        if (halflinewidth==0) halflinewidth = 1;
        int linewidth = halflinewidth*2;

        //JdapiTypes.CAST_BUTT_CTID, JdapiTypes.CAST_ROUND_CTID, JdapiTypes.CAST_PROJECT_CTID
        //         public final static int CAP_BUTT = 0;
        //         public final static int CAP_ROUND = 1;
        //         public final static int CAP_SQUARE = 2;
        int capStyle = g.getCapStyle();  
        
        //JdapiTypes.JOST_MITRE_CTID, JdapiTypes.JOST_BEVEL_CTID, JdapiTypes.JOST_ROUND_CTID
        //         public final static int JOIN_MITER = 0;
        //         public final static int JOIN_ROUND = 1;
        //         public final static int JOIN_BEVEL = 2;
        int joinStyle = g.getJoinStyle();
        if (joinStyle==JdapiTypes.JOST_MITRE_CTID) joinStyle =BasicStroke.JOIN_MITER;
        else if (joinStyle==JdapiTypes.JOST_BEVEL_CTID) joinStyle =BasicStroke.JOIN_BEVEL;
        else if (joinStyle==JdapiTypes.JOST_ROUND_CTID) joinStyle =BasicStroke.JOIN_ROUND;
        
        boolean closed = g.isClosed();
        //int fillStyle  = g.getFillStyle();
        int startAngle = g.getInternalStartAngle();
        int endAngle = g.getInternalEndAngle();
        if (endAngle==0) endAngle = 360;
        Color foregroundColor = formsColor2Java(g.getForegroundColor());
        Color backgroundColor = formsColor2Java(g.getBackColor());
        String fillPattern = g.getFillPattern();
        Color edgeForegroundColor = formsColor2Java(g.getEdgeForegroundColor());
        Color edgeBackgroundColor = formsColor2Java(g.getEdgeBackColor());
        String edgePattern = g.getEdgePattern();
        
        int cornerRadiusX = formsX2Page(g.getCornerRadiusX());
        int cornerRadiusY = formsY2Page(g.getCornerRadiusY());
        
        Stroke s =  new BasicStroke (linewidth, capStyle,joinStyle);
        int dashStyle = g.getDashStyle();
        if (dashStyle==JdapiTypes.DAST_SOLID_CTID) {}
        else if (dashStyle==JdapiTypes.DAST_DOT_CTID) {s =  new BasicStroke(linewidth,capStyle,joinStyle,10.0f,new float[]{linewidth,linewidth},0);}
        else if (dashStyle==JdapiTypes.DAST_DASH_CTID) {s =  new BasicStroke(linewidth,capStyle,joinStyle,10.0f,new float[]{3*linewidth,linewidth},0);}
        else if (dashStyle==JdapiTypes.DAST_DASHDOT_CTID) {s =  new BasicStroke(linewidth,capStyle,joinStyle,10.0f,new float[]{linewidth,linewidth,3*linewidth,linewidth},0);}
        else if (dashStyle==JdapiTypes.DAST_DOUBDOT_CTID) {s =  new BasicStroke(linewidth,capStyle,joinStyle,10.0f,new float[]{linewidth,linewidth,linewidth,linewidth*2},0);}
        else if (dashStyle==JdapiTypes.DAST_LONGDASH_CTID) {s =  new BasicStroke(linewidth,capStyle,joinStyle,10.0f,new float[]{5*linewidth,linewidth},0);}
        else if (dashStyle==JdapiTypes.DAST_DASHDOUBDOT_CTID) {s =  new BasicStroke(linewidth,capStyle,joinStyle,10.0f,new float[]{linewidth,linewidth,linewidth,linewidth,3*linewidth,linewidth},0);}
        g2d.setStroke(s);
         
        switch(g.getGraphicsType()){
            case 0 /*JdapiTypes.GRTY_ARC_CTID*/ : 
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
                    int fillStyle  = 0 ;//g.getFillStyle();
                    if (!"none".equalsIgnoreCase(g.getFillPattern()) ){
                        g2d.setColor(backgroundColor);
                        g2d.fill(new Arc2D.Double(0,0,width,height,startAngle,endAngle-startAngle,(closed?(fillStyle==0?Arc2D.PIE:Arc2D.CHORD):Arc2D.OPEN)));
                    }
                    g2d.setColor(edgeForegroundColor);
                    g2d.setBackground(edgeBackgroundColor);
                    g2d.draw(new Arc2D.Double(halflinewidth,halflinewidth,width-linewidth,height-linewidth,startAngle,endAngle-startAngle,(closed?(fillStyle==0?Arc2D.PIE:Arc2D.CHORD):Arc2D.OPEN)));
                break;
            case 1 /*JdapiTypes.GRTY_IMAGE_CTID*/ : 
                    
                break; 
            case 2 /*JdapiTypes.GRTY_LINE_CTID*/ : 
                    edgeBackgroundColor = formsColor2Java(g.getEdgeBackColor(),Color.BLACK);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
                    g2d.setColor(edgeBackgroundColor);
                    g2d.setBackground(edgeForegroundColor);
                    int[] x = {pOffset.x + internalLineWidth / 2 , pOffset.x + width - internalLineWidth / 2 };
                    int[] y = {pOffset.y + internalLineWidth / 2 , pOffset.y + height - internalLineWidth / 2 };
                    g2d.setPaint( edgeBackgroundColor );
                    g2d.setStroke( new BasicStroke( internalLineWidth ) );
                    g2d.drawPolyline(x,y,x.length);
                    //g2d.drawLine(pOffset.x + 0, pOffset.y + 0, pOffset.x + width , pOffset.y + height); 
                    //draw triangle;   
                    //JdapiTypes.ARST_NONE_CTID, JdapiTypes.ARST_START_CTID, JdapiTypes.ARST_END_CTID, JdapiTypes.ARST_BOTH_CTID, JdapiTypes.ARST_MDLTOSTRT_CTID, JdapiTypes.ARST_MDLTOEND_CTID
                    int arrowStyle = g.getArrowStyle();
                    if (arrowStyle != JdapiTypes.ARST_NONE_CTID){
                        int len = 10 * linewidth;
                        if (len>50) len = 50;
                        if (len<10) len = 10;
                        double angleOffset = Math.PI * 20 / 180 ;
                        double angle = Math.atan(1.0d * height/width);
                        int x1 = (int)Math.round(Math.cos(angle + angleOffset) * len);
                        int y1 = (int)Math.round(Math.sin(angle + angleOffset) * len);
                        int x2 = (int)Math.round(Math.cos(angle - angleOffset) * len);
                        int y2 = (int)Math.round(Math.sin(angle - angleOffset) * len);
                        
                        s =  new BasicStroke (linewidth, capStyle,joinStyle);
                        g2d.setStroke(s);
                        g2d.setColor(edgeForegroundColor);
                        Polygon p3 = new Polygon();
                        if (arrowStyle == JdapiTypes.ARST_START_CTID) {
                            p3.addPoint(pOffset.x + 0,pOffset.y + 0);
                            p3.addPoint(pOffset.x + x1,pOffset.y + y1);
                            p3.addPoint(pOffset.x + x2,pOffset.y + y2);                        
                        } else if (arrowStyle ==  JdapiTypes.ARST_END_CTID) {
                            p3.addPoint(pOffset.x + width,pOffset.y + height);
                            p3.addPoint(pOffset.x + width-x1,pOffset.y + height-y1);
                            p3.addPoint(pOffset.x + width-x2,pOffset.y + height-y2);
                        } else if (arrowStyle ==  JdapiTypes.ARST_BOTH_CTID) {
                            p3.addPoint(pOffset.x + 0,pOffset.y + 0);
                            p3.addPoint(pOffset.x + x1,pOffset.y + y1);
                            p3.addPoint(pOffset.x + x2,pOffset.y + y2);                        
                            g2d.fillPolygon(p3);
                            p3 = new Polygon();
                            p3.addPoint(pOffset.x + width,pOffset.y + height);
                            p3.addPoint(pOffset.x + width-x1,pOffset.y + height-y1);
                            p3.addPoint(pOffset.x + width-x2,pOffset.y + height-y2);
                        } else if (arrowStyle ==  JdapiTypes.ARST_MDLTOSTRT_CTID) {
                            p3.addPoint(pOffset.x + width/2,pOffset.y + height/2);
                            p3.addPoint(pOffset.x + width/2+x1,pOffset.y + height/2+y1);
                            p3.addPoint(pOffset.x + width/2+x2,pOffset.y + height/2+y2);                              
                        } else if (arrowStyle == JdapiTypes.ARST_MDLTOEND_CTID){
                            p3.addPoint(pOffset.x + width/2,pOffset.y + height/2);
                            p3.addPoint(pOffset.x + width/2-x1,pOffset.y + height/2-y1);
                            p3.addPoint(pOffset.x + width/2-x2,pOffset.y + height/2-y2);                        
                        }
                        g2d.fillPolygon(p3);
                    }
                break; 
            case 3 /*JdapiTypes.GRTY_POLY_CTID*/ : 
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
                    Polygon p = new Polygon();
                    for(JdapiIterator iter = g.getPoints(); iter.hasNext();){
                        Point pt = (Point)iter.next();
                        p.addPoint(formsX2Page(pt.getXPosition() - g.getXPosition()),formsY2Page(pt.getYPosition()- g.getYPosition()));
                    }
                    g2d.setColor(backgroundColor);
                    g2d.fillPolygon(p);
                    g2d.setColor(edgeForegroundColor); 
                    g2d.setBackground(edgeBackgroundColor);
                    g2d.drawPolygon(p);            
                break; 
            case 4 /*JdapiTypes.GRTY_RECT_CTID*/ : 
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF); 
                    if (!"none".equalsIgnoreCase(g.getFillPattern()) ){ 
                        g2d.setColor(backgroundColor);
                        g2d.fillRect(0,0,width,height);
                    }
                    g2d.setColor(edgeForegroundColor);
                    g2d.setBackground(edgeBackgroundColor);
                    g2d.drawRect(halflinewidth,halflinewidth,width-linewidth,height-linewidth);    
                break; 
            case 5 /*JdapiTypes.GRTY_RREC_CTID*/ : 
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
                    if (!"none".equalsIgnoreCase(g.getFillPattern()) ){
                        g2d.setColor(backgroundColor);
                        g2d.fillRoundRect(0,0,width,height,cornerRadiusX,cornerRadiusY);
                    }
                    g2d.setColor(edgeForegroundColor);
                    g2d.setBackground(edgeBackgroundColor);
                    g2d.drawRoundRect(halflinewidth,halflinewidth,width-linewidth,height-linewidth,cornerRadiusX,cornerRadiusY);     
                break; 
            case 6 /*JdapiTypes.GRTY_TEXT_CTID*/ : 
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF); 
                    if (g.getFillPattern() != null && !g.getFillPattern().equals("") && !g.getFillPattern().equalsIgnoreCase("none") && !g.getFillPattern().equalsIgnoreCase("transparent")  ){
                        g2d.setColor(backgroundColor);
                        g2d.fillRect(0,0,width,height);
                    }
                    g2d.setColor(edgeForegroundColor);
                    g2d.setBackground(edgeBackgroundColor);
                    g2d.drawRect(halflinewidth,halflinewidth,width-linewidth,height-linewidth);            
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
                    java.awt.Font fn = new java.awt.Font(g.getGraphicsFontName(),oracle2JavaFontStyle(g.getGraphicsFontSize()),(int)Math.round(g.getGraphicsFontSize()/100));
                    g2d.setFont(fn);
                    g2d.setColor(formsColor2Java(g.getGraphicsFontColor(),Color.BLACK));
                    
                    String str= g.getGraphicsText();
                    String[] sa = str.split("\\n");
                    int ySpacing = height / (sa.length==0?1:sa.length); 
                    int yOffset = 0;
                    for(String ss : sa ){
                        Rectangle2D r2d = getStringRectangle(fn,ss);
                        g2d.drawString(ss, linewidth , linewidth + yOffset + (int)Math.round(r2d.getHeight()));
                        yOffset = yOffset + ySpacing;
                    }                
                break;
            case 7 /*JdapiTypes.GRTY_GROUP_CTID*/ : 
                    JdapiIterator Graphicses = g.getGraphicses();
                    StringBuilder sb = generateGraphicsCode(Graphicses, graphicsTemplate,  c,  oraFileName,  formmodule,  xoffset,  yoffset);
                    graphicsescodeSB.append(sb);
                break; 
            case 8 /*JdapiTypes.GRTY_FRAME_CTID*/ : 
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF); 
    
                    //JdapiTypes.BEST_RAISED_CTID, JdapiTypes.BEST_LOWERED_CTID, JdapiTypes.BEST_NONE_CTID, JdapiTypes.BEST_NSET_CTID, JdapiTypes.BEST_OUTSET_CTID, JdapiTypes.BEST_PLAIN_CTID
                    int bevel = g.getBevel();
                    
                    String frameTitle = g.getFrameTitle();
                    //JdapiTypes.JUSTIFICATION_LEFT_CTID, JdapiTypes.JUSTIFICATION_RIGHT_CTID, JdapiTypes.JUSTIFICATION_CENTER_CTID, JdapiTypes.JUSTIFICATION_START_CTID, JdapiTypes.JUSTIFICATION_END_CTID
                    int framTitleAlign = g.getFrameTitleAlign();
                    
                    Color frameTitleBackColor = formsColor2Java(g.getFrameTitleBackColor(),formsColor2Java(c.getBackColor()));
                    String frameTitleFontName = g.getFrameTitleFontName();
                    if (frameTitleFontName == null || frameTitleFontName.equals("")) frameTitleFontName="Default";
                    int frameTitleFontSize = g.getFrameTitleFontSize()/100;
                    if (frameTitleFontSize == 0) frameTitleFontSize = getParentFontSize(c);
                    //JdapiTypes.FOST_PLAIN_CTID, JdapiTypes.FOST_ITALIC_CTID, JdapiTypes.FOST_OBLIQUE_CTID, JdapiTypes.FOST_UNDERLINE_CTID, JdapiTypes.FOST_OUTLINE_CTID, JdapiTypes.FOST_SHADOW_CTID, JdapiTypes.FOST_INVERTED_CTID, JdapiTypes.FOST_OVERSTRIKE_CTID, JdapiTypes.FOST_BLINK_CTID
                    int frameTitleFontStyle = oracle2JavaFontStyle(g.getFrameTitleFontStyle());
                      
                    java.awt.Font fnt = new java.awt.Font(g.getGraphicsFontName(),frameTitleFontStyle,frameTitleFontSize);
                    g2d.setFont(fnt);
                    
                    Color frameTitleForegroundColor= formsColor2Java(g.getFrameTitleForegroundColor(),Color.BLACK);
                    int frameTitleOffset = g.getFrameTitleOffset();
                    int frameTitleSpacing = g.getFrameTitleSpacing();
                    
                    Rectangle2D r2d = getStringRectangle(fnt,frameTitle);
                    if (g.getFillPattern() != null && !g.getFillPattern().equals("") && !g.getFillPattern().equalsIgnoreCase("none") ){
                        g2d.setColor(backgroundColor);
                        g2d.fillRect(0,(int)Math.round(r2d.getHeight()/2),width,height);
                    }
                    if (bevel == JdapiTypes.BEST_NONE_CTID || bevel == JdapiTypes.BEST_PLAIN_CTID) {
                        g2d.setColor(frameTitleForegroundColor);
                        g2d.setBackground(edgeBackgroundColor);
                        g2d.drawLine(halflinewidth, (int)Math.round(r2d.getHeight()/2),halflinewidth,height-halflinewidth);
                        g2d.drawLine(halflinewidth,height-halflinewidth,width-halflinewidth,height-halflinewidth);
                        g2d.drawLine(width-halflinewidth,height-halflinewidth,width-halflinewidth,(int)Math.round(r2d.getHeight()/2));
                        g2d.drawLine(width-halflinewidth,(int)Math.round(r2d.getHeight()/2),halflinewidth,(int)Math.round(r2d.getHeight()/2));
                    } else  if (bevel == JdapiTypes.BEST_RAISED_CTID){ 
                        s =  new BasicStroke (linewidth, capStyle,joinStyle);
                        g2d.setStroke(s);
                        g2d.setColor(Color.WHITE);
                        g2d.drawLine(halflinewidth, (int)Math.round(r2d.getHeight()/2),halflinewidth,height-halflinewidth);
                        g2d.drawLine(width-halflinewidth,(int)Math.round(r2d.getHeight()/2),halflinewidth,(int)Math.round(r2d.getHeight()/2));
                        g2d.setColor(new Color(172,168,153));
                        g2d.drawLine(halflinewidth,height-halflinewidth,width-halflinewidth,height-halflinewidth);
                        g2d.drawLine(width-halflinewidth,height-halflinewidth,width-halflinewidth,(int)Math.round(r2d.getHeight()/2));
                    } else  if (bevel == JdapiTypes.BEST_LOWERED_CTID){
                        s =  new BasicStroke (linewidth, capStyle,joinStyle);
                        g2d.setStroke(s);
                        g2d.setColor(new Color(172,168,153));
                        g2d.drawLine(halflinewidth, (int)Math.round(r2d.getHeight()/2),halflinewidth,height-halflinewidth);
                        g2d.drawLine(width-halflinewidth,(int)Math.round(r2d.getHeight()/2),halflinewidth,(int)Math.round(r2d.getHeight()/2));
                        g2d.setColor(Color.WHITE);
                        g2d.drawLine(halflinewidth,height-halflinewidth,width-halflinewidth,height-halflinewidth);
                        g2d.drawLine(width-halflinewidth,height-halflinewidth,width-halflinewidth,(int)Math.round(r2d.getHeight()/2));
                    } else  if (bevel == JdapiTypes.BEST_NSET_CTID){
                        halflinewidth = 2 *(int)Math.round(halflinewidth/2.0d + 0.5);
                        linewidth = 2 * halflinewidth;
                        s =  new BasicStroke (halflinewidth, capStyle,joinStyle);
                        g2d.setStroke(s);
                        g2d.setColor(new Color(172,168,153));
                        g2d.drawLine(halflinewidth/2, (int)Math.round(r2d.getHeight()/2) ,halflinewidth/2, height);
                        g2d.drawLine(width-halflinewidth,(int)Math.round(r2d.getHeight()/2)-halflinewidth/2,0,(int)Math.round(r2d.getHeight()/2)-halflinewidth/2);
                        g2d.drawLine(halflinewidth,height-halflinewidth*3/2,width-halflinewidth,height-halflinewidth*3/2);
                        g2d.drawLine(width-halflinewidth*3/2,height-halflinewidth,width-halflinewidth*3/2,(int)Math.round(r2d.getHeight()/2));
                        g2d.setColor(Color.WHITE);
                        g2d.drawLine(halflinewidth*3/2, (int)Math.round(r2d.getHeight()/2)+halflinewidth/2 ,halflinewidth*3/2, height-halflinewidth );
                        g2d.drawLine(width-halflinewidth,(int)Math.round(r2d.getHeight()/2)+halflinewidth/2,linewidth,(int)Math.round(r2d.getHeight()/2)+halflinewidth/2);
                        g2d.drawLine(0,height-halflinewidth*1/2,width,height-halflinewidth*1/2);
                        g2d.drawLine(width-halflinewidth/2,height,width-halflinewidth/2,(int)Math.round(r2d.getHeight()/2)-halflinewidth/2);
                    } else  if (bevel == JdapiTypes.BEST_OUTSET_CTID){
                        halflinewidth = 2 *(int)Math.round(halflinewidth/2.0d + 0.5);
                        linewidth = 2 * halflinewidth;
                        s =  new BasicStroke (halflinewidth, capStyle,joinStyle);
                        g2d.setStroke(s);
                        g2d.setColor(Color.WHITE);
                        g2d.drawLine(halflinewidth/2, (int)Math.round(r2d.getHeight()/2) ,halflinewidth/2, height);
                        g2d.drawLine(width-halflinewidth,(int)Math.round(r2d.getHeight()/2)-halflinewidth/2,0,(int)Math.round(r2d.getHeight()/2)-halflinewidth/2);
                        g2d.drawLine(halflinewidth,height-halflinewidth*3/2,width-halflinewidth,height-halflinewidth*3/2);
                        g2d.drawLine(width-halflinewidth*3/2,height-halflinewidth,width-halflinewidth*3/2,(int)Math.round(r2d.getHeight()/2));
                        g2d.setColor(new Color(172,168,153));
                        g2d.drawLine(halflinewidth*3/2, (int)Math.round(r2d.getHeight()/2)+halflinewidth/2 ,halflinewidth*3/2, height-halflinewidth );
                        g2d.drawLine(width-halflinewidth,(int)Math.round(r2d.getHeight()/2)+halflinewidth/2,linewidth,(int)Math.round(r2d.getHeight()/2)+halflinewidth/2);
                        g2d.drawLine(0,height-halflinewidth*1/2,width,height-halflinewidth*1/2);
                        g2d.drawLine(width-halflinewidth/2,height,width-halflinewidth/2,(int)Math.round(r2d.getHeight()/2)-halflinewidth/2);
                    }
                        
                    if (framTitleAlign == JdapiTypes.JUSTIFICATION_LEFT_CTID || framTitleAlign == JdapiTypes.JUSTIFICATION_START_CTID){
                        g2d.setColor(frameTitleBackColor);
                        g2d.fillRect(halflinewidth + frameTitleOffset, 0 , frameTitleSpacing*2 + (int)Math.round(r2d.getWidth()), (int)Math.round(r2d.getHeight()));
                        g2d.setColor(frameTitleForegroundColor);
                        g2d.drawString(frameTitle,linewidth + frameTitleOffset + frameTitleSpacing, (int)Math.round(r2d.getHeight()));
                    } else if (framTitleAlign == JdapiTypes.JUSTIFICATION_RIGHT_CTID || framTitleAlign == JdapiTypes.JUSTIFICATION_END_CTID){
                        g2d.setColor(frameTitleBackColor);
                        g2d.fillRect(width - halflinewidth - frameTitleOffset - 2*frameTitleSpacing - (int)Math.round(r2d.getWidth()), 0 , frameTitleSpacing*2 + (int)Math.round(r2d.getWidth()), (int)Math.round(r2d.getHeight()));
                        g2d.setColor(frameTitleForegroundColor);
                        g2d.drawString(frameTitle,width - halflinewidth - frameTitleOffset - frameTitleSpacing - (int)Math.round(r2d.getWidth()),(int)Math.round(r2d.getHeight()));
                    } else if (framTitleAlign == JdapiTypes.JUSTIFICATION_CENTER_CTID){
                        g2d.setColor(frameTitleBackColor);
                        g2d.fillRect(width/2 - frameTitleSpacing - (int)Math.round(r2d.getWidth()/2), 0 , frameTitleSpacing*2 + (int)Math.round(r2d.getWidth()), (int)Math.round(r2d.getHeight()));
                        g2d.setColor(frameTitleForegroundColor);
                        g2d.drawString(frameTitle,width/2 - (int)Math.round(r2d.getWidth()/2),(int)Math.round(r2d.getHeight()));
                    }
                break;
        }

        try {
            ImageIO.write(image,"png",f);
            realSize.x = image.getWidth();
            realSize.y = image.getHeight();
            return formmodule.getName().toLowerCase() + "_images/" + fileName+".png";
        } catch (IOException e) {
            return null;
        }
    }
    
    private Rectangle2D getStringRectangle(java.awt.Font font, String s){
//        java.awt.geom.AffineTransform atf = new java.awt.geom.AffineTransform();
//        java.awt.font.FontRenderContext frc = new java.awt.font.FontRenderContext(atf,false,false);
//        return font.getStringBounds(s,frc);

        FontMetrics fm = Toolkit.getDefaultToolkit().getFontMetrics(font);
        int strWidth = fm.stringWidth(s);    
        int strHeight = fm.getAscent();  //fm.getHeight();
        
        return new Rectangle2D.Float(0f,0f,(float)strWidth,(float)strHeight );

    }
    
    
    private int oracle2JavaFontStyle(int oracleFontStyle){
        switch (oracleFontStyle) {
            case 0 /*JdapiTypes.FOST_PLAIN_CTID*/ : return java.awt.Font.PLAIN;
            case 1 /*JdapiTypes.FOST_ITALIC_CTID*/ : return java.awt.Font.ITALIC;
            case 2 /*JdapiTypes.FOST_OBLIQUE_CTID*/ : return java.awt.Font.PLAIN; 
            case 3 /*JdapiTypes.FOST_UNDERLINE_CTID*/ : return java.awt.Font.PLAIN; 
            case 4 /*JdapiTypes.FOST_OUTLINE_CTID*/ : return java.awt.Font.PLAIN;
            case 5 /*JdapiTypes.FOST_SHADOW_CTID*/ : return java.awt.Font.BOLD; 
            case 6 /*JdapiTypes.FOST_INVERTED_CTID*/ : return java.awt.Font.PLAIN; 
            case 7 /*JdapiTypes.FOST_OVERSTRIKE_CTID*/ : return java.awt.Font.PLAIN; 
            case 8 /*JdapiTypes.FOST_BLINK_CTID*/ : return java.awt.Font.PLAIN; 
            default :  return java.awt.Font.PLAIN;
        }
    }
       
    private int getParentFontSize(Item item) {
        return getParentFontSize(item.getCanvasObject());
    }
    
    private int getParentFontSize(Canvas c){
        int fontsize = 0;
        if (c==null) fontsize = defaultFont.getSize();
        else {
            fontsize = c.getFontSize()/100;
            if (fontsize==0){
                Window w = c.getWindowObject();
                if (w==null) fontsize = defaultFont.getSize();
                else {
                    fontsize = w.getFontSize()/100;
                    if (fontsize==0) fontsize = defaultFont.getSize();
                }
            }
        }
        return fontsize;
    }  

    private int getParentFontStyle(Item item) {
        return getParentFontStyle(item.getCanvasObject());
    }
    
    private int getParentFontStyle(Canvas c){
        int fontstyle = -1;
        if (c==null) fontstyle = -1;
        else {
            fontstyle = c.getFontStyle();
            if (fontstyle==0){
                Window w = c.getWindowObject();
                if (w==null) fontstyle = -1;
                else {
                    fontstyle = w.getFontStyle();
                    if (fontstyle==0) fontstyle = -1;
                }
            }
        }
        return fontstyle;
    }  
   
    
    private String getParentFontName(Item item) {
        return getParentFontName(item.getCanvasObject());
    }
    
    private String getParentFontName(Canvas c){
        String fontname = "";
        if (c==null) fontname = defaultFont.getFontName();
        else {
            fontname = c.getFontName();
            if (fontname==null || "".equals(fontname) ){
                Window w = c.getWindowObject();
                if (w==null) fontname = defaultFont.getName();
                else {
                    fontname = w.getFontName();
                    if (fontname==null || "".equals(fontname)) fontname = defaultFont.getName();
                }
            }
        }
        return fontname;
    }      
    
    
    private java.awt.Font getItemFont(Item item){
        String fontName = item.getFontName();
        if (fontName==null || fontName.equals("")) fontName = getParentFontName(item);

        int fontStyle = item.getFontStyle();
        if (fontStyle==0) {
            fontStyle = getParentFontStyle(item);
            if (fontStyle==-1) fontStyle = java.awt.Font.PLAIN;
            else fontStyle = oracle2JavaFontStyle(fontStyle);
        }else fontStyle = oracle2JavaFontStyle(fontStyle);
        
        int fontSize = item.getFontSize()/100;
        if (fontSize==0) fontSize = getParentFontSize(item);
        
        return  new java.awt.Font(fontName,fontStyle,fontSize);        
    }

    private java.awt.Font getItemFont(RadioButton rb, Item item){
        String fontName = rb.getFontName();
        if (fontName==null || fontName.equals("")) fontName = getParentFontName(item);

        int fontStyle = rb.getFontStyle();
        if (fontStyle==0) {
            fontStyle = getParentFontStyle(item);
            if (fontStyle==-1) fontStyle = java.awt.Font.PLAIN;
            else fontStyle = oracle2JavaFontStyle(fontStyle);
        }else fontStyle = oracle2JavaFontStyle(fontStyle);
        
        int fontSize = rb.getFontSize()/100;
        if (fontSize==0) fontSize = getParentFontSize(item);
        
        return  new java.awt.Font(fontName,fontStyle,fontSize);        
    }



    private java.awt.Font getItemPromptFont(Item item){
        String fontName = item.getPromptFontName();
        if (fontName==null || fontName.equals("")) {
            fontName = item.getFontName();
            if (fontName==null || fontName.equals("")){
                fontName = getParentFontName(item);
            }
        }
        
        int fontStyle = item.getPromptFontStyle();
        if (fontStyle==0) {
            fontStyle = item.getFontStyle();
            if (fontStyle==0) fontStyle = getParentFontStyle(item);
            if (fontStyle==-1) fontStyle = java.awt.Font.PLAIN;
            else fontStyle = oracle2JavaFontStyle(fontStyle);        
        } else fontStyle = oracle2JavaFontStyle(fontStyle);        
        
        
        int fontSize = item.getPromptFontSize()/100;
        if (fontSize==0) fontSize = getParentFontSize(item);
        
        return  new java.awt.Font(fontName,fontStyle,fontSize);
    }

    private java.awt.Font getItemPromptFont(RadioButton rb,Item item){
        String fontName = rb.getPromptFontName();
        if (fontName==null || fontName.equals("")) {
            fontName = rb.getFontName();
            if (fontName==null || fontName.equals("")){
                fontName = getParentFontName(item);
            }
        }
        
        int fontStyle = rb.getPromptFontStyle();
        if (fontStyle==0) {
            fontStyle = rb.getFontStyle();
            if (fontStyle==0) fontStyle = getParentFontStyle(item);
            if (fontStyle==-1) fontStyle = java.awt.Font.PLAIN;
            else fontStyle = oracle2JavaFontStyle(fontStyle);        
        } else fontStyle = oracle2JavaFontStyle(fontStyle);        
        
        
        int fontSize = rb.getPromptFontSize()/100;
        if (fontSize==0) fontSize = getParentFontSize(item);
        
        return  new java.awt.Font(fontName,fontStyle,fontSize);
    }
    
    private java.awt.Point getPromptPoint(Item item, int x, int y, java.awt.Font font){
        //int promptJustification = item.getPromptJustification(); //JdapiTypes.HOJU_LEFT_CTID, JdapiTypes.HOJU_RIGHT_CTID, JdapiTypes.HOJU_CENTER_CTID, JdapiTypes.HOJU_START_CTID, JdapiTypes.HOJU_END_CTID
        int promptAlign = item.getPromptAlign(); //JdapiTypes.ALIG_START_CTID, JdapiTypes.ALIG_END_CTID, JdapiTypes.ALIG_CENTER_CTID
        int promptAttachmentEdge = item.getPromptAttachmentEdge();  //JdapiTypes.PRAT_START_CTID, JdapiTypes.PRAT_END_CTID, JdapiTypes.PRAT_TOP_CTID, JdapiTypes.PRAT_BOTTOM_CTID
        
        Rectangle2D r2d = getStringRectangle(font,item.getPrompt());
        
        int StringWidth = (int)Math.round(r2d.getWidth() + 4) ;   //pageX2Forms(r2d.getWidth() + 4);
        int StringHeight = (int)Math.round(r2d.getHeight() + 4);  //pageY2Forms(r2d.getHeight() + 4);
        
        java.awt.Point p = new java.awt.Point();
        
        if (promptAttachmentEdge==JdapiTypes.PRAT_START_CTID){
            if (promptAlign == JdapiTypes.ALIG_START_CTID){
                p.x = x - StringWidth;
                p.y = y ;
                p.y = p.y + item.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_END_CTID){
                p.x = x - StringWidth;
                p.y = y + item.getHeight() - StringHeight;   
                p.y = p.y - item.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_CENTER_CTID){
                p.x = x - StringWidth;
                p.y = y + (int)Math.round((item.getHeight() - StringHeight) /2);                   
                p.y = p.y + item.getPromptAlignOffset();
            }
            p.x = p.x - item.getPromptAttachmentOffset();
        }else if (promptAttachmentEdge==JdapiTypes.PRAT_END_CTID){
            if (promptAlign == JdapiTypes.ALIG_START_CTID){
                p.x = x + item.getWidth();
                p.y = y ;
                p.y = p.y + item.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_END_CTID){
                p.x = x + item.getWidth();
                p.y = y + item.getHeight() - StringHeight;   
                p.y = p.y - item.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_CENTER_CTID){
                p.x = x + item.getWidth();
                p.y = y + (int)Math.round((item.getHeight() - StringHeight) /2);  
                p.y = p.y + item.getPromptAlignOffset();
            }
            p.x = p.x + item.getPromptAttachmentOffset();
        }else if (promptAttachmentEdge==JdapiTypes.PRAT_TOP_CTID){
            if (promptAlign == JdapiTypes.ALIG_START_CTID){
                p.x = x;
                p.y = y - StringHeight;
                p.x = p.x + item.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_END_CTID){
                p.x = x + item.getWidth() - StringWidth;
                p.y = y - StringHeight;
                p.x = p.x - item.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_CENTER_CTID){
                p.x = x + (int)Math.round((item.getWidth() - StringWidth) /2);
                p.y = y - StringHeight;
                p.x = p.x + item.getPromptAlignOffset();
            } 
            p.y = p.y - item.getPromptAttachmentOffset();
        }else if (promptAttachmentEdge==JdapiTypes.PRAT_BOTTOM_CTID){
            if (promptAlign == JdapiTypes.ALIG_START_CTID){
                p.x = x ;
                p.y = y + item.getHeight();
                p.x = p.x + item.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_END_CTID){
                p.x = x + item.getWidth() - StringWidth;
                p.y = y + item.getHeight();
                p.x = p.x - item.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_CENTER_CTID){
                p.x = x + (int)Math.round((item.getWidth() - StringWidth) /2);
                p.y = y + item.getHeight();
                p.x = p.x + item.getPromptAlignOffset();
            }
            p.y = p.y + item.getPromptAttachmentOffset();
        }
        
        return p;
    }

    private java.awt.Point getPromptPoint(RadioButton rb, int x, int y, java.awt.Font font){
        //int promptJustification = item.getPromptJustification(); //JdapiTypes.HOJU_LEFT_CTID, JdapiTypes.HOJU_RIGHT_CTID, JdapiTypes.HOJU_CENTER_CTID, JdapiTypes.HOJU_START_CTID, JdapiTypes.HOJU_END_CTID
        int promptAlign = rb.getPromptAlign(); //JdapiTypes.ALIG_START_CTID, JdapiTypes.ALIG_END_CTID, JdapiTypes.ALIG_CENTER_CTID
        int promptAttachmentEdge = rb.getPromptAttachmentEdge();  //JdapiTypes.PRAT_START_CTID, JdapiTypes.PRAT_END_CTID, JdapiTypes.PRAT_TOP_CTID, JdapiTypes.PRAT_BOTTOM_CTID
        
        Rectangle2D r2d = getStringRectangle(font,rb.getPrompt());
        
        int StringWidth = (int)Math.round(r2d.getWidth() + 4) ;   //pageX2Forms(r2d.getWidth() + 4);
        int StringHeight = (int)Math.round(r2d.getHeight() + 4);  //pageY2Forms(r2d.getHeight() + 4);
        
        java.awt.Point p = new java.awt.Point();
        
        if (promptAttachmentEdge==JdapiTypes.PRAT_START_CTID){
            if (promptAlign == JdapiTypes.ALIG_START_CTID){
                p.x = x - StringWidth;
                p.y = y ;
                p.y = p.y + rb.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_END_CTID){
                p.x = x - StringWidth;
                p.y = y + rb.getHeight() - StringHeight;   
                p.y = p.y - rb.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_CENTER_CTID){
                p.x = x - StringWidth;
                p.y = y + (int)Math.round((rb.getHeight() - StringHeight) /2);                   
                p.y = p.y + rb.getPromptAlignOffset();
            }
            p.x = p.x - rb.getPromptAttachmentOffset();
        }else if (promptAttachmentEdge==JdapiTypes.PRAT_END_CTID){
            if (promptAlign == JdapiTypes.ALIG_START_CTID){
                p.x = x + rb.getWidth();
                p.y = y ;
                p.y = p.y + rb.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_END_CTID){
                p.x = x + rb.getWidth();
                p.y = y + rb.getHeight() - StringHeight;   
                p.y = p.y - rb.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_CENTER_CTID){
                p.x = x + rb.getWidth();
                p.y = y + (int)Math.round((rb.getHeight() - StringHeight) /2);  
                p.y = p.y + rb.getPromptAlignOffset();
            }
            p.x = p.x + rb.getPromptAttachmentOffset();
        }else if (promptAttachmentEdge==JdapiTypes.PRAT_TOP_CTID){
            if (promptAlign == JdapiTypes.ALIG_START_CTID){
                p.x = x;
                p.y = y - StringHeight;
                p.x = p.x + rb.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_END_CTID){
                p.x = x + rb.getWidth() - StringWidth;
                p.y = y - StringHeight;
                p.x = p.x - rb.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_CENTER_CTID){
                p.x = x + (int)Math.round((rb.getWidth() - StringWidth) /2);
                p.y = y - StringHeight;
                p.x = p.x + rb.getPromptAlignOffset();
            } 
            p.y = p.y - rb.getPromptAttachmentOffset();
        }else if (promptAttachmentEdge==JdapiTypes.PRAT_BOTTOM_CTID){
            if (promptAlign == JdapiTypes.ALIG_START_CTID){
                p.x = x ;
                p.y = y + rb.getHeight();
                p.x = p.x + rb.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_END_CTID){
                p.x = x + rb.getWidth() - StringWidth;
                p.y = y + rb.getHeight();
                p.x = p.x - rb.getPromptAlignOffset();
            }else if (promptAlign == JdapiTypes.ALIG_CENTER_CTID){
                p.x = x + (int)Math.round((rb.getWidth() - StringWidth) /2);
                p.y = y + rb.getHeight();
                p.x = p.x + rb.getPromptAlignOffset();
            }
            p.y = p.y + rb.getPromptAttachmentOffset();
        }
        
        return p;
    }
    
    private void calculateCoordinateCoefficient(FormModule formmodule){
        int dpi = Toolkit.getDefaultToolkit().getScreenResolution();
        Coordinate cod = new Coordinate(formmodule);
        if (cod.getCoordinateSystem() == JdapiTypes.COSY_CHARACTER_CTID){
            coordinateXCoefficient = cod.getCharacterCellWidth();
            coordinateYCoefficient = cod.getCharacterCellHeight();
        }else if (cod.getCoordinateSystem() == JdapiTypes.COSY_REAL_CTID){
            switch(cod.getRealUnit()){
                case 0 /*JdapiTypes.REUN_PIXEL_CTID*/ : 
                    coordinateXCoefficient = 1.0d;
                    coordinateYCoefficient = 1.0d;
                    break;
                case 1 /*JdapiTypes.REUN_CENTIMETER_CTID*/ : 
                    coordinateXCoefficient = dpi / 2.54d;
                    coordinateYCoefficient = dpi / 2.54d;                    
                    break;
                case 2 /*JdapiTypes.REUN_INCH_CTID*/ : 
                    coordinateXCoefficient = 1.0d*dpi;
                    coordinateYCoefficient = 1.0d*dpi;                    
                    break;
                case 3 /*JdapiTypes.REUN_POINT_CTID*/ : 
                     coordinateXCoefficient = 1.0d*dpi/72;
                     coordinateYCoefficient = 1.0d*dpi/72;                    
                    break;
                case 4 /*JdapiTypes.REUN_DECIPOINT_CTID*/ : 
                    coordinateXCoefficient = 1.0d*dpi*10/72;
                    coordinateYCoefficient = 1.0d*dpi*10/72;                    
                    break;
            }
        }
        defaultFont = new java.awt.Font(defaultFont.getFontName(),defaultFont.getStyle(),cod.getCharacterCellWidth());
    }
 
    private int formsX2Page(int f){
        return (int)Math.max(0,Math.round(f*coordinateXCoefficient));
    }
    
    private int formsY2Page(int f){
        return (int)Math.max(0,Math.round(f*coordinateYCoefficient));
    }
    
    private int pageX2Forms(double p){
        return (int)Math.round(p/coordinateXCoefficient);
    }
    
    private int pageY2Forms(double p){
        return (int)Math.round(p/coordinateYCoefficient);
    }
 
    private String formsColor2Html(String c){
        try{
            if (c==null || c.equals("")) return "rgb(114,143,143)";
            c = c.toLowerCase();
            int r = c.indexOf("r");
            int g = c.indexOf("g");
            int b = c.indexOf("b");
            String rS = c.substring(r+1,g);
            String gS = c.substring(g+1,b);
            String bS = c.substring(b+1);
            r = (int)Math.round(Integer.parseInt(rS) * 255 /100);
            g = (int)Math.round(Integer.parseInt(gS) * 255 /100);
            b = (int)Math.round(Integer.parseInt(bS) * 255 /100);
            return "rgb("+r+","+g+","+b+")";
        }catch(Exception e){
            return "rgb(114,143,143)";
        }       
    }
 
    private Color formsColor2Java(String c){
        return formsColor2Java( c , new Color(114,143,143,0));
    }
    
    private Color formsColor2Java(String c , Color defaultColor){
        if (c.toUpperCase().indexOf("BLACK")>=0) return Color.BLACK;
        if (c.toUpperCase().indexOf("BLUE")>=0) return Color.BLUE;
        if (c.toUpperCase().indexOf("CYAN")>=0) return Color.CYAN;
        if (c.toUpperCase().indexOf("DARK_GRAY")>=0) return Color.DARK_GRAY;
        if (c.toUpperCase().indexOf("GREEN")>=0) return Color.GREEN;
        if (c.toUpperCase().indexOf("LIGHT_GRAY")>=0) return Color.LIGHT_GRAY;
        if (c.toUpperCase().indexOf("MAGENTA")>=0) return Color.MAGENTA;
        if (c.toUpperCase().indexOf("ORANGE")>=0) return Color.ORANGE;
        if (c.toUpperCase().indexOf("PINK")>=0) return Color.PINK;
        if (c.toUpperCase().indexOf("RED")>=0) return Color.RED;
        if (c.toUpperCase().indexOf("WHITE")>=0) return Color.WHITE;
        if (c.toUpperCase().indexOf("YELLOW")>=0) return Color.YELLOW;
        if (c.toUpperCase().indexOf("GRAY")>=0) {
            c = c.toUpperCase().replaceAll("GRAY","");
            try{
                int i = Integer.parseInt(c);
                return new Color(255*(100-i)/100,255*(100-i)/100,255*(100-i)/100);
            } catch (Exception ex){
                return Color.GRAY;
            }
        }

        try{
            if (c==null || c.equals("")) return defaultColor;
            c = c.toLowerCase();
            int r = c.indexOf("r");
            int g = c.indexOf("g");
            int b = c.indexOf("b");
            String rS = c.substring(r+1,g);
            String gS = c.substring(g+1,b);
            String bS = c.substring(b+1);
            r = (int)Math.round(Integer.parseInt(rS) * 255 /100);
            g = (int)Math.round(Integer.parseInt(gS) * 255 /100);
            b = (int)Math.round(Integer.parseInt(bS) * 255 /100);
            return new Color(r,g, b);
        }catch(Exception e){
            return defaultColor;
        }       
    }



    
}


