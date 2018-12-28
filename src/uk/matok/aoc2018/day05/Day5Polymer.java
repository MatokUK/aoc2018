package uk.matok.aoc2018.day05;

public class Day5Polymer {
    private StringBuilder polymer;

    public Day5Polymer(String polymer)
    {
        this.polymer = new StringBuilder(polymer);
    }


    public String runReaction()
    {
        int initialLength;

        do {
            initialLength = polymer.length();
            for (int i = polymer.length() - 2; i >= 0; i--) {
                if (partialReaction(i, i + 1)) {
                    break;
                }
            }
        } while (polymer.length() != initialLength);
        return this.polymer.toString();
    }

    private Boolean partialReaction(int posA, int posB)
    {
        Character chA = polymer.charAt(posA);
        Character chB = polymer.charAt(posB);
        if (chA != chB && Character.toLowerCase(chA) == Character.toLowerCase(chB)) {
            polymer.deleteCharAt(posB);
            polymer.deleteCharAt(posA);
            return true;
        }

        return false;
    }
}
