package leetcode;

/**
 * 309. 最佳买卖股票时机含冷冻期
 *
 * @Author: Xinil
 * @Date: 2021/6/14 19:38
 */
public class LeetCode_309 {
    class Solution {
        public int maxProfit(int[] prices) {
            int firstBuy = Integer.MIN_VALUE, firstSell = 0;
            int secondBuy = Integer.MIN_VALUE, secondSell = 0;
            int thirdBuy = Integer.MIN_VALUE, thirdSell = 0;
            for (int i : prices) {
                thirdBuy = Math.max(secondBuy, firstSell - i);
                thirdSell = Math.max(secondSell, thirdBuy + i);
                firstBuy = secondBuy;
                secondBuy = thirdBuy;
                firstSell = secondSell;
                secondSell = thirdSell;
            }
            return thirdSell;
        }
    }
}
