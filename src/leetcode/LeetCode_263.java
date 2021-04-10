package leetcode;

/**
 * 263. 丑数
 *
 * @Author: Xinil
 * @Date: 2021/4/10 14:49
 */
public class LeetCode_263 {
    class Solution {
        public boolean isUgly(int n) {
            if (n < 1) {
                return false;
            }
            while (n % 2 == 0) {
                n /= 2;
            }
            while (n % 3 == 0) {
                n /= 3;
            }
            while (n % 5 == 0) {
                n /= 5;
            }
            return n == 1;
        }
    }
}
