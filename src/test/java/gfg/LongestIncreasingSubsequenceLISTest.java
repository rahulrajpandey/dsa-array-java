package gfg;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LongestIncreasingSubsequenceLISTest {
    // happy path or sunny day scenario
    @Test
    public void getLISCountTest() {
        Assert.assertEquals(6, LongestIncreasingSubsequenceLIS.getLISCount(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}));
    }

    // sad path or rainy day scenario
    @Test
    public void getLISCountTest2() {
        Assert.assertNotEquals(5, LongestIncreasingSubsequenceLIS.getLISCount(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}));
    }

    // happy path or sunny day scenario
    @Test
    public void getLISTest() {
        Assert.assertTrue(Arrays.equals(new Integer[]{10, 22, 33, 50, 60, 80}, LongestIncreasingSubsequenceLIS.getLIS(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80})));
    }

    // sad path or rainy day scenario
    @Test
    public void getLISTest2() {
        Assert.assertFalse(Arrays.equals(new Integer[]{10, 22, 33, 50, 60}, LongestIncreasingSubsequenceLIS.getLIS(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80})));
    }

    // happy path or sunny day scenario
    @Test
    public void getLISCountNLonNTest(){
        Assert.assertEquals(6, LongestIncreasingSubsequenceLIS.getLISCountNLonN(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}, 9));
    }
}
