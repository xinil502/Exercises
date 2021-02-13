package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 *
 * @Author: Xinil
 * @Date: 2021/2/13 19:13
 */
public class LeetCode_448 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < nums.length; ++i) {
                int k = nums[i];
                while (k != -1) {
                    int index = k - 1;
                    k = nums[index];
                    nums[index] = -1;
                }
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (nums[i] != -1) {
                    list.add(i + 1);
                }
            }
            return list;
        }
    }
}
