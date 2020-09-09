package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LeetCode_39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        Solution_39 sol = new Solution_39();
        List<List<Integer>> list = sol.combinationSum(nums, sc.nextInt());
        for (Iterator<List<Integer>> it1 = list.iterator(); it1.hasNext(); ) {
            for (Iterator<Integer> it2 = it1.next().iterator(); it2.hasNext(); ) {
                System.out.print(it2.next());
            }
            System.out.println();
        }
    }
}

class Solution_39 {
    List<Integer> item = new ArrayList<>();
    int sum = 0, target = 0;
    List<List<Integer>> list = new ArrayList<>();
    int[] nums = null;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.nums = candidates;
        this.target = target;
        for (int n = nums.length - 1; 0 < n; --n) {
            for (int i = 0; i < n; ++i) {
                if (nums[i] > nums[n]) {
                    int temp = nums[i];
                    nums[i] = nums[n];
                    nums[n] = temp;
                }
            }
        }
        dfs(0);
        return list;
    }

    void dfs(int start) {
        if (sum == target) {
            list.add(new ArrayList<>(item));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            if (sum + nums[i] > target) {
                break;
            }
            sum += nums[i];
            item.add(nums[i]);
            dfs(i);
            sum -= nums[i];
            item.remove(item.size() - 1);
        }
    }
}