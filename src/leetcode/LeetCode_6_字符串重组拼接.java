package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 *
 * @Author: Xinil
 * @Date: 2021/4/9 14:24
 */
public class LeetCode_6_字符串重组拼接 {
    /**
     * 寻找循环长度，重复添加到指定行。
     * 循环长度 ：   行数为 1时，循环长度为 1
     * 行数为 n(n>1)时，循环长度为 2n-2。
     */
    class Solution {
        public String convert(String s, int numRows) {
            List<List<Character>> list = new ArrayList<>();
            for (int i = 0; i < numRows; ++i) {
                list.add(new ArrayList<>());
            }

            int[] column;
            int columnSize;
            if (numRows == 1) {
                columnSize = 1;
                column = new int[columnSize];
                column[0] = 0;
            } else {
                columnSize = 2 * numRows - 2;
                column = new int[columnSize];
                for (int i = 0; i < numRows; ++i) {
                    column[i] = i;
                }
                for (int i = numRows; i < columnSize; ++i) {
                    column[i] = column[i - 1] - 1;
                }
            }

            int j = 0;
            for (char c : s.toCharArray()) {
                list.get(column[j]).add(c);
                ++j;
                j %= columnSize;
            }

            StringBuilder sb = new StringBuilder();
            for (List<Character> l : list) {
                for (char c : l) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
