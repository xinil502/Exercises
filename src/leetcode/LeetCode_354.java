package leetcode;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 *
 * @Author: Xinil
 * @Date: 2021/3/4 19:25
 */
public class LeetCode_354 {
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes.length == 0) {
                return 0;
            }

            int n = envelopes.length;
            Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);

            int[] f = new int[n];
            Arrays.fill(f, 1);
            int ans = 1;
            for (int i = 1; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) {
                        f[i] = Math.max(f[i], f[j] + 1);
                    }
                }
                ans = Math.max(ans, f[i]);
            }
            return ans;
        }
    }
}
