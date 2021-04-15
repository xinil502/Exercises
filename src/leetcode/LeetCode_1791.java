package leetcode;

/**
 * 1791. 找出星型图的中心节点
 *
 * @Author: Xinil
 * @Date: 2021/4/15 13:16
 */
public class LeetCode_1791 {
    /**
     * 想刷数据结构图，从通过率最高的开始吧，然后发现了这道题
     */
    class Solution {
        public int findCenter(int[][] edges) {
            if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
                return edges[0][0];
            } else {
                return edges[0][1];
            }
        }
    }
}
