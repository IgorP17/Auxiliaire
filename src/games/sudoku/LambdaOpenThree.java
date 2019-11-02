package games.sudoku;

import java.util.HashMap;
import java.util.Map;

class LambdaOpenThree {
    /**
     * Lambda for find threes: // TODO in process
     * 1. (abc)(abc)(abc)
     * 2. (abc)(abc)(ab)
     * 3. (abc)(ab)(bc)
     * 4. (ab)(bc)(ac)
     */
    static DoSomeThingFuncInterface findOpenThrees = board -> {
        System.out.println("=== Find Open Threes starts");
        HashMap<Cell, Integer[]> forRemove = new HashMap<>();

        // for rows TODO

        // for cols TODO
        // for each cell
        Cell cellA, cellB, cellC;
        Integer a, b, c;
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                cellA = board.getIJ(i, j);
                // if not filled
                if (!cellA.isFilled()) {
                    // num of candidates should be 2 or 3
                    if (cellA.getCandidates().size() == 3) {
                        // ====== VAR 1 ====== TODO
                        // (abc)(abc)(abc)

                        // ====== VAR 2 ====== TODO
                        //(abc)(abc)(ab)

                        // ====== VAR 3 ====== TODO
                        // (abc)(ab)(bc)

                    } else if (cellA.getCandidates().size() == 2) {
                        // ====== VAR 4 ======
                        // (ab)(bc)(ac)
                        // assume we have (ab) in current cell
                        a = cellA.getCandidates().get(0);
                        b = cellA.getCandidates().get(1);
                        // search col for (ac) variant
                        for (int k = 0; k < Board.DIM; k++) {
                            // not a current cell
                            if (i != k) {
                                // we have 2 candidates
                                if (board.getIJ(k, j).getCandidates().size() == 2) {
                                    // (ab) -- (ac)
                                    if (cellA.getCandidates().get(0).equals(board.getIJ(k, j).getCandidates().get(0))) {
                                        c = board.getIJ(k, j).getCandidates().get(1);
                                        cellC = board.getIJ(k, j);

                                        // okay, if we found ac, search bc
                                        for (int l = 0; l < Board.DIM; l++) {
                                            // not a current cell or ac cell
                                            if (i != l && k != l) {
                                                // we have 2 candidates
                                                if (board.getIJ(l, j).getCandidates().size() == 2) {
                                                    // bc
                                                    if (board.getIJ(l, j).getCandidates().get(0).equals(b) &&
                                                            board.getIJ(l, j).getCandidates().get(1).equals(c)) {
                                                        // we found bc
                                                        cellB = board.getIJ(l, j);
                                                        System.out.printf("Found open 3 - (abc) = (%d%d%d) " +
                                                                        "at [%d][%d], [%d][%d], [%d][%d]\n",
                                                                a, b, c,
                                                                cellA.getPosI(), cellA.getPosJ(),
                                                                cellB.getPosI(), cellB.getPosJ(),
                                                                cellC.getPosI(), cellC.getPosJ());
                                                        // so we need remove a b c from others cell in col
                                                        // so we have j = col num
                                                        // i = first cell
                                                        // k = second
                                                        // l = third
                                                        for (int m = 0; m < Board.DIM; m++) {
                                                            if (m != i && m != k && m != l) {
                                                                forRemove.put(board.getIJ(m, j), new Integer[]{a, b, c});
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

        // iterate over cand for remove
        Integer[] cands;
        for (Map.Entry<Cell, Integer[]> entry : forRemove.entrySet()) {
            cands = entry.getValue();
            for (Integer iCand :
                    cands) {
                entry.getKey().removeCandidate(iCand);
            }
        }

        System.out.println("=== Find Open Threes ends");
        return OperResultsEnum.OK;
    };
}
