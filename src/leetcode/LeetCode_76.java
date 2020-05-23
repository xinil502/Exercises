package leetcode;

import java.util.Scanner;

public class LeetCode_76 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        sc.close();

        Solution_76 sol = new Solution_76();
        System.out.println(sol.minWindow(s, t));
    }
}

class Solution_76 {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        String min = s;
        int i, j, k, judge = 0;
        int[] num = new int[t.length()];
        int[] numm = new int[t.length()];
        for (k = 0; k < t.length(); ++k) {
            for (i = 0; i < t.length(); ++i) {
                if (t.charAt(i) == t.charAt(k)) {
                    ++numm[k];
                }
            }
        }
        for (i = 0, j = 0; j < s.length(); ++j) {//右端右移
            for (k = 0; k < t.length(); ++k) {  //判断是否为t串中的字符
                if (s.charAt(j) == t.charAt(k)) {
                    ++num[k];
                }
            }
            for (k = 0; k < t.length(); ++k) { //判断是否已经覆盖字符串t
                if (num[k] < numm[k]) {
                    break;
                }
            }
            if (k != t.length()) { //未覆盖，，++j， 右端右移，进行下一次循环
                continue;
            }
            judge = 0;
            for (; judge == 0; ++i) { //尝试左端右移
                String kk = s.substring(i, j + 1);
                if (kk.length() < min.length()) {
                    min = kk; //已经覆盖，，赋值
                }
                for (k = 0; k < t.length(); ++k) {
                    if (s.charAt(i) == t.charAt(k)) {
                        --num[k];
                        if (num[k] < numm[k]) {  //如果右移后不存在于子串中，跳出
                            judge = 1;
                        }
                    }
                }
            }
        }
        if (judge == 1) { //覆盖过
            return min;
        }//未覆盖过
        return "";
    }
}