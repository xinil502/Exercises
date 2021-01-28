package leetcode;

/**
 * 724. 寻找数组的中心索引
 */
public class LeetCode_724 {
    class Solution {
        public int pivotIndex(int[] nums) {
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }

            int left = 0;

            for (int i = 0; i < nums.length; ++i) {
                if ((left << 1) + nums[i] == sum) {
                    return i;
                }
                left += nums[i];
            }
            return -1;
        }
    }
}
