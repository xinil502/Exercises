package leetcode;

import java.util.Scanner;

public class LeetCode_191 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        Solution_191 sol = new Solution_191();
        System.out.println(sol.hammingWeight(n));
    }
}

class Solution_191 {
    public int hammingWeight(int n) {
        int num = 0;
        while (0 != n) {
            if (1 == (n & 1)) {
                ++num;
            }
            n >>>= 1;
        }
        return num;
    }
}