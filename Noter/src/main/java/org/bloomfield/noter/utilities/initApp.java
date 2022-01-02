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


import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class initApp {
     
    // Instantiate the windows
    public JFrame beginPage = new JFrame();
    JFrame docTools = new JFrame();
    JDialog jd;

    // Instantiate layouts
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    
    // Declare misc variables to use
    ReadData d = new ReadData();
    PathUtils pu = new PathUtils();
    
    // Declare components to use
    JButton b1, b4, accountStatus;
    public JButton signIn, createAccount; // set these invisible once the user logs in and add welcome [user]
    JLabel l1, l2, l3, email, password, name;
    JList<String> recentlyAccessed, recentlyCreated;
    Font font, font1;
    JTextComponent ps, em, nm;


    // Instantiate welcome page
    
    public void initBeginPage() {

        // Create GridBagLayout Constraints
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth=8;
        c.gridheight=1;
        int temp=c.ipady;
        c.ipadx=50;
        c.ipady=1;

        
        // Welcome text
        l3=new JLabel("Welcome");
        font = new Font("Ariel", Font.BOLD, 50);
        l3.setFont(font);
        l3.setHorizontalAlignment(JLabel.CENTER);
        ComponentSettings(l3, 0, 0);

        
        // Sign in
        signIn = new JButton("Sign in (TBA)");
        signIn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                em = new JTextField();
                ps = new JPasswordField();
                email = new JLabel("Email");
                password = new JLabel("Password");
                accountStatus = new JButton("Done");
                accountStatus.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        // grab csv data if account is being accessed
                        d.signIn(em.getText(), ps.getText());
                        jd.dispose();
                    }
                });
                jd = new JDialog();
                jd.setLayout(new GridLayout(5, 1));
                jd.setBounds(300,200,300,200);
                jd.setSize(300,200);
                jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                jd.add(accountStatus, SwingConstants.CENTER);
                jd.add(ps, SwingConstants.CENTER);
                jd.add(password, SwingConstants.CENTER);
                jd.add(em, SwingConstants.CENTER);
                jd.add(email, SwingConstants.CENTER);

                jd.setVisible(true);
            }
        });
        signIn.setFont(font1);
        c.ipadx=5;
        c.ipady=10;
        ComponentSettings(signIn, 6, 0);


        // Create account
        createAccount = new JButton("Create Account (TBA)");
        createAccount.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                em = new JTextField();
                ps = new JPasswordField();
                nm = new JTextField();
                email = new JLabel("Email");
                password = new JLabel("Password");
                name = new JLabel("Name");
                accountStatus = new JButton("Done");
                accountStatus.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                        // write to csv data 
                        System.out.println(em.getText()+ps.getText()+nm.getText());
                        d.createProfile(em.getText(), ps.getText(), nm.getText());
                        jd.dispose();
                    }
                });

                jd = new JDialog();
                jd.setLayout(new GridLayout(7, 1));
                jd.setBounds(300,300,300,300);
                jd.setSize(300,200);

                jd.add(accountStatus, SwingConstants.CENTER);
                jd.add(ps, SwingConstants.CENTER);
                jd.add(password, SwingConstants.CENTER);
                jd.add(em, SwingConstants.CENTER);
                jd.add(email, SwingConstants.CENTER);
                jd.add(nm, SwingConstants.CENTER);
                jd.add(name, SwingConstants.CENTER);

                jd.setVisible(true);
            }
        });
        createAccount.setFont(font1);
        c.ipadx=10;
        c.ipady=15;
        ComponentSettings(createAccount, 6, 1);

        
        // Create new and Preferences Buttons
        c.gridwidth=2;
        c.ipadx=40;
        c.ipady=temp;
        b1 = new JButton("Create new");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                initDocTools(/*"untitled"*/);
             }
        });
        ComponentSettings(b1, 1, 1);
        b4 = new JButton("Preferences");
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                initPreferences();
             }
        });
        ComponentSettings(b4, 3, 1);
        
        
        /* List of pdfs */
        
        // Instantiate required variables
        String[] array2 = pu.listOfFiles();
        String[] array = pu.listOfFiles();
        for (String element : pu.listOfFiles()) {
            // int x = 0;
            if(element=="profiles.csv"){
                // fix profilescsv from showing up
            }
        }
        for (String element : array) {

        }
        font1= new Font("Ariel", Font.PLAIN, 15);
        
        // Recently Accessed and Recently Created buttons
        l1 = new JLabel("Recently Accessed");
        l1.setFont(font1);
        ComponentSettings(l1, 1, 2);
        recentlyAccessed = new JList<String>(array);
        recentlyAccessed.setVisibleRowCount(22);
        recentlyAccessed.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        recentlyAccessed.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                initDocTools(/*recentlyAccessed.getSelectedValue()*/);
            }
        });
        JScrollPane reac = new JScrollPane(recentlyAccessed);
        ComponentSettings(reac, 1, 3);
        
        l2 = new JLabel("Recently Created");
        l2.setFont(font1);
        ComponentSettings(l2, 3, 2);
        recentlyCreated = new JList<String>(array2);
        recentlyCreated.setVisibleRowCount(22);
        recentlyCreated.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        recentlyCreated.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                initDocTools(/*recentlyCreated.getSelectedValue()*/);
            }
        });
        JScrollPane recr = new JScrollPane(recentlyCreated);
        ComponentSettings(recr, 3, 3);
    }

    //Instantiating the Document UI
    public void initDocTools(/*String doc*/){
        // for the new docs
        
        // for the existing docs
        // Loop through the list of documents and open the requested one
        // if the doc doesn't exist create an error dialog, delete the doc from the list

        /* switch (doc){
            case "untitled":
            // create a new untitled document
            break;
            case "": // 

            default: 
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } */

        App2 tools = new App2();

        
        /*
        
        
        JF(docTools, 800);
        docTools.setTitle(doc);
        docTools.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        docTools.setVisible(true);
        // create necessary gui

        //
        if(doc=="untitled") {
            int x = 0;
            for (String element : pu.listOfFiles()) {
                if (element == doc+x){
                    x++;
                }
            }
            doc = doc + x;
        }
        // else if (){

        // }
        else {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }


        */
        
        
        // Open document
        // create the necessary gui, make sure it targets 
        /*
        * String Argument to open a document
        * If string argument is "untitled" then create a new file and open it
        * If it is from the list of pdfs, then open it
        * If it isn't from anywhere and is undefined, then create an error dialog
        */
        
        // Tools
        /*
        * Textcomponents to grab user input
        * create options for the user to scroll through, then when the user is satisfied, he/she can add it to the doc
        * the user can also embed images, use FileDialog
        */
    }

    // Instantiating the preferences (optional)
    public void initPreferences() {
        // Preferences (optional)
        /*
        * the user can set the default settings for them to use in their tools
        * 
        */
    }

    public void JF(JFrame f, int size){
        f.setLayout(layout);
        f.setResizable(true);
        f.setSize(size, size);
        f.setBounds(size,size,size,size);
        f.setLocationRelativeTo(null);
    }

    public void ComponentSettings (JComponent jc, int gridx, int gridy) {
        c.gridx=gridx;
        c.gridy=gridy;
        beginPage.add(jc, c);
    }

    public void ComponentSettings (JTextComponent jtc, int gridx, int gridy) {
        c.gridx=gridx;
        c.gridy=gridy;
        beginPage.add(jtc, c);
    }
}