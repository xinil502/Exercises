package leetcode;

import java.util.*;

/**
 * 90. 子集 II
 *
 * @Author: Xinil
 * @Date: 2021/3/31 14:17
 */
public class LeetCode_90 {
    class Solution {
        private List<int[]> list;
        private List<List<Integer>> re;
        int len;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            list = new ArrayList<>();
            re = new ArrayList<>();
            len = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            for (Iterator<Integer> ite = map.keySet().iterator(); ite.hasNext(); ) {
                int[] item = new int[2];
                item[0] = ite.next();
                item[1] = map.get(item[0]);
                list.add(item);
                ++len;
            }
            dfs(new ArrayList<>(), 0);
            return re;
        }

        void dfs(List<Integer> item, int k) {
            if (k == len) {
                re.add(item);
                return;
            }
            int[] nums = list.get(k);

            dfs(new ArrayList<>(item), k + 1);
            for (int i = 0; i < nums[1]; ++i) {
                item.add(nums[0]);
                dfs(new ArrayList<>(item), k + 1);
            }
            for (int i = 0; i < nums[1]; ++i) {
                item.remove(item.size() - 1);
            }
            return;
        }
    }

}
