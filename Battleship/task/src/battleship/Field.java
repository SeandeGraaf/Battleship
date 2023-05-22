package battleship;
import java.util.Scanner;

public class Field {
    private int rows;
    private int columns;
    private char startRow;
    private int startColumn;
    private String[][] grid;

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public char getStartRow() {
        return startRow;
    }

    public int getStartColumn() {
        return startColumn;
    }

    public String[][] getGrid() {
        return grid;
    }

    public Field(int rows, int columns, char startRow, int startColumn) {
        this.rows = rows;
        this.columns = columns;
        this.startRow = startRow;
        this.startColumn = startColumn;
        this.grid = new String[rows + 1][columns + 1];
    }

    public void initializeField() {
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                if (i == 0 && j == 0) {
                    grid[i][j] = "  ";
                } else if (i == 0) {
                    grid[i][j] = j + " ";
                } else if (j == 0) {
                    grid[i][j] = (char) (startRow + i - 1) + " ";
                } else {
                    grid[i][j] = "~ ";
                }
            }
        }
    }

    public void printField() {
        System.out.print("  ");
        for (int j = 1; j <= columns; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 1; i <= rows; i++) {
            System.out.print((char)(startRow + i - 1) + " ");
            for (int j = 1; j <= columns; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}