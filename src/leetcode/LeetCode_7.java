package leetcode;

/**
 * 7. 整数反转
 *
 * @Author: Xinil
 * @Date: 2021/5/3 11:50
 */
public class LeetCode_7 {
    class Solution {
        public int reverse(int x) {
            if (x >> 1 == 0) {
                return x;
            }
            long re = 0;
            while (x != 0) {
                re *= 10;
                re += x % 10;
                x /= 10;
            }
            if (re < -2147483648 || re > 2147483647) {
                return 0;
            }
            return (int) re;
        }
    }
}
