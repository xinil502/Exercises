package leetcode;

import java.util.Scanner;

/**
 * LeetCode_117.填充每个节点的下一个右侧节点指针
 */
public class LeetCode_117 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = new Node(sc.nextInt());
        root.creatNode();

        Solution_117 sol = new Solution_117();
        root = sol.connect(root);
        root.print(1);
    }
}


class Solution_117 {
    Node p = null, q = null, nextStart = null;

    public Node connect(Node root) { //使用nextStart去存储层链表的头节点。
        nextStart = root;
        boolean judge;
        while (true) {
            if (nextStart == null) {
                break;
            }
            p = nextStart;
            nextStart = null;
            judge = true;
            while (p != null) {
                if (p.left != null) {
                    if (judge) {
                        q = nextStart = p.left;
                        judge = false;
                    } else {
                        q.next = p.left;
                        q = p.left;
                    }
                }
                if (p.right != null) {
                    if (judge) {
                        q = nextStart = p.right;
                        judge = false;
                    } else {
                        q.next = p.right;
                        q = p.right;
                    }
                }
                p = p.next;
            }
        }
        return root;
    }
}