package uk.matok.aoc2018.day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Claim {
    private Integer id;
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;

    public Claim(Integer id, Integer x, Integer y, Integer width, Integer height)
    {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getXOffset() {
        return x + height;
    }

    public Integer getYOffset() {
        return y + width;
    }

    public static Claim fromString(String line) throws Exception
    {
        String pattern = "#(\\d+)\\s@\\s(\\d+),(\\d+):\\s(\\d+)x(\\d+)";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(line);
        if (!m.find()) {
            throw new Exception("wot " +line );
        }
        return new Claim(Integer.valueOf(m.group(1)), Integer.valueOf(m.group(3)), Integer.valueOf(m.group(2)), Integer.valueOf(m.group(4)), Integer.valueOf(m.group(5)));
    }

    @Override
    public String toString() {
        return "[" + this.id + "] - [" + this.x + "," + this.y + "] " + this.width + "x" + this.height;
    }
}
