package leetcode;

/**
 * 189.旋转数组
 */
public class LeetCode_189 {
    // 三次翻转 100% 91%
    class Solution_1 {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
        }
    }

    // 环形替换 100%  95%
    class Solution_2 {
        public void rotate(int[] nums, int k) {
            int length = nums.length;
            int count = gcd(length, k);
            boolean add = count == k || count == length;
            for (int i = 0; i < count; ++i) {
                int j = i;
                int num = nums[i];
                do {
                    int m = (j + k) % length;
                    int temp = nums[m];
                    nums[m] = num;
                    num = temp;
                    j = m;
                } while (i != j);
            }
        }

        int gcd(int x, int y) {
            return y > 0 ? gcd(y, x % y) : x;
        }
    }
}
