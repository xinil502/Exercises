package leetcode;

/**
 * 242. 有效的字母异位词——简单
 */
public class LeetCode_242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] cnts = new int[26];
            for (char c : s.toCharArray()) {
                ++cnts[c - 'a'];
            }
            for (char c : t.toCharArray()) {
                --cnts[c - 'a'];
            }
            for (int cnt : cnts) {
                if (cnt != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
