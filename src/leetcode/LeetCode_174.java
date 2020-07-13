package leetcode;

import java.util.Scanner;

public class LeetCode_174 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                nums[i][j] = sc.nextInt();
            }
        }

        Solution_174 sol = new Solution_174();
        System.out.println(sol.calculateMinimumHP(nums));
    }
}

class Solution_174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int i, j;
        int[][] dp = new int[dungeon.length][dungeon[0].length]; //从i行j列到右下角至少需要多少初始健康点数
        i = dungeon.length - 1;
        j = dungeon[0].length - 1;
        if (dungeon[i][j] < 0) {
            dp[i][j] = 1 - dungeon[i][j];
        } else {
            dp[i][j] = 1;
        }

        //动态规划边缘值
        for (i = dungeon.length - 2, j = dungeon[0].length - 1; i >= 0; --i) {
            dp[i][j] = dp[i + 1][j] - dungeon[i][j];
            dp[i][j] = Math.max(dp[i][j], 1); //如果最小生命值为负数，则调整为1
        }
        for (i = dungeon.length - 1, j = dungeon[0].length - 2; j >= 0; --j) {
            dp[i][j] = dp[i][j + 1] - dungeon[i][j];
            dp[i][j] = Math.max(dp[i][j], 1); //如果最小生命值为负数，则调整为1
        }

        for (i = dungeon.length - 2; i >= 0; --i) {
            for (j = dungeon[0].length - 2; j >= 0; --j) {
                dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j]; //求出最小初始生命值
                dp[i][j] = Math.max(dp[i][j], 1); //如果最小生命值为负数，则调整为1
            }
        }
        return dp[0][0];
    }
}