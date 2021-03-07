package games.numbers;

import java.util.Scanner;

public class NumbersSolver {

    private static NumbersBoard board = null;

    public static void main(String[] args) {

        int cycles = 100;
        int state;

        do {
            // show menu
            printMenu();
            // get input
            try {
                state = getUserInput();
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
                System.exit(1);
            }
        } while (board == null);


        // do main job
        board.printBoard("=== initial board ===");

        for (int i = 0; i < cycles; i++) {
            board.process();

            // remove ********* row
            board.removeEmptyRow();

            board.printBoard("=== after cycle " + i + " ===");

            // after process we may have solved puzzle
            if (board.isAllFilled()) {
                System.out.println("!!! SOLVED !!!");
                break;
            }

            // after process we have nothing to do, only add cloned (not empty) values
            board.cloneAvailable();

            board.printBoard("=== no moves, cloned ===");
        }
    }

    /**
     * Print menu
     */
    private static void printMenu() {
        System.out.println("========== Menu ==========");
        System.out.println("0. Load state #0, 1-18, stable seed");
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
