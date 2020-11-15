package leetcode;

import java.util.Scanner;

public class Utils {
    static int[] createArray() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
        }
        return nums;
    }

    static ListNode createList() {
        return ListNode.createList();
    }
}
