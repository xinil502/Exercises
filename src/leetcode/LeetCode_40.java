package leetcode;

import java.util.*;

public class LeetCode_40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        Solution_40 sol = new Solution_40();
        List<List<Integer>> list = sol.combinationSum2(nums, sc.nextInt());
        for (Iterator<List<Integer>> it1 = list.iterator(); it1.hasNext(); ) {
            for (Iterator<Integer> it2 = it1.next().iterator(); it2.hasNext(); ) {
                System.out.print(it2.next());
            }
            System.out.println();
        }
    }
}

class Solution_40 {
    List<Integer> item = new ArrayList<>();
    int sum = 0, target = 0;
    List<List<Integer>> list = new ArrayList<>();
    int[] nums = null;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.nums = candidates;
        this.target = target;
        Arrays.sort(nums);
        dfs(0);
        return list;
    }

    void dfs(int start) {
        if (sum == target) {
            int i = 0;
            while (i < list.size()) {
                if (list.get(i).equals(item)) {
                    break;
                }
                ++i;
            }
            if (i == list.size()) {
                list.add(new ArrayList<>(item));
            }
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < nums.length && sum + nums[i] <= target; ++i) {
            sum += nums[i];
            item.add(nums[i]);
            dfs(i + 1);
            sum -= nums[i];
            item.remove(item.size() - 1);
        }
    }
}