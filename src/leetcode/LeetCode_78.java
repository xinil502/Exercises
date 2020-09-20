package leetcode;

import java.util.*;

/**
 * LeetCode_78.子集
 */
public class LeetCode_78 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }

        Solution_78 sol = new Solution_78();
        for (Iterator<List<Integer>> ite1 = sol.subsets(nums).iterator(); ite1.hasNext(); ) {
            for (Iterator<Integer> ite2 = ite1.next().iterator(); ite2.hasNext(); ) {
                System.out.print(ite2.next() + " ");
            }
            System.out.println();
        }
    }
}

class Solution_78 {
    private List<Integer> temp = new ArrayList<>();
    private List<List<Integer>> list = new ArrayList<>();
    private int size = 0;
    private int[] num = null;

    public List<List<Integer>> subsets(int[] nums) {
        size = nums.length;
        num = nums;
        dfs(0);
        return list;
    }

    private void dfs(int index) {
        if (index == size) {
            list.add(new LinkedList<>(temp));
            return;
        }
        dfs(index + 1);
        temp.add(num[index]);
        dfs(index + 1);
        temp.remove(temp.size() - 1);
    }
}