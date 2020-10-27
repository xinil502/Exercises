package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 */
public class LeetCode_144 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.create();

        Solution_144_1 sol = new Solution_144_1();
        List<Integer> list = sol.preorderTraversal(root);
        for (Iterator<Integer> ite = list.iterator(); ite.hasNext(); ) {
            System.out.print(ite.next() + " ");
        }
    }
}

class Solution_144_1 {//递归
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}


class Solution_144_2 { //迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            list.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return list;
    }
}