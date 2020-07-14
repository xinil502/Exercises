package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_120 {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        List<List<Integer>> triangle = new ArrayList<>();

        try {
            String s = br.readLine();
            int n = Integer.parseInt(s);
            for (int i = 1; i <= n; ++i) {
                List<Integer> list = new ArrayList<>();
                for (int j = 1; j <= i; ++j) {
                    list.add(Integer.parseInt(br.readLine()));
                }
                triangle.add(list);
            }
            br.close();
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Solution_120 sol = new Solution_120();
        System.out.println(sol.minimumTotal(triangle));
    }
}

class Solution_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size()];
        List<Integer> list;
        for (int i = 0; i < triangle.size(); ++i) {
            list = triangle.get(i);
            for (int j = i; j >= 0; --j) {
                if (j == 0) {
                    dp[j] = dp[j] + list.get(j);
                } else if (j == i) {
                    dp[j] = dp[j - 1] + list.get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp) {
            min = min > i ? i : min;
        }
        return min;
    }
}