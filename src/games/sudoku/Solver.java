package games.sudoku;

import static games.sudoku.ProcessBoardLambda.*;

public class Solver {

    /**
     * Define method that will handle lambda (aka implements interface)
     *
     * @param doSomeThingFuncInterface - lambda
     * @param board                    - board
     * @return - as lambda return
     */
    private static OperResultsEnum process(DoSomeThingFuncInterface doSomeThingFuncInterface, Board board) {
        return doSomeThingFuncInterface.func(board);
    }

    // Board
    private static Board board = new Board(
            "./src/games/sudoku/ex1.txt");

    public static void main(String[] args) {
        process(initObjectFromFile, board);
        process(initialFill, board);
        process(printBoard, board);
        process(printState, board);
    }


}