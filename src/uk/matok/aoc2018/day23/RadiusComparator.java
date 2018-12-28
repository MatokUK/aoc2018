package uk.matok.aoc2018.day23;

import java.util.Comparator;

public class RadiusComparator implements Comparator<Nanobot> {

    @Override
    public int compare(Nanobot botA, Nanobot botB) {
        return Integer.compare(botA.getRadius(), botB.getRadius());
    }
}
