package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * LeetCode_992.K个不同整数的子数组
 */
public class LeetCode_992 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        Solution_992 sol = new Solution_992();
        System.out.println(sol.subarraysWithKDistinct(nums, k));
    }
}


class Solution_992 { //滑动窗口
    public int subarraysWithKDistinct(int[] A, int K) {
        Windows_992<Integer> window = new Windows_992<>();
        int length = A.length, i = 0, sum = 0, j = 0;
        while (i < length) {
            int temp = window.add(A[i]);
            ++i;

            while (temp > K) {
                temp = window.remove(A[j]);
                ++j;
            }

            int k = j;
            while (temp == K) {
                ++sum;
                temp = window.remove(A[k]);
                ++k;
            }

            while (k > j) {
                --k;
                window.add(A[k]);
            }
        }
        return sum;
    }
}

class Windows_992<K> {
    Map<K, Integer> m;

    public Windows_992() {
        this.m = new HashMap<>();
    }

    int add(K num) {
        if (m.putIfAbsent(num, 1) != null) {
            m.put(num, m.get(num) + 1);
        }
        return m.size();
    }

    int remove(K num) {
        if (m.get(num) == null || m.get(num) == 1) {
            m.remove(num);
        } else {
            m.put(num, m.get(num) - 1);
        }
        return m.size();
    }
}