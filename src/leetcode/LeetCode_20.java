package leetcode;

/**
 * 20. 有效的括号
 *
 * @Author: Xinil
 * @Date: 2021/2/4 18:30
 */
public class LeetCode_20 {
    class Solution {
        public boolean isValid(String s) {
            //参数校验
            if (s == null || "".equals(s) || s.length() % 2 == 1) {
                return false;
            }
            //用char数组模拟栈
            char[] stack = new char[s.length()];
            //栈指针
            int index = -1;
            for (char sChar : s.toCharArray()) {
                if (sChar == '(' || sChar == '[' || sChar == '{') {
                    stack[++index] = sChar;
                } else if (index < 0) {
                    return false;
                } else if (sChar == ')' && stack[index] != '(') {
                    return false;
                } else if (sChar == ']' && stack[index] != '[') {
                    return false;
                } else if (sChar == '}' && stack[index] != '{') {
                    return false;
                } else {
                    --index;
                }
            }
            return index == -1;
        }
    }

}
