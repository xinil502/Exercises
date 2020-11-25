package leetcode;

/**
 * 1370. 上升下降字符串
 */
public class LeetCode_1370 {
    /**
     * 使用捅存储排序前的字符串。
     * <p>
     * 排序后的字符串，使用StringBuilder连接，外层循环判断条件为存储长度等于原字符串长度。用时4ms。
     * 使用与排序前等长的字符数组存储，外层循环判断条件为，之后new为字符串。用时2ms。
     */
    class Solution {
        public String sortString(String s) {
            int[] values = new int[26];
            for (char c : s.toCharArray()) {  //用数组存储排序前的字符串
                ++values[c - 97];
            }
            char[] res = new char[s.length()];
            for (int j = 0; j < s.length(); ) {  //判断条件为已经存满。
                for (int i = 0; i < 26; ++i) {
                    if (values[i] > 0) {
                        res[j] = (char) ('a' + i);
                        --values[i];
                        ++j;
                    }
                }
                for (int i = 25; i > -1; --i) {
                    if (values[i] > 0) {
                        res[j] = (char) ('a' + i);
                        --values[i];
                        ++j;
                    }
                }
            }
            return new String(res);
        }
    }
}
