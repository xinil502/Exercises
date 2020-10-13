package leetcode;

import java.util.Scanner;

/**
 * LeetCode_104.二叉树的最大深度
 */
public class LeetCode_104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.createTree();

        Solution_104 sol = new Solution_104();
        System.out.println(sol.maxDepth(root));
    }
}

class Solution_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}