package leetcode;

/**
 * 87. 扰乱字符串
 *
 * @Author: Xinil
 * @Date: 2021/4/16 22:14
 */
public class LeetCode_87_扰乱字符串_记忆化搜索 {
    /**
     * 对于两个个字符串，每种截断都有两种处理方式，需要对两种方式进行递归判断。
     * <p>
     * 使用记忆化搜索来优化时间。
     * judge[i][j][k] 数组存储 s1字符串从i开始，s2字符串从j开始，长度都为 k 的子字符串是否相同。
     */
    class Solution {
        int[][][] judge;
        char[] chars1;
        char[] chars2;

        public boolean isScramble(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            } else if (s1.length() == 1) {
                return false;
            }
            int len = s1.length();
            judge = new int[len][len][len];
            chars1 = s1.toCharArray();
            chars2 = s2.toCharArray();

            for (int i = 1; i < len; ++i) {
                if (dfs(0, 0, i) && dfs(i, i, len - i) || dfs(0, len - i, i) && dfs(i, 0, len - i)) {
                    return true;
                }
            }
            return false;
        }


        boolean dfs(int start1, int start2, int length) {
            if (judge[start1][start2][length] != 0) { //先从记忆化数组中去查找信息。
                return judge[start1][start2][length] == 1;
            }
            if (length == 1) { //长度为1，直接判断是否相等
                if (chars1[start1] == chars2[start2]) {
                    judge[start1][start2][length] = 1;
                } else {
                    judge[start1][start2][length] = -1;
                }
                return judge[start1][start2][length] == 1;
            }
            int end = start2 + length;
            for (int i = 1; i < length; ++i) {//递归
                if (dfs(start1, start2, i) && dfs(start1 + i, start2 + i, length - i) || dfs(start1, end - i, i) && dfs(start1 + i, start2, length - i)) {
                    judge[start1][start2][length] = 1;
                    return true;
                }
            }
            judge[start1][start2][length] = -1;
            return false;
        }
    }
}
