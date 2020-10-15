package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LeetCode_1002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; ++i) {
            strs[i] = scanner.next();
        }

        Solution_1002 sol = new Solution_1002();
        System.out.println(Arrays.toString(sol.commonChars(strs).toArray()));
    }
}

class Solution_1002 {
    public List<String> commonChars(String[] A) {
        int[] minNum = new int[26];
        for (int i = 0; i < 26; ++i) {
            minNum[i] = Integer.MAX_VALUE;
        }
        for (String s : A) {
            int[] num = new int[26];
            for (char c : s.toCharArray()) {
                ++num[c - 97];
            }
            for (int i = 0; i < 26; ++i) {
                minNum[i] = Math.min(minNum[i], num[i]);
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            while (minNum[i]-- > 0) {
                list.add((char) ('a' + i) + "");
            }
        }
        return list;
    }
}