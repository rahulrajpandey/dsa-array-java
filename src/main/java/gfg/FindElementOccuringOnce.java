package gfg;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement: Find element occurring once when all others are present thrice.
 * Given an array of integers arr[] of length N, every element appears thrice except for one which occurs once.
 * Find that element which occurs once.
 * <p>
 * Link: https://practice.geeksforgeeks.org/problems/find-element-occuring-once-when-all-other-are-present-thrice/1/?page=1&category[]=Arrays
 * <p>
 * Constraints:
 * Input: Unsorted array of signed integers
 * Input constraints: 1 <= size of Array <= 10^6 AND -10^9 ≤ array items ≤ 10^9
 * Output: Item with single occurrence in the array
 * Output constraints: Expected Time Complexity: O(N) and Expected Auxiliary Space: O(1)
 * <p>
 * Discussion and Solution:
 * <p>
 * Because the expected Time Complexity in the constraint is O(N), so we can not use outer loop and inner loop.
 * We must have to iterate only once over the array elements.
 * <p>
 * Approach: I have violated the Space Complexity constraint as it expects O(1) but I have used a map to hold key and its count.
 * Ideally, some sort of bitwise operations will be used to fulfill the expected space complexity.
 * Store all the key with its number of occurrences in a map and find the key that occurs only once.
 */

/**
 * Code Implementation
 */
public class FindElementOccuringOnce {
    /**
     * Input:
     * @param arr - array of integers
     * @param N - length of array
     *
     * Output:
     * @return int element that occurs only once in the array
     *
     * Operations:
     * - Create a HashMap
     * - Start iterating over array items
     * - Update the occurance of item in map
     * - Check for single occurance item in map
     * - Return the key
     */
    static int singleElement(int[] arr, int N) {
        Map<Integer, Integer> map = new HashMap<>(); // O(N) space
        for (int i = 0; i < N; i++) { // O(N)
            boolean check = map.containsKey(arr[i]);
            if (check) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }// for loop ends
        Map.Entry<Integer, Integer> result = map.entrySet().stream().filter(hmap -> hmap.getValue() == 1).findFirst().orElse(null);
        return result == null ? -1 : result.getKey();
    }
}
