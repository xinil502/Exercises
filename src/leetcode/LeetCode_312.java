package leetcode;

import java.util.Scanner;

public class LeetCode_312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution_312 sol = new Solution_312();
        System.out.println(sol.maxCoins(nums));
    }
}

class Solution_312 {
    public int maxCoins(int[] nums) {
        int len = nums.length, i, j, k;

        //将左右两侧插入数字为1的气球，便于计算边界。
        // 原本{3,1,5,8}的气球排序，改为{1,3,1,5,8,1}
        int[] num = new int[len + 2];
        for (i = 0; i < len; ++i) {
            num[i + 1] = nums[i];
        }
        num[0] = num[len + 1] = 1;


        int[][] dp = new int[len + 2][len + 2];
        /**
         *
         * dp[i][j]表示扎破第i到第j个气球，最大获得多少分
         *
         * 注意：两头的气球不会被扎破，只是为了便于计算边界。
         * 首先外层循环要求i+1 < j ,控制从i到j至少有两个气球。
         *
         * 当i到j 有且仅有两个气球时，因为两端气球无法扎破，
         * 所以dp[i][j] = 0，最大为0分。
         *
         * 当气球大于两个时，令索引值k对应最后一个被炸爆的气球，
         * 扎爆后，i到j的所有气球，只剩i和j。
         * 先算出扎破i-k之间的气球能获得的最大值dp[i][k]，
         * 再算出扎破k-j之间的气球的最大值dp[k][j]，最后扎破k，,保留两端i和j
         * 则dp[i][j] 为：  Math.max(dp[i][j], dp[i][k] + dp[k][j] + num[i]*num[k]*num[j])
         * 此时dp[i][j] 是最后扎爆第k个气球的最大值。
         *
         * 当然，i-j之间的k有很多，
         * 循环计算每一种k的可能：k=i+1; k<j; ++k
         * 得到最大的dp[i][j]
         *
         */
        for (i = len; i >= 0; --i) {
            for (j = i + 2; j < len + 2; ++j) {
                for (k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + num[i] * num[k] * num[j]);
                }
            }
        }
        return dp[0][len + 1];
    }
}