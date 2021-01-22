package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 989.数组形式的整数加法
 */
public class LeetCode_989 {
    class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> list = new ArrayList<>();
            int plus = 0, i = A.length - 1;
            while (i > -1 && (K != 0 || plus != 0)) {
                int sum = K % 10 + plus + A[i];
                A[i] = sum % 10;
                plus = sum / 10;
                K /= 10;
                --i;
            }
            if (i == -1 && (plus != 0 || K != 0)) {
                while (K != 0 || plus != 0) {
                    int sum = K % 10 + plus;
                    plus = sum / 10;
                    K /= 10;
                    list.add(0, sum % 10);
                }
            }
            for (i = 0; i < A.length; ++i) {
                list.add(A[i]);
            }
            return list;
        }
    }
}
