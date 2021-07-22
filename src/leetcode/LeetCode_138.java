package leetcode;

import java.util.HashMap;

/**
 * 138. 复制带随机指针的链表
 *
 * @Author: Xinil
 * @Date: 2021/7/22 21:32
 */


public class LeetCode_138 {
    class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //遍历第一遍，创建每个节点的拷贝节点。
    //使用HashMap 维护新、旧节点的对应关系。
    //遍历第二遍，拷贝新旧节点的值。
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node cur = head;
            HashMap<Node, Node> map = new HashMap<>();
            while (cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);
        }
    }
}
