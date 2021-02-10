package leetcode;

/**
 * 567. 字符串的排列
 *
 * @Author: Xinil
 * @Date: 2021/2/10 13:07
 */
public class LeetCode_567 {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }
            int[] count = new int[26];
            int len = s1.length();
            for (char c : s1.toCharArray()) {
                ++count[c - 'a'];
            }
            int judge = 26;//统计不同的字符数量
            for (int i = 0; i < 26; ++i) {
                if (count[i] == 0) {
                    --judge;
                }
            }
            char[] str2 = s2.toCharArray();
            for (int i = 0; i < len; ++i) {
                int c = str2[i] - 'a';
                --count[c];
                if (count[c] == 0) { //不满足要求的字符少了一个
                    --judge;
                } else if (count[c] == -1) {//不满足要求的字符多了一个
                    ++judge;
                }
            }
            if (judge == 0) {
                return true;
            }
            for (int i = len; i < str2.length; ++i) {
                int c = str2[i] - 'a';
                --count[c];
                if (count[c] == 0) {
                    --judge;
                } else if (count[c] == -1) {
                    ++judge;
                }

                c = str2[i - len] - 'a';
                ++count[c];
                if (count[c] == 0) {
                    --judge;
                } else if (count[c] == 1) {
                    ++judge;
                }
                if (judge == 0) {
                    return true;
                }
            }
            return false;
        }
    }
}
