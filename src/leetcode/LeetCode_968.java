package leetcode;

import java.util.Scanner;

/**
 * LeetCode_968.监控二叉树
 */
public class LeetCode_968 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.creatTree();

        Solution_968 sol = new Solution_968();
        System.out.println(sol.minCameraCover(root));
    }
}

class Solution_968 {
    private int ans = 0;

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        if (dfs(root) == 2) ans++;
        return ans;
    }

    // 0：该节点安装了监视器 1：该节点可观，但没有安装监视器 2：该节点不可观
    private int dfs(TreeNode node) {
        if (node == null)
            return 1;
        int left = dfs(node.left), right = dfs(node.right);
        if (left == 2 || right == 2) {
            ans++;
            return 0;
        } else if (left == 0 || right == 0) {
            return 1;
        } else
            return 2;
    }
}