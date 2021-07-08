package leetcode;

/**
 * 930. 和相同的二元子数组
 *
 * @Author: Xinil
 * @Date: 2021/7/8 13:06
 */
public class LeetCode_930 {
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int n = nums.length;
            int left1 = 0, left2 = 0, right = 0;
            int sum1 = 0, sum2 = 0;
            int ret = 0;
            while (right < n) {//遍历右边界，用left1， left2确定两个右边界
                //左边界1，在刚好等于goal的最左侧
                sum1 += nums[right];
                while (left1 <= right && sum1 > goal) {
                    sum1 -= nums[left1];
                    left1++;
                }
                //左边界2，在刚好等于goal的最右侧的下一个位置
                sum2 += nums[right];
                while (left2 <= right && sum2 >= goal) {
                    sum2 -= nums[left2];
                    left2++;
                }
                //[left1, left2)为right的可选左边界
                ret += left2 - left1;
                right++;
            }
            return ret;
        }
    }
}
