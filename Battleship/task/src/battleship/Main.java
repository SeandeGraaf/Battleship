package battleship;

import java.util.Scanner;

public class Main {
    static String[] shipTypes;

    public static void main(String[] args) {
        Field field = new Field(10, 10, 'A', 1);
        field.initializeField();
        field.printField();

        ShipPlacer shipPlacer = new ShipPlacer(field);
        shipPlacer.shipPlace();

        SeaField seaField = new SeaField(10, 10);
        seaField.drawSea();

        ShootingTurn shootingTurn = new ShootingTurn(field);
        shootingTurn.shoot();

        }
    }






