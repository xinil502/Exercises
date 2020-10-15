package leetcode;

import java.util.Scanner;

/**
 * LeetCode_116.填充每个结点的下一个右侧结点指针
 */
public class LeetCode_116 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = new Node(scanner.nextInt());
        root.creatNode();

        Solution_116 sol = new Solution_116();
        sol.connect(root);
    }
}

class Solution_116 {
    Node p = null, q = null, nextStart = null;

    public Node connect(Node root) { //使用nextStart去存储层链表的头节点。
        nextStart = root;
        boolean judge;
        while (true) {
            if (nextStart.left == null) {
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
                    q.next = p.right;
                    q = q.next;
                }
                p = p.next;
            }
        }
        return root;
    }
}