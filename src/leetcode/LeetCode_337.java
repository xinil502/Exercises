package leetcode;

import java.util.Scanner;

public class LeetCode_337 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode();
        root.val = sc.nextInt();
        root.CreatTree();

        Solution_337_1 sol = new Solution_337_1();
        System.out.println(sol.rob(root));
    }
}

class Solution_337_1 {
    // 数组0为不取当前节点，，1为取当前节点。
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        // 然后计算左右子结点偷或不偷的最大值
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] dp = new int[2];
        //当前节点不偷时，左右子节点偷或不偷都可
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //当前节点偷时，左右节点必不能偷
        dp[1] = node.val + left[0] + right[0];
        return dp; //返回当前节点的最大值
    }
}

class Solution_337_2 { //此方法重复计算较多
    //递归当前层的值加上下下层的所有左右子树和  递归下层的左右子树和  取较大的结果返回
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.right == root.left) { //root.left == root.right == null
            return root.val;
        } else if (root.left == null && root.right != null) {
            return Math.max(root.val + this.rob(root.right.left) + this.rob(root.right.right), this.rob(root.right));
        } else if (root.right == null && root.left != null) {
            return Math.max(root.val + this.rob(root.left.left) + this.rob(root.left.right), this.rob(root.left));
        }
        return Math.max((root.val + this.rob(root.left.left) + this.rob(root.left.right) + this.rob(root.right.left) + this.rob(root.right.right)), this.rob(root.left) + this.rob(root.right));
    }
}