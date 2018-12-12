package uk.matok.aoc2018.day10;


import uk.matok.aoc2018.Reader;

import java.util.ArrayList;

public class Solution {
    public static void main(String... args) throws Exception {
        Reader reader = new Reader("day10.txt");
        Parser parser = new Parser();

        ArrayList<String> lines = reader.readS();

        ArrayList<Point> points = parser.parse(lines);

        Grid grid = new Grid(points);

        int i = 0;
        do {
            grid.elapse();
            i++;
            if (grid.hasChars()) {
                System.out.println("Seconds: " + i);
                System.out.println(grid.toString());
            }

        } while (i < 50000);
    }
}
