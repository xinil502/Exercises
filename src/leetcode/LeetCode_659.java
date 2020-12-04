package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 659. 分割数组为连续子序列
 */
public class LeetCode_659 {

    /**
     * 方法不太好：
     * 用 Map 统计数字的出现次数，进行排序。
     * 使用二维数组存储子串头和尾。
     * 数字从小到大，插入key
     * 存在key-1结尾的子串：寻找最短的这样的子串。
     * 不存在key-1结尾的子串，构造新的子串。
     */
    class Solution {
        public boolean isPossible(int[] nums) {
            int[][] num = new int[nums.length][2];
            int end = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
            Object[] count = map.keySet().toArray();
            Arrays.sort(count, (a, b) -> (Integer) a - (Integer) b);
            for (Object i : count) {
                int key = (Integer) i;
                int value = map.get(key);
                while (value > 0) {
                    int m = 0;
                    int index = -1;
                    for (; m < end; ++m) {
                        if (num[m][1] == key - 1 && (index == -1 || num[m][1] - num[m][0] < num[index][1] - num[index][0])) {
                            index = m;
                        }
                    }
                    if (index == -1) {
                        num[end][0] = num[end][1] = key;
                        ++end;
                    } else {
                        num[index][1] = key;
                    }
                    --value;
                }
            }
            for (int i = 0; i < end; ++i) {
                if (num[i][1] - num[i][0] < 2) {
                    return false;
                }
            }
            return true;
        }
    }
}
