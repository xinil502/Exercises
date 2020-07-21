package leetcode;


import java.util.Scanner;

/**
 * LeetCode_628.三个数的最大乘积
 */
public class LeetCode_628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution_628 sol = new Solution_628();
        System.out.println(sol.maximumProduct(nums));
    }
}

class Solution_628 {
    public int maximumProduct(int[] nums) {
        int[] max = new int[3];
        int[] min = new int[2];
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            int temp = nums[i];
            if (temp > 0) {
                k = 1;
                if (temp > max[0]) {
                    if (temp > max[1]) {
                        if (temp > max[2]) {
                            max[0] = max[1];
                            max[1] = max[2];
                            max[2] = temp;
                            continue;
                        }
                        max[0] = max[1];
                        max[1] = temp;
                        continue;
                    }
                    max[0] = temp;
                }
            } else {
                if (temp < min[0]) {
                    min[0] = temp;
                    if (min[0] < min[1]) {
                        min[0] = min[1];
                        min[1] = temp;
                    }
                }
            }
        }
        if (k == 0) {  //全是负数时，被迫负数乘积
            int[] p = new int[]{-100000, -100000, -100000};
            for (int i = 0; i < nums.length; ++i) {
                int temp = nums[i];
                if (temp > p[0]) {
                    if (temp > p[1]) {
                        if (temp > p[2]) {
                            p[0] = p[1];
                            p[1] = p[2];
                            p[2] = temp;
                            continue;
                        }
                        p[0] = p[1];
                        p[1] = temp;
                        continue;
                    }
                    p[0] = temp;
                }
            }
            return p[0] * p[1] * p[2];
        }
        return Math.max(max[0] * max[1] * max[2], min[0] * min[1] * max[2]);
    }
}