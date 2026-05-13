package org.example;
import com.opencsv.CSVReader;

import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class init {
public void init() {
        int target;
        int amtcrt = 0;
        int totalLines = 0;
        String data = null;
        Scanner stdin = new Scanner(System.in);
        Random rand = new Random();
        File f = new File("spa.csv");
        //count total lines  
        try(Scanner scan = new Scanner(f);) {
            totalLines = 0;
            while (scan.hasNextLine()){
                totalLines++;
                scan.nextLine();
            }
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } 
        // nextint takes highest number including zero
        target = rand.nextInt(totalLines) + 1;
    

}
    
}