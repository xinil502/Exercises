package leetcode;

import java.util.Scanner;

public class LeetCode_837 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt(), W = sc.nextInt();
        sc.close();

        Solution_837 sol = new Solution_837();
        System.out.println(sol.new21Game(N, K, W));
    }
}

class Solution_837 {
    public double new21Game(int N, int K, int W) {
        //dp[i]表示持有i分时获胜的概率，因此i在[K,N]之间dp[i]=1，i大于K时dp[i]=0
        //因为当大于等于K时就不会再抽取数字，因此最大分数是K-1+W
        //从后往前计算dp，dp[0]表示持有0分时获胜的概率，也就是题目的要求
        //dp[i] = (dp[i+1]+dp[i+2]+...+dp[i+W])/W
        //也就是选取W范围内任意一个数字获胜的概率
        if (K + W <= N) return 1;  //如果K+W<=N，最终的分数不可能超过N
        double[] dp = new double[K + W];
        double sum = 0;  //保存长度为W的窗口中的概率之和
        for (int i = K; i <= N; i++) dp[i] = 1;
        for (int j = K; j < K + W; j++) sum += dp[j];
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = sum / W;  //从后往前计算dp[i]
            sum += dp[i] - dp[i + W];  //移动窗口
        }
        return dp[0];
    }
}