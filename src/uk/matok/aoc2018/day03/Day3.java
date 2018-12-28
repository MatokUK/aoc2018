package uk.matok.aoc2018.day03;

import uk.matok.aoc2018.Reader;

import java.util.ArrayList;

public class Day3 {
    public static void main(String... args) throws Exception {
        Day3 day3 = new Day3();

        Fabric fabric = day3.partI("day3.txt");
        System.out.println("( I) Ta-Daa: " + fabric.overlap());
        System.out.println("(II) Ta-Daa: " + fabric.oneNotOverlapping());
    }

    private ArrayList<Claim> readInput(String fileName) throws Exception {
        Reader reader = new Reader(fileName);
        ArrayList<Claim> claims = new ArrayList<>();

        ArrayList<String> lines = reader.readS();

        for (String line : lines) {
            claims.add(Claim.fromString(line));
        }

        return claims;
    }

    public Fabric partI(String fileName) throws  Exception {
        Fabric fabric = new Fabric(2000, 2000);
        ArrayList<Claim> claims = readInput(fileName);

        for (Claim claim: claims) {
            fabric.cut(claim);
        }

        return fabric;
    }
}
