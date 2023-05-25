package battleship;

import java.util.List;

public class Main {

    private static int turnCount = 1;

    public static int getTurnCount() {
        return turnCount;
    }

    public static void setTurnCount(int turnCount) {
        Main.turnCount = turnCount;
    }

    public static void main(String[] args) {

        FieldPlayer1 field = new FieldPlayer1(10, 10, 'A', 1);
        field.initializeField();
        field.printField();
        ShipPlacer shipPlacer = new ShipPlacer(field);
        shipPlacer.placeShips();

            EnterKey enterKey = new EnterKey();
            enterKey.promptEnterKey();

            FieldPlayer1 field2 = new FieldPlayer1(10, 10, 'A', 1);
            field2.initializeField();
            field2.printField();
            ShipPlacer shipPlacer2 = new ShipPlacer(field2);
            shipPlacer2.placeShips();

                SeaField1 seaField = new SeaField1(10, 10);
                SeaField1 seaField2 = new SeaField1(10, 10);

                ShootingTurn shootingTurn = new ShootingTurn(field, field2, seaField, seaField2);
                int countX1 = shootingTurn.getCountX1();
                int countX2 = shootingTurn.getCountX2();

                enterKey.promptEnterKey();

                do {
                    seaField2.drawSea();
                    System.out.println("---------------------");
                    field.printField();
                    System.out.println(" ");
                    System.out.println("Player 1, it's your turn:");
                    System.out.println(" ");
                    System.out.println(countX1);
                    shootingTurn.shoot();
                    turnCount++;

                    enterKey.promptEnterKey();

                    seaField.drawSea();
                    System.out.println("---------------------");
                    field2.printField();
                    System.out.println(" ");
                    System.out.println("Player 2, it's your turn:");
                    System.out.println(" ");
                    System.out.println(countX2);
                    shootingTurn.shoot();
                    turnCount++;

                    enterKey.promptEnterKey();
                } while (countX1 < 17 || countX2 < 17);

                System.out.println("End");
            }
        }


