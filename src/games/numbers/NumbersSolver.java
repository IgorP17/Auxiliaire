package games.numbers;

import java.util.Scanner;

public class NumbersSolver {

    public static void main(String[] args) {

        NumbersBoard board = null;
        int cycles = 100;
        int state;
        boolean isSolved = false;
        boolean isNeedBoardPrinted = true;
        int timeoutLimit = 60 * 1000; // 1 min in ms, for all cycles
        long startStamp;

        do {
            // show menu
            printMenu(cycles);
            // get input
            try {
                state = getUserInput();
                if (state == 1) {
                    isNeedBoardPrinted = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, reenter");
                continue;
            }

            // check exit
            if (state == 99)
                System.exit(0);

            // try to init
            try {
                board = new NumbersBoard(state);
            } catch (NoSuchOptionException nse) {
                System.out.println(nse.getMessage());
            } catch (Exception e) {
                System.out.println("!!! Something goes very wrong!");
                System.out.println("State is: " + state);
                e.printStackTrace();
                System.exit(1);
            }
        } while (board == null);


        // do main job
        board.printBoard("=== initial board ===");
        startStamp = System.currentTimeMillis();
        for (int i = 0; i < cycles; i++) {
            if (!isNeedBoardPrinted) {
                System.out.println("=== Starting cycle " + i + " ===");
            }
            board.process(isNeedBoardPrinted);

            // remove ********* row
            board.removeEmptyRow();

            if (isNeedBoardPrinted) {
                board.printBoard("=== after cycle " + i + " ===");
            }

            // after process we may have solved puzzle
            if (board.isAllFilled()) {
                System.out.println("!!! SOLVED !!!");
                isSolved = true;
                break;
            }

            // check timeout
            if (System.currentTimeMillis() - startStamp > timeoutLimit){
                System.out.println("!!! Sorry, timeout exceeds " + timeoutLimit + " ms");
                System.out.println("Start at: " + startStamp);
                System.out.println("Now is  : " + System.currentTimeMillis());
                break;
            }

            // after process we have nothing to do, only add cloned (not empty) values
            board.cloneAvailable();

            if (isNeedBoardPrinted) {
                board.printBoard("=== no moves, cloned ===");
            } else {
                System.out.println("=== Ending cycle " + i + " ===");
            }
        }

        if (!isSolved) {
            System.out.println("!!! Cannot solve puzzle in " + cycles + " cycles");
        } else {
            System.out.println("Elapsed: " + (System.currentTimeMillis() - startStamp) + " ms");
        }
    }

    /**
     * Print menu
     */
    private static void printMenu(int cycles) {
        System.out.println("========== Menu (" + cycles + " cycles)==========");
        System.out.println("0. Load state #0, 1-18, stable seed");
        System.out.println("1. Load state #1, Random, seed 1");
        System.out.println("99. Exit");
        System.out.println("========== Menu end ==========");
    }

    /**
     * Get user input
     *
     * @return menu item
     */
    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the option:");
        return scanner.nextInt();
    }
}
