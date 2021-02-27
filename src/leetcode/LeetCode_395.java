package leetcode;

/**
 * 395. 至少有K个重复字符的最长子串
 *
 * @Author: Xinil
 * @Date: 2021/2/27 15:52
 */
public class LeetCode_395 {
    class Solution {
        public int longestSubstring(String s, int k) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                ++count[c - 'a'];
            }
            int judge = -1;
            for (int i = 0; i < 26; ++i) {
                if (count[i] > 0 && count[i] < k) {
                    judge = i;
                    break;
                }
            }
            if (judge == -1) {
                return s.length();
            } else {
                int max = 0;
                String[] strs = s.split((char) (judge + 'a') + "");
                for (String ss : strs) {
                    if (s.length() > max) {
                        max = Math.max(max, longestSubstring(ss, k));
                    }
                }
                return max;
            }
        }
    }
}
