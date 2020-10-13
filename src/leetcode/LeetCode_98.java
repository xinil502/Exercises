package leetcode;

import java.util.Scanner;

/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

	节点的左子树只包含小于当前节点的数。
	节点的右子树只包含大于当前节点的数。
	所有左子树和右子树自身必须也是二叉搜索树。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode_98 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        TreeNode root = new TreeNode(val);
        root.createTree();

        Solution_98 sol = new Solution_98();
        System.out.println(sol.isValidBST(root));
        sc.close();
    }
}

class Solution_98{
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }else if(root.left != null && root.left.val >= root.val) { //左子结点存在且比根结点大时，返回false
            return false;
        }else if(root.right != null && root.right.val <= root.val) { //右子结点存在且比根结点小时，返回false
            return false;
        }
        return this.is(root.left, -9223372036854775808L, root.val)&&this.is(root.right, root.val, 9223372036854775807L); //判断子树是否满足
    }
    boolean is(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }else if(root.left != null && root.left.val >= root.val) { //左子结点存在且比根结点大时，返回false
            return false;
        }else if(root.right != null && root.right.val <= root.val) { //右子结点存在且比根结点小时，返回false
            return false;
        }else if(root.left != null && root.left.val <= min){ //若左子结点非空且左结点小于等于祖先的最小值时，返回false
            return false;
        }else if(root.right != null&& root.right.val >= max){  //若右子结点非空且右结点大于等于祖先的最大值时，返回false
            return false;
        }
        return this.is(root.left, min, root.val)&&this.is(root.right, root.val, max);// 判断子树是否满足
    }
}
