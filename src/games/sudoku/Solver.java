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
        OperResultsEnum res;
        for (int i = 0; i < 1; i++) {//limit to some iterations
            // check alones
            do {
                res = process(fillAlone, board);
            }while (res == OperResultsEnum.NEW_CELL_FILLED);
            //check hidden alones
        }

        // print board
        process(printBoard, board);
        // print state
        process(printState, board);
    }


}