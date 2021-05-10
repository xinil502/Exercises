package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 872. 叶子相似的树
 *
 * @Author: Xinil
 * @Date: 2021/5/10 14:52
 */
public class LeetCode_872 {
    /**
     * 这里使用栈挨个判断，如果有不匹配，不用全部判断完就可以结束判断。
     * 不过直接求出序列，存到两个 List里面，再做比较会更快。
     */
    class Solution {
        List<Integer> list = new ArrayList<>();

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root1);
            stack2.push(root2);
            while (true) {
                Integer nextRoot1 = getNextLeaf(stack1);
                Integer nextRoot2 = getNextLeaf(stack2);
                if (nextRoot1 == null || nextRoot2 == null) {
                    return nextRoot1 == nextRoot2;
                } else if (!nextRoot1.equals(nextRoot2)) {
                    return false;
                }
            }
        }

        Integer getNextLeaf(Stack<TreeNode> stack) {
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left == node.right) {
                    return node.val;
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return null;
        }
    }
}
