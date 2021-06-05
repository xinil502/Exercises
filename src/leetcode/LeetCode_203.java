package leetcode;

/**
 * 203. 移除链表元素
 *
 * @Author: Xinil
 * @Date: 2021/6/5 13:07
 */
public class LeetCode_203 {
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val) {
                head = head.next;
            }
            if (head == null) {
                return null;
            }
            ListNode p = head;
            while (p.next != null) {
                if (p.next.val == 6) {
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            return head;
        }
    }
}
