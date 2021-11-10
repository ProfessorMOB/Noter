package org.bloomfield.noter.utilities;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;

public class ReadData {
    // Required Program variables
    static CSVParser p;
    private String currentUser = "Guest";

    // instantiate CSVParser when class instantiated
    public ReadData(){
        try {
            p= new CSVParser(new BufferedReader(new InputStreamReader(getClass()
                .getClassLoader()
                .getResourceAsStream("profile.csv"))), CSVFormat.DEFAULT.withHeader());
        } catch(IOException e){}
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
                System.out.println("email or password doesn't exist");
            }
            p.close();
        } catch(IOException e){}
    }

    // create a new profile
    public void createProfile() {
        
    }
    
    // get the current user
    public String getCurrentUser(){
        return currentUser;
    }
}
    
class test {

}