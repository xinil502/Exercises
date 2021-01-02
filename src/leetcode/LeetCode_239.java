package leetcode;

import java.util.PriorityQueue;

/**
 * 239.滑动窗口的最大值
 */
public class LeetCode_239 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
            for (int i = 0; i < k; ++i) {
                pq.offer(new int[]{nums[i], i});
            }
            int[] ans = new int[n - k + 1];
            ans[0] = pq.peek()[0];
            for (int i = k; i < n; ++i) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                ans[i - k + 1] = pq.peek()[0];
            }
            return ans;
        }
    }
}
