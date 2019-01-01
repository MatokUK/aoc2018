package uk.matok.aoc2018.day7;


import uk.matok.aoc2018.Reader;

import java.util.ArrayList;

public class Solution {
    public static void main(String... args) throws Exception {
        Reader reader = new Reader("day7.txt");

        ArrayList<String> lines = reader.readS();
        Parser parser2 = new Parser(lines);

        StepHeap heap = parser2.getHeap();

        Character nextStep;
        StringBuilder sb = new StringBuilder();
        while (null != (nextStep = heap.pop())) {
            sb.append(nextStep);
        }

        System.out.println("( I) Ta-daaa: " + sb.toString() + " length: " + sb.toString().length());
    }
}
