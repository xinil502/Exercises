package leetcode;

import java.util.Scanner;

public class LeetCode_236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        TreeNode pTree = new TreeNode(sc.nextInt());
        TreeNode qTree = new TreeNode(sc.nextInt());
        root.CreatTree();


        Solution_236_1 sol = new Solution_236_1();
        System.out.println(sol.lowestCommonAncestor(root, pTree, qTree).val);
    }
}

class Solution_236_1 { // 8ms,  41.9MB
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root)return root;
        //递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
        // 表示对于当前树的查找已经完毕,

        // 否则对左右子树进行查找, 根据左右子树的返回值判断:
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null && right != null)return root; //都不为空说明一个在左一个在右，此时root为最近公共祖先节点
        return left == null ? right : left;  //左右有一个为空说明该节点在另一个上，或者未到达公共祖先节点。
    }
}


class Solution_236_2 {
    private TreeNode k = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return k;
    }

    void dfs(TreeNode root, TreeNode p, TreeNode q){
        if(k != null){
            return;
        }
        if(root == null){
            return;
        }
        boolean pp = root.val == p.val, qq = root.val == q.val;// root是p或q。
        boolean lp = judge(root.left,p), rp = judge(root.right, p); //ront的左子树，或右子树有p。
        boolean lq = judge(root.left,q), rq = judge(root.right, q); //ront的右子树，或右子树有q。

        if((pp&&lq)||(pp&&rq)||(qq&&lp)||(qq&&rp)||(lp&&rq)||(lq&&rp)||(pp&&qq)){
            k = root;
        }
        dfs(root.left, p, q);
        dfs(root.right,p, q);
    }

    boolean judge(TreeNode root, TreeNode a){
        if(root == null){
            return false;
        }
        if(root.val == a.val){
            return true;
        }
        return judge(root.left, a) || judge(root.right ,a);
    }
}
