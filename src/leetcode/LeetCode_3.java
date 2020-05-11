package leetcode;

import java.util.Scanner;

public class LeetCode_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        Solution_3 sol = new Solution_3();
        System.out.println(s);

    }
}

class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] a = new int[s.length()];  //去存储以第i个字符结尾的最长无重复子串。
        a[0] = 1;
        char[] ss = s.toCharArray();

        for(int i=1; i<s.length(); ++i){ //遍历一遍字符串
            a[i] = a[i-1]+1;  //先将a[i]赋值为前一项+1，
            for(int j=i - a[i-1]; j<i; ++j){ //去寻找前面是否有重复字符。
                if(ss[i] == ss[j]){
                    a[i] = i-j;   //有重复字符，更新数组值,(不可能有两个该字符，所以直接跳出)。
                    break;
                }
            }
        }

        int max = 0;
        for(int i=0; i<s.length(); ++i){
            if(a[i] > max){
                max = a[i];
            }
        }
        return max;
    }
}