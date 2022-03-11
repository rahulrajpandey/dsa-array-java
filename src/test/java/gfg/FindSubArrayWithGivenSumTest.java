package gfg;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class FindSubArrayWithGivenSumTest {

    @Test
    public void subarraySumTest() {
        ArrayList<Integer> resultantList = new ArrayList<>();
        ArrayList<Integer> resultListReceived;

        // first test: When there exists a subarray
        resultantList.add(3);
        resultantList.add(4);
        resultListReceived = FindSubArrayWithGivenSum.subarraySum(new int[]{10, 5, 19, 13, 1}, 5, 32);
        Assert.assertEquals(resultantList, resultListReceived);

        // clear all the placeholders
        resultantList.clear();
        resultListReceived.clear();

        // second test: When there does not exist a subarray
        resultantList.add(-1);
        resultListReceived = FindSubArrayWithGivenSum.subarraySum(new int[]{10, 5, 19, 13, 1}, 5, 0);
        Assert.assertEquals(resultantList, resultListReceived);

        // clear all the placeholders
        resultantList.clear();
        resultListReceived.clear();
    }
}
