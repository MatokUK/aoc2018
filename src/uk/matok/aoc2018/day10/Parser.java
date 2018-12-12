package uk.matok.aoc2018.day10;

import uk.matok.aoc2018.Day3Claim;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public ArrayList<Point> parse(ArrayList<String> lines)  {
        ArrayList<Point> result = new ArrayList<>();
        String pattern = "position=<\\s*(-?\\d+),\\s*(-?\\d+)>.+<\\s*(-?\\d+),\\s*(-?\\d+)";
        Pattern r = Pattern.compile(pattern);

        for (String line: lines) {
            Matcher m = r.matcher(line);
            if (m.find()) {
                Velocity velocity = new Velocity(Integer.valueOf(m.group(3)), Integer.valueOf(m.group(4)));
                Point point = new Point(Integer.valueOf(m.group(1)), Integer.valueOf(m.group(2)), velocity);
                result.add(point);
            }
        }

        return result;

    }
}
