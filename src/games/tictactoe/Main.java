package games.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String s = scanner.nextLine();
        s = s.replace("\"", "");
        String[] f = s.split("");
        printField(f);
        System.out.print("Enter the coordinates: ");
        s = scanner.nextLine();
        while(!checkCoordsAndMove(f, s.substring(0, 1), s.substring(2, 3), "X")){
            System.out.print("Enter the coordinates: ");
            s = scanner.nextLine();
        }
        printField(f);

    }

    private static void printField(String[] state) {
        System.out.println("---------");
        System.out.printf("| %s %s %s |\n", state[0], state[1], state[2]);
        System.out.printf("| %s %s %s |\n", state[3], state[4], state[5]);
        System.out.printf("| %s %s %s |\n", state[6], state[7], state[8]);
        System.out.println("---------");
    }

    /**
     * Check coords and move
     * @param state - current state
     * @param x - x
     * @param y - y
     * @param s - X or O
     * @return - false if no move, true otherwise and make move
     */
    private static boolean checkCoordsAndMove(String[] state, String x, String y, String s) {
        boolean isXOK = false;
        boolean isYOK = false;
        // check x
        if ("1".equalsIgnoreCase(x)
                || "2".equalsIgnoreCase(x)
                || "3".equalsIgnoreCase(x)) {
            isXOK = true;
        }
        // check y
        if ("1".equalsIgnoreCase(y)
                || "2".equalsIgnoreCase(y)
                || "3".equalsIgnoreCase(y)) {
            isYOK = true;
        }
        if (!isXOK || !isYOK) {
            System.out.println("Wrong move!");
            return false;
        }
        // do move
        boolean res = humanMove(state, x , y, s);
        if (!res){
            System.out.println("Occupied!");
            return false;
        }
        return true;
    }

    /**
     * (1, 3) (2, 3) (3, 3)
     * (1, 2) (2, 2) (3, 2)
     * (1, 1) (2, 1) (3, 1)
     *
     * @param state - state massive
     * @param x     - x coord
     * @param y     - y coord
     * @param s     - X or O
     */
    private static boolean humanMove(String[] state, String x, String y, String s) {
        int stateNum = -1;
        switch (x) {
            case "1":
                switch (y) {
                    case "1":
                        stateNum = 6;
                        break;
                    case "2":
                        stateNum = 3;
                        break;
                    case "3":
                        stateNum = 0;
                        break;
                }
                break;
            case "2":
                switch (y) {
                    case "1":
                        stateNum = 7;
                        break;
                    case "2":
                        stateNum = 4;
                        break;
                    case "3":
                        stateNum = 1;
                        break;
                }
                break;
            case "3":
                switch (y) {
                    case "1":
                        stateNum = 8;
                        break;
                    case "2":
                        stateNum = 5;
                        break;
                    case "3":
                        stateNum = 2;
                        break;
                }
                break;
        }

        // check if we can move
        if ("X".equalsIgnoreCase(state[stateNum])
                || "O".equalsIgnoreCase(state[stateNum])) {
            return false;
        }
        state[stateNum] = s;
        return true;
    }

    /**
     * Get state of the game
     *
     * @param state - massive of fields, left top is 0, down right is 8
     * @return - state of the game
     */
    private static String getState(String[] state) {
        // check impossible state
        boolean isFilled = false;
        int counterX = 0;
        int counterY = 0;
        for (String s : state) {
            if ("X".equalsIgnoreCase(s)) {
                counterX++;
            }
            if ("O".equalsIgnoreCase(s)) {
                counterY++;
            }
        }
        // check count X O - there should be delta < 2
        if (Math.abs(counterX - counterY) > 1) {
            return "Impossible";
        }
        // check for double winner
        boolean xWinner = getWinner(state, "X");
        boolean yWinner = getWinner(state, "O");

        if (xWinner && yWinner) {
            return "Impossible";
        }

        // x wins
        if (xWinner) {
            return "X wins";
        }
        // o wins
        if (yWinner) {
            return "O wins";
        }

        // not finished
        if (counterX + counterY < 9) {
            return "Game not finished";
        }

        // draw
        return "Draw";
    }

    /**
     * Get winner of game
     *
     * @param state - massive of fields, left top is 0, down right is 8
     * @param s     - X or O or smth
     * @return - true if win in cell/row/diag found
     */
    private static boolean getWinner(String[] state, String s) {
        // check first row
        if (s.equalsIgnoreCase(state[0])
                && s.equalsIgnoreCase(state[1])
                && s.equalsIgnoreCase(state[2])) {
            return true;
        }
        // check second row
        if (s.equalsIgnoreCase(state[3])
                && s.equalsIgnoreCase(state[4])
                && s.equalsIgnoreCase(state[5])) {
            return true;
        }
        // check third row
        if (s.equalsIgnoreCase(state[6])
                && s.equalsIgnoreCase(state[7])
                && s.equalsIgnoreCase(state[8])) {
            return true;
        }
        // check first col
        if (s.equalsIgnoreCase(state[0])
                && s.equalsIgnoreCase(state[3])
                && s.equalsIgnoreCase(state[6])) {
            return true;
        }
        // check second col
        if (s.equalsIgnoreCase(state[1])
                && s.equalsIgnoreCase(state[4])
                && s.equalsIgnoreCase(state[7])) {
            return true;
        }
        // check third col
        if (s.equalsIgnoreCase(state[2])
                && s.equalsIgnoreCase(state[5])
                && s.equalsIgnoreCase(state[8])) {
            return true;
        }
        // check left down diag
        if (s.equalsIgnoreCase(state[0])
                && s.equalsIgnoreCase(state[4])
                && s.equalsIgnoreCase(state[8])) {
            return true;
        }
        // check left up diag
        return s.equalsIgnoreCase(state[2])
                && s.equalsIgnoreCase(state[4])
                && s.equalsIgnoreCase(state[6]);
    }
}
