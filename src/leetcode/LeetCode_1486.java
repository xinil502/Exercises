package leetcode;

/**
 * 1486. 数组异或操作
 *
 * @Author: Xinil
 * @Date: 2021/5/7 17:35
 */
public class LeetCode_1486 {
    /**
     * 如果一个数为 4k ，那么(4k)^(4k+1)^(4k+2)^(4k+3) 为 0
     * * 因为最后两位 00, 01, 10, 11异或和为 0，
     * * 这四个数除过后两位的都一样，异或后也为 0、
     */
    class Solution {
        public int xorOperation(int n, int start) {
            //右移一位就可以变为一个连续的数列求异或和。
            //因为起点不为0， 所以用(0^1^2...^(start>>1-1))  ^ (0^1^2^....^(start>>1+n-1)) 来表示中间一段。
            int half = xor((start >> 1) - 1) ^ xor((start >> 1) + n - 1);
            return half << 1 | (n & start & 1);
        }

        //从零开始的异或和，每四位就会归零
        //用一个函数计算 0^1^2^3....^n 的结果
        public int xor(int n) {
            //因为是从0开始求异或，所以取余等于3才是刚好为0。
            if (n % 4 == 0) return n;  //剩单独一个n
            else if (n % 4 == 1) return 1; //(n-1)^n
            else if (n % 4 == 2) return n + 1; //(n-2)^(n-1)^n
            return 0;
        }
    }
}
