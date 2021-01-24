package leetcode;

/**
 * 5664. 放置盒子
 */
public class LeetCode_5664 {
    class Solution {
        public int minimumBoxes(int n) {
            int sumA = 0;
            int sumB = 0;

            int bottomA = 0;
            int bottomB = 0;

            if (n == 1) {
                return 1;
            } else if (n <= 4) {
                return Math.min(3, n);
            } else if (n <= 10) {
                return Math.min(6, 3 + getMore(n - 4));
            }

            //每层的盒子数
            bottomA = 3;
            bottomB = 6;
            int nextAcc = 4;

            //总盒子数
            sumA = 4;
            sumB = 10;

            //算出底层盒子数的临界值
            while (sumB < n) {
                bottomA = bottomB;
                bottomB += nextAcc;
                nextAcc++;

                sumA = sumB;
                sumB += bottomB;
            }

            //最大盒子数，最小盒子数+相差盒子数
            return Math.min(bottomB, bottomA + getMore(n - sumA));
        }

        //二分法尝试底层单个的个数
        private int getMore(int i) {
            int l = 0;
            int r = (i + 1) / 2;
            while (l < r) {
                int mid = l + (r - l >> 1);
                //每次尝试对应的mid上一层为mid-1，再上一层为mid-2....
                //做出判断
                if (checked(mid, i)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        private boolean checked(int mid, int i) {
            long tmp = mid;
            return (tmp + 1) * tmp / 2 >= i;

        }
    }
}
