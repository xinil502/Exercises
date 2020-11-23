package leetcode;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 */
public class LeetCode_452 {
    public static void main(String[] args) {
        int[][] array = Utils.createDoubleDimensionalArray();

        Solution_452 sol = new Solution_452();
        System.out.println(sol.findMinArrowShots(array));
    }
}

/**
 * 排序后从左往右，只加不出，保证左侧是最优的。
 */
class Solution_452 {
    public int findMinArrowShots(int[][] points) {
        //按照起始的位置排序
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? (a[1] > b[1] ? 1 : -1) : (a[0] > b[0] ? 1 : -1));
        int length = points.length;
        int sum = 0;
        for (int i = 0; i < length; ) {
            //使用已经加入的右端边界，和排好序的左端边界进行判断。
            int end = points[i][1];
            ++i;
            if (i < length) {
                while (points[i][0] <= end) {
                    end = Math.min(points[i][1], end);
                    ++i;
                    if (i == length) {
                        break;
                    }
                }
            }
            ++sum;
        }
        return sum;
    }
}