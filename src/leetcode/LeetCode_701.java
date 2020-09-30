package leetcode;

import java.util.Scanner;

/**
 * LeetCode_701.二叉搜索树中的插入操作。
 */
public class LeetCode_701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.creatTree();

        Solution_701 sol = new Solution_701();
        root = sol.insertIntoBST(root, sc.nextInt());
        root.print(1);
    }
}

class Solution_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return root;
            }
            root.left = insertIntoBST(root.left, val);
            return root;
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return root;
            }
            root.right = insertIntoBST(root.right, val);
            return root;
        }
    }
}