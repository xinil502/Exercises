package leetcode;

import java.util.*;

/**
 * 39. 组合总和
 *
 * @Author: Xinil
 * @Date: 2021/5/27 20:49
 */
public class LeetCode_39 {
    class Solution {
        List<Integer> item = new ArrayList<>();
        int sum = 0, target = 0;
        List<List<Integer>> list = new ArrayList<>();
        int[] nums = null;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.nums = candidates;
            this.target = target;
            Arrays.sort(nums);
            dfs(0);
            return list;
        }

        void dfs(int start) {
            if (sum == target) {
                list.add(new ArrayList<>(item));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int i = start; i < nums.length; ++i) {
                if (sum + nums[i] > target) {
                    break;
                }
                sum += nums[i];
                item.add(nums[i]);
                dfs(i);
                sum -= nums[i];
                item.remove(item.size() - 1);
            }
        }
    }
}