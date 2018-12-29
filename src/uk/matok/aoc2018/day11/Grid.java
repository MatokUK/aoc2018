package uk.matok.aoc2018.day11;

public class Grid {
    private int[][] fuel = new int[301][301];
    private int serialNumber;

    Grid(int serialNumber) {
        this.serialNumber = serialNumber;
        calculateCells();
    }

    private void calculateCells() {
        for (int x = 1; x <= 300; x++) {
            for (int y = 1; y <= 300; y++) {
                fuel[x][y] = calculateCell(x, y);
            }
        }
    }

    private int calculateCell(int x, int y) {
        int rackId = x + 10;
        int powerLevel = rackId * y + serialNumber;
        powerLevel = powerLevel * rackId;

        powerLevel = powerLevel / 100;
        powerLevel = powerLevel % 10;

        return powerLevel - 5;
    }

    public Square maxSquare(int squareSide) {
        int maxPower = Integer.MIN_VALUE;
        int currentPower;
        Square topLeftCorner = new Square();

        for (int x = 1; x <= 300 - squareSide; x++) {
            for (int y = 1; y <= 300 - squareSide; y++) {
                currentPower = calculateSquare(x, y, squareSide);
                if (currentPower > maxPower) {
                    maxPower = currentPower;
                    topLeftCorner.x = x;
                    topLeftCorner.y = y;
                    topLeftCorner.side = squareSide;
                    topLeftCorner.power = currentPower;
                }
            }
        }

        return topLeftCorner;
    }

    private int calculateSquare(int xStart, int yStart, int side) {
        int power = 0;
        for (int x = xStart; x < xStart + side; x++) {
            for (int y = yStart; y < yStart + side; y++) {
                power += fuel[x][y];
            }
        }

      return power;
    }

    public void printGrid() {
        for (int y = 1; y <= 300; y++) {
            System.out.format("%3d: ", y);
            for (int x = 1; x <= 300; x++) {
                System.out.format("%4d", fuel[x][y]);
            }
            System.out.println("");
        }
    }
}
