package games.sudoku;

import java.io.Serializable;
import java.util.ArrayList;

class Board implements Serializable {
    private static final long serialVersionUID = 7L;
    // Board 9 by 9
    final static int DIM = 9;
    private Cell[][] allField = new Cell[DIM][DIM];
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

    int getFilledCells(){
        int count = 0;
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                if (allField[i][j].isFilled()) count++;
            }
        }
        return count;
    }

    void removeCandidateFromOthers(int i, int j, int value){
        // remove value from other candidates
        for (int k = 0; k < Board.DIM; k++) {
            this.getIJ(k, j).removeCandidate(value);
        }
        for (int k = 0; k < Board.DIM; k++) {
            this.getIJ(i, k).removeCandidate(value);
        }
        int threeID = this.getIJ(i, j).getThreeID();
        for (int k = 0; k < Board.DIM; k++) {
            for (int l = 0; l < Board.DIM; l++) {
                if (!(i == k && j == l)){
                    if (this.getIJ(k, l).getThreeID() == threeID){
                        this.getIJ(k, l).removeCandidate(value);
                    }
                }
            }
        }
    }

    /**
     * Get all cells from small square except current
     * @param sI - current row
     * @param sJ - current col
     * @return - array list of cells
     */
    ArrayList<Cell> getTheSameSmallSquare(int sI, int sJ){
        ArrayList<Cell> result = new ArrayList<>();
        int smallSquareID = this.getIJ(sI, sJ).getThreeID();
        for (int i = 0; i < Board.DIM; i++) {
            for (int j = 0; j < Board.DIM; j++) {
                // if cell is the same square id
                if (smallSquareID == allField[i][j].getThreeID()){
                    // and not a current cell
                    if (!(i == sI && j == sJ)){
                        // add to result
                        result.add(allField[i][j]);
                    }
                }
            }
        }
        return result;
    }
}
