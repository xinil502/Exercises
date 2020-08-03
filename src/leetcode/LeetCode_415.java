package leetcode;

import java.util.Scanner;

/**
 * LeetCode_415.字符串相加
 */
public class LeetCode_415 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        Solution_415 sol = new Solution_415();
        System.out.println(sol.addStrings(s1, s2));
    }
}

class Solution_415 {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return num1;
        }
        if (num1.length() <= num2.length()) {
            return add(num1, num2);
        } else {
            return add(num2, num1);
        }
    }

    String add(String s, String l) {
        int k = 0, b, i = s.length() - 1, j = l.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (j >= 0) {
            if (i < 0) {
                k += l.charAt(j) - 48;
            } else {
                k += s.charAt(i) - 48 + l.charAt(j) - 48;
            }
            b = k % 10;
            k /= 10;
            sb.insert(0, b);
            --i;
            --j;
            if (j < 0 && k > 0) {
                sb.insert(0, k);
            }
        }
        return sb.toString();
    }
}