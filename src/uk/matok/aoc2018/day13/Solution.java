package uk.matok.aoc2018.day13;

import uk.matok.aoc2018.Reader;


public class Solution {
    public static void main(String... args) throws Exception {
        Reader reader = new Reader("day13.txt");
      //  Reader reader = new Reader("test13_II.txt");
        Track track;


        track = new Track(reader.readS());
        track.printGrid();

        int i = 0;
        do {
            track.advance();
            if (i % 10 == 0) {
          //      track.printGrid();
            }

            i++;
        } while (!track.hasCollision());

        track.printGrid();
        System.out.println("( I) Ta-daaa: " + track.getCollision());


        // part II
       /* track = new Track(reader.readS());

        do {
            track.advance();
            int cleared = track.clearCollisions();
            if (cleared > 0) {
                System.out.println(cleared + " carts removed!");
            }
        } while (track.cartCount() > 1);

        System.out.println("(II) Ta-daaa: " + track.peekCart());
        track.printGrid();*/

    }
}
