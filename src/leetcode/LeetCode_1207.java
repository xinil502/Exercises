package leetcode;

import java.util.*;

/**
 * 1207.独一无二的出现次数
 */
public class LeetCode_1207 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
        }

        Solution_1207 sol = new Solution_1207();
        System.out.println(sol.uniqueOccurrences(nums));
    }
}

class Solution_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer key : map.keySet()) {
            set.add(map.get(key));
        }
        return set.size() == map.size();
    }
}