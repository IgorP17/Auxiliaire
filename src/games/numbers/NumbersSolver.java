package games.numbers;

public class NumbersSolver {

    public static void main(String[] args) {

        int cycles = 100;
        NumbersBoard board = new NumbersBoard(0);

        board.printBoard("initial board");

        for (int i = 0; i < cycles; i++) {
            board.process();

            // remove ********* row
            board.removeEmptyRow();

            board.printBoard("after cycle " + i);

            // after process we may have solved puzzle
            if (board.isAllFilled()) {
                System.out.println("!!! SOLVED !!!");
                break;
            }

            // after process we have nothing to do, only add cloned (not empty) values
            board.cloneAvailable();

            board.printBoard("no moves, cloned");
        }
    }






}
