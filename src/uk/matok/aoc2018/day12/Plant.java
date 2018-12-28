package uk.matok.aoc2018.day12;

import java.util.HashSet;

public class Plant {
    private String state;
    private HashSet<String> generatePlant;
    private HashSet<String> killPlant;
    private int c = 1;
    private int leftIndex;

    Plant(String initialState, HashSet<Rule> ruleSet) {
        generatePlant = new HashSet<>();
        killPlant = new HashSet<>();
        this.state = "..." + initialState + "...";

        for(Rule rule: ruleSet) {
            if (rule.getPlant()) {
                generatePlant.add(rule.getPattern());
            } else {
                killPlant.add(rule.getPattern());
            }
        }
        this.leftIndex = -3;
    }

    String getState() {
        return state;
    }

    int getIndex() {
        return leftIndex;
    }

    void generate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 5; i < state.length(); i++) {
            String slice = state.substring(i - 5, i);
            if (generatePlant.contains(slice)) {
             //   System.out.println("AAAA");
                sb.append('#');
            } else if (killPlant.contains(slice)) {
                sb.append('.');
               // System.out.println("BBBBB");
            } else {
                System.out.println("CCCCCCCCCCCCCCCCC");
            }
        }
        this.leftIndex -= 1;

        this.state = "..." + sb.toString() + "....";
    }
}
