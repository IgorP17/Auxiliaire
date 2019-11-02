package games.sudoku;

class LambdaFillHiddenAlone {
    /**
     * Lambda for fill hidden alone candidates // TODO seems here is some problem?
     */
    static DoSomeThingFuncInterface fillHiddenAlone = board -> {
        System.out.println("=== Fill hidden starts");
        Cell currentCell;
        boolean isAlone = true;
        int aloneValue = -1;
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                currentCell = board.getIJ(i, j);
                // if current cell is not filled
                if (!currentCell.isFilled()) {
                    // for all candidates
                    for (int v :
                            currentCell.getCandidates()) {
                        // assume candidate alone
                        isAlone = true;
                        aloneValue = v;
                        // check if it is hidden alone in row
                        // set false if in other cell we found the same candidate
                        for (int k = 0; k < Board.DIM; k++) {
                            if (k != j) {
                                if (board.getIJ(i, k).getCandidates().contains(v)) {
                                    isAlone = false;
                                }
                            }
                        }
                        // if it is alone set it
                        if (isAlone) break;

                        // assume candidate alone
                        isAlone = true;
                        // check if it is hidden alone in column
                        for (int k = 0; k < Board.DIM; k++) {
                            if (k != i) {
                                if (board.getIJ(k, j).getCandidates().contains(v)) {
                                    isAlone = false;
                                }
                            }
                        }
                        // if it is alone set it
                        if (isAlone) break;

                        // assume candidate alone
                        isAlone = true;
                        // check if it is hidden alone in 3x3
                        for (int k = 0; k < Board.DIM; k++) {
                            for (int l = 0; l < Board.DIM; l++) {
                                if (!(i == k && j == l)) {
                                    // the same 3 x 3
                                    if (currentCell.getThreeID() == board.getIJ(k, l).getThreeID()) {
                                        if (board.getIJ(k, l).getCandidates().contains(v)) {
                                            isAlone = false;
                                        }
                                    }
                                }
                            }
                        }

                        // if it is alone set it
                        if (isAlone) break;
                    }
                    if (isAlone) {
                        System.out.printf("Found hidden alone at [%d] [%d] = %d\n",
                                i, j, aloneValue);
                        currentCell.setValue(aloneValue);
                        board.removeCandidateFromOthers(i, j, aloneValue);
                    }
                }
            }
        }
        System.out.println("=== Fill hidden ends");
        return OperResultsEnum.NOTHING_FILLED;
    };
}
