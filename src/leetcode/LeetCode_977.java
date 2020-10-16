package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * LeetCode_977.有序数组的平方
 */
public class LeetCode_977 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextInt();
        }

        Solution_977 sol = new Solution_977();
        a = sol.sortedSquares(a);
        for (int i : a) {
            System.out.print(i);
        }
    }
}

class Solution_977 {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            A[i] = (int) Math.pow(A[i], 2);
        }
        Arrays.sort(A);
        return A;
    }
}