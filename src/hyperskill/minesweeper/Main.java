package hyperskill.minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many mines do you want on the field? ");

        int numOfBombs = Integer.parseInt(scanner.nextLine());
        Field field = new Field(4, 2, numOfBombs);
        int x;
        int y;
        String action;
        String line;

        field.printState(false);

        while (field.getGameState() == GameState.RUNNING) {
            System.out.print("Set/delete mines marks (x and y coordinates): ");
            line = scanner.nextLine();
            try {
                x = Integer.parseInt(line.split(" ")[0]);
                y = Integer.parseInt(line.split(" ")[1]);
                action = line.split(" ")[2].toLowerCase();
                switch (action) {
                    case "mine":
                        field.setMarkedBomb(x - 1, y - 1);
                        break;
                    case "free":
                        field.setOpened(x - 1, y - 1);
                        break;
                }
                if (field.getGameState() == GameState.RUNNING) {
                    field.printState("all".equalsIgnoreCase(action));
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }

        switch (field.getGameState()){
            case BOMB:
                field.printState(true);
                System.out.println("You stepped on a mine and failed!");
                break;
            case OK:
                break;
            default:
                System.out.println("Unknown exit state!");
        }
    }

}

class Field {
    private int x;
    private int y;
    private int numOfBombs;
    private GameState gameState = GameState.RUNNING;

    private Cell[][] field;

    Field(int x, int y, int numOfBombs) {
        this.x = x;
        this.y = y;
        this.numOfBombs = numOfBombs;
        field = new Cell[x][y];
        generateField();
    }


