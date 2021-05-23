package leetcode;

import java.util.Arrays;

/**
 * 5765. 跳跃游戏 VII
 *
 * @Author: Xinil
 * @Date: 2021/5/23 14:27
 */
public class LeetCode_5765 {
    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            int len = s.length();
            char[] chars = s.toCharArray();
            if (s.charAt(len - 1) == '1') {
                return false;
            }
            boolean[] dp = new boolean[len];
            dp[0] = true;
            int max = 0;
            for (int i = 0; i < len; ++i) {
                if (dp[i]) {
                    int start = Math.max(max + 1, i + minJump);
                    max = i + maxJump;
                    for (int j = start; j <= max && j < len; ++j) {
                        if (chars[j] == '0') {
                            dp[j] = true;
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(dp));
            return dp[len - 1];
        }
    }

}
