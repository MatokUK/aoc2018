package uk.matok.aoc2018.day13;

public class Vector {
    private int x;
    private int y;
    private char vector;

    public Vector(int x, int y, char vector) {
        this.x = x;
        this.y = y;
        this.vector = vector;
    }

    public char getDirection() {
        return vector;
    }

    public int peekX() {
        if (vector == '<') {
            return x-1;
        }

        if (vector == '>') {
            return x+1;
        }

        return x;
    }

    public int peekY() {
        if (vector == 'v') {
            return y+1;
        }

        if (vector == '^') {
            return y-1;
        }

        return y;
    }


    public void advance() {
        switch (vector) {
            case '>':
                x++;
                break;
            case '<':
                x--;
                break;
            case '^':
                y--;
                break;
            case 'v':
                y++;
                break;
        }
    }

    public void left() {
        switch (vector) {
            case '>':
                vector = '^';
                break;
            case '<':
                vector = 'v';
                break;
            case '^':
                vector = '<';
                break;
            case 'v':
                vector = '>';
                break;
        }
    }

    public void right() {
        switch (vector) {
            case '>':
                vector = 'v';
                break;
            case '<':
                vector = '^';
                break;
            case '^':
                vector = '>';
                break;
            case 'v':
                vector = '<';
                break;
        }
    }

    @Override
    public String toString() {
        return "[" + x + ", "+ y + "] " + vector;
    }

    @Override
    public int hashCode() {
        return x*10000 + y;
    }
}
