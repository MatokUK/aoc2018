package uk.matok.aoc2018.day11;

import java.util.PriorityQueue;

public class Day11 {
    public static void main(String... args) {
        Grid grid = new Grid(5177);
       // grid.printGrid();

        Square maxFuelPosition = grid.maxSquare(3);
        System.out.println("( I) Ta-daaa: " + maxFuelPosition);

        PriorityQueue<Square> maxSquares = new PriorityQueue<>();

        // Start: 3 || Finish: 100
        for (int s = 3; s <= 100; s++) {
            Square max = grid.maxSquare(s);
            maxSquares.add(max);
        }

        System.out.println("(II) Ta-daaa: " + maxSquares.peek());
    }
}
