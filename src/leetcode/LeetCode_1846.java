package leetcode;

import java.util.Arrays;

/**
 * 1846. 减小和重新排列数组后的最大元素
 *
 * @Author: Xinil
 * @Date: 2021/7/15 15:58
 */
public class LeetCode_1846 {
    //排序后计算贪心算法
    class Solution_1 {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            Arrays.sort(arr);
            int re = 0;
            for (int i : arr) {
                if (i != re) {
                    ++re;
                }
            }
            return re;
        }
    }

    //范围明确，使用计数排序优化排序复杂度到O(n)
    class Solution_2 {
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            int n = arr.length;
            int[] cnt = new int[n + 1];
            for (int v : arr) {
                ++cnt[Math.min(v, n)];
            }
            int miss = 0;
            for (int i = 1; i <= n; ++i) {
                if (cnt[i] == 0) {
                    ++miss;
                } else {
                    miss -= Math.min(cnt[i] - 1, miss); // miss 不会小于 0，故至多减去 miss 个元素
                }
            }
            return n - miss;
        }
    }
}
