package uk.matok.aoc2018.day13;

public class Cart {
    private Vector vector;
    private int crossings;

    public Cart(int x, int y, char direction) {
        this.vector = new Vector(x, y, direction);
        this.crossings = 0;
    }

    public int peekX() {
        return vector.peekX();
    }

    public int peekY() {
        return vector.peekY();
    }

    public void advance(Character cell) {
        vector.advance();
        if (isCurve(cell)) {
            curveTurn(cell);
        } else if (isCrossing(cell)) {
            crossingTurn();
        }
    }

    private Boolean isCurve(Character cell) {
        return cell.equals('/') || cell.equals('\\');
    }

    private Boolean isCrossing(Character cell) {
        return cell.equals('+');
    }

    private void curveTurn(char curve) {
        if (vector.getDirection() == '>' || vector.getDirection() == '<') {
            if (curve == '\\') {
                vector.right();
            } else {
                vector.left();
            }
        } else {

            if (curve == '\\') {
                vector.left();
            } else {
                vector.right();
            }
        }
    }

    private void crossingTurn() {
        crossings++;
        if (crossings % 3 == 1) {
            vector.left();
        } else if (crossings % 3 == 0) {
            vector.right();
        }
    }

    @Override
    public String toString() {
        return vector.toString();
    }

    @Override
    public int hashCode() {
        return vector.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return hashCode() == obj.hashCode();
    }
}
