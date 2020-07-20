package leetcode;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * LeetCode_735.行星碰撞。
 */
public class LeetCode_735 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] asteroids = new int[n];
        for (int i = 0; i < n; ++i) {
            asteroids[i] = sc.nextInt();
        }

        Solution_735 sol = new Solution_735();
        System.out.println(Arrays.toString(sol.asteroidCollision(asteroids)));
    }
}

class Solution_735 {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        int i;
        for (i = 0; i < asteroids.length; ++i) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                if (!stack.empty() && stack.peek() > 0) {
                    while (Math.abs(asteroids[i]) >= stack.peek()) {
                        if (asteroids[i] == -stack.pop()) {
                            break;
                        }
                        if (stack.empty() || stack.peek() < 0) {
                            stack.push(asteroids[i]);
                            break;
                        }
                    }
                } else {
                    stack.push(asteroids[i]);
                }
            }
        }
        i = 0;
        while (!stack.empty()) {
            asteroids[i] = stack.pop();
            ++i;
        }
        int[] num = new int[i];
        for (i = 0; i < num.length; ++i) {
            num[num.length - i - 1] = asteroids[i];
        }
        return num;
    }
}