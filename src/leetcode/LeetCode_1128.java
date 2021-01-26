package leetcode;

/**
 * 1128. 等价多米诺骨牌对的数量
 */
public class LeetCode_1128 {
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            int[][] nums = new int[10][10];
            for (int i = 0; i < dominoes.length; ++i) {
                ++nums[dominoes[i][0]][dominoes[i][1]];
            }
            int sum = 0;
            for (int i = 1; i < 10; ++i) {
                sum += (nums[i][i] * (nums[i][i] - 1) / 2);
                for (int j = i + 1; j < 10; ++j) {
                    int t = nums[i][j] + nums[j][i];
                    sum += t * (t - 1) / 2;
                }
            }
            return sum;
        }
    }
}
