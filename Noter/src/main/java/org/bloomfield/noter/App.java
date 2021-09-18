package org.bloomfield.noter;

import javax.swing.*;
import org.bloomfield.noter.PDFMaking.PDFPathFinder;
import org.bloomfield.noter.GUI.CreateGUI;
public class App {
    public static void main( String[] args )
    {
        PDFPathFinder PPF = new PDFPathFinder();
        String path = PPF.getPDFDir();
        
        JFrame jf = new JFrame();
        CreateGUI swing = new CreateGUI();
        swing.instantiateSwing(jf);
        swing.UI(jf);
    }
}
