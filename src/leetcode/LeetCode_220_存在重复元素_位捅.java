package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 220. 存在重复元素 III
 *
 * @Author: Xinil
 * @Date: 2021/4/17 16:31
 */
public class LeetCode_220_存在重复元素_位捅 {
    //使用位捅来存储值相邻的元素，进行比较。
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            Map<Long, int[]> map = new HashMap<>();
            //元素x的作用范围为[x-t,x+t]，避免t为0时除以0， 所以设置大小为t+1的桶。
            long size = t + 1;
            for (int i = 0; i < nums.length; ++i) {
                long key;
                if (nums[i] >= 0) {
                    key = (long) nums[i] / size;
                } else {
                    key = (long) nums[i] / size - 1;
                }
                if (map.get(key) != null && (i - map.get(key)[0]) <= k ||
                        map.get(key - 1) != null && (i - map.get(key - 1)[0]) <= k && ((long) nums[i] - map.get(key - 1)[1]) <= t ||
                        map.get(key + 1) != null && (i - map.get(key + 1)[0]) <= k && ((long) map.get(key + 1)[1] - nums[i]) <= t) {
                    return true;
                }
                map.put(key, new int[]{i, nums[i]});
            }
            return false;
        }
    }

}
