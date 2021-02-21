package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1438. 绝对差不超过限制的最长连续子数组
 *
 * @Author: Xinil
 * @Date: 2021/2/21 10:00
 */
public class LeetCode_1438 {
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> queMax = new LinkedList<Integer>();
            Deque<Integer> queMin = new LinkedList<Integer>();
            int n = nums.length;
            int left = 0, right = 0;
            int ret = 0;
            while (right < n) {
                while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                    queMax.pollLast();
                }
                while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                    queMin.pollLast();
                }
                queMax.offerLast(nums[right]);
                queMin.offerLast(nums[right]);
                while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                    if (nums[left] == queMin.peekFirst()) {
                        queMin.pollFirst();
                    }
                    if (nums[left] == queMax.peekFirst()) {
                        queMax.pollFirst();
                    }
                    left++;
                }
                ret = Math.max(ret, right - left + 1);
                right++;
            }
            return ret;
        }
    }
}
