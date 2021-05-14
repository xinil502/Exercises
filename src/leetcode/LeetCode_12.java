package leetcode;

/**
 * 12. 整数转罗马数字
 *
 * @Author: Xinil
 * @Date: 2021/5/14 15:19
 */
public class LeetCode_12 {
    /**
     * // 4，9做特殊处理，大于4先添加一个5，最后添加1
     */
    class Solution {
        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            int a, b, c, d;
            a = num / 1000;
            b = num / 100 % 10;
            c = num / 10 % 10;
            d = num % 10;
            for (int i = 0; i < a; ++i) {
                sb.append("M");
            }

            if (b == 9) {
                sb.append("CM");
                b = 0;
            } else if (b > 4) {
                sb.append("D");
                b -= 5;
            } else if (b == 4) {
                sb.append("CD");
                b = 0;
            }
            for (int i = 0; i < b; ++i) {
                sb.append("C");
            }

            if (c == 9) {
                sb.append("XC");
                c = 0;
            } else if (c > 4) {
                sb.append("L");
                c -= 5;
            } else if (c == 4) {
                sb.append("XL");
                c = 0;
            }
            for (int i = 0; i < c; ++i) {
                sb.append("X");
            }


            if (d == 9) {
                sb.append("IX");
                d = 0;
            } else if (d > 4) {
                sb.append("V");
                d -= 5;
            } else if (d == 4) {
                sb.append("IV");
                d = 0;
            }
            for (int i = 0; i < d; ++i) {
                sb.append("I");
            }


            return sb.toString();
        }
    }
}
