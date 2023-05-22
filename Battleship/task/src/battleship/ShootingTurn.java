package battleship;

import java.util.Scanner;

public class ShootingTurn {
    private Field field;
    private int counter = 17;

    SeaField seaField = new SeaField(10, 10);

    public int getCounter() {
        return counter;
    }

    public ShootingTurn(Field field) {
        this.field = field;
    }

    public void shoot() {

        if (counter == 0) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            System.exit(0);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Take a shot!");
        String input = scanner.nextLine().toUpperCase();
        String[] coordinates = input.split("(?<=\\D)(?=\\d)");

        int row = coordinates[0].charAt(0) - field.getStartRow() + 1;
        int col = Integer.parseInt(coordinates[1]);


        if (coordinates.length < 2) {
            System.out.println("Invalid input! Please provide both row and column coordinates. Try again:");
            shoot();
        } else if (row < 1 || row > 10 || col < 1 || col > 10) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            shoot();
        } else if (seaField.getSeaGrid()[row - 1][col - 1].equals("X ") || seaField.getSeaGrid()[row - 1][col - 1].equals("M ")) {
            System.out.println("Error! Already shot that! Try again:");
            shoot();
        } else if (field.getGrid()[row][col].equals("~ ")) {
            seaField.getSeaGrid()[row - 1][col - 1] = "M";
            System.out.println("You missed!");
            seaField.drawSea();
            shoot();
        } else if (field.getGrid()[row][col].equals("O ")) {
            seaField.getSeaGrid()[row - 1][col - 1] = "X";
            System.out.println("You hit a ship!");
            counter--;
            seaField.drawSea();
            //System.out.println(counter);
            shoot();
        }
    }
}