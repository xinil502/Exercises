package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 205.同构字符串
 */
public class LeetCode_205 {
    /**
     * 两个 Map解决匹配问题
     */
    class Solution_1 {
        public boolean isIsomorphic(String s, String t) {
            if (s == t) {
                return true;
            }
            char[] S = s.toCharArray();
            char[] T = t.toCharArray();
            int length = s.length();
            Map<Character, Character> map1 = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();
            for (int i = 0; i < length; ++i) {
                if (map1.containsKey(S[i])) {
                    if (map1.get(S[i]) != T[i]) {
                        return false;
                    }
                } else {
                    map1.put(S[i], T[i]);
                }
                if (map2.containsKey(T[i])) {
                    if (map2.get(T[i]) != S[i]) {
                        return false;
                    }
                } else {
                    map2.put(T[i], S[i]);
                }
            }
            return true;
        }
    }

    /**
     * 虽然提示可以假设 s 和 t 的长度相同，
     * 但是如果加上长度的比较，可以节省 1ms
     */
    class Solution_2 {
        public boolean isIsomorphic(String s, String t) {
            return canMap(s, t) && canMap(t, s);
        }

        private boolean canMap(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] ms = new int[128];
            char[] cs = s.toCharArray();
            char[] ct = t.toCharArray();
            int len = s.length();
            for (int i = 0; i < len; ++i) {
                if (ms[cs[i]] == 0) {
                    ms[cs[i]] = ct[i];
                } else if (ms[cs[i]] != ct[i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
