package leetcode;

/**
 * 85.最大矩形
 */
public class LeetCode_85 {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            //行，列，行列三种情况。
            int[][] length = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    if (matrix[i][j] == '0') {
                        length[i][j] = 0;
                    } else {
                        if (j - 1 > -1 && length[i][j - 1] != 0) {
                            length[i][j] = length[i][j - 1] + 1;
                        } else {
                            length[i][j] = 1;
                        }
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    if (matrix[i][j] == '1') {
                        int lMin = Integer.MAX_VALUE, m;
                        for (m = i; m > -1 && length[m][j] > 0; --m) {
                            lMin = Math.min(lMin, length[m][j]);
                            max = Math.max(max, (i - m + 1) * lMin);
                        }
                    }
                }
            }
            return max;
        }
    }
}
