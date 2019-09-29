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
        // load file
        process(initObjectFromFile, board);
        // fill board with candidates
        process(initialFill, board);
        // check alones
        OperResultsEnum res = process(fillAlone, board);
        // print board
        process(printBoard, board);
        // print state
        process(printState, board);
    }


}