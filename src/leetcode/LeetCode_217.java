package leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 217.寻找重复元素
 */
public class LeetCode_217 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
        }

        Solution_217 sol = new Solution_217();
        System.out.println(sol.containsDuplicate(nums));
    }
}

class Solution_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return set.size() != nums.length;
    }
}