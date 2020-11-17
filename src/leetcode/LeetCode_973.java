package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 973. 最接近原点的 K 个点
 */
public class LeetCode_973 {
    public static void main(String[] args) {
        int[][] nums = Utils.createDoubleDimensionalArray();
        int k = new Scanner(System.in).nextInt();

        Solution_973 sol = new Solution_973();
        nums = sol.kClosest(nums, k);
        for (int[] e : nums) {
            System.out.println(Arrays.toString(e));
        }
    }
}

class Solution_973 {
    public int[][] kClosest(int[][] points, int K) {
        int length = points.length;
        int[][] nums = new int[length][3];
        for (int i = 0; i < length; ++i) {  //重新创建数组，去存储距离
            nums[i][0] = points[i][0];
            nums[i][1] = points[i][1];
            nums[i][2] = nums[i][0] * nums[i][0] + nums[i][1] * nums[i][1];
        }
        Arrays.sort(nums, Comparator.comparingInt(a -> a[2])); //数组排序
        int[][] re = new int[K][2];
        for (int i = 0; i < K; ++i) {  //导出结果数组
            re[i][0] = nums[i][0];
            re[i][1] = nums[i][1];
        }
        return re;
    }
}