package uk.matok.aoc2018.day23;


import uk.matok.aoc2018.Reader;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String... args) throws Exception {
        Reader reader = new Reader("day23.txt");
        ArrayList<String> coordinates = reader.readS();
        ArrayList<Nanobot> bots = new ArrayList<>();
        int nanobotsInRange = 0;

        for (String coordinate: coordinates) {
            bots.add(new Nanobot(coordinate));
        }

        Nanobot strongestBot = strongestRadius(bots);
        System.out.println("Strongest: " + strongestBot);

        for (Nanobot bot: bots) {
            if (strongestBot.isInRange(bot)) {
                nanobotsInRange++;
            }
        }

        System.out.println("Part I: " + nanobotsInRange);
    }

    private static Nanobot strongestRadius(ArrayList<Nanobot> bots) {
        return Collections.max(bots, new RadiusComparator());
    }
}
