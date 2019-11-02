package games.sudoku;

class LambdaOpenTwos {
    /**
     * Labda for find open twos
     */
    static DoSomeThingFuncInterface findOpenTwos = board -> {
        System.out.println("=== Open Twos starts");
        Cell currentCell;
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                currentCell = board.getIJ(i, j);
                if (currentCell.getCandidates().size() != 2) continue;

                if (currentCell.isFilled()) continue;

                // searching in row
                for (int k = 0; k < Board.DIM; k++) {
                    // skip current cell
                    if (j == k) continue;
                    if (currentCell.compareCandidates(board.getIJ(i, k).getCandidates())) {
                        System.out.printf(
                                "Found same candidates in row for [%d][%d] and [%d][%d]\n",
                                i, j, i, k);
                        for (int cand :
                                currentCell.getCandidates()) {
                            for (int l = 0; l < Board.DIM; l++) {
                                if (!(j == l || k == l)) {
                                    board.getIJ(i, l).removeCandidate(cand);
                                }
                            }
                        }
                    }
                }

                // searching in col
                for (int k = 0; k < Board.DIM; k++) {
                    // skip current cell
                    if (i == k) continue;
                    if (currentCell.compareCandidates(board.getIJ(k, j).getCandidates())) {
                        System.out.printf(
                                "Found same candidates in col for [%d][%d] and [%d][%d]\n",
                                i, j, k, j);
                        for (int cand :
                                currentCell.getCandidates()) {
                            for (int l = 0; l < Board.DIM; l++) {
                                if (!(i == l || k == l)) {
                                    board.getIJ(l, j).removeCandidate(cand);
                                }
                            }
                        }
                    }
                }


                // searching in 3 x 3
                if (!currentCell.isFilled()) {
                    for (int k = 0; k < Board.DIM; k++) {
                        for (int l = 0; l < Board.DIM; l++) {
                            // cell not filled
                            if (board.getIJ(k, l).isFilled()) continue;
                            // not a current cell
                            if (!(i == k && j == l)) {
                                // the same 3 x 3
                                if (currentCell.getThreeID() == board.getIJ(k, l).getThreeID()) {
                                    // check if the same candidates
                                    if (currentCell.compareCandidates(board.getIJ(k, l).getCandidates())) {
                                        System.out.printf(
                                                "Found same candidates in 3 x 3 for [%d][%d] and [%d][%d]\n",
                                                i, j, k, l);
                                        // for each candidate
                                        for (int cand :
                                                currentCell.getCandidates()) {
                                            for (int m = 0; m < Board.DIM; m++) {
                                                for (int n = 0; n < Board.DIM; n++) {
                                                    if (!(i == m && j == n)) {
                                                        if (!(k == m && l == n)) {
                                                            if (currentCell.getThreeID() ==
                                                                    board.getIJ(m, n).getThreeID()) {
                                                                board.getIJ(m, n).removeCandidate(cand);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("=== Open Twos ends");
        return OperResultsEnum.OK;
    };
}
