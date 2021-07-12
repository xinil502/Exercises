package leetcode;

/**
 * 275. H 指数 II
 *
 * @Author: Xinil
 * @Date: 2021/7/12 18:54
 */
public class LeetCode_275 {
    class Solution {
        public int hIndex(int[] citations) {
            int len = citations.length;
            int left = 0, right = len;
            while (left < right) {
                int mid = (left >> 1) + (right >> 1);
                if (citations[mid] >= len - mid) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return len - left;
        }
    }
}
