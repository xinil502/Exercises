package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * LeetCode_37.解数独
 * line column block 三个数组去记录每行，每列，每个九宫格的状态
 * 使用位运算求出是否可填数字。
 * 对唯一可填的位置可以直接填写
 */
public class LeetCode_37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] num = new char[9][9];
        for (int i = 0; i < 9; ++i) {
            num[i] = sc.next().toCharArray();
        }
        Solution_37 sol = new Solution_37();
        sol.solveSudoku(num);
    }
}

class Solution_37 {
    private int[] line = new int[9];
    private int[] column = new int[9];
    private int[][] block = new int[3][3];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0' - 1;
                    flip(i, j, digit); //直接将确定的数导入状态数组
                }
            }
        }
        while (true) {
            boolean modified = false;
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
                        if ((mask & (mask - 1)) == 0) {
                            int digit = Integer.bitCount(mask - 1);
                            flip(i, j, digit);
                            board[i][j] = (char) (digit + '0' + 1);
                            modified = true;
                        }
                    }
                }
            }
            if (!modified) {
                break;
            }
        }

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);
            dfs(board, pos + 1);
            flip(i, j, digit);
        }
    }

    public void flip(int i, int j, int digit) { //移入移出状态数组
        line[i] ^= (1 << digit);
        column[j] ^= (1 << digit);
        block[i / 3][j / 3] ^= (1 << digit);
    }
}

/**
 * 92154673.
 * 657.39241
 * 43.271659
 * 51478396.
 * 789652413
 * .63194.75
 * 145927386
 * 39641852.
 * 8.236519.
 * <p>
 * 53..7....
 * 6..195...
 * .98....6.
 * 8...6...3
 * 4..8.3..1
 * 7...2...6
 * .6....28.
 * ...419..5
 * ....8..79
 */