package leetcode;

/**
 * 342. 4的幂
 *
 * @Author: Xinil
 * @Date: 2021/5/31 12:54
 */
public class LeetCode_342 {
    /**
     * 大于零 & 只有一位是1 & 是奇数位
     */
    class Solution_1 {
        public boolean isPowerOfFour(int n) {
            return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
        }
    }

    class Solution_2 {
        public boolean isPowerOfFour(int n) {
            return (n & (n - 1)) == 0 && n % 3 == 1;
        }
    }
}
