package leetcode;

/**
 * 91. 解码方法
 *
 * @Author: Xinil
 * @Date: 2021/4/21 17:29
 */
public class LeetCode_91_动态规划 {
    class Solution {
        public int numDecodings(String s) {
            if (s.charAt(0) == '0') {
                return 0;
            }
            int[] dp = new int[s.length() + 1];
            char[] chars = s.toCharArray();
            dp[chars.length] = 1;
            if (chars[chars.length - 1] != '0') {
                dp[chars.length - 1] = 1;
            }
            for (int i = chars.length - 2; i > -1; --i) {
                if (chars[i] != '0') {
                    dp[i] += dp[i + 1];
                }
                if (chars[i] == '1' || (chars[i] == '2' && chars[i + 1] <= '6')) {
                    dp[i] += dp[i + 2];
                }
            }
            return dp[0];
        }
    }
}
