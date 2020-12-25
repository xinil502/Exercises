package leetcode;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class LeetCode_455 {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0, j = 0;
            int length1 = g.length;
            int length2 = s.length;
            int sum = 0;
            while (i < length1 && j < length2) {
                if (g[i] <= s[j]) {
                    ++sum;
                    ++i;
                }
                ++j;
            }
            return sum;
        }
    }
}
