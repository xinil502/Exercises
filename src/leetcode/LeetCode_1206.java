package leetcode;

import java.util.*;

/**
 * LeetCode_1036.跳跃游戏Ⅲ
 */
public class LeetCode_1206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution_1306 sol = new Solution_1306();
        System.out.println(sol.canReach(nums, sc.nextInt()));
    }
}

class Solution_1306 {
    public boolean canReach(int[] arr, int start) {
        if (arr.length == 0 || start < 0) {
            return false;
        }
        Set<Integer> s = new HashSet<>();
        List<Integer> quene = new ArrayList<>();
        quene.add(start);
        for (int i = 0; i < quene.size(); ++i) {
            int temp = quene.get(i);
            if (arr[temp] == 0) {
                return true;
            }
            if (-arr[temp] < arr.length && temp - arr[temp] > -1) {
                if (s.add(temp - arr[temp])) {
                    quene.add(temp - arr[temp]);
                }
            }
            if (temp + arr[temp] < arr.length && temp + arr[temp] > -1) {
                if (s.add(temp + arr[temp])) {
                    quene.add(temp + arr[temp]);
                }
            }
        }
        return false;
    }
}
