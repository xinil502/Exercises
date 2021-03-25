package leetcode;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * @Author: Xinil
 * @Date: 2021/3/25 11:18
 */
public class LeetCode_82 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode first = null, p = head;
            while (true) {
                if (head.next != null && head.val == head.next.val) {
                    while (head.next != null && head.val == head.next.val) {
                        head = head.next;
                    }
                    head = head.next;
                    if (head == null) {
                        return first;
                    }
                } else {
                    if (first == null) {
                        p = first = head;
                    } else {
                        p.next = head;
                        p = p.next;
                    }
                    head = head.next;
                    p.next = null;
                    if (head == null) {
                        return first;
                    }
                }
            }
        }
    }
}
