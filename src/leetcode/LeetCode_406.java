package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. 根据身高重建队列
 */
public class LeetCode_406 {
    public static void main(String[] args) {
        int[][] nums = Utils.createDoubleDimensionalArray();

        Solution_406 sol = new Solution_406();
        int[][] ints = sol.reconstructQueue(nums);
        for (int[] k : ints) {
            System.out.println(Arrays.toString(k));
        }
    }
}

class Solution_406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length < 2) {
            return people;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        for (int i = 0; i < people.length; ++i) {
            list.add(people[i][1], people[i]);
        }
        for (int i = 0; i < people.length; ++i) {
            people[i] = list.get(i);
        }
        return people;
    }
}