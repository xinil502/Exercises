package leetcode;

import java.util.Scanner;

/**
 * 463.岛屿的周长
 */
public class LeetCode_463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();

        int[][] nums = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                nums[i][j] = scanner.nextInt();
            }
        }

        Solution_463 sol = new Solution_463();
        System.out.println(sol.islandPerimeter(nums));
    }
}

class Solution_463 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int sum = 0, x, y;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    sum += 4;
                    if (i + 1 < n && grid[i + 1][j] == 1) {
                        sum -= 2;
                    }
                    if (j + 1 < m && grid[i][j + 1] == 1) {
                        sum -= 2;
                    }
                }
            }
        }
        return sum;
    }
}