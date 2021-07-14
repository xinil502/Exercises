package leetcode;

/**
 * 1818. 绝对差值和
 *
 * @Author: Xinil
 * @Date: 2021/7/14 22:44
 */
public class LeetCode_1818 {
    class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int len = nums1.length;
            int[] cop = new int[len];
            for (int i = 0; i < len; ++i) {
                cop[i] = nums1[i];
            }
            Arrays.sort(cop);
            long sum = 0, max = 0;
            for (int i = 0; i < len; ++i) {
                int k = Math.abs(nums1[i] - nums2[i]);
                sum += k;
                int left = 0, right = len - 1;
                while (right - left > 1) {
                    int mid = (right >> 1) + (left >> 1) + (left & right & 1);
                    if (cop[mid] <= nums2[i]) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
                max = Math.max(max, k - Math.min(Math.abs(cop[left] - nums2[i]), Math.abs(cop[right] - nums2[i])));
            }
            return (int) ((sum - max) % 1000000007);
        }
    }
}
