package leetcode;

import java.util.Scanner;

public class LeetCode_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println('0' + 0);
        Solution_8 sol = new Solution_8();
        System.out.println(sol.myAtoi(s));
    }
}

class Solution_8 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        String s = str.trim();
        if (s.length() == 0) {
            return 0;
        }
        int k = 1, sum = 0, i = 0;
        if (s.charAt(0) == '+') {
            i = 1;
        } else if (s.charAt(0) == '-') {
            k = -1;
            i = 1;
        } else if (s.charAt(i) > 47 && s.charAt(i) < 58) {
        } else {
            return 0;
        }
        for (; i < s.length(); ++i) {
            if (s.charAt(i) > 47 && s.charAt(i) < 58) {
                int temp = sum;
                sum = 10 * sum + k * (s.charAt(i) - 48);
                if (k < 0 && (temp < -214748364 || temp == -214748364 && s.charAt(i) - 48 == 9)) {
                    return -2147483648;
                }
                if (k > 0 && (temp > 214748364 || temp == 214748364 && s.charAt(i) - 48 > 7)) {
                    return 2147483647;
                }
                continue;
            }
            break;
        }
        return sum;
    }
}