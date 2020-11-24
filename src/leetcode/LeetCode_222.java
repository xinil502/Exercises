package leetcode;

/**
 * 222. 完全二叉树的节点个数
 */
public class LeetCode_222 {
    public static void main(String[] args) {
        TreeNode root = Utils.createTree();

        Solution_222 sol = new Solution_222();
        System.out.println(sol.countNodes(root));
    }
}

class Solution_222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == root.right) {
            return 1;
        }
        int depth = 0;
        TreeNode temp = root;
        while (root != null) {  //计算不包含最后一层的树的深度。
            ++depth;
            root = root.left;
        }
        --depth;
        root = temp;
        int sum = (int) Math.pow(2, depth) - 1;  //上部分有规律的求和
        int k = (int) Math.pow(2, depth);   //最后一层最多含有的结点树
        --depth;
        while (depth > 0) {
            //二分法，
            // 左子树的最底层最右结点不为null，则左侧为满树，+=k/2后，对右半边查找。否则对左半边查找。
            if (hasNode(root.left, depth)) {
                sum += k / 2;
                root = root.right;
            } else {
                root = root.left;
            }
            k /= 2;
            --depth;
        }
        //最后的两个结点，单独计算。
        if (root.left != null) {
            ++sum;
        }
        if (root.right != null) {
            ++sum;
        }
        return sum;
    }

    boolean hasNode(TreeNode root, int n) {
        while (n-- != 0) {
            root = root.right;
        }
        return root != null;
    }
}