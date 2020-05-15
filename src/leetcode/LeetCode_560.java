package leetcode;

import java.util.Scanner;

public class LeetCode_560 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),i;
        int[] nums = new int[n];
        for(i = 0; i<n; ++i){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.subarraySum(nums,k));
    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        int i=0,j=0,sumk=0,sum=0;
        for(j=0; j<nums.length; ++j){ //暴力遍历
            sumk = 0;
            for(i=j; i<nums.length; ++i){
                sumk+=nums[i];
                if(sumk == k){
                    ++sum;
                }
            }
        }
        return sum;
    }
}