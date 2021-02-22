package leetcode;

/**
 * 766. 托普利茨矩阵
 *
 * @Author: Xinil
 * @Date: 2021/2/22 13:04
 */
public class LeetCode_766 {
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] != matrix[i - 1][j - 1]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
