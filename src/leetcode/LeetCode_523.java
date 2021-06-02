package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. 连续的子数组和
 * 是否存在定和子区间
 *
 * @Author: Xinil
 * @Date: 2021/6/2 8:53
 */
public class LeetCode_523 {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int len = nums.length;
            if (len < 2) {
                return false;
            }
            long[] trie = new long[len + 1];
            Map<Long, Integer> map = new HashMap<>();
            map.put(0L, 0);
            for (int i = 1; i <= len; ++i) {
                trie[i] = trie[i - 1] + nums[i - 1];
                trie[i] %= k;
                Integer z = map.get(trie[i]);
                if (z == null) {
                    map.put(trie[i], i);
                } else if (z < i - 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
