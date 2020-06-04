package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution_238 sol = new Solution_238();
        System.out.println(Arrays.toString(nums));
    }
}


class Solution_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i > 0; --i) {
            right *= nums[i];
            left[i - 1] *= right;
        }

        return left;
    }
}