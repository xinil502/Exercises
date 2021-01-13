package leetcode;

import util.DisjointSet;

/**
 * 684. 冗余连接
 */
public class LeetCode_684 {
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            DisjointSet set = new DisjointSet(10000);
            for (int[] i : edges) {
                if (set.find(i[0]) == set.find(i[1])) {
                    return i;
                }
                set.union(i[0], i[1]);
            }
            return new int[]{-1, -1};
        }
    }
}
