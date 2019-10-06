package games.sudoku;

class Board {

    // Board 9 by 9
    final static int DIM = 9;
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
}
