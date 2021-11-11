package org.bloomfield.noter.utilities;

import javax.swing.JOptionPane;

import java.io.*;
import java.net.URISyntaxException;

import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.nio.*;
import java.nio.file.*;

public class ReadData {
    // Required Program variables
    static CSVParser p;
    CSVPrinter pr;
    static private String currentUser = "Guest";
    
    // instantiate CSVParser when class instantiated
    public ReadData(){
        try {
            Path ps = Path.of(getClass().getClassLoader().getResource("profile.csv").toURI());
            p= new CSVParser(new BufferedReader(new InputStreamReader(getClass()
                .getClassLoader()
                .getResourceAsStream("profile.csv"))), CSVFormat.DEFAULT.withHeader());
            pr = new CSVPrinter(new FileWriter(ps.toString()), CSVFormat.DEFAULT.withHeader());
        } catch(IOException e){}
        catch(URISyntaxException e) {}
    }
    public ReadData(boolean close){
        if(close){
            try {
                pr.close();
                p.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
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
                        break TEST_EMAIL;
                    }
                }
                pr.printRecord(name, password, email);
                currentUser = name;
            }
        } catch(IOException e){}
        System.out.println(currentUser);
    }
    
    // get the current user
    public String getCurrentUser(){
        return currentUser;
    }
}
    
class test {
    /* public static void main(String[] args) {
        ReadData d = new ReadData();
        d.pr.print("value");
    }*/ 
}