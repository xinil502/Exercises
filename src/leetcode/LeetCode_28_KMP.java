package leetcode;

/**
 * 28. 实现 strStr()
 *
 * @Author: Xinil
 * @Date: 2021/4/20 11:47
 */
public class LeetCode_28_KMP {
    /*
     * 使用 subString 截取定长比较——1ms
     * 使用 KMP 算法进行匹配——2ms
     * 优化 next 数组为 nextval数组——3ms
     */

    class Solution_subString {
        public int strStr(String haystack, String needle) {
            int n = haystack.length(), m = needle.length();
            for (int i = 0; i < n - m + 1; i++) {
                String sub = haystack.substring(i, i + m);
                if (sub.equals(needle)) return i;
            }
            return -1;
        }
    }

    class Solution_KMP {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            char[] haystacks = haystack.toCharArray();
            char[] needles = needle.toCharArray();
            int[] next = new int[needles.length + 1];
            next[0] = -1;
            next[1] = 0;
            int len = 0;
            for (int i = 1; i < needles.length - 1; ) { //计算next数组
                if (len == -1 || needles[i] == needles[len]) {
                    ++i;
                    ++len;
                    next[i] = len;
                    if (needles[i] == needles[next[i]]) { //nextval
                        next[i] = next[next[i]];
                    }
                } else {
                    len = next[len];
                }
            }


            int i = 0;
            int j = 0;
            while (i < haystacks.length && j < needles.length) {
                if (j == -1 || haystacks[i] == needles[j]) {
                    ++i;
                    ++j;
                } else {
                    j = next[j];
                }
            }
            if (j == needles.length) {
                return i - needles.length;
            } else {
                return -1;
            }
        }
    }
}
