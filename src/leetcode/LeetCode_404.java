package leetcode;

import java.util.Scanner;

/**
 * LeetCode_404.左叶子之和
 */
public class LeetCode_404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.createTree();

        Solution_404 sol = new Solution_404();
        System.out.println(sol.sumOfLeftLeaves(root));
    }
}

class Solution_404 {
    int n;

    public int sumOfLeftLeaves(TreeNode root) {
        n = 0;
        dfs(root);
        return n;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            n += root.left.val;
        }
        dfs(root.right);
        dfs(root.left);
    }
}