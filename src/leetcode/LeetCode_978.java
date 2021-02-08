package leetcode;

/**
 * 978. 最长湍流子数组
 *
 * @Author: Xinil
 * @Date: 2021/2/8 22:03
 */
public class LeetCode_978 {
    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int len = arr.length;
            if (arr == null) {
                return 0;
            } else if (len < 2) {
                return len;
            }
            int max = -1;
            int sum = 1;
            for (int i = 1; i < len; ++i) {
                if (arr[i - 1] < arr[i]) {
                    ++sum;
                } else {
                    max = Math.max(max, sum);
                    sum = 1;
                }
                ++i;
                if (i < len) {
                    if (arr[i - 1] > arr[i]) {
                        ++sum;
                    } else {
                        max = Math.max(max, sum);
                        sum = 1;
                    }
                }
            }
            max = Math.max(max, sum);
            sum = 1;
            for (int i = 1; i < len; ++i) {
                if (arr[i - 1] > arr[i]) {
                    ++sum;
                } else {
                    max = Math.max(max, sum);
                    sum = 1;
                }
                ++i;
                if (i < len) {
                    if (arr[i - 1] < arr[i]) {
                        ++sum;
                    } else {
                        max = Math.max(max, sum);
                        sum = 1;
                    }
                }
            }
            return Math.max(max, sum);
        }
    }

}
