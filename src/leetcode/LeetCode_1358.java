package leetcode;

import java.util.Scanner;

public class LeetCode_1358 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        Solution_1358 sol = new Solution_1358();
        System.out.println(sol.numberOfSubstrings(str));
    }
}

class Solution_1358 {
    // 求出以第i个字符结尾的最小满足条件的子串头部，
    // 求出第i个字符结尾的符合要求的字符串个数
    public int numberOfSubstrings(String s) {
        int i, num = 0, a=-1, b=-1, c=-1;
        for(i = 0; i<s.length(); ++i){
            if(s.charAt(i) == 'a'){
                a = i;
            }else if(s.charAt(i) == 'b'){
                b = i;
            }else if(s.charAt(i) == 'c'){
                c = i;
            }
            if(Math.min(a, Math.min(b, c)) == -1){
                continue;
            }else{
                num += Math.min(a, Math.min(b, c))+1;
            }
        }
        return num;
    }
}