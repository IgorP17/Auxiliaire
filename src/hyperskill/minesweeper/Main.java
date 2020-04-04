package hyperskill.minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many mines do you want on the field? ");

        int numOfBombs = Integer.parseInt(scanner.nextLine());
        Field field = new Field(9, 9, numOfBombs);
        field.printState();
    }

}

class Field {
    private int x;
    private int y;
    private int numOfBombs;

    private String[][] field;

    Field(int x, int y, int numOfBombs) {
        this.x = x;
        this.y = y;
        this.numOfBombs = numOfBombs;
        field = new String[x][y];
        generateField();
    }

    /**
     * . save field
     * X bomb
     */
    private void generateField() {
        if (numOfBombs > x * y || numOfBombs < 0) {
            throw new RuntimeException("Illegal num of bombs!");
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                field[i][j] = ".";
            }
        }
        int xRnd;
        int yRnd;
        Random xRandom = new Random();
        Random yRandom = new Random();
        int genCount = 0;
        while (genCount < numOfBombs) {
            xRnd = xRandom.nextInt(x);
            yRnd = yRandom.nextInt(y);
            // check if field is save and we can place bomb
            if (".".equalsIgnoreCase(field[xRnd][yRnd])) {
                field[xRnd][yRnd] = "X";
                genCount++;
            }
        }

        // set num of near
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                setNumberOfBombsSingle(i, j);
            }
        }
    }

    /**
     * Set in field number of near bombs at x1 y1
     */
    private void setNumberOfBombsSingle(int x1, int y1) {
        if (x1 >= x || y1 >= y) {
            throw new RuntimeException("Illegal coords!");
        }
        int counter = 0;
        // the field must be empty
        if (".".equalsIgnoreCase(field[x1][y1])) {
            if (x1 == 0 && y1 == 0) {
                // left top
                if ("x".equalsIgnoreCase(field[0][1])) counter++;
                if ("x".equalsIgnoreCase(field[1][0])) counter++;
                if ("x".equalsIgnoreCase(field[1][1])) counter++;
            } else if ((x1 == 0) && (y1 == (y - 1))) {
                // right top
                if ("x".equalsIgnoreCase(field[0][y - 2])) counter++;
                if ("x".equalsIgnoreCase(field[1][y - 2])) counter++;
                if ("x".equalsIgnoreCase(field[1][y - 1])) counter++;
            } else if ((x1 == (x - 1)) && (y1 == 0)) {
                // left bottom
                if ("x".equalsIgnoreCase(field[x - 2][0])) counter++;
                if ("x".equalsIgnoreCase(field[x - 2][1])) counter++;
                if ("x".equalsIgnoreCase(field[x - 1][1])) counter++;
            } else if ((x1 == (x - 1)) && (y1 == (y - 1))) {
                // right bottom
                if ("x".equalsIgnoreCase(field[x - 2][y - 1])) counter++;
                if ("x".equalsIgnoreCase(field[x - 2][y - 2])) counter++;
                if ("x".equalsIgnoreCase(field[x - 1][y - 2])) counter++;
            } else if (x1 == 0) {
                // top horiz
                if ("x".equalsIgnoreCase(field[0][y1 - 1])) counter++;
                if ("x".equalsIgnoreCase(field[0][y1 + 1])) counter++;
                if ("x".equalsIgnoreCase(field[1][y1])) counter++;
                if ("x".equalsIgnoreCase(field[1][y1 - 1])) counter++;
                if ("x".equalsIgnoreCase(field[1][y1 + 1])) counter++;
            } else if (x1 == (x - 1)) {
                // bottom horiz
                if ("x".equalsIgnoreCase(field[x - 1][y1 - 1])) counter++;
                if ("x".equalsIgnoreCase(field[x - 1][y1 + 1])) counter++;
                if ("x".equalsIgnoreCase(field[x - 2][y1])) counter++;
                if ("x".equalsIgnoreCase(field[x - 2][y1 - 1])) counter++;
                if ("x".equalsIgnoreCase(field[x - 2][y1 + 1])) counter++;
            } else if (y1 == 0) {
                // left vert
                if ("x".equalsIgnoreCase(field[x1 - 1][0])) counter++;
                if ("x".equalsIgnoreCase(field[x1 + 1][0])) counter++;
                if ("x".equalsIgnoreCase(field[x1][1])) counter++;
                if ("x".equalsIgnoreCase(field[x1 - 1][1])) counter++;
                if ("x".equalsIgnoreCase(field[x1 + 1][1])) counter++;
            } else if (y1 == (y - 1)) {
                // right vert
                if ("x".equalsIgnoreCase(field[x1 - 1][y1])) counter++;
                if ("x".equalsIgnoreCase(field[x1 + 1][y1])) counter++;
                if ("x".equalsIgnoreCase(field[x1][y1 - 1])) counter++;
                if ("x".equalsIgnoreCase(field[x1 - 1][y1 - 1])) counter++;
                if ("x".equalsIgnoreCase(field[x1 + 1][y1 - 1])) counter++;
            } else {
                // not in corner or side
                // top
                if ("x".equalsIgnoreCase(field[x1 - 1][y1])) counter++;
                if ("x".equalsIgnoreCase(field[x1 - 1][y1 - 1])) counter++;
                if ("x".equalsIgnoreCase(field[x1 - 1][y1 + 1])) counter++;
                // bottom
                if ("x".equalsIgnoreCase(field[x1 + 1][y1])) counter++;
                if ("x".equalsIgnoreCase(field[x1 + 1][y1 - 1])) counter++;
                if ("x".equalsIgnoreCase(field[x1 + 1][y1 + 1])) counter++;
                // left right
                if ("x".equalsIgnoreCase(field[x1][y1 - 1])) counter++;
                if ("x".equalsIgnoreCase(field[x1][y1 + 1])) counter++;
            }
        }
        if (counter > 0) {
            field[x1][y1] = String.valueOf(counter);
        }
    }

    /**
     * Print current state
     */
    void printState() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

}