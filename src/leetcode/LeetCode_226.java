package leetcode;

import java.util.Scanner;

/**
 * LeetCode_226.翻转二叉树
 */
public class LeetCode_226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.CreatTree();
        Solution_226 sol = new Solution_226();
        root = sol.invertTree(root);
        root.print(1);
    }
}

class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = dfs(root.left);
        root.left = dfs(root.right);
        root.right = temp;
        return root;
    }
}