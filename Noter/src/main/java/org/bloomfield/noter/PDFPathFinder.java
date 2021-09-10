package org.bloomfield.noter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PDFPathFinder {
    protected String etceteraPath="";
    private String path = System.getProperty("user.home");
    private Pattern p = Pattern.compile("(.*)(/)(.*)");
    private Matcher m = p.matcher(path);
    protected boolean pathStyle = m.matches();
    protected String getPDFDir(){
        if(pathStyle==true){
            path=path+"/Documents/"+etceteraPath+"/";
        }
        else if(pathStyle==false){
            path=path+"\\Documents\\"+etceteraPath+"\\";
        }
        return path;
    }

    
}