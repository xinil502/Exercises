package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_m16_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(), l = sc.nextInt(), k = sc.nextInt();

        Solution_16_11 sol = new Solution_16_11();
        System.out.println(Arrays.toString(sol.divingBoard(s, l, k)));
    }
}

class Solution_16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (longer == shorter) {
            return new int[]{shorter * k};
        }
        int[] num = new int[k + 1];
        num[0] = shorter * k;
        int jj = longer - shorter;
        for (int i = 1; i < num.length; ++i) {
            num[i] = num[i - 1] + jj;
        }
        return num;
    }
}