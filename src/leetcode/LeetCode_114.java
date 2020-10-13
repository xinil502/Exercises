package leetcode;

import java.util.Scanner;

/**
 * LeetCode_114.二叉树展开为链表
 */
public class LeetCode_114 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.createTree();

        Solution_114 sol = new Solution_114();
        sol.flatten(root);
        root.print(1);
    }
}

class Solution_114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            while (root.right != null) {
                root = root.right;
            }
            root.right = temp;
        }
        flatten(root.right);
    }
}