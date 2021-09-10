package org.bloomfield.noter;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.*;
public class App {
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        PDDocument doc = new PDDocument();
        PDFPathFinder PPF = new PDFPathFinder();
        PPF.etceteraPath="Notes";
        String path = PPF.getPDFDir();
        // doc.save("C:/PdfBox_Examples/my_doc.pdf");
        // doc.close();
    }
}
