package leetcode;

import java.util.Scanner;

/**
 * 129.求根到叶子节点数字之和
 */
public class LeetCode_129 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = new TreeNode(scanner.nextInt());
        root.createTree();

        Solution_129 sol = new Solution_129();
        System.out.println(sol.sumNumbers(root));
    }
}

class Solution_129 {
    int sums = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sums;
    }

    void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = sum * 10 + root.val;
        if (root.left == root.right) {
            sums += sum;
        } else {
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
    }
}