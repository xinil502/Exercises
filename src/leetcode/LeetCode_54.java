package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * @Author: Xinil
 * @Date: 2021/3/15 17:13
 */
public class LeetCode_54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<>();
            int k = 0, i = 0, j = 0, m = matrix.length, n = matrix[0].length;
            while (true) {
                while (j + k < n) {
                    list.add(matrix[i][j]);
                    ++j;
                }
                --j;
                ++i;
                while (i + k < m) {
                    list.add(matrix[i][j]);
                    ++i;
                }
                --i;
                --j;
                if (list.size() == m * n) {
                    return list;
                }
                while (j > k) {
                    list.add(matrix[i][j]);
                    --j;
                }

                while (i > k) {
                    list.add(matrix[i][j]);
                    --i;
                }
                if (list.size() == m * n) {
                    return list;
                }
                ++i;
                ++j;
                ++k;
            }
        }
    }
}
