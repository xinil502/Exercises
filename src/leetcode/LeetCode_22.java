package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * @Author: Xinil
 * @Date: 2021/5/25 22:43
 */
public class LeetCode_22 {
    class Solution {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        public List<String> generateParenthesis(int n) {
            dfs(n, 0);
            return list;
        }

        void dfs(int n, int need) {
            if (n == 0) {
                for (int i = 0; i < need; ++i) {
                    sb.append(")");
                }
                list.add(sb.toString());
                for (int i = 0; i < need; ++i) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return;
            }
            sb.append("(");
            dfs(n - 1, need + 1);
            sb.deleteCharAt(sb.length() - 1);
            if (need > 0) {
                sb.append(")");
                dfs(n, need - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
