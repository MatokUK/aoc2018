package uk.matok.aoc2018.day6;

import java.util.HashSet;

public class Area {
    private Point middle;
    private Boolean finite;
    private int area;
    private HashSet<Point> points;

    Area() {
        this.finite = true;
        this.area = 0;
        this.points = new HashSet<>();
    }

    Area(Point middle) {
        this.middle = middle;
        this.finite = true;
        this.area = 1;
        this.points = new HashSet<>();
    }

    public int getArea() {
        return area;
    }

    public Boolean isFinite() {
        return this.finite;
    }

    public Point middle() {
        return this.middle;
    }

    public Boolean hasPoint(Point point) {
        return points.contains(point);
    }

    public void addPoint(Point point, int topBorder, int bottomBorder, int leftBorder, int rightBorder) {
        this.area++;
        this.points.add(point);

        if (point.getX() == leftBorder || point.getX() == rightBorder) {
            this.finite = false;
        }

        if (point.getY() == topBorder || point.getY() == bottomBorder) {
            this.finite = false;
        }
    }
}
