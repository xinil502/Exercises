package leetcode;

import java.util.*;

/**
 * 514. 自由之路
 */
public class LeetCode_514 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ring = scanner.next();
        String key = scanner.next();

        Solution_514 sol = new Solution_514();
        System.out.println(sol.findRotateSteps(ring, key));
    }
}

class Solution_514 {
    public int findRotateSteps(String ring, String key) {
        if (ring == null || ring.length() == 0 || key == null || key.length() == 0) {
            return 0;
        }
        List<Map<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            Map<Integer, Integer> mapLength = new HashMap<>();
            for (int j = 0; j < ring.length(); ++j) {
                if (c == ring.charAt(j)) {
                    mapLength.put(j, Integer.MAX_VALUE);
                }
            }
            list.add(mapLength);
        }
        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            Map<Integer, Integer> mapLength = list.get(i), mapProLength;
            if (i == 0) {
                mapProLength = new HashMap<>();
                mapProLength.put(0, 0);
            } else mapProLength = list.get(i - 1);

            for (Iterator<Integer> ite = mapLength.keySet().iterator(); ite.hasNext(); ) {
                int index = ite.next();
                int length = mapLength.get(index);
                for (Iterator<Integer> ite2 = mapProLength.keySet().iterator(); ite2.hasNext(); ) {
                    int proIndex = ite2.next();
                    int proLength = mapProLength.get(proIndex);
                    length = Math.min(length, proLength + Math.min(Math.min(Math.abs(index - proIndex), Math.abs(index - ring.length() - proIndex)), Math.abs(index + ring.length() - proIndex)) + 1);
                }
                mapLength.put(index, length);
            }
            list.remove(i);
            list.add(i, mapLength);
        }
        int minLength = Integer.MAX_VALUE;
        Map<Integer, Integer> m = list.get(list.size() - 1);
        for (Integer index : m.keySet()) {
            minLength = Math.min(minLength, m.get(index));
        }
        return minLength;
    }
}