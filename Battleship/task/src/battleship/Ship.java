/*package battleship;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private String name;
    private int size;
    private String[][] board;
    private boolean sunk;

    public Ship(String name, int size, String[][] board, boolean sunk) {
        this.name = name;
        this.size = size;
        this.board = board;
        this.sunk = sunk;
    }

    // Getters and setters...

    public static void main(String[] args) {
        List<Ship> ships = createShips();

        // Access and manipulate the ships in the list as needed
        for (Ship ship : ships) {
            System.out.println("Ship name: " + ship.getName());
            System.out.println("Ship size: " + ship.getSize());
            System.out.println("Ship sunk status: " + ship.isSunk());
            // Access and modify other ship properties as needed
        }
    }

    private static List<Ship> createShips() {
        List<Ship> ships = new ArrayList<>();

        // Create ship objects and add them to the list
        ships.add(new Ship("Aircraft Carrier", 5, new Point[5][5], false));
        ships.add(new Ship("Battleship", 4, new Point[4][4], false));
        ships.add(new Ship("Submarine", 3, new Point[3][3], false));
        ships.add(new Ship("Cruiser", 3, new Point[3][3], false));
        ships.add(new Ship("Destroyer", 2, new Point[2][2], false));

        return ships;
    }
}*/