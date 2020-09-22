package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LeetCode_89 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Solution_89 sol = new Solution_89();
        List<Integer> list = sol.grayCode(n);
        for (Iterator<Integer> ite = list.iterator(); ite.hasNext(); ) {
            System.out.print(ite.next() + " ");
        }
    }
}

class Solution_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        if (n == 0) return temp;

        temp.add(1);
        if (n == 1) return temp;

        int bit = 1;
        int size = 1 << n;
        while (temp.size() != size) {
            for (int i = temp.size() - 1; i >= 0; i--) {
                temp.add(temp.get(i) + (1 << bit));
            }
            bit++;
        }
        return temp;
    }
}