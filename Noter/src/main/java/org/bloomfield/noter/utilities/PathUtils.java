package org.bloomfield.noter.utilities;

/*
* 
* Deals with PDF paths and system properties for cross compatibility
* 
*/

public class PathUtils {
    
    // Paths
    public String profilePath="";
    private String defaultPath=getHome()+getSep()+"Noter-Docs"; 
    
    // Get System Properties and the location of the PDFs
    public String getDir(){
        return defaultPath+getSep()+profilePath+getSep();
    }
    public String getSep() {
        return System.getProperty("file.separator");
    }
    public String getHome() {
        return System.getProperty("user.home");
    }

    // Admin users have privilege to change default path
    public void changeDefaultPath(String path){
        this.defaultPath=path;
    }
}