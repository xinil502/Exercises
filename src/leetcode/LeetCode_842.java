package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 */
public class LeetCode_842 {
    class Solution {
        private String s;

        public List<Integer> splitIntoFibonacci(String S) {
            s = S;
            int length = S.length();
            for (int len1 = 1; len1 < length; ++len1) {

                long l1 = Long.valueOf(S.substring(0, len1));
                if (l1 > 2147483647) {
                    break;
                }
                for (int len2 = 1; len1 + len2 <= length; ++len2) {
                    long l2 = Long.valueOf(S.substring(len1, len1 + len2));
                    if (l1 + l2 >= 2147483647) {
                        break;
                    }
                    if (S.substring(len1 + len2).startsWith("" + (l1 + l2))) {
                        if (judge((int) len1, (int) len2)) {
                            return toList((int) len1, (int) len2);
                        }
                    }
                    if (l2 == 0) {
                        break;
                    }
                }
                if (l1 == 0) {
                    break;
                }
            }
            return new ArrayList<Integer>();
        }

        boolean judge(int len1, int len2) {
            String str = s;
            int l1, l2;
            l1 = Integer.valueOf(str.substring(0, len1));
            l2 = Integer.valueOf(str.substring(len1, len1 + len2));
            str = str.substring(len1 + len2);
            while (true) {
                l2 = l1 + l2;
                l1 = l2 - l1;
                String sss = "" + l2;
                if (str.startsWith(sss)) {
                    if (str.equals(sss)) {
                        return true;
                    }
                    str = str.substring(sss.length());
                } else {
                    return false;
                }
            }
        }

        List<Integer> toList(int len1, int len2) {
            int l1, l2, len = s.length();
            l1 = Integer.valueOf(s.substring(0, len1));
            l2 = Integer.valueOf(s.substring(len1, len1 + len2));
            List<Integer> list = new ArrayList<>();
            list.add(l1);
            list.add(l2);
            len -= ("" + l1).length() + ("" + l2).length();
            while (len != 0) {
                l2 = l1 + l2;
                l1 = l2 - l1;
                list.add(l2);
                len -= ("" + l2).length();
            }
            return list;
        }
    }
}
