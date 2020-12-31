package leetcode;

import java.util.Arrays;

/**
 * 435.无重叠区间
 */
public class LeetCode_435 {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            int sum = 0, end = Integer.MIN_VALUE;
            for (int i = 0; i < intervals.length; ++i) {
                if (intervals[i][0] < end) {
                    ++sum;
                } else {
                    end = intervals[i][1];
                }
            }
            return sum;
        }
    }
}
