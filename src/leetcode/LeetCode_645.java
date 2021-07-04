package leetcode;

/**
 * 645. 错误的集合
 *
 * @Author: Xinil
 * @Date: 2021/7/4 15:49
 */
public class LeetCode_645 {
    class Solution {
        public int[] findErrorNums(int[] nums) {
            boolean[] eixst = new boolean[nums.length + 1];
            int[] re = new int[2];
            for (int i : nums) {
                if (eixst[i]) {
                    re[0] = i;
                } else {
                    eixst[i] = true;
                }
            }
            for (int i = 1; i <= nums.length; ++i) {
                if (!eixst[i]) {
                    re[1] = i;
                    return re;
                }
            }
            return re;
        }
    }
}
