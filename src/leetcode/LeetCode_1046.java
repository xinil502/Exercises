package leetcode;

import java.util.PriorityQueue;

/**
 * 1046.最后一块石头的重量
 */
public class LeetCode_1046 {
    public static void main(String[] args) {
        Solution_1 sol = new LeetCode_1046().new Solution_1();
        System.out.println(sol.lastStoneWeight(Utils.createArray()));
    }

    class Solution_1 {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int stone : stones) {
                pq.offer(stone);
            }

            while (pq.size() > 1) {
                int a = pq.poll();
                int b = pq.poll();
                if (a > b) {
                    pq.offer(a - b);
                }
            }
            return pq.isEmpty() ? 0 : pq.poll();
        }
    }
}
