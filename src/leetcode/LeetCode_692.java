package leetcode;

import java.util.*;

/**
 * 692. 前K个高频单词
 *
 * @Author: Xinil
 * @Date: 2021/5/20 22:10
 */
public class LeetCode_692 {
    class Solution {
        //排序多规则，就封装成一个对象
        class Status implements Comparable<Status> {
            int count;
            String word;

            Status(int weight, String word) {
                this.count = weight;
                this.word = word;
            }

            public int compareTo(Status status2) {
                return count != status2.count ? status2.count - count : word.compareTo(status2.word);
            }
        }

        public List<String> topKFrequent(String[] words, int k) {
            //使用Map统计出现次数
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            //使用优先队列排序
            PriorityQueue<Status> queue = new PriorityQueue<>();
            for (Map.Entry<String, Integer> item : map.entrySet()) { //Map取值
                queue.offer(new Status(item.getValue(), item.getKey()));
            }

            //取出前 K 个值
            List<String> list = new ArrayList<>();
            for (int i = 0; i < k; ++i) {
                list.add(queue.remove().word);
            }
            return list;
        }
    }

}
