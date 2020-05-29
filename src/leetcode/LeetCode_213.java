package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        Solution_213 sol = new Solution_213();
        System.out.println(sol.rob(nums));
    }
}

class Solution_213 {
    //基于第198题的基础上，求出去掉第一个的最大值和去掉第二个的最大值，再求最大值
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] num1 = new int[nums.length - 1];
        int[] num2 = new int[nums.length - 1];
        System.arraycopy(nums, 0, num1, 0, nums.length - 1);
        System.arraycopy(nums, 1, num2, 0, nums.length - 1);
        return Math.max(this.robb(num1), this.robb(num2));
    }

    int robb(int[] nums) { //第198题题解
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