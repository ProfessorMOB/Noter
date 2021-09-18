package org.bloomfield.noter.GUI;

import org.bloomfield.noter.PDFMaking.PDFPathFinder;
import javax.swing.*;

public class CreateGUI {

    // The method to instantiate the Swing GUI
    public void instantiateSwing(JFrame f){
        f.setResizable(true);
        f.setSize(600, 600);
        f.setBounds(600,600,600,600);
        f.setVisible(true);
        f.setLayout(null);
        // GroupLayout gl = new GroupLayout(f);
        // f.setLayout(gl);
    }
    public void UI(JFrame f){
        PDFPathFinder pdfpath = new PDFPathFinder();
        JButton jb = new JButton(pdfpath.getPDFDir());
        jb.setBounds(200, 200, 200, 200);
        jb.setSize(200, 200);
        jb.setVisible(true);
        f.add(jb);
    }
}