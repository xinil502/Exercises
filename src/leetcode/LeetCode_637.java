package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LeetCode_637 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int roo = sc.nextInt();
        TreeNode root = new TreeNode(roo);
        root.createTree();

        Solution_637 sol = new Solution_637();
        List<Double> list = sol.averageOfLevels(root);
        for (Iterator<Double> ite = list.iterator(); ite.hasNext(); ) {
            System.out.println(ite.next());
        }
    }
}


class Solution_637 {
    List<List<Integer>> item = new ArrayList<>();
    List<Double> list = new ArrayList<>();
    List<Integer> li = null;

    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 1);
        for (Iterator<List<Integer>> ite = item.iterator(); ite.hasNext(); ) {
            double sum = 0;
            int k = 0;
            for (Iterator<Integer> ite1 = ite.next().iterator(); ite1.hasNext(); ) {
                sum += ite1.next();
                ++k;
            }
            list.add(sum / k);
        }
        return list;
    }

    void dfs(TreeNode root, int level) {
        if (item.size() < level) {
            item.add(new ArrayList<>());
        }
        li = item.get(level - 1);
        li.add(root.val);
        if (root.left != null) {
            dfs(root.left, level + 1);
        }
        if (root.right != null) {
            dfs(root.right, level + 1);
        }
    }
}