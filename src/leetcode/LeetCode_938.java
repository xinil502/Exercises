package leetcode;

/**
 * LeetCode_938.二叉搜索树的范围和
 */
public class LeetCode_938 {
    class Solution {
        int low, high, sum = 0;

        public int rangeSumBST(TreeNode root, int low, int high) {
            this.low = low;
            this.high = high;
            dfs(root);
            return sum;
        }

        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            if (low <= root.val && root.val <= high) {
                sum += root.val;
            }
            if (low <= root.val) {
                dfs(root.left);
            }
            if (root.val <= high) {
                dfs(root.right);
            }
        }
    }
}
