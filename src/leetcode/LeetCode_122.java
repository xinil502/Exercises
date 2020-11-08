package leetcode;

/**
 * 122.买卖股票的最佳时机Ⅱ
 */
public class LeetCode_122 {
    public static void main(String[] args) {
        Solution_122 sol = new Solution_122();
        System.out.println(sol.maxProfit(Utils.createArray()));
    }
}

class Solution_122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int sum = 0, start = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (start == i - 1 && prices[i] < prices[i - 1]) {
                start = i;
            } else if (start != i - 1 && prices[i] < prices[i - 1]) {
                sum += prices[i - 1] - prices[start];
                start = i;
            } else if (i == prices.length - 1 && prices[i] > prices[start]) {
                sum += prices[i] - prices[start];
            }
        }
        return sum;
    }
}