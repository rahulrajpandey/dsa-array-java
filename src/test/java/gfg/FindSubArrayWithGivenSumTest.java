package gfg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FindSubArrayWithGivenSumTest {
    ArrayList<Integer> resultantList;
    ArrayList<Integer> resultListReceived;

    // runs before each test method
    @Before
    public void setup() {
        resultantList = new ArrayList<>();
    }

    // happy path or sunny day scenario
    @Test
    public void subarraySumTest() {
        // first test: When there exists a subarray
        resultantList.add(3);
        resultantList.add(4);
        resultListReceived = FindSubArrayWithGivenSum.subarraySum(new int[]{10, 5, 19, 13, 1}, 5, 32);
        Assert.assertEquals(resultantList, resultListReceived);
    }

    // sad path or rainy day scenario
    @Test
    public void subarraySumTest2() {
        // second test: When there does not exist a subarray
        resultantList.add(-1);
        resultListReceived = FindSubArrayWithGivenSum.subarraySum(new int[]{10, 5, 19, 13, 1}, 5, 0);
        Assert.assertEquals(resultantList, resultListReceived);
    }
}
