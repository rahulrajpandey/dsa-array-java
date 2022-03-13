package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Problem Statement: Overlapping Intervals. Given a collection of Intervals, the task is to merge all the overlapping Intervals.
 * <p>
 * Link: https://practice.geeksforgeeks.org/problems/8a644e94faaa94968d8665ba9e0a80d1ae3e0a2d/1/?page=1&category[]=Arrays
 * <p>
 * Constraints:
 * Input: Array of N intervals.
 * Input Constraint: 1 ≤ Size of Array ≤ 100 AND 0 ≤ start interval ≤ end interval ≤ 1000
 * Output: sorted list of intervals after merging.
 * Output Constraint: Expected Time Complexity: O(N*Log(N)) AND Expected Auxiliary Space: O(Log(N)) or O(N)
 * <p>
 * Discussion and Solution:
 * Because we need to return the output in sorted order, and also we need to find overlapping intervals,
 * we must have to sort the input 2D array based on start value of each interval i.e. column 0 of every row in 2D array.
 * Assume the first interval from the sorted Intervals to be the first Overlapped interval to ease the comparison process later.
 * We need to create a List of type integer array to hold overlapped merged intervals
 * because we are not sure of the size of the result 2D array at this stage.
 * Start iterating over Intervals array to find overlapped intervals and add into the list.
 * The last overlapped interval created will not be added in the list while iterating, so add that after iteration is over.
 * Convert the list into 2D array.
 * Return the result 2D array.
 */

/**
 * Code Implementation
 */
public class OverlappingIntervals {
    /**
     * Input:
     *
     * @param Intervals - array of Integer intervals
     *
     * Output:
     * @return array of overlapped intervals
     * <p>
     * Operations:
     * - Sort the Intervals array based on starting point of Interval i.e. sort on column 0
     * - Hold the first assumed Overlapped Interval as the first row of the sorted Interval
     * - Create a List of int[] to hold the overlapped Intervals
     * - Overlapping condition:
     * - If start value of next Interval > end value of current Overlapped Interval, Then,
     * Store current Overlapped Interval into List and start a new Overlapped Interval
     * with the current Interval.
     * - Else If end value of current Overlapped Interval >= start value of next Interval AND
     * end value of current Overlapped Interval < end value of next Interval, Then,
     * Update the current Overlapped Interval:-
     * end value of current Overlapped Interval = end value of next Interval
     * - After the iteration is over, add the last Overlapped Interval into the list
     * - Convert the list of int[] to 2D array
     * - return the 2D array as result
     */
    public int[][] overlappedInterval(int[][] Intervals) {

        // sort the Input array based on first column
        Arrays.sort(Intervals, Comparator.comparingInt(a -> a[0])); // O(nlogn), n = number of interval pairs in Intervals

        // resultRow initialized
        int[] resultRow = new int[]{Intervals[0][0], Intervals[0][1]};

        // list to hold result rows
        List<int[]> listArr = new ArrayList<>();

        // check for intervals while iterating
        for (int i = 1; i < Intervals.length; i++) { // O(n), n = number of interval pairs in Intervals
            if (resultRow[1] < Intervals[i][0]) {
                listArr.add(resultRow);
                resultRow = new int[]{Intervals[i][0], Intervals[i][1]};
            } else if (resultRow[1] >= Intervals[i][0] && resultRow[1] < Intervals[i][1]) {
                resultRow[1] = Intervals[i][1];
            }
        } // for loop ends

        // last interval
        listArr.add(resultRow);

        // convert list to 2D array
        int[][] result = new int[listArr.size()][];
        for (int i = 0; i < listArr.size(); i++) { // O(K), K = listArr.size()
            result[i] = listArr.get(i);
        }

        // return the result
        return result;
    }
}
