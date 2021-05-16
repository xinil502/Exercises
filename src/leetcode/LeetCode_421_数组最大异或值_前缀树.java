package leetcode;

/**
 * 421. 数组中两个数的最大异或值
 *
 * @Author: Xinil
 * @Date: 2021/5/16 15:15
 */
public class LeetCode_421_数组最大异或值_前缀树 {
    /**
     * 求出每个元素的二进制表示
     * 用前缀树求解。
     */
    class Solution {
        public int findMaximumXOR(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }
            if (nums.length == 2) {
                return nums[0] ^ nums[1];
            }

            Trie root = new Trie();
            int[] ints = new int[31];
            for (int i : nums) {
                for (int j = 30; j > -1; --j) { //求出每个元素的二进制表示
                    ints[j] = i & 1;
                    i >>= 1;
                }
                Trie node = root;
                for (int j = 0; j < 31; ++j) { //用二进制表示构建前缀树
                    if (ints[j] == 0) {
                        if (node.leftNode == null) {
                            node.leftNode = new Trie();
                        }
                        node = node.leftNode;
                    } else {
                        if (node.rightNode == null) {
                            node.rightNode = new Trie();
                        }
                        node = node.rightNode;
                    }
                }
            }
            int weight = 30;
            while (true) { //寻找前缀树中第一次出现左右子节点的位置
                if (root.leftNode == null) {
                    root = root.rightNode;
                    --weight;
                } else if (root.rightNode == null) {
                    root = root.leftNode;
                    --weight;
                } else {
                    break;
                }
            }
            return (1 << weight) + getVal(root.leftNode, root.rightNode, weight - 1);
        }


        int getVal(Trie root1, Trie root2, int weight) {
            int max = 0;
            if (root1.leftNode != null && root2.rightNode != null) {   //寻找不同位的情况
                max = (1 << weight) + getVal(root1.leftNode, root2.rightNode, weight - 1);
            }
            if (root1.rightNode != null && root2.leftNode != null) {   //寻找不同位的情况
                max = Math.max(max, (1 << weight) + getVal(root1.rightNode, root2.leftNode, weight - 1));
            }
            if (max == 0) {   //没有不同位的情况，只能默认往下走
                if (root1.leftNode != null && root2.leftNode != null) {
                    return getVal(root1.leftNode, root2.leftNode, weight - 1);
                } else if (root1.rightNode != null && root2.rightNode != null) {
                    return getVal(root1.rightNode, root2.rightNode, weight - 1);
                } else {
                    return 0;
                }
            }
            return max;
        }
    }


    class Trie {
        Trie leftNode;
        Trie rightNode;
    }
}
