package uk.matok.aoc2018;

import java.util.HashSet;
import java.util.Set;

public class Day3Fabric {
    private Integer width;
    private Integer height;
    private int[][] grid;
    private Set<Integer> claims;

    public Day3Fabric(Integer width, Integer height)
    {
        this.width = width;
        this.height = height;
        this.grid = new int[height][width];
        this.claims = new HashSet<>();
    }

    public void cut(Day3Claim claim)
    {
        this.claims.add(claim.getId());
        for (int x = claim.getX(); x < claim.getXOffset(); x++) {
            for (int y = claim.getY(); y < claim.getYOffset(); y++) {
                if (grid[x][y] == 0) {
                    grid[x][y] = claim.getId();
                } else {
                    claims.remove(claim.getId());
                    claims.remove(grid[x][y]);
                    grid[x][y] = -1;
                }
            }
        }
    }

    public Integer overlap()
    {
        Integer overlaps = 0;
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (grid[x][y] == -1) {
                    overlaps++;
                }
            }
        }

        return overlaps;
    }

    public Integer oneNotOverlapping()
    {
        System.out.println(this.claims);
        Integer[] result = claims.toArray(new Integer[claims.size()]);
        return result[0];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                sb.append("|" + grid[x][y]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
