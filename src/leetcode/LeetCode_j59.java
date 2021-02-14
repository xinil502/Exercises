package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 *
 * @Author: Xinil
 * @Date: 2021/2/14 9:42
 */
public class LeetCode_j59 {
    //使用queue队列和 Deque双端队列
    class MaxQueue {

        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> d = new LinkedList<>();

        public MaxQueue() {
        }

        public int max_value() {
            if (d.isEmpty()) {
                return -1;
            }
            return d.peekFirst();
        }

        public void push_back(int value) {
            while (!d.isEmpty() && d.peekLast() < value) {
                d.pollLast();
            }
            d.offerLast(value);
            q.offer(value);
        }


        public int pop_front() {
            if (q.isEmpty()) {
                return -1;
            }
            int ans = q.poll();
            if (ans == d.peekFirst()) {
                d.pollFirst();
            }
            return ans;
        }
    }

    //使用数组，强行遍历
    class MaxQueue_2 {
        int[] q = new int[20000];
        int start = 0, end = 0;

        public MaxQueue_2() {

        }

        public int max_value() {
            int ans = -1;
            for (int i = start; i != end; i++) {
                ans = ans < q[i] ? q[i] : ans;
            }
            return ans;
        }

        public void push_back(int value) {
            q[end++] = value;
        }

        public int pop_front() {
            if (start == end) {
                return -1;
            } else {
                return q[start++];
            }
        }
    }
}
