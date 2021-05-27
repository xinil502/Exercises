package leetcode;

import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 *
 * @Author: Xinil
 * @Date: 2021/5/27 20:54
 */
public class LeetCode_1190 {
    class Solution {
        public String reverseParentheses(String s) {
            int n = s.length();
            int[] pair = new int[n];
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (s.charAt(i) == ')') {
                    int j = stack.pop();
                    pair[i] = j;
                    pair[j] = i;
                }
            }

            StringBuffer sb = new StringBuffer();
            int index = 0, step = 1;
            while (index < n) {
                if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                    index = pair[index];
                    step = -step;
                } else {
                    sb.append(s.charAt(index));
                }
                index += step;
            }
            return sb.toString();
        }
    }
}
