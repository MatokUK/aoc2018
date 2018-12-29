package uk.matok.aoc2018.day13;

import java.util.ArrayList;

public class Track {
    private char[][] grid;
    private ArrayList<Cart> carts;
    private Cart collision;

    public Track(ArrayList<String> lines) {
        grid = new char[lines.size()][];

        int idx = 0;
        for (String line: lines) {
            grid[idx] = new char[line.length()];
            grid[idx] = line.toCharArray();
            idx++;
        }

        initCarts();
    }

    private void initCarts() {
        carts = new ArrayList<>();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                Cart cart = getCartFromGrid(x, y);
                if (null != cart) {
                    carts.add(cart);
                }
            }
        }
    }

    private Cart getCartFromGrid(int x, int y) {
        char cell = grid[y][x];
        if (cell == '>' || cell == '<' || cell == '^' || cell == 'v') {
            return new Cart(x, y, cell);
        }

        return null;
    }

    public void advance() {
        for (Cart cart: carts) {
            char cell = grid[cart.peekY()][cart.peekX()];
            cart.advance(cell);
        }
    }

    public boolean hasCollision() {
        for (Cart referenceCart: carts) {
            int sameHashCodes = 0;
            for (Cart cart: carts) {
                if (referenceCart.hashCode() == cart.hashCode()) {
                    sameHashCodes++;
                }
            }

            if (sameHashCodes > 1) {
                collision = referenceCart;
                return true;
            }
        }

        return false;
    }

    public int clearCollisions() {
        int cleared = 0;
        int originalCount;

        while (hasCollision()) {
            originalCount = carts.size();
            System.out.println(carts);
            carts.removeIf(c -> c.hashCode() == collision.hashCode());
            System.out.println(carts);
            cleared += originalCount - carts.size();
        }

        return cleared;
    }

    public int cartCount() {
        return carts.size();
    }

    public Cart getCollision() {
        return collision;
    }

    public Cart peekCart() {
        return carts.get(0);
    }

    public void printGrid() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (null != carts && carts.contains(new Cart(x, y, '>'))) {
                    System.out.print("\u001B[31mC\u001B[0m");
                } else {
                    System.out.print(grid[x][y]);
                }
            }
            System.out.println("");
        }
    }
}
