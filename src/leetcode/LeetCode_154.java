package leetcode;

import java.util.Scanner;

public class LeetCode_154 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; ++i){
            nums[i] = sc.nextInt();
        }

        Solution_154 sol = new Solution_154();
        System.out.println(sol.findMin(nums));
    }
}

class Solution_154 {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        while(l<r){
            /*
            与题目153相似，但在碰到有重复数的时候
            比如数组[3，3, 3，1，3]此时mid应为左边界
            数组[3, 1, 3, 3, 3]此时mid应为右边界，
            无法根据边界值和mid去二分区间

            可以在判断边界值与mid相等后：++左边界，或者--右边界，
            使一侧边界值改变后，和153题一样处理就好了。
             */
            if(nums[(l+r)/2] == nums[r]){
                --r;
            }else if(nums[(l+r)/2] < nums[r]){
                r = (l+r)/2;
            }else{
                l = (l+r)/2+1;
            }
        }
        return nums[r];
    }
}