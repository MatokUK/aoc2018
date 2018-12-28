package uk.matok.aoc2018.day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RuleParser {

    HashSet<Rule> parse(ArrayList<String> lines) {
        HashSet<Rule> ruleSet = new HashSet<>();
        String pattern = "(.{5})\\s+=> (#|\\.)";

        for (String line: lines) {
            System.out.println(line);


            Pattern r = Pattern.compile(pattern);

            Matcher m = r.matcher(line);
            if (m.find()) {
                Rule rule = new Rule(m.group(1), m.group(2).equals("#"));
                ruleSet.add(rule);
            }
        }

        return ruleSet;
    }
}
