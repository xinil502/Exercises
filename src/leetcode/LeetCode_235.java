package leetcode;

import java.util.Scanner;

/**
 * 235.二叉搜索树的最近公共祖先
 */
public class LeetCode_235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.createTree();

        TreeNode p = new TreeNode(sc.nextInt());
        TreeNode q = new TreeNode(sc.nextInt());

        Solution_235 sol = new Solution_235();
        root = sol.lowestCommonAncestor(root, p, q);
        root.print(1);
    }
}

class Solution_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val || (root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val)) {
            return root;
        } else if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}