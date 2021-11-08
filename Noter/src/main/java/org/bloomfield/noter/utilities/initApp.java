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

    // Instantiate layouts
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    
    // Declare components to use
    JButton b1, b4;
    JLabel l1, l2, l3;
    JList<String> recentlyAccessed, recentlyCreated;
    Font font, font1;

    public void compo (){
        JPanel jp = new JPanel();
        jp.setBounds(0,0,0,0);
        jp.add(new JButton("asdf"));
        JPanel jpp = new JPanel();
        jpp.setBounds(300,300,300,300);
    }

    public void initBeginPage() {

        // Create GridBagLayout Constraints
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth=8;
        c.gridheight=1;
        int temp=c.ipady;
        c.ipadx=50;
        c.ipady=50;

        // Welcome text
        l3=new JLabel("Welcome");
        font = new Font("Ariel", Font.BOLD, 50);
        l3.setFont(font);
        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setFont(font);
        ComponentSettings(l3, 0, 0);

        // Create new and Preferences Buttons
        c.gridwidth=2;
        c.ipadx=40;
        c.ipady=temp;
        b1 = new JButton("Create new");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                initTools("untitled");
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
        
        // these arrays will act as placeholders for the pdfs
        String[] array2 = {"asdf", "adf", "asdf"};
        String[] array = {"asdf", "adf", "asdf"};
        
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
                initTools(recentlyAccessed.getSelectedValue());
            }
        });
        JScrollPane asdf = new JScrollPane(recentlyAccessed);
        ComponentSettings(asdf, 1, 3);
        
        l2 = new JLabel("Recently Created");
        l2.setFont(font1);
        ComponentSettings(l2, 3, 2);
        recentlyCreated = new JList<String>(array2);
        recentlyCreated.setVisibleRowCount(22);
        recentlyCreated.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        recentlyCreated.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                initTools(recentlyCreated.getSelectedValue());
            }
        });
        JScrollPane asdf2 = new JScrollPane(recentlyCreated);
        ComponentSettings(asdf2, 3, 3);

    }
    public void initDoc(){
        
    }
    public void initTools(String doc){
        
        /* switch (doc){
            case "untitled":
            // create a new untitled document
            break;
            case "":

            default: 
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } */

        if(doc=="untitled") {
            JF(docTools, 800);
            docTools.setTitle(doc);
            docTools.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            docTools.setVisible(true);
        }
        // else if (){

        // }
        else {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // Open document
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