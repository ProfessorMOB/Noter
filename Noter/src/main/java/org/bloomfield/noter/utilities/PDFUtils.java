package org.bloomfield.noter.utilities;

import org.apache.pdfbox.pdmodel.*;

public class PDFUtils {
    PDDocument doc;
    public void createPDF(PDDocument document, PDPage... page){
        doc=document;
        for (PDPage pdPage : page) {
            doc.addPage(pdPage);
        }
    }
    
}
