package leetcode;

import java.util.Scanner;

public class LeetCode_198 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        Solution_198 sol = new Solution_198();
        System.out.println(sol.rob(nums));
    }
}

class Solution_198 {
    /*
     * 要么隔一家一偷，要么隔两家一偷，不可能会隔三家
     * 所以dp[i] = (dp[i - 2] > dp[i - 3] ? dp[i - 2] : dp[i - 3]) + nums[i]
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0] + nums[2];
        int max = dp[1] > dp[2] ? dp[1] : dp[2];
        for (int i = 3; i < nums.length; ++i) {
            dp[i] = (dp[i - 2] > dp[i - 3] ? dp[i - 2] : dp[i - 3]) + nums[i];
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}