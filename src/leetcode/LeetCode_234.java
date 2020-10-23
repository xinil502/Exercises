package leetcode;

import java.util.Stack;

/**
 * 234. 回文链表
 */
public class LeetCode_234 {
    public static void main(String[] args) {
        ListNode head = ListNode.createList();

        Solution_234 sol = new Solution_234();
        System.out.println(sol.isPalindrome(head));
    }
}

class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow, fast;
        slow = head;
        fast = head.next;
        Stack<Integer> stack = new Stack<>();
        stack.push(slow.val);
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.push(slow.val);
        }
        if (fast == null) {
            stack.pop();
        }
        slow = slow.next;
        while (slow != null && !stack.empty() && stack.pop() == slow.val) {
            slow = slow.next;
        }
        if (slow == null && stack.empty()) {
            return true;
        }
        return false;
    }
}
