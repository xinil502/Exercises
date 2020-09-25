package leetcode;

import java.util.Scanner;

/**
 * LeetCode_106.从中序与后序遍历序列构造二叉树
 */
public class LeetCode_106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inorder = new int[n];
        int[] postorder = new int[n];
        for (int i = 0; i < n; ++i) {
            inorder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            postorder[i] = sc.nextInt();
        }

        Solution_106 sol = new Solution_106();
        sol.buildTree(inorder, postorder).print(1);
    }
}


class Solution_106 {
    private int[] in, post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int i;
        in = inorder;
        post = postorder;
        for (i = 0; i < postorder.length; ++i) {
            if (postorder[postorder.length - 1] == inorder[i]) {
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        if (i != 0) {
            root.left = buildChildTree(0, i - 1, 0, i - 1);
        }
        if (i != postorder.length - 1) {
            root.right = buildChildTree(i + 1, postorder.length - 1, i, postorder.length - 2);
        }
        return root;
    }

    private TreeNode buildChildTree(int start1, int end1, int start2, int end2) {
        if (end1 - start1 == 0) {
            return new TreeNode(in[start1]);
        }
        int i;
        for (i = 0; start1 + i <= end1; ++i) {
            if (post[end2] == in[start1 + i]) {
                break;
            }
        }
        TreeNode root = new TreeNode(post[end2]);
        if (i != 0) {
            root.left = buildChildTree(start1, start1 + i - 1, start2, start2 + i - 1);
        }
        if (start1 + i != end1) {
            root.right = buildChildTree(start1 + i + 1, end1, start2 + i, end2 - 1);
        }
        return root;
    }
}