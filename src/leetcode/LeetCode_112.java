package leetcode;

import java.util.Scanner;

public class LeetCode_112 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.createTree();

        int k = sc.nextInt();
        Solution_112 sol = new Solution_112();
        System.out.println(sol.hasPathSum(root, k));
    }
}


class Solution_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return athSum(sum, root, 0);
    }

    boolean athSum(int sum, TreeNode root, int summ) { //递归求路径总和
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null) { //判断是否为叶子节点
            if (sum == summ + root.val) {
                return true;
            } else {
                return false;
            }
        }

        return athSum(sum, root.left, summ + root.val) || athSum(sum, root.right, root.val + summ);
    }
}
