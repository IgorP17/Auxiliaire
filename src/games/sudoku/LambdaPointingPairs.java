package games.sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class LambdaPointingPairs {

    /**
     * Lambda for find pointer of pair in small square //TODO for cols
     */
    static DoSomeThingFuncInterface pointingPairs = board -> {
        System.out.println("=== Pointer Pair starts");
        Cell seekingCell, currentCell;
        ArrayList<Integer> candidates;
        HashMap<Cell, Integer> forRemove = new HashMap<>();
        // for each cell
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                currentCell = board.getIJ(i, j);
                candidates = currentCell.getCandidates();
                // if cell not filled
                if (!currentCell.isFilled()) {
                    // ====== ROWS ======
                    // searching in row
                    // for each candidate
                    for (Integer cand :
                            candidates) {
                        // searching in row
                        for (int k = 0; k < Board.DIM; k++) {
                            // not a current cell
                            if (j != k) {
                                // cell is not filled
                                seekingCell = board.getIJ(i, k);
                                if (!seekingCell.isFilled()) {
                                    // cell has he same candidate
                                    if (seekingCell.getCandidates().contains(cand)) {
                                        // candidate should be in the same small square
                                        if (seekingCell.getThreeID() == currentCell.getThreeID()) {
                                            // candidate not present in other rows in the small square
                                            ArrayList<Cell> sSquare = board.getTheSameSmallSquare(i, j);
                                            // assume we have pointer
                                            boolean isPointer = true;
                                            // for each cell
                                            for (Cell sCell :
                                                    sSquare) {
                                                // not a current cell
                                                if (!(sCell.getPosI() == i && sCell.getPosJ() == j)) {
                                                    // not a seeking cell
                                                    if (!(sCell.getPosI() == i && sCell.getPosJ() == k)) {
                                                        // not a cell in the ROW of 3x3 - allow 3 pointer
                                                        if (sCell.getPosI() != i) {
                                                            // has the same cand
                                                            if (sCell.getCandidates().contains(cand)) {
                                                                isPointer = false;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if (isPointer) {
                                                System.out.printf("Seems we have row pointer " +
                                                                "at [%d][%d] and [%d][%d] value = %d\n",
                                                        i, j, i, k, cand);
                                                // remove candidate from other small squares in a row
                                                for (int l = 0; l < Board.DIM; l++) {
                                                    // not the same small square
                                                    if (!(board.getIJ(i, l).getThreeID() == currentCell.getThreeID())) {
                                                        System.out.printf("Mark for remove candidate %d at [%d][%d]\n",
                                                                cand, i, l);
                                                        forRemove.put(board.getIJ(i, l), cand);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // TODO COL
                }
            }
        }

        // iterate over cand for remove
        for (Map.Entry<Cell, Integer> entry : forRemove.entrySet()) {
            entry.getKey().removeCandidate(entry.getValue());
        }
        System.out.println("=== Pointer Pair ends");
        return OperResultsEnum.OK;
    };
}
