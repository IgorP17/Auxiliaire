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
        boolean solved = false;
        // load file
        process(initObjectFromFile, board);
        // fill board with candidates
        process(initialFill, board);
        OperResultsEnum res;
        for (int i = 0; i < 2; i++) {//limit to some iterations
            // check alones
            do {
                res = process(fillAlone, board);
            } while (res == OperResultsEnum.NEW_CELL_FILLED);
            // if no cell filled it may mean that all filled
            if (board.getFilledCells() == Board.DIM * Board.DIM) {
                solved = true;
                break;
            }
            //check hidden alones
            process(fillHiddenAlone, board);
        }

        // print board
        process(printBoard, board);
        // print state, if not solved
        if (!solved)
            process(printState, board);
    }


}