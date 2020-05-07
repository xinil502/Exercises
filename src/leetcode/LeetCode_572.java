package leetcode;

import java.util.Scanner;

public class LeetCode_572 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution_572_2 sol = new Solution_572_2();

        TreeNode roots = new TreeNode(sc.nextInt());
        roots.CreatTree();
        TreeNode roott = new TreeNode(sc.nextInt());
        roott.CreatTree();

        System.out.println(sol.isSubtree(roots, roott));
    }
}

class Solution_572_1 {  //转为字符串，KMP查找子串。23ms 41.3Mb
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String dfsS = this.dfsTree(s);
        String dfsT = this.dfsTree(t);
        char[] dfss = dfsS.toCharArray();
        char[] dfst = dfsT.toCharArray();

        System.out.println(dfss);
        System.out.println(dfst);
        int i = -1, j = 0;
        int[] next = new int[dfst.length];
        next[0] = -1;
        while( j < dfst.length-1){  //建立next数组
            if(i == -1 || dfst[i] == dfst[j]){
                ++i;
                ++j;
                next[j] = i;
            }else{
                i = next[i];
            }
        }
        i = j = 0;
        while(i <dfss.length && j<dfst.length){
            if(j == -1 || dfss[i] == dfst[j]){
                ++i;
                ++j;
            }else{
                j = next[j];
            }
        }
        if(j == dfst.length){
            return true;
        }
        return false;
    }

    String dfsTree(TreeNode root){ //二叉树化为先序字符串
        if (root == null){
            return "#";
        }
        return "\\"+root.val+"/"+this.dfsTree(root.left)+this.dfsTree(root.right);//value值前后都要加符号，不然2/##是12/##的子树。
    }

}
class Solution_572_2{ //递归分治  4ms  40Mb
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s== null){ //s都搜到底了。说明之前没有一样的。
            return false;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t) || judge(s, t); //搜左子树右子树，判断自己
    }
    boolean judge(TreeNode s, TreeNode t){
        if(s == null && t == null){ //两个空树是相等的。
            return true;
        }else if(s == null || t == null){ //两空已经跳出，一空一非空是不相等的。
            return false;
        }else if(s.val==t.val && judge(s.left,t.left) && judge(s.right, t.right)) {  //两值相等且子树相等才相等
            return true;
        }
        return false;
    }
}
