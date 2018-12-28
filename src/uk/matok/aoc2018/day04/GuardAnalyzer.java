package uk.matok.aoc2018.day04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuardAnalyzer {
    private SortedMap<Date, String> data;
    private HashMap<Integer, Long> guardIdToSleepTime;
    private HashMap<Integer, HashMap<Integer, Integer>> sleepFrequency;

    public GuardAnalyzer(SortedMap<Date, String> data) {
        this.data = data;
        this.guardIdToSleepTime = new HashMap<>();
        this.sleepFrequency = new HashMap<>();

        for (Integer i = 0; i < 60; i++) {
            sleepFrequency.put(i, new HashMap<>());
        }
    }

    public void analyze() {
        Integer guardId;
        Guard guard = new Guard(0);

        for (Map.Entry<Date, String> entry : data.entrySet()) {
            String op = entry.getValue().substring(19,24);

            if (op.equals("Guard")) {
                guardId = parseGuardId(entry.getValue());
                if (guard.getSleepMinutes() > 0) {
                    writeDown(guard);
                }
                guard = new Guard(guardId);
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

    public HashMap<Integer, GuardSleeping> sleepMinuteFrequency() {
        Integer guardId;
        Guard guard = new Guard(0);

        for (Map.Entry<Date, String> entry : data.entrySet()) {
            String op = entry.getValue().substring(19,24);

            if (op.equals("Guard")) {
                guardId = parseGuardId(entry.getValue());
                //  System.out.println(guard);
                if (guard.getSleepMinutes() > 0) {
                    writeDown(guard);
                }
                guard = new Guard(guardId);
            } else if (op.equals("falls")) {
                guard.asleep(entry.getKey());
            } else if (op.equals("wakes")) {
                guard.wakeUp(entry.getKey());
                countFrequency(guard.getId(), guard.getFrom(), guard.getTo());
            }
        }

        return maxSleepingFrequency();
    }

    private void countFrequency(Integer guardId, Integer from , Integer to) {
        for (Integer minute = from; minute <= to; minute++) {
            sleepFrequency.get(minute).putIfAbsent(guardId, 0);
            sleepFrequency.get(minute).replace(guardId, 1 + sleepFrequency.get(minute).get(guardId));
        }
    }

    private HashMap<Integer, GuardSleeping> maxSleepingFrequency() {
        HashMap<Integer, GuardSleeping> result = new HashMap<>();

        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry: sleepFrequency.entrySet()) {
            Integer max = -1;
            Map.Entry<Integer, Integer> maxE = null;
            for (Map.Entry<Integer, Integer> guardSleepFrequency: entry.getValue().entrySet()) {
                if (guardSleepFrequency.getValue() > max) {
                    max = guardSleepFrequency.getValue();
                    maxE = guardSleepFrequency;
                }
            }
            if (maxE != null) {
                result.put(entry.getKey(), new GuardSleeping(maxE.getKey(), maxE.getValue()));
            }
        }
        return result;
    }

    private Integer countMostRepeatingMinute(Integer id)
    {
        Guard guard = new Guard(0);
        SortedMap<Integer, Integer> freq = new TreeMap<>();

        for (Map.Entry<Date, String> entry : data.entrySet()) {
            String op = entry.getValue().substring(19,24);

            if (op.equals("Guard")) {
                Integer guardId = parseGuardId(entry.getValue());

                guard = new Guard(guardId);
            } else if (op.equals("falls")) {
                guard.asleep(entry.getKey());
            } else if (op.equals("wakes")) {
                guard.wakeUp(entry.getKey());
            }

            if (guard.getSleepMinutes() > 0 && id.equals(guard.getId())) {
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


    private void writeDown(Guard guard)
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
