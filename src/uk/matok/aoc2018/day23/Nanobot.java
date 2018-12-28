package uk.matok.aoc2018.day23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nanobot {
    private int x;
    private int y;
    private int z;

    private int radius;

    Nanobot(String line) {
        String pattern = "pos=<(-?\\d+),(-?\\d+),(-?\\d+)>,\\s+r=(\\d+)";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(line);
        if (m.find()) {
            x = Integer.valueOf(m.group(1));
            y = Integer.valueOf(m.group(2));
            z = Integer.valueOf(m.group(3));
            radius = Integer.valueOf(m.group(4));
        }
    }

    public int getRadius() {
        return radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public Boolean isInRange(Nanobot bot) {
        int distance = Math.abs(x - bot.getX()) + Math.abs(y - bot.getY()) + Math.abs(z - bot.getZ());
        //System.out.println("D: " + distance + " / R: "+bot.getRadius());

        return distance <= radius;
    }

    @Override
    public String toString() {
        return "<" + x + ", " + y + ", " + z + "> R: " +radius;
    }
}
