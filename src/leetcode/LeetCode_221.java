package leetcode;

import java.util.Scanner;

public class LeetCode_221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] matrix = new char[n][n];

        for(int i = 0; i<m; ++i) {
            for (int j = 0; j < n; ++j){
                matrix[i][j] = sc.next().charAt(0);
            }
        }
        Solution_221 sol = new Solution_221();
        System.out.println(sol.maximalSquare(matrix));
    }
}
class Solution_221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length , n;
        if(m == 0){  //数组为空直接返回0。
            return 0;
        }else{
            n = matrix[0].length;
        }
        int max = 0;
        int[][] dp =new int[m][n];   //以该位置为右下角的最大正方形的边长。
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                if(matrix[i][j] == '0'){  //字符为0，没有正方形
                    dp[i][j] = 0;
                }else{
                    if(i==0 || j==0){  //字符为1 且位于边，正方形最大为1.
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1;  //不位于边上，能扩展的最大正方形为上，左，左上三个方向的最小正方形边长+1.
                    }
                }
            }
        }
        for(int i = 0; i<m; ++i) {
            for (int j = 0; j < n; ++j){
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        return max*max;
    }

    int min(int num1, int num2, int num3){
        if(num1<num2 &&num1<num3){
            return num1;
        }else{
            return num2 < num3 ? num2 : num3;
        }
    }
}