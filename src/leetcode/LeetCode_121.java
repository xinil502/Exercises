package leetcode;

import java.util.Scanner;


public class LeetCode_121 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution_121 sol = new Solution_121();
        System.out.println(sol.maxProfit(nums));
    }
}

class Solution_121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (min < prices[i]) {
                profit = Math.max(profit, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return profit;
    }
}
