package leetcode;

import java.util.Scanner;

public class LeetCode_105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for (int i = 0; i < n; ++i) {
            preorder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            inorder[i] = sc.nextInt();
        }

        Solution_105 sol = new Solution_105();
        TreeNode root = sol.buildTree(preorder, inorder);
        root.print(1);
        System.out.println();
        root.print(2);
        System.out.println();
        root.print(3);
    }
}


class Solution_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        this.build(preorder, inorder, 0, preorder.length, 0, inorder.length, root);
        return root;
    }

    public void build(int[] preorder, int[] inorder, int i, int j, int m, int n, TreeNode root) {
        int k;
        for (k = 0; k < n; ++k) {
            if (preorder[i] == inorder[m + k]) {
                break;
            }
        }
        /*
         * 递归的去调用
         * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
         *     i                        i+k   i+k+1                   j
         * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
         *    m                m+k-1   m+k    m+k+1                   n
         */
        if (k != 0) {
            root.left = new TreeNode(preorder[i + 1]);
            this.build(preorder, inorder, i + 1, i + k + 1, m, m + k, root.left);
        }
        if (i + k + 1 != j) {
            root.right = new TreeNode(preorder[i + k + 1]);
            this.build(preorder, inorder, i + k + 1, j, m + k + 1, n, root.right);
        }
    }
}