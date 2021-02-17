package leetcode;

/**
 * 566. 重塑矩阵
 *
 * @Author: Xinil
 * @Date: 2021/2/17 11:43
 */
public class LeetCode_566 {
    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int rr = nums.length;
            int cc = nums[0].length;
            if (rr * cc != r * c) {
                return nums;
            }

            int[][] re = new int[r][c];
            int m = 0, n = 0;
            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    re[i][j] = nums[m][n];
                    ++n;
                    if (n < cc) continue;
                    n = 0;
                    ++m;
                }
            }
            return re;
        }
    }
}
