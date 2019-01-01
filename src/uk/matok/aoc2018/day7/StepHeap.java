package uk.matok.aoc2018.day7;

import java.util.ArrayList;
import java.util.TreeSet;

public class StepHeap {
    ArrayList<StepPair> steps;

    public StepHeap(ArrayList<StepPair> steps) {
        this.steps = steps;
    }

    public Character pop() {
        TreeSet<Character> options = nextPossibilities();

        if (options.isEmpty()) {
            return null;
        }

        Character part = options.iterator().next();

        removeStep(part);

        return part;
    }

    private TreeSet<Character> nextPossibilities() {
        TreeSet<Character> options = new TreeSet<>();
        for (StepPair pair: steps) {
            options.add(pair.getLeft());
        }

        for (StepPair pair: steps) {
            options.remove(pair.getRight());
        }

        return options;
    }

    private void removeStep(Character part) {
        handleLastStep();

        steps.removeIf((StepPair emp) -> emp.getLeft().equals(part));
    }

    private void handleLastStep() {
        if (steps.size() == 1) {
            StepPair finalStep = new StepPair(steps.iterator().next().getRight(), '.');
            steps.add(finalStep);
        }
    }
}
