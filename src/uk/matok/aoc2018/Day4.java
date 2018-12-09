package uk.matok.aoc2018;


import java.util.ArrayList;
import java.util.Date;
import java.util.SortedMap;

public class Day4 {
    public static void main(String... args) throws Exception {
        Reader reader = new Reader("day4.txt");

        ArrayList<String> lines = reader.readS();
        Day4Parser parser = new Day4Parser(lines);

        SortedMap<Date, String> data = parser.getSortedData();
        Day4GuardAnalyzer guardAnalyzer = new Day4GuardAnalyzer(data);

        guardAnalyzer.analyze();
    }
}
