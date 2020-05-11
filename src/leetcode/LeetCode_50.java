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
    public double myPow(double x, int n) {//将n转换为二进制求出下x^10 = x^(2^0+2^3) = x * x^9
        long nn = n;
        double num = 1;
        double xn = x;
        if(nn < 0){
            nn = -nn;
            xn = 1 / x;
        }
        while(nn > 0){
            if(nn%2 == 1){
                num *= xn;
            }
            xn *= xn;  //右移计算下一位
            nn /= 2;
        }
        return num;
    }
}

class Solution_50_2 {  //递归总是超时
    public double myPow(double x, int n) {
        if(n == 1){
            return x;
        }
        if(n == -1){
            return 1/x;
        }
        if(n%2 == 0){
            return myPow(x, n/2) * myPow(x, n/2);
        }else {
            if (n > 0) {
                return myPow(x, n / 2) * myPow(x, n / 2) * x;
            }else{
                return myPow(x, n / 2) * myPow(x, n / 2) / x;
            }
        }
    }
}