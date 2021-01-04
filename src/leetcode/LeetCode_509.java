package leetcode;

/**
 * 509.斐波那契数
 */
public class LeetCode_509 {
    class Solution {
        int[] nums = new int[31];

        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            nums[1] = 1;
            for (int i = 2; i < n; ++i) {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
            return nums[n - 1] + nums[n - 2];
        }
    }
}
