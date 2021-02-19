package leetcode;

/**
 * 1004. 最大连续1的个数 III
 *
 * @Author: Xinil
 * @Date: 2021/2/19 9:37
 */
public class LeetCode_1004 {
    class Solution {
        public int longestOnes(int[] A, int K) {
            int len = A.length;

            int left = 0;
            int right = 0;
            int maxCount = 0;
            while (right < len) {
                if (A[right++] == 0) {
                    maxCount++;
                }
                if (maxCount > K) {
                    if (A[left++] == 0) {
                        maxCount--;
                    }
                }

            }

            return right - left;
        }
    }

}
