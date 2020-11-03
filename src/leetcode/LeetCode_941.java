package leetcode;

import java.util.Scanner;

/**
 * 941.有效的山脉数组
 */
public class LeetCode_941 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
        }

        Solution_941 sol = new Solution_941();
        System.out.println(sol.validMountainArray(nums));
    }
}

class Solution_941 {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3 || A[0] > A[1]) {
            return false;
        }
        boolean bool = true;
        int i;
        for (i = 1; i < A.length; ++i) {
            if (A[i] == A[i - 1]) {
                return false;
            }
            if (bool) {
                if (A[i - 1] > A[i]) {
                    bool = false;
                }
            } else {
                if (A[i - 1] < A[i]) {
                    break;
                }
            }
        }
        if (i == A.length && !bool) {
            return true;
        }
        return false;
    }
}