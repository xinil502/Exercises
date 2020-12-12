package leetcode;

/**
 * 376. 摆动序列
 */
public class LeetCode_376 {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return 1;
            }
            int i;
            boolean isAdd;
            for (i = 1; i < nums.length; ++i) {
                if (nums[i - 1] != nums[i]) {
                    break;
                }
            }
            if (i == nums.length) {
                return 1;
            } else {
                if (nums[i - 1] > nums[i]) {
                    isAdd = false;
                } else {
                    isAdd = true;
                }
            }
            int length = 1;
            while (i < nums.length) {
                if (isAdd) {
                    for (; i < nums.length; ++i) {
                        if (nums[i - 1] > nums[i]) {
                            ++length;
                            isAdd = false;
                            break;
                        }
                    }
                } else {
                    for (; i < nums.length; ++i) {
                        if (nums[i - 1] < nums[i]) {
                            ++length;
                            isAdd = true;
                            break;
                        }
                    }
                }
            }
            return length + 1;
        }
    }
}
