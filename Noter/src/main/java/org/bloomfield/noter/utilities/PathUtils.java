package org.bloomfield.noter.utilities;



/*
* 
* Deals with PDF paths and system properties for cross compatibility
* 
*/

public class PathUtils {
    
    // Paths

    private String profilePath="";
    private String defaultPath=getHome()+getSep()+"Documents"+getSep()+"Noter-Docs"; 
    // Get System Properties and the location of the PDFs
    public String getDir(){
        return defaultPath;
    }
    public String getProfileDir(){
        return defaultPath+getSep()+profilePath;
    }
    public String getSep() {
        return System.getProperty("file.separator");
    }
    public String getHome() {
        return System.getProperty("user.home");
    }
    // set the profile's path
    public void setProfilePath(String path){
        this.profilePath = path;
    }
    // Admin users have privilege to change default path
    public void changeDefaultPath(String path){
        this.defaultPath=path;
    }
    public void setProfile(){
        
    }
    public void initPath(){
        // scans the Document directory to see if the noter docs exists, if it doesn't then it creates it
        // grabs the profile to create subdir for profile's personal page
        // 
    }
}