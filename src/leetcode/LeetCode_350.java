package leetcode;

import java.util.*;

public class LeetCode_350 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];

        for (int i = 0; i < m; ++i) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            nums2[i] = sc.nextInt();
        }

        Solution_350 sol = new Solution_350();
        int[] outnums = sol.intersect(nums1, nums2);
        System.out.println(Arrays.toString(outnums));
    }
}


class Solution_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int k = 0;
        int[] nums = new int[nums1.length];
        for (int i : nums2) {  //因为最后顺序是按nums1返回的，所以，存入nums2，用nums1来比较。
            if (map.get(i) == null) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (int i : nums1) {
            if (map.get(i) != null && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
                nums[k++] = i;
            }
        }
        return Arrays.copyOf(nums, k);
    }
}