package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1030. 距离顺序排列矩阵单元格
 */
public class LeetCode_1030 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        Solution_1030 sol = new Solution_1030();
        int[][] nums = sol.allCellsDistOrder(a, b, c, d);
        for (int[] k : nums) {
            System.out.println(Arrays.toString(k));
        }
    }
}

class Solution_1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] judge = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});
        int[] element;
        int i = 0, k = R * C;
        int[][] re = new int[k][2];
        while (i < k) {
            element = queue.poll();
            if (judge[element[0]][element[1]]) {
                continue;
            }
            judge[element[0]][element[1]] = true;
            re[i] = element;
            ++i;
            for (int j = 0; j < 4; ++j) {
                int x = element[0] + direction[j][0];
                int y = element[1] + direction[j][1];
                if (x > -1 && x < R && y > -1 && y < C) {
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return re;
    }
}