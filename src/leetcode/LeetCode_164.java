package leetcode;

import java.util.Arrays;

/**
 * 164. 最大间距
 * 无脑使用sort排序，题解用的基数排序。
 */
public class LeetCode_164 {
    class Solution {
        public int maximumGap(int[] nums) {
            int len = nums.length, max = 0;
            if (len < 2) return 0;
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                int t = nums[i] - nums[i - 1];
                max = max > t ? max : t;
            }
            return max;
        }
    }
}
