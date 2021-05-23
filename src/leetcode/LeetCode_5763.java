package leetcode;

/**
 * 5763. 哪种连续子字符串更长
 *
 * @Author: Xinil
 * @Date: 2021/5/23 14:25
 */
public class LeetCode_5763 {
    class Solution {
        public boolean checkZeroOnes(String s) {
            int len1 = 0, len0 = 0;
            int max1 = 0, max0 = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    max0 = Math.max(max0, len0);
                    len0 = 0;
                    ++len1;
                } else {
                    max1 = Math.max(max1, len1);
                    len1 = 0;
                    ++len0;
                }
            }
            max0 = Math.max(max0, len0);
            max1 = Math.max(max1, len1);
            return max1 > max0;
        }
    }

}
