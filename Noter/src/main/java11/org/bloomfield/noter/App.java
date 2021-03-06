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

package org.bloomfield.noter;

import javax.swing.JFrame;
import org.bloomfield.noter.utilities.*;
public class App {
    public static void main(String[] args )
    {
        PathUtils ppf = new PathUtils();
        System.out.println(ppf.getDir());
        initApp app = new initApp();
        app.JF(app.beginPage, 600);
        app.beginPage.setTitle("Main Menu");
        app.beginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.initBeginPage();
        app.beginPage.setVisible(true);
    }
}
