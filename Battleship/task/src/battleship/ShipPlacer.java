package battleship;

import java.util.Scanner;



public class ShipPlacer {
    static String[] shipTypes;
    private Field field;
    private String currentShip;

    public String getCurrentShip() {
        return currentShip;
    }

    public ShipPlacer(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public void shipPlace (){
        Scanner scanner = new Scanner(System.in);
        shipTypes = new String[]{"Aircraft Carrier", "Battleship", "Submarine", "Cruiser", "Destroyer"};
        int[] shipSizes = {5, 4, 3, 3, 2};
        for (int i = 0; i < shipTypes.length; i++) {
            boolean validPlacement = false;
            while (!validPlacement) {
                System.out.print("Enter the coordinates of the " + shipTypes[i] + " (" + shipSizes[i] + " cells): ");
                currentShip = shipTypes[i];
                validPlacement = placeShip(shipSizes[i]);
                if (!validPlacement) {
                    // Skip printing the field when there is an input mistake
                    continue;
                }
                field.printField();
            }
            // Request the coordinates of the next ship
            if (i < shipTypes.length - 1) {
                System.out.print("Enter the coordinates of the " + shipTypes[i+1] + " (" + shipSizes[i+1] + " cells): ");
            }
        }
        System.out.println("The game starts!");
    }

    public boolean placeShip(int size) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        String[] coordinates = input.split(" ");

        if (coordinates.length != 2) {
            System.out.println("Invalid input! Please provide both start and end coordinates. Please try again.");
            return false;
        }

        String start = coordinates[0];
        String end = coordinates[1];

        // Convert start and end coordinates to row and column indices
        int startRow = start.charAt(0) - field.getStartRow() + 1;
        int startColumn = Integer.parseInt(start.substring(1));
        int endRow = end.charAt(0) - field.getStartRow() + 1;
        int endColumn = Integer.parseInt(end.substring(1));


        // Swap coordinates if start is greater than end
        if (startRow > endRow || startColumn > endColumn) {
            int tempRow = startRow;
            int tempColumn = startColumn;
            startRow = endRow;
            startColumn = endColumn;
            endRow = tempRow;
            endColumn = tempColumn;
        }

        // Check if the ship is placed horizontally or vertically
        if (startRow != endRow && startColumn != endColumn) {
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }

        // Check if the ship size is valid
        if (Math.abs(startRow - endRow) + 1 != size && Math.abs(startColumn - endColumn) + 1 != size) {
            System.out.println("Error! Wrong length of the " + currentShip + "! Try again:");  // Nog verbeteren
            return false;
        }

        // Check if ships are too close
        for (int i = startRow - 1; i <= endRow + 1; i++) {
            for (int j = startColumn - 1; j <= endColumn + 1; j++) {
                if (i >= 1 && i <= field.getRows() && j >= 1 && j <= field.getColumns() && !field.getGrid()[i][j].equals("~ ")) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    return false;
                }
            }
        }

        // Place the ship on the field
        if (startRow == endRow) {
            int increment = startColumn <= endColumn ? 1 : -1;
            for (int j = startColumn; j != endColumn + increment; j += increment) {
                field.getGrid()[startRow][j] = "O ";
            }
        } else {
            int increment = startRow <= endRow ? 1 : -1;
            for (int i = startRow; i != endRow + increment; i += increment) {
                field.getGrid()[i][startColumn] = "O ";
            }
        }

        return true;
    }
}