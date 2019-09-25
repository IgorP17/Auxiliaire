package games.sudoku;

public class Board {

    // Board 9 by 9
    private static Cell[][] allField = new Cell[10][10];
    private String pathToFile;

    Board(String pathToFile){
        this.pathToFile = pathToFile;
    }



    // Getters setters
    public String getPathToFile() {
        return pathToFile;
    }

    public void setIJ(int i, int j, Cell cell){
        allField[i][j] = cell;
    }

    public Cell getIJ(int i, int j){
        return allField[i][j];
    }
}
