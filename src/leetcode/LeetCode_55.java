package leetcode;

import java.util.Scanner;

public class LeetCode_55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; ++i){
            nums[i] = sc.nextInt();
        }

        Solution_55 sol = new Solution_55();
        System.out.println(sol.canJump(nums));
    }
}



class Solution_55 {
    public boolean canJump(int[] nums) {
        int k = nums.length-1;
        for(int i = nums.length-2; i>=0; --i){
            if(i+nums[i]>=k){
                k = i;
            }
        }
        return 0==k;
    }
}