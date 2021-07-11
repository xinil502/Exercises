package leetcode;

import java.util.Arrays;

/**
 * 274. H 指数
 *
 * @Author: Xinil
 * @Date: 2021/7/11 20:26
 */
public class LeetCode_274 {
    /**
     * 二分查找尝试 O(N*logN)
     */
    class Solution {
        public int hIndex(int[] citations) {
            int left = 0, right = 0;
            for (int i : citations) {
                if (i > right) {
                    right = i;
                }
            }
            while (left < right) {
                int mid = (right >> 1) + (left >> 1) + 1;
                int count = 0;
                for (int i : citations) {
                    if (i >= mid) {
                        ++count;
                    }
                }
                if (count >= mid) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

    /**
     * 使用排序，然后处理。
     */
    class Solution_2 {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);

            for (int i = 0; i < citations.length; i++) {
                int pos = citations.length - i;
                if (citations[i] >= pos)
                    return pos;
            }
            return 0;
        }
    }

}
