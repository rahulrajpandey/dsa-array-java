package gfg;

/**
 * Problem Statement: Given an array Arr[] of N integers.
 * Find the contiguous sub-array(containing at least one number) which has the maximum sum and return that sum.
 * <p>
 * Link: https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1/?page=1&category[]=Arrays
 * <p>
 * Constraints:
 * Input: Array of signed integers.
 * Input Constraint: 1 ≤ Size of Array ≤ 10^6 AND -10^7 ≤ Array Elements ≤ 10^7
 * Output: Maximum Sum in the Contiguous Subarray
 * Output Constraint: Expected Time Complexity: O(N) AND Expected Auxiliary Space: O(1)
 * <p>
 * Discussion and Solution:
 * Because the expected Time Complexity is O(N) and Space Complexity is O(1),
 * in this scenario, Kadane's Algorithm best fits here.
 * <p>
 * Kadane's Algorithm Discussion:
 * The idea of Kadane’s algorithm is to maintain a maximum subarray sum ending at every index ‘i’ of the given array
 * and update the maximum sum obtained by comparing it with the maximum sum of the subarray ending at every index ‘i’.
 * <p>
 * At any given index ‘i’ of the array, we have 2 choices, we can either:
 * - Append the element at index ‘i’ to the maximum sum subarray(so just add the element at index ‘i’ to the maximum found so far).
 * - Start a new subarray starting from index ‘i’.
 * <p>
 * Appending an element at index ‘i’ to the maximum sum subarray obtained so far is beneficial if the sum till index ‘i-1’ is non-negative,
 * otherwise it is better to start a new subarray starting from index ‘i’ and update the maximum sum obtained accordingly.
 */

/**
 * Code Implementation
 */
public class MaximumSumContiguousSubarray {
    /**
     * Inputs:
     *
     * @param arr - array of signed integers
     * @param n - length of array elements
     *
     * Output:
     * @return maximum sum in contiguous subarray in arr
     *
     * Operations:
     * - Initialize maximumSum and sumTillCurrentItem with the first element of arr
     * - Start iterating over array elements from index 1
     * - for every element in the array, check (current element + sumTillCurrentItem) with (current element)
     * - Update the sumTillCurrentItem with the maximum of last operation
     * - Check if maximumSum is less than sumTillCurrentItem, then update maximumSum with sumTillCurrentItem.
     *
     */
    static long maxSubarraySum(int arr[], int n) {
        long maximumSum = arr[0];
        int sumTillCurrentItem = arr[0];
        for (int counter = 1; counter < n; counter++) {
            sumTillCurrentItem = Math.max(arr[counter], sumTillCurrentItem + arr[counter]);
            if (maximumSum < sumTillCurrentItem) {
                maximumSum = sumTillCurrentItem;
            }
        }
        return maximumSum;
    }
}
