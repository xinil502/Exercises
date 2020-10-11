package leetcode;

import java.util.Scanner;

/**
 * LeetCode_416.分割等和的子集
 */
public class LeetCode_416 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
        }

        Solution_416 sol = new Solution_416();
        System.out.println(sol.canPartition(nums));
    }
}

class Solution_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];

        //填第0行，第 1 个数只能让容积为它自己的背包恰好装满。
        if (nums[0] < target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j <= target; ++j) {
                if (nums[i] < j) {
                    //取nums[i], 判断从0到i，能否存在和为到 j-nums[i]
                    //不取nums[i], 判断之前是否已经达到目标和。dp[i-1][j]
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                } else if (nums[i] == j) { // 智取一个数，一次到位。
                    dp[i][j] = true;
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}