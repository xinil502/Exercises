package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LeetCode_1431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] candies = new int[sc.nextInt()];
        for (int i = 0; i < candies.length; ++i) {
            candies[i] = sc.nextInt();
        }
        int extraCandies = sc.nextInt();

        Solution_1431 sol = new Solution_1431();
        System.out.println(sol.kidsWithCandies(candies, extraCandies));
    }
}


class Solution_1431 {
    List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new LinkedList<>();
        int max = 0;
        for (int i : candies) {
            max = Math.max(max, i);
        }
        for (int i : candies) {
            list.add((i + extraCandies) >= max);
        }
        return list;
    }
}