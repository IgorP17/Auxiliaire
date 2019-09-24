package games.sudoku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Functional interface for manipulating with sudoku board
 */
interface DoSomeThingFunc {
    String func(Board board);
}


public class Solver {

    /**
     * Define method that will handle lambda (aka implements interface)
     *
     * @param doSomeThingFunc - lambda
     * @param board           - board
     * @return - as lambda return
     */
    static String process(DoSomeThingFunc doSomeThingFunc, Board board) {
        return doSomeThingFunc.func(board);
    }

    // Board
    private static Board board = new Board(
            "/home/igor/Projects/Java/Auxiliaire/src/games/sudoku/ex1.txt");

    public static void main(String[] args) {
        process(initObjectFromFile, board);
        process(printBoard, board);
    }

    /**
     * Lambda for initialisation board from file
     */
    static DoSomeThingFunc initObjectFromFile = (DoSomeThingFunc) -> {
        System.out.println("=== initObjectFromFile starts");
        // Try with resource
        try (BufferedReader br = new BufferedReader(new FileReader(board.getPathToFile()))) {
            String line = br.readLine();

            while (line != null) {
//                System.out.println(line);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception in lambda initObjectFromFile");
            e.printStackTrace();
        }

        System.out.println("=== initObjectFromFile ends");

        return "OK";
    };

    /**
     * Lambda for print board
     */
    static DoSomeThingFunc printBoard = (DoSomeThingFunc) -> {
        System.out.println("=== printBoard starts");
        System.out.println("=== printBoard ends");
        return "OK";
    };
}