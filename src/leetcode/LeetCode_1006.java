package leetcode;

/**
 * 1006. 笨阶乘
 *
 * @Author: Xinil
 * @Date: 2021/4/1 16:30
 */
public class LeetCode_1006 {
    class Solution {
        public int clumsy(int N) {
            int sum = 0;
            for (int i = N - 3; i > 0; i -= 4) {
                sum += i;
            }

            if (N > 2) {
                sum += N * (N - 1) / (N - 2);
            } else if (N == 2) {
                sum += 2;
            } else if (N == 1) {
                sum += 1;
            }
            for (int i = N - 4; i > 0; i -= 4) {
                if (i > 2) {
                    sum -= i * (i - 1) / (i - 2);
                } else if (i == 2) {
                    sum -= 2;
                } else if (i == 1) {
                    sum -= 1;
                }
            }
            return sum;
        }
    }
}
