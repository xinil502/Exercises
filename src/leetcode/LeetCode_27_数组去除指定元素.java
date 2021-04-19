package leetcode;

/**
 * 27. 移除元素
 *
 * @Author: Xinil
 * @Date: 2021/4/19 18:46
 */
public class LeetCode_27_数组去除指定元素 {
    /**
     * 简单双指针遍历
     */
    class Solution {
        public int removeElement(int[] nums, int val) {
            int len = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != val) {
                    nums[len] = nums[i];
                    ++len;
                }
            }
            return len;
        }
    }
}
