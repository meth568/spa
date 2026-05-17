package org.example;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
public class Gui implements Frontend{
    private JFrame frame;
    private JLabel label;
    private JLabel score;
    private JOptionPane warning;
    private JTextField textField;

    String answer;
    JButton submit;
    Engine engine = new Engine();
ArrayList<String[]> all_qs = new ArrayList<>();
String[] rand_q;

    
    private void setup(){
        String window_title = "spa";
        int input_cols = 20;
                
        // setup window
        frame = new JFrame(window_title);
        frame.setSize(400,200);
        frame.setLayout(new java.awt.FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        label = new JLabel();
        label.setVisible(true);
        frame.add(label);

        score = new JLabel();
        score.setVisible(true);
        frame.add(score);

        warning = new JOptionPane("a");
        warning.setVisible(true);
        //frame.add(warning);

        textField = new JTextField();
        textField.setColumns(input_cols);
        textField.setVisible(true);
        frame.add(textField);

        submit = new JButton("submit");
        submit.setVisible(true);
        frame.add(submit);
        //  load csv into mem
        all_qs= engine.cache_q("/home/ryan/code/java/spa/spa.csv");
    }
     private void displayq(String question){
      
       rand_q = engine.get_q(all_qs); //rand_q[0] == question rand_q[1] == answer
       label.setText(String.format("question is:%s", rand_q[0]));
        
        
    }
    @Override
   public void start() {
        setup();
        displayq(answer);
        reada(rand_q[1]);
    }

   
    public String reada(String answer){
        submit.addActionListener(e -> {
            String result = textField.getText();
            Boolean res = engine.ck_q(result,answer);
            if(res == true){
                label.setText("true");
               try {
  Thread.sleep(200);
} catch (InterruptedException e1) {
  Thread.currentThread().interrupt();
}
displayq(answer);
            }if (res == false){
                label.setText("wrong");
                
            }
        });       

        return answer;
        
        
    }




    //  public void start() {
    //     frame = new JFrame("spa");
    //   //  frame.setLayout(new CardLayout());
    //     frame.setSize(400,200);
    //     label = new JLabel();
    //     label.setVisible(true);
    //     frame.add(label);
    //     textField = new JTextField();
    //    textField.setColumns(20);
    //     frame.add(textField);
    //     submit = new JButton("Submit");
    //     frame.add(submit);
    //     submit.setVisible(true);
    //     frame.setVisible(true);
    //     frame.setLayout(new java.awt.FlowLayout());
    // }

    // public void displayq(String question){
        
    //     label.setText(String.format("%s", question));
        
        
    // }
    // public String reada(String question){
    //     submit.addActionListener(e -> {
    //         answer = textField.getText();
    //         Boolean res = engine.ck_q(question,answer);
    //         if(res == true){
    //             label.setText("true");
    //             // here 
    //         }
    //     });       

    //     return answer;
        
        
    // }
}
