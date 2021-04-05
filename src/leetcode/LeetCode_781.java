package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 781. 森林中的兔子
 *
 * @Author: Xinil
 * @Date: 2021/4/5 18:43
 */
public class LeetCode_781 {
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < answers.length; ++i) {
                map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
            }
            int sum = 0;
            for (Iterator<Integer> ite = map.keySet().iterator(); ite.hasNext(); ) {
                int key = ite.next();
                int value = map.get(key);
                if ((value % (key + 1)) == 0) {
                    sum += value;
                } else {
                    sum += (1 + value / (key + 1)) * (key + 1);
                }
            }
            return sum;
        }
    }
}
