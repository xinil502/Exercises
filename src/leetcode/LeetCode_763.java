package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 763. 划分字母区间
 */
public class LeetCode_763 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Solution_763 sol = new Solution_763();
        List<Integer> list = Solution_763.partitionLabels(s);
        for (Iterator<Integer> ite = list.iterator(); ite.hasNext(); ) {
            System.out.print(ite.next() + " ");
        }
    }
}

class Solution_763 {
    public static List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return new ArrayList<>();
        } else if (S.length() == 1) {
            return new ArrayList<>(1);
        }
        int[] nums = new int[S.length()];
        int[] appear = new int[26];
        for (int i = 0; i < 26; ++i) {
            appear[i] = -1;
        }
        for (int i = S.length() - 1; i != -1; --i) {
            int c = S.charAt(i) - 97;
            if (appear[c] == -1) {
                appear[c] = i;
            }
            nums[i] = appear[c];
        }
        int max = 0, l = -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            max = Math.max(max, nums[i]);
            if (max == i && max == appear[S.charAt(i) - 97]) {
                list.add(i - l);
                l = i;
            }
        }
        return list;
    }
}