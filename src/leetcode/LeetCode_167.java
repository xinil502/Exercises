package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * LeetCode_167.两数之和Ⅱ-输入有序数组
 */
public class LeetCode_167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), target;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        target = sc.nextInt();

        Solution_167 sol = new Solution_167();
        System.out.println(Arrays.toString(sol.twoSum(nums, target)));
    }
}

class Solution_167 {
    public int[] twoSum(int[] numbers, int target) {
        int i, j;
        i = 0;
        j = numbers.length - 1;
        while (numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] > target) {
                --j;
            } else {
                ++i;
            }
        }
        int[] num = new int[2];
        num[0] = i + 1;
        num[1] = j + 1;
        return num;
    }
}
