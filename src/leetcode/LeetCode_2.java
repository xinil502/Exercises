package leetcode;

import java.util.Scanner;

/**
 * LeetCode_2.两数之和
 */
public class LeetCode_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        int x = 0;
        ListNode p = head1;
        while (sc.nextInt() != 0) {
            p.next = new ListNode(sc.nextInt());
            p = p.next;

        }
        p = head2;
        while (sc.nextInt() != 0) {
            p.next = new ListNode(sc.nextInt());
            p = p.next;
        }
        Solution_2 sol = new Solution_2();
        head1 = sol.addTwoNumbers(head1.next, head2.next);
        head1.print(head1);
    }
}

class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;
        int x = 0;
        while (l1 != null && l2 != null) {
            p.next = new ListNode();
            int sum = l1.val + l2.val + x;
            p.next.val = sum % 10;
            x = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        if (l1 == null) {
            l1 = l2;
        }
        while (l1 != null) {
            p.next = new ListNode();
            int sum = l1.val + x;
            p.next.val = sum % 10;
            x = sum / 10;
            l1 = l1.next;
            p = p.next;
        }
        if (x != 0) {
            p.next = new ListNode(x);
        }
        return head.next;
    }
}