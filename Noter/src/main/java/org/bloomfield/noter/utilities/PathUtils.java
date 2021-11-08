package org.bloomfield.noter.utilities;

/*
* 
* This Class allows for compatibility between platforms when creating paths for files
* 
*/

public class PathUtils {
    
    // Default Folder PDF Path
    public String customPath="Noter-Docs"; 
    
    // Get System Properties and the location of the PDFs
    public String getDir(){
        return getHome()+getSep()+customPath;
    }
    public String getSep() {
        return System.getProperty("path.separator");
    }
    public String getHome() {
        return System.getProperty("user.home");
    }
}