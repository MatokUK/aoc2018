package uk.matok.aoc2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reader
{
    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Integer> read() throws IOException {
        ArrayList<Integer> values = new ArrayList<Integer>();

                //uses the class loader search mechanism:
        InputStream input = this.getClass().getResourceAsStream(this.fileName);
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
//        ){
            String line = null;
            while ((line = reader.readLine()) != null) {
                values.add(new Integer(line));
            }
    //    }

        return values;
    }

    public ArrayList<String> readS() throws IOException {
        ArrayList<String> values = new ArrayList<>();

        InputStream input = this.getClass().getResourceAsStream(this.fileName);
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        String line = null;
        while ((line = reader.readLine()) != null) {
            values.add(line);
        }

        return values;
    }

    public String readLine() {
        try {
            InputStream input = this.getClass().getResourceAsStream(this.fileName);
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            return reader.readLine();
        } catch (IOException exception) {
            System.out.println("Oh Nooo...");
        }

        return "";
    }
}
