package leetcode;

/**
 * 643. 子数组最大平均数 I
 *
 * @Author: Xinil
 * @Date: 2021/2/4 18:12
 */
public class LeetCode_643 {
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int i, sum = 0;
            for (i = 0; i < k; ++i) {
                sum += nums[i];
            }
            int max = sum;
            while (i < nums.length) {
                sum += nums[i] - nums[i - k];
                max = Math.max(max, sum);
                ++i;
            }
            return max * 1.0 / k;
        }
    }
}
