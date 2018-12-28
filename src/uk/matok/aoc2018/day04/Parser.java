package uk.matok.aoc2018.day04;


import java.text.SimpleDateFormat;
import java.util.*;

public class Parser {
    private SortedMap<Date, String> data;

    public Parser(ArrayList<String> lines) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        data = new TreeMap<>();

        for (String line: lines) {
            Date date;
            String datePart = line.substring(1, 17);
            try {
                date = simpleDateFormat.parse(datePart);
                data.put(date, line);
            } catch (Exception exception) {

            }

        }
    }

    public SortedMap<Date, String> getSortedData()
    {
        return data;
    }
}
