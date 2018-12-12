package uk.matok.aoc2018.day10;

public class Velocity {
    private int x;
    private int y;

    public Velocity(int x, int y)  {
        this.x = x;
        this.y = y;
    }

    public void elapse(int time)  {
        x *= time;
        y *= time;
    }

    public Point getPoint()  {
        return new Point(this.x, this.y);
    }

}
