package leetcode;

/**
 * 810. 黑板异或游戏
 *
 * @Author: Xinil
 * @Date: 2021/5/22 22:18
 */
public class LeetCode_810 {
    class Solution {
        public boolean xorGame(int[] nums) {
            if (nums.length % 2 == 0) {
                return true;
            }
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            return xor == 0;
        }
    }
}
