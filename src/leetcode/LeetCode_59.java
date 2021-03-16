package leetcode;

/**
 * 59. 螺旋矩阵 II
 *
 * @Author: Xinil
 * @Date: 2021/3/16 14:14
 */
public class LeetCode_59 {
    class Solution {
        public int[][] generateMatrix(int n) {
            int k = 0, i = 0, j = 0;
            int start = 1, end = n * n;
            int[][] re = new int[n][n];
            while (true) {
                while (j + k < n) {
                    re[i][j] = start;
                    ++start;
                    ++j;
                }
                --j;
                ++i;
                while (i + k < n) {
                    re[i][j] = start;
                    ++start;
                    ++i;
                }
                --i;
                --j;
                if (start > end) {
                    return re;
                }
                while (j > k) {
                    re[i][j] = start;
                    ++start;
                    --j;
                }

                while (i > k) {
                    re[i][j] = start;
                    ++start;
                    --i;
                }
                if (start > end) {
                    return re;
                }
                ++i;
                ++j;
                ++k;
            }
        }
    }
}
