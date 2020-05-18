package leetcode;

import java.util.Scanner;

public class LeetCode_152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; ++i){
            nums[i] = sc.nextInt();
        }

        Solution_152_1 sol = new Solution_152_1();
        System.out.println(sol.maxProduct(nums));
    }
}

class Solution_152_1 { //dp第i个数结尾的最大最小乘积串。
    public int maxProduct(int[] nums) {
        int max,min,num,temp;
        num = min = max = nums[0];
        for(int i=1; i<nums.length; ++i){
            temp = Math.max(Math.max(max*nums[i], min*nums[i]),nums[i]);
            min = Math.min(Math.min(max*nums[i], min*nums[i]),nums[i]);
            max = temp;
            num = Math.max(num, max);
        }
        return num;
    }
}

class Solution_152_2 { //暴力解。
    public int maxProduct(int[] nums) {
        int num,max = nums[0],i,j;
        for(i = 0; i<nums.length; ++i){
            num = 1;
            for(j = i; j<nums.length; ++j){
                num *= nums[j];
                if(num > max){
                    max = num;
                }
            }
        }
        return max;
    }
}