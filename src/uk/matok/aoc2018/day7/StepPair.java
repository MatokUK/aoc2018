package uk.matok.aoc2018.day7;

public class StepPair {
    private Character left;
    private Character right;

    public StepPair(String line) {
        String[] parts = line.split(" ");

        left = parts[1].charAt(0);
        right = parts[7].charAt(0);
    }

    public StepPair(Character A, Character B) {
        left = A;
        right = B;
    }

    public Character getLeft() {
        return left;
    }

    public Character getRight() {
        return right;
    }

    @Override
    public String toString() {
        return left + " -> " + right;
    }
}
