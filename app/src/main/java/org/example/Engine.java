package org.example;

import java.util.ArrayList;
import java.util.Random;
public class Engine {
    //
public String[] ld_q(ArrayList<String[]> quesions) {
    Random rand = new Random();
    String[] q = quesions.get(rand.nextInt(quesions.size()));
    return q;
}

}
