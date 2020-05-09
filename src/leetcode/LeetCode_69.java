package leetcode;

import java.util.Scanner;

public class LeetCode_69 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        Solution_69_1 sol = new Solution_69_1();
        System.out.println(sol.mySqrt(x));
    }
}

class Solution_69_1 {
    public int mySqrt(int x) {
        double l=0, r=x, mid;
        while(Math.abs(r-l)>0.0000001){
            mid = (l+r)/2;
            if(mid*mid <= x){
                l = mid;
            }else{
                r = mid;
            }
        }
        return (int)r;
    }
}
class Solution_69_2 {
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }
}