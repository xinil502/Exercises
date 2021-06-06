package leetcode;

/**
 * @Author: Xinil
 * @Date: 2021/6/6 12:51
 */
public class LeetCode_474 {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            int[][] count = new int[len][2];
            boolean[] judge = new boolean[len];
            for (int i = 0; i < len; ++i) {
                for (char c : strs[i].toCharArray()) {
                    if (c == '0') {
                        ++count[i][0];
                    } else {
                        ++count[i][1];
                    }
                }
                if (count[i][0] <= m & count[i][1] <= n) {
                    judge[i] = true;
                }
            }
            int[][] dp = new int[m + 1][n + 1];//二维dp
            for (int i = 0; i < len; ++i) {
                if (judge[i]) {
                    int j = m, tempJ = m - count[i][0];
                    while (tempJ >= 0) {
                        int k = n, tempK = n - count[i][1];
                        while (tempK >= 0) {
                            dp[j][k] = Math.max(dp[j][k], dp[tempJ][tempK] + 1); //第j，k位置的最大值由[j-count[j][0]][k-count[k][1]]位置决定
                            --k;
                            --tempK;
                        }
                        --j;
                        --tempJ;
                    }
                }
            }
            return dp[m][n];
        }
    }
}
