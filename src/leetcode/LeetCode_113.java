package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * LeetCode_113.路径总和
 */
public class LeetCode_113 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.createTree();

        Solution_113 sol = new Solution_113();
        List<List<Integer>> list = sol.pathSum(root, sc.nextInt());
        for (Iterator<List<Integer>> ite = list.iterator(); ite.hasNext(); ) {
            for (Iterator<Integer> ite2 = ite.next().iterator(); ite2.hasNext(); ) {
                System.out.print(ite2.next());
            }
            System.out.println();
        }
    }
}

class Solution_113 {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> item = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return list;
    }

    void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        item.add(root.val);
        if (root.left == root.right && sum == root.val) {
            list.add(new ArrayList<>(item));
        }
        dfs(root.right, sum - root.val);
        dfs(root.left, sum - root.val);
        item.remove(item.size() - 1);
    }
}