package uk.matok.aoc2018.day1;

import uk.matok.aoc2018.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public static void main(String... args) throws IOException {
        Solution day1 = new Solution();
        Integer result;

        result = day1.partI("day1.txt");
        System.out.println("( I) Ta-Daa: " + result);
        result = day1.partII("day1.txt");
        System.out.println("(II) Ta-Daa: " + result);
    }

    public Integer partI(String fileName) throws IOException {
        uk.matok.aoc2018.Reader reader = new uk.matok.aoc2018.Reader(fileName);

        ArrayList<Integer> values = reader.read();
        Integer sum = 0;
        for (Integer value:values) {
            sum += value;
        }

        return sum;
    }

    public Integer partII(String fileName) throws IOException {
        uk.matok.aoc2018.Reader reader = new Reader(fileName);

        ArrayList<Integer> values = reader.read();
        HashSet<Integer> frequency = new HashSet<>();
        Integer sum = 0;
        frequency.add(0);
        for (int i = 0; i < 1000; i++) {
            for (Integer value : values) {
                sum += value;
                if (frequency.contains(sum)) {
                    return sum;
                }

                frequency.add(sum);
            }
        }

        throw new RuntimeException("Cannot find solution");
    }
}
