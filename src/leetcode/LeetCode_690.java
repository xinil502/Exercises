package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Xinil
 * @Date: 2021/5/1 12:36
 */
public class LeetCode_690 {
    class Employee {
        int id;
        int importance;
        List<Integer> subordinates;
    }

    /**
     * 深搜
     */
    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();

        public int getImportance(List<Employee> employees, int id) {
            for (Employee e : employees) {
                e.subordinates.add(0, e.importance);
                map.put(e.id, e.subordinates);
            }
            return getImportanceById(id);
        }

        int getImportanceById(int id) {
            List<Integer> list = map.get(id);
            int sum = list.get(0);
            for (int i = 1; i < list.size(); ++i) {
                sum += getImportanceById(list.get(i));
            }
            return sum;
        }
    }
}
