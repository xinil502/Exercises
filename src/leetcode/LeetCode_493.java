package leetcode;

public class LeetCode_493 {
    public static void main(String[] args) {
        int[] nums = Utils.createArray();

        Solution_693 sol = new Solution_693();
        System.out.println(sol.reversePairs(nums));
    }
}

/**
 * 归并排序思路
 * 数组的翻转对 = 左反转对 + 右翻转对 + 一左一右
 */
class Solution_693 {
    int[] val = null;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        val = nums;
        int[] re = reverse(0, nums.length);
        return re[0];
    }

    int[] reverse(int start, int end) { // 计算翻转对的方法，第一个位置存储翻转对数目，之后的位置存储排序子数组。
        if (end - start < 2) {   //长度为0或1，递归结束直接返回。
            if (end == start) {
                return new int[]{0};
            }
            int[] re = new int[2];
            re[0] = 0;
            re[1] = val[start];
            return re;
        }
        //求出中位索引值（防止索引值太大相加超过int）。
        int middle = start / 2 + end / 2;
        if (start % 2 == 1 && end % 2 == 1) {
            ++middle;
        }
        int[] left, right;  //接收递归后的左右子数组。
        left = reverse(start, middle);
        right = reverse(middle, end);
        int[] re = new int[left.length + right.length - 1];
        re[0] = left[0] + right[0];
        int i = 1, j = 1;
        while (true) { //求左一右一的翻转对。
            if (i == left.length) { //大的那边遍历完了，跳出循环
                break;
            }
            //右边没遍历完 &&（可能还有更多右边满足要求）：右侧索引值自增
            if (j != right.length && (left[i] / 2 > right[j] || left[i] / 2 == right[j] && left[i] % 2 == 1)) {
                ++j;
            } else { //对于一个左侧值，统计有多少右侧值满足要求，加起来
                re[0] += j - 1;
                ++i;
            }
        }
        //子数组合并
        int m = 1, n = 1;
        for (i = 1; m < left.length && n < right.length; ++i) {
            if (left[m] < right[n]) {
                re[i] = left[m];
                ++m;
            } else {
                re[i] = right[n];
                ++n;
            }
        }
        if (m < left.length) {
            while (m < left.length) {
                re[i] = left[m];
                ++m;
                ++i;
            }
        } else {
            while (n < right.length) {
                re[i] = right[n];
                ++n;
                ++i;
            }
        }
        return re;
    }
}