package gfg;

import org.junit.Assert;
import org.junit.Test;

public class FindElementOccuringOnceTest {
    // happy path or sunny day scenario
    @Test
    public void singleElementTest() {
        int result = 10;
        Assert.assertEquals(result, FindElementOccuringOnce.singleElement(new int[]{1, 10, 1, 1}, 4));
    }

    // sad path or rainy day scenario
    @Test
    public void singleElementTest2() {
        int result = 11;
        Assert.assertTrue(result != FindElementOccuringOnce.singleElement(new int[]{1, 10, 1, 1}, 4));
    }
}
