package leetcode;

/**
 * 738. 单调递增的数字
 */
public class LeetCode_738 {
    /**
     * 判断非递减数位，
     * 如果从第i位开始, 没有递增，有递减，则第i位变为i-1，后面的数位变为 9.
     * 如果均为非递减，则直接返回。
     */
    class Solution {
        public int monotoneIncreasingDigits(int N) {
            if (N == 0) {
                return 0;
            }
            char[] num = Integer.toString(N).toCharArray();
            int k = 0, i;
            for (i = 1; i < num.length && num[i - 1] <= num[i]; ++i) {
                if (num[i - 1] != num[i]) {
                    k = i;
                }
            }
            if (i != num.length) {
                num[k] = (char) (num[k] - 1);
                for (++k; k < num.length; ++k) {
                    num[k] = '9';
                }
            }
            return Integer.parseInt(new String(num));
        }
    }
}
