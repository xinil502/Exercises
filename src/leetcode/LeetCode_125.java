package leetcode;

import java.util.Scanner;

public class LeetCode_125 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        Solution_125 sol = new Solution_125();
        System.out.println(sol.isPalindrome(str));
    }
}

class Solution_125 {
    public boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        s = s.toUpperCase();
        int i=0, j=s.length()-1;
        while(true){
            while(s.charAt(i)>90 || s.charAt(i)<48 || s.charAt(i)>57&&s.charAt(i)<65){
                if(i == s.length()-1){
                    break;
                }
                ++i;
            }
            while(s.charAt(j)>90 || s.charAt(j)<48 || s.charAt(j)>57&&s.charAt(j)<65){
                if(j == 0){
                    break;
                }
                --j;
            }
            if(i>=j){
                break;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}
