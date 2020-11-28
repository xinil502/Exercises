package leetcode;

public class LeetCode_493 {
    public static void main(String[] args) {
        int[] nums = Utils.createArray();

        Solution_693 sol = new Solution_693();
        System.out.println(sol.reversePairs(nums));
    }
}

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

    int[] reverse(int start, int end) {
        if (end - start < 2) {
            if (end == start) {
                return new int[]{0};
            }
            int[] re = new int[2];
            re[0] = 0;
            re[1] = val[start];
            return re;
        }
        int middle = (start + end) / 2;
        int[] left, right;
        left = reverse(start, middle);
        right = reverse(middle, end);
        int[] re = new int[left.length + right.length - 1];
        re[0] = left[0] + right[0];
        int i = 1, j = 1;
        while (true) {
            if (i == left.length) {
                break;
            }
            if (j != right.length && left[i] > 2 * right[j]) {
                ++j;
            } else {
                re[0] += j - 1;
                ++i;
            }
        }
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