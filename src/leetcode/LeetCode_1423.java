package leetcode;

/**
 * 1423. 可获得的最大点数
 *
 * @Author: Xinil
 * @Date: 2021/2/6 22:22
 */
public class LeetCode_1423 {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int i = 0, sum = 0;
            while (i < k) {
                sum += cardPoints[i++];
            }

            int max = sum;
            while (--i > -1) {
                sum += cardPoints[cardPoints.length + i - k] - cardPoints[i];
                if (sum > max) {
                    max = sum;
                }
            }
            return max;
        }
    }
}
