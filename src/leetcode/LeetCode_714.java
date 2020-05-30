package leetcode;

import java.util.Scanner;

public class LeetCode_714 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; ++i) {
            prices[i] = sc.nextInt();
        }
        int fee = sc.nextInt();

        Solution_714 sol = new Solution_714();
        System.out.println(sol.maxProfit(prices, fee));
    }
}


class Solution_714 {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee); //卖出时利润最高（卖出时才计算手续费）
            hold = Math.max(hold, cash - prices[i]); //保证z持有着最低价的股票
        }
        return cash;
    }
}