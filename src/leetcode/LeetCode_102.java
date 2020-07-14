package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.List;

public class LeetCode_102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(sc.nextInt());
        root.CreatTree();

        Solution_102 sol = new Solution_102();
        List<List<Integer>> list = sol.levelOrder(root);
        for (Iterator<List<Integer>> ite = list.iterator(); ite.hasNext(); ) { //打印List
            for (Iterator<Integer> itee = ite.next().iterator(); itee.hasNext(); ) {
                System.out.print(itee.next() + "  ");
            }
            System.out.println();
        }
    }
}

class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<QueueNode> que = new ArrayList<>();

        int i = 0, lev = 0;
        List<Integer> ll = new ArrayList<>();
        QueueNode temp = new QueueNode();
        temp.level = 0;
        temp.root = root;
        que.add(temp);

        while (i < que.size()) {
            temp = que.get(i);
            if (temp.level != lev) { //是否换层（需要重新建立一个子List）
                list.add(ll);
                ll = new ArrayList<>();
                ++lev;
            }
            ll.add(temp.root.val);


            if (temp.root.left != null) { //是否有左子树去加入队列
                que.add(new QueueNode(temp.root.left, temp.level + 1));
            }
            if (temp.root.right != null) { //是否有右子树去加入队列
                que.add(new QueueNode(temp.root.right, temp.level + 1));
            }
            ++i;
        }
        list.add(ll);

        return list;
    }
}


