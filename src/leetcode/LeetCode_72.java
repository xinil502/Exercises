package leetcode;


import java.util.Scanner;

/**
 * LeetCode_72.编辑距离
 */
public class LeetCode_72 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next(), s2 = sc.next();

        Solution_72 sol = new Solution_72();
        System.out.println(sol.minDistance(s1, s2));
    }
}

class Solution_72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() + word2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); ++i) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); ++i) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); ++i) {
            for (int j = 1; j <= word2.length(); ++j) {
                dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}