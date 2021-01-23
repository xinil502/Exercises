package leetcode;

import java.util.Arrays;

/**
 * 1319. 连通网络的操作次数
 */
public class LeetCode_1319 {
    class Solution {
        int[] f;
        int[] height;

        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) {
                return -1;
            }
            f = new int[n];
            height = new int[n];
            for (int i = 0; i < n; ++i) {
                f[i] = i;
            }
            Arrays.fill(height, 1);
            int length = connections.length;
            for (int i = 0; i < length; ++i) {
                if (connect(connections[i][0], connections[i][1])) {
                    --n;
                }
            }
            return n - 1;
        }

        int find(int a) {
            if (f[a] == a) {
                return a;
            } else {
                return find(f[a]);
            }
        }

        boolean connect(int a, int b) {
            int x = find(a), y = find(b);
            if (x == y) {
                return false;
            }
            if (height[x] < height[y]) {
                x ^= y;
                y ^= x;
                x ^= y;
            }

            f[y] = x;
            height[x] = Math.max(height[x], height[y] + 1);
            return true;
        }
    }
}
