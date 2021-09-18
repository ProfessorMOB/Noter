package org.bloomfield.noter.PDFMaking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

This class finds the documents folder of the OS, be it MacOS, Windows, or Linux

*/


public class PDFPathFinder {
    
    //This is the custom path for where to put the PDFs
    public String customPath=""; 

    // Using regex to find if the system uses '/' or '\'
    private String path = System.getProperty("user.home");
    private Pattern p = Pattern.compile("(.*)(/)(.*)");
    private Matcher m = p.matcher(path);
    private boolean pathStyle = m.matches();
    
    // The function for getting the path to put the PDFs in
    public String getPDFDir(){
        if(pathStyle==true){
            path=path+"/Documents/"+customPath;
        }
        else if(pathStyle==false){
            path=path+"\\Documents\\"+customPath;
        }
        return path;
    }
}