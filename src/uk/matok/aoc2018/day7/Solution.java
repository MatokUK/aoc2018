package uk.matok.aoc2018.day7;


import uk.matok.aoc2018.Reader;

import java.util.ArrayList;
import java.util.Set;

public class Solution {
    public static void main(String... args) throws Exception {
        Reader reader = new Reader("day7.txt");
        Parser parser = new Parser();

        ArrayList<String> lines = reader.readS();

        for (String line: lines) {
           // System.out.println(line);
            parser.parse(line);

        }

        System.out.println("*******************");
        parser.getStartingPoint();

        Character[] xx = parser.getAllSteps();

        for (int i = 0; i < xx.length; i++) {
            System.out.println(xx[i]);
        }

        Character[] sorted = sort(xx, parser);
        System.out.println("--------------");

        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i]);
        }

       // Day5Polymer polymer = new Day5Polymer(input);
       // String reacted = polymer.runReaction();


        //System.out.println("( I) Ta-Daa: " + reacted.length() + " [" + reacted + "]");


    }

    private static Character[] sort(Character[] steps, Parser p) {
       // static void bubbleSort(int[] arr) {
            int len = steps.length;
            Character temp = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 1; j < (len-i); j++){
                    //if (steps[j-1] > steps[j]){
                    if (p.compare(steps[j-1], steps[j])) {
                        //swap elements
                        temp = steps[j-1];
                        steps[j-1] = steps[j];
                        steps[j] = temp;
                    }

                }
            }

            return steps;
        }
}
