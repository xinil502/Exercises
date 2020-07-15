package leetcode;

import java.util.Scanner;

public class LeetCode_96 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Solution_96_2 sol = new Solution_96_2();
        System.out.println(sol.numTrees(sc.nextInt()));
    }
}


class Solution_96_1 { //递归 5%    7%
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int sum = 0;

        //对于根的每一种情况，他的结果等于左子树的排列方法*右子树的排列方法
        for (int i = 1; i <= n; ++i) {
            sum += numTrees(i - 1) * numTrees(n - i);
        }

        return sum;
    }
}


class Solution_96_2 {  //递归优化
    public int numTrees(int n) {
        int[] num = new int[n + 1];
        num[0] = num[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }
}