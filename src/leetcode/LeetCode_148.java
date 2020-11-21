package leetcode;

public class LeetCode_148 {

    /**
     * 148. 排序链表
     */
    class Solution_148 {
        public ListNode sortList(ListNode head) { //快慢指针寻找链表中间节点，将两个子链分别排序
            if (head == null || head.next == null) {
                return head;
            }
            ListNode fast, slow;
            slow = head;
            fast = slow.next;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            fast = sortList(slow.next);
            slow.next = null;
            slow = sortList(head);
            return fun(fast, slow);
        }

        ListNode fun(ListNode l1, ListNode l2) {//将两个排序后的子链表合并，得到完整的排序后的链表
            ListNode head = new ListNode();
            ListNode p = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            if (l1 == null) {
                p.next = l2;
            } else {
                p.next = l1;
            }
            return head.next;
        }
    }
}
