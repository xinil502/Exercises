package leetcode;

/**
 * 190. 颠倒二进制位
 *
 * @Author: Xinil
 * @Date: 2021/3/29 14:31
 */
public class LeetCode_190 {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int r = 0;
            int i = 0;
            if ((n & 1) == 1) { //1开头
                r = 1;
            } else {//0开头
                r = 0;
            }
            n >>>= 1;
            while (i++ < 31) {
                r = r << 1;
                r = r | (n & 1);
                n >>>= 1;
            }
            return r;
        }
    }

}
