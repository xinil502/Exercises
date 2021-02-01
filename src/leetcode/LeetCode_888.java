package leetcode;

import java.util.Arrays;

/**
 * 888. 公平的糖果棒交换
 *
 * @Author: Xinil
 * @Date: 2021/2/1 23:25
 */
public class LeetCode_888 {
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < A.length; ++i) {
                a += A[i];
            }
            for (int i = 0; i < B.length; ++i) {
                b += B[i];
            }
            int e = (a - b) / 2;
            Arrays.sort(A);
            Arrays.sort(B);
            for (a = b = 0; a < A.length && b < B.length; ) {
                if (A[a] - B[b] == e) {
                    return new int[]{A[a], B[b]};
                } else {
                    if (A[a] - B[b] > e) {
                        ++b;
                    } else {
                        ++a;
                    }
                }
            }
            return null;
        }
    }
}
