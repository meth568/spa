package com.github.based187.carded;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.formdev.flatlaf.FlatDarkLaf;
public class Gui implements Frontend{
    private JFrame frame;
    private JLabel label;
    private JLabel score;
    JButton submit;
    private JButton debugButton;
    private JOptionPane warning;
    private JTextField textField;
    private JFileChooser filepick;
    

    String answer;
    
    Engine engine = new Engine();
    ArrayList<String[]> all_qs = new ArrayList<>(); 
    String[] rand_q_a;
    Boolean are_points_earnable = true; 
    Boolean firstime = true;
    //state
    int totalqs = 0;
    int amtcrt = 0;
    
    private void setup(){
        String window_title = "Carded";
        int input_cols = 20;
        //theming
        FlatDarkLaf.setup();
        // setup window
        frame = new JFrame(window_title);
        frame.setSize(400,200);
        frame.setLayout(new java.awt.FlowLayout(FlowLayout.LEFT, 20, 10 ));
       
        ImageIcon icon = new ImageIcon(getClass().getResource("/carded.png"));
        frame.setIconImage(icon.getImage());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.setResizable(false);
        frame.setVisible(true);
        


        // label for questions
        label = new JLabel();
        label.setVisible(true);
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        frame.add(label);

        score = new JLabel();
        score.setVisible(true);
        frame.add(score);

        warning = new JOptionPane();

        textField = new JTextField();
        textField.setColumns(input_cols);
        textField.setVisible(true);
        frame.add(textField);

        submit = new JButton("submit");
        submit.setVisible(true);
        frame.add(submit);
        //bind enter to submit for fastness
        frame.getRootPane().setDefaultButton(submit);

        //debug/ print varibles 
        debugButton = new JButton("debug");
        debugButton.addActionListener(null);
        debugButton.addActionListener(e -> {
            System.out.print(String.format("totalq : %d amtcrt %d firsttime %b \n", totalqs,amtcrt,firstime));
        });
        if (Info.debug == true) {
            frame.add(debugButton);
        }


        // loading file and picking
        //
        if(Info.debug == false){
            
        
        filepick = new JFileChooser();
        filepick.showOpenDialog(null);
        all_qs= engine.cache_q(filepick.getSelectedFile().getAbsolutePath());
        
       
        }else{
           System.err.print("Using debug file");
        all_qs= engine.cache_q("/home/ryan/code/java/spa/spa.csv");

        }
        //submit button
        // NOTE: listener stays on forever so the question just needs to be regen for new q's
        // NOTE: code in the action listener runs every time a button a pressed.
            reada();
            
            
             submit.addActionListener(e -> {
 
                // if(res){
                //     if(firstime){
                //         //correct + firsttime
                //          totalqs++;
                //          amtcrt++;
                //     }else{
                //         //correct + anytime
                //         totalqs++;
                //     }
                //     //new question
                //     firstime = true;
                //     reada();
                // }else{
                //     if(firstime){
                //         //wrong + firsttime
                //     totalqs++;
                //     }else{
                //         //wrong + anytime
                //         firstime = false;
                //     }
                    
                //     
                // }
                
                // textField.setText("");
                String result = textField.getText();
                Boolean res = engine.ck_q(result, rand_q_a[1]);
                if(res == true){

               if(are_points_earnable == true){
                totalqs++;
                amtcrt++;
                
               }else{
                are_points_earnable = true;
                totalqs++;
               }
               textField.setText("");
               reada();
                
            }else{
                // If wrong
                
                are_points_earnable = false;
                JOptionPane.showMessageDialog(frame,"Wrong");
                textField.setText("");

            }

             });
            // if(res == false && are_points_earnable == true){
            //     // if it's false on the first time
            //     are_points_earnable = false;
            //     totalqs++;
            //     JOptionPane.showMessageDialog(frame,"Wrong");
            // }if(res == false && are_points_earnable == false){
            //     //if its false after many time
            // }
            // if(res == true && are_points_earnable == false){
            //     // if its true after a 2nd try
            //     reada();
            // }
         // if(are_points_earnable == true && res == true){
            //     //if it's correct after 1 try
            //     amtcrt++;
            //     totalqs++;
            //     reada();
            // }
            // textField.setText("");





        
    }

    @Override
   public void start() {
        setup();
       
        reada();
    }

    /**
     * Read_a takes a random question and answer and displays it
     */
    public void reada(){
        are_points_earnable = true;
        rand_q_a = engine.get_q(all_qs); //rand_q[0] == question rand_q[1] == answer
        //label.setText(String.format("question is:%s", rand_q_a[0]));
        label.setText(String.format("%s", rand_q_a[0]));
      // DEBUGING  System.out.printf("amt crt %d total q %d \n", amtcrt, totalqs);
        score.setText(String.format("%d/%d Correct", amtcrt, totalqs));
    }
   
    // Boolean alr_answ = false;
    // public String reada(String answer){ 
   
    //     submit.addActionListener(e -> {
    //         String result = textField.getText();
    //         Boolean res = engine.ck_q(result,answer);
            
    //         if(res == true){
    //             warning.setText("true");
    //             label.setText("");
    //             if(alr_answ == false){
    //             amtcrt++;
    //             totalqs++;
    //             alr_answ = false;
    //             }
    //             textField.setText("");
    //             //displayq(answer);
    //             reada(answer);
    //         }if (res == false){
    //             warning.setText("Try Again");
    //             if(alr_answ == false){
    //             totalqs++;
    //             alr_answ = true;
    //             }else{
                
    //             }
                
    //         }
    //         score.setText(String.format("%d/%d Correct",amtcrt, totalqs));
    //     });       

    //     return answer;
        
        
    // }




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
