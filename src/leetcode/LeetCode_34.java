package leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class LeetCode_34 {
    class Solution {
        int[] nums;
        int target;

        public int[] searchRange(int[] nums, int target) {
            int left = 0, right = nums.length;
            this.nums = nums;
            this.target = target;
            return getRange(0, nums.length);
        }

        //递归，二分判断区间
        int[] getRange(int start, int end) {
            //无子区间，返回{-1,-1}
            if (start >= end) {
                return new int[]{-1, -1};
            }
            //判断中间位置和target的大小
            int middle = (start + end) / 2;
            if (nums[middle] < target) {
                return getRange(middle + 1, end);
            } else if (target < nums[middle]) {
                return getRange(start, middle);
            } else {
                int[] r1 = getRange(start, middle);
                int[] r2 = getRange(middle + 1, end);
                int[] re = new int[2];
                re[0] = r1[0] == -1 ? middle : r1[0];
                re[1] = r2[1] == -1 ? middle : r2[1];
                return re;
            }
        }
    }
}
