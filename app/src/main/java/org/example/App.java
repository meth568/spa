package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import org.example.Engine;
// Engine e = new Engine();
public class App {

    public static void main(String[] args) {
        // JFrame frame = new JFrame();
        // frame.setSize(400,200);
        // JLabel label = new JLabel();
        // frame.add(label);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setVisible(true);



        int target;
        int amtcrt = 0;
        int totalqs = 0; // total questions
        int totalLines = 0;
        String data = null;
        ArrayList<String[]> quesions = new ArrayList<>();
        Scanner stdin = new Scanner(System.in);
        Random rand = new Random();
        File f = new File("/home/ryan/code/java/spa/spa.csv");
        // init and storing in mem
        try(Scanner scan = new Scanner(f);) {
            while (scan.hasNextLine()){
                
                quesions.add(scan.nextLine().split(","));
                // todo add newline checking
                totalLines++;
            }
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } 


        //check q's
        Engine engine = new Engine();
        boolean gui = true;
        Frontend frontend;
        if(gui == true){
            frontend = new Gui();
        }else{
            frontend = new Cli();
        } 


        
        //pick q (b) => display q (f) => read input (f) => check q (b)  => report (f)
        frontend.start();
      while (true) {  //loop
        String[] q = engine.ld_q(quesions);
        frontend.displayq(q[0]);
        String answer = frontend.reada();
        if(q[1].contains(answer)){
            System.out.print("oc");
        }
        while(true){

        }
        
      //  frontend.reada();


   }
   
}
//       while (true) {  //loop
//         boolean wrong = false;
//         String[] q = quesions.get(rand.nextInt(quesions.size()));
//         while(true){
//         System.out.printf("q[0] = %s q[1] = %s\t", q[0], q[1]);
//         System.out.printf("%s?:", q[0]);
//         String answer = stdin.nextLine();
//         if(answer.equals(q[1])){
//             if(wrong == true){
//             totalqs++;
//             }else {
//                 amtcrt++;
//                 totalqs++;
//             }
//              System.out.printf("Correct, in total you have gotten %d/%d correct.\n", amtcrt, totalqs);
//                 break;
//         }else{
//             System.out.printf("Wrong, Try again\n");
//             wrong = true;

//         }
//     }
// }

       
    }
    
//}
