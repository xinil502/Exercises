package leetcode;

import java.util.Arrays;

/**
 * 204. 计数质数
 */
public class LeetCode_204 {
    class Solution {
        public int countPrimes(int n) {
            int sum = 0;
            boolean[] isPrime = new boolean[n];
            for (int i = 2; i < n; ++i) {
                if (!isPrime[i]) {
                    ++sum;
                    for (int j = 2 * i; j < n; j += i) {
                        isPrime[j] = true;
                    }
                }
            }
            return sum;
        }
    }
}
