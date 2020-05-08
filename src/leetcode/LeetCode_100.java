package leetcode;

import java.util.Scanner;

public class LeetCode_100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_100 sol = new Solution_100();

        TreeNode rootp = new TreeNode(sc.nextInt());
        rootp.CreatTree();
        TreeNode rootq = new TreeNode(sc.nextInt());
        rootq.CreatTree();

        System.out.println(sol.isSameTree(rootp, rootq));
    }
}
class Solution_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){ //两个空树是相等的。
            return true;
        }else if(p == null || q == null){ //两空已经跳出，一空一非空是不相等的。
            return false;
        }else if(p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right, q.right)) {  //两值相等且子树相等才相等
            return true;
        }
        return false;
    }
}
