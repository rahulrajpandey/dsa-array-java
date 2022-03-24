package gfg;

import org.junit.Assert;
import org.junit.Test;

public class MinimumOpsToConvertArrAToBTest {
    // sunny day scenario or happy path
    @Test
    public void minInsAndDelTest(){
        int[] A = {1, 2, 5, 3, 1};
        int[] B = {1, 3, 5};
        Assert.assertEquals(4, MinimumOpsToConvertArrAToB.minInsAndDel(A, B, 5, 3));
    }

    // rainy day scenario or sad path
    @Test
    public void minInsAndDelTest2(){
        int[] A = {1, 2, 5, 3, 1};
        int[] B = {1, 3, 5};
        Assert.assertNotEquals(5, MinimumOpsToConvertArrAToB.minInsAndDel(A, B, 5, 3));
    }
}
