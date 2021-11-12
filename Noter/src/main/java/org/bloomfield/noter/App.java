package org.bloomfield.noter;

import javax.swing.JFrame;
import org.bloomfield.noter.utilities.*;
public class App {
    public static void main(String[] args )
    {
        
        PathUtils PPF = new PathUtils();
        String path = PPF.getDir();
        System.out.println(path+"profiles.csv");

        initApp app = new initApp();
        app.JF(app.beginPage, 600);
        app.beginPage.setTitle("Main Menu");
        app.beginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.initBeginPage();
        app.beginPage.setVisible(true);
    }
}
