package leetcode;

/**
 * 389.找不同 —— 简单
 */
public class LeetCode_389 {
    //计数
    class Solution_1 {
        public char findTheDifference(String s, String t) {
            int[] nums = new int[26];
            for (char c : s.toCharArray()) {
                ++nums[c - 'a'];
            }
            for (char c : t.toCharArray()) {
                int k = nums[c - 'a'] = nums[c - 'a'] - 1;
                if (k < 0) {
                    return c;
                }
            }
            return 'a';
        }
    }

    //求和
    class Solution_2 {
        public char findTheDifference(String s, String t) {
            int as = 0, at = 0;
            for (int i = 0; i < s.length(); ++i) {
                as += s.charAt(i);
            }
            for (int i = 0; i < t.length(); ++i) {
                at += t.charAt(i);
            }
            return (char) (at - as);
        }
    }

    //位运算
    class Solution_3 {
        public char findTheDifference(String s, String t) {
            int ret = 0;
            for (int i = 0; i < s.length(); ++i) {
                ret ^= s.charAt(i);
            }
            for (int i = 0; i < t.length(); ++i) {
                ret ^= t.charAt(i);
            }
            return (char) ret;
        }
    }
}
