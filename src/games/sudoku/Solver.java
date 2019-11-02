package games.sudoku;

import static games.sudoku.LambdaFillAlone.fillAlone;
import static games.sudoku.LambdaFillHiddenAlone.fillHiddenAlone;
import static games.sudoku.LambdaInitObjectFromFile.initObjectFromFile;
import static games.sudoku.LambdaInitialFill.initialFill;
import static games.sudoku.LambdaOpenThree.findOpenThrees;
import static games.sudoku.LambdaOpenTwos.findOpenTwos;
import static games.sudoku.LambdaPointingPairs.pointingPairs;
import static games.sudoku.LambdaPrintBoardState.*;

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

    private static boolean solved = false;

    public static void main(String[] args) {
        OperResultsEnum res;
        // load file
        process(initObjectFromFile, board);
        // fill board with candidates
        process(initialFill, board);

        // try some analytics
        tryBrain();
//        process(printBoard, board);
//        process(printState, board);

        // if !solved
//        if (!solved) {
//            guess();
//        }

        // print board
        process(printBoard, board);

        // print state, if not solved
        if (!solved)
            process(printState, board);
        else {
            res = process(checkBoard, board);
            if (res == OperResultsEnum.FAIL) {
                throw new RuntimeException("Wrong solution!");
            }
        }
    }

    /*private static void guess() {
        System.out.println("====== Guess starts");
        try {
            // save current state
            Serialize.serializeMe(board);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // find cell with some pairs
        Cell currentCell;
        int pI = -1, pJ = -1;
        int[] vals = new int[2];
        boolean isPairFound = false;
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                currentCell = board.getIJ(i, j);
                // not filled
                if (!currentCell.isFilled()) {
                    // 2 candidates
                    if (currentCell.getCandidates().size() == 2) {
                        pI = i;
                        pJ = j;
                        vals[0] = currentCell.getCandidates().get(0);
                        vals[1] = currentCell.getCandidates().get(1);
                        isPairFound = true;
                        break;
                    }
                }
            }
            if (isPairFound) break;
        }
        System.out.printf("Found pair of candidates at [%d][%d] vals = [%d, %d]\n",
                pI, pJ, vals[0], vals[1]);
        // try them
        for (int v :
                new int[]{vals[1], vals[0]}) {
            System.out.printf("Trying candidate %d at [%d][%d]\n",
                    v, pI, pJ);
            // load board (for first candidate not necessary)
            try {
                board = Serialize.deSerializeMe();
                System.out.println("Deser");
                process(printBoard, board);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Cannot deserialize!");
            }
            board.setIJ(pI, pJ, new Cell(true, v, pI, pJ));
            board.removeCandidateFromOthers(pI, pJ, v);
            // and try to brain again
            tryBrain();
            // if solved then break
            if (solved && (OperResultsEnum.OK == process(checkBoard, board))) break;
        }

        System.out.println("====== Guess ends");
    }*/

    /**
     * Try methods alone, hidden alone, open twos...
     */
    private static void tryBrain() {
        System.out.println("====== Try Brain starts");
        OperResultsEnum res;
        for (int i = 0; i < 5; i++) {//limit to some iterations
            System.out.println("=== Step #" + i);
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
            // open twos
            process(findOpenTwos, board);
            // pointer pair
            process(pointingPairs, board);
            // Open 3
            process(findOpenThrees, board);
        }
        System.out.println("====== Try Brain ends");
    }
}