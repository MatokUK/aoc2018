package uk.matok.aoc2018.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Grid {
    private ArrayList<Point> points;
    private int up;
    private int bottom;
    private int left;
    private int right;

    public Grid(ArrayList<Point> points) {
        this.points = points;
        resetBoundaries();
    }

    public void elapse()  {
        resetBoundaries();
        for (Point point: points) {
            point.move();
            if (point.getX() < left) {
                left = point.getX();
            }

            if (point.getX() > right) {
                right = point.getX();
            }

            if (point.getY() < up) {
                up = point.getY();
            }

            if (point.getY() > bottom) {
                bottom = point.getY();
            }
        }
    }

    public Boolean hasChars() {
        int verticalLines = 0;
        HashMap<Integer, Integer> f = new HashMap<>();

        for (Point point: points) {
            f.putIfAbsent(point.getX(), 0);
            f.put(point.getX(), 1 + f.get(point.getX()));
        }

        for (Map.Entry<Integer, Integer> entry : f.entrySet()) {
            if (entry.getValue() >= 20) {
                verticalLines++;
            }
        }

        return verticalLines > 5;
    }

    private void resetBoundaries() {
        up = Integer.MAX_VALUE;
        bottom = Integer.MIN_VALUE;
        left = Integer.MAX_VALUE;
        right = Integer.MIN_VALUE;
    }

    public String toString()  {
        StringBuilder sb = new StringBuilder();

        for (int c = up; c <= bottom; c++) {
            for (int r = left; r <= right; r++) {
                if (hasPoint(c, r)) {
                    sb.append("#");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        return "\n" + sb.toString();
    }

    private Boolean hasPoint(int y, int x) {
        for (Point point: points) {
            if (y == point.getY() && x == point.getX()) {
                return true;
            }
        }

        return false;
    }
}
