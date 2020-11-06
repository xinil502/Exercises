package leetcode;

import java.util.*;

/**
 * 1356.根据数字二进制下一的数目排序
 */
public class LeetCode_1356 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
        }

        Solution_1356_1 sol = new Solution_1356_1();
        System.out.println(Arrays.toString(sol.sortByBits(nums)));
    }
}

class Solution_1356_1 { //位捅数组存储计算出的bit，重写compare
    public int[] sortByBits(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return arr;
        }
        int[] bit = new int[10001]; //位捅数组
        Integer[] intt = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            intt[i] = arr[i];
            int x = arr[i], j = 0;
            while (x != 0) {
                if (1 == (x & 1)) {
                    ++j;
                }
                x >>= 1;
            }
            bit[arr[i]] = j;
        }
        List<Integer> list = Arrays.asList(intt);
        list.sort((x, y) -> bit[x] != bit[y] ? bit[x] - bit[y] : x - y);

        Object[] obj = list.toArray();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (Integer) obj[i];
        }
        return arr;
    }
}

class Solution_1356_2 { //使用bitCount，权重*100000
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 100000;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 100000;
        }
        return arr;
    }
}