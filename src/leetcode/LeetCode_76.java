package leetcode;

import java.util.*;

public class LeetCode_76 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        sc.close();

        Solution_76 sol = new Solution_76();
        System.out.println(sol.minWindow(s, t));
    }
}

class Solution_76 {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        String min = s;
        int i, j, judge = 0;
        Map<Character, Integer> numWindow = new HashMap<>(); //初始化统计哈希表
        Map<Character, Integer> numT = new HashMap<>();//初始化参照哈希表
        for (i = 0; i < t.length(); ++i) {
            if (numT.get(t.charAt(i)) == null) {
                numT.put(t.charAt(i), 1);
            } else {
                numT.put(t.charAt(i), numT.get(t.charAt(i)) + 1);
            }
        }
        Set<Character> set = numT.keySet();

        for (i = 0, j = 0; j < s.length(); ++j) {//右端右移
            // 加入右端新字符
            if (numWindow.get(s.charAt(j)) == null) {
                numWindow.put(s.charAt(j), 1);
            } else {
                numWindow.put(s.charAt(j), numWindow.get(s.charAt(j)) + 1);
            }

            //判断是否满足覆盖
            int fuGai = 1;
            for (Iterator<Character> iter = set.iterator(); iter.hasNext(); ) {
                char temp = iter.next();
                if (numWindow.get(temp) == null || numT.get(temp) > numWindow.get(temp)) { //不满足，右端继续右移
                    fuGai = 0;
                    break;
                }
            }
            if (fuGai == 0) {
                continue;
            }

            //满足，左端左移至最小子串
            char ch = s.charAt(i);
            while (numT.get(ch) == null || numT.get(ch) <= numWindow.get(ch)) {
                numWindow.put(ch, numWindow.get(ch) - 1);
                ++i;
                if (numT.get(ch) != null && numT.get(ch) > numWindow.get(ch)) {
                    break;
                }
                ch = s.charAt(i);
            }

            String kk = s.substring(i - 1, j + 1);
            if (kk.length() <= min.length()) {
                min = kk; //已经覆盖，，赋值
                judge = 1;
            }

        }
        if (judge == 1) { //覆盖过
            return min;
        }//未覆盖过
        return "";
    }
}