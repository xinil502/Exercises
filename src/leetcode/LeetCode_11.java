package leetcode;

/**
 * 11. 盛最多水的容器
 *
 * @Author: Xinil
 * @Date: 2021/5/27 21:09
 */
public class LeetCode_11 {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0, rigth = height.length - 1;
            int lMax = height[0], rMax = height[rigth];
            int maxSize = Math.min(lMax, rMax) * rigth;
            while (left < rigth) {
                if (lMax < rMax) {
                    while (left < rigth && height[left] <= lMax) {
                        ++left;
                    }
                    lMax = height[left];
                    maxSize = Math.max(maxSize, Math.min(lMax, rMax) * (rigth - left));
                } else {
                    while (left < rigth && height[rigth] <= rMax) {
                        --rigth;
                    }
                    rMax = height[rigth];
                    maxSize = Math.max(maxSize, Math.min(lMax, rMax) * (rigth - left));
                }
            }
            return maxSize;
        }
    }
}
