package leetcode;

import java.util.Arrays;

/**
 * 1833. 雪糕的最大数量
 *
 * @Author: Xinil
 * @Date: 2021/7/2 19:20
 */
public class LeetCode_1833 {
    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);
            int sum = 0, count = 0;
            for (int i : costs) {
                sum += i;
                if (sum > coins) {
                    return count;
                } else {
                    ++count;
                }
            }
            return count;
        }
    }
}
