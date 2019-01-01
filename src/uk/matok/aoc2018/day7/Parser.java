package uk.matok.aoc2018.day7;

import java.util.ArrayList;

public class Parser {
    private ArrayList<StepPair> steps = new ArrayList<>();

    public Parser(ArrayList<String> lines) {
        for (String line: lines) {
            steps.add(new StepPair(line));
        }
    }

    public StepHeap getHeap() {
        return new StepHeap(steps);
    }
}
