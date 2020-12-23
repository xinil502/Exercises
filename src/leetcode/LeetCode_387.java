package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 387.字符串中的第一个唯一字符
 */
public class LeetCode_387 {
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, int[]> map = new HashMap<>();
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    int[] nums = map.get(c);
                    ++nums[1];
                } else {
                    int[] nums = new int[2];
                    nums[0] = i;
                    nums[1] = 1;
                    map.put(c, nums);
                }
            }
            int min = Integer.MAX_VALUE;
            for (Iterator<Character> ite = map.keySet().iterator(); ite.hasNext(); ) {
                int[] nums = map.get(ite.next());
                if (nums[1] == 1 && nums[0] < min) {
                    min = nums[0];
                }
            }
            if (min == Integer.MAX_VALUE) {
                return -1;
            }
            return min;
        }
    }
}
