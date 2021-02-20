package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 *
 * @Author: Xinil
 * @Date: 2021/2/20 11:10
 */
public class LeetCode_697 {
    class Solution {
        public int findShortestSubArray(int[] A) {
            Map<Integer, Integer> degreeMap = new HashMap<>();
            Map<Integer, Integer> first = new HashMap<>();
            int res = 0, maxDegree = 0;
            for (int i = 0; i < A.length; ++i) {
                if (!first.containsKey(A[i]))
                    first.put(A[i], i);
                int degree = degreeMap.getOrDefault(A[i], 0) + 1;
                degreeMap.put(A[i], degree);
                if (degree < maxDegree)
                    continue;
                int distance = i - first.get(A[i]) + 1;
                if (degree > maxDegree) {
                    maxDegree = degree;
                    res = distance;
                } else if (degree == maxDegree) {
                    res = Math.min(res, distance);
                }
            }
            return res;
        }
    }
}
