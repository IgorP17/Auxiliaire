package games.numbers;

import java.util.ArrayList;

public class NumbersBoard {

    private ArrayList<Cell> board;

    NumbersBoard(int state){
        switch (state){
            case 0:
                board = initBoardState0();
                break;
            case 1:
                System.out.println("Not implemented yet, use default");
                board = initBoardState0();
                break;
            default:
                System.out.println("No such state, init as 0");
                board = initBoardState0();
                break;
        }
    }


    /**
     * Print board - 9 items per row
     */
    public void printBoard(String msg) {
        System.out.println("Board(" + msg + ")");
        for (int i = 0; i < board.size(); i++) {
            System.out.print(board.get(i).getsValue());
            if ((i + 1) % 9 == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    /**
     * Process board
     */
    public void process() {
        for (int i = 0; i < board.size(); i++) {
            if (processSingle(i))
                i = 0; // drop index to 0 (searching from beginning)
        }
    }

    /**
     * Process single cell in board
     *
     * @param pos position
     * @return true if something founded, false otherwise
     */
    public boolean processSingle(int pos) {

        if (board.get(pos).isEmpty())
            return false;

        ArrayList<Integer> neighbors = getNeighborsIDs(pos);

        for (Integer neighbor : neighbors) {
            if ((board.get(pos).getValue() == board.get(neighbor).getValue()) ||
                    (10 == board.get(pos).getValue() + board.get(neighbor).getValue())) {
                board.get(pos).setEmpty();
                board.get(neighbor).setEmpty();
                return true;
            }
        }
        return false;
    }

    /**
     * Get neighbors
     *
     * @return ArrayList of id of neighbors
     */
    public ArrayList<Integer> getNeighborsIDs(int pos) {
        ArrayList<Integer> result = new ArrayList<>();

        int searching;

        // get right
        searching = pos + 1;
        while (searching < board.size()) {
            if (!board.get(searching).isEmpty()) {
                result.add(searching);
                break;
            }
            searching++;
        }

        // get down
        searching = pos + 9;
        while (searching < board.size()) {
            if (!board.get(searching).isEmpty()) {
                result.add(searching);
                break;
            }
            searching += 9;
        }

        // Вообще говоря, порядок анализа соседей может влиять на дальнейшее

        // В теории, если перезапускаем процесс поиска с 0, то достать левый или верхний не нужны

        // get left
        searching = pos - 1;
        while (searching >= 0) {
            if (!board.get(searching).isEmpty()) {
                result.add(searching);
                break;
            }
            searching--;
        }

        // get up
        searching = pos - 9;
        while (searching >= 0) {
            if (!board.get(searching).isEmpty()) {
                result.add(searching);
                break;
            }
            searching -= 9;
        }

        if (result.size() == 0) {
            System.out.println("!!! WARNING no neighbors");
            System.exit(1);
        }

        return result;
    }

    /**
     * Clone available cells
     */
    public void cloneAvailable() {
        ArrayList<Cell> additional = new ArrayList<>();

        for (Cell cell : board) {
            if (!cell.isEmpty())
                additional.add(new Cell(cell.getValue()));
        }
        board.addAll(additional);
    }

    /**
     * Check if all board filled
     *
     * @return true if all cells filled, false otherwise
     */
    public boolean isAllFilled() {
        for (Cell cell : board) {
            if (!cell.isEmpty())
                return false;
        }

        return true;
    }

    /**
     * Remove row witch all empty cells
     *
     */
    public void removeEmptyRow() {
        ArrayList<Cell> result = new ArrayList<>();

        for (int i = 0; i < board.size(); i = i + 9) {
            // row is full
            if ((i + 8) < board.size()) {
                // and not empty - add to results
                if (!board.get(i).isEmpty() || !board.get(i + 1).isEmpty() ||
                        !board.get(i + 2).isEmpty() || !board.get(i + 3).isEmpty() ||
                        !board.get(i + 4).isEmpty() || !board.get(i + 5).isEmpty() ||
                        !board.get(i + 6).isEmpty() || !board.get(i + 7).isEmpty() ||
                        !board.get(i + 8).isEmpty()) {
                    result.add(board.get(i));
                    result.add(board.get(i + 1));
                    result.add(board.get(i + 2));
                    result.add(board.get(i + 3));
                    result.add(board.get(i + 4));
                    result.add(board.get(i + 5));
                    result.add(board.get(i + 6));
                    result.add(board.get(i + 7));
                    result.add(board.get(i + 8));
                }
            } else { // row is not full - add as is
                for (int j = i; j < board.size(); j++) {
                    result.add(board.get(j));
                }
            }
        }
        board = new ArrayList<>(result);
    }

    /**
     * Init board as in game (first option)
     *
     * @return Board ArrayList<Cell>
     */
    private ArrayList<Cell> initBoardState0() {
        ArrayList<Cell> cells = new ArrayList<>();

        cells.add(new Cell(1));
        cells.add(new Cell(2));
        cells.add(new Cell(3));
        cells.add(new Cell(4));
        cells.add(new Cell(5));
        cells.add(new Cell(6));
        cells.add(new Cell(7));
        cells.add(new Cell(8));
        cells.add(new Cell(9));
        cells.add(new Cell(1));
        cells.add(new Cell(1));
        cells.add(new Cell(1));
        cells.add(new Cell(2));
        cells.add(new Cell(1));
        cells.add(new Cell(3));
        cells.add(new Cell(1));
        cells.add(new Cell(4));
        cells.add(new Cell(1));
        cells.add(new Cell(5));
        cells.add(new Cell(1));
        cells.add(new Cell(6));
        cells.add(new Cell(1));
        cells.add(new Cell(7));
        cells.add(new Cell(1));
        cells.add(new Cell(8));

        return cells;
    }

}
