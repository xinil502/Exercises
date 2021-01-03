package leetcode;

/**
 * 86.分隔链表
 */
public class LeetCode_86 {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode head1 = new ListNode();
            ListNode head2 = new ListNode();
            ListNode p, q;
            p = head1;
            q = head2;
            while (head != null) {
                if (head.val < x) {
                    p.next = head;
                    p = p.next;
                } else {
                    q.next = head;
                    q = q.next;
                }
                head = head.next;
            }
            p.next = head2.next;
            q.next = null;
            return head1.next;
        }
    }
}
