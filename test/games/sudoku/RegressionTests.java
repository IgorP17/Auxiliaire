package games.sudoku;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;



@RunWith(Parameterized.class)
public class RegressionTests {

    private static OperResultsEnum process(DoSomeThingFuncInterface doSomeThingFuncInterface, Board board) {
        return doSomeThingFuncInterface.func(board);
    }

    // this is for repeatable tests
    private String comment;
    private Board board;

    // this is constructor for each test
    public RegressionTests(String comment, Board board) {
        this.comment = comment;
        this.board = board;
    }

    // This will return set of data
    // name = "{index}: {0} - test ID and first of readTests line
    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection<Object[]> data() {
        return readTests();
    }

    @Test
    public void testRegress() {
        System.out.println("testRegress Comment = " + comment);
        System.out.println("testRegress Board = " + board);

    }

    // TODO - Reading boards and comments and return list of comments and boards inline
    private static ArrayList<Object[]> readTests() {
        // This list contains Comment and Boards
        ArrayList<Object[]> result = new ArrayList<>();

//        result.add(new Object[]{"1. ", null});

        try (BufferedReader br = new BufferedReader(new FileReader("test/games/sudoku/samples.txt"))) {
            String line = br.readLine();
            String comment = null;
            Board board = null;
            // new board
            // read line
            while (line != null) {
                // we have sample
                if (line.equals("=sample=")) {
                    // we need got sample
                    // got a comment
                    comment = (line = br.readLine());

                    // need read sample
                    line = br.readLine();
                    while (line != null){
                        System.out.println(line);

                        line = br.readLine();
                    }

//                    result.add(new Object[]{comment, board});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


}
