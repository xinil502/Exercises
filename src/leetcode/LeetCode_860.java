package leetcode;

/**
 * 860.柠檬水找零
 */
public class LeetCode_860 {
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int a, b;
            a = b = 0;
            for (int i : bills) {
                switch (i) {
                    case 5:
                        ++a;
                        break;
                    case 10:
                        ++b;
                        --a;
                        break;
                    case 20:
                        if (b > 0) {
                            --b;
                            --a;
                        } else {
                            a -= 3;
                        }
                }
                if (a < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}