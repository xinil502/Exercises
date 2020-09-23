package leetcode;

import java.util.Scanner;

/**
 * LeetCode_617.合并二叉树
 */
public class LeetCode_617 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root1 = new TreeNode(sc.nextInt());
        root1.creatTree();
        TreeNode root2 = new TreeNode(sc.nextInt());
        root2.creatTree();

        Solution_617 sol = new Solution_617();
        sol.mergeTrees(root1, root2).print(1);
    }
}

class Solution_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}