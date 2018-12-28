package uk.matok.aoc2018.day04;

public class GuardSleeping {
    private Integer guardId;
    private Integer howMuch;

    GuardSleeping(Integer guardId, Integer howMuch) {
        this.guardId = guardId;
        this.howMuch = howMuch;
    }

    public Integer getGuardId() {
        return guardId;
    }

    public Integer getHowMuch() {
        return howMuch;
    }
}
