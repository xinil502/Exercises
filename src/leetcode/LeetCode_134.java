package leetcode;

/**
 * 134. 加油站
 */
public class LeetCode_134 {
    public static void main(String[] args) {
        int[] gas = Utils.createArray();
        int[] cost = Utils.createArray();

        Solution_134 sol = new Solution_134();
        System.out.println(sol.canCompleteCircuit(gas, cost));
    }
}

/**
 * 访问一遍，时间复杂度O(n)，
 * 到无法加油的加油站时停止，从下一个加油站作为起点。
 */
class Solution_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        for (int i = 0; i < length; ++i)
            gas[i] = gas[i] - cost[i];
        int i;
        for (i = 0; i < length; ) {
            int sum = 0;
            int count = 0;
            while (count < length) {
                sum += gas[(i + count) % length];
                if (sum < 0) {
                    break;
                } else {
                    ++count;
                }
            }
            if (count == length) {
                return i;
            }
            i += count + 1;
        }
        return -1;
    }
}