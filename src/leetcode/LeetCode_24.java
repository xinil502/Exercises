package leetcode;

import java.util.Scanner;

public class LeetCode_24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode list = new ListNode();
        list.BuildList(scanner.nextInt());

        Solution_24 sol = new Solution_24();
        list.print(sol.swapPairs(list));
    }
}

class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            head.next.next = head;
            head = head.next;
            head.next.next = null;
            return head;
        }
        ListNode p, q, h;
        h = head;
        p = head.next;
        q = head.next.next;
        p.next = h;
        h.next = q;
        head = p;
        h = p = q = head.next;
        while (h.next != null && h.next.next != null) {
            p = h.next;
            q = h.next.next;
            h.next = q;
            p.next = q.next;
            q.next = p;
            h = p = q = p;
        }
        return head;
    }
}