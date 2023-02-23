package algorithms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class BubbleSortTest {

    private final int[] incoming;
    private final int[] expected;

    public BubbleSortTest(int[] incoming, int[] expected) {
        this.incoming = incoming;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: in:({0}), exp={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]
                {
                        {new int[]{1, 3, 2, 5, 4}, new int[]{1, 2, 3, 4, 5}},
                        {new int[]{1, 3, 2, 5, 4, 9, 8}, new int[]{1, 2, 3, 4, 5, 8, 9}},
                        {new int[]{}, new int[]{}}
                });
    }

    @Test
    public void test() {
        System.out.println("Incoming " + Arrays.toString(incoming));
        System.out.println("Expected " + Arrays.toString(expected));
        Assert.assertEquals(0, Arrays.compare(BubbleSort.bubbleSort(incoming), expected));
    }
}
