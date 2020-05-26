package leetcode;

import java.util.Scanner;
import java.util.Random;

public class LeetCode_287 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution_287_1 sol1 = new Solution_287_1();
        System.out.println(sol1.findDuplicate(nums));
    }
}

class Solution_287_1 {
    public int findDuplicate(int[] nums) {
        /*
         * 数组中的数在1-nus.length-1之间
         * 对这些数进行二分法筛选
         * 时间复杂度为O(nlogn)
         */
        int mid, i, start = 1, end = nums.length - 1, count;
        while (end - start > 1) {
            count = 0;
            mid = (start + end) / 2;
            for (i = 0; i < nums.length; ++i) {
                if (nums[i] > mid && nums[i] <= end) {
                    ++count;
                }
            }
            if (count > (end - start + 1) / 2) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (start == end) {
            return start;
        } else {
            for (count = 0, i = 0; i < nums.length; ++i) {
                if (nums[i] == start) {
                    ++count;
                }
            }
            if (count > 1) {
                return start;
            } else {
                return end;
            }
        }
    }
}


class Solution_287_2 { //欧皇专用。
    public int findDuplicate(int[] nums) {
        Random r = new Random();
        int a, b;
        while (true) {
            a = r.nextInt(nums.length);
            b = r.nextInt(nums.length);
            if (nums[a] == nums[b] && a != b) {
                return nums[a];
            }
        }
    }
}