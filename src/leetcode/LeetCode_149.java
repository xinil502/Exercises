package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. 直线上最多的点数
 *
 * @Author: Xinil
 * @Date: 2021/6/24 16:18
 */
public class LeetCode_149 {
    /**
     * O(n²)遍历每个点，
     * 对于一个左边的点，使用哈希表记录相同斜率的点的个数。
     */
    class Solution {
        public int maxPoints(int[][] points) {
            int n = points.length;
            //n == 1 || n == 2
            if (n <= 2) {
                return n;
            }
            int ret = 0;
            for (int i = 0; i < n; i++) {
                //一条直线的共线点数，，大于剩余点数，或者大于一半的点数时，则一定为最大共线点数
                if (ret >= n - i || ret > n / 2) {
                    break;
                }
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = i + 1; j < n; j++) {
                    int x = points[i][0] - points[j][0];
                    int y = points[i][1] - points[j][1];
                    if (x == 0) {
                        y = 1;
                    } else if (y == 0) {
                        x = 1;
                    } else {
                        if (y < 0) {
                            x = -x;
                            y = -y;
                        }
                        int gcdXY = gcd(Math.abs(x), Math.abs(y));
                        x /= gcdXY;
                        y /= gcdXY;
                    }
                    //x，y最大为10000.  使用int同时存储x，y。
                    int key = y + x * 20001;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
                //判断当前第 i 点往后拼凑的直线，最多有多少点。
                int maxn = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int num = entry.getValue();
                    maxn = Math.max(maxn, num + 1);
                }
                ret = Math.max(ret, maxn);
            }
            return ret;
        }

        private int gcd(int a, int b) {
            return b != 0 ? gcd(b, a % b) : a;
        }
    }
}
