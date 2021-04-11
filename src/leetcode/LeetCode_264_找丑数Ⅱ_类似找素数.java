package leetcode;

/**
 * 264. 丑数 II
 *
 * @Author: Xinil
 * @Date: 2021/4/11 15:23
 */
public class LeetCode_264_找丑数Ⅱ_类似找素数 {
    /**
     * 像找素数一样，使用线性筛排除第 i个，因为无法判断所有的，就需要暴力遍历。
     * 对于本题，我们要取的是第 i个，所以可以直接添加到已获得的数组中。
     */
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
            for (int i = 2; i <= n; i++) {
                int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
                dp[i] = Math.min(Math.min(num2, num3), num5);
                if (dp[i] == num2) {
                    p2++;
                }
                if (dp[i] == num3) {
                    p3++;
                }
                if (dp[i] == num5) {
                    p5++;
                }
            }
            return dp[n];
        }
    }
}
