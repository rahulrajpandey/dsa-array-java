package gfg;

import org.junit.Assert;
import org.junit.Test;

public class CountSubarraysHavingSumInRangeTest {

    // happy path or sunny day scenario
    @Test
    public void countSubarrayTest() {
        Assert.assertEquals(6, CountSubarraysHavingSumInRange.countSubarray(4, new int[]{2, 3, 5, 8}, 4, 13));
    }

    // sad path or rainy day scenario
    @Test
    public void countSubarrayTest2() {
        Assert.assertNotEquals(5, CountSubarraysHavingSumInRange.countSubarray(4, new int[]{2, 3, 5, 8}, 4, 13));
    }
}
