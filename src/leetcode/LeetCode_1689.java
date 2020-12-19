package leetcode;

/**
 * 1689. 十-二进制数的最少数目
 */
public class LeetCode_1689 {
    class Solution {
        public int minPartitions(String n) {
            int ret = 0;
            for (char c : n.toCharArray()) {
                ret = Math.max(ret, c - '0');
            }
            return ret;
        }
    }
}
