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

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.bloomfield.noter.utilities.userInput;

public class PDFUtils {
    PDDocument doc;
    
    public void createPDF(PDDocument document){
        doc=document;
    }

    public void createPDF(PDDocument document, PDPage... page){
        doc=document;
        for (PDPage pdPage : page) {
            doc.addPage(pdPage);
        }
    }

    public void addPages(PDPage... page){
        for (PDPage pdPage : page) {
            doc.addPage(pdPage);
        }
    }

    public String getTitle(){
        return "asdf";
    }
    
    public String getSubtitle(){
        return "asdf";
    }
    
    public String getItems(){
        return "asdf";
    }
    
    public void setTitle(){

    }
    
    public void setSubtitle(){

    }
    
    public void setItems(List<userInput> userInputs){
        PDPage p = new PDPage();
        try {
            PDPageContentStream pcs = new PDPageContentStream(doc, p);
            pcs.setFont(PDType1Font.COURIER, 10);
            pcs.beginText();
            pcs.newLineAtOffset(20, 20);
            for (userInput uInput : userInputs) {
                pcs.showText(uInput.getItem());
                for(int x = uInput.getSpacing(); x>0; x--){
                    pcs.newLine();
                }
            }
            addPages(p);
            pcs.endText();
            pcs.close();
        } catch (IOException e) {e.printStackTrace();}
    }

    public void finishDoc(String name){
        PathUtils pu = new PathUtils();
        try {
            doc.save(new File(pu.getDir()+pu.getSep()+name+".pdf"));
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
