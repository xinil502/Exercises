package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 *
 * @Author: Xinil
 * @Date: 2021/2/12 19:45
 */
public class LeetCode_119 {
    //滚动数组，一行行计算
    class Solution_1 {
        public List<Integer> getRow(int rowIndex) {
            ++rowIndex;
            int[] nums = new int[rowIndex];
            nums[0] = 1;
            for (int i = 0; i < rowIndex; ++i) {
                for (int j = i - 1; j > 0; --j) {
                    nums[j] = nums[j] + nums[j - 1];
                }
                nums[i] = 1;
            }
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            return list;
        }
    }

    //O(n)时间复杂度， 第i行第j列的数（索引值从0开始），为排列组合数：Cji
    //本题求杨辉三角的一行，所以可以通过一行的前一个数，计算得到下一个。
    class Solution_2 {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int i = 1; i <= rowIndex; ++i) {
                row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
            }
            return row;
        }
    }
}
