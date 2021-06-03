package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 *
 * @Author: Xinil
 * @Date: 2021/6/3 20:04
 */
public class LeetCode_525 {
    class Solution {
        public int findMaxLength(int[] nums) {
            int len = nums.length, maxLen = 0, k = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
            for (int i = 1; i <= len; ++i) {
                if (nums[i - 1] == 1) {
                    ++k;
                } else {
                    --k;
                }
                if (map.get(k) == null) {
                    map.put(k, i);
                } else {
                    maxLen = Math.max(maxLen, i - map.get(k));
                }
            }
            return maxLen;
        }
    }
}
