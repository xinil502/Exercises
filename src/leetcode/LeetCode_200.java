package leetcode;

/**
 * 200. 岛屿数量
 *
 * @Author: Xinil
 * @Date: 2021/2/28 13:43
 */
public class LeetCode_200 {
    class Solution {
        char[][] grid;
        boolean[][] visited;
        int m, n;
        int[][] dircetion = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int numIslands(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            int sum = 0;
            this.grid = grid;
            visited = new boolean[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        dfs(i, j);
                        ++sum;
                    }
                }
            }
            return sum;
        }

        public void dfs(int i, int j) {
            visited[i][j] = true;
            int x, y;
            for (int k = 0; k < 4; ++k) {
                x = i + dircetion[k][0];
                y = j + dircetion[k][1];
                if (x > -1 && x < m && y > -1 && y < n && grid[x][y] == '1' && !visited[x][y]) {
                    dfs(x, y);
                }
            }
        }
    }
}
