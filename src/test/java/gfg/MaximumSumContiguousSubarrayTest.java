package gfg;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSumContiguousSubarrayTest {
    @Test
    public void maxSubarraySumTest() {
        // sunny day scenario
        Assert.assertEquals(-1, MaximumSumContiguousSubarray.maxSubarraySum(new int[]{-1, -2, -4, -3}, 4));
    }

    @Test
    public void maxSubarraySumTest2() {
        // rainy day scenario
        Assert.assertNotEquals(-10, MaximumSumContiguousSubarray.maxSubarraySum(new int[]{-1, -2, -4, -3}, 4));
    }
}
