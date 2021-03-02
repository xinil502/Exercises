package leetcode;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 *
 * @Author: Xinil
 * @Date: 2021/3/2 23:01
 */
public class LeetCode_304 {
    class NumMatrix {
        int[][] matrix;
        int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                dp = null;
                return;
            }
            this.matrix = matrix;
            dp = new int[matrix.length + 1][matrix[0].length + 1];
            dp[1][1] = matrix[0][0];
            for (int i = 1; i < matrix[0].length; ++i) {
                dp[1][i + 1] = dp[1][i] + matrix[0][i];
            }
            for (int i = 1; i < matrix.length; ++i) {
                dp[i + 1][1] = dp[i][1] + matrix[i][0];
                for (int j = 1; j < matrix[0].length; ++j) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (dp == null) {
                return 0;
            }
            return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];

        }
    }

}
