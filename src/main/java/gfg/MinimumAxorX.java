package gfg;

/**
 * Problem Statement: Given two integers A and B, the task is to find an integer X such that (X XOR A) is minimum possible
 * and the count of set bit in X is equal to the count of set bits in B.
 * <p>
 * Link: https://practice.geeksforgeeks.org/problems/x-xor-a-is-minimum-and-set-bits-in-x-b/1/?page=1&difficulty[]=2&category[]=Arrays
 * <p>
 * Constraints:
 * Input: Two positive integers
 * Input constraints: 1 ≤ Input numbers ≤ 1e9
 * Output: find an integer X such that (X XOR A) is minimum possible and the count of set bits in X is equal to the count of set bits in B.
 * Output constraints: Expected Time Complexity:  O(log N) and Expected Auxiliary Space: O(1)
 * <p>
 * Discussion and Solution:
 * <p>
 * We need to have some mechanism to get the count of set bits, in this we can use either Java's build-in Integer.bitCount or Brian Kernighan'a algo.
 * Also, if the count of set bits in both the input number are same, then `a` is the required ans, as a XOR a will be 0 and bits count is also equal.
 * Otherwise, we have to create a number that has all the bits set count as second input number and gives minimum possible XOR with first input.
 * <p>
 * Approach:
 * Check if the count of bits set in both the input numbers are same, then return first number.
 * Else, Start with number 0 as the answer.
 * Start checking from the MSB in first input and add set bits of input in ans as well.
 * Once done, check if the count of set bits in ans is equal to the count of set bits in second input.
 * If yes, then we are done and we have the ans.
 * If no, then the task is to keep the ans as the smallest possible number,
 * so start setting LSB bits to 1 where it is 0 in ans, till the count of set bits in ans is equal to count of set bits in second input
 */

/**
 * Code Implementation
 */
public class MinimumAxorX {

    /**
     * Objective: To find number of set bits in an integer
     * Input:
     * @param number - input integer
     *
     * Output:
     * @return number of bits set in the input integer
     *
     * Operations:
     * - Algorithm: Brian Kernighan's algorithm to find set bits count
     * - Subtracting 1 from a decimal number flips all the bits after the rightmost set bit including the rightmost set bit.
     * - If we subtract a number by 1 and do it bitwise & with itself (n & (n-1)), we unset the rightmost set bit.
     * - If we do n & (n-1) in a loop and count the number of times the loop executes, we get the set bit count.
     * - Alternatively, in Java, Integer.bitCount() also finds number of set bits in a number.
     */
    private static int getSetBitCount(int number) { // O(log n)
        int count = 0;
        while (number > 0) {
            number &= (number - 1);
            count++;
        }
        return count;
    }

    /**
     * Objective: To find a positive number X such that X XOR a is minimum possible and also set bits count in X and b are equal.
     *
     * Input:
     * @param a - positive integer number
     * @param b - positive integer number
     *
     * Output:
     * @return an integer X such that (X XOR a) is minimum possible and the count of set bits in X is equal to the count of set bits in b.
     *
     * Operations:
     * - Find the count of Set Bits in a and b.
     * - Check if the two counts are equal, then return `a` as the result.
     * - Declare result variable `ans` and initialize with 0
     * - Start Loop: Start traversing from MSB to LSB in `a`
     * - Create a mask of only ith bit set
     * - Do bitwise AND of mask and `a` and check if it results in a number greater than 0
     * - IF YES, then also check if count of set bits in `b` is greater than 0
     * - IF YES, then set this bit in `ans` and decrement count of set bits in `b`
     * - End Loop
     * - At this stage, number of set bits in `a` is equal to number of set bits in `ans`
     * - Check if the count of set bits in `b` is 0
     * - i.e. if `ans` is the required number with same number of set bits in `b` and giving minimum possible XOR with `a`
     * - If NO, then
     * - Start Loop: Start traversing from LSB to MSB in `ans`
     * - Create a mask of only ith bit set
     * - Do bitwise AND of mask and `ans` and check if result is 0
     * - If YES, then also check if count of set bits in `b` is greater than 0
     * - IF YES, then set this bit in `ans` and decrement count of set bits in `b`
     * - End Loop
     * - return the `ans`
     */
    public static int minVal(int a, int b) {

        // find the set bits count in both the input number
        int setBitsInB = getSetBitCount(b);
        int setBitsInA = getSetBitCount(a);

        // if set bits count in both the numbers is same,
        // then A is the answer as it will only have the smallest possible XOR with itself
        if (setBitsInA == setBitsInB) {
            return a;
        }

        // declare a variable ans to XOR a with
        int ans = 0;

        // Java stores Integer using 32 bits of memory
        for (int i = 31; i >= 0; i--) { // MSB For Loop starts
            // create a mask to do bitwise AND with a and check if ith bit is set
            int mask = 1 << i;
            if ((a & mask) > 0 && setBitsInB > 0) {
                setBitsInB--;
                ans |= mask;
            }
        } // MSB For Loop ends

        // if set bits in ans and set bits in b are equal
        if (setBitsInB == 0) {
            return ans;
        }

        // start adding set bits from LSB in order to maintain `ans` as the least possible number
        for (int i = 0; i < 32; i++) { // LSB For Loop Starts
            int mask = 1 << i;
            if ((ans & mask) == 0 && setBitsInB > 0) {
                setBitsInB--;
                ans |= mask;
            }
            if (setBitsInB == 0) {
                break;
            }
        } // LSB For Loop ends

        // return the answer
        return ans;
    }
}
