package leetcode;

/**
 * 151. 翻转字符串里的单词
 *
 * @Author: Xinil
 * @Date: 2021/2/2 4:54
 */
public class LeetCode_151 {
    class Solution {
        public String reverseWords(String s) {
            String[] strs = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = strs.length - 1; i > -1; --i) {
                if (strs[i].length() != 0 && (!strs[i].equals(" "))) {
                    sb.append(strs[i]).append(" ");
                }
            }
            return sb.toString().substring(0, sb.length() - 1);
        }
    }
}
