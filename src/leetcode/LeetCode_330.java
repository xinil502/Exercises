package leetcode;

/**
 * 330.按要求补齐数组
 */
public class LeetCode_330 {
    class Solution {
        public int minPatches(int[] nums, int n) {
            long sum = 0, nn = n;
            int k = 0;
            for (int i = 0; i < nums.length && sum < nn; ++i) {
                if (nums[i] > sum + 1) {
                    while (nums[i] > sum + 1 && sum < nn) {
                        sum += sum + 1;
                        ++k;
                    }
                }
                sum += nums[i];
            }
            while (sum < nn) {
                sum += sum + 1;
                ++k;
            }
            return k;
        }
    }
}
