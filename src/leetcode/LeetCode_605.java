package leetcode;

/**
 * 605.种花问题
 */
public class LeetCode_605 {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int i = 0, len = flowerbed.length;
            while (i < len && n > 0) {
                if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    --n;
                }
                ++i;
            }
            return n == 0;
        }
    }
}
