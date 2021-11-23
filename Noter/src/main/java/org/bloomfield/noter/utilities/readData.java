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

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class ReadData {
    // Required Program variables
    static CSVParser p;
    static CSVPrinter pr;
    PathUtils putils = new PathUtils();
    static private String currentUser = "Guest";
    // instantiate CSVParser when class instantiated
    public ReadData(){
        try {
            File f = new File(putils.getDir()+putils.getSep()+"profiles.csv");
            f.getParentFile().mkdirs();
            f.createNewFile();
            pr = new CSVPrinter(new BufferedWriter(new FileWriter(f)), CSVFormat.DEFAULT.withHeader("name","password","email"));
            p = new CSVParser(new BufferedReader(new FileReader(f)), CSVFormat.DEFAULT.withHeader("name","password","email"));
        } catch(IOException e){}
    }
    public void close(){
        try {
            pr.close();
            p.close();
        } catch (IOException e) {}
    }
    
    // sign in
    public void signIn(String email, String password){
        
        try {
            TEST_EMAIL: {
                for(CSVRecord a : p.getRecords()){
                    if ( password.equals(a.get("password")) && email.equals(a.get("email")) ) {
                        currentUser = a.get("name");
                        break TEST_EMAIL;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Invalid Email or Password", "Error", JOptionPane.ERROR_MESSAGE);
        } catch(IOException e){}
    }

    // create a new profile
    public void createProfile(String email, String password, String name) {
        try {
            TEST_EMAIL: {
                for(CSVRecord a : p.getRecords()){
                    if ( email.equals(a.get("email")) ) {
                        JOptionPane.showMessageDialog(null, "Email is already used", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println(a.get("password"));
                        break TEST_EMAIL;
                    }
                } 
                pr.printRecord(name, password, email); currentUser = name;
            }
        } catch(IOException e){}
    }
    
    // get the current user
    public String getCurrentUser(){
        return currentUser;
    }
}