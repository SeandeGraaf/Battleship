package battleship;

import java.util.Scanner;

import static battleship.Main.getTurnCount;



public class ShootingTurn {

    private FieldPlayer1 field;
    private FieldPlayer1 field2;
    private SeaField1 seaField;
    private SeaField1 seaField2;
    private int countX1 = 0;
    private int countX2 = 0;
    private int counter1 = 17;
    private int counter2 = 17;

    public ShootingTurn(FieldPlayer1 field, FieldPlayer1 field2, SeaField1 seaField, SeaField1 seaField2) {
        this.field = field;
        this.field2 = field2;
        this.seaField = seaField;
        this.seaField2 = seaField2;
    }

    public int getCounter1() {
        return counter1;
    }

    public int getCounter2() {
        return counter2;
    }

    public int getCountX1() {
        return countX1;
    }

    public int getCountX2() {
        return countX2;
    }

    public void shoot() {

        if (counter1 == 0) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            System.exit(0);
        }
        Scanner scanner = new Scanner(System.in);

        //System.out.print("Take a shot!");
        String input = scanner.nextLine().toUpperCase();
        String[] coordinates = input.split("(?<=\\D)(?=\\d)");

        int row = coordinates[0].charAt(0) - field.getStartRow() + 1;
        int col = Integer.parseInt(coordinates[1]);

        if (getTurnCount() % 2 != 0) {  // Checks for player 1
            if (coordinates.length < 2) {
                System.out.println("Invalid input! Please provide both row and column coordinates. Try again:");
                shoot();
            } else if (row < 1 || row > 10 || col < 1 || col > 10) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                shoot();
            } else if (seaField2.getSeaGrid()[row - 1][col - 1].equals("X")) {
                System.out.println("You hit a ship, again!");
                seaField2.drawSea();
            } else if (seaField2.getSeaGrid()[row - 1][col - 1].equals("M")) {
                System.out.println("You missed, again!");
                seaField2.drawSea();
            } else if (field2.getGrid()[row][col].equals("~ ")) {
                seaField2.getSeaGrid()[row - 1][col - 1] = "M";
                field2.getGrid()[row][col] = "M ";
                System.out.println("You missed!");
                seaField2.drawSea();
            } else if (field2.getGrid()[row][col].equals("O ")) {
                seaField2.getSeaGrid()[row - 1][col - 1] = "X";
                field2.getGrid()[row][col] = "X ";
                System.out.println("You hit a ship!");
                counter1--;
                countX1++;
                seaField2.drawSea();
            }
        } else {  // Player 2
            if (coordinates.length < 2) {
                System.out.println("Invalid input! Please provide both row and column coordinates. Try again:");
                shoot();
            } else if (row < 1 || row > 10 || col < 1 || col > 10) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                shoot();
            } else if (seaField.getSeaGrid()[row - 1][col - 1].equals("X")) {
                System.out.println("You hit a ship, again!");
                seaField.drawSea();
            } else if (seaField.getSeaGrid()[row - 1][col - 1].equals("M")) {
                System.out.println("You missed, again!");
                seaField.drawSea();
            } else if (field.getGrid()[row][col].equals("~ ")) {
                seaField.getSeaGrid()[row - 1][col - 1] = "M";
                field.getGrid()[row][col] = "M ";
                System.out.println("You missed!");
                seaField.drawSea();
            } else if (field.getGrid()[row][col].equals("O ")) {
                seaField.getSeaGrid()[row - 1][col - 1] = "X";
                field.getGrid()[row][col] = "X ";
                System.out.println("You hit a ship!");
                counter2--;
                countX2++;
                seaField.drawSea();
            }
        }
    }
}