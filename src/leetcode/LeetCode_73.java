package leetcode;

/**
 * 73. 矩阵置零
 *
 * @Author: Xinil
 * @Date: 2021/3/21 12:44
 */
public class LeetCode_73 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            boolean judge = false;
            for (int i = 0; i < m; ++i) {
                if (matrix[i][0] == 0) {
                    judge = true;
                }
                for (int j = 1; j < n; ++j) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
            for (int j = 1; j < n; ++j) {
                if (matrix[0][j] == 0) {
                    for (int i = 0; i < m; ++i) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int i = 1; i < m; ++i) {
                if (matrix[i][0] == 0) {
                    for (int j = 0; j < n; ++j) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (matrix[0][0] == 0) {
                for (int j = 1; j < n; ++j) {
                    matrix[0][j] = 0;
                }
            }
            if (judge) {
                for (int i = 0; i < m; ++i) {
                    matrix[i][0] = 0;
                }
            }
            return;
        }
    }
}
