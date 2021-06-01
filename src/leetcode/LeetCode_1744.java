package leetcode;

/**
 * 1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 *
 * @Author: Xinil
 * @Date: 2021/6/1 12:07
 */
public class LeetCode_1744 {// 第queries[i][1]天（这个天数从0开始）可能吃到第queries[i][0]种糖

    class Solution {
        public boolean[] canEat(int[] candiesCount, int[][] queries) {
            long[] sum = new long[candiesCount.length + 1];
            for (int i = 1; i <= candiesCount.length; ++i) {
                sum[i] = sum[i - 1] + candiesCount[i - 1];
            }
            boolean[] answer = new boolean[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                int a = queries[i][0];
                long b = queries[i][1] + 1;
                long c = queries[i][2];
                answer[i] = b * c > sum[a] && b <= sum[a + 1];
            }
            return answer;
        }
    }

}
