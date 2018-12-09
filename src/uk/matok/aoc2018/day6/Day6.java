package uk.matok.aoc2018.day6;


import uk.matok.aoc2018.Day5Polymer;
import uk.matok.aoc2018.Reader;

import java.util.ArrayList;

public class Day6 {
    public static void main(String... args) throws Exception {
        Reader reader = new Reader("day6.txt");

        ArrayList<String> lines = reader.readS();

        for (String line: lines) {
            System.out.println(line);
        }
       // Day5Polymer polymer = new Day5Polymer(input);
       // String reacted = polymer.runReaction();


        //System.out.println("( I) Ta-Daa: " + reacted.length() + " [" + reacted + "]");


    }
}
