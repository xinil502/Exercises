package leetcode;

/**
 * 48.旋转图像
 */
public class LeetCode_48 {
    //翻转转两次
    class Solution_1 {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            //沿主对角线翻转
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n - i - 1; ++j) {
                    matrix[i][j] ^= matrix[n - 1 - j][n - 1 - i];
                    matrix[n - 1 - j][n - 1 - i] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[n - 1 - j][n - 1 - i];
                }
            }
            //沿X轴翻转  (需要逆时针旋转时，只需要沿Y翻转)
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] ^= matrix[n - 1 - i][j];
                    matrix[n - 1 - i][j] ^= matrix[i][j];
                    matrix[i][j] ^= matrix[n - 1 - i][j];
                }
            }
        }
    }

    //遍历矩阵的1/4，一次旋转四个位置。
    class Solution_2 {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n / 2; ++i) {
                for (int j = 0; j < (n + 1) / 2; ++j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][i];
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = temp;
                }
            }
        }
    }
}
