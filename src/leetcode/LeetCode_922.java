package leetcode;

import java.util.Arrays;

/**
 * 922. 按奇偶排序数组 II
 */
public class LeetCode_922 {
    public static void main(String[] args) {
        int[] nums = Utils.createArray();

        Solution_922 sol = new Solution_922();
        System.out.println(Arrays.toString(sol.sortArrayByParityII(nums)));
    }
}

class Solution_922 {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1, temp = 0;
        while (i < A.length && j < A.length) {
            if (A[i] % 2 == 1 && A[j] % 2 == 0) {
                temp = A[i] ^ A[j];
                A[i] = temp ^ A[i];
                A[j] = temp ^ A[j];
            } else {
                if (A[i] % 2 == 0) {
                    i += 2;
                }
                if (A[j] % 2 == 1) {
                    j += 2;
                }
            }
        }
        return A;
    }
}