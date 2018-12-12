package uk.matok.aoc2018.day7;

import java.util.*;

public class Parser {
    private Set<Character> steps = new HashSet<>();
    private Set<Character> rightPoints = new HashSet<>();
    private Set<Character> leftPoints = new HashSet<>();
    private HashMap<Character, HashSet<Character>> xx = new HashMap<>();
    private HashMap<Character, HashSet<Character>> rev = new HashMap<>();


    public void parse(String line) {
        Character first = line.charAt(5);
        Character second = line.charAt(36);
       // System.out.println(first);
       // System.out.println(second);
        xx.putIfAbsent(first, new HashSet<>());
        HashSet<Character> yy = xx.get(first);
        yy.add(second);

        leftPoints.add(first);
        rightPoints.add(second);


      /*  HashMap<Character, HashSet<Character>> cl = (HashMap) xx.clone();

        for(Map.Entry<Character, HashSet<Character>> entry : cl.entrySet()) {
            Character key = entry.getKey();
            HashSet<Character> value = (HashSet) entry.getValue().clone();
            System.out.println( key + " = " + value);
        //    System.out.println(value);

            for (Character c: value) {
                System.out.println("...." + c);
                if (xx.containsKey(c)) {
                    System.out.println(" insert under key " + key + " values " + xx.get(c));
                    xx.get(key).addAll(xx.get(c));
                }
            }
        }*/

         //   if (xx.)

            /*HashSet<Character> tmp = new HashSet<>();
            tmp.add('X');
            value.addAll(tmp);
*/
            // do what you have to do here
            // In your case, another loop.

        System.out.println("--------------");

       /* rev.putIfAbsent(second, new HashSet<>());
        HashSet<Character> rev2 = rev.get(second);
        rev2.add(first);
*/
       // System.out.println("1 " + xx);



        steps.add(first);
        steps.add(second);
    }

    public void getStartingPoint()
    {
        leftPoints.removeAll(rightPoints);

        System.out.println(leftPoints);
    }

    private HashSet<Character> getMp()
    {
        HashSet<Character> m = new HashSet<>();
        m.add('B');

        return m;
    }

    public Character[] getAllSteps() {
        System.out.println("XXXX" + xx);
        System.out.println("r " + rev);
        return steps.toArray(new Character[steps.size()]);
    }

    public Boolean compare(Character a, Character b) {
        System.out.println("Comparing " + a + " vs "+ b);
        if (xx.containsKey(a)) {
            //return true;


            HashSet<Character> yy = xx.get(a);
            HashSet<Character> yy2 = xx.get(b);

            if (yy.contains(b)) {
                System.out.println("HAS");
                return false;
            } else if (yy2.contains(a)) {
                System.out.println("HAS II");
                return true;
            }
        }

        System.out.println("normal");
        return a > b;

       /* Random rand = new Random();
        return rand.nextInt() % 2 == 0;*/
    }
}
