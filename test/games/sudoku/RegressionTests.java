package games.sudoku;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

public class RegressionTests {

    private ArrayList<Board> boards = new ArrayList<>();

    @Test
    public void testRegress() {

    }

    // name = "{index}: {0} - test ID and first of readTests line
    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection<Object[]> data() {
        return readTests();
    }


    // TODO
    private static ArrayList<Object[]> readTests() {
        // This list contains Comment and Boards
        ArrayList<Object[]> result = new ArrayList<>();



        return result;
    }


}
