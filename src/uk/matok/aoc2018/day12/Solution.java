package uk.matok.aoc2018.day12;


import uk.matok.aoc2018.Reader;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public static void main(String... args) throws Exception {
        Reader reader = new Reader("day12.txt");
        RuleParser parser = new RuleParser();
        HashSet<Rule> ruleSet;
        Plant plant;

        ArrayList<String> lines = reader.readS();
        // #...##.#...#..#.#####.##.#..###.#.#.###....#...#...####.#....##..##..#..#..#..#.#..##.####.#.#.###

        ruleSet = parser.parse(lines);
        plant = new Plant("#...##.#...#..#.#####.##.#..###.#.#.###....#...#...####.#....##..##..#..#..#..#.#..##.####.#.#.###", ruleSet);
       // plant = new Plant("#..#.#..##......###...###", ruleSet);


        int plants = 0;
        int sum = 0;
        String state = "";
        for (int i = 0; i < 20; i++) {
            plant.generate();
            state = plant.getState();
            int occurance =  state.length() - state.replace("#", "").length();
            System.out.println(state + "  " + occurance);
            plants += occurance;
        }

       // int pos = -3;
        int pos = plant.getIndex();
        System.out.println(plant.getIndex());

        System.out.println(state);
        for (Character c: state.toCharArray()) {
            if (c == '#') {
                sum += pos;
                System.out.println(pos);
            }

            pos ++;
        }

        System.out.println("Ta-Daa: " + sum);
       // System.out.println(ruleSet.size());
       // System.out.println(ruleSet);
        //.#....##....#####...#######....#.#..##.
    }
}
