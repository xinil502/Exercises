package leetcode;

import java.util.Scanner;

public class LeetCode_101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.CreatTree();

        Solution_101 sol = new Solution_101();
        System.out.println(sol.isSymmetric(root));
    }
}


class Solution_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return this.judge(root.left, root.right); //递归判断左右子树是否对称
    }

    boolean judge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return this.judge(root1.left, root2.right) && this.judge(root1.right, root2.left);
    }
}