package leetcode;

import java.util.Scanner;

public class LeetCode_344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] s = new char[n];
        s = sc.next().toCharArray();

        Solution_344 sol = new Solution_344();
        sol.reverseString(s);
        System.out.println(s);
    }
}

class Solution_344 {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; ++i) {
            int j = n - 1 - i;
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
    }
}