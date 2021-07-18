package leetcode;

import java.util.*;

/**
 * 面试题 10.02. 变位词组
 *
 * @Author: Xinil
 * @Date: 2021/7/18 9:26
 */
public class LeetCode_m10_02 {
    //两种解法：排序比较、计数比较
    //使用HashMap创造键值对归类

    //排序比较，因为Array.sort的原因，速度过快。
    class Solution_1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            int n = strs.length;
            Map<String, List<String>> anagramMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String word = strs[i];
                char[] letters = word.toCharArray();
                Arrays.sort(letters);
                String sortedWord = new String(letters);
                anagramMap.computeIfAbsent(sortedWord, v -> new ArrayList<>()).add(word);
            }
            return new ArrayList<>(anagramMap.values());
        }
    }

    class Solution_2 {
        public ArrayList groupAnagrams(String[] strs) {
            int len = strs.length;
            int[] count = new int[26];
            Map<String, List<String>> map = new HashMap();
            for (String str : strs) {
                for (char c : str.toCharArray()) {
                    count[c - 'a']++;
                }
                String key = Arrays.toString(count);
                List<String> list = map.getOrDefault(key, new ArrayList());
                list.add(str);
                map.put(key, list);
                Arrays.fill(count, 0);
            }
            return new ArrayList(map.values());
        }
    }
}
