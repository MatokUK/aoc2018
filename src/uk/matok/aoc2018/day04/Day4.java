package uk.matok.aoc2018.day04;


import uk.matok.aoc2018.Reader;

import java.util.*;

public class Day4 {
    private static final int FREQUENCY_LESS_THAN = 15;

    public static void main(String... args) throws Exception {
        Reader reader = new Reader("day4.txt");

        ArrayList<String> lines = reader.readS();
        Parser parser = new Parser(lines);

        SortedMap<Date, String> data = parser.getSortedData();
        GuardAnalyzer guardAnalyzer = new GuardAnalyzer(data);

        System.out.println("Part I: ");
        guardAnalyzer.analyze();

        System.out.println("Part II: (multiply minute * guard ID)");
        HashMap<Integer, GuardSleeping> sleepTime = guardAnalyzer.sleepMinuteFrequency();
        for (Map.Entry<Integer, GuardSleeping> entry: sleepTime.entrySet()) {
            if (entry.getValue().getHowMuch() > FREQUENCY_LESS_THAN) {
                System.out.println(":" + entry.getKey() + " ... #" + entry.getValue().getGuardId() + " -> " + entry.getValue().getHowMuch());
            }
        }
    }
}
