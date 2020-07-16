package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_m16_03 {
    public static void main(String[] args) {
        int[] start1, end1, start2, end2;
        start1 = new int[2];
        end1 = new int[2];
        start2 = new int[2];
        end2 = new int[2];

        Scanner sc = new Scanner(System.in);
        start1[0] = sc.nextInt();
        start1[1] = sc.nextInt();
        end1[0] = sc.nextInt();
        end1[1] = sc.nextInt();
        start2[0] = sc.nextInt();
        start2[1] = sc.nextInt();
        end2[0] = sc.nextInt();
        end2[1] = sc.nextInt();

        Solution_m16_03 sol = new Solution_m16_03();
        System.out.println(Arrays.toString(sol.intersection(start1, end1, start2, end2)));
    }
}


class Solution_m16_03 {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        if (start1 == null || end1 == null || start2 == null || end2 == null) {
            return new double[0];
        }
        double k1, b1, k2, b2;
        if ((end1[0] - start1[0]) == 0) {
            k1 = -123;
            b1 = -123 + start1[0];
        } else {
            k1 = 1.0 * (end1[1] - start1[1]) / (end1[0] - start1[0]);
            b1 = start1[1] - k1 * start1[0];
        }
        if ((end2[0] - start2[0]) == 0) {
            k2 = -123;
            b2 = -123 + start2[0];
        } else {
            k2 = 1.0 * (end2[1] - start2[1]) / (end2[0] - start2[0]);
            b2 = start2[1] - k2 * start2[0];
        }

        double[] d = new double[2];
        if (k1 == k2 && b1 == b2) { //重合
            if (Math.max(start1[0], end1[0]) < Math.min(end2[0], start2[0]) || Math.min(end1[0], start1[0]) > Math.max(start2[0], end2[0]) || Math.max(start1[1], end1[1]) < Math.min(end2[1], start2[1]) || Math.min(end1[1], start1[1]) > Math.max(start2[1], end2[1])) {
                return new double[0];
            }
            d[0] = Math.max(Math.min(start1[0], end1[0]), Math.min(start2[0], end2[0]));
            d[1] = k1 * d[0] + b1;
            if (k1 == -123) {
                d[1] = Math.max(Math.min(start1[1], end1[1]), Math.min(start2[1], end2[1]));
            }
            return d;
        } else if (k1 == k2 && b1 != b2) {
            return new double[0];
        } else {
            d[0] = (b2 - b1) / (k1 - k2);
            d[1] = k1 * d[0] + b1;
            if (k1 == -123 && k2 == -123) {
                d[0] = start1[0];
                d[1] = start2[0];
                return d;
            } else if (k1 == -123) {
                d[0] = start1[0];
                d[1] = d[0] * k2 + b2;
            } else if (k2 == -123) {
                d[0] = start2[0];
                d[1] = d[0] * k1 + b1;
            }


            if (((d[0] >= start1[0] && d[0] <= end1[0]) || (d[0] <= start1[0] && d[0] >= end1[0])) && ((d[0] >= start2[0] && d[0] <= end2[0]) || (d[0] <= start2[0] && d[0] >= end2[0])) && ((d[1] >= start1[1] && d[1] <= end1[1]) || (d[1] <= start1[1] && d[1] >= end1[1])) && ((d[1] >= start2[1] && d[1] <= end2[1]) || (d[1] <= start2[1] && d[1] >= end2[1]))) {
                return d;
            } else {
                return new double[0];
            }
        }

    }
}