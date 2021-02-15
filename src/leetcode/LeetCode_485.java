package leetcode;

/**
 * 485. 最大连续1的个数
 *
 * @Author: Xinil
 * @Date: 2021/2/15 14:23
 */
public class LeetCode_485 {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int fast = 0, slow = 0, max = 0;
            while (slow < nums.length) {
                if (nums[slow] == 0) {
                    ++slow;
                } else {
                    fast = slow;
                    while (fast < nums.length && nums[fast] == 1) ++fast;
                    max = (max < fast - slow) ? fast - slow : max;
                    slow = fast;
                }
            }
            return max;
        }
    }

}
