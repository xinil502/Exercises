package leetcode;

import java.util.Scanner;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x){
        val = x;
        this.right = null;
        this.left = null;
    }
    public void CreatTree() {
        /*先序创建，
        想输入数据时输入：“1 value”
        想输入null时输入：“0”
         */
        Scanner sca = new Scanner(System.in);
        int judge = sca.nextInt(), val;
        if (judge == 1) {
            val = sca.nextInt();
            this.left = new TreeNode(val);
            this.left.CreatTree();
        }
        judge = sca.nextInt();
        if (judge == 1) {
            val = sca.nextInt();
            this.right = new TreeNode(val);
            this.right.CreatTree();
        }
    }
}
