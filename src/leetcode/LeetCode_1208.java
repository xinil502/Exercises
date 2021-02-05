package leetcode;

/**
 * 1208. 尽可能使字符串相等
 *
 * @Author: Xinil
 * @Date: 2021/2/5 20:29
 */
public class LeetCode_1208 {
    /**
     * 滑动窗口，大了左指针移，小了右指针移
     */
    class Solution_1 {
        public int equalSubstring(String s, String t, int maxCost) {
            int length = Math.min(s.length(), t.length());
            int[] d = new int[length];
            for (int i = 0; i < length; ++i) {
                d[i] = Math.abs(s.charAt(i) - t.charAt(i));
            }
            int sum, start, end;
            sum = start = end = 0;
            int maxLength = 0;
            while (end < length) {
                if (sum <= maxCost) {
                    sum += d[end];
                    ++end;
                    if (sum <= maxCost) {
                        maxLength = Math.max(maxLength, end - start);
                    }
                } else {
                    sum -= d[start];
                    ++start;
                }
            }
            return maxLength;
        }
    }


    /**
     * 滑动窗口的大小只增不减（每次循环右指针都移动）
     */
    class Solution_2 {
        public int equalSubstring(String s, String t, int maxCost) {

            int m = s.length();
            char[] sch = s.toCharArray();
            char[] tch = t.toCharArray();
            int[] result = new int[m];
            for (int i = 0; i < m; i++) {
                result[i] = Math.abs(sch[i] - tch[i]);
            }

            int maxLegth = 0;
            int sum = 0;
            for (int left = 0, right = 0; right < result.length; right++) {
                sum += result[right];
                if (sum <= maxCost) { //只走右指针
                    maxLegth = Math.max(maxLegth, right - left + 1);
                } else { //两个指针同时走
                    sum -= result[left];
                    left++;
                }
            }
            return maxLegth;

        }
    }

}
