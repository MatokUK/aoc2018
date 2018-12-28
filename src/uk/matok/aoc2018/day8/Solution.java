package uk.matok.aoc2018.day8;


import uk.matok.aoc2018.Reader;

import java.util.ArrayList;


public class Solution {
    public static void main(String... args) throws Exception {
        Reader reader = new Reader("day8.txt");
        String line = reader.readLine();
        NodeParser nodeParser = new NodeParser(line);

        ArrayList<Node> nodes;
        Node leaf;
        Integer leafSum;
        Integer checkSum = 0;

        do {
            leafSum = nodeParser.getLeaf();
            if (null != leafSum) {
                checkSum += leafSum;
            }
        } while (leafSum != null);

        System.out.println("Part I: " + checkSum);
    }
}
