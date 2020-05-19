package leetcode;

import java.util.Scanner;

public class LeetCode_680 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        Solution_680 sol = new Solution_680();
        System.out.println(sol.validPalindrome(s));
    }
}

class Solution_680 {
    public boolean validPalindrome(String s) {
        if(s == ""){
            return true;
        }
        int i=0, j=s.length()-1;
        while(i<j && s.charAt(i) == s.charAt(j)){
            ++i;
            --j;
        }
        if(j-i < 1){
            return true;
        }
        for(int low = i+1,high = j;s.charAt(low) == s.charAt(high);++low,--high) {
            if(high-low < 1){
                return true;
            }
        }
        for(int low = i,high = j-1;s.charAt(low) == s.charAt(high);++low,--high) {
            if(high-low < 1){
                return true;
            }
        }
        return false;
    }
}