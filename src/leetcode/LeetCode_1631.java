package leetcode;

import util.DisjointSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1631. 最小体力消耗路径
 *
 * @Author: Xinil
 * @Date: 2021/1/29 22:51
 */
public class LeetCode_1631 {

    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int row = heights.length;
            int columns = heights[0].length;
            int kkkkkk = row * columns - 1;
            DisjointSet disjoint = new DisjointSet(row * columns);
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < columns; ++j) {
                    int sum = i * columns + j;
                    //统计边时只取两个方向。
                    if (i > 0) {
                        list.add(new int[]{sum, sum - columns, Math.abs(heights[i][j] - heights[i - 1][j])});
                    }
                    if (j > 0) {
                        list.add(new int[]{sum, sum - 1, Math.abs(heights[i][j] - heights[i][j - 1])});
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
