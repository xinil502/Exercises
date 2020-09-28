package leetcode;

import java.util.Scanner;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public void creatNode() {
        Scanner sca = new Scanner(System.in);
        int judge = sca.nextInt(), val;
        if (judge == 1) {
            val = sca.nextInt();
            this.left = new Node(val);
            this.left.creatNode();
        }
        judge = sca.nextInt();
        if (judge == 1) {
            val = sca.nextInt();
            this.right = new Node(val);
            this.right.creatNode();
        }
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public void print(int i) {  //输出二叉树
        if (i == 1) { //前序输出
            System.out.print(val + " ");
            if (left != null) {
                left.print(i);
            } else {
                System.out.print("null ");
            }
            if (right != null) {
                right.print(i);
            } else {
                System.out.print("null ");
            }
        } else if (i == 2) { //中序输出
            if (left != null) {
                left.print(i);
            } else {
                System.out.print("null ");
            }
            System.out.print(val + " ");
            if (right != null) {
                right.print(i);
            } else {
                System.out.print("null ");
            }
        } else if (i == 3) { //后序输出
            if (left != null) {
                left.print(i);
            } else {
                System.out.print("null ");
            }
            if (right != null) {
                right.print(i);
            } else {
                System.out.print("null ");
            }
            System.out.print(val + " ");
        }
    }
}