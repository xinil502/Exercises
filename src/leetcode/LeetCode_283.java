package leetcode;

import java.util.Arrays;

/**
 * 283. 移动零
 */
public class LeetCode_283 {
    public static void main(String[] args) {
        int[] nums = Utils.createArray();

        Solution_283 sol = new Solution_283();
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution_283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = 0, j = 0, length = nums.length;
        while (j < length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                ++i;
            }
            ++j;
        }
        while (i < length) {
            nums[i++] = 0;
        }
    }
}