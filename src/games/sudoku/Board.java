package games.sudoku;

public class Board {

    // Board 9 by 9
    public final static int DIM = 9;
    private static Cell[][] allField = new Cell[DIM][DIM];
    private String pathToFile;

    /**
     * Constructor
     * @param pathToFile - file to read sudoku
     */
    Board(String pathToFile){
        this.pathToFile = pathToFile;
    }



    // Getters setters
    String getPathToFile() {
        return pathToFile;
    }

    void setIJ(int i, int j, Cell cell){
        allField[i][j] = cell;
    }

    Cell getIJ(int i, int j){
        return allField[i][j];
    }
}
