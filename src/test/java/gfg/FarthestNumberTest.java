package gfg;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FarthestNumberTest {
    int[] resultArray;

    // happy path or sunny day scenario
    @Test
    public void farNumberTest() {
        resultArray = new int[]{3, -1, 4, -1, -1};
        Assert.assertTrue(Arrays.equals(resultArray, FarthestNumber.farNumber(5, new int[]{3, 1, 5, 2, 4})));
    }

    // sad path or rainy day scenario
    @Test
    public void farNumberTest2() {
        resultArray = new int[]{1, -1, 4, -1, -1};
        Assert.assertFalse(Arrays.equals(resultArray, FarthestNumber.farNumber(5, new int[]{3, 1, 5, 2, 4})));
    }
}
