package leetcode;

import java.util.Scanner;

/**
 * 530. 二叉搜索树的最小绝对差
 */
public class LeetCode_530 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = new TreeNode(scanner.nextInt());
        root.createTree();

        Solution_530 sol = new Solution_530();
        System.out.println(sol.getMinimumDifference(root));
    }
}

class Solution_530 {
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    int[] dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        return judge(root.val, dfs(root.left), dfs(root.right));
    }

    int[] judge(int val, int[] left, int[] right) {
        if (left == right) {
            return new int[]{val, val};
        } else if (left == null) {
            min = Math.min(right[0] - val, min);
            return new int[]{val, right[1]};
        } else if (right == null) {
            min = Math.min(val - left[1], min);
            return new int[]{left[0], val};
        } else {
            min = Math.min(Math.min(val - left[1], right[0] - val), min);
            return new int[]{left[0], right[1]};
        }
    }
}