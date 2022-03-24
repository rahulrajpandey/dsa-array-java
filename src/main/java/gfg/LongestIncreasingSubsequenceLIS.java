package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Longest Increasing Subsequence: longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order.
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * <p>
 * It looks intuitive to think about this in terms of similar sub-problem because if we need to find the length or last element of LIS,
 * we must know the prior element. The same applies for any element, know the prior subsequence and add current element to it.
 * <p>
 * Optimal Substructure:
 * Let arr[0 . . n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i] is the last element of the LIS.
 * Then, L(i) can be recursively written as:
 * - L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
 * - L(i) = 1, if no such j exists.
 * To find the LIS for a given array, we need to return max(L(i)) where 0 < i < n.
 * <p>
 * It can also be observed that if we are solving for let's say arr[5], we have to compute arr[1], arr[2], arr[3], arr[4] and
 * while solving for arr[4], arr[1], arr[2] and arr[3] will be computed again. It would be better to store the computations in some table,
 * to faster the execution and also refrain from recomputing.
 * <p>
 * So we can say, it is a Dynamic Programming problem.
 */
public class LongestIncreasingSubsequenceLIS {

    /**
     * Objective: To find a suitable index in array to place Key
     * Input:
     * @param A   - array of integers
     * @param l   - left index in A[]
     * @param r   - right index in A[]
     * @param key - item to be placed in A[]
     *
     * Output:
     * @return the index where key can be placed in A[]
     *
     * Operations:
     * - Iterate while left pointer does not pass over right pointer
     * - Find middle index between left and right indices
     * - Check if the middle element is greater than or equal to key
     * - If YES, search in the left half
     * - If NO, search in the right half
     * - Finally return the suitable index
     */
    static int CeilIndex(int A[], int l, int r, int key) {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }
        return r;
    }

    /**
     * Objective: Find the Longest Increasing Subsequence in A[]
     *
     * Input:
     * @param A    - array of integers
     * @param size - length of A[]
     *
     * Output:
     * @return Longest Increasing Subsequence(LIS) count in A[]
     *
     * Operations:
     * - Create an array tailTable to store LIS of input array A
     * - Initialize tailTable with the A[0]
     * - Set the Number of Items i.e. len in the tailTable to be 1
     * - Iterate over A[] from Index 1
     * - Check
     * - If current element of A[] is less than tailTable[0], then update tailTable[0] with current element of A[]
     * - Else If, current element of A[] is greater than tailTable's last element,
     * - then update tailTable's last element with current element of A[] and also increment len to hold number of items
     * - Else If, current element of A[] is neither greater than tailTable's last element nor smaller than the first element of tailTable
     * - then find a suitable index in tailTable[] for placing the current element of A[]
     * - and then insert the current element of A[] at that found index in tailTable[]
     * - Finally, return the length of items in tailTable[] i.e. len
     */
    static int getLISCountNLonN(int A[], int size) {
        // boundary condition
        if (size < 1) {
            return 0;
        }
        // array to hold LIS elements
        int[] tailTable = new int[size];
        tailTable[0] = A[0];
        int len = 1; // Number of items in tailTable

        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0]) {
                // new smallest value
                tailTable[0] = A[i];
            } else if (A[i] > tailTable[len - 1]) {
                // A[i] wants to extend the largest subsequence
                tailTable[len++] = A[i];
            } else {
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
            }
        }
        // return count of items in tailTable[]
        return len;
    }

    /**
     * @param arr - array of unsorted Integers
     * @return count of LIS
     * <p>
     * Operations:
     * - Create a table to hold the LIS count and fill with 1 for all the indices
     * - Start iterating over array elements, for each element, iterate from first index to that index -1
     * - Check for (arr[j] < arr[i]) and (LIS count till i < LIS count till j + 1)
     * - update the LIS counter
     * - find max from the table and return
     */
    static int getLISCount(int[] arr) {
        int[] table = new int[arr.length]; // O(n) space
        Arrays.fill(table, 1); // O(n)

        // compute the result and store in a table
        for (int i = 0; i < arr.length; i++) { // O(n)
            for (int j = 0; j < i; j++) {      // O (n)
                if (arr[j] < arr[i] && table[i] < (table[j] + 1)) {
                    table[i] += 1;
                }
            }
        }
        // O(n^2) time for this nested loop

        // return the max length
        return Arrays.stream(table).max().getAsInt(); // O(n)
    }

    /**
     * @param arr - array of unsorted integers
     * @return array of maximum length Increasing Subsequence
     * <p>
     * Operations:
     * - Create a table to hold the LIS count and fill with 1 for all the indices
     * - Create a list to hold the LIS result and add the first array element into it - lisList
     * - Create a list to hold LIS in current iteration - tempLisList
     * - Outer Loop: Start iterating over array elements,
     * - Inner Loop: for each element, iterate from first index to that index -1
     * - Check for arr[j] < arr[i] and also LIS count till i
     * - If Check Pass: Update the LIS counter in the table and add the current item in tempLisList
     * - Once Inner Loop is over, add the end element in the list
     * - Compare the length of lisList and tempLisList and update the lisList if current iteration list is bigger in length
     * - Clear teh current iteration list
     * - Once Outer Loop is over, return integer array from the resultList
     */
    static Integer[] getLIS(int[] arr) {
        int[] table = new int[arr.length]; // O(n) space
        Arrays.fill(table, 1); // O(n)

        List<Integer> lisList = new ArrayList<>();
        List<Integer> tempLisList = new ArrayList<>();
        lisList.add(arr[0]);

        // compute the result and store in a table
        for (int i = 0; i < arr.length; i++) { // O(n)
            for (int j = 0; j < i; j++) {      // O (n)
                if (arr[j] < arr[i] && table[i] < (table[j] + 1)) {
                    table[i] += 1;
                    tempLisList.add(arr[j]);
                }
            }

            tempLisList.add(arr[i]); // add the end element in the list

            // list operations for bigger list
            if (tempLisList.size() > lisList.size()) {
                lisList.clear();
                lisList.addAll(tempLisList);
            }

            tempLisList.clear(); // clear the current iteration list

        }  // O(n^2) time for this nested loop

        Integer[] result = lisList.toArray(new Integer[0]);
        return result;
    }
}
