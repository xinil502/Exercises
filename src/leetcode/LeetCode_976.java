package leetcode;

import java.util.Arrays;

/**
 * 976.三角形的最大周长
 */
public class LeetCode_976 {
    class Solution {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);
            for (int i = A.length - 1; i > 1; --i) {
                if (A[i] - A[i - 1] < A[i - 2]) {
                    return A[i] + A[i - 1] + A[i - 2];
                }
            }
            return 0;
        }
    }
}
