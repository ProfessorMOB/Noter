package org.bloomfield.noter.utilities;

import javax.swing.JOptionPane;

import java.io.*;

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
            pr = new CSVPrinter(new BufferedWriter(new FileWriter(f)), CSVFormat.DEFAULT.withHeader());
            p = new CSVParser(new BufferedReader(new FileReader(f)), CSVFormat.DEFAULT.withHeader());
        } catch(IOException e){}
    }
    public ReadData(boolean close){
        if(close){
            try {
                pr.close();
                p.close();
            } catch (IOException e) {}
            
        }
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