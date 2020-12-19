package leetcode;

/**
 * 48.旋转图像
 */
public class LeetCode_48 {
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            //沿y=x ，轴对称
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n - i - 1; ++j) {
                    matrix[i][j] ^= matrix[n - 1 - j][n - 1 - i];
                    matrix[n - 1 - j][n - 1 - i] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[n - 1 - j][n - 1 - i];
                }
            }
            //沿y=00轴对称  (需要逆时针旋转时，只需要沿x=0旋转)
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] ^= matrix[n - 1 - i][j];
                    matrix[n - 1 - i][j] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[n - 1 - i][j];
                }
            }
        }
    }
}
