package leetcode;

import java.util.Scanner;

public class Leetcodem46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        Solutionleecodem46 solution = new Solutionleecodem46();
        System.out.println(solution.translateNum(num));
    }
}
class Solutionleecodem46 {
    public int translateNum(int num) {
        int sum=0, lang = (num+"").length(); // 求出数字长度
        int numm = (int) Math.pow(10, lang-2);
        if(num<10) {
            return 1;
        }
        if(num/numm<26){    //如果前两位在10-25之前，dp除去前两位的数字
            sum+=translateNum(num - num/numm*numm);
        }
        sum+=translateNum(num - num/numm/10*numm*10);//除去最前一位的数字
        return sum;
    }
}