package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeetCode_115 {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            String s = br.readLine();
            String t = br.readLine();

            Solution_115 sol = new Solution_115();
            System.out.println(sol.numDistinct(s, t));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Solution_115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0, j = 0; j < s.length() + 1; ++j) {
            dp[i][j] = 1;
        }
        for (int i = 1, j = 0; i < t.length() + 1; ++i) {
            dp[i][j] = 0;
        }


        for (int i = 1; i < t.length() + 1; ++i) {
            for (int j = 1; j < s.length() + 1; ++j) {
                if (s.charAt(j - 1) != t.charAt(i - 1)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }
            }
        }

        return dp[t.length()][s.length()];
    }
}