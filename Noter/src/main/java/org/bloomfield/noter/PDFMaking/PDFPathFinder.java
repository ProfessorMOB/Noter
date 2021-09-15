package org.bloomfield.noter.PDFMaking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PDFPathFinder {
    public String customPath="";
    private String path = System.getProperty("user.home");
    private Pattern p = Pattern.compile("(.*)(/)(.*)");
    private Matcher m = p.matcher(path);
    private boolean pathStyle = m.matches();
    public String getPDFDir(){
        if(pathStyle==true){
            path=path+"/Documents/"+customPath+"/";
        }
        else if(pathStyle==false){
            path=path+"\\Documents\\"+customPath+"\\";
        }
        return path;
    }
}