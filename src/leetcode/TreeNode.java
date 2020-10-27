package leetcode;

import java.util.Scanner;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
        val = 0;
        this.right = null;
        this.left = null;
    }

    public TreeNode(int val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void createTree() {  //创建二叉树
        /*先序创建，
        想输入数据时输入：“1 value”
        想输入null时输入：“0”
         */
        Scanner sca = new Scanner(System.in);
        int judge = sca.nextInt(), val;
        if (judge == 1) {
            val = sca.nextInt();
            this.left = new TreeNode(val);
            this.left.createTree();
        }
        judge = sca.nextInt();
        if (judge == 1) {
            val = sca.nextInt();
            this.right = new TreeNode(val);
            this.right.createTree();
        }
    }

    public static TreeNode create() {  //创建二叉树
        TreeNode root = new TreeNode();
        root.createTree();
        return root;
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
