package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. 所有可能的路径
 *
 * @Author: Xinil
 * @Date: 2021/4/9 13:56
 */
public class LeetCode_797_有向图两点的所有路径 {
    class Solution {
        List<List<Integer>> list = new ArrayList<>();
        int len;
        int[][] graph;
        List<Integer> item = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            len = graph.length;
            this.graph = graph;
            item.add(0);
            dfs(0);
            return list;
        }

        void dfs(int node) {
            if (node == len - 1) {
                list.add(new ArrayList<>(item));
                return;
            }
            for (int i = 0; i < graph[node].length; ++i) {
                int nextNode = graph[node][i];
                item.add(nextNode);
                dfs(nextNode);
                item.remove(item.size() - 1);
            }
        }
    }
}
