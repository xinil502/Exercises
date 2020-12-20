package leetcode;

import java.util.Stack;

/**
 * 316. 去除重复字母
 */
public class LeetCode_316 {
    class Solution {
        //找出最小的满足 s[i]>s[i+1] 的下标 i，并去除字符 s[i]。
        public String removeDuplicateLetters(String s) {
            int[] lastExist = new int[26];
            boolean[] exist = new boolean[26];
            Stack<Character> stack = new Stack<>();
            int i = 0;
            //计算每个字符最后一次出现的位置。
            for (char c : s.toCharArray()) {
                lastExist[c - 'a'] = i;
                ++i;
            }
            i = 0;
            for (char c : s.toCharArray()) {
                //栈中已有字符，就不能再插入了
                if (!exist[c - 'a']) {
                    //插入前和前面的字符作比较
                    while (!stack.empty()) {
                        //如果栈顶字符大于当前字符，且后面还会出现栈顶字符，就将栈顶弹出。
                        if (stack.peek() >= c && lastExist[stack.peek() - 'a'] >= i) {
                            exist[stack.pop() - 'a'] = false;
                        } else {
                            break;
                        }
                    }
                    //可以入栈了。
                    stack.push(c);
                    exist[c - 'a'] = true;
                }
                ++i;
            }
            String str = "";
            while (!stack.empty()) {
                str = stack.pop() + str;
            }
            return str;
        }
    }
}
