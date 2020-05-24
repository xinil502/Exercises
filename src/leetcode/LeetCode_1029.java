package leetcode;

import java.util.Scanner;

public class LeetCode_1029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] costs = new int[n][2];
        for (int i = 0; i < n; ++i) {
            costs[i][0] = sc.nextInt();
            costs[i][1] = sc.nextInt();
        }

        Solution_1028 sol = new Solution_1028();
        System.out.println(sol.twoCitySchedCost(costs));
    }
}

class Solution_1028 {
    public int twoCitySchedCost(int[][] costs) {
        int sum = 0;
        int[] price = new int[costs.length];
        for (int i = 0; i < costs.length; ++i) {
            sum += costs[i][0];
            price[i] = costs[i][1] - costs[i][0];
        }
        for (int i = 0; i < costs.length / 2; ++i) {
            for (int j = i + 1; j < costs.length; ++j) {
                if (price[i] > price[j]) {
                    price[i] ^= price[j];
                    price[j] ^= price[i];
                    price[i] ^= price[j];
                }
            }
        }
        for (int i = 0; i < costs.length / 2; ++i) {
            sum += price[i];
        }
        return sum;
    }
}