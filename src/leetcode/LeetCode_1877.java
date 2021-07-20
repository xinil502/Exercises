package leetcode;

import java.util.Arrays;

/**
 * 1877. 数组中最大数对和的最小值
 *
 * @Author: Xinil
 * @Date: 2021/7/20 8:47
 */
public class LeetCode_1877 {
    //简单的排序+贪心
    class Solution {
        public int minPairSum(int[] nums) {
            Arrays.sort(nums);
            int max = 0, len = nums.length;
            for (int i = 0; i < len / 2; ++i) {
                max = Math.max(max, nums[i] + nums[len - 1 - i]);
            }
            return max;
        }
    }
}
