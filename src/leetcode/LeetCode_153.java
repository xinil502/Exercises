package leetcode;

import java.util.Scanner;

public class LeetCode_153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; ++i){
            nums[i] = sc.nextInt();
        }

        Solution_153 sol = new Solution_153();
        System.out.println(sol.findMin(nums));
    }
}

class Solution_153 {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        while(l<r){
            if(nums[(l+r)/2] <= nums[r]){ //与题目154不同，mid始终靠左，不会与右端的数相同。
                r = (l+r)/2;
            }else{
                l = (l+r)/2+1;
            }
        }
        return nums[r];
    }
}