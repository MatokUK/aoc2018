package uk.matok.aoc2018.day12;

public class Rule {
    private String pattern;
    private Boolean plant;

    Rule(String pattern, Boolean plant) {
        this.pattern = pattern;
        this.plant = plant;
    }

    String getPattern()  {
        return pattern;
    }

    Boolean getPlant()  {
        return plant;
    }
}
