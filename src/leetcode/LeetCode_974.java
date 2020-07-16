package leetcode;

import java.util.Scanner;

public class LeetCode_974 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution_974 sol = new Solution_974();
        System.out.println(sol.subarraysDivByK(nums, k));
    }
}

class Solution_974 { //O(n²)，超时未通过
    public int subarraysDivByK(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int i, j, num = 0, sum = 0, summ = 0;
        for (i = 0; i < A.length; ++i) {
            sum = 0;
            for (j = i; j < A.length; ++j) {
                sum += A[j];
                if (sum % K == 0) {
                    ++num;
                }
            }
        }
        return num;
    }
}