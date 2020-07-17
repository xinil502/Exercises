package leetcode;

import java.util.Scanner;

public class LeetCode_35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution_35 sol = new Solution_35();
        System.out.println(sol.searchInsert(nums, sc.nextInt()));
    }
}

class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1, mid;
        while (true) {
            mid = (l + r) >> 1;
            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }

            if (r - l < 2) {
                break;
            }
        }
        int k = r + 1;
        if (nums[r] >= target) {
            k = r;
        }
        if (nums[l] >= target) {
            k = l;
        }
        return k;
    }
}