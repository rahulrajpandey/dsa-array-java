package gfg;

import org.junit.Assert;
import org.junit.Test;

public class MinimumAxorXTest {
    // sunny day scenario or happy path
    @Test
    public void minValTest() {
        Assert.assertEquals(3, MinimumAxorX.minVal(3, 5));
    }

    // rainy day scenario or sad path
    @Test
    public void minValTest2() {
        Assert.assertNotEquals(4, MinimumAxorX.minVal(3, 5));
    }
}
