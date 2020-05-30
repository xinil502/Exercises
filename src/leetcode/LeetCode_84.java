package leetcode;

import java.util.Scanner;

public class LeetCode_84 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution_84 sol = new Solution_84();
        System.out.println(sol.largestRectangleArea(nums));
    }
}

class Solution_84 {
    /*
     * 使用栈去存储高度对应的数组索引值，让高度保持递增。
     * 当碰到一个比栈顶矮的高度时，结算栈内高度
     * (通过当前位置与栈顶的下一层来判断栈顶的高度对应的宽度)
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        ListNode stack = new ListNode(-1);
        ListNode s;
        int i, j, max = 0;
        for (i = 0; i < heights.length; ++i) {
            if (stack.val != -1 && heights[i] < heights[stack.val]) {
                while (stack.val != -1 && heights[i] < heights[stack.val]) { //不满足递增，让栈顶出栈。
                    max = Math.max(max, heights[stack.val] * (i - stack.next.val - 1));
                    stack = stack.next;
                }
            }
            s = new ListNode(i);  //将新高度加入
            s.next = stack;
            stack = s;
        }
        while (stack.val != -1) {
            max = Math.max(max, heights[stack.val] * (i - stack.next.val - 1));
            stack = stack.next;
        }
        return max;
    }
}