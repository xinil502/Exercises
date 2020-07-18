package leetcode;

import java.util.Scanner;

public class LeetCode_97 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1, s2, s3;
        s1 = sc.next();
        s2 = sc.next();
        s3 = sc.next();

        Solution_97_2 sol = new Solution_97_2();
        System.out.println(sol.isInterleave(s1, s2, s3));
    }
}

class Solution_97_1 {  //优化深搜，勉强通过。
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {  //长度不等，直接false
            return false;
        }
        int i = 0, j = 0, len = 0, lenth = 0;
        for (; len < s3.length(); ++len) { //开始循环判断字符
            if (s1.length() == i) {  //字符串1读完，直接判断2 3剩下的部分。
                return s2.substring(j).equals(s3.substring(len));
            } else if (s2.length() == j) { ////字符串2读完，直接判断1 3剩下的部分。
                return s1.substring(i).equals(s3.substring(len));
            }

            //出现字符相同时，判断相同字符长度
            while (s1.charAt(i) == s3.charAt(len) && s2.charAt(j) == s3.charAt(len)) {
                ++lenth;
                ++i;
                ++j;
                ++len;
                //有一个字符读完，则比较取两段字符的两种情况
                if (s1.length() == i) {
                    return s2.substring(j - lenth).equals(s3.substring(len)) || isInterleave(s1.substring(i - lenth), s2.substring(j), s3.substring(len));
                } else if (s2.length() == j) {
                    return s1.substring(i - lenth).equals(s3.substring(len)) || isInterleave(s1.substring(i), s2.substring(j - lenth), s3.substring(len));
                }

                /*如果有字符不相等，则需要递归深搜
                 * 反例：
                 * aacaac
                 * aacaaeaac
                 * aacaacaaeaacaac
                 * 必须要在第一段取且仅取三个字符 aac，才能读取s3的e
                 * 而如果直接一步找到最长公共前缀，则无法得到正确答案：true
                 */
                if (s1.charAt(i) == s3.charAt(len) && s2.charAt(j) == s3.charAt(len) && s1.charAt(i) != s1.charAt(i - 1)) {
                    return isInterleave(s1.substring(i), s2.substring(j - lenth), s3.substring(len)) || isInterleave(s1.substring(i - lenth), s2.substring(j), s3.substring(len));
                }
            }
            if (lenth != 0) { //正常跳出循环，深搜
                return isInterleave(s1.substring(i), s2.substring(j - lenth), s3.substring(len)) || isInterleave(s1.substring(i - lenth), s2.substring(j), s3.substring(len));
            }

            /*
             * 没有公共前缀，则判断是否有唯一前缀与s3相同。
             */
            if (s1.charAt(i) == s3.charAt(len)) {
                ++i;
                continue;
            }
            if (s2.charAt(j) == s3.charAt(len)) {
                ++j;
                continue;
            }
            //s1,s2均未匹配到字符
            return false;
        }
        //正常结束
        return true;
    }
}


class Solution_97_2 {  //dp[i][j]。
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {  //长度不等，直接false
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        int i, j;
        dp[0][0] = true;
        for (j = 1; j <= s2.length(); ++j) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (i = 1; i <= s1.length(); ++i) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (i = 1; i <= s1.length(); ++i) {
            for (j = 1; j <= s2.length(); ++j) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}