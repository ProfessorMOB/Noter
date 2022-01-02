package org.bloomfield.noter.gui.ToolUI;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bloomfield.noter.utilities.*;

public class UserInputUI extends JPanel{
    List<userInput> userInputs = new ArrayList<userInput>();
    static DefaultListModel<String> currentSelection;
    UserInputUI() {
        JPanel userInputPanel = new JPanel();
        userInputPanel.setLayout(new BoxLayout(userInputPanel, BoxLayout.Y_AXIS));

        JLabel insertInstructionsLabel = new JLabel("Please insert your input");
        JLabel itemLabel = new JLabel("Item");
        JTextArea itemInput = new JTextArea();
        JLabel spacingLabel = new JLabel("Spacing");
        String[] str = {"1 line", "2 lines", "3 lines", "4 lines",
                        "5 lines", "6 lines", "7 lines", "8 lines", "9 lines",
                        "10 lines", "11 lines", "12 lines", "13 lines", "14 lines",
                        "15 lines", "Full Page"};
        JComboBox<String> spacingInput = new JComboBox<String>(str);
        JLabel answerLabel = new JLabel("Answer to Item (optional)");
        JTextArea answerInput = new JTextArea();
        JButton insertInfo = new JButton("Insert");
        insertInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                userInput input = new userInput("Item",
                    itemInput.getText(),
                    spacingInput.getSelectedIndex(), 
                    answerInput.getText()
                    );
                // userInputs.add(input);
                // updateCurrentSelection();
            }
        });

        userInputPanel.setBounds(450, 10, 300, 300);
        
        userInputPanel.add(insertInstructionsLabel);
        userInputPanel.add(insertInfo);
        
        userInputPanel.add(itemLabel);
        userInputPanel.add(new JScrollPane(itemInput,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        
        userInputPanel.add(spacingLabel);
        userInputPanel.add(spacingInput);

        userInputPanel.add(answerLabel);
        userInputPanel.add(new JScrollPane(answerInput,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
    }
    public void updateCurrentSelection(){
        String[] str = new String[userInputs.size()];
        userInputs.forEach((u) -> {int x = 0; str[x]=u.getName(); x++;});
        String[] str2 = Arrays.stream(str).filter(s -> (s!=null && s.length()>0)).toArray(String[]::new);
        Arrays.stream(str2).filter(s -> (s!=null && s.length()>0)).forEach((s) -> currentSelection.addElement(s));
    }
}
