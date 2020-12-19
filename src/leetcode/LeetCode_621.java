package leetcode;

/**
 * 621. 任务调度器
 */
public class LeetCode_621 {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            // 对于最多数量种类任务 其所需的时间一定是其数量(m - 1)*(n + 1)然后剩下得往待命中填充就是了
            // 但是如果出现相同次数种类任务，那么待命区域将会不足够 还需要添加一个时间段
            // 如果最多种类和间隙不能填充所有的任务 那么时间就是任务总数 因为这个间隙是最小间隙（还可以再增加任务）
            // AAABBB  ->           A,待命...,A,待命...,多次重复添加的时间段(A,B) (3-1)(2+1)+2
            if (tasks == null || tasks.length < 1) {
                return 0;
            }
            int[] nums = new int[26];
            for (int i = 0; i < tasks.length; i++) {
                nums[tasks[i] - 'A']++;
            }
            // 获得最大值
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                }
            }
            int ans = 0;
            //获得要多算的时间段
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == max) {
                    ans += 1;
                }
            }
            ans += (max - 1) * (n + 1);
            return Math.max(ans, tasks.length);
        }
    }
}
