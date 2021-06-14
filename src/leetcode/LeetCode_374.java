package leetcode;

/**
 * 374. 猜数字大小
 *
 * @Author: Xinil
 * @Date: 2021/6/14 17:30
 */
public class LeetCode_374 {
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int min = 1;
            while (min < n) {
                int mid = (min >> 1) + (n >> 1) + (min & n & 1);
                if (guess(mid) == 1) {
                    min = mid + 1;
                } else if (guess(mid) == -1) {
                    n = mid;
                } else {
                    return mid;
                }
            }
            return min;
        }
    }
}


class GuessGame {
    int guess(int num) {
        return num;//-1,0,1;
    }
}