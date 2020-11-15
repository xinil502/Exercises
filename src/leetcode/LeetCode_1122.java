package leetcode;

import java.util.*;

/**
 * 1122. 数组的相对排序
 */
public class LeetCode_1122 {
    public static void main(String[] args) {
        int[] arr1 = Utils.createArray();
        int[] arr2 = Utils.createArray();

        Solution_1122 sol = new Solution_1122();
        System.out.println(Arrays.toString(sol.relativeSortArray(arr1, arr2)));
    }
}

class Solution_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr2.length; ++i) {
            map.put(arr2[i], 0);
        }
        for (int i = 0; i < arr1.length; ++i) {
            Integer nums = map.get(arr1[i]);
            if (nums == null) {
                list.add(arr1[i]);
            } else {
                map.put(arr1[i], nums + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr2.length; ++i) {
            int b = map.get(arr2[i]);
            for (int j = 0; j < b; ++j) {
                res.add(arr2[i]);
            }
        }

        Integer[] n = list.toArray(new Integer[0]);
        Arrays.sort(n);
        List<Integer> sorted = Arrays.asList(n);
        res.addAll(sorted);
        return Arrays.stream(res.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }
}