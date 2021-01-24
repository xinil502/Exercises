package leetcode;

import java.util.Scanner;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class LeetCode_538 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.createTree();

        Solution_538 sol = new Solution_538();
        sol.convertBST(root).print(1);
    }
}

class Solution_538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
    }
}