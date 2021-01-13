package leetcode;

import java.util.*;

import util.DisjointSet;

/**
 * 1202.交换字符串中的元素
 */
public class LeetCode_1202 {
    class Solution {
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            DisjointSet dsu = new DisjointSet(s.length());
            for (List<Integer> pair : pairs) {
                dsu.union(pair.get(0), pair.get(1));
            }
            Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
            for (int i = 0; i < s.length(); i++) {
                int parent = dsu.find(i);
                if (!map.containsKey(parent)) {
                    map.put(parent, new ArrayList<Character>());
                }
                map.get(parent).add(s.charAt(i));
            }
            for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
                Collections.sort(entry.getValue(), new Comparator<Character>() {
                    public int compare(Character c1, Character c2) {
                        return c2 - c1;
                    }
                });
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                int x = dsu.find(i);
                List<Character> list = map.get(x);
                sb.append(list.remove(list.size() - 1));
            }
            return sb.toString();
        }
    }
}
