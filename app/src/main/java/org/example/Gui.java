package org.example;

import java.awt.Color;

import javax.swing.*;
public class Gui implements Frontend{
    private JFrame frame;
    private JLabel label;
    private JTextField textField;
    String answer;
    JButton submit;
    @Override
    public void start() {
        frame = new JFrame("spa");
      //  frame.setLayout(new CardLayout());
        frame.setSize(400,200);
        label = new JLabel();
        label.setVisible(true);
        frame.add(label);
        textField = new JTextField();
       textField.setColumns(20);
        frame.add(textField);
        submit = new JButton("Submit");
        frame.add(submit);
        submit.setVisible(true);
        frame.setVisible(true);
        frame.setLayout(new java.awt.FlowLayout());
    }

    public void displayq(String question){
        
        label.setText(String.format("%s", question));
        
        
    }
    public String reada(){
        submit.addActionListener(e -> {
            answer = textField.getText();
            
        });       
        return answer;
        
        
    }
}
