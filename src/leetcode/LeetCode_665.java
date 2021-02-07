package leetcode;

/**
 * 665. 非递减数列
 *
 * @Author: Xinil
 * @Date: 2021/2/7 20:55
 */
public class LeetCode_665 {
    class Solution {
        public boolean checkPossibility(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            boolean can = nums[0] <= nums[1];
            for (int i = 1; i < nums.length - 2; ++i) {
                if (nums[i] > nums[i + 1]) {
                    if (can) {
                        if (nums[i - 1] <= nums[i + 1] || nums[i] <= nums[i + 2]) {
                            can = false;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
            if (nums.length > 2 && nums[nums.length - 2] > nums[nums.length - 1] && (!can)) {
                return false;
            }
            return true;
        }
    }
}
