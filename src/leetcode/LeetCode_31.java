package leetcode;

import java.util.Arrays;

/**
 * 31. 下一个排列
 */
public class LeetCode_31 {
    public static void main(String[] args) {
        int[] nums = Utils.createArray();

        Solution_31 sol = new Solution_31();
        sol.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution_31 {
    public void nextPermutation(int[] nums) {
        int i, j, k = nums.length;
        for (i = k - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        int temp;
        if (i != -1) {
            for (j = k - 1; j > i; --j) {
                if (nums[i] < nums[j]) {
                    break;
                }
            }
            temp = nums[i] ^ nums[j];
            nums[i] = temp ^ nums[i];
            nums[j] = temp ^ nums[j];
        }
        for (j = 1; i + j < k - j; ++j) {
            temp = nums[i + j] ^ nums[k - j];
            nums[i + j] = temp ^ nums[i + j];
            nums[k - j] = temp ^ nums[k - j];
        }
    }
}