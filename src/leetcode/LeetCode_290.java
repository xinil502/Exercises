package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 290. 单词规律
 */
public class LeetCode_290 {
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            char[] chars = pattern.toCharArray();
            String[] strs = s.split(" ");
            if (chars.length != strs.length) {
                return false;
            }
            Map<Character, String> map = new HashMap<>();

            for (int i = 0; i < chars.length; ++i) {
                if (map.containsKey(chars[i])) {
                    if (!strs[i].equals(map.get(chars[i]))) {
                        return false;
                    }
                } else {
                    for (Iterator<Character> ite = map.keySet().iterator(); ite.hasNext(); ) {
                        if (map.get(ite.next()).equals(strs[i])) {
                            return false;
                        }
                    }
                    map.put(chars[i], strs[i]);
                }
            }
            return true;
        }
    }
}
