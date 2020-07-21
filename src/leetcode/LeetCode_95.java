package leetcode;


import java.util.*;

/**
 * LeetCode_95.不同的二叉搜索树
 */
public class LeetCode_95 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Solution_95 sol = new Solution_95();
        for (Iterator<TreeNode> ite = sol.generateTrees(n).iterator(); ite.hasNext(); ) {
            TreeNode root = ite.next();
            root.print(1);
            System.out.println();
        }
    }
}


class Solution_95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = getTree(1, n);
        return list;
    }

    List<TreeNode> getTree(int start, int end) {
        if (start > end) {
            List<TreeNode> t = new ArrayList<>();
            t.add(null);
            return t;
        }
        List<TreeNode> list = new ArrayList<>();
        for (int i = start; i <= end; ++i) {
            List<TreeNode> left = getTree(start, i - 1);
            List<TreeNode> right = getTree(i + 1, end);
            for (int j = 0; j < left.size(); ++j) {
                for (int k = 0; k < right.size(); ++k) {
                    TreeNode t3 = new TreeNode(i, left.get(j), right.get(k));
                    list.add(t3);
                }
            }
        }
        return list;
    }
}