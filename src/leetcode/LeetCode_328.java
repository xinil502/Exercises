package leetcode;

/**
 * 328.奇偶链表
 */
public class LeetCode_328 {
    public static void main(String[] args) {
        ListNode head = Utils.createList();

        Solution_328 sol = new Solution_328();
        sol.oddEvenList(head).print();
    }
}

class Solution_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode head2, p, q, t;
        head2 = head.next;
        p = head;
        q = head.next;
        t = head.next.next;
        boolean judge = true;
        while (t != null) {
            if (judge) {
                p.next = t;
                p = p.next;
                judge = false;
            } else {
                q.next = t;
                q = q.next;
                judge = true;
            }
            t = t.next;
        }
        p.next = head2;
        q.next = null;
        return head;
    }
}