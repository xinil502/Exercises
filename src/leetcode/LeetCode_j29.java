package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_j29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; ++i) {
            matrix[i] = new int[m];
            for (int j = 0; j < m; ++j) {
                matrix[i][j] = sc.nextInt();
            }
        }

        Solution_j29_1 sol = new Solution_j29_1();
        System.out.println(Arrays.toString(sol.spiralOrder(matrix)));
    }
}

class Solution_j29_1 { //按元素个数循环输出
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;
            //判断是否需要转方向。
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
}


class Solution_j29_2 { //四重循环转方向，如遇撞墙(无法前进，直接跳出)
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int i = 0, num = 0, j = -1, k = 0, row = matrix.length, clumn = matrix[0].length;
        int kk = Math.min(row / 2, clumn / 2);
        int[] nums = new int[clumn * row];
        while (k <= kk) {
            if (j == clumn - k - 1) {
                break;
            }
            while (j < clumn - k - 1) {
                ++j;
                nums[num] = matrix[i][j];
                ++num;
            }
            if (i == row - k - 1) {
                break;
            }
            while (i < row - k - 1) {
                ++i;
                nums[num] = matrix[i][j];
                ++num;
            }
            if (j == k) {
                break;
            }
            while (j > k) {
                --j;
                nums[num] = matrix[i][j];
                ++num;
            }
            if (i == k + 1) {
                break;
            }
            while (i > k + 1) {
                --i;
                nums[num] = matrix[i][j];
                ++num;
            }
            ++k;
        }
        return nums;
    }
}