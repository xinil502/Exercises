package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 */
public class LeetCode_1018 {
    class Solution {
        public List<Boolean> prefixesDivBy5(int[] A) {
            List<Boolean> list = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < A.length; ++i) {
                sum = (sum << 1) % 10 + A[i];
                list.add(sum % 5 == 0);
            }
            return list;
        }
    }
}
