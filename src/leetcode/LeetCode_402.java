package leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * 402. 移掉K位数字
 */
public class LeetCode_402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nums = sc.next();
        int k = sc.nextInt();

        Solution_402 sol = new Solution_402();
        System.out.println(sol.removeKdigits(nums, k));
    }
}

class Solution_402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int length = num.length();
        int j = 0;
        boolean kk = true;
        for (int i = 0; i < k; ++i) { //移除一个
            if (j < num.length()) {
                char c = num.charAt(j);
                while (stack.isEmpty() || stack.peek() <= c) {
                    stack.push(c);
                    ++j;
                    if (j != num.length()) {
                        c = num.charAt(j);
                    } else {
                        break;
                    }
                }
            } else {
                kk = false;
            }
            stack.pop();
        }

        //字符串合并
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.insert(0, stack.pop());
        }
        if (kk) {
            sb.append(num.substring(j));
        }
        while (sb.toString().startsWith("0")) {
            sb = new StringBuilder(sb.toString().substring(1));
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
