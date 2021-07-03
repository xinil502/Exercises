package leetcode;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 *
 * @Author: Xinil
 * @Date: 2021/7/3 20:01
 */
public class LeetCode_451 {
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            List<String> list = new ArrayList<>();
            for (Iterator<Character> ite = map.keySet().iterator(); ite.hasNext(); ) {
                char c = ite.next();
                int val = map.get(c);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < val; ++i) {
                    sb.append(c);
                }
                list.add(sb.toString());
            }
            list.sort((o1, o2) -> o2.length() - o1.length());
            StringBuilder sb = new StringBuilder();
            for (String i : list) {
                sb.append(i);
            }
            return sb.toString();
        }
    }
}
