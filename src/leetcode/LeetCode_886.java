package leetcode;

/**
 * 886.可能的二分法
 *
 * @Author: Xinil
 * @Date: 2021/2/27 16:18
 */
public class LeetCode_886 {
    class Solution {
        private boolean[] visited;
        private int[] colors;
        private boolean[][] graph;
        private int len;

        public boolean possibleBipartition(int N, int[][] dislikes) {
            len = N + 1;
            graph = new boolean[len][len];
            for (int i = 0; i < dislikes.length; ++i) {
                graph[dislikes[i][0]][dislikes[i][1]] = graph[dislikes[i][1]][dislikes[i][0]] = true;
            }
            visited = new boolean[len];
            colors = new int[len];
            for (int i = 1; i < len; ++i) {
                if (!visited[i] && !dfs(i, 1)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int i, int color) {
            visited[i] = true; //已遍历
            colors[i] = color; //染色

            for (int j = 1; j < len; ++j) { //遍历相邻结点
                if (i == j) {
                    continue;
                }
                if (graph[i][j]) {
                    if (!visited[j]) {  //相邻结点未访问过，
                        if (!dfs(j, -color)) { //染相反的颜色。
                            return false;
                        }
                    } else if (colors[i] == colors[j]) { //相邻颜色相同，返回false。
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
