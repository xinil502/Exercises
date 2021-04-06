package leetcode;

/**
 * 80. 删除有序数组中的重复项 II
 *
 * @Author: Xinil
 * @Date: 2021/4/6 13:38
 */
public class LeetCode_80 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int length = nums.length;
            int len = 2;
            for (int i = 2; i < length; ++i) {
                if (nums[i] != nums[len - 2]) {
                    nums[len] = nums[i];
                    ++len;
                }
            }
            return len;
        }
    }
}
