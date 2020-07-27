package leetcode;

import java.util.Scanner;

/**
 * LeetCode_392.判断子序列
 */
public class LeetCode_392 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s, t;
        s = sc.next();
        t = sc.next();

        Solution_392 sol = new Solution_392();
        System.out.println(sol.isSubsequence(s, t));
    }
}


class Solution_392 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }
        int i = 0, j = 0, m = s.length(), n = t.length();
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
            }
            ++j;
        }
        if (i == m) {
            return true;
        }
        return false;
    }
}