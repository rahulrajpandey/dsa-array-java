package gfg;

import java.util.ArrayList;
/**
 * Problem Statement: Given an unsorted array A of size N that contains only non-negative integers,
 * find a continuous sub-array which adds to a given number S.
 * In case of multiple subarrays, return the subarray which comes first on moving from left to right.
 * <p>
 * Link: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1/?page=1
 * <p>
 * Constraints:
 * Input: Unsorted array of positive integers
 * Input constraints: 1 <= size of Array <= 10^5 AND 1 <= Element of Array <= 10^9
 * Output: Subarray with given sum following Indexing start by 1, -1 otherwise
 * Output constraints: Expected Time Complexity: O(N) and Expected Auxiliary Space: O(1)
 * <p>
 * Discussion and Solution:
 * <p>
 * Because the expected Time Complexity in the constraint is O(N), so we can not use outer loop and inner loop.
 * We must have to iterate only once over the array elements.
 * <p>
 * Approach: using some sort of Sliding window concept.
 */

/**
 * Code Implementation
 */
public class FindSubArrayWithGivenSum {

    /**
     * Inputs:
     *
     * @param arr - array of unordered integers
     * @param n   - size of array
     * @param s   - required sum
     *
     * Output:
     * @return ArrayList of index positions of the subarray
     *
     * Operations:
     * Iterate over array elements
     * Hold the sum till current element in a variable
     * Check if the sum is greater than required sum,
     * If YES, start reducing the sum from the start index
     * Check if the sum is equal to the required sum,
     * If YES, set the start and end Index and break the iteration
     * return the Indexes in the List
     */
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> subArrayIndexes = new ArrayList<>();
        int startIndex = 0;
        int temporarySum = 0;

        // edge case: all elements of Array is positive integer >= 1
        if(s <= 0){
            subArrayIndexes.add(-1);
            return subArrayIndexes;
        }

        for (int counter = 0; counter < n; counter++) {
            temporarySum = temporarySum + arr[counter];

            while (temporarySum > s && startIndex <= counter) {
                temporarySum = temporarySum - arr[startIndex];
                startIndex++;
            }

            if (temporarySum == s) {
                subArrayIndexes.add(startIndex + 1);
                subArrayIndexes.add(counter + 1);
                return subArrayIndexes;
            }
        } // for loop ends

        // code reaches till this point, that means no subarray was found
        subArrayIndexes.add(-1);
        return subArrayIndexes;
    }
}

// Driver code to test is implemented in Junit: gfg.FindSubArrayWithGivenSumTest
