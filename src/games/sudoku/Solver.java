package games.sudoku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solver {

    private static Cell[][] board = new Cell[9][9];

    public static void main(String[] args) {
        readFile("/home/igor/Projects/Java/Auxiliaire/src/games/sudoku/sample.txt");


    }

    /**
     * Read and create board
     * @param pathToFile
     * @return
     */
    private static Cell[][] readFile(String pathToFile){

        try(BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception in readFile");
            e.printStackTrace();
        }
        return new Cell[0][];
    }
}
