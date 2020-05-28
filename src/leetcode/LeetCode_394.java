package leetcode;

import java.util.Scanner;

public class LeetCode_394 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Solution_397 sol = new Solution_397();
        System.out.println(sol.decodeString(s));
    }
}

class Solution_397 {
    public String decodeString(String s) {
        if (s.length() == 0) { //空字符串直接返回
            return s;
        }
        int i, j, num, k = 0;
        String sum = ""; //sum存储总字符串
        String ss = ""; //ss存储小段字符串
        i = j = 0;
        while (i < s.length()) {
            if (s.charAt(i) > 60) { //首个字符为非数字，直接录入，i，j右移
                sum += s.substring(i, i + 1);
                ++i;
                ++j;
                continue;
            }
            ss = "";
            while (s.charAt(j) < 60) { //求出数字部分长度
                ++j;
            }
            num = Integer.valueOf(s.substring(i, j)); //得到数字
            i = j;
            while (true) { //根据[]的对称性，求出字符串部分长度
                if (s.charAt(j) == 91) {
                    ++k;
                }
                if (s.charAt(j) == 93) {
                    --k;
                }
                ++j;
                if (k == 0) {
                    break;
                }
            }
            if (j - i > 2) { //若子字符串存在，递归求出其值
                ss = this.decodeString(s.substring(i + 1, j - 1));
            }
            for (int m = 0; m < num; ++m) {  //循环num遍，加到总串上。
                sum += ss;
            }
            i = j;
        }
        return sum;
    }
}