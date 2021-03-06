package leetcode;

import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 *
 * @Author: Xinil
 * @Date: 2021/3/6 12:56
 */
public class LeetCode_503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] re = new int[nums.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums.length; ++i) {
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                        re[stack.pop()] = nums[i];
                    }
                    stack.add(i);
                }
            }
            for (int i = 0; i < nums.length; ++i) {
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                        re[stack.pop()] = nums[i];
                    }
                }
            }
            while (!stack.isEmpty()) {
                re[stack.pop()] = -1;
            }
            return re;
        }
    }
}
