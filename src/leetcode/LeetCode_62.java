package leetcode;

import java.util.Arrays;

/**
 * 62.不同路径
 */
public class LeetCode_62 {
    public static void main(String[] args) {
        LeetCode_62 leet = new LeetCode_62();
        Solution_2 sol = leet.new Solution_2();
        System.out.println(sol.uniquePaths(10, 10));

    }

    /**
     * 方法一：使用压缩数组动态规划。
     */
    class Solution_1 {
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    dp[j] += dp[j - 1];
                }
            }
            return dp[n - 1];
        }
    }

    /**
     * 方法二：排列组合
     * 向下走 m-1 步，， 向右走 n-1 步。
     * 总共走  m+n-2 步
     * <p>
     * m-1
     * C m+n-2
     */
    class Solution_2 {
        public int uniquePaths(int m, int n) {
            long ans = 1;
            for (int x = n, y = 1; y < m; ++x, ++y) {
                ans = ans * x / y;
            }
            return (int) ans;
        }
    }

}