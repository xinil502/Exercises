package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 830. 较大分组的位置
 */
public class LeetCode_830 {
    class Solution {
        public List<List<Integer>> largeGroupPositions(String s) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> item;
            for (int i = 0; i < s.length(); ) {
                char c = s.charAt(i);
                int start = i, end;
                while (i < s.length() && s.charAt(i) == c) {
                    ++i;
                }
                end = i - 1;
                if (end - start > 1) {
                    item = new ArrayList<>();
                    item.add(start);
                    item.add(end);
                    list.add(item);
                }
            }
            return list;
        }
    }
}
