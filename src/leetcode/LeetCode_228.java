package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 */
public class LeetCode_228 {
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < nums.length; ) {
                int start = nums[i];
                for (int k = 0; k + i < nums.length; ++k) {
                    if (i + k + 1 >= nums.length || nums[i + k + 1] > start + k + 1) {
                        if (k == 0) {
                            list.add(start + "");
                        } else {
                            list.add(start + "->" + nums[i + k]);
                        }
                        i += k + 1;
                        break;
                    }
                }
            }
            return list;
        }
    }
}
