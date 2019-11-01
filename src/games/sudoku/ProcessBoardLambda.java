package games.sudoku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ProcessBoardLambda {

    /**
     * Lambda for initialisation board from file
     */
    static DoSomeThingFuncInterface initObjectFromFile = (board) -> {
        System.out.println("=== Init starts");
        // Try with resource
        int j = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(board.getPathToFile()))) {
            String line = br.readLine();
            while (line != null) {
                line = line.trim().replace(" ", "");

                if (!line.isEmpty()) {
                    String[] vals = line.split(";");
                    if (vals.length != Board.DIM) {
                        System.out.println(line);
                        throw new RuntimeException("Ellegal numbers of input string!");
                    }
                    for (int i = 0; i < Board.DIM; i++) {
                        Cell cell;
                        if ("_".equals(vals[i])) {
                            cell = new Cell(false, null, j, i);
                        } else {
                            cell = new Cell(true, Integer.parseInt(vals[i]), j, i);
                        }
                        board.setIJ(j, i, cell);
                    }
                    j++;
                }

                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception in lambda initObjectFromFile");
            e.printStackTrace();
        }
        System.out.println("=== Init ends");
        return OperResultsEnum.OK;
    };

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
     * Lambda for initial candidates filling
     */
    static DoSomeThingFuncInterface initialFill = (board) -> {
        System.out.println("=== Initial fill starts");
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                Cell currentCell = board.getIJ(i, j);
                if (!currentCell.isFilled()) {
                    System.out.printf("Cell [%d] [%d] - is empty, set all possible candidates\n",
                            i, j);
//                    candidates = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                    currentCell.fillAllCandidates();

                    // get filled in row and remove
                    for (int k = 0; k < Board.DIM; k++) {
                        if (k != j) {
                            if (board.getIJ(i, k).isFilled()) {
                                System.out.printf("Got filled [%d][%d] with value %d, remove candidate\n",
                                        i, k,
                                        board.getIJ(i, k).getValue());
                                currentCell.removeCandidate(board.getIJ(i, k).getValue());
                            }
                        }
                    }
                    // get filled in column and remove
                    for (int k = 0; k < Board.DIM; k++) {
                        if (k != i) {
                            if (board.getIJ(k, j).isFilled()) {
                                System.out.printf("Got filled [%d][%d] with value %d, remove candidate\n",
                                        k, j,
                                        board.getIJ(k, j).getValue());
                                currentCell.removeCandidate(board.getIJ(k, j).getValue());
                            }
                        }
                    }
                    // get filled in area 3 x 3
                    for (int k = 0; k < Board.DIM; k++) {
                        for (int l = 0; l < Board.DIM; l++) {
                            if (!(i == k && j == l)) {// not a current cell
                                // the same 3 x 3
                                if (board.getIJ(k, l).getThreeID() == currentCell.getThreeID()) {
                                    // and filled
                                    if (board.getIJ(k, l).isFilled()) {
                                        System.out.printf("3 x 3 - Got filled [%d][%d] with value %d, remove candidate\n",
                                                k, l,
                                                board.getIJ(k, l).getValue());
                                        currentCell.removeCandidate(board.getIJ(k, l).getValue());
                                    }
                                }
                            }
                        }
                    }
                    System.out.println();
                }
            }
        }
        System.out.println("=== Initial fill ends");
        return OperResultsEnum.OK;
    };

    /**
     * Lambda for fill alone candidates
     */
    static DoSomeThingFuncInterface fillAlone = (board) -> {
        Cell currentCell;
        int value;
        boolean smthFilled = false;
        System.out.println("=== Fill alone starts");
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                currentCell = board.getIJ(i, j);
                if (!currentCell.isFilled()) {
                    if (currentCell.getCandidates().size() == 1) {
                        value = currentCell.getCandidates().get(0);
                        System.out.printf("Filling [%d][%d] with value %d\n",
                                i, j, value);
                        smthFilled = true;
                        // set value
                        currentCell.setValue(value);
                        board.removeCandidateFromOthers(i, j, value);
                    }
                }
            }
        }
        System.out.println("=== Fill alone ends");
        return smthFilled ? OperResultsEnum.NEW_CELL_FILLED : OperResultsEnum.NOTHING_FILLED;
    };

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

    /**
     * Lambda for find pointer of pair in small square //TODO for cols
     */
    static DoSomeThingFuncInterface pointerPair = board -> {
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
                    // ROW
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
            for (Integer iCand:
                 cands) {
                entry.getKey().removeCandidate(iCand);
            }
        }

        System.out.println("=== Find Open Threes ends");
        return OperResultsEnum.OK;
    };

}
