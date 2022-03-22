package gfg;

/**
 * Longest Common Subsequence (LCS): Given two sequences, find the length of the longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 * <p>
 * It is a classic computer science problem,
 * the basis of diff (a file comparison program that outputs the differences between two files),
 * and has applications in bioinformatics.
 * <p>
 * For example:
 * - LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * - LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * <p>
 * Solutions Discussion:
 * 1. The naive solution for this problem is to generate all subsequences of both given sequences and find the longest matching subsequence.
 * This solution is exponential in terms of time complexity.
 * 2. Using Dynamic Programming
 * - Optimal Substructure
 * For ex: Let the input sequences be X[0..m-1] and Y[0..n-1] of lengths m and n respectively.
 * And let L(X[0..m-1], Y[0..n-1]) be the length of LCS of the two sequences X and Y.
 * If last characters of both sequences match (or X[m-1] == Y[n-1]) then
 * L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])
 * <p>
 * If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
 * L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2]) )
 * <p>
 * - Overlapping Subproblems
 * For ex:
 *              lcs("AXYT", "AYZX")
 *              /               \
 * lcs("AXY", "AYZX")           lcs("AXYT", "AYZ")
 * ----
 * If we draw the complete recursion tree, then we can see that there are many sub-problems which are solved again and again.
 * So this problem has Overlapping Substructure property and recomputation of same subproblems can be avoided by either
 * using Memoization (Top-Down) or Tabulation (Bottom-Up).
 *
 * Solution Discussion:
 * - The core of this problem is to create a table that contains LCS count
 * - Once we have the LCS counter table, return the last cell as the max length of LCS
 * - Once we have the LCS counter table, we can trace the elements of LCS starting from the last cell
 */

/**
 * Code Implementation
 */
public class LongestCommonSubsequenceLCS {
    /**
     * Objective: To find LCS Counter Table
     * Input:
     * @param str1 - character array
     * @param str2 - character array
     *
     * Output:
     * @return 2D integer array that contains LCS for all the indices of input arrays
     *
     * Operations:
     * - Declare a 2D array of size > array sizes, any array length can become row and column
     * - For every element of One Array, Iterate for all the elements of other Array i.e. nested loop
     * - Set the first row and first column to 0
     * - Check if elements from both the array is same
     * - IF YES, update the table counter with 1 + previous diagonal cell's value
     * - IF NO, update the table counter with Maximum of left and upper cell's value
     * - After iteration finishes, return the table
     */
    private static int[][] getLcsCountTable(char[] str1, char[] str2){
        int[][] table = new int[str1.length + 1][str2.length + 1]; // O(m*n) space, IF m == n then O(n^2)
        for (int row = 0; row <= str1.length; row++) { // O(m)
            for (int col = 0; col <= str2.length; col++) { // O(n)
                // fill first row and first column with 0
                if (row == 0 || col == 0) {
                    table[row][col] = 0;
                } else if (str1[row - 1] == str2[col - 1]) {
                    table[row][col] = 1 + table[row - 1][col - 1]; // update with 1+prev diagonal value
                } else {
                    table[row][col] = Math.max(table[row][col - 1], table[row - 1][col]); // update with upper or left cell value
                }
            }
        } // O(m*n), IF m == n then O(n^2)
        return table;
    }

    /**
     * Objective: Get the LCS Count from two given Character arrays
     * Input:
     * @param str1 - first character array
     * @param str2 - second character array
     *
     * Output:
     * @return integer value of maximum length
     *
     * Operations:
     * - Get the Counter table
     * - Return the last cell from the table
     */
    static int getLCSLength(char[] str1, char[] str2) {
        int[][] table = getLcsCountTable(str1, str2);
        return table[str1.length][str2.length];
    }

    /**
     * Objective: Find the LCS character array from two given character array
     * Input:
     * @param str1 - first character array
     * @param str2 - second character array
     *
     * Output:
     * @return character array of LCS
     *
     * Operations:
     * - Get the counter table
     * - Declare the Lcs character array with maximum length of LCS i.e. the last cell in the table
     * - Declare the iteration counters for both the input character array with their lengths
     * - start traversing from last cell in the counter table till the iteration counters are greater than 0
     * - check if characters in both array are same
     * - If YES, add the character into the LCS character array and move up in the counter table diagonally
     * - If NO, then
     * - check if left cell value is greater than upper cell value, then move up one row
     * - Else, move left one column
     * - After the iteration is done, return the LCS character array
     */
    static char[] getLCS(char[] str1, char[] str2) {
        int[][] table = getLcsCountTable(str1, str2);

        int maxLen = table[str1.length][str2.length];
        char[] lcsArray = new char[maxLen];

        // start from the last characters
        int row = str1.length;
        int col = str2.length;
        while (row > 0 && col > 0) {
            if (str1[row - 1] == str2[col - 1]) {
                lcsArray[maxLen - 1] = str1[row - 1];
                row--;
                col--;
                maxLen--;
            } else if (table[row][col - 1] < table[row - 1][col]) {
                row--;
            } else {
                col--;
            }
        }
        // return LCS character array
        return lcsArray;
    }
}
