package leetcode;

/**
 * 122.买卖股票的最佳时机Ⅱ
 */
public class LeetCode_122 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2)
                return 0;
            int total = 0, index = 0, length = prices.length;
            while (index < length) {
                //如果股票下跌就一直找，直到找到股票开始上涨为止
                while (index < length - 1 && prices[index] >= prices[index + 1])
                    index++;
                //股票上涨开始的值，也就是这段时间上涨的最小值
                int min = prices[index];
                //一直找到股票上涨的最大值为止
                while (index < length - 1 && prices[index] <= prices[index + 1])
                    index++;
                //计算这段上涨时间的差值，然后累加
                total += prices[index++] - min;
            }
            return total;
        }
    }
}