package leetcode;

/**
 * 338. 比特位计数
 *
 * @Author: Xinil
 * @Date: 2021/3/3 23:20
 */
public class LeetCode_338 {
    /**
     * x 比特位为 1的个数
     * count(x)
     * =  count(x&(x-1))+1
     * =  while(x == 0) x=x&(x-1); 直至为 0操作的执行次数
     */
    class Solution {
        public int[] countBits(int num) {
            int[] bits = new int[num + 1];
            for (int i = 1; i <= num; i++) {
                bits[i] = bits[i & (i - 1)] + 1;
            }
            return bits;
        }
    }
}
