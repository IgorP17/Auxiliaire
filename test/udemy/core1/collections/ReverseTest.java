package udemy.core1.collections;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class ReverseTest {

    private final long incoming;
    private final long expected;

    public ReverseTest(long incoming, long expected) {
        this.incoming = incoming;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: in:({0}), exp={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]
                {
                        {0, 0},
                        {5, 5},
                        {-1, -1},
                        {-5544, -4455},
                        {123_456_789, 987_654_321},
                        {-987_654_321, -123_456_789},
                        {1_230_456_789, 9_876_540_321L}
                });
    }

    @Test
    public void test() {
        Assert.assertEquals(HWS_6_Sets.dz6_8(incoming), expected);
    }
}
