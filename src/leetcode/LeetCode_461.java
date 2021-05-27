package leetcode;

/**
 * 461. 汉明距离
 *
 * @Author: Xinil
 * @Date: 2021/5/27 19:31
 */
public class LeetCode_461 {
    class Solution {
        public int hammingDistance(int x, int y) {
            int re = 0;
            x ^= y;
            while (x != 0) {
                if ((x & 1) == 1) {
                    ++re;
                }
                x >>= 1;
            }
            return re;
        }
    }
}
