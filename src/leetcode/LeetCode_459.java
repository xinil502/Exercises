package leetcode;

import java.util.Scanner;

/**
 * LeetCode_459.重复的字符串
 */
public class LeetCode_459 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Solution_459 sol = new Solution_459();
        System.out.println(sol.repeatedSubstringPattern(sc.next()));
    }
}


class Solution_459 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}