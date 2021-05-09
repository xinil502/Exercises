package leetcode;

/**
 * 1482. 制作 m 束花所需的最少天数
 *
 * @Author: Xinil
 * @Date: 2021/5/9 13:29
 */
public class LeetCode_1482 {
    /*
     * 二分法查找合适的天数
     */
    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            int len = bloomDay.length;
            if (len < m * k) {
                return -1;
            }
            int min = Integer.MAX_VALUE, max = 1;
            for (int value : bloomDay) { //初始化二分的左右边界
                if (value > max) {
                    max = value;
                }
                if (value < min) {
                    min = value;
                }
            }
            while (min < max) { //二分判断
                int middle = (max >> 1) + (min >> 1) + (max & min & 1); //防止 min+max 超出int。先除以2再相加，同为奇数时进位。
                int countK = 0, countM = 0;
                boolean judge = false;
                for (int i = 0; i < len; ++i) { //循环判断，
                    if (bloomDay[i] <= middle) { //用countK统计连续个数，
                        ++countK;
                        if (countK == k) {  //countK达到K时，计数countM
                            countK = 0;
                            ++countM;
                            if (countM == m) { //countM达到M时，直接成功。
                                judge = true;
                                break;
                            }
                        }
                    } else { //连续花束中断，从0开始。
                        countK = 0;
                        if ((i + (m - countM) * k) > len) { //判断剩余花束个数，是否有可能满足。
                            break;
                        }
                    }
                }
                if (judge) { //middle 可以，则移动右边界
                    max = middle;
                } else {  //middle 不行，则移动左边界
                    min = middle + 1;
                }
            }
            return min;
        }
    }

}
