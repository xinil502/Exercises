package leetcode;

import java.util.Scanner;

public class LeetCode_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];
        for (int i = 0; i < m; ++i) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            nums2[i] = sc.nextInt();
        }
        sc.close();

        Solution_4 sol = new Solution_4();
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}

class Solution_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = 0, b = 0, i, j;
        boolean x = (nums1.length + nums2.length) % 2 == 1;  //判断求两数平均，，还是直接得到
        int k = (nums1.length + nums2.length) / 2;
        if (x) {
            x = true;
            ++k;
        }
        while (true) {  //二分法去除前一半的数组
            //k为1，下一个就是所求数，，或者一个数组已经遍历完时跳出
            if (k == 1 || a >= nums1.length || b >= nums2.length) {
                break;
            }
            if (a + k / 2 >= nums1.length) { //判断num1是否到达末端。
                i = nums1.length - 1;
            } else {
                i = a + k / 2 - 1;
            }
            if (b + k / 2 >= nums2.length) { //判断num2是否到达末端
                j = nums2.length - 1;
            } else {
                j = b + k / 2 - 1;
            }
            if (nums1[i] > nums2[j]) { //判断移出num1数组还是num2数组
                k = k - (j - b + 1);
                b = j + 1;
            } else {
                k = k - (i - a + 1);
                a = i + 1;
            }
        }
        if (a >= nums1.length) {  //num1数组已经遍历完，根据x在num2中找中位数。
            if (x) {
                return nums2[b + k - 1];
            } else {
                return ((double) nums2[b + k - 1] + (double) nums2[b + k]) / 2;
            }
        } else if (b >= nums2.length) { //num2数组已经遍历完，根据x在num1中找中位数。
            if (x) {
                return nums1[a + k - 1];
            } else {
                return ((double) nums1[a + k - 1] + (double) nums1[a + k]) / 2;
            }
        } else { //两数组均未遍历完，，根据下一个数找中位数
            if (x) { //直接找下一个数
                return Math.min(nums1[a], nums2[b]);
            } else { //找个数组下一个数，，求平均
                double min = (double) (nums1[a] + nums2[b]) / 2;
                if (a + 1 < nums1.length && min > (double) (Math.min(nums1[a], nums2[b]) + nums1[a + 1]) / 2) {
                    min = (double) (Math.min(nums1[a], nums2[b]) + nums1[a + 1]) / 2;
                }
                if (b + 1 < nums2.length && min > (double) (Math.min(nums1[a], nums2[b]) + nums2[b + 1]) / 2) {
                    min = (double) (Math.min(nums1[a], nums2[b]) + nums2[b + 1]) / 2;
                }
                return min;
            }
        }
    }
}