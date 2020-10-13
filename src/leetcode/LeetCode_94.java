package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LeetCode_94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.createTree();

        Solution_94 sol = new Solution_94();
        List<Integer> list = sol.inorderTraversal(root);
        for (Iterator<Integer> ite = list.iterator(); ite.hasNext(); ) {
            System.out.println(ite.next());
        }
    }
}

class Solution_94 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
    }
}