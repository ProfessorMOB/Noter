package org.bloomfield.noter.utilities;

import javax.swing.*;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App2 {
    
    static ListModel<String> currentSelectionListModel = new DefaultListModel<String>();
    static DefaultListModel<String> currentSelection;
    static JList<String> currentSelectionList;
    static int v = 0;
    JPanel totalGUI = new JPanel();
    JFrame frame = new JFrame();
    List<userInput> userInputs = new ArrayList<userInput>();
    static JPanel currentSelectionPanel;
    static userInput changingUserInputValues;
    String docName; 


    App2(){
        totalGUI.add(createUserInputGui());
        // totalGUI.add(createCurrentSelectionPanel());
        totalGUI.add(createUserOptionGui());
        totalGUI.add(createPDFViewingPanel());
        totalGUI.setLayout(null);
        totalGUI.setOpaque(true);
        
        frame.setContentPane(totalGUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setBounds(800,800,800,800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.repaint();
        frame.validate();
    }
    
    public JPanel createUserInputGui(){
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
                    (itemInput.getText()+1),
                    spacingInput.getSelectedIndex(), 
                    answerInput.getText()
                    );
                userInputs.add(input);
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
        
        return userInputPanel;
    }
    public JPanel createUserOptionGui(){
        JPanel userOptionPanel = new JPanel();
        userOptionPanel.setLayout(new GridLayout(2, 1));
        JButton jb = new JButton("Save");
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JDialog askUserForDetails = createFinalDoc();
                askUserForDetails.setVisible(true);
                PDFUtils pdfu = new PDFUtils();

                pdfu.createPDF(new PDDocument());
                pdfu.setItems(userInputs);
                pdfu.finishDoc(docName);
            }
        });
        userOptionPanel.add(jb);
        userOptionPanel.setLocation(450, 315);
        userOptionPanel.setSize(300,130);

        return userOptionPanel;
    }

    public JScrollPane createPDFViewingPanel(){
        JPanel pdfViewingPanel = new JPanel();
        pdfViewingPanel.setLayout(new BoxLayout(pdfViewingPanel, BoxLayout.Y_AXIS));
        pdfViewingPanel.setLayout(null);
        pdfViewingPanel.setLocation(10, 10);
        pdfViewingPanel.setPreferredSize(new Dimension(430,740));

        JScrollPane jsp = new JScrollPane(pdfViewingPanel, 
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setSize(430,740);
        return jsp;
    }
    
    public JPanel createCurrentSelectionPanel(){
        currentSelectionPanel = new JPanel();
        currentSelectionPanel.setLayout(new BoxLayout(currentSelectionPanel, BoxLayout.Y_AXIS));
        String[] str = new String[userInputs.size()];
        
        currentSelection = new DefaultListModel<String>();
        userInputs.forEach((u) -> {int x = 0; str[x]=u.getName(); x++;});
        Arrays.stream(str).filter(s -> (s!=null && s.length()>0)).forEach((s) -> currentSelection.addElement(s));
        currentSelectionList = new JList<String>(currentSelection);
        

        JLabel currentSelectionLabel = new JLabel("Current Selection");
        currentSelectionPanel.add(currentSelectionLabel);

        currentSelectionPanel.add(new JScrollPane(currentSelectionList, 
                                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        
        currentSelectionPanel.setLocation(450, 450);
        currentSelectionPanel.setSize(300,300);
        return currentSelectionPanel;
    }
    public void updateCurrentSelection(){
        String[] str = new String[userInputs.size()];
        userInputs.forEach((u) -> {int x = 0; str[x]=u.getName(); x++;});
        String[] str2 = Arrays.stream(str).filter(s -> (s!=null && s.length()>0)).toArray(String[]::new);
        Arrays.stream(str2).filter(s -> (s!=null && s.length()>0)).forEach((s) -> currentSelection.addElement(s));
    }
    public void updateCurrentUserInput(int index){
        currentSelectionList.getSelectedValue();
        changingUserInputValues= userInputs.get(index);
    }
    public void updateUserInputValue(){

    }
    public JDialog createFinalDoc(){
        JDialog jp = new JDialog();
        JPanel jd = new JPanel();
        jp.setLayout(new BoxLayout(jd, BoxLayout.PAGE_AXIS));
        
        jp.setBounds(300,200,300,200);
        
        JLabel askForName = new JLabel("Name");
        JTextArea name = new JTextArea();
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                docName=name.getName();
                jp.dispose();
            }
        });
        jd.add(askForName);
        jd.add(name);
        jd.add(submit);
        jp.setLocationRelativeTo(null);
        jp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jp.setContentPane(jd);
        return jp;
    }
}