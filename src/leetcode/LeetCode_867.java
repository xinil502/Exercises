package leetcode;

/**
 * 867. 转置矩阵
 *
 * @Author: Xinil
 * @Date: 2021/2/25 15:11
 */
public class LeetCode_867 {
    class Solution {
        public int[][] transpose(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] nums = new int[n][m];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    nums[j][i] = matrix[i][j];
                }
            }
            return nums;
        }
    }
}
