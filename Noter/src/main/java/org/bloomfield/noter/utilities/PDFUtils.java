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

import org.apache.pdfbox.pdmodel.*;

public class PDFUtils {
    PDDocument doc;
    
    public void createPDF(PDDocument document, PDPage... page){
        doc=document;
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
    public String getQuestionsList(){
        return "asdf";
    }
    public String getSpacing(){
        return "asdf";
    }
}
