package leetcode;

import java.util.Scanner;

public class LeetCode_136 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),i;
        int[] nums = new int[n];
        for(i = 0; i<n; ++i){
            nums[i] = sc.nextInt();
        }

        Solution_136 sol = new Solution_136();
        System.out.println(sol.singleNumber(nums));
    }

}
class Solution_136 { //用异或运算消去相同的数字
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int i:nums){
            num = num^i;
        }
        return num;
    }
}