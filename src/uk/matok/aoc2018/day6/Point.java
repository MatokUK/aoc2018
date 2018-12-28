package uk.matok.aoc2018.day6;


public class Point {
    private int x;
    private int y;

    public Point(int x, int y)  {
        this.x = x;
        this.y = y;
    }

    public Point(String coordinates)  {
        String[] parts = coordinates.split(", ");
        this.x = Integer.valueOf(parts[0]);
        this.y = Integer.valueOf(parts[1]);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int manhattanDistance(Point point) {
        return Math.abs(this.x - point.getX()) + Math.abs(this.y - point.getY());
    }


    public String toString()
    {
        return "[" + x + "," + y + "]";
    }

    @Override
    public int hashCode() {
        return x * 100000 + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (hashCode() != other.hashCode())
            return false;
        return true;
    }
}
