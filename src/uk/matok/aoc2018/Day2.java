package uk.matok.aoc2018;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day2 {
    public static void main(String... args) throws IOException {
        Day2 day2 = new Day2();
        Integer result;

        result = day2.partI("day2.txt");
        System.out.println("( I) Ta-Daa: " + result);
        String result2 = day2.partII("day2.txt");
        System.out.println("(II) Ta-Daa:\n" + result2);
    }

    public Integer partI(String fileName) throws IOException {
        Reader reader = new Reader(fileName);

        ArrayList<String> ids = reader.readS();
        int two = 0;
        int three = 0;
        for (String id:ids) {
            if (repeating(id, 2)) {
                two++;
            }
            if (repeating(id, 3)) {
                three++;
            }
        }

        return two * three;
    }

    public String partII(String fileName) throws IOException {
        Reader reader = new Reader(fileName);

        ArrayList<String> ids = reader.readS();
        for (String id1:ids) {
            for (String id2:ids) {
                if (!id1.equals(id2) && hasOneDifference(id1, id2)) {
                    return id1 + "\n" + id2;
                }
            }

        }
        throw new RuntimeException("Cannot find solution");
    }

    private Boolean hasOneDifference(String source, String comparedTo) {
        int diffs = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != comparedTo.charAt(i)) {
                diffs ++;
            }
        }

        return diffs == 1;
    }

    private Map<Character, Integer> countFrequency(String label){
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char ch : label.toCharArray()) {
            frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
        }

        return frequencies;
    }

    private Boolean repeating(String label, int howMuch) {
        Map<Character, Integer> frequencies = countFrequency(label);

        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == howMuch) {
                return true;
            }
        }

        return false;
    }
}
