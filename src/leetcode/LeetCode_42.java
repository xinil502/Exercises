package leetcode;

import java.util.Stack;

/**
 * 42. 接雨水
 *
 * @Author: Xinil
 * @Date: 2021/2/4 17:57
 */
public class LeetCode_42 {
    /**
     * 维护单调递减栈来模拟接雨水的 "坑"。
     */
    class Solution_1 {
        public int trap(int[] height) {
            Stack<Integer> stack = new Stack<>();
            int sum = 0;
            for (int i = 0; i < height.length; ++i) {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int min = stack.pop();
                    if (!stack.isEmpty()) {
                        sum += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[min]);
                    }
                }
                stack.push(i);
            }
            return sum;
        }
    }

    /**
     * 双指针。
     * 维护四个变量：  两端的指针，以及两端已遍历的最大值。
     * 移动位置低指针，来计算接的雨水。
     */
    class Solution_2 {
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
