package leetcode;

import java.util.Arrays;

/**
 * 767. 重构字符串
 */
public class LeetCode_767 {
    class Solution {
        public String reorganizeString(String S) {
            //统计字符个数
            int[][] num = new int[26][2];
            for (int i = 0; i < 26; ++i) {
                num[i][0] = 'a' + i;
            }
            for (int i = 0; i < S.length(); ++i) {
                ++num[S.charAt(i) - 'a'][1];
            }
            Arrays.sort(num, (a, b) -> b[1] - a[1]); //按出现次数降序排序
            //如果一个字符出现次数超过总长度的一半，必不能构成新字符串。
            if (num[0][1] > (S.length() + 1) / 2) {
                return "";
            }
            char[] chars = new char[S.length()];
            for (int i = 0; i < chars.length; ) {
                //求出出现次数最多的两个字符，将他俩排入进去。
                int max1 = 0, max2 = 1;
                for (int j = 2; j < 26; ++j) {
                    if (num[j][1] > num[max1][1]) {
                        max1 = j;
                    } else if (num[j][1] > num[max2][1]) {
                        max2 = j;
                    }
                }
                if (num[max1][1] != 0) {
                    --num[max1][1];
                    chars[i] = (char) num[max1][0];
                    ++i;
                }
                if (num[max2][1] != 0) {
                    --num[max2][1];
                    chars[i] = (char) num[max2][0];
                    ++i;
                }
            }
            return new String(chars);
        }
    }
}
