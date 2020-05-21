package leetcode;

import java.util.Scanner;

public class LeetCode_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        Solution_5 sol = new Solution_5();
        System.out.println(sol.longestPalindrome(s));
    }
}

class Solution_5 {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int i, j, k;
        String str = s.substring(0, 1);
        for (i = 1; i < s.length(); ++i) { //遍历一遍字符串，以第i个字符为中心扩展。
            k = 1;
            while (i - k > -1 && i + k < s.length() && s.charAt(i - k) == s.charAt(i + k)) { //回文串为奇数串
                ++k;
            }
            if (2 * k - 1 > str.length()) {
                str = s.substring(i - k + 1, i + k);
            }
            k = 0;
            while (i - k - 1 > -1 && i + k < s.length() && s.charAt(i - 1 - k) == s.charAt(i + k)) { //回文串为偶数串
                ++k;
            }
            if (2 * k > str.length()) {
                str = s.substring(i - k, i + k);
            }
        }
        return str;
    }
}