package leetcode;

import java.util.Scanner;

/**
 * LeetCode_19.删除链表的倒数第N个节点
 */
public class LeetCode_19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode list = new ListNode();
        list.BuildList(scanner.nextInt());

        Solution_19 sol = new Solution_19();
        list.print(sol.removeNthFromEnd(list, scanner.nextInt()));
        scanner.close();
    }
}

class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p, q;
        p = q = head;
        for (int i = 0; i < n; ++i) {
            q = q.next;
        }

        while (q != null && q.next != null) {
            q = q.next;
            p = p.next;
        }
        if (q == null) {
            return head.next;
        }
        p.next = p.next.next;
        return head;
    }
}