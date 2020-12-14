package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49.字母异位词分组
 */
public class LeetCode_49 {

    /**
     * 使用 int[]存储对应答案中每个 List<String> 中字母的统计，669ms
     */
    class Solution_1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> list = new ArrayList<>();
            List<int[]> numss = new ArrayList<>();
            if (strs == null || strs.length == 0) {
                return list;
            }

            int size = 0;
            for (int k = 0; k < strs.length; ++k) {
                String str = strs[k];
                int[] nums = new int[26];
                for (char c : str.toCharArray()) {
                    ++nums[c - 'a'];
                }
                int i;
                for (i = 0; i < size; ++i) {
                    int j;
                    int[] temp = numss.get(i);
                    for (j = 0; j < 26; ++j) {
                        if (temp[j] != nums[j]) {
                            break;
                        }
                    }
                    if (j == 26) {
                        List<String> item = list.get(i);
                        item.add(str);
                        break;
                    }
                }
                if (i == size) {
                    List<String> item = new ArrayList<>();
                    item.add(str);
                    list.add(item);
                    numss.add(nums);
                    ++size;
                }
            }
            return list;
        }
    }


    /**
     * 使用字符->质数
     * 乘积确定，字符串唯一的方法。  7ms
     */
    class Solution_2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> list = new ArrayList<>();
            Map<Long, Integer> p = new HashMap<>();
            long[] num = new long[]{2, 3, 5, 7, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
            int index = 0;
            for (String str : strs) {
                long nums = 1;
                for (char c : str.toCharArray()) {
                    nums *= num[c - 'a'];
                }
                List<String> item;
                if (p.containsKey(nums)) {
                    item = list.get(p.get(nums));
                } else {
                    item = new ArrayList<>();
                    list.add(item);
                    p.put(nums, index++);
                }
                item.add(str);
            }
            return list;
        }
    }

    /**
     * 自定义getHash方法，6ms
     */
    class Solution_3 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            Map<Long, Integer> hashIndexMap = new HashMap<>();
            int size = 0;
            for (String str : strs) {
                long hash = getHash(str);
                List<String> list;
                if (hashIndexMap.containsKey(hash)) {
                    int index = hashIndexMap.get(hash);
                    list = ans.get(index);
                } else {
                    list = new ArrayList<>();
                    ans.add(list);
                    hashIndexMap.put(hash, size++);
                }
                list.add(str);
            }
            return ans;
        }

        long getHash(String str) {
            long sum = 0;
            long prod = 1;
            for (char c : str.toCharArray()) {
                sum += (long) (c);
                prod *= (long) (c);
            }
            return sum + prod;
        }
    }

}
