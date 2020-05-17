package leetcode;

import java.util.Scanner;

public class LeetCode_1323 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Solution_1323 sol = new Solution_1323();
        System.out.println(sol.maximum69Number(num));
    }
}

class Solution_1323 {
    public int maximum69Number (int num) {
        String strnum1 = ""+num;
        char[] array =strnum1.toCharArray();
        for(int i=0; i<array.length; ++i){
            if(array[i] == '6'){
                array[i] = '9';
                break;
            }
        }
        String strnum2 = new String(array);
        int numreturn = Integer.parseInt(strnum2);
        return numreturn;
    }
}