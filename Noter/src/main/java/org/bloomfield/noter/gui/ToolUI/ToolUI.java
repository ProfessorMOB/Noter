package org.bloomfield.noter.gui.ToolUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import org.bloomfield.noter.utilities.userInput;

public class ToolUI extends JFrame{
    static ListModel<String> currentSelectionListModel = new DefaultListModel<String>();
    static DefaultListModel<String> currentSelection;
    static JList<String> currentSelectionList;
    static int v = 0;
    JPanel totalGUI = new JPanel();
    List<userInput> userInputs = new ArrayList<userInput>();
    static JPanel currentSelectionPanel;
    static userInput changingUserInputValues;
    ToolUI() {
        // totalGUI.add(createUserInputGui());
        // totalGUI.add(createCurrentSelectionPanel());
        // totalGUI.add(createUserOptionGui());
        // totalGUI.add(createPDFViewingPanel());
        
        totalGUI.setLayout(null);
        totalGUI.setOpaque(true);
        
        this.setContentPane(totalGUI);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setBounds(800,800,800,800);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
        this.repaint();
        this.validate();
    }
}
