package uk.matok.aoc2018;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4GuardAnalyzer {
    private SortedMap<Date, String> data;
    HashMap<Integer, Long> guardIdToSleepTime;

    public Day4GuardAnalyzer(SortedMap<Date, String> data) {
        this.data = data;
        this.guardIdToSleepTime = new HashMap<>();
    }

    public void analyze() {

        Integer guardId;
        Day4Guard guard = new Day4Guard(0);

        for (Map.Entry<Date, String> entry : data.entrySet()) {
            String op = entry.getValue().substring(19,24);

            if (op.equals("Guard")) {
                guardId = parseGuardId(entry.getValue());
              //  System.out.println(guard);
                if (guard.getSleepMinutes() > 0) {
                    writeDown(guard);
                }
                guard = new Day4Guard(guardId);
            } else if (op.equals("falls")) {
                guard.asleep(entry.getKey());
            } else if (op.equals("wakes")) {
                guard.wakeUp(entry.getKey());
            }
        }

        if (guard.getSleepMinutes() > 0) {
            writeDown(guard);
        }

        guardId = 0;
        Long maxSleepTime = -1L;
        for (Map.Entry<Integer, Long> entry : guardIdToSleepTime.entrySet()) {
            if (maxSleepTime < entry.getValue()) {
                maxSleepTime = entry.getValue();
                guardId = entry.getKey();
            }
        }

        System.out.println("#" + guardId + " ---> " + maxSleepTime);

        countMostRepeatingMinute(guardId);
    }

    private Integer countMostRepeatingMinute(Integer id)
    {
        Day4Guard guard = new Day4Guard(0);
        SortedMap<Integer, Integer> freq = new TreeMap<>();

        for (Map.Entry<Date, String> entry : data.entrySet()) {
            String op = entry.getValue().substring(19,24);

            if (op.equals("Guard")) {
                Integer guardId = parseGuardId(entry.getValue());
               // System.out.println(guard);

                guard = new Day4Guard(guardId);
            } else if (op.equals("falls")) {
                guard.asleep(entry.getKey());
            } else if (op.equals("wakes")) {
                guard.wakeUp(entry.getKey());
            }

            if (guard.getSleepMinutes() > 0 && id.equals(guard.getId())) {
                //System.out.println("Fuct");
                //System.out.println(guard.getId() + ": " + guard.getFrom() + "-" + guard.getTo());
                for (Integer minute = guard.getFrom(); minute <= guard.getTo(); minute++) {
                    freq.putIfAbsent(minute, 0);
                    freq.put(minute, freq.get(minute) + 1);
                }
            }
        }

        Integer mostRepetingMinute = -1;
        Integer repeatingMax = 0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > repeatingMax) {
                repeatingMax = entry.getValue();
                mostRepetingMinute = entry.getKey();
            }
        }

        System.out.println("MINUTE: " + mostRepetingMinute);
        return 555;
    }


    private void writeDown(Day4Guard guard)
    {
        Integer guardId = guard.getId();
        if (guardIdToSleepTime.containsKey(guardId)) {
            guardIdToSleepTime.put(guardId, guardIdToSleepTime.get(guardId) + guard.getSleepMinutes());
        } else {
            guardIdToSleepTime.put(guardId, guard.getSleepMinutes());
        }
    }

    private Integer parseGuardId(String entry)
    {
        String pattern = "#(\\d+)\\s";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(entry);
        if (m.find()) {
            return Integer.valueOf(m.group(1));
        }

        return -1;
    }
}
