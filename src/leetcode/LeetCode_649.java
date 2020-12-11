package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 649.Dota2 参议院
 */
public class LeetCode_649 {
    class Solution_1 {
        public String predictPartyVictory(String senate) {
            int a, b, n = senate.length();
            a = b = 0;
            char[] cc = senate.toCharArray();
            boolean[] bb = new boolean[n];
            for (char c : cc) {
                if (c == 'R') {
                    ++a;
                } else {
                    ++b;
                }
            }
            if (a == 0) {
                return "Dire";
            } else if (b == 0) {
                return "Radiant";
            }
            int i = 0;
            while (true) {
                i %= n;
                if (!bb[i]) { //有权
                    if (cc[i] == 'R') {
                        --b;
                        if (b == 0) {
                            return "Radiant";
                        }
                    } else {
                        --a;
                        if (a == 0) {
                            return "Dire";
                        }
                    }
                    int j = i + 1;
                    while (true) {
                        j %= n;
                        if (cc[j] != cc[i] && !bb[j]) {
                            bb[j] = true;
                            break;
                        }
                        ++j;
                    }
                }
                ++i;
            }
        }
    }


    class Solution_2 {  //循环队列   36%
        public String predictPartyVictory(String senate) {
            Queue<Integer> R = new LinkedList<>();
            Queue<Integer> D = new LinkedList<>();

            int length = senate.length();
            char[] chars = senate.toCharArray();
            for (int i = 0; i < length; ++i) {
                if (senate.charAt(i) == 'R') {
                    R.offer(i);
                } else {
                    D.offer(i);
                }
            }
            while (!(R.isEmpty() || D.isEmpty())) {
                if (R.element() < D.element()) {
                    R.offer(R.remove() + length);
                    D.remove();
                } else {
                    D.offer(D.remove() + length);
                    R.remove();
                }
            }
            return R.isEmpty() ? "Dire" : "Radiant";
        }
    }

    /**
     * Queue 接口使用的是 LinkedList 实例化，
     * 而 LinkedList 在内存中是「非连续」的，不容易触发缓存命中
     * 所以使用 Queue 会更加耗时。
     * <p>
     * 这里使用数组，遍历时统计预 ban 权的个数，一遍投票，一遍遍历。
     */
    class Solution_3 {
        public String predictPartyVictory(String senate) {
            int Rnumber = 0;//R阵营总人数
            int Dnumber = 0;//D阵营总人数
            int curBanR = 0;//当前被ban
            int curBanD = 0;//当前被ban
            int totalBanR = 0;//被ban总数
            int totalBanD = 0;//被ban总数
            char[] chars = senate.toCharArray();
            boolean flag = true;  //第一次遍历时统计阵营人数
            while (true) {
                for (int i = 0; i < chars.length; i++) {
                    char cur = chars[i];
                    if (cur == 'R') {  //未在之前的轮中被ban
                        if (flag)  //第一次遍历时统计阵营总人数
                            Rnumber++;
                        if (curBanR == 0) { //可以预行使ban权
                            curBanD++;
                            totalBanD++;
                            if (totalBanD == Dnumber && !flag) return "Radiant";
                        } else {     //被行使ban权
                            curBanR--;
                            chars[i] = 'r';
                        }
                    } else if (cur == 'D') {
                        if (flag)
                            Dnumber++;
                        if (curBanD == 0) {
                            curBanR++;
                            totalBanR++;
                            if (totalBanR == Rnumber && !flag) return "Dire";
                        } else {
                            curBanD--;
                            chars[i] = 'd';
                        }
                    }
                }
                flag = false;
                if (totalBanD >= Dnumber) return "Radiant";
                if (totalBanR >= Rnumber) return "Dire";
            }
        }
    }
}
