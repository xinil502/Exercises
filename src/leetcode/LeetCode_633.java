package leetcode;

/**
 * @Author: Xinil
 * @Date: 2021/4/28 13:27
 */
public class LeetCode_633 {
    /**
     * 双指针，两端向中间遍历
     */
    class Solution_1 {
        public boolean judgeSquareSum(int c) {
            int left = 0;
            int right = (int) Math.sqrt(c);
            while (left <= right) {
                int sum = left * left + right * right;
                if (sum == c) {
                    return true;
                } else if (sum > c) {
                    right--;
                } else {
                    left++;
                }
            }
            return false;
        }
    }

    /**
     * 数学算法：
     * 一个非负整数如果能够表示为两个整数的平方和，
     * 那么这个数的所有形如 4k+3的质因子的幂均为偶数。
     */
    class Solution_2 {
        public boolean judgeSquareSum(int c) {
            for (int base = 2; base * base <= c; base++) {
                // 如果不是因子，枚举下一个
                if (c % base != 0) {
                    continue;
                }

                // 计算 base 的幂
                int exp = 0;
                while (c % base == 0) {
                    c /= base;
                    exp++;
                }

                // 根据 Sum of two squares theorem 验证
                if (base % 4 == 3 && exp % 2 != 0) {
                    return false;
                }
            }

            // 例如 11 这样的用例，由于上面的 for 循环里 base * base <= c ，base == 11 的时候不会进入循环体
            // 因此在退出循环以后需要再做一次判断
            return c % 4 != 3;
        }
    }
}
