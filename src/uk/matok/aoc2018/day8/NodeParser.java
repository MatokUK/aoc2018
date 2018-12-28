package uk.matok.aoc2018.day8;

import java.util.*;

public class NodeParser {
    private String input;
    private ArrayList<Integer> digits;

    NodeParser(String input) {
        this.input = input;
        this.digits = new ArrayList<>();


        String parts[] = input.split(" ");

        for (int i = 0; i < parts.length; i++) {
            //System.out.println(parts[i]);
            digits.add(Integer.valueOf(parts[i]));
        }
       // System.out.println(digits);
    }

    public Integer getLeaf()  {
        System.out.println(digits);
        int zeroPosition = getZeroIndex();
        if (zeroPosition == -1) {
            return null;
        }
        System.out.println("Zero pos is " + zeroPosition);
        int sum = getMetadaFromProsition(zeroPosition);
        erasaFromPosition(zeroPosition);

        System.out.println(sum);
       // System.out.println(zeroPosition);


        return new Integer(sum);
    }

    private int getZeroIndex() {
        ListIterator<Integer> it = digits.listIterator();

        while (it.hasNext()) {
            Integer value = it.next();
            if (value == 0) {
                return it.nextIndex() - 1;
            }

        }

        return -1;
    }

    private int getMetadaFromProsition(int position) {
        int howMuch = digits.get(position + 1);
        int sum = 0;
        System.out.println(howMuch);

        for (int i = 0; i < howMuch; i++) {
            sum += digits.get(position + i + 2);
        }
        System.out.println("sum: " + sum);
        return sum;
    }

    private void erasaFromPosition(int position)  {
        int howMuch = digits.get(position + 1);
        digits.subList(position, position + howMuch + 2).clear();
        if (position > 0) {
            digits.set(position - 2, digits.get(position - 2) - 1);
        }
    }

    public ArrayList<Node> parse() {
        ArrayList<Node> nodes = new ArrayList<>();
        System.out.println("parsong");
        System.out.println(input);

        int childs = children(input);
        metadata(input);
        System.out.println("CH: " + childs);


        return nodes;
    }

    private int children(String input) {
        int spacePosition = input.indexOf(' ');

        return Integer.valueOf(input.substring(0, spacePosition));
    }

    private int metadata(String input) {
        int spacePosition = input.indexOf(' ');
        int nextSpacePosition = input.indexOf(' ', spacePosition + 1);
        int metadataCount = Integer.valueOf(input.substring(spacePosition + 1, nextSpacePosition));
        System.out.println(spacePosition);
        System.out.println(nextSpacePosition);
       // System.out.println("X :" + metadataCount);
        System.out.println(metadataValues(input, metadataCount));

        return 40;
    }

    private ArrayList<Integer> metadataValues(String input, int count) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int pos = input.lastIndexOf(' ');
            int data = Integer.valueOf(input.substring(pos + 1));
            input = input.substring(0, pos);
            result.add(data);
        }

        return result;
    }
}
