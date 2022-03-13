package gfg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class OverlappingIntervalsTest {
    OverlappingIntervals obj;
    int[][] Intervals;
    int[][] resultant;
    int[][] result;
    boolean equalsFlag;

    @Before
    public void setUp() {
        obj = new OverlappingIntervals();
        equalsFlag = true;
    }

    // happy path or sunny day scenario
    @Test
    public void overlappedIntervalTest() {
        Intervals = new int[][]{{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        resultant = new int[][]{{1, 4}, {6, 8}, {9, 10}};
        result = obj.overlappedInterval(Intervals);

        // Assert for equality of length of arrays
        Assert.assertEquals(resultant.length, result.length);

        // iterate to check for all the rows
        for (int i = 0; i < result.length; i++) {
            int[] resultRow = result[i];
            int[] resultantRow = resultant[i];
            if (!Arrays.equals(resultantRow, resultRow)) {
                equalsFlag = false;
                break;
            }
        } // for loop ends

        // Assert for equality of expected and result arrays
        Assert.assertEquals(true, equalsFlag);
    }

    // sad path or rainy day scenario
    @Test
    public void overlappedIntervalTest2() {
        Intervals = new int[][]{{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        resultant = new int[][]{{1, 4}, {6, 8}};
        result = obj.overlappedInterval(Intervals);

        // Assert for equality of length of arrays
        Assert.assertFalse(resultant.length == result.length);
    }

    // sad path or rainy day scenario
    @Test
    public void overlappedIntervalTest3() {
        Intervals = new int[][]{{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        resultant = new int[][]{{1, 4}, {6, 8}, {9, 11}};
        result = obj.overlappedInterval(Intervals);

        // Assert for equality of length of arrays
        Assert.assertEquals(resultant.length, result.length);

        // iterate to check for all the rows
        for (int i = 0; i < result.length; i++) {
            int[] resultRow = result[i];
            int[] resultantRow = resultant[i];
            if (!Arrays.equals(resultantRow, resultRow)) {
                equalsFlag = false;
                break;
            }
        } // for loop ends

        // Assert for equality of expected and result arrays
        Assert.assertTrue(!equalsFlag);
    }
}
