package gfg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class LongestCommonSubsequenceLCSTest {
    private String str1, str2;
    private char[] resultLCS;

    @Before
    public void setup() {
        str1 = "AGGTAB";
        str2 = "GXTXAYB";
        resultLCS = new char[]{'G', 'T', 'A', 'B'};
    }

    // happy path or sunny day scenario
    @Test
    public void getLCSLengthTest() {
        Assert.assertEquals(4, LongestCommonSubsequenceLCS.getLCSLength(str1.toCharArray(), str2.toCharArray()));
    }

    // sad path or rainy day scenario
    @Test
    public void getLCSLengthTest2() {
        Assert.assertNotEquals(3, LongestCommonSubsequenceLCS.getLCSLength(str1.toCharArray(), str2.toCharArray()));
    }

    // happy path or sunny day scenario
    @Test
    public void getLCSTest() {
        char[] res = LongestCommonSubsequenceLCS.getLCS(str1.toCharArray(), str2.toCharArray());
        Assert.assertTrue(Arrays.equals(resultLCS, res) && (resultLCS.length == res.length));
    }

    // happy path or sunny day scenario
    @Test
    public void testLCSFunctionality() {
        int len = LongestCommonSubsequenceLCS.getLCSLength(str1.toCharArray(), str2.toCharArray());
        char[] resArr = LongestCommonSubsequenceLCS.getLCS(str1.toCharArray(), str2.toCharArray());
        Assert.assertEquals(len, resArr.length);
    }

}
