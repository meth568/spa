package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Engine {

/**
 * This takes a filename and loads it into an arraylist composed of an index (0.. 1.. 2..) which each index contains an array. The array's index 0 is the first part of the comma in a csv like file and index 1 is a string after the comma in an csv like file.
 * @param filename path to file. It might be absolute or realative, idk
 * @return an arraylist with a question and an answer array at each arraylist index.
 */

public ArrayList<String[]> cache_q(String filename){
    System.out.println(String.format("Using file: %s",filename));
    int totalLines = 0;    
    ArrayList<String[]> questions = new ArrayList<>();
    File f = new File(filename);
        // init and storing in mem
        try(Scanner scan = new Scanner(f);) {
            while (scan.hasNextLine()){
                
                questions.add(scan.nextLine().split(","));
                // todo add newline checking
                totalLines++;
            }
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } 
        return questions;
}



/**
 * This takes in an array list built from a line by line parse of a csv style file and returns a random array containing 1 question and 1 answer
 ** @param quesions arraylist
 * @return q[0] is the 1st before the comma (question), q[1] is the string aftert the comma (answer)
 */
public String[] get_q(ArrayList<String[]> quesions) {
    Random rand = new Random();
    String[] q = quesions.get(rand.nextInt(quesions.size()));
    return q;
}

public Boolean ck_q(String question, String answer){
    if(question.contains(answer) == true){
        return true;
    }else{
        return false;
    }
}
}
