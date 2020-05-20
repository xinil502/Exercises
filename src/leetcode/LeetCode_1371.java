package leetcode;

import java.util.Scanner;

public class LeetCode_1371 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        Solution_1371 sol = new Solution_1371();
        System.out.println(sol.findTheLongestSubstring(str));
    }
}

class Solution_1371 {
    public int findTheLongestSubstring(String s) {
        int status = 0;  //用二进制数状态压缩
        int[] lang = new int[32];
        int max = 0;
        lang[0] = -1;// 0的状态第一次出现，在字符串以-1为索引值结尾。
        for (int i = 1; i < 32; ++i) {
            lang[i] = -8; //未出现状态。
        }
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'a') { //更改状态
                status ^= 1;

            } else if (s.charAt(i) == 'e') {
                status ^= 2;

            } else if (s.charAt(i) == 'i') {
                status ^= 4;

            } else if (s.charAt(i) == 'o') {
                status ^= 8;

            } else if (s.charAt(i) == 'u') {
                status ^= 16;

            }
            if (lang[status] == -8) { //第一次出现这种状态
                lang[status] = i;
            } else if (i - lang[status] > max) {  //重复出现这种状态计算长度
                max = i - lang[status];
            }
        }
        return max;
    }
}