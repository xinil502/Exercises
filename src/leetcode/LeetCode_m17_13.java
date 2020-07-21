package leetcode;

import java.util.Scanner;

public class LeetCode_m17_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];

        str[0] = sc.nextLine();
        for (int i = 0; i < n; ++i) {
            str[i] = sc.nextLine();
        }

        String ss = sc.nextLine();


        Solution_m17_13 sol = new Solution_m17_13();
        System.out.println(sol.respace(str, ss));
    }
}


class Solution_m17_13 {
    public int respace(String[] dictionary, String sentence) {
        int[] num = new int[sentence.length() + 1];
        int i = 0;
        int[] judge = new int[dictionary.length];

        for (i = 0; i < sentence.length(); ++i) { //字符串遍历第i个字符
            char c = sentence.charAt(i);
            num[i + 1] = num[i] + 1;

            for (int j = 0; j < judge.length; ++j) { //访问第j个字符串
                if (c == dictionary[j].charAt(judge[j])) {  //访问第judge[j]中索引值对应的字符
                    ++judge[j];
                    if (judge[j] == dictionary[j].length()) { //判断是否到达结尾，进行dp
                        num[i + 1] = Math.min(num[i + 1], num[i + 1 - judge[j]]);
                        judge[j] = 0;
                    }
                } else if (c == dictionary[j].charAt(0)) {
                    judge[j] = 1;
                } else {
                    judge[j] = 0;
                }
            }
        }

        return num[num.length - 1];
    }
}
//  ["qowhxw","gobaagbtt","boh","eaqr","ghahqhqungoafnahwwhav","w","nvqx","obqhaxha","aew"]
//"nvqxonnvqx"