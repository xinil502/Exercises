package leetcode;

/**
 * 896. 单调数列
 *
 * @Author: Xinil
 * @Date: 2021/2/28 13:56
 */
public class LeetCode_896 {
    class Solution {
        public boolean isMonotonic(int[] A) {
            boolean asc = true, desc = true;
            int n = A.length;
            for (int i = 1; i < n; ++i) {
                if (A[i - 1] > A[i]) {
                    asc = false;
                }
                if (A[i - 1] < A[i]) {
                    desc = false;
                }
                if (!(asc || desc)) {
                    return false;
                }
            }
            return true;
        }
    }
}
