package leetcode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 */
public class LeetCode_103 {

    //方法一：2ms， 打败13%
    //使用List<TreeNode> lastList 和 item 存储单链表结果。
    //使用栈存储 lastList 的子层对应序列，， 翻转后存储到lastList中。
    //使用List<Integer>  l获取单层结果,list 存结果。
    class Solution_1 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            boolean leftToRight = true;
            List<TreeNode> lastList = new ArrayList<>();
            lastList.add(root);
            while (true) {
                Stack<TreeNode> stack = new Stack<>();
                if (leftToRight) {
                    for (Iterator<TreeNode> ite = lastList.iterator(); ite.hasNext(); ) {
                        TreeNode k = ite.next();
                        if (k.left != null) {
                            stack.push(k.left);
                        }
                        if (k.right != null) {
                            stack.push(k.right);
                        }
                    }
                    leftToRight = false;
                } else {
                    for (Iterator<TreeNode> ite = lastList.iterator(); ite.hasNext(); ) {
                        TreeNode k = ite.next();
                        if (k.right != null) {
                            stack.push(k.right);
                        }
                        if (k.left != null) {
                            stack.push(k.left);
                        }
                    }
                    leftToRight = true;
                }
                List<TreeNode> item = new ArrayList<>();
                while (!stack.empty()) {
                    item.add(stack.pop());
                }
                List<Integer> l = new ArrayList<>();
                for (Iterator<TreeNode> ite = lastList.iterator(); ite.hasNext(); ) {
                    l.add(ite.next().val);
                }
                list.add(l);
                if (item.size() == 0) {
                    return list;
                }
                lastList = item;
            }
        }
    }


    //使用队列。先按层序遍历查出结果，之后对结果进行翻转。
    class Solution_2 {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) return new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int step = 0;
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                if (step % 2 == 1) Collections.reverse(list);
                result.add(list);
                step++;
            }
            return result;
        }
    }


}
