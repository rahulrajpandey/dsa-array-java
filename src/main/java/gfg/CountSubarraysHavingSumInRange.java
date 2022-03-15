package gfg;

/**
 * Problem Statement: Count the number of subarrays.
 * Given an array A[] of N integers and a range(L, R).
 * The task is to find the number of subarrays having sum in the range L to R (inclusive).
 * <p>
 * Link: https://practice.geeksforgeeks.org/problems/count-the-number-of-subarrays/1/?page=1&category[]=Arrays
 * <p>
 * Constraints:
 * Input: Unsorted array of unsigned integers
 * Input constraints: 1 <= size of Array <= 10^6, -1 ≤ array items ≤ 10^9 AND 1 ≤ L ≤ R ≤ 1015
 * Output: Count of subarrays whose sum falls in the range [L,R]
 * Output constraints: Expected Time Complexity: O(N) and Expected Auxiliary Space: O(1)
 * <p>
 * Discussion and Solution:
 * <p>
 * In my observation, it's not possible to compute th result in O(N) time. It will take atleast O(NlogN) time.
 * Its kind of Sliding Window problem but needs little modification.
 * The approach in this solution might not be pretty intuitive at first.
 * <p>
 * Approach: I have violated the Time Complexity constraint.
 * We are given Lower limit and Upper Limit of the required range.
 * Using Sliding Window concept to find subArrays with sum <= Upper limit will give all the possible subArrays that sums less than upper limit.
 * Use the above technique to find all the subArrays with sum <= Lower Limit - 1.
 * Now we have some duplicate counts of subArrays as the second result is already there in the first result, so subtract that.
 */

/**
 * Code Implementation
 */
public class CountSubarraysHavingSumInRange {

    /**
     * Input:
     * @param N - length of array
     * @param A - array of unsigned integers
     * @param L - lower limit of range
     * @param R - Upper limit of range
     *
     * Output:
     * @return count of all sub-arrays whose sum lies in [L,R]
     */
    static long countSubarray(int N, int A[], long L, long R) {
        return helper(N, A, R) - helper(N, A, L - 1);
    }

    /**
     * Input:
     * @param N - length of array
     * @param A - array of positive integers
     * @param sum - upper limit of sum for a range
     *
     * Output:
     * @return number of Sub-arrays that sums <= sum
     *
     * Operations:
     * - Implement Sliding Window concept for Sum matching
     * - Start iterating over array elements
     * - Add the current element to SubArraySum till this index
     * - Check if SubArraySum exceeds the given limit
     * - If YES, start decrementing the SubArraySum from initial entry
     *      until SubArraySum becomes less than given limit
     * - Update the counter
     */
    static long helper(int N, int[] A, long sum) {
        long count = 0L;
        long subArraySum = 0L;
        int subArraySumStartIndex = 0;
        for (int currentIndex = 0; currentIndex < N; currentIndex++) {
            subArraySum += A[currentIndex];
            while (subArraySum > sum) {
                subArraySum -= A[subArraySumStartIndex++];
            }
            count += currentIndex - subArraySumStartIndex + 1;
        }

        return count;
    }
}
