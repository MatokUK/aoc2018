package uk.matok.aoc2018.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Grid {
    private int left;
    private int right;
    private int top;
    private int bottom;
    private char counter;

    private HashSet<Point> points;
    private TreeMap<Character, Area> areas;

    public Grid() {
        this.points = new HashSet<>();
        this.areas = new TreeMap<>();
        this.counter = 'A';
    }

    public void putPoint(Point point)  {
        points.add(point);
        calculateBorders();

        Area area = new Area(point);
        areas.put(counter++, area);
    }


    private void calculateBorders() {
        left = points.iterator().next().getX();
        right = 0;
        top = points.iterator().next().getY();
        bottom =  0;
        for (Point point: points) {
            if (point.getX() < left) {
                left = point.getX();
            }

            if (point.getX() > right) {
                right = point.getX();
            }

            if (point.getY() > bottom) {
                bottom = point.getY();
            }

            if (point.getY() < top) {
                top = point.getY();
            }
        }
    }

    public String toString() {
        String result = "";
        int i = 65;

        for (int y = top; y <= bottom; y++) {
            for (int x = left; x <= right; x++) {
                Point tempPoint = new Point(x, y);
                if (points.contains(tempPoint)) {
                    result += new String(Character.toChars(i));

                    i++;
                } else {
                    result += ".";
                }
            }
            result += "\n";
        }

        return result;
    }

    public String toString(Area region) {
        String result = "";
        int i = 65;

        for (int y = top; y <= bottom; y++) {
            for (int x = left; x <= right; x++) {
                Point tempPoint = new Point(x, y);
                if (region.hasPoint(tempPoint)) {
                    result += '#';
                } else if (points.contains(tempPoint)) {
                    result += new String(Character.toChars(i));

                    i++;
                } else {
                    result += ".";
                }
            }
            result += "\n";
        }

        return result;
    }

    public ArrayList<Integer> calculateAreas()  {
        ArrayList<Integer> areas = new ArrayList<>();

        for (int y = top; y <= bottom; y++) {
            for (int x = left; x <= right; x++) {
                Point tempPoint = new Point(x, y);
                if (!points.contains(tempPoint)) {
                    calc(tempPoint);
                }
            }
        }

        for (Map.Entry<Character, Area> entry: this.areas.entrySet()) {
            if (entry.getValue().isFinite()) {
                areas.add(entry.getValue().getArea());
            }
        }

        return areas;
    }

    private void calc(Point gridPoint)
    {
        int minDistance = Integer.MAX_VALUE;
        int distance;
        char areaLabel = '?';
        int areasWithMinimalDistance = 0;

        for (Map.Entry<Character, Area> entry: this.areas.entrySet()) {
            distance = entry.getValue().middle().manhattanDistance(gridPoint);
            if (distance < minDistance) {
                minDistance = distance;
                areasWithMinimalDistance = 1;
                areaLabel = entry.getKey();

            } else if (distance == minDistance) {
                areasWithMinimalDistance++;
            }
        }

        if (areasWithMinimalDistance == 1) {
            this.areas.get(areaLabel).addPoint(gridPoint, this.top, this.bottom, this.left, this.right);
        }
    }


    public Area getBiggestRegion(int maxDistance) {
        Area region = new Area();

        for (int y = top; y <= bottom; y++) {
            for (int x = left; x <= right; x++) {
                if (isWithinDistance(new Point(x, y), maxDistance)) {
                    region.addPoint(new Point(x, y), 0, 0, 0, 0);
                }
            }
        }

        return region;
    }

    private Boolean isWithinDistance(Point gridPoint, int maxDistance) {
        int totalDistance = 0;

        for (Point point: points) {
            totalDistance += gridPoint.manhattanDistance(point);
        }

        return totalDistance < maxDistance;
    }
}
