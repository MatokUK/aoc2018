package uk.matok.aoc2018.day6;


import uk.matok.aoc2018.Reader;

import java.util.ArrayList;
import java.util.Collections;

public class Day6 {
    public static void main(String... args) throws Exception {
        Reader reader = new Reader("day6.txt");
        ArrayList<String> lines = reader.readS();

        Grid grid = new Grid();
        for (String line: lines) {
            Point point = new Point(line);
            grid.putPoint(point);
        }


        System.out.println(grid.toString());
        ArrayList<Integer> areas = grid.calculateAreas();
        Collections.sort(areas);
        System.out.println("Part I:");
        System.out.println(areas);

        Area region = grid.getBiggestRegion(10000);
        System.out.println("Part II:");
        System.out.println(grid.toString(region));
        System.out.println(region.getArea());
    }
}
