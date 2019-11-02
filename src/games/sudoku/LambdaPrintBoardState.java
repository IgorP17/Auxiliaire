package games.sudoku;

class LambdaPrintBoardState {
    /**
     * Lambda for print board
     */
    static DoSomeThingFuncInterface printBoard = (board) -> {
        System.out.println("=== Print starts");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                System.out.print("| " +
                        (board.getIJ(i, j).getValue() == null
                                ? "_"
                                : board.getIJ(i, j).getValue())
                        + " ");
                if ((j + 1) % 3 == 0 && j != 8) System.out.print("\t");
            }
            System.out.println("|");
            if ((i + 1) % 3 == 0) System.out.println("---------------------------------------------");
        }
        System.out.println("=== Print ends");
        return OperResultsEnum.OK;
    };

    /**
     * Lambda for print state
     */
    static DoSomeThingFuncInterface printState = (board) -> {
        System.out.println("=== Print state starts");
        int filled = board.getFilledCells();
        System.out.println("Filled count = " + filled);
        System.out.println("Empty count = " + (Board.DIM * Board.DIM - filled));
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                System.out.println(board.getIJ(i, j).toString());
                System.out.println("----------------------------------------------");
            }
        }
        System.out.println("=== Print state ends");
        return OperResultsEnum.OK;
    };

    /**
     * Lambda for check constrain of solved board
     */
    static DoSomeThingFuncInterface checkBoard = board -> {
        System.out.println("=== Check board starts");
        if (board.getFilledCells() != Board.DIM * Board.DIM) {
            System.out.println("Board is not ready!");
            return OperResultsEnum.FAIL;
        }
        Cell currentCell;
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                currentCell = board.getIJ(i, j);
                if (currentCell.getValue() == -1) return OperResultsEnum.FAIL;
                // check unique in row
                for (int k = 0; k < Board.DIM; k++) {
                    if (j != k) {
                        if (currentCell.getValue().equals(board.getIJ(i, k).getValue())) {
                            System.out.printf("Check failure! [%d][%d] == [%d] && " +
                                            "[%d][%d] == [%d]\n",
                                    i, j, currentCell.getValue(),
                                    i, k, board.getIJ(i, k).getValue());
                            return OperResultsEnum.FAIL;
                        }
                    }
                }
                // check unique in col
                for (int k = 0; k < Board.DIM; k++) {
                    if (i != k) {
                        if (currentCell.getValue().equals(board.getIJ(k, j).getValue())) {
                            System.out.printf("Check failure! [%d][%d] == [%d] && " +
                                            "[%d][%d] == [%d]\n",
                                    i, j, currentCell.getValue(),
                                    k, j, board.getIJ(k, j).getValue());
                            return OperResultsEnum.FAIL;
                        }
                    }
                }
                // check unique in 3x3
                for (int k = 0; k < Board.DIM; k++) {
                    for (int l = 0; l < Board.DIM; l++) {
                        // not a current cell
                        if (!(i == k && j == l)) {
                            // the same 3 x 3
                            if (currentCell.getThreeID() ==
                                    board.getIJ(k, l).getThreeID()) {
                                if (currentCell.getValue().equals(
                                        board.getIJ(k, l).getValue())) {
                                    return OperResultsEnum.FAIL;
                                }
                            }
                        }
                    }
                }

            }
        }
        System.out.println("=== Check board ends");
        return OperResultsEnum.OK;
    };
}
