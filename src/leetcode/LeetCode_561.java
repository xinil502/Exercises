package leetcode;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 *
 * @Author: Xinil
 * @Date: 2021/2/16 10:48
 */
public class LeetCode_561 {
    class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i += 2) {
                sum += nums[i];
            }
            return sum;
        }
    }
}
