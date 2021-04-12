package leetcode;

import java.util.Arrays;

/**
 * 179. 最大数
 *
 * @Author: Xinil
 * @Date: 2021/4/12 13:22
 */
public class LeetCode_179_建议复习_重写Compare方法没想到 {
    class Solution {
        public String largestNumber(int[] nums) {
            int n = nums.length;
            // 转换成包装类型，以便传入 Comparator 对象
            Integer[] numsArr = new Integer[n];
            for (int i = 0; i < n; i++) {
                numsArr[i] = nums[i];
            }

            Arrays.sort(numsArr, (x, y) -> {
                long lenX = 10, lenY = 10;
                while (lenX <= x) {
                    lenX *= 10;
                }
                while (lenY <= y) {
                    lenY *= 10;
                }
                return (int) (y * lenX + x - x * lenY - y);
            });

            if (numsArr[0] == 0) {
                return "0";
            }
            StringBuilder ret = new StringBuilder();
            for (int num : numsArr) {
                ret.append(num);
            }
            return ret.toString();
        }
    }
}
