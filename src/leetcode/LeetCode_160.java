package leetcode;

/**
 * 160. 相交链表
 *
 * @Author: Xinil
 * @Date: 2021/6/4 8:51
 */
public class LeetCode_160 {
    //按不同顺序同时遍历两个链表，如果链表存在相交，则两种遍历必会相遇，首个相交节点即为首个相遇节点
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A = headA;
            ListNode B = headB;
            while (A != B) {
                A = A != null ? A.next : headB;
                B = B != null ? B.next : headA;
            }
            return A;
        }
    }
}
