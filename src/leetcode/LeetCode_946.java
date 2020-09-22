package leetcode;

import java.util.Scanner;
import java.util.Stack;

public class LeetCode_946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] push = new int[n];
        for (int i = 0; i < n; ++i) {
            push[i] = sc.nextInt();
        }
        int[] pop = new int[n];
        for (int i = 0; i < n; ++i) {
            pop[i] = sc.nextInt();
        }
        Solution_946 sol = new Solution_946();
        System.out.println(sol.validateStackSequences(push, pop));
    }
}

class Solution_946 {
    static int[] push, pop;

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Solution_946.push = pushed;
        Solution_946.pop = popped;
        return Solution_946.judge(new Stack<>(), 0, 0);
    }

    static boolean judge(Stack<Integer> stack, int pushIndex, int popIndex) {
        while (true) {
            if (popIndex == pop.length) { //pop已经全部弹出，返回true
                return true;
            }
            if (pushIndex == push.length) { //push已经全部推入，判断是否能弹出。
                if (stack.peek() != pop[popIndex]) {  //无法弹出下一个。
                    return false;
                } else {  //弹出下一个，继续计算
                    stack.pop();
                    return Solution_946.judge((Stack) stack.clone(), pushIndex, popIndex + 1);
                }
            }
            if (!stack.empty() && stack.peek() == pop[popIndex]) {  //未全部推入栈，弹出和不弹出都计算。
                stack.push(push[pushIndex]);
                boolean a = Solution_946.judge((Stack) stack.clone(), pushIndex + 1, popIndex);
                stack.pop();
                stack.pop();
                boolean b = Solution_946.judge((Stack) stack.clone(), pushIndex, popIndex + 1);
                return a || b;
            } else { //无法弹出，只能推入。
                stack.push(push[pushIndex]);
                ++pushIndex;
            }
        }
    }
}