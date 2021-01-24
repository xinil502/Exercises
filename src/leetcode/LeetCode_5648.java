package leetcode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;


/**
 * 5648. 生成乘积数组的方案数
 */
public class LeetCode_5648 {
    class Solution {
        public int[] waysToFillArray(int[][] queries) {
            int[] re = new int[queries.length];
            int z = 0;
            for (int[] nums : queries) {
                int a = nums[0];
                int b = nums[1];
                Map<Integer, Integer> map = new HashMap<>();
                for (int i = 2; i <= b; ++i) {
                    while (b % i == 0) {
                        map.put(i, map.getOrDefault(i, 0) + 1);
                        b /= i;
                    }
                }
                BigInteger integer = new BigInteger("1");
                for (Integer value : map.keySet()) {
                    System.out.print(value);
                    System.out.println(": " + map.get(value));
                    integer = integer.multiply(fun(a, map.get(value)));
                }
                integer = integer.remainder(new BigInteger("" + 1000000007));
                re[z] = integer.intValue();
                ++z;
            }
            return re;
        }

        BigInteger fun(int m, int n) {
            if (n == 0) {
                return new BigInteger("1");
            }
            BigInteger c = new BigInteger("0");
            for (int i = 0; i < n; ++i) {
                BigInteger b = new BigInteger("1");
                int z = n - i;
                for (int k = m - z + 1; k <= m; ++k) {
                    b = b.multiply(new BigInteger("" + k));
                }
                while (z > 1) {
                    b = b.divide(new BigInteger("" + z));
                    --z;
                }
                b = b.multiply(fun(n - i, i));
                c = c.add(b);
            }
            return c;
        }
    }

}
