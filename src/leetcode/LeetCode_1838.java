package leetcode;

import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 *
 * @Author: Xinil
 * @Date: 2021/7/19 8:44
 */
public class LeetCode_1838 {
    //排序+滑动窗口
    class Solution {
        public int maxFrequency(int[] nums, int k) {
            Arrays.sort(nums);
            int left = 0, right = 0, max = 1, temp = 0;
            while (right < nums.length) {
                if (k >= 0) {
                    int len = right - left;
                    k -= len * (nums[right] - temp);
                    temp = nums[right];
                    if (k >= 0) {
                        max = Math.max(max, len + 1);
                    }
                    ++right;
                } else {
                    k += temp - nums[left];
                    ++left;
                }
            }
            return max;
        }
    }
}
