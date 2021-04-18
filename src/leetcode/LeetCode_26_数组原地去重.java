package leetcode;

/**
 * 26. 删除有序数组中的重复项
 *
 * @Author: Xinil
 * @Date: 2021/4/18 12:59
 */
public class LeetCode_26_数组原地去重 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int k = 1;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i - 1] != nums[i]) {
                    nums[k] = nums[i];
                    ++k;
                }
            }
            return k;
        }
    }
}
