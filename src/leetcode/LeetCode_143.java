package leetcode;

import java.util.Stack;

/**
 * 143. 重排链表
 */
public class LeetCode_143 {
    public static void main(String[] args) {
        ListNode head = ListNode.createList();

        Solution_143 sol = new Solution_143();
        sol.reorderList(head);
        System.out.println(head.toString());
    }
}

class Solution_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        fast = head;
        Stack<ListNode> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        while (!stack.empty()) {
            slow = stack.pop();
            slow.next = fast.next;
            fast.next = slow;
            fast = slow.next;
        }
        while (fast.next != slow) {
            fast = fast.next;
        }
        fast.next = null;
    }
}