package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 547.省份数量
 */
public class LeetCode_547 {
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            Map<Integer, Integer> map = new HashMap<>();
            int length = isConnected.length, k = 1, sum = 0;
            for (int i = 0; i < length; ++i) {
                map.put(i, -1);
            }
            for (int i = 0; i < length; ++i) {
                ++sum;
                for (int j = 0; j < i; ++j) {
                    if (isConnected[i][j] == 1) {
                        int pi = map.get(i), pj = map.get(j);
                        if (pi == -1 && pj == -1) {
                            map.put(i, k);
                            map.put(j, k);
                            ++k;
                            --sum;
                        } else if (pi == -1) {
                            map.put(i, pj);
                            --sum;
                        } else if (pj == -1) {
                            map.put(j, pi);
                            --sum;
                        } else if (pi != pj) {
                            for (int next : map.keySet()) {
                                if (map.get(next) == pi) {
                                    map.put(next, pj);
                                }
                            }
                            --sum;
                        }
                    }
                }
            }
            return sum;
        }
    }
}
