package leetcode;

import java.util.Scanner;

public class Utils {
    static int[] createArray() {   //创建并初始化一维数组
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
        }
        return nums;
    }

    static ListNode createList() {  //创建并初始化链表
        return ListNode.createList();
    }

    static int[][] createDoubleDimensionalArray() {  //创建并初始化二维数组
        Scanner scanner = new Scanner(System.in);
        int m, n;
        m = scanner.nextInt();
        n = scanner.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                nums[i][j] = scanner.nextInt();
            }
        }
        return nums;
    }
}
