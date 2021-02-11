package leetcode;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第 K 大元素
 *
 * @Author: Xinil
 * @Date: 2021/2/11 12:45
 */
public class LeetCode_703 {
    class KthLargest {
        private PriorityQueue<Integer> pq;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<Integer>();
            for (int x : nums) {
                add(x);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }
}
