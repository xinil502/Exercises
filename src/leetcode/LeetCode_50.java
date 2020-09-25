package leetcode;

import java.util.Scanner;

public class LeetCode_50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();

        Solution_50_1 sol = new Solution_50_1();
        System.out.println(sol.myPow(x, n));
    }
}

class Solution_50_1 {
    public double myPow(double x, int n) {//将n转换为二进制求出下x^10 = x^(2^1+2^3) = x^2 * x^8
        long nn = n;  //避免负数求绝对值时越界的情况
        double num = 1;  //累乘结果
        double xn = x;   //计算 X^(2^n)
        if(nn < 0){
            nn = -nn;
            xn = 1 / x;
        }
        while(nn > 0){
            if (nn % 2 == 1) { //该位有值，将Xn乘进去。
                num *= xn;
            }
            xn *= xn;  //右移计算下一个X^(2^n)
            nn /= 2;
        }
        return num;
    }
}

class Solution_50_2 {  //递归总是超时
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1/x;
        } else if (n % 2 == 0) {
            return myPow(x, n/2) * myPow(x, n/2);
        } else if (n > 0) {
            return myPow(x, n / 2) * myPow(x, n / 2) * x;
        } else {
            return myPow(x, n / 2) * myPow(x, n / 2) / x;
        }
    }
}