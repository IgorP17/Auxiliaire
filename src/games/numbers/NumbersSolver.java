package games.numbers;

import java.util.ArrayList;

public class NumbersSolver {

    private static final ArrayList<Cell> board = initBoard();

    public static void main(String[] args) {

        printBoard();

        process();

        printBoard();

    }


    /**
     * Process board
     */
    private static void process(){
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
    private static boolean processSingle(int pos) {

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
    private static ArrayList<Integer> getNeighborsIDs(int pos) {
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

        // Вообще говоря, порядок анализа соседей может влиять на дальнейшее (TODO - рекурсивный метод для анализа максимальной полезности?)

        // В теории, если перезапускаем процесс поиска с 0, то достать левый или нижний не нужны

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
     * Print board - 9 items per row
     */
    private static void printBoard() {
        System.out.println("Board:");
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
     * Init board as in game
     *
     * @return Board ArrayList<Cell>
     */
    private static ArrayList<Cell> initBoard() {
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
