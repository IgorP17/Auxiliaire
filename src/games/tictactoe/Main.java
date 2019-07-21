package games.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private static boolean isFirstBot, isSecondBot;
    private static boolean isExit = false;

    public static void main(String[] args) {

//        System.out.print("Enter cells: ");
//        String s = scanner.nextLine();
//        s = s.replace("\"", "");
//        String[] f = s.split("");
//        printField(f);

        String sState;
        while (!isExit) {
            if (getCommand()) {
                String[] f = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
                printField(f);
                while (true) {
                    sState = doMove(isFirstBot, f, "X");
                    if (sState != null) {
                        break;
                    }
                    sState = doMove(isSecondBot, f, "O");
                    if (sState != null) {
                        break;
                    }
                }
                System.out.println(sState);
            }
        }
    }

    /**
     * Do start game
     *
     * @return - if game can be started
     */
    private static boolean getCommand() {
        System.out.print("Input command: ");
        String s = scanner.nextLine();
        if (s.startsWith("start")) {
            String[] sp = s.split(" ");
            if (sp.length != 3
                    || !(sp[1].equalsIgnoreCase("user")
                    || sp[1].equalsIgnoreCase("easy"))
                    || !(sp[2].equalsIgnoreCase("user")
                    || sp[2].equalsIgnoreCase("easy"))) {
                System.out.println("Usage: start (user|easy) (user|easy)");
            } else {
                switch (sp[1]) {
                    case "user":
                        isFirstBot = false;
                        break;
                    case "easy":
                        isFirstBot = true;
                        break;
                }
                switch (sp[2]) {
                    case "user":
                        isSecondBot = false;
                        break;
                    case "easy":
                        isSecondBot = true;
                        break;
                }
                return true;
            }
        } else if (s.startsWith("exit")) {
            isExit = true;
        } else {
            System.out.println("Unknown command! Use start|exit");
        }
        return false;
    }


    /**
     * Make move
     *
     * @param isBot  - is it is bot
     * @param state  - state
     * @param marker - X or O
     * @return - null if we can do next move
     */
    private static String doMove(boolean isBot, String[] state, String marker) {
        if (isBot) {
            // bot move
            easyBot(state, marker);
            printField(state);
            return checkGameState(state);
        } else {
            // Human move
            System.out.print("Enter the coordinates: ");
            String s = scanner.nextLine();
            if (s.length() < 3) {
                // TODO wait until coords receoved
                System.out.println("PANIC!");
                System.exit(1);
            }
            while (!checkCoordsAndMove(state, s.substring(0, 1), s.substring(2, 3), marker, false)) {
                System.out.print("Enter the coordinates: ");
                s = scanner.nextLine();
            }
            printField(state);
            return checkGameState(state);
        }
    }

    /**
     * Check if game ends
     *
     * @param state - state
     * @return - null if we can do move, else winner
     */
    private static String checkGameState(String[] state) {
        String s = getState(state);
        if ("Draw".equalsIgnoreCase(s)) {
            return s;
        }
        if ("X wins".equalsIgnoreCase(s)) {
            return s;
        }
        if ("O wins".equalsIgnoreCase(s)) {
            return s;
        }
        return null;
    }

    /**
     * Print current state
     *
     * @param state - state
     */
    private static void printField(String[] state) {
        System.out.println("---------");
        System.out.printf("| %s %s %s |\n", state[0], state[1], state[2]);
        System.out.printf("| %s %s %s |\n", state[3], state[4], state[5]);
        System.out.printf("| %s %s %s |\n", state[6], state[7], state[8]);
        System.out.println("---------");
    }

    /**
     * Easy bot - mark random field
     *
     * @param state - current state
     * @param s     - X or O
     */
    private static void easyBot(String[] state, String s) {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        int x = 1 + random.nextInt(3);
        int y = 1 + random.nextInt(3);
        boolean res = checkCoordsAndMove(state, String.valueOf(x), String.valueOf(y), s, true);
        while (!res) {
            x = 1 + random.nextInt(3);
            y = 1 + random.nextInt(3);
            res = checkCoordsAndMove(state, String.valueOf(x), String.valueOf(y), s, true);
        }

    }

    /**
     * If it can win in one move (if it has two in a row), it places a third to get three in a row and win.
     * If the opponent can win in one move, it plays the third itself to block the opponent to win.
     * Otherwise, it makes a random move.
     *
     * @param state - current state
     * @param s - X or O
     */
    private static void mediumBot(String[] state, String s) {
        //TODO
    }

    /**
     * Check coords and move
     *
     * @param state - current state
     * @param x     - x
     * @param y     - y
     * @param s     - X or O
     * @return - false if no move, true otherwise and make move
     */
    private static boolean checkCoordsAndMove(String[] state, String x, String y, String s, boolean isBot) {
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
        boolean res = humanMove(state, x, y, s);
        if (!res) {
            if (!isBot) {
                System.out.println("Occupied!");
            }
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
