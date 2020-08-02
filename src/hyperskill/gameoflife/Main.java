package hyperskill.gameoflife;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int dim = Integer.parseInt(s.split(" ")[0]);
        long seed = Long.parseLong(s.split(" ")[1]);
        int steps = Integer.parseInt(s.split(" ")[2]);

        Board board = new Board(dim, seed, steps);

        board.printBoard();
    }
}

class Board {
    private static final String sAlive = "O";
    private static final String sDead = " ";
    private final int dim;
    private final long seed;
    private final int steps;
    private String[][] board;

    public Board(int dim, long seed, int steps) {
        this.dim = dim;
        this.seed = seed;
        this.steps = steps;
        initBoard();
        if (steps > 0) {
            for (int i = 0; i < steps; i++) {
                process();
            }
        }
    }

    /**
     * Init board
     */
    private void initBoard() {
        board = new String[dim][dim];
        Random random = new Random();
        random.setSeed(seed);
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (random.nextBoolean()) {
                    board[i][j] = sAlive;
                } else {
                    board[i][j] = sDead;
                }
            }
        }
    }


    /**
     * Print board
     */
    void printBoard() {
        if (null == board) {
            throw new RuntimeException("Print board - board is null!");
        }
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


    /**
     * Process 1 step
     */
    private void process() {
        String[][] result = new String[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (getAlive(i, j)) {
                    result[i][j] = sAlive;
                } else {
                    result[i][j] = sDead;
                }
            }
        }
        board = result.clone();
    }

    /**
     * Get alive
     *
     * @param i - row
     * @param j - col
     * @return - if cell is alive
     */
    private boolean getAlive(int i, int j) {
        // get N
        String n = (i == 0 ? board[dim - 1][j] : board[i - 1][j]);
        // get S
        String s = (i == (dim - 1) ? board[0][j] : board[i + 1][j]);
        // get W
        String w = (j == 0 ? board[i][dim - 1] : board[i][j - 1]);
        // get E
        String e = (j == (dim - 1) ? board[i][0] : board[i][j + 1]);

        // get NW
        String nw;
        if (i == 0 && j == 0) {
            nw = board[dim - 1][dim - 1];
        } else if (i == 0) {
            nw = board[dim - 1][j - 1];
        } else if (j == 0) {
            nw = board[i - 1][dim - 1];
        } else {
            nw = board[i - 1][j - 1];
        }

        // get SW
        String sw;
        if (i == (dim - 1) && j == 0) {
            sw = board[0][dim - 1];
        } else if (i == (dim - 1)) {
            sw = board[0][j - 1];
        } else if (j == 0) {
            sw = board[i + 1][dim - 1];
        } else {
            sw = board[i + 1][j - 1];
        }

        // get NE
        String ne;
        if (i == 0 && j == (dim - 1)) {
            ne = board[dim - 1][0];
        } else if (i == 0) {
            ne = board[dim - 1][j + 1];
        } else if (j == (dim - 1)) {
            ne = board[i - 1][0];
        } else {
            ne = board[i - 1][j + 1];
        }

        // get SE
        String se;
        if (i == (dim - 1) && j == (dim - 1)) {
            se = board[0][0];
        } else if (i == (dim - 1)) {
            se = board[0][j + 1];
        } else if (j == (dim - 1)) {
            se = board[i + 1][0];
        } else {
            se = board[i + 1][j + 1];
        }

        // Rules
        // 1 - An alive cell survives if has two or three alive neighbors; otherwise, it dies of boredom (<2) or overpopulation (>3)
        // count
        String[] cnt = new String[]{n, s, w, e, nw, sw, ne, se};
        int cntAlive = 0;
        for (String value : cnt) {
            if (value.equalsIgnoreCase(sAlive)) {
                cntAlive++;
            }
        }
        if (board[i][j].equalsIgnoreCase(sAlive)) {
            return cntAlive == 2 || cntAlive == 3;
        } else {
            // 2 - A dead cell is reborn if it has exactly three alive neighbors
            return cntAlive == 3;
        }
    }
}



