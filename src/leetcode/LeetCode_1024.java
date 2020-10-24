package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1024. 视频拼接
 */
public class LeetCode_1024 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; ++i) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        Solution_1024 sol = new Solution_1024();
        System.out.println(sol.videoStitching(nums, scanner.nextInt()));
    }
}

class Solution_1024 { //dp
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.sort(clips, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        Arrays.fill(dp, 111);
        dp[0] = 0;
        for (int[] clip : clips) {
            for (int i = clip[0] + 1; i <= clip[1]; ++i)
                if (i < dp.length) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
        }
        if (dp[T] == 111) {
            return -1;
        }
        return dp[T];
    }
}