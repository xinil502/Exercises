package leetcode;

/**
 * 1310. 子数组异或查询
 *
 * @Author: Xinil
 * @Date: 2021/5/12 16:51
 */
public class LeetCode_1310 {
    //用一个数组储存前缀异或和，
    //两个异或和异或，得到数组任意一段的异或和。
    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int len = arr.length;
            int[] xors = new int[len + 1];
            for (int i = 0; i < len; ++i) {
                xors[i + 1] = xors[i] ^ arr[i];
            }
            int[] re = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                re[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
            }
            return re;
        }
    }
}
