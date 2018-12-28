package uk.matok.aoc2018.day05;


import uk.matok.aoc2018.Reader;

public class Day5 {
    public static void main(String... args) {
        Reader reader = new Reader("day5.txt");

        String input = reader.readLine();

        Day5Polymer polymer = new Day5Polymer(input);
        String reacted = polymer.runReaction();


        System.out.println("( I) Ta-Daa: " + reacted.length() + " [" + reacted + "]");

        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            String f = input.replaceAll(alphabet + "", "").replaceAll(Character.toLowerCase(alphabet) + "", "");
            Day5Polymer polymerII = new Day5Polymer(f);
            String tmpPolymer = polymerII.runReaction();
            System.out.println(alphabet + ": " + tmpPolymer.length() + " (" + tmpPolymer + ")");
        }
    }
}
