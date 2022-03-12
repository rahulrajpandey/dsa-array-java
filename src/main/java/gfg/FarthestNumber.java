package gfg;

/**
 * Problem Statement: Given an array Arr[] of size N. For every element in the array, the task is to find
 * the index of the farthest element in the array to the right which is smaller than the current element.
 * If no such number exists then print -1.
 * <p>
 * Link: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1/?page=1
 * <p>
 * Constraints:
 * Input: Unsorted array of whole numbers
 * Input constraints: 1 ≤ Size of Array ≤ 1e5 AND 0 ≤ Array Elements ≤ 1e9
 * Output: array of farthest element to the right for every element of the array
 * Output constraints: Expected Time Complexity:  O(N*logN) and Expected Auxiliary Space: O(N)
 * <p>
 * Discussion and Solution:
 * <p>
 * From the problem, it is obvious that we must have to keep a pointer from end of the Array in order to get the farthest element.
 * Also, the last element will always have -1 as the output because there is no element after that.
 * Iterate over the array elements and check for the farthest smallest element using the last pointer.
 * <p>
 * Approach:
 * Iterate over array elements from first to second last.
 * For each element check the farthest element.
 */

/**
 * Code Implementation
 */
public class FarthestNumber {

    /**
     * Input:
     * @param N - size of array
     * @param Arr - array of whole numbers
     *
     * Output:
     * @return array of farthest positions
     *
     * Operations:
     * - Declare the result array
     * - Iterate over elements from 0 index to N-2 index
     * - Initialize lastIndex for each iteration and also a flag set to false
     * - For current element, check the farthest element which is less than current element
     * - If found, update the result array with the lastIndex at which the smaller element was found
     * - If Not found, update the result array with -1
     * - return the result array
     */
    static int[] farNumber(int N, int Arr[]) {
        int[] resultArray = new int[N];
        resultArray[N - 1] = -1;

        for (int i = 0; i <= N - 2; i++) {   // O(N)
            int lastIndex = N - 1;
            boolean flag = false;
            while (lastIndex > i) {         // O(log N)
                if (Arr[lastIndex] < Arr[i]) {
                    resultArray[i] = lastIndex;
                    flag = true;
                    break;
                }
                lastIndex--;
            } // while loop ends

            if (!flag) {
                resultArray[i] = -1;
            }

        } // for loop ends

        // return the result array
        return resultArray;
    }
}
