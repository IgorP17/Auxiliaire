package games.sudoku;

public class Board {

    // Board 9 by 9
    static Cell[][] allField = new Cell[10][10];
    private String pathToFile;

    Board(String pathToFile){
        this.pathToFile = pathToFile;
    }



    // Getters setters
    public String getPathToFile() {
        return pathToFile;
    }
}
