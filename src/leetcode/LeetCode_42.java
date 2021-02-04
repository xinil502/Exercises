package leetcode;

/**
 * 42. 接雨水
 *
 * @Author: Xinil
 * @Date: 2021/2/4 17:57
 */
public class LeetCode_42 {
    class Solution {
        public int trap(int[] height) {
            if (height == null || height.length == 0 || height.length == 1 || height.length == 2) {
                return 0;
            }
            int sum = 0;
            int i, j;
            i = 0;
            j = height.length - 1;
            int left = 0;
            int right = 0;
            while (i != j) {
                if (height[i] < height[j]) {
                    if (height[i] > left) {
                        left = height[i];
                    } else {
                        sum += left - height[i];
                    }
                    ++i;
                } else {
                    if (height[j] > right) {
                        right = height[j];
                    } else {
                        sum += right - height[j];
                    }
                    --j;
                }
            }
            return sum;
        }
    }

}
