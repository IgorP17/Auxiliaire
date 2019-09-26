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
            "./src/games/sudoku/ex1.txt");

    public static void main(String[] args) {
        process(initObjectFromFile, board);
        process(printBoard, board);
    }

    /**
     * Lambda for initialisation board from file
     */
    static DoSomeThingFunc initObjectFromFile = (DoSomeThingFunc) -> {
//        System.out.println("=== initObjectFromFile starts");
        // Try with resource
        int j = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(board.getPathToFile()))) {
            String line = br.readLine();
            while (line != null) {
                line = line.trim().replace(" ", "");

                if (!line.isEmpty()) {
                    String[] vals = line.split(";");
                    if (vals.length != 9) {
                        throw new RuntimeException("Ellegal numbers of input string!");
                    }
                    for (int i = 0; i < 9; i++) {
                        Cell cell;
                        if ("_".equals(vals[i])) {
                            cell = new Cell(false, null);
                        } else {
                            cell = new Cell(true, Integer.parseInt(vals[i]));
                        }
                        board.setIJ(i, j, cell);
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

//        System.out.println("=== initObjectFromFile ends");

        return "OK";
    };

    /**
     * Lambda for print board
     */
    static DoSomeThingFunc printBoard = (DoSomeThingFunc) -> {
        System.out.println("-------------------------------------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                System.out.print("| " +
                        (board.getIJ(i, j).getValue() == null
                                ? "_"
                                : board.getIJ(i, j).getValue())
                        + " ");
            }
            System.out.println("|");
        }
//        System.out.println("=== printBoard ends");
        return "OK";
    };

    /**
     * Lambda for print state
     */
    static DoSomeThingFunc printState = (DoSomeThingFunc) -> {
      return "OK";
    };
}