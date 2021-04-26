package leetcode;

/**
 * 1011. 在 D 天内送达包裹的能力
 *
 * @Author: Xinil
 * @Date: 2021/4/26 16:18
 */
public class LeetCode_1011_二分法查找 {
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int min = 1;
            for (int i : weights) {
                min = Math.max(min, i);
            }
            int max = Integer.MAX_VALUE;

            while (max - min >= 1) {
                int middle = (max - min) / 2 + min;
                int count = 0;
                int sum = 0;
                for (int i = 0; i < weights.length; ) {
                    sum += weights[i];
                    if (sum > middle) {
                        sum = 0;
                        ++count;
                    } else {
                        ++i;
                    }
                }
                if (count < D) {
                    max = middle;
                } else {
                    min = middle + 1;
                }
            }
            return min;
        }
    }
}
