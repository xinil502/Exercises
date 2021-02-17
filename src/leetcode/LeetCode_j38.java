package leetcode;

import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 *
 * @Author: Xinil
 * @Date: 2021/2/17 11:07
 */
public class LeetCode_j38 {
    class Solution {
        char[] chars;
        boolean[] use;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        public String[] permutation(String s) {
            chars = s.toCharArray();
            use = new boolean[chars.length];
            Arrays.fill(use, true);
            dfs(0);
            return list.toArray(new String[0]);
        }

        void dfs(int deep) {
            if (deep == chars.length) {
                list.add(sb.toString());
            }

            //剪枝，保证在前缀相同的情况下，下一个字符不重复，
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < chars.length; ++i) {
                if (use[i]) {
                    if (set.contains(chars[i])) {
                        continue;
                    }
                    set.add(chars[i]);
                    use[i] = false;
                    sb.append(chars[i]);
                    dfs(deep + 1);
                    sb.deleteCharAt(sb.length() - 1);
                    use[i] = true;
                }
            }
        }
    }
}
