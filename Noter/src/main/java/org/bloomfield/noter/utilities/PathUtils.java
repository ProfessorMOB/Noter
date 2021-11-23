/*
* This file is part of Noter.
* 
* Noter is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* 
* Noter is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with Noter.  If not, see <https://www.gnu.org/licenses/>.
*/

package org.bloomfield.noter.utilities;

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