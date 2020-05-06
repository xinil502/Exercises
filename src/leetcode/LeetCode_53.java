package leetcode;

import java.util.Scanner;

public class LeetCode_53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; ++i){
            nums[i] = sc.nextInt();
        }
        Solution_53 sol = new Solution_53();
        System.out.println(sol.maxSubArray(nums));
    }
}

class Solution_53 {
    public int maxSubArray(int[] nums) {
        /*
        将以第i个数结尾的最大子序的和存在numa中
        （要么连接上一个最大子序numa+nums[i]，，要么新的开始，存入nums[i]）
         */
        int i, max, numa;
        max = numa = nums[0];
        for(i=1; i<nums.length; ++i){
            numa = nums[i]>nums[i]+numa?nums[i]:nums[i]+numa;
            if(numa > max){ //与第i-1个数结尾的最大子序作比较
                max = numa;
            }
        }
        return max;
    }
}