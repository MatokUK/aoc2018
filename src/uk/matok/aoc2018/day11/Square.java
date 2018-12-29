package uk.matok.aoc2018.day11;

public class Square implements Comparable<Square> {
    public int x;
    public int y;
    public int side;
    public Integer power;

    @Override
    public String toString() {
        return "[" + x + ", " + y + "] // " + side + " Power: " + power;
    }

    @Override
    public int compareTo(Square o) {
        return o.power.compareTo(power);
    }
}
