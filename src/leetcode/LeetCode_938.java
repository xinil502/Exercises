package leetcode;

import java.util.Scanner;

/**
 * LeetCode_938.二叉搜索树的范围和
 */
public class LeetCode_938 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.createTree();

        Solution_938 sol = new Solution_938();
        System.out.println(sol.rangeSumBST(root, sc.nextInt(), sc.nextInt()));
    }
}

class Solution_938 {
    int sum;
    int l, r;

    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        l = L;
        r = R;
        dfs(root);
        return sum;
    }

    void dfs(TreeNode root) {
        if (null == root) {
            return;
        }
        if (root.val <= l) {
            if (root.val == l) {
                sum += l;
            }
            dfs(root.right);
            return;
        } else if (root.val >= r) {
            if (root.val == r) {
                sum += r;
            }
            dfs(root.left);
            return;
        }
        sum += root.val;
        dfs(root.right);
        dfs(root.left);
    }
}