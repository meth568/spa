package org.example;

import javax.swing.*;
public class Gui implements Frontend{
    private JFrame frame;
    private JLabel label;
    private JTextField textField;
    JButton submit;
    @Override
    public void start() {
        frame = new JFrame();
        frame.setSize(400,200);
        label = new JLabel();
        frame.add(label);
        textField = new JTextField();
        frame.add(textField);
        submit = new JButton("Submit");
        frame.add(submit);
        
        frame.setVisible(true);
    }

    public void displayq(String question){
        
        label.setText(String.format("%s", question));
        
    }
    public void reada(){
        submit.addActionListener(e -> {
            String answer = textField.getText();
            System.out.println(answer);
        });       
        
        
    }
}
