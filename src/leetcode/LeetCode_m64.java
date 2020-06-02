package leetcode;

import java.util.Scanner;

public class LeetCode_m64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Solution_m64 sol = new Solution_m64();
        System.out.println(sol.sumNums(n));
    }
}

class Solution_m64 { //用短路运算代替if判断语句，，递归求解。
    public int sumNums(int n) {
        boolean flag = n > 1 && (n += this.sumNums(n - 1)) == 0;
        return n;
    }
}