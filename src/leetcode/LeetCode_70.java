package leetcode;

import java.util.Scanner;

public class LeetCode_70 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Solution_70 sol = new Solution_70();
        System.out.println(sol.climbStairs(n));
    }
}


class Solution_70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 0, b = 1, c = 1;
        for (int i = 2; i <= n; ++i) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}