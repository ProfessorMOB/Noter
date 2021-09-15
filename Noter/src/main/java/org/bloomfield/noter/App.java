package org.bloomfield.noter;

import javax.swing.*;
import org.bloomfield.noter.PDFMaking.PDFPathFinder;
import org.bloomfield.noter.GUI.CreateGUI;
public class App {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        PDFPathFinder PPF = new PDFPathFinder();
        PPF.customPath="Notes";
        String path = PPF.getPDFDir();
        CreateGUI swing = new CreateGUI();
        swing.instantiateSwing(new JFrame());
    }
}
