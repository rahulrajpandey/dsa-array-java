package gfg;
/**
 * Problem Statement: Given two Arrays A[] and B[] of length N and M respectively.
 * Find the minimum number of insertions and deletions on the array A[], required to make both the arrays identical.
 * Note: Array B[] is sorted and all its elements are distinct, operations can be performed at any index not necessarily at end.
 * <p>
 * Link: https://practice.geeksforgeeks.org/problems/minimum-insertions-to-make-two-arrays-equal/1/?page=1&difficulty[]=2&category[]=Arrays
 * <p>
 * Constraints:
 * Input: two Arrays A[] and B[] of length N and M respectively. B[] is sorted and contains distinct elements.
 * Input constraints: 1 ≤ Size of Arrays ≤ 10^5 AND 1 ≤ Items in Array ≤ 10^5
 * Output: minimum number of insertions and deletions on the array A[], required to make both the arrays identical.
 * Output constraints: Expected Time Complexity:  O(N*logN) and Expected Auxiliary Space: O(N)
 * <p>
 * Discussion and Solution:
 * <p>
 * From the problem, it is clear that B[] is sorted and contains distinct items only that means while matching for the
 * longest common subsequence, we can check for longest Increasing subsequence.
 * Deletion operation takes 1 cost, Insertion operation takes 1 cost, but replacing an item operation takes 2 cost.
 * <p>
 * Approach:
 * Step 1: Check for all the items in A[] that are not in B[] and delete from A[]. for each deletion, count cost.
 * Step 2: Then find LIS count in A[].
 * Step 3: Compute the final cost as:
 * Deletion Cost from Step 1 + Difference in LIS length and length of B[] i.e. Insertion Cost
 * + Difference in LIS Length and length of A[] obtained after step 1 i.e. Deletion Cost
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Code Implementation
 */
public class MinimumOpsToConvertArrAToB {

    /**
     * Objective: Find Minimum number of operations(Insertions or Deletions) performed on A[] to make it identical to B[]
     * Input:
     * @param A - array of integers
     * @param B - array of integers
     * @param N - size of A[]
     * @param M - size of B[]
     *
     * Output:
     * @return count or cost of operations
     *
     * Operations:
     * - Create a set of items in B[]
     * - Create a list tp hold items from A[]
     * - Iterate over A[]
     * - Check if current item in A[] is there in the set of B
     * - IF YES, add into the list
     * - IF NO, perform deletion i.e. add cost
     * - After the iteration is over, compute the LIS count for the list
     * - Finally compute the result:
     * - Cost of deletion from A[] + Cost of Deletion in the List + Cost of Insertion
     */
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        // convert B to a Set
        Set<Integer> bSet = new TreeSet<>();
        for(int item : B){
            bSet.add(item);
        }

        // search for elements of A[] in list of B[]
        // if item is found, add into a list for A[]
        int deleteCost = 0;
        List<Integer> aList = new ArrayList<>();
        for(int item : A){
            if(bSet.contains(item)){
                aList.add(item);
            }else{
                deleteCost += 1;
            }
        }

        // find LIS count for list of A
        Integer[] arrA = new Integer[aList.size()];
        int lenLIS = getLISCountNLonN(aList.toArray(arrA), aList.size());

        int deleteFromUpdatedListCost = aList.size() - lenLIS;
        int InsertionCost = bSet.size() - lenLIS;

        // compute the result
        return deleteCost + deleteFromUpdatedListCost + InsertionCost;
    }

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
    private static int CeilIndex(int A[], int l, int r, int key) {
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
    static int getLISCountNLonN(Integer A[], int size) {
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
}
