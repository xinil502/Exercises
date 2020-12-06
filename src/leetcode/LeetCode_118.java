package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118.杨辉三角——简单
 */

public class LeetCode_118 {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> list = new ArrayList<>();
            if (numRows == 0) {
                return list;
            }
            List<Integer> c = new ArrayList<>();
            c.add(1);
            list.add(c);
            for (int i = 1; i < numRows; ++i) {
                List<Integer> a, b;
                a = list.get(i - 1);
                b = new ArrayList<>();
                b.add(1);
                for (int j = 1; j < i; ++j) {
                    b.add(a.get(j - 1) + a.get(j));
                }
                b.add(1);
                list.add(b);
            }
            return list;
        }
    }
}
