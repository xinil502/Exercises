package leetcode;

import java.util.*;

/**
 * 5663. 找出第 K 大的异或坐标值
 */
public class LeetCode_5663 {

    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] re = new int[m][n];
            re[0][0] = matrix[0][0];
            for (int i = 1; i < n; ++i) {
                re[0][i] = re[0][i - 1] ^ matrix[0][i];
            }
            for (int i = 1; i < m; ++i) {
                int temp = matrix[i][0];
                re[i][0] = re[i - 1][0] ^ temp;
                for (int j = 1; j < n; ++j) {
                    temp ^= matrix[i][j];
                    re[i][j] = re[i - 1][j] ^ temp;
                    Set<Integer> set = new TreeSet<>();

                }
            }
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < m; ++i) {
                System.out.println(Arrays.toString(re[i]));
                for (int j = 0; j < n; ++j) {
                    list.add(re[i][j]);
                }
            }
            list.sort((o1, o2) -> o2 - o1);
            System.out.println(list.toString());
            return list.get(k - 1);
        }
    }
}
