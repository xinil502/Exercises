package leetcode;

/**
 * 5764. 准时到达的列车最小时速
 *
 * @Author: Xinil
 * @Date: 2021/5/23 14:26
 */
public class LeetCode_5764 {

    class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            int min = 1, max = 10000000;
            while (min < max) {
                int middle = (max + min) / 2;
                double sum = 0;
                for (int i : dist) {
                    double temp = 1.0 * i / middle;
                    sum = Math.ceil(sum) + temp;
                }
                if (sum > hour) {
                    min = middle + 1;
                } else {
                    max = middle;
                }
            }

            int middle = max;
            double sum = 0;
            for (int i : dist) {
                double temp = 1.0 * i / middle;
                sum = Math.ceil(sum) + temp;
            }

            return sum <= hour ? max : -1;
        }

    }
}
