package leetcode;

/**
 * 5766. 石子游戏 VIII
 *
 * @Author: Xinil
 * @Date: 2021/5/23 14:28
 */
public class LeetCode_5766 {
    class Solution {
        public int stoneGameVIII(int[] stones) {
            int len = stones.length;
            int[] sum = new int[len];
            sum[0] = stones[0];
            for (int i = 1; i < len; ++i) {
                sum[i] = sum[i - 1] + stones[i];
            }
            int[] dp = new int[len];
            dp[len - 1] = 0;
            int max = Integer.MIN_VALUE;
            for (int i = len - 2; i > -1; --i) {
                max = Math.max(max, sum[i + 1] - dp[i + 1]);
                dp[i] = max;
            }
            return dp[0];
        }
    }

}
