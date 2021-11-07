package org.bloomfield.noter;

import javax.swing.*;
import org.bloomfield.noter.PDFMaking.PDFPathFinder;
public class App {
    public static void main(String[] args )
    {
        
        // PDFPathFinder PPF = new PDFPathFinder();
        // String path = PPF.getPDFDir();

        GUI gui = new GUI();
        gui.JF(gui.beginPage, 600);
        gui.beginPage.setTitle("Main Menu");
        gui.beginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.initBeginPage();
        gui.beginPage.setVisible(true);
    }
}
