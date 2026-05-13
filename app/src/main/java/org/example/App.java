package org.example;

import com.opencsv.CSVReader;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class App {

    public static void main(String[] args) {
        int target;
        int amtcrt = 0;
        int totalqs = 0; // total questions
        int totalLines = 0;
        String data = null;
        ArrayList<String[]> quesions = new ArrayList<>();
        Scanner stdin = new Scanner(System.in);
        Random rand = new Random();
        File f = new File("spa.csv");
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
      while (true) {
        boolean wrong = false;
        String[] q = quesions.get(rand.nextInt(quesions.size()));
        while(true){
        System.out.printf("q[0] = %s q[1] = %s\t", q[0], q[1]);
        System.out.printf("%s?:", q[0]);
        String answer = stdin.nextLine();
        if(answer.equals(q[1])){
            if(wrong == true){
            totalqs++;
            }else {
                amtcrt++;
                totalqs++;
            }
             System.out.printf("Correct, in total you have gotten %d/%d correct.\n", amtcrt, totalqs);
                break;
        }else{
            System.out.printf("Wrong, Try again\n");
            wrong = true;

        }
    }
}
        // nextint takes highest number including zero
       // target = rand.nextInt(totalLines) + 1;
    

        //count total lines  
        // try(Scanner scan = new Scanner(f);) {
        //     totalLines = 0;
        //     while (scan.hasNextLine()){
        //         totalLines++;
        //         scan.nextLine();
        //     }
        // } catch (FileNotFoundException e) {
        //    e.printStackTrace();
        // } 
        // // nextint takes highest number including zero
        // target = rand.nextInt(totalLines) + 1;
    
       
    }
    
}
