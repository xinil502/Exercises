package leetcode;

import util.DisjointSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 778. 水位上升的泳池中游泳
 *
 * @Author: Xinil
 * @Date: 2021/1/30 20:04
 */
public class LeetCode_778 {
    //弗洛伊德 或者 Dijkstra(迪杰斯特拉)算法都可以，，这里使用弗洛伊德算法连接。
    class Solution {
        public int swimInWater(int[][] grid) {
            int row = grid.length;
            int columns = grid[0].length;
            int kkkkkk = row * columns - 1;
            DisjointSet disjoint = new DisjointSet(row * columns);
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < columns; ++j) {
                    int sum = i * columns + j;
                    //统计边时只取两个方向。
                    if (i > 0) {
                        list.add(new int[]{sum, sum - columns, Math.max(grid[i][j], grid[i - 1][j])});
                    }
                    if (j > 0) {
                        list.add(new int[]{sum, sum - 1, Math.max(grid[i][j], grid[i][j - 1])});
                    }
                }
            }
            list.sort(Comparator.comparingInt(a -> a[2]));

            //弗洛伊德算法
            for (int[] i : list) {
                disjoint.union(i[0], i[1]);
                if (disjoint.find(0) == disjoint.find(kkkkkk)) {
                    return i[2];
                }
            }
            return 0;
        }
    }
}
