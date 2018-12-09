package uk.matok.aoc2018;


import java.text.SimpleDateFormat;
import java.util.*;

public class Day4Parser {
    private SortedMap<Date, String> data;

    public Day4Parser(ArrayList<String> lines) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        data = new TreeMap<>();

        for (String line: lines) {
            Date date;
            String datePart = line.substring(1, 17);
          //  String opPart = line.substring(18);
         //   System.out.println(datePart + ".." + opPart);
            try {
                date = simpleDateFormat.parse(datePart);
            //    System.out.println("date : "+simpleDateFormat.format(date));
                data.put(date, line);
            } catch (Exception ex) {

            }

        }
    }

    public SortedMap<Date, String> getSortedData()
    {
        return data;
    }
}
