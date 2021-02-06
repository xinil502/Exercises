package leetcode;

/**
 * LeetCode_5658. 任意子数组和的绝对值的最大值
 * <p>
 * 给你一个整数数组 nums 。
 * 一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值
 * 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 * <p>
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-3,2,3,-4]
 * 输出：5
 * 解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,-5,1,-4,3,-2]
 * 输出：8
 * 解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * @Author: Xinil
 * @Date: 2021/2/6 23:59
 */
public class LeetCode_5658 {
    //动态规划，维护最大和最小
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int ma = 0, mi = 0;
            if (nums[0] > 0) {
                ma = nums[0];
            } else {
                mi = nums[0];
            }
            int max = Math.max(0, Math.abs(nums[0]));
            for (int i = 1; i < nums.length; ++i) {
                ma = Math.max(nums[i], ma + nums[i]);
                mi = Math.min(nums[i], mi + nums[i]);
                max = Math.max(max, Math.max(Math.abs(ma), Math.abs(mi)));
            }
            return max;
        }
    }
}
