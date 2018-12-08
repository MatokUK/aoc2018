package uk.matok.aoc2018;

import java.io.IOException;
import java.util.ArrayList;

public class Day3 {
    public static void main(String... args) throws Exception {
        Day3 day3 = new Day3();

        Day3Fabric fabric = day3.partI("day3.txt");
        System.out.println("( I) Ta-Daa: " + fabric.overlap());
        System.out.println("(II) Ta-Daa: " + fabric.oneNotOverlapping());
    }

    private ArrayList<Day3Claim> readInput(String fileName) throws Exception {
        Reader reader = new Reader(fileName);
        ArrayList<Day3Claim> claims = new ArrayList<>();

        ArrayList<String> lines = reader.readS();

        for (String line : lines) {
            claims.add(Day3Claim.fromString(line));
        }

        return claims;
    }

    public Day3Fabric partI(String fileName) throws  Exception {
        Day3Fabric fabric = new Day3Fabric(2000, 2000);
        ArrayList<Day3Claim> claims = readInput(fileName);

        for (Day3Claim claim: claims) {
            fabric.cut(claim);
        }

        return fabric;
    }

}
