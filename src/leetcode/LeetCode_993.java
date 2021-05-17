package leetcode;

/**
 * 993. 二叉树的堂兄弟节点
 *
 * @Author: Xinil
 * @Date: 2021/5/17 10:42
 */
public class LeetCode_993 {
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            int[] getX = getParent(root, x, 1);
            int[] getY = getParent(root, y, 1);
            return getX[0] == getY[0] && getX[1] != getY[1];
        }

        int[] getParent(TreeNode node, int nodeVal, int deep) {
            if (node == null) {
                return new int[]{-1};
            }
            if ((node.left != null && node.left.val == nodeVal) || (node.right != null && node.right.val == nodeVal)) {
                return new int[]{deep, node.val};
            }
            int[] re = getParent(node.left, nodeVal, deep + 1);
            if (re[0] == -1) {
                re = getParent(node.right, nodeVal, deep + 1);
            }
            return re;
        }
    }
}
