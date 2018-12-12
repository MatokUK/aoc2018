package uk.matok.aoc2018.day10;

public class Point {
    private int x;
    private int y;
    private Velocity velocity;


    public Point(int x, int y)  {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, Velocity velocity)  {
        this.x = x;
        this.y = y;
        this.velocity = velocity;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        this.velocity.elapse(1);
        Point tmp = this.velocity.getPoint();
        this.x += tmp.x;
        this.y += tmp.y;
    }

    public String toString()
    {
        String velocity;
        if (null != this.velocity) {
            velocity = " : " + this.velocity.getPoint().toString();
        } else {
            velocity = " ";
        }
        return "[" + x + "," + y + "]" + velocity;
    }
}
