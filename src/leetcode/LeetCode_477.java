package leetcode;

import java.util.Scanner;

/**
 * LeetCode_477.汉明距离总和。
 */
public class LeetCode_477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution_477_2 sol = new Solution_477_2();
        System.out.println(sol.totalHammingDistance(nums));
    }
}

class Solution_477_1 { //按数字计算，求和，超时。
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        int k;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                k = nums[i] ^ nums[j];
                while (!(k == 0)) {
                    if ((k & 1) == 1) {
                        ++sum;
                    }
                    k >>= 1;
                }
            }
        }
        return sum;
    }
}

class Solution_477_2 {  //按位计算，求和
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] j = new int[30];
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int k = 0, num = nums[i];
            while (num != 0) {
                j[k] += num & 1;
                num >>= 1;
                ++k;
            }
        }
        int sum = 0;
        for (int e : j) {
            sum += e * (n - e);
        }
        return sum;
    }
}
