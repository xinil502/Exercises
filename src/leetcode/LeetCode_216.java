package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LeetCode_216 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();

        Solution_216 sol = new Solution_216();
        List<List<Integer>> list = sol.combinationSum3(n, k);
        for (Iterator<List<Integer>> ite = list.iterator(); ite.hasNext(); ) {
            for (Iterator<Integer> ite1 = ite.next().iterator(); ite1.hasNext(); ) {
                System.out.print(ite1.next() + " ");
            }
            System.out.println();
        }
    }
}

class Solution_216 {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> item = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n, 1, k);
        return list;
    }

    void dfs(int sumNeed, int start, int size) {
        if (sumNeed == 0 && size == 0) {
            list.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i < 10 && i <= sumNeed; ++i) {
            item.add(i);
            dfs(sumNeed - i, i + 1, size - 1);
            item.remove(item.size() - 1);
        }
        return;
    }
}