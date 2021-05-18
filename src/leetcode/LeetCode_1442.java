package leetcode;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 *
 * @Author: Xinil
 * @Date: 2021/5/18 14:43
 */
public class LeetCode_1442 {
    class Solution {
        public int countTriplets(int[] arr) {
            if (arr.length < 2) {
                return 0;
            }
            int sum = 0;
            for (int i = 0; i < arr.length - 1; ++i) {
                int xor = arr[i];
                for (int j = i + 1; j < arr.length; ++j) {
                    xor ^= arr[j];
                    if (xor == 0) {
                        sum += j - i;
                    }
                }
            }
            return sum;
        }
    }
}
