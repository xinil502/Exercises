package leetcode;

/**
 * 424. 替换后的最长重复字符
 *
 * @Author: Xinil
 * @Date: 2021/2/2 21:43
 */
public class LeetCode_424 {
    class Solution {
        public int characterReplacement(String s, int k) {
            char[] chars = s.toCharArray();
            int max = -1;
            for (int i = 0; i < 26; ++i) { //对每个字符进行分析。
                char c = (char) ('A' + i);
                int start = 0;
                int end = 0;

                //控制初始滑动窗口为替换前k个。
                for (int j = 0; j < k && end < s.length(); ++j) {
                    while (end < s.length() && chars[end] == c) {
                        ++end;
                    }
                    ++end;
                }
                while (end < s.length() && chars[end] == c) {
                    ++end;
                }

                //初始滑动窗口为字符串最大长度，直接return字符串长度
                if (end >= s.length()) {
                    return s.length();
                }

                //比较最大值
                max = Math.max(max, end - start);
                while (end < s.length()) {  //滑动窗口
                    ++end; //右端右移一个字符（该字符必定为非想要的字符）
                    while (end < s.length() && chars[end] == c) { //判断右端接下来有多少个连续的想要的字符
                        ++end;
                    }

                    while (chars[start] == c) { //左端左移直到碰到一个非想要的字符
                        ++start;
                    }
                    ++start;//跳过非想要的字符。

                    max = Math.max(max, end - start);
                }
            }
            return max;
        }
    }
}
