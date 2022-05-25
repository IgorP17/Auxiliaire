package udemy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import udemy.core1.Udemy;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UdemyTest {

    private final int i1;
    private final int i2;
    private final int i3;
    private final String expected;

    public UdemyTest(int i1, int i2, int i3, String expected) {
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {1, 2, 3, "1st = 1"},
                {2, 2, 3, "1st and 2nd = 2"},
                {3, 4, 3, "1st and 3d = 3"},
                {5, 4, 6, "2nd = 4"},
                {5, 5, 6, "1st and 2nd = 5"},
                {7, 6, 6, "2nd and 3d = 6"},
                {9, 8, 7, "3d = 7"},
                {8, 9, 8, "1st and 3d = 8"},
                {10, 9, 9, "2nd and 3d = 9"},
                {10, 10, 10, "all eq = 10"}
        };
        return Arrays.asList(data);
    }

    @Test
    public void check() {
        System.out.printf("Checking min of %d %d %d, should be %s\n", i1, i2, i3, expected);
        Assert.assertEquals(expected, Udemy.min(i1, i2, i3));
    }

}
