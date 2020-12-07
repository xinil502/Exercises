package leetcode;

/**
 * 861. 翻转矩阵后的得分
 */
public class LeetCode_861 {
    class Solution {
        public int matrixScore(int[][] A) {
            int m = A.length, n = A[0].length;
            for (int i = 0; i < m; ++i) {
                if (A[i][0] == 0) {
                    for (int j = 0; j < n; ++j) {
                        A[i][j] ^= 1;
                    }
                }
            }
            int x = (int) Math.pow(2, n - 1);
            int sum = x * m;
            for (int j = 1; j < n; ++j) {
                x /= 2;
                int k = 0;
                for (int i = 0; i < m; ++i) {
                    if (A[i][j] == 1) {
                        ++k;
                    }
                }
                sum += x * (k * 2 > m ? k : m - k);
            }
            return sum;
        }
    }
}