    public GameState getGameState() {
        return gameState;
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
                field[i][j] = new Cell();
                field[i][j].setEmpty(true);
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
            if (field[xRnd][yRnd].isEmpty()) {
                field[xRnd][yRnd].setBomb(true);
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
        if (field[x1][y1].isEmpty()) {
            if (x1 == 0 && y1 == 0) {
                // left top
                if (field[0][1].isBomb()) counter++;
                if (field[1][0].isBomb()) counter++;
                if (field[1][1].isBomb()) counter++;
            } else if ((x1 == 0) && (y1 == (y - 1))) {
                // right top
                if (field[0][y - 2].isBomb()) counter++;
                if (field[1][y - 2].isBomb()) counter++;
                if (field[1][y - 1].isBomb()) counter++;
            } else if ((x1 == (x - 1)) && (y1 == 0)) {
                // left bottom
                if (field[x - 2][0].isBomb()) counter++;
                if (field[x - 2][1].isBomb()) counter++;
                if (field[x - 1][1].isBomb()) counter++;
            } else if ((x1 == (x - 1)) && (y1 == (y - 1))) {
                // right bottom
                if (field[x - 2][y - 1].isBomb()) counter++;
                if (field[x - 2][y - 2].isBomb()) counter++;
                if (field[x - 1][y - 2].isBomb()) counter++;
            } else if (x1 == 0) {
                // top horiz
                if (field[0][y1 - 1].isBomb()) counter++;
                if (field[0][y1 + 1].isBomb()) counter++;
                if (field[1][y1].isBomb()) counter++;
                if (field[1][y1 - 1].isBomb()) counter++;
                if (field[1][y1 + 1].isBomb()) counter++;
            } else if (x1 == (x - 1)) {
                // bottom horiz
                if (field[x - 1][y1 - 1].isBomb()) counter++;
                if (field[x - 1][y1 + 1].isBomb()) counter++;
                if (field[x - 2][y1].isBomb()) counter++;
                if (field[x - 2][y1 - 1].isBomb()) counter++;
                if (field[x - 2][y1 + 1].isBomb()) counter++;
            } else if (y1 == 0) {
                // left vert
                if (field[x1 - 1][0].isBomb()) counter++;
                if (field[x1 + 1][0].isBomb()) counter++;
                if (field[x1][1].isBomb()) counter++;
                if (field[x1 - 1][1].isBomb()) counter++;
                if (field[x1 + 1][1].isBomb()) counter++;
            } else if (y1 == (y - 1)) {
                // right vert
                if (field[x1 - 1][y1].isBomb()) counter++;
                if (field[x1 + 1][y1].isBomb()) counter++;
                if (field[x1][y1 - 1].isBomb()) counter++;
                if (field[x1 - 1][y1 - 1].isBomb()) counter++;
                if (field[x1 + 1][y1 - 1].isBomb()) counter++;
            } else {
                // not in corner or side
                // top
                if (field[x1 - 1][y1].isBomb()) counter++;
                if (field[x1 - 1][y1 - 1].isBomb()) counter++;
                if (field[x1 - 1][y1 + 1].isBomb()) counter++;
                // bottom
                if (field[x1 + 1][y1].isBomb()) counter++;
                if (field[x1 + 1][y1 - 1].isBomb()) counter++;
                if (field[x1 + 1][y1 + 1].isBomb()) counter++;
                // left right
                if (field[x1][y1 - 1].isBomb()) counter++;
                if (field[x1][y1 + 1].isBomb()) counter++;
            }
        }
        if (counter > 0) {
            field[x1][y1].setCount(true);
            field[x1][y1].setNear(counter);
        }
    }

    /**
     * Print current state
     * In reverse x y
     */
    void printState(boolean showAll) {
        System.out.print(" │");
        for (int i = 0; i < x; i++) {
            System.out.print(i + 1);
        }
        System.out.println("|");
        System.out.println("—│—————————│");
        for (int i = 0; i < y; i++) {
            System.out.print((i + 1) + "|");
            for (int j = 0; j < x; j++) {
                System.out.print(field[j][i].getStringRepresentation(showAll));
            }
            System.out.println("|");
        }
        System.out.println("—│—————————│");
    }

    boolean isAllBombsOpened() {
        // all bombs should be found
        // and no empty cells marked
        int counter = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (field[i][j].isMarkedBomb() && field[i][j].isEmpty()) {
                    return false;
                }
                if (field[i][j].isMarkedBomb() && field[i][j].isBomb()) {
                    counter++;
                }
            }
        }
        if (counter == numOfBombs) {
            gameState = GameState.OK;
        }
        return counter == numOfBombs;
    }

    /**
     * Set / unset bomb flag
     *
     * @param x1 x coord
     * @param y1 y coord
     */
    void setMarkedBomb(int x1, int y1) {
        try {
            // cell must be not opened
            if (field[x1][y1].isOpened()) {
                System.out.println("Cell is opened!");
                return;
            }
            // mark + unmark
            if (field[x1][y1].isMarkedBomb()) {
                field[x1][y1].setMarkedBomb(false);
            } else {
                field[x1][y1].setMarkedBomb(true);
            }
        } catch (Exception e) {
            System.out.println("Invalid set to mark!");
        }
    }

    void setOpened(int x1, int y1) {
        if (field[x1][y1].isBomb()){
            gameState = GameState.BOMB;
            return;
        }
    }

}

class Cell {
    private boolean isEmpty = false;
    private boolean isBomb = false;
    private boolean isCount = false;
    private boolean isMarkedBomb = false;
    private boolean isOpened = false;
    private int near = 0;


    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public boolean isMarkedBomb() {
        return isMarkedBomb;
    }

    public void setMarkedBomb(boolean markedBomb) {
        isMarkedBomb = markedBomb;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
        if (bomb) {
            isEmpty = false;
        }
    }

    public void setCount(boolean count) {
        isCount = count;
    }

    public void setNear(int near) {
        this.near = near;
    }

    public String getStringRepresentation(boolean showAll) {
        if (showAll) {
            if (isBomb) return "X";
            if (isCount) return String.valueOf(near);
        }

        if (isMarkedBomb) return "*";
        return ".";
    }
}

enum GameState {
    RUNNING, OK, BOMB
}