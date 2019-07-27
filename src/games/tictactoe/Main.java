package games.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private static Player player1, player2;
    private static boolean isExit = false;
    private static String[] state;

    public static void main(String[] args) {

        String sState;
        while (!isExit) {
            if (getCommand()) {
                state = new String[]{" ", " ", " ", " ", " ", " ", " ", " ", " "};
                printField();
                while (true) {
                    sState = doMove(player1);
                    if (sState != null) {
                        break;
                    }
                    sState = doMove(player2);
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
                    || sp[1].equalsIgnoreCase("easy")
                    || sp[1].equalsIgnoreCase("medium"))

                    || !(sp[2].equalsIgnoreCase("user")
                    || sp[2].equalsIgnoreCase("easy")
                    || sp[2].equalsIgnoreCase("medium"))) {
                System.out.println("Usage: start (user|easy|medium) (user|easy|medium)");
            } else {
                switch (sp[1]) {
                    case "user":
                        player1 = new Player(false, null, "X", "O");
                        break;
                    case "easy":
                        player1 = new Player(true, Levels.EASY, "X", "O");
                        break;
                    case "medium":
                        player1 = new Player(true, Levels.MEDIUM, "X", "O");
                        break;
                }
                switch (sp[2]) {
                    case "user":
                        player2 = new Player(false, null, "O", "X");
                        break;
                    case "easy":
                        player2 = new Player(true, Levels.EASY, "O", "X");
                        break;
                    case "medium":
                        player2 = new Player(true, Levels.MEDIUM, "O", "X");
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
     * @param player - player obj
     * @return - null if we can do next move
     */
    private static String doMove(Player player) {
        if (player.isBot()) {
            // bot move
            switch (player.getLevel()) {
                case EASY:
                    easyBot(player.getMarker(), true);
                    break;
                case MEDIUM:
                    mediumBot(player.getMarker(), player.getOpponentMarker());
                    break;
            }
            printField();
            return checkGameState();
        } else {
            // Human move
            System.out.print("Enter the coordinates: ");
            String s = scanner.nextLine();
            if (s.length() < 3) {
                // TODO wait until coords receoved
                System.out.println("PANIC!");
                System.exit(1);
            }
            while (!checkCoordsAndMove(s.substring(0, 1), s.substring(2, 3), player.getMarker(), false)) {
                System.out.print("Enter the coordinates: ");
                s = scanner.nextLine();
            }
            printField();
            return checkGameState();
        }
    }

    /**
     * Check if game ends
     *
     * @return - null if we can do move, else winner
     */
    private static String checkGameState() {
        String s = getState();
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
     */
    private static void printField() {
        System.out.println("---------");
        System.out.printf("| %s %s %s |\n", state[0], state[1], state[2]);
        System.out.printf("| %s %s %s |\n", state[3], state[4], state[5]);
        System.out.printf("| %s %s %s |\n", state[6], state[7], state[8]);
        System.out.println("---------");
    }

    /**
     * Easy bot - mark random field
     *
     * @param s - X or O
     */
    private static void easyBot(String s, boolean printMaking) {
        if (printMaking) {
            System.out.println("Making move level \"easy\"");
        }
        Random random = new Random();
        int x = 1 + random.nextInt(3);
        int y = 1 + random.nextInt(3);
        boolean res = checkCoordsAndMove(String.valueOf(x), String.valueOf(y), s, true);
        while (!res) {
            x = 1 + random.nextInt(3);
            y = 1 + random.nextInt(3);
            res = checkCoordsAndMove(String.valueOf(x), String.valueOf(y), s, true);
        }

    }

    /**
     * If it can win in one move (if it has two in a row), it places a third to get three in a row and win.
     * If the opponent can win in one move, it plays the third itself to block the opponent to win.
     * Otherwise, it makes a random move.
     *
     * @param s - X or O
     */
    private static void mediumBot(String s, String opponentSign) {
        boolean isMoveDone = false;
        System.out.println("Making move level \"medium\"");
        // check if can win
        int[] coords = canWinInOneMove(s);
        if (coords[0] != -1) {
//            System.out.printf("%s can win in 1 move\n", s);
            boolean res = checkCoordsAndMove(String.valueOf(coords[0]), String.valueOf(coords[1]), s, true);
            if (!res) {
                System.out.println("WTF?");
                System.exit(1);
            }
            isMoveDone = true;
        }
        // check if can loose
        if (!isMoveDone) {
            coords = canWinInOneMove(opponentSign);
            if (coords[0] != -1) {
//                System.out.printf("%s can win in 1 move\n", opponentSign);
                boolean res = checkCoordsAndMove(String.valueOf(coords[0]), String.valueOf(coords[1]), s, true);
                if (!res) {
                    System.out.println("WTF?");
                    System.exit(1);
                }
                isMoveDone = true;
            }
        }
        // random
        if (!isMoveDone) {
            easyBot(s, false);
        }
    }

    /**
     * Get coords if can win in 1 move
     *
     * @param s - X or O
     * @return - coords for move
     */
    private static int[] canWinInOneMove(String s) {
        // left down corner
        //up
        if (s.equalsIgnoreCase(state[6]) && s.equalsIgnoreCase(state[3])) {
            if (state[0].equalsIgnoreCase(" ")) {
                return new int[]{1, 3};
            }
        }
        //right
        if (s.equalsIgnoreCase(state[6]) && s.equalsIgnoreCase(state[7])) {
            if (state[8].equalsIgnoreCase(" ")) {
                return new int[]{3, 1};
            }
        }
        //diag
        if (s.equalsIgnoreCase(state[6]) && s.equalsIgnoreCase(state[4])) {
            if (state[2].equalsIgnoreCase(" ")) {
                return new int[]{3, 3};
            }
        }
        // left up corner
        // down
        if (s.equalsIgnoreCase(state[0]) && s.equalsIgnoreCase(state[3])) {
            if (state[6].equalsIgnoreCase(" ")) {
                return new int[]{1, 1};
            }
        }
        // right
        if (s.equalsIgnoreCase(state[0]) && s.equalsIgnoreCase(state[1])) {
            if (state[2].equalsIgnoreCase(" ")) {
                return new int[]{3, 3};
            }
        }
        //diag
        if (s.equalsIgnoreCase(state[0]) && s.equalsIgnoreCase(state[4])) {
            if (state[8].equalsIgnoreCase(" ")) {
                return new int[]{3, 1};
            }
        }

        // right down corner
        // up
        if (s.equalsIgnoreCase(state[8]) && s.equalsIgnoreCase(state[5])) {
            if (state[2].equalsIgnoreCase(" ")) {
                return new int[]{3, 3};
            }
        }
        // left
        if (s.equalsIgnoreCase(state[8]) && s.equalsIgnoreCase(state[7])) {
            if (state[6].equalsIgnoreCase(" ")) {
                return new int[]{1, 1};
            }
        }
        // diag
        if (s.equalsIgnoreCase(state[8]) && s.equalsIgnoreCase(state[4])) {
            if (state[0].equalsIgnoreCase(" ")) {
                return new int[]{1, 3};
            }
        }

        // right up corner
        // down
        if (s.equalsIgnoreCase(state[2]) && s.equalsIgnoreCase(state[5])) {
            if (state[8].equalsIgnoreCase(" ")) {
                return new int[]{3, 1};
            }
        }
        // left
        if (s.equalsIgnoreCase(state[2]) && s.equalsIgnoreCase(state[1])) {
            if (state[0].equalsIgnoreCase(" ")) {
                return new int[]{1, 3};
            }
        }
        // diag
        if (s.equalsIgnoreCase(state[2]) && s.equalsIgnoreCase(state[4])) {
            if (state[6].equalsIgnoreCase(" ")) {
                return new int[]{1, 1};
            }
        }

        // 2nd row
        // left
        if (s.equalsIgnoreCase(state[3]) && s.equalsIgnoreCase(state[4])) {
            if (state[5].equalsIgnoreCase(" ")) {
                return new int[]{3, 2};
            }
        }
        // right
        if (s.equalsIgnoreCase(state[5]) && s.equalsIgnoreCase(state[4])) {
            if (state[3].equalsIgnoreCase(" ")) {
                return new int[]{1, 2};
            }
        }
        // mid
        if (s.equalsIgnoreCase(state[3]) && s.equalsIgnoreCase(state[5])) {
            if (state[4].equalsIgnoreCase(" ")) {
                return new int[]{2, 2};
            }
        }

        // 2nd col
        // up
        if (s.equalsIgnoreCase(state[1]) && s.equalsIgnoreCase(state[4])) {
            if (state[7].equalsIgnoreCase(" ")) {
                return new int[]{2, 1};
            }
        }
        // down
        if (s.equalsIgnoreCase(state[7]) && s.equalsIgnoreCase(state[4])) {
            if (state[1].equalsIgnoreCase(" ")) {
                return new int[]{2, 3};
            }
        }
        // mid
        if (s.equalsIgnoreCase(state[1]) && s.equalsIgnoreCase(state[7])) {
            if (state[4].equalsIgnoreCase(" ")) {
                return new int[]{2, 2};
            }
        }

        // mids
        if (s.equalsIgnoreCase(state[0]) && s.equalsIgnoreCase(state[6])) {
            if (state[3].equalsIgnoreCase(" ")) {
                return new int[]{1, 2};
            }
        }
        if (s.equalsIgnoreCase(state[6]) && s.equalsIgnoreCase(state[8])) {
            if (state[7].equalsIgnoreCase(" ")) {
                return new int[]{2, 1};
            }
        }
        if (s.equalsIgnoreCase(state[8]) && s.equalsIgnoreCase(state[2])) {
            if (state[5].equalsIgnoreCase(" ")) {
                return new int[]{3, 2};
            }
        }
        if (s.equalsIgnoreCase(state[2]) && s.equalsIgnoreCase(state[0])) {
            if (state[1].equalsIgnoreCase(" ")) {
                return new int[]{2, 3};
            }
        }

        return new int[]{-1, -1};
    }

    /**
     * Check coords and move
     *
     * @param x - x
     * @param y - y
     * @param s - X or O
     * @return - false if no move, true otherwise and make move
     */
    private static boolean checkCoordsAndMove(String x, String y, String s, boolean isBot) {
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
        boolean res = humanMove(x, y, s);
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
     * @param x - x coord
     * @param y - y coord
     * @param s - X or O
     */
    private static boolean humanMove(String x, String y, String s) {
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
     * @return - state of the game
     */
    private static String getState() {
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
        boolean xWinner = getWinner("X");
        boolean yWinner = getWinner("O");

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
     * @param s - X or O or smth
     * @return - true if win in cell/row/diag found
     */
    private static boolean getWinner(String s) {
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


    /**
     * Player class
     */
    private static class Player {
        private boolean isBot;
        private Levels level;
        private String marker;
        private String opponentMarker;

        public Player(boolean isBot, Levels level, String marker, String opponentMarker) {
            this.isBot = isBot;
            if (level != null) {
                this.level = level;
            } else {
                this.level = Levels.NONE;
            }
            this.marker = marker;
            this.opponentMarker = opponentMarker;
        }

        public String getOpponentMarker() {
            return opponentMarker;
        }

        public boolean isBot() {
            return isBot;
        }

        public Levels getLevel() {
            return level;
        }

        public String getMarker() {
            return marker;
        }

        @Override
        public String toString() {
            return "Is Bot = "
                    + isBot + "\n"
                    + "Level = "
                    + level.toString() + "\n"
                    + "Marker = "
                    + marker;
        }
    }

    private enum Levels {
        EASY, MEDIUM, HARD, NONE;
    }
}
