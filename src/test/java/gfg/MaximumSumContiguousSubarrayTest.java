package gfg;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSumContiguousSubarrayTest {
    // happy path or sunny day scenario
    @Test
    public void maxSubarraySumTest() {
        Assert.assertEquals(-1, MaximumSumContiguousSubarray.maxSubarraySum(new int[]{-1, -2, -4, -3}, 4));
    }

    // sad path or rainy day scenario
    @Test
    public void maxSubarraySumTest2() {
        Assert.assertNotEquals(-10, MaximumSumContiguousSubarray.maxSubarraySum(new int[]{-1, -2, -4, -3}, 4));
    }
}
