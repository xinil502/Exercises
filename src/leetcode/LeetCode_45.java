package leetcode;

import java.util.Scanner;

public class LeetCode_45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; ++i){
            nums[i] = sc.nextInt();
        }

        Solution_45 sol = new Solution_45();
        System.out.println(sol.jump(nums));
    }
}

class Solution_45 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int min, k;
        dp[nums.length-1] = 0;
        for(int i = nums.length-2; i>=0; --i){
            if(i + nums[i]>nums.length-1){
                k = nums.length-1;
            }else{
                k = i + nums[i];
            }
            min = dp[k];
            for(int j = i+1; j<k; ++j){
                if(dp[j] < min){
                    min = dp[j];
                }
            }
            if(min == 2147483647 || nums[i] == 0){
                dp[i] = 2147483647;
                continue;
            }
            dp[i] = min+1;
        }
        return dp[0];
    }
}