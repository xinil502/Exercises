package leetcode;

/**
 * @Author: Xinil
 * @Date: 2021/6/10 9:07
 */
public class LeetCode_518 {
    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {
                for (int i = coin; i <= amount; i++) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
            return dp[amount];
        }
    }
}
