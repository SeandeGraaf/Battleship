package battleship;

public class SeaField {
    private final int rows;
    private final int columns;
    private final String[][] seaGrid;

    public SeaField(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seaGrid = new String[rows][columns];
        initializeSea();
    }

    public SeaField(int rows, int columns, String[][] seaGrid) {
        this.rows = rows;
        this.columns = columns;
        this.seaGrid = seaGrid;
    }

    public String[][] getSeaGrid() {
        return seaGrid;
    }


    private void initializeSea() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seaGrid[i][j] = "~";
            }
        }
    }

    public void drawSea() {
        System.out.print("  ");
        for (int col = 1; col <= columns; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < rows; row++) {
            char rowLabel = (char) ('A' + row);
            System.out.print(rowLabel + " ");
            for (int col = 0; col < columns; col++) {
                System.out.print(seaGrid[row][col] + " ");
            }
            System.out.println();
        }
    }

}
