package leetcode;

import util.MinPriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并K个升序链表
 *
 * @Author: Xinil
 * @Date: 2021/4/27 20:49
 */
public class LeetCode_23 {
    /**
     * 手写小顶堆
     * 908 ms
     */
    class Solution_1 {
        public ListNode mergeKLists(ListNode[] lists) {
            MinPriorityQueue minPriorityQueue = new MinPriorityQueue<Integer>(5000000, Comparator.comparingInt(a -> a));
            for (ListNode head : lists) {
                while (head != null) {
                    minPriorityQueue.insert(head.val);
                    head = head.next;
                }
            }

            ListNode head = new ListNode();
            ListNode p = head;
            while (!minPriorityQueue.isEmpty()) {
                p.next = new ListNode((Integer) minPriorityQueue.delMin());
            }
            p.next = null;
            return head;
        }
    }

    /**
     * 顺序合并排序链表
     * 129 ms
     */
    class Solution_2 {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode ans = null;
            for (int i = 0; i < lists.length; ++i) {
                ans = mergeTwoLists(ans, lists[i]);
            }
            return ans;
        }

        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null) {
                return a != null ? a : b;
            }
            ListNode head = new ListNode(0);
            ListNode tail = head, aPtr = a, bPtr = b;
            while (aPtr != null && bPtr != null) {
                if (aPtr.val < bPtr.val) {
                    tail.next = aPtr;
                    aPtr = aPtr.next;
                } else {
                    tail.next = bPtr;
                    bPtr = bPtr.next;
                }
                tail = tail.next;
            }
            tail.next = (aPtr != null ? aPtr : bPtr);
            return head.next;
        }
    }

    /**
     * 利用用队列，两两合并排序链表
     * 4ms
     */
    class Solution_3 {
        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> queue = new LinkedList<>();
            for (ListNode i : lists) {
                queue.offer(i);
            }
            while (true) {
                ListNode re = queue.remove();
                if (queue.isEmpty()) {
                    return re;
                } else {
                    queue.offer(mergeTwoLists(re, queue.remove()));
                }
            }
        }

        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null) {
                return a != null ? a : b;
            }
            ListNode head = new ListNode(0);
            ListNode tail = head, aPtr = a, bPtr = b;
            while (aPtr != null && bPtr != null) {
                if (aPtr.val < bPtr.val) {
                    tail.next = aPtr;
                    aPtr = aPtr.next;
                } else {
                    tail.next = bPtr;
                    bPtr = bPtr.next;
                }
                tail = tail.next;
            }
            tail.next = (aPtr != null ? aPtr : bPtr);
            return head.next;
        }
    }

    /**
     * 分治，递归合并链表
     */
    class Solution_4 {
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int l, int r) {
            if (l == r) {
                return lists[l];
            }
            if (l > r) {
                return null;
            }
            int mid = (l + r) >> 1;
            return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
        }

        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null || b == null) {
                return a != null ? a : b;
            }
            ListNode head = new ListNode(0);
            ListNode tail = head, aPtr = a, bPtr = b;
            while (aPtr != null && bPtr != null) {
                if (aPtr.val < bPtr.val) {
                    tail.next = aPtr;
                    aPtr = aPtr.next;
                } else {
                    tail.next = bPtr;
                    bPtr = bPtr.next;
                }
                tail = tail.next;
            }
            tail.next = (aPtr != null ? aPtr : bPtr);
            return head.next;
        }
    }

    /**
     * 使用自带的优先队列合并
     * 2ms
     */
    class Solution_5 {
        class Status implements Comparable<Status> {
            int val;
            ListNode ptr;

            Status(int val, ListNode ptr) {
                this.val = val;
                this.ptr = ptr;
            }

            public int compareTo(Status status2) {
                return this.val - status2.val;
            }
        }

        PriorityQueue<Status> queue = new PriorityQueue<>();

        public ListNode mergeKLists(ListNode[] lists) {
            for (ListNode node : lists) {
                if (node != null) {
                    queue.offer(new Status(node.val, node));
                }
            }
            ListNode head = new ListNode(0);
            ListNode tail = head;
            while (!queue.isEmpty()) {
                Status f = queue.poll();
                tail.next = f.ptr;
                tail = tail.next;
                if (f.ptr.next != null) {
                    queue.offer(new Status(f.ptr.next.val, f.ptr.next));
                }
            }
            return head.next;
        }
    }
}
