package leetcode;

/**
 * 1269. 停在原地的方案数
 *
 * @Author: Xinil
 * @Date: 2021/5/13 13:19
 */
public class LeetCode_1269 {
    class Solution {
        public int numWays(int steps, int arrLen) {
            arrLen = Math.min(steps / 2 + 1, arrLen); //优化数组长度的为可达长度
            long[][] dp = new long[steps + 1][arrLen];
            for (int i = 0; i < steps && i < arrLen; ++i) { //初始化对角线的部分(步数 == 数组长度)
                dp[i][i] = 1;
            }
            dp[1][0] = 1;
            for (int i = 2; i <= steps && i < arrLen; ++i) { //初始化斜着的部分(步数 < 数组长度)
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 1000000007;
                for (int j = 1; j < i - 1; ++j) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j] + dp[i - 1][j + 1]) % 1000000007;
                }
                dp[i][i - 1] = (dp[i - 1][i - 2] + dp[i - 1][i - 1]) % 1000000007;
            }
            for (int i = arrLen; i <= steps; ++i) { //推出结果
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % 1000000007;
                for (int j = 1; j < arrLen - 1; ++j) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j] + dp[i - 1][j + 1]) % 1000000007;
                }
                dp[i][arrLen - 1] = (dp[i - 1][arrLen - 2] + dp[i - 1][arrLen - 1]) % 1000000007;
            }
            return (int) dp[steps][0];
        }
    }
}
