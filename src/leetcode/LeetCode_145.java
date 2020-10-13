package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * LeetCode_145.二叉树的后续遍历
 */
public class LeetCode_145 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.createTree();

        Solution_145 sol = new Solution_145();
        List<Integer> list = sol.postorderTraversal(root);
    }
}

class Solution_145 {  //只写了递归方法
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return list;
    }

    void dfs(TreeNode root) {
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        list.add(root.val);
    }
}